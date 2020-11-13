/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.easyretail.controllers.views;

import com.era.datamodels.enums.DocumentType;
import com.era.easyretail.era_jasperreports.ReportManager;
import com.era.easyretail.exceptions.InternalUnexpectedErrorException;
import com.era.views.CobroJFrame;
import java.util.List;
import com.era.logger.LoggerUtility;
import com.era.models.BasDats;
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
            
            final ButtonGroup g = new ButtonGroup();
            g.add(jRTic);
            g.add(jRRem);
            g.add(jRFac);

            final ButtonGroup creditOrCashRadioG = new ButtonGroup();
            creditOrCashRadioG.add(jRadioButtonCredit);
            creditOrCashRadioG.add(jRadioButtonCash);
        
            //When the user selects ticket it can not be in credit
            this.JComponentUtils.onRadioButtonChangeListener(jRTic, new JComponentUtils.OnRadioButtonChange(){
                
                @Override
                public void onChecked() {
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
                
                @Override
                public void onUncheked() {
                    
                }
            });
            
            //When the user selects remision it can not be in credit
            this.JComponentUtils.onRadioButtonChangeListener(jRRem, new JComponentUtils.OnRadioButtonChange(){
                
                @Override
                public void onChecked() {
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
                
                @Override
                public void onUncheked() {
                    
                }
            });
            
            //When the user selects invoice it can be in credit
            this.JComponentUtils.onRadioButtonChangeListener(jRFac, new JComponentUtils.OnRadioButtonChange(){
                
                @Override
                public void onChecked() {
                    try {
                        
                        //Validate if the sale is in credit
                        validateIfSaleInCredit();
        
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
                    
                }
            });
            
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
        
        final String conditions = RepositoryFactory.getInstance().getCompanysRepository().getCustomerConditions(Company);
        jLabelCred.setText(conditions);
        
        //Validate if the sale is in credit
        validateIfSaleInCredit();
    }
    
    private void validateIfSaleInCredit() throws Exception {
        
        //If the customer has credit
        if(this.Company.hasCredit()){
            
            //If the customer has saldo a favor
            final BigDecimal saldoFavor = RepositoryFactory.getInstance().getCxcRepository().getSaldoFavorFromCustomer(this.Company.getCompanyCode());
            if(saldoFavor.compareTo(BigDecimal.ZERO)>0){
                
                //The amount should be enought
                if(saldoFavor.compareTo(Sale.getTotal())>0){
                    creditPayment();
                }
                else{
                    jRadioButtonCredit.setEnabled(false);

                    //Pat at the moment
                    atmomentPayment();
                }
            }
        }
    }
    
    private void creditPayment() throws Exception{
        
        //Select radio to credit
        jRadioButtonCredit.setSelected(true);
        jRadioButtonCredit.setEnabled(true);

        jRFac.setSelected(true);
        
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
        
        final BasDats BasDatsLocal = UtilitiesFactory.getSingleton().getSessionUtility().getBasDats();
        
        switch(DocumentType_){
            
            case REMISION:
                
                RepositoryFactory.getInstance().getSalessRepository().saveSaleRemision(Sale, Company, false, partvtas,BigDecimalTotal,BigDecimalCardDebit,BigDecimalCardCredit);
                
                ReportManager.getSingleton().generateRemPDF(Sale, Company_, BasDatsLocal);
                
                break;
                
            case INVOICE:
                
                RepositoryFactory.getInstance().getSalessRepository().saveSaleInvoice(Sale, true, Company_, false, partvtas,BigDecimalTotal,BigDecimalCardDebit,BigDecimalCardCredit);
                
                ReportManager.getSingleton().generateCFDIPDF(Sale, Company_, BasDatsLocal);
                
                break;
    
            case TICKETS:
                
                RepositoryFactory.getInstance().getSalessRepository().saveSaleTicket(Sale, Company_, false, partvtas,BigDecimalTotal,BigDecimalCardDebit,BigDecimalCardCredit);
                
                ReportManager.getSingleton().generateTicketPDF(Sale, Company_, BasDatsLocal);
                
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
