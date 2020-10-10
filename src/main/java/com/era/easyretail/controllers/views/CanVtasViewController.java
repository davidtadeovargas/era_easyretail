/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.easyretail.controllers.views;

import com.era.easyretail.controllers.views.ClavMastViewController.OnResult;
import com.era.easyretail.era_jasperreports.ReportManager;
import com.era.logger.LoggerUtility;
import com.era.models.Company;
import com.era.models.Sales;
import com.era.repositories.RepositoryFactory;
import com.era.repositories.datamodels.DocumentTypeFilter;
import com.era.views.CanVtasJFrame;
import com.era.views.dialogs.DialogsFactory;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author PC
 */
public class CanVtasViewController extends CanVtasJFrame {
    
    private DocumentTypeFilter DocumentTypeFilter;
    
    public CanVtasViewController() {
        super("window_title_cancel_sales");
        
        try{
            
            this.disposeButton(jBSal);
            
            jBCancel.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBCancelActionPerformed(evt);
            });
            jBBusc.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBBuscActionPerformed(evt);
            });
            jBMosT.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBMosTActionPerformed(evt);
            });
            
            //Configuretable
            this.BaseJTable = jTab;
            jTab.showCommonColumns();            
            jTab.setScrollAtStartWhenEnd(true);
            jTab.setJScrollPane(jScrollPane2);
            jTab.setOnPaginationLabelUpdate((String paginationUpdate) -> {
                jLabelPagination.setText(paginationUpdate);
            });
            
        }catch (Exception ex) {
            LoggerUtility.getSingleton().logError(CanVtasViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(CanVtasViewController.class.getName()).log(Level.SEVERE, null, ex1);
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
    
    private void jBCancelActionPerformed(java.awt.event.ActionEvent evt) {
    
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
                    
            //Check if the sale has any payment registered
            //final Cxc Cxc = (Cxc)RepositoryFactory.getInstance().getCxcRepository().getCXC(Sale.getReferenceNumber(), Sale.getSerie(), Sale.getId(), Sale.getCompanyCode());
            
            //If the document has registered payments stop
            /*if(Cxc!=null){
                DialogsFactory.getSingleton().showErrorOKCallbackDialog(baseJFrame, "errors_sales_document_has_payments", (JFrame jFrame) -> {
                    jTab.grabFocus();
                });                
                return;
            }*/
            
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
                    
                    //If should ask by admin password first so
                    if(RepositoryFactory.getInstance().getConfgralRepository().getAskForAdminPasswordOnCancelInvoicesOnPointOfSales().getVal()==1){
                        final ClavMastViewController ClavMastViewController = ViewControlersFactory.getSingleton().getClavMastViewController();
                        ClavMastViewController.setOnResult(new OnResult(){

                            @Override
                            public void onValidAdminUser() {
                                
                                try {
                                    
                                    cancelSale(Sale.getId(), razon);
                                                                        
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
                            public void onInvalidAdminUser() {
                                
                                try {
                                 
                                    DialogsFactory.getSingleton().showErrorInvalidLoginOKDialog(baseJFrame, (JFrame jFrame1) -> {
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

                        });
                        ClavMastViewController.setVisible();
                    }
                    else{
                        cancelSale(Sale.getId(), razon);
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
    
    private void cancelSale(final int saleID, final String razon) throws Exception {
        
        //Cancel the sale
        RepositoryFactory.getInstance().getSalessRepository().cancelSale(saleID, razon);

        final Sales Sale = RepositoryFactory.getInstance().getSalessRepository().getByVenta(saleID);
        
        final Company Company = RepositoryFactory.getInstance().getCompanysRepository().getCustomerByCode(Sale.getCompanyCode());
        
        ReportManager.getSingleton().generateCancelSalePDF(Sale, Company, true);
        
        //Reload the table
        jTab.initTableWithPagination();

        //Success
        DialogsFactory.getSingleton().showOKOperationCompletedCallbackDialog(baseJFrame, (JFrame jFrame1) -> {
        });
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
