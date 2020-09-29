/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.easyretail.controllers.views;

import com.era.datamodels.enums.DocumentType;
import com.era.easyretail.era_jasperreports.FacReportGenerator;
import com.era.easyretail.era_jasperreports.ReportsManager;
import com.era.easyretail.era_jasperreports.TicketReportGenerator;
import com.era.easyretail.era_jasperreports.models.FacReportModel;
import com.era.easyretail.era_jasperreports.models.GenerateProperties;
import com.era.easyretail.era_jasperreports.models.TicketReportModel;
import com.era.easyretail.exceptions.InternalUnexpectedErrorException;
import com.era.views.CobroJFrame;
import java.util.List;
import com.era.logger.LoggerUtility;
import com.era.models.Coin;
import com.era.models.Company;
import com.era.models.Confgral;
import com.era.models.ImpuesXProduct;
import com.era.models.Partvta;
import com.era.models.Product;
import com.era.models.Sales;
import com.era.models.User;
import com.era.repositories.RepositoryFactory;
import com.era.utilities.UtilitiesFactory;
import com.era.views.dialogs.DialogsFactory;
import com.era.views.utils.JComponentUtils;
import java.awt.event.FocusEvent;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
/**
 *
 * @author PC
 */
public class CobroViewController extends CobroJFrame {
            
    private Sales Sale;
    private List<Partvta> partvtas;
    private OnFinish OnFinish;    
    private Company Company;
            
    public CobroViewController() {
        super("window_title_cobro");
        
        try{
            
            ButtonGroup g = new ButtonGroup();
            g.add(jRTic);
            g.add(jRRem);
            g.add(jRFac);

            ButtonGroup creditOrCashRadioG = new ButtonGroup();
            creditOrCashRadioG.add(jRadioButtonCredit);
            creditOrCashRadioG.add(jRadioButtonCash);
        
            this.JComponentUtils.onRadioButtonChangeListener(jRadioButtonCredit, new JComponentUtils.OnRadioButtonChange(){

                @Override
                public void onChecked() {
                    try {
                        creditPayment();
                    } catch (Exception ex) {
                        LoggerUtility.getSingleton().logError(this.getClass(), ex);
                        try {
                            DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
                        } catch (Exception ex1) {
                            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex1);
                        }
                    }
                }

                @Override
                public void onUncheked() {
                    try {
                        atmomentPayment();
                    } catch (Exception ex) {
                        LoggerUtility.getSingleton().logError(this.getClass(), ex);
                        try {
                            DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
                        } catch (Exception ex1) {
                            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex1);
                        }
                    }                    
                }
                
            });
            
            this.getRootPane().setDefaultButton(jBCob);
        
            jTEfeCant.grabFocus();

            jTSald.setText("$0.00");
            jTCamb.setText("$0.00");

