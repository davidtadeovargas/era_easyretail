/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.easyretail.controllers.views;

import com.era.datamodels.NewVtaCustomerInfoDataModel;
import com.era.datamodels.NewVtaHeaderInfoDataModel;
import com.era.datamodels.NewVtaProductInfoDataModel;
import com.era.datamodels.TotalsDataModel;
import com.era.datamodels.enums.DocumentType;
import com.era.views.NewVtaJFrame;
import java.util.List;
import com.era.logger.LoggerUtility;
import com.era.models.CPaymentForm;
import com.era.models.CPaymentMethod;
import com.era.models.CUsoCFDI;
import com.era.models.Coin;
import com.era.models.Company;
import com.era.models.Kits;
import com.era.models.Partvta;
import com.era.models.Sales;
import com.era.models.Serie;
import com.era.models.User;
import com.era.repositories.RepositoryFactory;
import com.era.utilities.UtilitiesFactory;
import com.era.views.dialogs.DialogsFactory;
import com.era.views.tables.headers.TableHeaderFactory;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
/**
 *
 * @author PC
 */
public class NewVtaViewController extends NewVtaJFrame {
    
    private Sales Sale;
    private NewVtaCustomerInfoDataModel NewVtaCustomerInfoDataModel;
    private NewVtaProductInfoDataModel NewVtaProductInfoDataModel;
    private NewVtaHeaderInfoDataModel NewVtaHeaderInfoDataModel;
    private TotalsDataModel Totals;    
    private DocumentType DocumentType_;
    
    
    public NewVtaViewController() {
        super("window_title_newvta");
        
        try{
                     
            jBGuar.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBGuarActionPerformed(evt);
            });
            jBSal.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBSalActionPerformed(evt);
            });
            jBNew.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBNewActionPerformed(evt);
            });
            jBCustomer.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBCustomerActionPerformed(evt);
            });
            jBHeader.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBHeaderActionPerformed(evt);
            });
            jBDel.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBDelActionPerformed(evt);
            });
            btnPrevio.addActionListener((java.awt.event.ActionEvent evt) -> {
                btnPrevioActionPerformed(evt);
            });
            
            //Config table
            this.BaseJTable = jTablePartidas;
            jTablePartidas.addShowColumn(TableHeaderFactory.getSigleton().getPartvtasTableHeader().getROWNUMBER());
            jTablePartidas.addShowColumn(TableHeaderFactory.getSigleton().getPartvtasTableHeader().getCANT());
            jTablePartidas.addShowColumn(TableHeaderFactory.getSigleton().getPartvtasTableHeader().getPROD());            
            jTablePartidas.addShowColumn(TableHeaderFactory.getSigleton().getPartvtasTableHeader().getUNID());
            jTablePartidas.addShowColumn(TableHeaderFactory.getSigleton().getPartvtasTableHeader().getDESCRIP());
            jTablePartidas.addShowColumn(TableHeaderFactory.getSigleton().getPartvtasTableHeader().getPRE());
            
            //Init empty table
            final List<Partvta> items = new ArrayList<>();
            jTablePartidas.initTable(items);
            
            //Load default casher customer
            loadCasherCustomer();
            
            setContadoConditions();
                    
        }catch (Exception ex) {
            LoggerUtility.getSingleton().logError(NewVtaViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(NewVtaViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    public void setDocumentType(DocumentType DocumentType) {
        
        this.DocumentType_ = DocumentType;
        
        String content;
        switch(DocumentType_){
            
            case REMISION:                
                content = this.props.getProperty("new_remision_sales");
                break;
                
            case INVOICE:
                content = this.props.getProperty("new_invoice_sales");
                break;
            
            case TICKETS:
                content = this.props.getProperty("new_ticket_sales");
                break;
                    
            default:
                content = this.props.getProperty("new_invoice_sales");
                break;
        }
        
        //Set the content
        jLNot.setText(content);
    }

        
    public void setSale(Sales Sale) throws Exception {
        this.Sale = Sale;
        
        //Load the sale
        loadModelInFields(Sale);
    }

    private void loadCasherCustomer() throws Exception {
        
        //Get the casher customer
        final Company Company = RepositoryFactory.getInstance().getCompanysRepository().getClienteMostrador();
        
        //Create the response model
        NewVtaCustomerInfoDataModel = new NewVtaCustomerInfoDataModel();
        NewVtaCustomerInfoDataModel.setCompany(Company);
        NewVtaCustomerInfoDataModel.setContado(false);
        NewVtaCustomerInfoDataModel.setEmail1(true);
        NewVtaCustomerInfoDataModel.setEmail2(false);
        NewVtaCustomerInfoDataModel.setEmail3(false);
        NewVtaCustomerInfoDataModel.setUpdateCustomer(false);
        
        //Set customer info in fields
        setCustomerInfoInPanel(NewVtaCustomerInfoDataModel);
    }
    
    private void setCustomerInfoInPanel(final NewVtaCustomerInfoDataModel NewVtaCustomerInfoDataModel) throws Exception {
        
        final String name = NewVtaCustomerInfoDataModel.getCompany().getNom();
        final String street = NewVtaCustomerInfoDataModel.getCompany().getCalle()==null?"":NewVtaCustomerInfoDataModel.getCompany().getCalle();
        final String externalNumber = NewVtaCustomerInfoDataModel.getCompany().getNoext()==null?"":NewVtaCustomerInfoDataModel.getCompany().getNoext();
        final String colony = NewVtaCustomerInfoDataModel.getCompany().getCol()==null?"":NewVtaCustomerInfoDataModel.getCompany().getCol();
        final String country = NewVtaCustomerInfoDataModel.getCompany().getPai()==null?"":NewVtaCustomerInfoDataModel.getCompany().getPai();
        final String city = NewVtaCustomerInfoDataModel.getCompany().getCiu()==null?"":NewVtaCustomerInfoDataModel.getCompany().getCiu();
        final String CP = NewVtaCustomerInfoDataModel.getCompany().getCP()==null?"":NewVtaCustomerInfoDataModel.getCompany().getCP();
        final String phone = NewVtaCustomerInfoDataModel.getCompany().getTel()==null?"":NewVtaCustomerInfoDataModel.getCompany().getTel();
        
        jLabelCustomer.setText(name);
        
        if(!NewVtaCustomerInfoDataModel.getCompany().isCashCustomer()){
            jLabelAddress.setText(street + ", Ext: " + externalNumber + ", Col: " + colony);
            jLabelAddress2.setText(country + "," + city + ", CP " + CP);
            jLabelAddress3.setText(phone);
        }
        else{            
            jLabelAddress.setText("");
            jLabelAddress2.setText("");
            jLabelAddress3.setText("");
        }
        
        //If is pay at the moment        
        if(NewVtaCustomerInfoDataModel.isContado()){
            setContadoConditions();
        }
        else{        
            setCreditConditions();
        }
    }
    
    private void setContadoConditions() {
        
        //If is pay at the moment
        String labelConditionPayment = props.getProperty("sale_pay_at_moment");
        jLTipVta.setText(labelConditionPayment);
    }
    
    private void setCreditConditions() {
        
        //If is pay at the moment
        String labelConditionPayment = props.getProperty("sale_pay_with_credit");
        jLTipVta.setText(labelConditionPayment);
    }
    
    @Override
    public void clearFields() throws Exception{
        
        //Load default casher customer
        loadCasherCustomer();
    }
    
    @Override
    public void loadModelInFields(Object ObjectModel) throws  Exception {
        
        //Cast the model
        final Sales Sale_ = (Sales)ObjectModel;
        
        //Get from repositories missing data
        final Serie Serie = RepositoryFactory.getInstance().getSerieRepository().getBySerie(Sale_.getSerie());
        final CPaymentForm CPaymentForm = (CPaymentForm)RepositoryFactory.getInstance().getPaymentFormsRepository().getByCode(Sale_.getPaymentForm());
        final CUsoCFDI CUsoCFDI = (CUsoCFDI)RepositoryFactory.getInstance().getCUsoCFDIsRepository().getByCode(Sale_.getUsocfdi());
        final Coin Coin = (Coin)RepositoryFactory.getInstance().getCoinsRepository().getByCode(Sale_.getCoinCode());
        final CPaymentMethod CPaymentMethod = (CPaymentMethod)RepositoryFactory.getInstance().getCPaymentMethodsRepository().getByCode(Sale_.getPaymentMethod());                
        final User User = (User)RepositoryFactory.getInstance().getUsersRepository().getByCode(Sale_.getSalesMan());
        
        //Create the header model
        final NewVtaHeaderInfoDataModel NewVtaHeaderInfoDataModel_ = new NewVtaHeaderInfoDataModel();
        NewVtaHeaderInfoDataModel_.setSerie(Serie);
        NewVtaHeaderInfoDataModel_.setCPaymentForm(CPaymentForm);
        NewVtaHeaderInfoDataModel_.setCUsoCFDI(CUsoCFDI);
        NewVtaHeaderInfoDataModel_.setCoin(Coin);
        NewVtaHeaderInfoDataModel_.setMetogoPago(CPaymentMethod);
        NewVtaHeaderInfoDataModel_.setAccount(Sale_.getAccount());
        NewVtaHeaderInfoDataModel_.setObervations(Sale_.getObservation());
        NewVtaHeaderInfoDataModel_.setSalesman(User);
        NewVtaHeaderInfoDataModel_.setDate(Sale_.getFalt().toString());
        
        //Set the header info
        setHeaderInfo(NewVtaHeaderInfoDataModel_);
        
        final Company Company = (Company)RepositoryFactory.getInstance().getCompanysRepository().getCustomerByCode(Sale_.getCompanyCode());
        
        //Create the customer model
        final NewVtaCustomerInfoDataModel NewVtaCustomerInfoDataModel_ = new NewVtaCustomerInfoDataModel();
        NewVtaCustomerInfoDataModel_.setCompany(Company);
        NewVtaCustomerInfoDataModel_.setContado(!Sale_.isCredit());
        
        //Set the customer info
        setCustomerInfoInPanel(NewVtaCustomerInfoDataModel_);
        
        //Load the items in the detail table
        final List<Partvta> items = (List<Partvta>)RepositoryFactory.getInstance().getPartvtaRepository().getPartsVta(Sale_.getId());
        jTablePartidas.initTable(items);
        
        //Convert to money the totals
        final String subtotal = UtilitiesFactory.getSingleton().getNumbersUtility().toMoneyFormat(String.valueOf(Sale_.getSubtotal()));
        final String disccount = UtilitiesFactory.getSingleton().getNumbersUtility().toMoneyFormat(String.valueOf(Sale_.getTotalDisccount()));
        final String taxes = UtilitiesFactory.getSingleton().getNumbersUtility().toMoneyFormat(String.valueOf(Sale_.getTax()));
        final String total = UtilitiesFactory.getSingleton().getNumbersUtility().toMoneyFormat(String.valueOf(Sale_.getTotal()));
                
        //Set the totals
        jTSubTot.setText(subtotal);        
        jTTotDesc.setText(disccount);
        campo_impuesto.setText(taxes);
        jTTot.setText(total);
    }
    
    
    private void jBGuarActionPerformed(java.awt.event.ActionEvent evt) {

	try{            	
            
            //First need customer info
            if(NewVtaCustomerInfoDataModel==null){
                DialogsFactory.getSingleton().showErrorOKCallbackDialog(baseJFrame, "errors_customer_info_missing", (JFrame jFrame) -> {
                    jBCustomer.requestFocus();
                });
                return;
            }
            
            //First need header info
            if(NewVtaHeaderInfoDataModel==null){
                DialogsFactory.getSingleton().showErrorOKCallbackDialog(baseJFrame, "errors_sale_info_missing", (JFrame jFrame) -> {
                    jBHeader.requestFocus();
                });
                return;
            }
            
            //Get all parts
            final List<Partvta> parts = (List<Partvta>)jTablePartidas.getAllItemsInTable();
            if(parts.isEmpty()){
                DialogsFactory.getSingleton().showErrorCeroItemsOKDialog(baseJFrame, (JFrame jFrame) -> {
                    jTablePartidas.grabFocus();
                });
                return;
            }
            
            switch(DocumentType_){
                        
                case INVOICE:
                    
                    //Is the customer is not mostrador
                    if(!NewVtaCustomerInfoDataModel.getCompany().isCashCustomer()){

                        //If the customer wants to ring the sale
                        if(NewVtaHeaderInfoDataModel.isRing()){

                            //The customer need to have all the fiscal data
                            if(     NewVtaCustomerInfoDataModel.getCompany().getCalle().isEmpty() || 
                                    NewVtaCustomerInfoDataModel.getCompany().getCol().isEmpty() || 
                                    NewVtaCustomerInfoDataModel.getCompany().getCP().isEmpty() || 
                                    NewVtaCustomerInfoDataModel.getCompany().getNoext().isEmpty() || 
                                    NewVtaCustomerInfoDataModel.getCompany().getRFC().isEmpty() || 
                                    NewVtaCustomerInfoDataModel.getCompany().getCiu().isEmpty() || 
                                    NewVtaCustomerInfoDataModel.getCompany().getEstad().isEmpty()){
                                UtilitiesFactory.getSingleton().getGenericExceptionUtil().generateException("errors_missing_fiscal_info");
                                return;
                            }
                        }
                        
                        //If the user did not select to send the document 
                        if(!NewVtaHeaderInfoDataModel.isSendEmail()){
                            DialogsFactory.getSingleton().showOKCallbackDialog(baseJFrame, "the_document_will_not_be_sent_by_email", (JFrame jFrame) -> {                                
                            });                            
                        }
                    }
                    
                    break;
            }

            DialogsFactory.getSingleton().showQuestionContinueDialog(baseJFrame, (JFrame jFrame) -> {
                
                try {
                    
                    //Create the sales model
                    final Sales Sales = new Sales();
                    Sales.setCompanyCode(NewVtaCustomerInfoDataModel.getCompany().getCompanyCode());
                    Sales.setRazon(NewVtaCustomerInfoDataModel.getCompany().getNom());
                    Sales.setSubtotal(Totals.getSubtotal());
                    Sales.setTax(Totals.getTaxes());
                    Sales.setTotal(Totals.getTotal());                    
                    Sales.setAccount(NewVtaHeaderInfoDataModel.getAccount());
                    Sales.setSerie(NewVtaHeaderInfoDataModel.getSerie().getSer());
                    Sales.setNoser("");
                    Sales.setCoinCode(NewVtaHeaderInfoDataModel.getCoin().getCode());
                    Sales.setSalesMan(NewVtaHeaderInfoDataModel.getSalesman().getCode());
                    Sales.setPaymentForm(NewVtaHeaderInfoDataModel.getCPaymentForm().getC_FormaPago());
                    Sales.setTypeExchange(new BigDecimal(Float.toString(NewVtaHeaderInfoDataModel.getCoin().getValue())));
                    Sales.setTotalTranslade(BigDecimal.ZERO);
                    Sales.setTotalRetention(BigDecimal.ZERO);
                    Sales.setPaymentMethod(NewVtaHeaderInfoDataModel.getMetogoPago().getCode());
                    Sales.setEmisionDate(UtilitiesFactory.getSingleton().getDateTimeUtility().getCurrentDate());
                    Sales.setDeliverDate(UtilitiesFactory.getSingleton().getDateTimeUtility().getCurrentDate());
                    Sales.setUsocfdi(NewVtaHeaderInfoDataModel.getCUsoCFDI().getCode());
                    Sales.setTicket(false);
                    Sales.setEstatus(RepositoryFactory.getInstance().getSalessRepository().getConfirmedSaleStatus());
                    Sales.setObservation("");
                    Sales.setSalesPoint(false);
                    
                    //If the user will pay the sale in cash at the moment
                    BigDecimal totalCash = BigDecimal.ZERO;
                    if(NewVtaCustomerInfoDataModel.isContado()){
                        totalCash = new BigDecimal(UtilitiesFactory.getSingleton().getNumbersUtility().fromMoneyFormat(jTTot.getText().trim()));
                    }
                    
                    switch(DocumentType_){
                        
                        case REMISION:
                            RepositoryFactory.getInstance().getSalessRepository().saveSaleRemision(Sales, NewVtaCustomerInfoDataModel.getCompany(),NewVtaCustomerInfoDataModel.isUpdateCustomer(), parts,totalCash,BigDecimal.ZERO,BigDecimal.ZERO);
                            break;
                            
                        case INVOICE:
                            RepositoryFactory.getInstance().getSalessRepository().saveSaleInvoice(Sales, NewVtaHeaderInfoDataModel.isRing(),NewVtaCustomerInfoDataModel.getCompany(),NewVtaCustomerInfoDataModel.isUpdateCustomer(), parts,totalCash,BigDecimal.ZERO,BigDecimal.ZERO);
                            break;
                            
                        default:
                            RepositoryFactory.getInstance().getSalessRepository().saveSaleInvoice(Sales, NewVtaHeaderInfoDataModel.isRing(), NewVtaCustomerInfoDataModel.getCompany(),NewVtaCustomerInfoDataModel.isUpdateCustomer(), parts,totalCash,BigDecimal.ZERO,BigDecimal.ZERO);
                    }
                    
                    DialogsFactory.getSingleton().showOKOperationCompletedCallbackDialog(baseJFrame, (JFrame jFrame1) -> {
                        dispose();
                    });
                    
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
    
    private void jBSalActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            dispose();
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
    
    private void jBNewActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{
            
            if(NewVtaHeaderInfoDataModel==null){
                DialogsFactory.getSingleton().showErrorOKCallbackDialog(baseJFrame, "errors_sale_info_missing", (JFrame jFrame) -> {
                    jBHeader.requestFocus();
                });
                return;
            }
            
            final NewVtaProductInfoController NewVtaProductInfoController = ViewControlersFactory.getSingleton().getNewVtaProductInfoController();
            NewVtaProductInfoController.setOnResult((NewVtaProductInfoDataModel NewVtaProductInfoDataModel_) -> {
                
                try {
                 
                    this.NewVtaProductInfoDataModel = NewVtaProductInfoDataModel_;

                    //Calculate the imports
                    final BigDecimal import_ = this.NewVtaProductInfoDataModel.getCant().multiply(this.NewVtaProductInfoDataModel.getPrice());

                    //Create table model
                    final Partvta Partvta = new Partvta();
                    Partvta.setAlma(NewVtaProductInfoDataModel.getWarehouse().getCode());
                    Partvta.setMon(NewVtaHeaderInfoDataModel.getCoin().getCode());
                    Partvta.setCant(this.NewVtaProductInfoDataModel.getCant());
                    Partvta.setDescrip(this.NewVtaProductInfoDataModel.getProduct().getDescription());
                    Partvta.setEskit(this.NewVtaProductInfoDataModel.getProduct().getCompound());
                    Partvta.setList(this.NewVtaProductInfoDataModel.getList());
                    Partvta.setPre(this.NewVtaProductInfoDataModel.getPrice());
                    Partvta.setTipcam(BigDecimal.ZERO);
                    Partvta.setUnid(this.NewVtaProductInfoDataModel.getUnid().getCode());
                    Partvta.setImpo(import_);
                    Partvta.setImpue(0);
                    Partvta.setProd(this.NewVtaProductInfoDataModel.getProduct().getCode());                
                    BigDecimal disccount = new BigDecimal(this.NewVtaProductInfoDataModel.getDisccount(), MathContext.DECIMAL64);
                    Partvta.setDescu(disccount);
                    Partvta.setInventory(true);

                    jTablePartidas.addObject(Partvta);

                    //Recalc totals                    
                    Totals = calculateTotals();                        

                    //Fill the totals
                    fillTotals(Totals);
                    
                } catch (Exception ex) {
                    LoggerUtility.getSingleton().logError(this.getClass(), ex);
                    try {
                        DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
                    } catch (Exception ex1) {
                        Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex1);
                    }
                }
            });
            NewVtaProductInfoController.setVisible();
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
    
    private void jBCustomerActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            final NewVtaCustomerInfoViewController NewVtaCustomerInfoViewController = ViewControlersFactory.getSingleton().getNewVtaCustomerInfoViewController();
            NewVtaCustomerInfoViewController.setOnResult((NewVtaCustomerInfoDataModel NewVtaCustomerInfoDataModel_) -> {
                
                try {
                    
                    NewVtaCustomerInfoDataModel = NewVtaCustomerInfoDataModel_;

                    //Set customer info in fields
                    setCustomerInfoInPanel(NewVtaCustomerInfoDataModel);
                    
                } catch (Exception ex) {
                    LoggerUtility.getSingleton().logError(this.getClass(), ex);
                    try {
                        DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
                    } catch (Exception ex1) {
                        Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex1);
                    }
                }
            });
            if(NewVtaCustomerInfoDataModel!=null){
                NewVtaCustomerInfoViewController.setNewVtaCustomerInfoDataModel(NewVtaCustomerInfoDataModel);
            }                
            NewVtaCustomerInfoViewController.setVisible();
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
    
    private void jBHeaderActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
            final NewVtaHeaderInfoController NewVtaHeaderInfoController = ViewControlersFactory.getSingleton().getNewVtaHeaderInfoController();
            if(NewVtaHeaderInfoDataModel!=null){
                NewVtaHeaderInfoController.setNewVtaHeaderInfoDataModel(NewVtaHeaderInfoDataModel);
            }
            else{
                NewVtaHeaderInfoController.setCompany(NewVtaCustomerInfoDataModel.getCompany());
            }            
            NewVtaHeaderInfoController.setOnResult((NewVtaHeaderInfoDataModel NewVtaHeaderInfoDataModel_) -> {
                
                this.NewVtaHeaderInfoDataModel = NewVtaHeaderInfoDataModel_;
                              
                //Set the header info
                setHeaderInfo(NewVtaHeaderInfoDataModel);
            });
            NewVtaHeaderInfoController.setDocumentType_(DocumentType_);
            NewVtaHeaderInfoController.setVisible();
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
    
    private void setHeaderInfo(final NewVtaHeaderInfoDataModel NewVtaHeaderInfoDataModel){
        
        final String date = NewVtaHeaderInfoDataModel.getDate()==null?UtilitiesFactory.getSingleton().getDateTimeUtility().getCurrentDate().toString():NewVtaHeaderInfoDataModel.getDate();
        final String usoCFDI = NewVtaHeaderInfoDataModel.getCUsoCFDI()==null?"":NewVtaHeaderInfoDataModel.getCUsoCFDI().getDescription();
        
        //Create the info text
        final String info = "Fecha: " + date + "\n" +
                            "Forma de pago: " + NewVtaHeaderInfoDataModel.getMetogoPago().getDescription() + "\n" +
                            "Moneda: " + NewVtaHeaderInfoDataModel.getCoin().getDescription() + ", " + NewVtaHeaderInfoDataModel.getCoin().getCode() + "\n" +
                            "Uso CFDI: " + usoCFDI + "\n" +
                            "Vendedor: " + NewVtaHeaderInfoDataModel.getSalesman().getName() + "\n" + 
                            "Serie: " + NewVtaHeaderInfoDataModel.getSerie().getDescription() + "\n" +
                            "Observaciones: " + NewVtaHeaderInfoDataModel.getObervations() + "\n";

        //Set the info
        jTextArea1.setText(info);
    }
    
    private void jBDelActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
    
            //First select in table
            if(!jTablePartidas.isRowSelected()){
                DialogsFactory.getSingleton().showErrorOKNoSelectionCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                    jTablePartidas.grabFocus();
                });
                return;
            }
            
            DialogsFactory.getSingleton().showQuestionContinueDialog(baseJFrame, (JFrame jFrame) -> {
                
                try {                    
                    
                    //Get selected object
                    final Partvta Partvta = (Partvta)jTablePartidas.getRowSelected();
                    
                    //Remove the object from the table
                    jTablePartidas.deleteObject(Partvta);
                    
                    //Recalc totals                    
                    Totals = calculateTotals();                        
            
                    //Fill the totals
                    fillTotals(Totals);
                    
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
    
    private void fillTotals(final TotalsDataModel Totals) throws Exception {
        
        //Place in fields
        jTSubTot.setText(UtilitiesFactory.getSingleton().getNumbersUtility().toMoneyFormat(String.valueOf(Totals.getSubtotal().doubleValue())));
        campo_impuesto.setText(UtilitiesFactory.getSingleton().getNumbersUtility().toMoneyFormat(String.valueOf(Totals.getTaxes().doubleValue())));
        jTTot.setText(UtilitiesFactory.getSingleton().getNumbersUtility().toMoneyFormat(String.valueOf(Totals.getTotal().doubleValue())));
        jTTotDesc.setText(UtilitiesFactory.getSingleton().getNumbersUtility().toMoneyFormat(String.valueOf(Totals.getDisccount().doubleValue())));
    }
    
    private TotalsDataModel calculateTotals() throws Exception {
        
        //Get all table items
        final List<Partvta> items = (List<Partvta>)jTablePartidas.getAllItemsInTable();

        //Contains the total
        BigDecimal taxes = BigDecimal.ZERO;
        BigDecimal total = BigDecimal.ZERO;
        BigDecimal subtotal = BigDecimal.ZERO;
        BigDecimal cant = BigDecimal.ZERO;
        BigDecimal disccountTotal = BigDecimal.ZERO;
        
        //Loop to calculate totals
        for(Partvta Partvta:items){

            //Get the price
            final BigDecimal price = Partvta.getPre();

            //Get amount
            final BigDecimal qty = Partvta.getCant();
            
            //Calculate the import
            BigDecimal import_ = price.multiply(qty);

            //Get the disccount
            final BigDecimal descu = Partvta.getDescu();
            final BigDecimal descuTot = descu.divide(new BigDecimal(100, MathContext.DECIMAL64));
            
            //Get the disccount                        
            BigDecimal totalDisccount = descuTot.multiply(import_);

            disccountTotal = disccountTotal.add(totalDisccount);
            
            //Remove the disccount
            import_ = import_.subtract(totalDisccount);
            
            //Continue adding the subtotal
            subtotal = subtotal.add(import_);

            //Continue adding the quantity
            cant = cant.add(qty);
            
            //If the product is kit
            if(Partvta.isEskit()){
                
                //Get all the components of the product
                final List<Kits> kits = RepositoryFactory.getInstance().getKitssRepository().getComponentsByKit(Partvta.getProd());
                
                for(Kits Kit: kits){
                    taxes = taxes.add(RepositoryFactory.getInstance().getProductsRepository().getTotalTaxesOfProduct(Kit.getProd(), import_));
                }
            }
            else{
                taxes = taxes.add(RepositoryFactory.getInstance().getProductsRepository().getTotalTaxesOfProduct(Partvta.getProd(), import_));
            }
        }

        //Create the total
        total = total.add(subtotal.add(taxes));

        //Create the model
        final TotalsDataModel Totals_ = new TotalsDataModel();
        Totals_.setTaxes(taxes);
        Totals_.setDisccount(disccountTotal);
        Totals_.setSubtotal(subtotal);
        Totals_.setTotal(total);
        Totals_.setCant(cant);

        return Totals_;
    }
    
    private void btnPrevioActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
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
    
    @Override
    public List<?> getItemsToLoadInTable() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }        
}
