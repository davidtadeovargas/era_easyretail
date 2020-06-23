/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.easyretail.controllers.views;

import com.era.views.SeriesJFrame;
import java.util.List;
import com.era.logger.LoggerUtility;
import com.era.models.DocumentOrigin;
import com.era.models.Serie;
import com.era.repositories.RepositoryFactory;
import com.era.views.dialogs.DialogsFactory;
import com.era.views.tables.headers.TableHeaderFactory;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.event.ListSelectionEvent;
/**
 *
 * @author PC
 */
public class SeriesViewController extends SeriesJFrame {
    
    public SeriesViewController() {
        super("window_title_series");
        
        try{
                     
            jBDel.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBDelActionPerformed(evt);
            });
            jBNew.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBNewActionPerformed(evt);
            });
            jBBusc.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBBuscActionPerformed(evt);
            });
            jBMostT.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBMostTActionPerformed(evt);
            });
            
            this.JComponentUtils.onKeyTypedToMayus(jTSer);
            this.JComponentUtils.onKeyTypedToMayus(jTDescrip);
            
            this.disposeButton(jBSal);
            
            cmbTipoDocumento.setChangeSelectionListener((Object ObjectModel) -> {
                
                //Cast the model
                final DocumentOrigin DocumentOrigin = (DocumentOrigin)ObjectModel;
                
                tipdocdescripJTextField.setText(DocumentOrigin.getName());
            });
            cmbTipoDocumento.loadItems();
            
            this.JComponentUtils.onlyNumbers(jTConsec);
            
            //Config table
            this.BaseJTable = jTab;
            jTab.addShowColumn(TableHeaderFactory.getSigleton().getSeriesTableHeader().getROWNUMBER());
            jTab.addShowColumn(TableHeaderFactory.getSigleton().getSeriesTableHeader().getTYPE());
            jTab.addShowColumn(TableHeaderFactory.getSigleton().getSeriesTableHeader().getDESCRIPTION());
            jTab.addShowColumn(TableHeaderFactory.getSigleton().getSeriesTableHeader().getCONSECUTIVE());
            jTab.setITableRowSelected((ListSelectionEvent lse, Object Object) -> {
                
                try {
                    
                    //Cast model
                    final Serie Serie = (Serie)Object;
                    
                    loadModelInFields(Serie);
                    
                } catch (Exception ex) {
                    LoggerUtility.getSingleton().logError(this.getClass(), ex);
                    try {
                        DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
                    } catch (Exception ex1) {
                        Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex1);
                    }
                }
            });
            
            //Load all
            jTab.loadAllItemsInTable();
            
        }catch (Exception ex) {
            LoggerUtility.getSingleton().logError(SeriesViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(SeriesViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    @Override
    public void clearFields() throws Exception{
        
        cmbTipoDocumento.clearSelection();
        jTSer.setText("");
        jTConsec.setText("1");
        jTDescrip.setText("");
        jTab.clearSelection();        
    }
    
    @Override
    public void loadModelInFields(Object ObjectModel) throws  Exception {
        
        //Cast model
        final Serie Serie = (Serie)ObjectModel;
        
        //Clear fields
        jTSer.setText("");
        jTConsec.setText("");
        jTDescrip.setText("");
        
        //Get the document type
        final DocumentOrigin DocumentOrigin = (DocumentOrigin)RepositoryFactory.getInstance().getDocumentOriginRepository().getDocumentByType(Serie.getType());
        
        //Load values
        cmbTipoDocumento.selectByObject(DocumentOrigin);
        jTSer.setText(Serie.getSer());
        jTConsec.setText(String.valueOf(Serie.getConsecutive()));
        jTDescrip.setText(Serie.getDescription());
    }
    
   private void jBMostTActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{
            this.jTab.loadAllItemsInTable();
            
            this.clearFields();
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
            
            //First select a document type
            final DocumentOrigin DocumentOrigin = (DocumentOrigin)cmbTipoDocumento.getSelectedObject();
            if(DocumentOrigin.getType().isEmpty()){
                DialogsFactory.getSingleton().showErrorOKNoSelectionCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                    cmbTipoDocumento.grabFocus();
                });
                return;
            }
            
            //Type first a serie
            final String serie = jTSer.getText().trim().replace(" ", "");
            if(serie.isEmpty()){
                DialogsFactory.getSingleton().showOKEmptyFieldCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                    jTSer.grabFocus();
                });
                return;
            }
            
            //Check that the serie doesnt exists
            final Serie Serie = (Serie)RepositoryFactory.getInstance().getSerieRepository().getBySerie(serie);
            if(Serie!=null){
                DialogsFactory.getSingleton().showErrorRecordExistsOKDialog(baseJFrame, (JFrame jFrame1) -> {
                    jTSer.grabFocus();
                });
                return;
            }
            
            //Check that the description is defined
            final String description = jTDescrip.getText().trim();
            if(description.isEmpty()){
                DialogsFactory.getSingleton().showOKEmptyFieldCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                    jTDescrip.grabFocus();
                });
                return;
            }
            
            DialogsFactory.getSingleton().showQuestionContinueDialog(baseJFrame, (JFrame jFrame) -> {
                
                try {
                    
                    //Get the consec
                    final int consec = Integer.valueOf(jTConsec.getText().trim());
                    
                    //Create the model
                    final Serie Serie_ = new Serie();
                    Serie_.setType(DocumentOrigin.getType());
                    Serie_.setCode("");
                    Serie_.setSer(serie);
                    Serie_.setDescription(description);
                    Serie_.setConsecutive(consec);
                    
                    //Save in db
                    RepositoryFactory.getInstance().getSerieRepository().save(Serie_);
                    
                    //Reload table
                    jTab.loadAllItemsInTable();
                    
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
            if(!jTab.isRowSelected()){
                DialogsFactory.getSingleton().showErrorOKNoSelectionCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                    jTab.grabFocus();
                });
                return;
            }
            
            DialogsFactory.getSingleton().showQuestionContinueDialog(baseJFrame, (JFrame jFrame) -> {
                
                try {
                    
                    //Get the selected object
                    final Serie Serie = (Serie)jTab.getRowSelected();
                    
                    //Delete in db                                        
                    RepositoryFactory.getInstance().getSerieRepository().delete(Serie);
                    
                    //Reload table
                    jTab.loadAllItemsInTable();
                    
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
