/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.easyretail.controllers.views;

import com.era.datamodels.NewVtaHeaderInfoDataModel;
import com.era.datamodels.enums.DocumentType;
import com.era.datamodels.enums.SearchCommonTypeEnum;
import com.era.logger.LoggerUtility;
import com.era.models.CPaymentForm;
import com.era.models.CUsoCFDI;
import com.era.models.Coin;
import com.era.models.MetogoPago;
import com.era.models.Serie;
import com.era.models.User;
import com.era.repositories.RepositoryFactory;
import com.era.utilities.UtilitiesFactory;
import com.era.views.NewVtaHeaderInfoJFrame;
import com.era.views.comboboxes.SeriesCombobox;
import com.era.views.dialogs.DialogsFactory;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author PC
 */
public class NewVtaHeaderInfoController extends NewVtaHeaderInfoJFrame {
    
    private NewVtaHeaderInfoDataModel NewVtaHeaderInfoDataModel;
    private OnResult OnResult;
    private DocumentType DocumentType_;    
    
    public NewVtaHeaderInfoController() {
        super("window_title_new_vta_info_header");
        
        try{
                     
            jBSal.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBSalActionPerformed(evt);
            });
            jBAcept.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBAceptActionPerformed(evt);
            });
            jButton1.addActionListener((java.awt.event.ActionEvent evt) -> {
                jButton1ActionPerformed(evt);
            });
            
            jComboBoxSerie.grabFocus();
            
            jComboboxMonedas.loadItems();
            jComboBoxFormaPago.loadItems();
            jUsoCFDI.loadItems();
            jComboBoxMetodoPago.loadItems();                        
            
            //Set the current user
            final User User = UtilitiesFactory.getSingleton().getSessionUtility().getUser();
            jTextFieldVendedor.setText(User.getCode());                        
            
            //Select national coin
            final Coin Coin = RepositoryFactory.getInstance().getCoinsRepository().getNationalCoin();
            jComboboxMonedas.selectByObject(Coin);
            
            //Select the first payment method
            final MetogoPago MetodoPago = (MetogoPago)RepositoryFactory.getInstance().getMetogoPagosRepository().getFirst();
            jComboBoxMetodoPago.selectByObject(MetodoPago);
            
            //Select cash option
            final CPaymentForm CPaymentForm = RepositoryFactory.getInstance().getPaymentFormsRepository().getByCash();            
            jComboBoxFormaPago.selectByObject(CPaymentForm);
            
            //Select uso cfdi
            final CUsoCFDI CUsoCFDI = (CUsoCFDI)RepositoryFactory.getInstance().getCUsoCFDIsRepository().getFirst();            
            jUsoCFDI.selectByObject(CUsoCFDI);
            
            //Set the current date
            JTFecha.setText(UtilitiesFactory.getSingleton().getDateTimeUtility().getCurrentDateWithoutHour());
                        
            //Set the expedition place from the company
            txtLugarExped.setText(UtilitiesFactory.getSingleton().getSessionUtility().getBasDats().getLugexp());
            
        }catch (Exception ex) {
            LoggerUtility.getSingleton().logError(NewVtaHeaderInfoController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(NewVtaHeaderInfoController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        
    }

    public void setCUsoCFDI(CUsoCFDI CUsoCFDI) throws Exception {
        
        //Select in the combo
        if(CUsoCFDI!=null){
            jUsoCFDI.selectByObject(CUsoCFDI);
        }        
    }
    
    public void setDocumentType_(DocumentType DocumentType_) throws Exception {
        this.DocumentType_ = DocumentType_;
                
        Serie Serie;
        switch(DocumentType_){
            
            case REMISION:                
                jComboBoxSerie.setType(SeriesCombobox.Type.REM);
                Serie = RepositoryFactory.getInstance().getSerieRepository().getFirstSerieREM();
                break;
                
            case INVOICE:
                jComboBoxSerie.setType(SeriesCombobox.Type.FAC);
                Serie = RepositoryFactory.getInstance().getSerieRepository().getFirstSerieFAC();
                break;
                
            default:
                Serie = RepositoryFactory.getInstance().getSerieRepository().getFirstSerieFAC();
                jComboBoxSerie.setType(SeriesCombobox.Type.FAC);                
        }
                
        //Load items in the combobox
        jComboBoxSerie.loadItems();
        
        //Select the sales serie
        jComboBoxSerie.selectByObject(Serie);
    }        

    public void setOnResult(OnResult OnResult) {
        this.OnResult = OnResult;
    }        
    
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {

        try {
            
            final SearchViewController SearchViewController = new SearchViewController();
            SearchViewController.setSEARCH_TYPE(SearchCommonTypeEnum.EXPEDITION_PLACE);
            SearchViewController.setButtonAceptClicked(() -> {
                final String fiscalRegimen = SearchViewController.getCod();                
                txtLugarExped.setText(fiscalRegimen);
            });
            SearchViewController.setVisible();
            
        } catch (Exception ex) {
            LoggerUtility.getSingleton().logError(this.getClass(), ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    private void jBAceptActionPerformed(java.awt.event.ActionEvent evt) {
        
        try {
            
            //First select
            final Serie Serie = (Serie)jComboBoxSerie.getSelectedObject();
            if(Serie.getCode()==null){
                DialogsFactory.getSingleton().showErrorOKNoSelectionCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                    jComboBoxSerie.grabFocus();
                });
                return;
            }
                        
            //First select
            final MetogoPago MetogoPago = (MetogoPago)jComboBoxMetodoPago.getSelectedObject();
            if(MetogoPago.getDescription()==null){
                DialogsFactory.getSingleton().showErrorOKNoSelectionCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                    jComboBoxMetodoPago.grabFocus();
                });
                return;
            }
            
            //First select
            final CUsoCFDI CUsoCFDI = (CUsoCFDI)jUsoCFDI.getSelectedObject();
            if(CUsoCFDI.getCode()==null){
                DialogsFactory.getSingleton().showErrorOKNoSelectionCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                    jUsoCFDI.grabFocus();
                });
                return;
            }
            
            //First select
            final Coin Coin = (Coin)jComboboxMonedas.getSelectedObject();
            if(Coin.getDescription()==null){
                DialogsFactory.getSingleton().showErrorOKNoSelectionCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                    jComboboxMonedas.grabFocus();
                });
                return;
            }
            
            //First select
            final CPaymentForm CPaymentForm = (CPaymentForm)jComboBoxFormaPago.getSelectedObject();
            if(CPaymentForm.getC_FormaPago()==null){
                DialogsFactory.getSingleton().showErrorOKNoSelectionCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                    jComboBoxFormaPago.grabFocus();
                });
                return;
            }
            
            //First select
            final String salesManCode = jTextFieldVendedor.getText().trim();
            if(salesManCode.isEmpty()){
                DialogsFactory.getSingleton().showOKEmptyFieldCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                    jTextFieldVendedor.grabFocus();
                });
                return;
            }
            
            //Get the user
            final User User = (User)RepositoryFactory.getInstance().getUsersRepository().getByCode(salesManCode);
            if(User==null){
                DialogsFactory.getSingleton().showErrorOKRecordNotExistsCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                    jTextFieldVendedor.grabFocus();
                });
                return;
            }
                    
            DialogsFactory.getSingleton().showQuestionContinueDialog(baseJFrame, (JFrame jFrame) -> {
                
                try {
                    
                    //Get other fields
                    final String account = jTCta.getText().trim();
                    final String expeditionPlace = txtLugarExped.getText().trim();
                    final String observations = jTAObserv.getText().trim();
                    final boolean ring = jCheckboxTimbrar.isSelected();
                    final boolean sendEmail = jCMand.isSelected();
                    final boolean showFile = jCMostA.isSelected();
                    final boolean cartaPorte = jCCartaP.isSelected();
                    final boolean print = jCImp.isSelected();                    
                    
                    //Create the model
                    final NewVtaHeaderInfoDataModel NewVtaHeaderInfoDataModel_ = new NewVtaHeaderInfoDataModel();
                    NewVtaHeaderInfoDataModel_.setSerie(Serie);
                    NewVtaHeaderInfoDataModel_.setCPaymentForm(CPaymentForm);
                    NewVtaHeaderInfoDataModel_.setCUsoCFDI(CUsoCFDI);
                    NewVtaHeaderInfoDataModel_.setCoin(Coin);
                    NewVtaHeaderInfoDataModel_.setMetogoPago(MetogoPago);
                    NewVtaHeaderInfoDataModel_.setSalesman(User);
                    NewVtaHeaderInfoDataModel_.setAccount(account);
                    NewVtaHeaderInfoDataModel_.setObervations(observations);
                    NewVtaHeaderInfoDataModel_.setRing(ring);
                    NewVtaHeaderInfoDataModel_.setSendEmail(sendEmail);
                    NewVtaHeaderInfoDataModel_.setShowFile(showFile);
                    NewVtaHeaderInfoDataModel_.setCartaPorte(cartaPorte);
                    NewVtaHeaderInfoDataModel_.setPrint(print);
                    NewVtaHeaderInfoDataModel_.setExpeditionPlace(expeditionPlace);
                    
                    dispose();
                    
                    //Callback
                    if(OnResult!=null){
                        OnResult.onResult(NewVtaHeaderInfoDataModel_);
                    }
                    
                } catch (Exception ex) {
                    LoggerUtility.getSingleton().logError(this.getClass(), ex);
                    try {
                        DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
                    } catch (Exception ex1) {
                        Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex1);
                    }
                }
            });
            
        } catch (Exception ex) {
            LoggerUtility.getSingleton().logError(this.getClass(), ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    private void jBSalActionPerformed(java.awt.event.ActionEvent evt) {

	try{            	
            
            DialogsFactory.getSingleton().showQuestionContinueDialog(baseJFrame, (JFrame jFrame) -> {
                
                try {
                    
                    dispose();
                    
                } catch (Exception ex) {
                    LoggerUtility.getSingleton().logError(this.getClass(), ex);
                    try {
                        DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
                    } catch (Exception ex1) {
                        Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex1);
                    }
                }
            });
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(this.getClass(), ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }

    public void setNewVtaHeaderInfoDataModel(NewVtaHeaderInfoDataModel NewVtaHeaderInfoDataModel) throws Exception {
        this.NewVtaHeaderInfoDataModel = NewVtaHeaderInfoDataModel;
        
        loadModelInFields(this.NewVtaHeaderInfoDataModel);
    }        
    
    @Override
    public void loadModelInFields(Object ObjectModel) throws  Exception {
        
        //Cast the model
        final NewVtaHeaderInfoDataModel NewVtaHeaderInfoDataModel_ = (NewVtaHeaderInfoDataModel)ObjectModel;
        
        //Select fields
        jComboBoxSerie.selectByObject(NewVtaHeaderInfoDataModel_.getSerie());
        jComboBoxFormaPago.selectByObject(NewVtaHeaderInfoDataModel_.getCPaymentForm());
        jUsoCFDI.selectByObject(NewVtaHeaderInfoDataModel_.getCUsoCFDI());
        jComboboxMonedas.selectByObject(NewVtaHeaderInfoDataModel_.getCoin());
        jComboBoxMetodoPago.selectByObject(NewVtaHeaderInfoDataModel_.getMetogoPago());
        
        jTCta.setText(NewVtaHeaderInfoDataModel_.getAccount());
        jTextFieldVendedor.setText(NewVtaHeaderInfoDataModel_.getSalesman().getCode());
        jTextFieldVendedor.setText(NewVtaHeaderInfoDataModel_.getSalesman().getCode());
        JTFecha.setText(NewVtaHeaderInfoDataModel_.getDate());
        jTTipoRelacion.setText("");
        jTAObserv.setText(NewVtaHeaderInfoDataModel_.getObervations());
        
        jCheckboxTimbrar.setSelected(NewVtaHeaderInfoDataModel_.isRing());
        jCMand.setSelected(NewVtaHeaderInfoDataModel_.isSendEmail());
        jCMostA.setSelected(NewVtaHeaderInfoDataModel_.isShowFile());
        jCCartaP.setSelected(NewVtaHeaderInfoDataModel_.isCartaPorte());
        jCImp.setSelected(NewVtaHeaderInfoDataModel_.isPrint());
        
        txtLugarExped.setText(NewVtaHeaderInfoDataModel_.getExpeditionPlace());
    }
    
    @Override
    public void clearFields() throws Exception{            
    }
    
    @Override
    public List<?> getItemsToLoadInTable() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public interface OnResult{
        public void onResult(NewVtaHeaderInfoDataModel NewVtaHeaderInfoDataModel);
    }
}