            jBSal.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBSalActionPerformed(evt);
            });
            jBCob.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBCobActionPerformed(evt);
            });
            
            JComponentUtils.setALT_TEvent(() -> {
                jRTic.setSelected(true);
            });
            JComponentUtils.setALT_FEvent(() -> {
                jRFac.setSelected(true);
            });
            JComponentUtils.setALT_REvent(() -> {
                jRRem.setSelected(true);
            });
            
            this.JComponentUtils.moneyFormat(jTEfeCant);
            this.JComponentUtils.moneyFormat(jTDebCant);
            this.JComponentUtils.moneyFormat(jTTarCredCant);
            
            this.JComponentUtils.addFocusLost(jTEfeCant, (FocusEvent e) -> {
                try {
                    
                    //Calculate totals
                    calculateTotals();
        
                } catch (Exception ex) {
                    LoggerUtility.getSingleton().logError(this.getClass(), ex);
                    try {
                        DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
                    } catch (Exception ex1) {
                        Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex1);
                    }
                }
            });
            this.JComponentUtils.addFocusLost(jTDebCant, (FocusEvent e) -> {
                try {
                    
                    //Calculate totals
                    calculateTotals();
        
                } catch (Exception ex) {
                    LoggerUtility.getSingleton().logError(this.getClass(), ex);
                    try {
                        DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
                    } catch (Exception ex1) {
                        Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex1);
                    }
                }
            });
            this.JComponentUtils.addFocusLost(jTTarCredCant, (FocusEvent e) -> {
                try {
                    
                    //Calculate totals
                    calculateTotals();
        
                } catch (Exception ex) {
                    LoggerUtility.getSingleton().logError(this.getClass(), ex);
                    try {
                        DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
                    } catch (Exception ex1) {
                        Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex1);
                    }
                }
            });
            
        }catch (Exception ex) {
            LoggerUtility.getSingleton().logError(CobroViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(CobroViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }

    public void setOnFinish(OnFinish OnFinish) {
        this.OnFinish = OnFinish;
    }        
    
    public void init(final Sales Sale, final Company Company, final List<Partvta> partvtas) throws Exception {
        
        //Save globally
        this.Sale = Sale;
        this.Company = Company;
        this.partvtas = partvtas;
        
        //Set the cash
        jTEfeCant.setText(UtilitiesFactory.getSingleton().getNumbersUtility().toMoneyFormat(String.valueOf(Sale.getTotal().doubleValue())));
        jTTot.setText(UtilitiesFactory.getSingleton().getNumbersUtility().toMoneyFormat(String.valueOf(Sale.getTotal().doubleValue())));
        
        //If the customer has credit        
        if(this.Company.hasCredit()){
            
            //If the customer has saldo a favor
            final BigDecimal saldoFavor = RepositoryFactory.getInstance().getCxcRepository().getSaldoFavorFromCustomer(this.Company.getCompanyCode());
            if(saldoFavor.compareTo(BigDecimal.ZERO)>0){                
                creditPayment();
            }
        }
        else{
            jRadioButtonCredit.setEnabled(false);
            
            //Pat at the moment
            atmomentPayment();
        }
    }
    
    private void creditPayment() throws Exception{
        
        //Select radio to credit
        jRadioButtonCredit.setSelected(true);
        jRadioButtonCredit.setEnabled(true);

        //Disable at moment payment
        jTEfeCant.setEnabled(false);
        jTDebCant.setEnabled(false);
        jTTarCredCant.setEnabled(false);                
        jTEfeCant.setText("$0.00");
        jTDebCant.setText("$0.00");
        jTTarCredCant.setText("$0.00");        
        
        calculateTotals();
        
        jTSald.setText("$0.00");
    }
    
    private void atmomentPayment() throws Exception{
        
        //Select radio to credit
        jRadioButtonCash.setSelected(true);

        //Enable at moment payment
        jTEfeCant.setEnabled(true);
        jTDebCant.setEnabled(true);
        jTTarCredCant.setEnabled(true);
        
        jTEfeCant.setText(UtilitiesFactory.getSingleton().getNumbersUtility().toMoneyFormat(String.valueOf(Sale.getTotal())));
        jTSald.setText("$0.00");
        
        calculateTotals();
    }
    
    private void calculateTotals() throws Exception {
        
        //Get the total in cash
        final BigDecimal cash = new BigDecimal(Double.valueOf(UtilitiesFactory.getSingleton().getNumbersUtility().fromMoneyFormat(jTEfeCant.getText().trim())), MathContext.DECIMAL64);
        
        //Get the total in debit
        final BigDecimal debit = new BigDecimal(Double.valueOf(UtilitiesFactory.getSingleton().getNumbersUtility().fromMoneyFormat(jTDebCant.getText().trim())), MathContext.DECIMAL64);
                
        //Get the total in card
        final BigDecimal card = new BigDecimal(Double.valueOf(UtilitiesFactory.getSingleton().getNumbersUtility().fromMoneyFormat(jTTarCredCant.getText().trim())), MathContext.DECIMAL64);
        
        //Get the total to pay
        final BigDecimal total = cash.add(debit).add(card);
        
        //Get the diference        
        BigDecimal difference = new BigDecimal(Sale.getTotal().doubleValue(), MathContext.DECIMAL64).subtract(total);
        if(difference.compareTo(BigDecimal.ZERO)<0){
            difference = BigDecimal.ZERO;
        }
        
        //Set the sald
        jTSald.setText(UtilitiesFactory.getSingleton().getNumbersUtility().toMoneyFormat(String.valueOf(difference.doubleValue())));
        
        //Set the exchange
        BigDecimal exchange = cash.subtract(new BigDecimal(Sale.getTotal().doubleValue(), MathContext.DECIMAL64));
        if(exchange.compareTo(BigDecimal.ZERO)<0){
            exchange = BigDecimal.ZERO;
        }
        jTCamb.setText(UtilitiesFactory.getSingleton().getNumbersUtility().toMoneyFormat(String.valueOf(exchange.doubleValue())));
    }
    
    @Override
    public void clearFields() throws Exception{
        
        jRTic.setSelected(true);
        jTAObserv.setText("");
        
        jTEfeCant.setText("$0.00");
        jTDebCant.setText("$0.00");
        jTTarCredCant.setText("$0.00");
        jTSald.setText("$0.00");
        jTCamb.setText("$0.00");
    }
    
    @Override
    public void loadModelInFields(Object ObjectModel) throws  Exception {        
    }
    
    private void charge() throws Exception {
        
        final BigDecimal sald = new BigDecimal(Double.valueOf(UtilitiesFactory.getSingleton().getNumbersUtility().fromMoneyFormat(jTSald.getText().trim())), MathContext.DECIMAL64);

        //If there is pending amount stop
        if(sald.compareTo(BigDecimal.ZERO)!=0){
            DialogsFactory.getSingleton().showErrorOKCallbackDialog(baseJFrame, "errors_pending_ammount", (JFrame jFrame) -> {
                jTEfeCant.grabFocus();
            });
            return;
        }
        
        //If there is not ticket printer configured show message to the user
        if(!UtilitiesFactory.getSingleton().getPrintersUtility().userTicketPrinterExists()){
            DialogsFactory.getSingleton().showOKDialog(baseJFrame, "printer_ticket_not_configured");
        }

        //Determine the type of document operation to validate pre actualization
        if(jRTic.isSelected()){
            prevalidateTicket();
        }
        else if(jRRem.isSelected()){
            prevalidateRemision();
        }
        else if(jRFac.isSelected()){
            prevalidateInvoice();
        }

        //Get national coin
        final Coin Coin = (Coin)RepositoryFactory.getInstance().getCoinsRepository().getNationalCoin();

        String serie = "";        
        boolean ticket = false;
        String estatus = "";
        DocumentType DocumentType_ = null;
        if(jRTic.isSelected()){

            //Get the serie
            final Confgral Confgral = RepositoryFactory.getInstance().getConfgralRepository().getSerieTickInPointOfSale();
            serie = Confgral.getExtr();

            DocumentType_ = DocumentType.TICKETS;

            ticket = true;

            estatus = "CO";
        }
        else if(jRRem.isSelected()){

            //Get the serie
            final Confgral Confgral = RepositoryFactory.getInstance().getConfgralRepository().getSerieRemisionsInPointOfSale();
            serie = Confgral.getExtr();

            DocumentType_ = DocumentType.REMISION;

            ticket = false;
            
            estatus = "CO";
        }
        else if(jRFac.isSelected()){

            //Get the serie
            final Confgral Confgral = RepositoryFactory.getInstance().getConfgralRepository().getSerieInvoiceInPointOfSale();
            serie = Confgral.getExtr();

            DocumentType_ = DocumentType.INVOICE;

            ticket = false;
            
            estatus = "CO";
        }

        if(DocumentType_==null){
            UtilitiesFactory.getSingleton().getGenericExceptionUtil().generateException("errors_exception_generic_type_of_sale_not_found");
            return;
        }
        if(serie.isEmpty()){
            throw new InternalUnexpectedErrorException("serie");
        }
        if(estatus==null){
            throw new InternalUnexpectedErrorException("estatus");
        }            

        //Get the customer
        final Company Company_ = (Company)RepositoryFactory.getInstance().getCompanysRepository().getByCod(Sale.getCompanyCode());

        //Contains the taxes of all the items
        BigDecimal total_retencion = BigDecimal.ZERO;
        BigDecimal total_traslado = BigDecimal.ZERO;

        //Iterate all the item products            
        for(Partvta Partvta:partvtas){

            //Get the product
            final Product Product = (Product)RepositoryFactory.getInstance().getProductsRepository().getByCode(Partvta.getProd());

            //Get the taxes of the product
            final List<ImpuesXProduct> impuesXProduct = RepositoryFactory.getInstance().getImpuesXProductRepository().getAllByProd(Product.getCode());

            //Get the total of taxes
            /*for(ImpuesXProduct ImpuesXProduct:impuesXProduct){
                final String codeImpue = ImpuesXProduct.getImpue();
                final Tax Tax = (Tax)RepositoryFactory.getInstance().getTaxesRepository().getByCode(codeImpue);
                total_retencion = total_retencion.add(new BigDecimal(Tax.getValue(), MathContext.DECIMAL64));
                total_traslado = total_traslado.add(value);
            }*/
        }

        //Get the sales man
        final User User = UtilitiesFactory.getSingleton().getSessionUtility().getUser();

        //Get sale observation
        final String observations = jTAObserv.getText().trim();

        Sale.setAccount("");
        Sale.setSerie(serie);
        Sale.setNoser("");
        Sale.setCoinCode(Coin.getCode());
        Sale.setSalesMan(User.getCode());
        Sale.setPaymentForm("01");
        Sale.setTypeExchange(new BigDecimal(Float.toString(Coin.getValue())));
        Sale.setTotalTranslade(total_traslado);
        Sale.setTotalRetention(total_retencion);
        Sale.setPaymentMethod("01");
        Sale.setEmisionDate(UtilitiesFactory.getSingleton().getDateTimeUtility().getCurrentDate());
        Sale.setDeliverDate(UtilitiesFactory.getSingleton().getDateTimeUtility().getCurrentDate());
        Sale.setTicket(ticket);
        Sale.setEstatus(estatus);
        Sale.setObservation(observations);
        Sale.setSalesPoint(true);

        final BigDecimal BigDecimalTotal = new BigDecimal(UtilitiesFactory.getSingleton().getNumbersUtility().fromMoneyFormat(jTEfeCant.getText().trim()));
        final BigDecimal BigDecimalCardDebit = new BigDecimal(UtilitiesFactory.getSingleton().getNumbersUtility().fromMoneyFormat(jTDebCant.getText().trim()));
        final BigDecimal BigDecimalCardCredit = new BigDecimal(UtilitiesFactory.getSingleton().getNumbersUtility().fromMoneyFormat(jTTarCredCant.getText().trim()));
        
        switch(DocumentType_){
            
            case REMISION:
                RepositoryFactory.getInstance().getSalessRepository().saveSaleRemision(Sale, Company, false, partvtas,BigDecimalTotal,BigDecimalCardDebit,BigDecimalCardCredit);
                break;
                
            case INVOICE:
                RepositoryFactory.getInstance().getSalessRepository().saveSaleInvoice(Sale, true, Company_, false, partvtas,BigDecimalTotal,BigDecimalCardDebit,BigDecimalCardCredit);
                break;
    
            case TICKETS:
                RepositoryFactory.getInstance().getSalessRepository().saveSaleTicket(Sale, Company_, false, partvtas,BigDecimalTotal,BigDecimalCardDebit,BigDecimalCardCredit);
                break;
            
            case NOTC:
                RepositoryFactory.getInstance().getSalessRepository().saveSaleNotc(Sale, Company_, false, partvtas,BigDecimalTotal,BigDecimalCardDebit,BigDecimalCardCredit);
                break;
        }

        //Get import in words
        final String importInWords = UtilitiesFactory.getSingleton().getNumbersUtility().convertNumberToStringRepresentation(String.valueOf(Sale.getTotal()), Sale.getSerie(), Sale.getCoinCode(), true, true);
        
        final String subtotalFormat = UtilitiesFactory.getSingleton().getNumbersUtility().toMoneyFormat(String.valueOf(Sale.getSubtotal().doubleValue()));
        final String taxesFormat = UtilitiesFactory.getSingleton().getNumbersUtility().toMoneyFormat(String.valueOf(Sale.getTax().doubleValue()));
        final String disccountFormat = UtilitiesFactory.getSingleton().getNumbersUtility().toMoneyFormat(String.valueOf(Sale.getTotalDisccount().doubleValue()));
        final String totalFormat = UtilitiesFactory.getSingleton().getNumbersUtility().toMoneyFormat(String.valueOf(Sale.getTotal().doubleValue()));        
        
        GenerateProperties GenerateProperties = new GenerateProperties();
        
        switch(DocumentType_){
            
            case REMISION:
                break;
                
            case INVOICE:
                
                //Crete the report model
                final FacReportModel FacReportModel = new FacReportModel();
                FacReportModel.setCiu(Company_.getCiu());
                FacReportModel.setMon(Sale.getCoinCode());
                FacReportModel.setCol(Company_.getCol());
                FacReportModel.setNomemp(Company_.getNom());
                FacReportModel.setVta(String.valueOf(Sale.getId()));        
                FacReportModel.setPai(Company_.getPai());
                FacReportModel.setFdoc(Sale.getDeliverDate().toString());
                FacReportModel.setEstad(Company_.getEstad());
                FacReportModel.setNoext(Company_.getNoext());
                FacReportModel.setImportWords(importInWords);
                FacReportModel.setNoint(Company_.getNoint());
                FacReportModel.setTel(Company_.getTel());
                FacReportModel.setCp(Company_.getCP());
                FacReportModel.setRfc(Company_.getRFC());                
                FacReportModel.setCall(Company_.getCalle());

                FacReportModel.setSubtotal(subtotalFormat);
                FacReportModel.setImpue(taxesFormat);
                FacReportModel.setDescu(disccountFormat);
                FacReportModel.setTot(totalFormat);
                FacReportModel.setWebPage(Company_.getPags());

                //Create the report properties                
                GenerateProperties.setObjectModel(FacReportModel);
                if(UtilitiesFactory.getSingleton().getPrintersUtility().userTicketPrinterExists()){
                    GenerateProperties.setPrint(true);
                }        
                GenerateProperties.setExportToPDF(true);
                GenerateProperties.setPdfExportPath(UtilitiesFactory.getSingleton().getImagesUtility().getInvoicesPath());
                GenerateProperties.setPdfFileName(String.valueOf(Sale.getId()));

                //Change the tickets printer
                if(UtilitiesFactory.getSingleton().getPrintersUtility().userTicketPrinterExists()){
                    UtilitiesFactory.getSingleton().getPrintersUtility().changeDefaultUserTicketPrinter();
                }

                //Generate te report
                final FacReportGenerator FacReportGenerator = ReportsManager.getSingleton().getFacReportGenerator();
                FacReportGenerator.setLocalCompanyParams(true);
                FacReportGenerator.setBaseReport(FacReportModel);
                FacReportGenerator.generate(GenerateProperties);
                
                break;
    
            case TICKETS:
                
                //Crete the report model
                final TicketReportModel TicketReportModel = new TicketReportModel();
                TicketReportModel.setCity(Company_.getCiu());
                TicketReportModel.setCoin(Sale.getCoinCode());
                TicketReportModel.setColony(Company_.getCol());
                TicketReportModel.setCompanyName(Company_.getNom());
                TicketReportModel.setConsecutive(Sale.getReferenceNumber());
                TicketReportModel.setCountry(Company_.getPai());
                TicketReportModel.setDocumentDate(Sale.getDeliverDate().toString());
                TicketReportModel.setEstate(Company_.getEstad());
                TicketReportModel.setExternalNumber(Company_.getNoext());
                TicketReportModel.setImportWords(importInWords);
                TicketReportModel.setInternalNumber(Company_.getNoint());
                TicketReportModel.setPhone(Company_.getTel());
                TicketReportModel.setPostalCode(Company_.getCP());
                TicketReportModel.setRFC(Company_.getRFC());
                TicketReportModel.setSaleID(String.valueOf(Sale.getId()));        
                TicketReportModel.setStreet(Company_.getCalle());

                TicketReportModel.setSubtotal(subtotalFormat);
                TicketReportModel.setTax(taxesFormat);
                TicketReportModel.setDisccount(disccountFormat);
                TicketReportModel.setTotal(totalFormat);
                TicketReportModel.setWebPage(Company_.getPags());

                //Create the report properties
                GenerateProperties.setObjectModel(TicketReportModel);
                if(UtilitiesFactory.getSingleton().getPrintersUtility().userTicketPrinterExists()){
                    GenerateProperties.setPrint(true);
                }        
                GenerateProperties.setExportToPDF(true);
                GenerateProperties.setPdfExportPath(UtilitiesFactory.getSingleton().getImagesUtility().getTicketsPath());
                GenerateProperties.setPdfFileName(String.valueOf(Sale.getId()));

                //Change the tickets printer
                if(UtilitiesFactory.getSingleton().getPrintersUtility().userTicketPrinterExists()){
                    UtilitiesFactory.getSingleton().getPrintersUtility().changeDefaultUserTicketPrinter();
                }

                //Generate te report
                final TicketReportGenerator TicketReportGenerator = ReportsManager.getSingleton().getTicketReportGenerator();
                TicketReportGenerator.setLocalCompanyParams(true);
                TicketReportGenerator.setBaseReport(TicketReportModel);
                TicketReportGenerator.generate(GenerateProperties);
                
                break;
            
            case NOTC:
                break;
        }
        
        if(OnFinish!=null){
            OnFinish.onFinish();
        }
                
        dispose();
    }
    
    private void jBCobActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{
            
            if(jRFac.isSelected()){

                //Is the customer is not mostrador
                if(!Company.isCashCustomer()){

                    //The customer need to have all the fiscal data
                    if(     Company.getCalle().isEmpty() || 
                            Company.getCol().isEmpty() || 
                            Company.getCP().isEmpty() || 
                            Company.getNoext().isEmpty() || 
                            Company.getRFC().isEmpty() || 
                            Company.getCiu().isEmpty() || 
                            Company.getEstad().isEmpty()){
                        UtilitiesFactory.getSingleton().getGenericExceptionUtil().generateException("errors_missing_fiscal_info");
                        return;
                    }
                }
            }

            charge();
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(CobroViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(CobroViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    
    
    private void prevalidateTicket() throws Exception {
        
    }
    
    private void prevalidateRemision() throws Exception {
        
    }
    
    private void prevalidateInvoice() throws Exception {
    
        //Get configuration to check if need admin password to continue with invoice        
    }
    
    private void jBSalActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
            DialogsFactory.getSingleton().showQuestionExitDialog(baseJFrame, (JFrame jFrame) -> {
                dispose();
            });
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(CobroViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(CobroViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    @Override
    public List<?> getItemsToLoadInTable() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public interface OnFinish{
        public void onFinish();
    }
}
