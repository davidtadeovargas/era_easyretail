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
import com.era.models.Company;
import com.era.models.Consec;
import com.era.models.DocumentOrigin;
import com.era.models.Kits;
import com.era.models.Partvta;
import com.era.models.Sales;
import com.era.repositories.RepositoryFactory;
import com.era.utilities.DialogPropertiesUitlity;
import com.era.utilities.UtilitiesFactory;
import com.era.views.dialogs.DialogsFactory;
import com.era.views.tables.headers.TableHeaderFactory;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Properties;
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
    private DocumentType DocumentType;
    
    
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
        
        this.DocumentType = DocumentType;
        
        switch(DocumentType){
            
            case REMISION:
                break;
                
            case INVOICE:
                break;
        }
    }

        
    public void setSale(Sales Sale) {
        this.Sale = Sale;
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
        
        final Properties Properties = DialogPropertiesUitlity.getSingleton().getProperties();
        
        //If is pay at the moment
        String labelConditionPayment;
        if(NewVtaCustomerInfoDataModel.isContado()){
            labelConditionPayment = Properties.getProperty("sale_pay_at_moment");        }
        else{        
            labelConditionPayment = Properties.getProperty("sale_pay_with_credit");
        }
        
        //Set label for credit or pay at the momento
        jLTipVta.setText(labelConditionPayment);
    }
    
    @Override
    public void clearFields() throws Exception{
        
        //Load default casher customer
        loadCasherCustomer();
    }
    
    @Override
    public void loadModelInFields(Object ObjectModel) throws  Exception {        
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
            
            DialogsFactory.getSingleton().showQuestionContinueDialog(baseJFrame, (JFrame jFrame) -> {
                
                try {
                    
                    final Consec Consec = (Consec)RepositoryFactory.getInstance().getConsecsRepository().getSalesConsec(NewVtaHeaderInfoDataModel.getSerie().getSer());
                    
                    final DocumentOrigin DocumentOrigin = RepositoryFactory.getInstance().getDocumentOriginRepository().getDocumentOriginFAC();
                    
                    //If has to update the customer info
                    if(NewVtaCustomerInfoDataModel.isUpdateCustomer()){
                        RepositoryFactory.getInstance().getCompanysRepository().saveOrUpdateCustomer(NewVtaCustomerInfoDataModel.getCompany());
                    }
                    
                    //Create the sales model
                    final Sales Sales = new Sales();
                    Sales.setCompanyCode(NewVtaCustomerInfoDataModel.getCompany().getCompanyCode());
                    Sales.setRazon(NewVtaCustomerInfoDataModel.getCompany().getNom());
                    Sales.setSubtotal(Totals.getSubtotal());
                    Sales.setTax(Totals.getTaxes());
                    Sales.setTotal(Totals.getTotal());                    
                    Sales.setAccount(NewVtaHeaderInfoDataModel.getAccount());
                    Sales.setReferenceNumber(String.valueOf(Consec.getConsec()));
                    Sales.setSerie(NewVtaHeaderInfoDataModel.getSerie().getCode());
                    Sales.setNoser("");
                    Sales.setCoinCode(NewVtaHeaderInfoDataModel.getCoin().getCode());
                    Sales.setSalesMan(NewVtaHeaderInfoDataModel.getSalesman().getCode());
                    Sales.setPaymentForm(NewVtaHeaderInfoDataModel.getCPaymentForm().getC_FormaPago());
                    Sales.setTypeExchange(new BigDecimal(Float.toString(NewVtaHeaderInfoDataModel.getCoin().getValue())));
                    Sales.setTotalTranslade(BigDecimal.ZERO);
                    Sales.setTotalRetention(BigDecimal.ZERO);
                    Sales.setDocumentType(DocumentOrigin.getType());
                    Sales.setPaymentMethod(NewVtaHeaderInfoDataModel.getMetogoPago().getCode());
                    Sales.setEmisionDate(UtilitiesFactory.getSingleton().getDateTimeUtility().getCurrentDate());
                    Sales.setDeliverDate(UtilitiesFactory.getSingleton().getDateTimeUtility().getCurrentDate());
                    Sales.setTicket(false);
                    Sales.setEstatus(RepositoryFactory.getInstance().getSalessRepository().getConfirmedSaleStatus());
                    Sales.setObservation("");
                    Sales.setSalesPoint(false);
                    
                    //If the user will pay the sale in cash at the moment
                    BigDecimal totalCash = BigDecimal.ZERO;
                    if(NewVtaCustomerInfoDataModel.isContado()){
                        totalCash = new BigDecimal(UtilitiesFactory.getSingleton().getNumbersUtility().fromMoneyFormat(jTTot.getText().trim()));
                        
                        Sales.setCredit(false);
                    }
                    else{
                        Sales.setCredit(true);
                    }
                    
                    //Save the sale
                    RepositoryFactory.getInstance().getSalessRepository().saveSale(Sales, NewVtaCustomerInfoDataModel.getCompany(),NewVtaCustomerInfoDataModel.isUpdateCustomer(), parts,totalCash,BigDecimal.ZERO,BigDecimal.ZERO);
                    
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
            NewVtaHeaderInfoController.setOnResult((NewVtaHeaderInfoDataModel NewVtaHeaderInfoDataModel_) -> {
                
                this.NewVtaHeaderInfoDataModel = NewVtaHeaderInfoDataModel_;
                                
                final String date = this.NewVtaHeaderInfoDataModel.getDate()==null?UtilitiesFactory.getSingleton().getDateTimeUtility().getCurrentDate().toString():this.NewVtaHeaderInfoDataModel.getDate();
                
                //Create the info text
                final String info = "Fecha: " + date + "\n" +
                                    "Forma de pago: " + this.NewVtaHeaderInfoDataModel.getCPaymentForm().getDescription() + "\n" +
                                    "Moneda: " + this.NewVtaHeaderInfoDataModel.getCoin().getDescription() + "\n" +
                                    "Uso CFDI: " + this.NewVtaHeaderInfoDataModel.getCUsoCFDI().getDescription() + "\n" +
                                    "Vendedor: " + this.NewVtaHeaderInfoDataModel.getSalesman().getName() + "\n" + 
                                    "Serie: " + this.NewVtaHeaderInfoDataModel.getSerie().getDescription() + "\n" +
                                    "Observaciones: " + this.NewVtaHeaderInfoDataModel.getObervations() + "\n";
                
                //Set the info
                jTextArea1.setText(info);
            });
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
