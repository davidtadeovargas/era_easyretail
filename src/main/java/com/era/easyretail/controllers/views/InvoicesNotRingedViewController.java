/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.easyretail.controllers.views;

import com.era.datamodels.enums.DocumentType;
import com.era.logger.LoggerUtility;
import com.era.models.Sales;
import com.era.repositories.RepositoryFactory;
import com.era.views.InvoicesNotRingedVtasJFrame;
import com.era.views.dialogs.DialogsFactory;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author PC
 */
public class InvoicesNotRingedViewController extends InvoicesNotRingedVtasJFrame{
        
    private DocumentType DocumentType_ = DocumentType.INVOICE_NOT_RINGED_CONFIRMED;
    
    public InvoicesNotRingedViewController(){
        
        super("window_title_invoices_not_ringed");
        
        try {
            
            jBRing.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBImpActionPerformed(evt);
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
            
            //Load sales
            jTab.setDocumentType(DocumentType_);
            jTab.initTableWithPagination();

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

	try{            	
            
            //Get the value to search
            final String search = jTBusc.getText().trim();
            
            //If nothing to search so return
            if(search.isEmpty()){
                return;
            }
            
            //Search all the ocurrences
            this.jTab.getByLikeEncabezados(search);
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(VVtasViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(VVtasViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBMosTActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
            this.jTab.initTableWithPagination();
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(VVtasViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(VVtasViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBImpActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
            //First select a sale
            if(!jTab.isRowSelected()){
                DialogsFactory.getSingleton().showErrorOKNoSelectionCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                    jTab.grabFocus();
                });
                return;
            }
            
            //Get the selected sale
            Sales Sale = (Sales)jTab.getRowSelected();
         
            //If the sale is already ringed
            if(Sale.isInvoiced()){
                DialogsFactory.getSingleton().showErrorOKCallbackDialog(baseJFrame, "errors_document_already_ringed", null);
                return;
            }
            
            DialogsFactory.getSingleton().showQuestionContinueDialog(baseJFrame, (JFrame jFrame) -> {
                
                try {
                    
                    //Ring the invoice                    
                    RepositoryFactory.getInstance().getSalessRepository().actualizaVentaTimbrado(Sale.getId(), String.valueOf(new Date().getTime()), String.valueOf(new Date().getTime()), String.valueOf(new Date().getTime()), String.valueOf(new Date().getTime()), String.valueOf(new Date().getTime()), String.valueOf(new Date().getTime()), String.valueOf(new Date().getTime()), String.valueOf(new Date().getTime()));                    
                    
                    //Reload all the records
                    jTab.initTableWithPagination();
                    
                    //Show success
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
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(VVtasViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(VVtasViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
}
