/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.easyretail.controllers.views;

import com.era.easyretail.exceptions.InternalUnexpectedErrorException;
import com.era.views.CobroJFrame;
import java.util.List;
import com.era.logger.LoggerUtility;
import com.era.models.Coin;
import com.era.models.Company;
import com.era.models.Confgral;
import com.era.models.Consec;
import com.era.models.DocumentOrigin;
import com.era.models.ImpuesXProduct;
import com.era.models.Partvta;
import com.era.models.Product;
import com.era.models.Sales;
import com.era.models.User;
import com.era.repositories.RepositoryFactory;
import com.era.utilities.UtilitiesFactory;
import com.era.views.dialogs.DialogsFactory;
import java.awt.event.FocusEvent;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
/**
 *
 * @author PC
 */
public class CobroViewController extends CobroJFrame {
            
    private Sales Sale;
    private List<Partvta> partvtas;
    private OnFinish OnFinish;
            
    public CobroViewController() {
        super("window_title_cobro");
        
        try{
            
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
    
    public void init(final Sales Sale, final List<Partvta> partvtas) throws Exception {
        
        //Save globally
        this.Sale = Sale;
        this.partvtas = partvtas;
        
        //Set the cash
        jTEfeCant.setText(UtilitiesFactory.getSingleton().getNumbersUtility().toMoneyFormat(String.valueOf(Sale.getTotal().doubleValue())));
        jTTot.setText(UtilitiesFactory.getSingleton().getNumbersUtility().toMoneyFormat(String.valueOf(Sale.getTotal().doubleValue())));
                
        //Calculate totals
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
        final BigDecimal total = Sale.getTotal();

        //If there is pending amount stop
        if(sald.compareTo(BigDecimal.ZERO)!=0){
            DialogsFactory.getSingleton().showErrorOKCallbackDialog(baseJFrame, "errors_pending_ammount", (JFrame jFrame) -> {
                jTEfeCant.grabFocus();
            });
            return;
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
        Consec Consec = null;
        DocumentOrigin DocumentOrigin = null;
        boolean ticket = false;
        String estatus = "";
        if(jRTic.isSelected()){

            //Get the serie
            final Confgral Confgral = RepositoryFactory.getInstance().getConfgralRepository().getSerieTickInPointOfSale();
            serie = Confgral.getExtr();

            //Get the consec for this serie
            Consec = (Consec)RepositoryFactory.getInstance().getConsecsRepository().getTicketsConsec(serie);

            //Get the document type
            DocumentOrigin = RepositoryFactory.getInstance().getDocumentOriginRepository().getDocumentOriginTIK();

            ticket = true;

            estatus = "CO";
        }
        else if(jRRem.isSelected()){

            //Get the serie
            final Confgral Confgral = RepositoryFactory.getInstance().getConfgralRepository().getSerieRemisionsInPointOfSale();
            serie = Confgral.getExtr();

            //Get the consec for this serie
            Consec = (Consec)RepositoryFactory.getInstance().getConsecsRepository().getRemisionsConsec(serie);

            //Get the document type
            DocumentOrigin = RepositoryFactory.getInstance().getDocumentOriginRepository().getDocumentOriginREM();

            ticket = false;
            
            estatus = "CO";
        }
        else if(jRFac.isSelected()){

            //Get the serie
            final Confgral Confgral = RepositoryFactory.getInstance().getConfgralRepository().getSerieInvoiceInPointOfSale();
            serie = Confgral.getExtr();

            //Get the consec for this serie
            Consec = (Consec)RepositoryFactory.getInstance().getConsecsRepository().getSalesConsec(serie);

            //Get the document type
            DocumentOrigin = RepositoryFactory.getInstance().getDocumentOriginRepository().getDocumentOriginFAC();

            ticket = false;
            
            estatus = "CO";
        }

        if(serie.isEmpty()){
            throw new InternalUnexpectedErrorException("serie");
        }
        if(Consec==null){
            throw new InternalUnexpectedErrorException("Consec");
        }
        if(DocumentOrigin==null){
            throw new InternalUnexpectedErrorException("DocumentOrigin");
        }
        if(estatus==null){
            throw new InternalUnexpectedErrorException("estatus");
        }            

        //Update the consec
        Consec = RepositoryFactory.getInstance().getConsecsRepository().updateConsec(Consec);
        
        //Get the customer
        final Company Company = (Company)RepositoryFactory.getInstance().getCompanysRepository().getByCod(Sale.getCompanyCode());

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
        Sale.setReferenceNumber(String.valueOf(Consec.getConsec()));
        Sale.setSerie(serie);
        Sale.setNoser("");
        Sale.setCoinCode(Coin.getCode());
        Sale.setSalesMan(User.getCode());
        Sale.setPaymentForm("01");
        Sale.setTypeExchange(new BigDecimal(Float.toString(Coin.getValue())));
        Sale.setTotalTranslade(total_traslado);
        Sale.setTotalRetention(total_retencion);
        Sale.setDocumentType(DocumentOrigin.getType());
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
        
        //Save the sale
        RepositoryFactory.getInstance().getSalessRepository().saveSale(Sale, partvtas,BigDecimalTotal,BigDecimalCardDebit,BigDecimalCardCredit);

        DialogsFactory.getSingleton().showOKOperationCompletedCallbackDialog(baseJFrame, (JFrame jFrame1) -> {

            if(OnFinish!=null){
                OnFinish.onFinish();
            }

            dispose();
        });
    }
    
    private void jBCobActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{
            
            DialogsFactory.getSingleton().showQuestionContinueDialog(baseJFrame, (JFrame jFrame) -> {
                
                try {
                    
                    charge();
                            
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
