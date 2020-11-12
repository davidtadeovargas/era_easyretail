/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.easyretail.controllers.views;

import com.era.logger.LoggerUtility;
import com.era.models.Cxc;
import com.era.models.Sales;
import com.era.repositories.RepositoryFactory;
import com.era.repositories.datamodels.DocumentTypeFilter;
import com.era.views.DevVtaPtoJFrame;
import com.era.views.dialogs.DialogsFactory;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author PC
 */
public class DevVtaPtoViewController extends DevVtaPtoJFrame {
    
    private DocumentTypeFilter DocumentTypeFilter;
    
    public DevVtaPtoViewController(){
        
        super("window_title_devs_sales");
        
        try {
            
            jBDev.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBDevActionPerformed(evt);
            });
            jBBusc.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBBuscActionPerformed(evt);
            });
            jBMosT.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBMosTActionPerformed(evt);
            });
            
            this.disposeButton(jBSal);
            
            //Configuretable
            this.BaseJTable = jTab;
            jTab.showCommonColumns();
            jTab.setScrollAtStartWhenEnd(true);
            jTab.setJScrollPane(jScrollPane2);
            jTab.setOnPaginationLabelUpdate((String paginationUpdate) -> {
                jLabelPagination.setText(paginationUpdate);
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

    public void setDocumentTypeFilter(DocumentTypeFilter DocumentTypeFilter) throws Exception {
        this.DocumentTypeFilter = DocumentTypeFilter;
        
        //Load sales
        jTab.setDocumentTypeFilter(DocumentTypeFilter);
        jTab.initTableWithPagination();
    }   
    
    private void jBMosTActionPerformed(java.awt.event.ActionEvent evt) {
    
        try {
            
            this.jTab.initTableWithPagination();
            
        } catch (Exception ex) {
            LoggerUtility.getSingleton().logError(this.getClass(), ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    private void jBBuscActionPerformed(java.awt.event.ActionEvent evt) {
    
        try {
            
            //Get the value to search
            final String search = jTBusc.getText().trim();
            
            //If nothing to search so return
            if(search.isEmpty()){
                return;
            }
            
            //Search all the ocurrences
            this.jTab.getByLikeEncabezados(search);
            
        } catch (Exception ex) {
            LoggerUtility.getSingleton().logError(this.getClass(), ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    private void jBDevActionPerformed(java.awt.event.ActionEvent evt) {
        
        try {
    
            //First select a sale
            if(!jTab.isRowSelected()){
                DialogsFactory.getSingleton().showErrorOKNoSelectionCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                    jTab.grabFocus();
                });
                return;
            }
            
            //Get the selected sale
            final Sales Sale = (Sales)jTab.getRowSelected();
                    
            //If the sale is already returned stop            
            if(RepositoryFactory.getInstance().getSalessRepository().isDev(Sale) || RepositoryFactory.getInstance().getSalessRepository().isCanceled(Sale) || RepositoryFactory.getInstance().getSalessRepository().isParcialDev(Sale)){
                DialogsFactory.getSingleton().showErrorSaleNotContinueByEstatusOKDialog(baseJFrame, (JFrame jFrame) -> {
                    jTab.grabFocus();
                });
                return; 
            }
            
            //If is CXC document
            final boolean cxcDocument = RepositoryFactory.getInstance().getSalessRepository().cxcDocument(Sale);
            if(cxcDocument){
                
                //Check if the sale has any payment registered
                final Cxc Cxc = (Cxc)RepositoryFactory.getInstance().getCxcRepository().getCXC(Sale.getReferenceNumber(), Sale.getSerie(), Sale.getId(), Sale.getCompanyCode());

                //If the document has registered payments stop
                if(Cxc!=null){
                    DialogsFactory.getSingleton().showErrorOKCallbackDialog(baseJFrame, "errors_sales_document_has_payments", (JFrame jFrame) -> {
                        jTab.grabFocus();
                    });                
                    return;
                }
            }
            
            //Type first a razon
            final String razon = jTMot.getText().trim();
            if(razon.isEmpty()){
                DialogsFactory.getSingleton().showOKEmptyFieldCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                    jTMot.grabFocus();
                });
                return;
            }
            
            DialogsFactory.getSingleton().showQuestionContinueDialog(baseJFrame, (JFrame jFrame) -> {
                
                try {
                    
                    //Return the sale
                    RepositoryFactory.getInstance().getSalessRepository().returnSale(Sale.getId(), razon);

                    //Reload the table
                    jTab.initTableWithPagination();

                    //Success
                    DialogsFactory.getSingleton().showOKOperationCompletedCallbackDialog(baseJFrame, (JFrame jFrame1) -> {
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
}
