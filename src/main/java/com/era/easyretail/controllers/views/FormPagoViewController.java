/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.easyretail.controllers.views;

import com.era.datamodels.enums.SearchCommonTypeEnum;
import com.era.views.FormPagoJFrame;
import java.util.List;
import com.era.logger.LoggerUtility;
import com.era.models.CPaymentForm;
import com.era.models.Company;
import com.era.models.Cxc;
import com.era.models.Payment;
import com.era.repositories.RepositoryFactory;
import com.era.utilities.UtilitiesFactory;
import com.era.views.dialogs.DialogsFactory;
import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
/**
 *
 * @author PC
 */
public class FormPagoViewController extends FormPagoJFrame {
    
    private Cxc Cxc;
    private BigDecimal pendingToPay;
    
    public FormPagoViewController() {
        super("window_title_formpag");
        
        try{                        
            
            JComponentUtils.moneyFormat(jForImporte);
                     
            jBAbon.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBAbonActionPerformed(evt);
            });
            jBFormPag.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBFormPagActionPerformed(evt);
            });
            jBConcep.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBConcepActionPerformed(evt);
            });
            jBBancos.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBBancosActionPerformed(evt);
            });                                    
            
        }catch (Exception ex) {
            LoggerUtility.getSingleton().logError(FormPagoViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(FormPagoViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }

    public void setCxc(Cxc Cxc) {
        
        try {
         
            this.Cxc = Cxc;

            final Company Company = RepositoryFactory.getInstance().getCompanysRepository().getCustomerByCode(Cxc.getEmpre());
            txtCustomerCode.setText(Cxc.getEmpre());
            txtCustomerName.setText(Company.getNom());
            
            //Determine the pending of payment
            final BigDecimal totalPaid = RepositoryFactory.getInstance().getPaymentsRepository().getTotalPaidForDocument(Cxc.getNoser(),Cxc.getNorefer());
            pendingToPay = Cxc.getCarg().subtract(totalPaid==null?BigDecimal.ZERO:totalPaid);
                        
            //Put in the field
            final String pendingToPayString = UtilitiesFactory.getSingleton().getNumbersUtility().toMoneyFormat(pendingToPay);
            jForImporte.setText(pendingToPayString);
            
            labelPendingToPay.setText(pendingToPayString);
            
            //Select cash as payment form
            final CPaymentForm CPaymentForm = RepositoryFactory.getInstance().getCPaymentFormsRepository().getCashForm();
            jTFormPag.setText(CPaymentForm.getC_FormaPago());
            txtFormPagDescrip.setText(CPaymentForm.getDescription());
            
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
    public void loadModelInFields(Object ObjectModel) throws  Exception {        
    }
    
    @Override
    public void clearFields() throws Exception{            
    }
    
    private void jBAbonActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
    
            final String paymentForm = jTFormPag.getText();
            if(paymentForm.isEmpty()){
                DialogsFactory.getSingleton().showOKEmptyFieldCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                    jTFormPag.grabFocus();
                    return;
                });
            }
            
            final String totalAbon = jForImporte.getText();            
            final BigDecimal totalAbonBigDecimal = UtilitiesFactory.getSingleton().getNumbersUtility().fromMoneyFormatToBigDecimal(totalAbon);
            if(totalAbonBigDecimal.compareTo(BigDecimal.ZERO)==0 || totalAbonBigDecimal.compareTo(pendingToPay)>0){
                DialogsFactory.getSingleton().showErrorOKCallbackDialog(baseJFrame, "errors_invalid_amount", (JFrame jFframe) -> {
                });
                return;
            }
            
            DialogsFactory.getSingleton().showQuestionContinueDialog(baseJFrame, (JFrame jFrame) -> {
                
                try {
                    
                    final String comment = jTComentario.getText().trim();
                    final String bankAccount = jTBanco.getText().trim();                    
                    
                    final Payment Payment = new Payment();
                    Payment.setCodigoClienteProveedor(Cxc.getEmpre());
                    Payment.setComentario(comment);
                    Payment.setConcepto("");
                    Payment.setCuentabanco(bankAccount);
                    Payment.setFolio(Cxc.getNorefer());
                    Payment.setFormapago(paymentForm);
                    Payment.setImporte(totalAbonBigDecimal);
                    Payment.setSerie(Cxc.getNoser());
                    
                    //Save the payment
                    RepositoryFactory.getInstance().getPaymentsRepository().save(Cxc,Payment);
                    
                    DialogsFactory.getSingleton().showOKOperationCompletedCallbackDialog(jFrame, (JFrame jFrame1) -> {
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
            LoggerUtility.getSingleton().logError(FormPagoViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(FormPagoViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBFormPagActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
            //Search
            final SearchViewController SearchViewController = new SearchViewController();
            SearchViewController.setSEARCH_TYPE(SearchCommonTypeEnum.PAYMENT_METHOD);
            SearchViewController.setButtonAceptClicked(() -> {

                try {
                 
                    final String paymentMethod = SearchViewController.getCod();
                    jTFormPag.setText(paymentMethod);
                    
                    final String paymentMethodDescrip = SearchViewController.getDescrip();
                    txtFormPagDescrip.setText(paymentMethodDescrip);
                    
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
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(FormPagoViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(FormPagoViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBConcepActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(FormPagoViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(FormPagoViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBBancosActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
            //Search
            final SearchViewController SearchViewController = new SearchViewController();
            SearchViewController.setSEARCH_TYPE(SearchCommonTypeEnum.BANCOS);
            SearchViewController.setButtonAceptClicked(() -> {

                try {
                 
                    final String account = SearchViewController.getCod();
                    jTBanco.setText(account);
                    
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
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(FormPagoViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(FormPagoViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    @Override
    public List<?> getItemsToLoadInTable() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
