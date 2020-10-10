/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.easyretail.controllers.views;

import com.era.logger.LoggerUtility;
import com.era.models.Cxc;
import com.era.models.Payment;
import com.era.repositories.RepositoryFactory;
import com.era.views.dialogs.DialogsFactory;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.util.List;
import com.era.views.AbonosJFrame;
import com.era.views.tables.headers.TableHeaderFactory;
import javax.swing.JFrame;

/**
 *
 * @author PC
 */
public class AbonosViewController extends AbonosJFrame {
 
    private Cxc Cxc;
    
    public AbonosViewController() {
        super("window_title_abons");
        
        try{
                     
            jBTimbrar.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBTimbrarActionPerformed(evt);
            });
            jBComprobar.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBComprobarActionPerformed(evt);
            });
            jBCancel.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBCancelActionPerformed(evt);
            });
            
            //Config table
            this.BaseJTable = paymentTable;
            paymentTable.addShowColumn(TableHeaderFactory.getSigleton().getPaymentsTableHeader().getROWNUMBER());
            paymentTable.addShowColumn(TableHeaderFactory.getSigleton().getPaymentsTableHeader().getFOLIO());
            paymentTable.addShowColumn(TableHeaderFactory.getSigleton().getPaymentsTableHeader().getSERIE());
            paymentTable.addShowColumn(TableHeaderFactory.getSigleton().getPaymentsTableHeader().getCODIGO_CLIENTE_PROVEEDOR());
            paymentTable.addShowColumn(TableHeaderFactory.getSigleton().getPaymentsTableHeader().getESTATUS());
            paymentTable.addShowColumn(TableHeaderFactory.getSigleton().getPaymentsTableHeader().getCOMENTARIO());
            paymentTable.addShowColumn(TableHeaderFactory.getSigleton().getPaymentsTableHeader().getCONCEPTO());
            paymentTable.addShowColumn(TableHeaderFactory.getSigleton().getPaymentsTableHeader().getFORMA_PAGO());
            paymentTable.addShowColumn(TableHeaderFactory.getSigleton().getPaymentsTableHeader().getCUENTA_BANCO());            
            paymentTable.addShowColumn(TableHeaderFactory.getSigleton().getPaymentsTableHeader().getIMPORTE());
            paymentTable.addShowColumn(TableHeaderFactory.getSigleton().getPaymentsTableHeader().getTIMBRADA());
            
        }catch (Exception ex) {
            LoggerUtility.getSingleton().logError(AbonosViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(AbonosViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }

    private void jBTimbrarActionPerformed(java.awt.event.ActionEvent evt) {
    
        try {
            
            if(!paymentTable.isRowSelected()){
                DialogsFactory.getSingleton().showErrorOKNoSelectionCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                    paymentTable.grabFocus();
                });
                return;
            }
            
            //If the payment is ringed stop
            final Payment Payment = (Payment)paymentTable.getRowSelected();            
            if(Payment.isTimbrada()){
                DialogsFactory.getSingleton().showOKDialog(baseJFrame, "errors_document_ringed");
               return; 
            }
            
            DialogsFactory.getSingleton().showQuestionContinueDialog(baseJFrame, (JFrame jFrame) -> {
                
                try {
                
                    Payment.setTimbrada(true);
                    
                    RepositoryFactory.getInstance().getPaymentsRepository().update(Payment);
                    
                    initTable();
                    
                    DialogsFactory.getSingleton().showOKOperationCompletedCallbackDialog(jFrame, (JFrame jFrame1) -> {
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
            
        } catch (Exception ex) {
            LoggerUtility.getSingleton().logError(this.getClass(), ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    
    private void jBComprobarActionPerformed(java.awt.event.ActionEvent evt) {
    
        try {
            
        } catch (Exception ex) {
            LoggerUtility.getSingleton().logError(this.getClass(), ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    private void jBCancelActionPerformed(java.awt.event.ActionEvent evt) {
    
        try {
            
            if(!paymentTable.isRowSelected()){
                DialogsFactory.getSingleton().showErrorOKNoSelectionCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                    paymentTable.grabFocus();
                });
                return;
            }
            
            //If the payment is already canceled stop
            final Payment Payment = (Payment)paymentTable.getRowSelected();            
            if(!RepositoryFactory.getInstance().getPaymentsRepository().isConfirmed(Payment)){
                DialogsFactory.getSingleton().showOKDialog(baseJFrame, "errors_document_already_canceled");
               return; 
            }
            
            DialogsFactory.getSingleton().showQuestionContinueDialog(baseJFrame, (JFrame jFrame) -> {
                
                try {
                
                    RepositoryFactory.getInstance().getPaymentsRepository().cancel(Payment);
                    
                    initTable();
                    
                    DialogsFactory.getSingleton().showOKOperationCompletedCallbackDialog(jFrame, (JFrame jFrame1) -> {
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
            
        } catch (Exception ex) {
            LoggerUtility.getSingleton().logError(this.getClass(), ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    public void setCxc(Cxc Cxc) {        
        
        try {
         
            this.Cxc = Cxc;
            
            initTable();                        
            
        } catch (Exception ex) {
            LoggerUtility.getSingleton().logError(this.getClass(), ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    private void initTable() throws Exception {
        
        final List<Payment> payments = RepositoryFactory.getInstance().getPaymentsRepository().getAllPaymentsOfDocument(Cxc.getNorefer(), Cxc.getNoser());
            
        paymentTable.initTable(payments);
    }
    
    @Override
    public void loadModelInFields(Object ObjectModel) throws  Exception {        
    }
    
    @Override
    public void clearFields() throws Exception{            
    }
    
    @Override
    public List<?> getItemsToLoadInTable() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
