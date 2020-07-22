/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.easyretail.controllers.views;

import com.era.datamodels.NewVtaCustomerInfoDataModel;
import com.era.datamodels.enums.SearchCommonTypeEnum;
import com.era.logger.LoggerUtility;
import com.era.models.Company;
import com.era.repositories.RepositoryFactory;
import com.era.utilities.DialogPropertiesUitlity;
import com.era.utilities.UtilitiesFactory;
import com.era.views.NewVtaCustomerInfoJFrame;
import com.era.views.dialogs.DialogsFactory;
import java.math.BigDecimal;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author PC
 */
public class NewVtaCustomerInfoViewController extends NewVtaCustomerInfoJFrame {
    
    private OnResult OnResult;    
    private NewVtaCustomerInfoDataModel NewVtaCustomerInfoDataModel;
    private Company Company;
    
    public NewVtaCustomerInfoViewController() {
        super("window_title_new_vta_info_customer");
        
        try{
            
            jButtonBuscarCliente.addActionListener((java.awt.event.ActionEvent evt) -> {
                jButtonBuscarClienteActionPerformed(evt);
            });
            jBAcept.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBAceptActionPerformed(evt);
            });            
            
            this.disposeButton(jBSal);
            
        }catch (Exception ex) {
            LoggerUtility.getSingleton().logError(NewVtaCustomerInfoViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(NewVtaCustomerInfoViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }

    public void setNewVtaCustomerInfoDataModel(NewVtaCustomerInfoDataModel NewVtaCustomerInfoDataModel) throws Exception {
        
        this.NewVtaCustomerInfoDataModel = NewVtaCustomerInfoDataModel;
        
        this.Company = this.NewVtaCustomerInfoDataModel.getCompany();
        loadModelInFields(NewVtaCustomerInfoDataModel);
    }
    
    public void setOnResult(OnResult OnResult) {
        this.OnResult = OnResult;
    }
    
    private void jBAceptActionPerformed(java.awt.event.ActionEvent evt) {
        
        try {
        
            //If no customer selected
            if(Company==null){
                DialogsFactory.getSingleton().showErrorOKNoSelectionCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                    jTextFieldCliente.grabFocus();
                });
                return;
            }
            
            DialogsFactory.getSingleton().showQuestionContinueDialog(baseJFrame, (JFrame jFrame) -> {
                
                try {
                    
                    //Set flags
                    final boolean contado = jCConta.isSelected();
                    final boolean emal1 = jCCo1.isSelected();
                    final boolean emal2 = jCCo2.isSelected();
                    final boolean emal3 = jCCo3.isSelected();
                    final boolean updateCustomer = jCGDats.isSelected();
                    
                    //Update the company model
                    Company.setCalle(jTextFieldCalle.getText().trim());
                    Company.setCo1(jTCo1.getText().trim());
                    Company.setCo2(jTCo2.getText().trim());
                    Company.setCo3(jTCo3.getText().trim());
                    Company.setCol(jTCol.getText().trim());
                    Company.setTel(jTTel.getText().trim());
                    Company.setCP(jTCP.getText().trim());
                    Company.setNoext(jTNoExt.getText().trim());
                    Company.setNoint(jTNoInt.getText().trim());
                    Company.setRFC(jTRFC.getText().trim());
                    Company.setCiu(jTCiu.getText().trim());
                    Company.setEstad(jTEstad.getText().trim());
                    
                    //Create the response model
                    final NewVtaCustomerInfoDataModel NewVtaCustomerInfoDataModel_ = new NewVtaCustomerInfoDataModel();
                    NewVtaCustomerInfoDataModel_.setCompany(Company);
                    NewVtaCustomerInfoDataModel_.setContado(contado);
                    NewVtaCustomerInfoDataModel_.setEmail1(emal1);
                    NewVtaCustomerInfoDataModel_.setEmail2(emal2);
                    NewVtaCustomerInfoDataModel_.setEmail3(emal3);
                    NewVtaCustomerInfoDataModel_.setUpdateCustomer(updateCustomer);
                    
                    dispose();
                    
                    if(OnResult!=null){
                        OnResult.OnAccept(NewVtaCustomerInfoDataModel_);
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
    
    private void jButtonBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {
        
        try {
            
            //Search warehouse
            final SearchViewController SearchViewController = new SearchViewController();
            SearchViewController.setSEARCH_TYPE(SearchCommonTypeEnum.CUSTOMERS);
            SearchViewController.setButtonAceptClicked(() -> {

                try {
                 
                    final String customerCode = SearchViewController.getCod();

                    //Clear all the fields
                    clearFields();
                    
                    //Get the customer
                    Company = (Company)RepositoryFactory.getInstance().getCompanysRepository().getCustomerByCode(customerCode);
                            
                    //Set all the fields
                    loadModelInFields(Company);
                    
                    //If is the cash customer disable all the fields, the user can not modify this customer
                    if(Company.isCashCustomer()){
                        disableFieldsBecasuseIsCasherCustomer();
                    }
                    else{
                        
                        jTextFieldCalle.setEditable(true);
                        jTCol.setEditable(true);
                        jTTel.setEditable(true);
                        jTCP.setEditable(true);
                        jTNoExt.setEditable(true);
                        jTNoInt.setEditable(true);
                        jTRFC.setEditable(true);
                        jTCiu.setEditable(true);
                        jTEstad.setEditable(true);
                        jTCo1.setEditable(true);
                        jTCo2.setEditable(true);
                        jTCo3.setEditable(true);
                    }
                    
                    //Show conditions
                    showCustomerConditions(Company);
                    
                } catch (Exception ex) {
                    LoggerUtility.getSingleton().logError(this.getClass(), ex);
                    try {
                        DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
                    } catch (Exception ex1) {
                        Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex1);
                    }
                }
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
    
    public void disableFieldsBecasuseIsCasherCustomer(){
        
        jTextFieldCalle.setEditable(false);
        jTCol.setEditable(false);
        jTTel.setEditable(false);
        jTCP.setEditable(false);
        jTNoExt.setEditable(false);
        jTNoInt.setEditable(false);
        jTRFC.setEditable(false);
        jTCiu.setEditable(false);
        jTEstad.setEditable(false);
        jTCo1.setEditable(false);
        jTCo2.setEditable(false);
        jTCo3.setEditable(false);
    }
    
    @Override
    public void loadModelInFields(Object ObjectModel) throws  Exception {
        
        final Company Company_;
        NewVtaCustomerInfoDataModel NewVtaCustomerInfoDataModel_ = null;
        if(ObjectModel instanceof Company){
            Company_ = (Company)ObjectModel;
        }
        else{
            NewVtaCustomerInfoDataModel_ = (NewVtaCustomerInfoDataModel)ObjectModel;
            Company_ = NewVtaCustomerInfoDataModel_.getCompany();
        }
        
        jTextFieldCliente.setText(Company_.getCompanyCode());
        jTextFieldCalle.setText(Company_.getCalle());
        jTCol.setText(Company_.getCol());
        jTTel.setText(Company_.getTel());
        jTPai.setText(Company_.getPai());
        jTCond.setText("");
        jTNom.setText(Company_.getNom());
        jTCP.setText(Company_.getCP());
        jTNoExt.setText(Company_.getNoext());
        jTNoInt.setText(Company_.getNoint());
        jTRFC.setText(Company_.getRFC());
        jTListEmp.setText(String.valueOf(Company_.getList()));
        jTCiu.setText(Company_.getCiu());
        jTEstad.setText(Company_.getEstad());
        jTCo1.setText(Company_.getCo1());
        jTCo2.setText(Company_.getCo2());
        jTCo3.setText(Company_.getCo3());
        
        if(NewVtaCustomerInfoDataModel_!=null){
            jCConta.setSelected(NewVtaCustomerInfoDataModel_.isContado());
            jCCo1.setSelected(NewVtaCustomerInfoDataModel_.isEmail1());
            jCCo2.setSelected(NewVtaCustomerInfoDataModel_.isEmail2());
            jCCo3.setSelected(NewVtaCustomerInfoDataModel_.isEmail3());
            jCGDats.setSelected(NewVtaCustomerInfoDataModel_.isUpdateCustomer());
        }
        
        if(Company_.isCashCustomer()){
            disableFieldsBecasuseIsCasherCustomer();
        }
        
        //Show conditions
        showCustomerConditions(Company_);
    }
    
    private void showCustomerConditions(final Company Company) throws Exception {
                
        //If the user has credit                
        if(Company.hasCredit()){
            jCConta.setEnabled(true);
            jCConta.setSelected(false);
        }
        else{

            jCConta.setSelected(true);
            jCConta.setEnabled(false);
        }
        
        //Get the conditions
        final String conditions = RepositoryFactory.getInstance().getCompanysRepository().getCustomerConditions(Company);
        
        //Set the condtions
        jTCond.setText(conditions);
        
        //Get positive sald of the customer
        final BigDecimal favorSald = RepositoryFactory.getInstance().getCxcRepository().getSaldoFavorFromCustomer(Company.getCompanyCode());
        
        //If the customer doesnt have money credit avaible
        if(favorSald.compareTo(Company.getLimtcred())<0){            
            jCConta.setSelected(true);
            jCConta.setEnabled(false);
        }
    }
    
    @Override
    public void clearFields() throws Exception{
        
        jTextFieldCliente.setText("");
        jTextFieldCalle.setText("");
        jTCol.setText("");
        jTTel.setText("");
        jTPai.setText("");
        jTCond.setText("");
        jTNom.setText("");
        jTCP.setText("");
        jTNoExt.setText("");
        jTNoInt.setText("");
        jTRFC.setText("");
        jTListEmp.setText("");
        jTCiu.setText("");
        jTEstad.setText("");
        jTCo1.setText("");
        jTCo2.setText("");
        jTCo3.setText("");
        
        jCConta.setSelected(false);
        jCCo1.setSelected(true);
        jCCo2.setSelected(false);
        jCCo3.setSelected(false);
        jCGDats.setSelected(false);
        
        NewVtaCustomerInfoDataModel = null;
    }
    
    @Override
    public List<?> getItemsToLoadInTable() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public interface OnResult{
        public void OnAccept(NewVtaCustomerInfoDataModel NewVtaCustomerInfoDataModel_);
    }
}
