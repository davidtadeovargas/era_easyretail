/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.easyretail.controllers.views;

import com.era.views.ImpsJFrame;
import java.util.List;
import com.era.logger.LoggerUtility;
import com.era.models.Tax;
import com.era.repositories.RepositoryFactory;
import com.era.views.dialogs.DialogsFactory;
import com.era.views.tables.BaseJTable.ITableRowSelected;
import com.era.views.tables.headers.TableHeaderFactory;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.event.ListSelectionEvent;
/**
 *
 * @author PC
 */
public class ImpsViewController extends ImpsJFrame {
    
    public ImpsViewController() {
        super("window_title_imps");
        
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
            jBActua.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBActuaActionPerformed(evt);
            });
            
            this.disposeButton(jBSal);
            
            //Config table
            this.BaseJTable = jTab;
            jTab.addShowColumn(TableHeaderFactory.getSigleton().getTaxsTableHeader().getROWNUMBER());
            jTab.addShowColumn(TableHeaderFactory.getSigleton().getTaxsTableHeader().getCODE());
            jTab.addShowColumn(TableHeaderFactory.getSigleton().getTaxsTableHeader().getVALUE());
            jTab.addShowColumn(TableHeaderFactory.getSigleton().getTaxsTableHeader().getXMLTAX());
            
            //When the table is selected
            jTab.setITableRowSelected((ListSelectionEvent lse, Object Object) -> {
                
                try {
                 
                    //Cast the model
                    final Tax Tax = (Tax)Object;

                    //Clear all fields
                    clearFields();

                    //The user code can not change for editing
                    campo_impuesto.setEditable(false);

                    //Load all the user information in fields
                    loadModelInFields(Tax);
                    
                } catch (Exception ex) {
                    LoggerUtility.getSingleton().logError(ImpsViewController.class, ex);
                    try {
                        DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
                    } catch (Exception ex1) {
                        Logger.getLogger(ImpsViewController.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                }
            });
            
            //Load all the taxes
            jTab.loadAllItemsInTable();
           
            this.JComponentUtils.onlyDecimals(jTVal);
            
            //Lad all the xml taxes
            
        }catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ImpsViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(ImpsViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    @Override
    public void clearFields() throws Exception{
        
        campo_impuesto.setText("");
        jTVal.setText("");
        
        campo_impuesto.setEditable(true);
    }
    
    @Override
    public void loadModelInFields(Object ObjectModel) throws  Exception {
        
        //Cast the model
        final Tax Tax = (Tax)ObjectModel;
        
        campo_impuesto.setText(Tax.getCode());
        jTVal.setText(String.valueOf(Tax.getValue()));
    }
    
    private void saveOrUpdate(final boolean save) {
        
        try {
         
            //Code before continue
            final String taxCode = campo_impuesto.getText().trim();
            if(taxCode.isEmpty()){
                DialogsFactory.getSingleton().showOKEmptyFieldCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                    campo_impuesto.requestFocus();
                });
                return;
            }
            
            //If new tax
            if(save){
                //Check if the tax already exists
                final Tax Tax = (Tax)RepositoryFactory.getInstance().getTaxesRepository().getByCode(taxCode);
                if(Tax!=null){
                    DialogsFactory.getSingleton().showErrorRecordExistsOKDialog(baseJFrame, (JFrame jFrame1) -> {
                        campo_impuesto.requestFocus();
                    });
                    return;
                }
            }
            
            //Question if continue
            DialogsFactory.getSingleton().showQuestionContinueDialog(baseJFrame, (JFrame jFrame) -> {
                
                try {                    
               
                    //Get the tax value
                    final double value = Double.valueOf(jTVal.getText().trim());
                    
                    //Create the model
                    final Tax Tax_ = new Tax();
                    Tax_.setCode(taxCode);
                    Tax_.setValue(value);                    
                    
                    //Save or update
                    RepositoryFactory.getInstance().getTaxesRepository().saveOrUpdate(Tax_);
                    
                    //Reload table
                    jTab.loadAllItemsInTable();
                    
                    //Success
                    DialogsFactory.getSingleton().showOKOperationCompletedCallbackDialog(jFrame, (JFrame jFrame1) -> {
                    });
                    
                } catch (Exception ex) {
                    LoggerUtility.getSingleton().logError(ImpsViewController.class, ex);
                    try {
                        DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
                    } catch (Exception ex1) {
                        Logger.getLogger(ImpsViewController.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                }
            });
            
        } catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ImpsViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(ImpsViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    private void jBActuaActionPerformed(java.awt.event.ActionEvent evt) {
	saveOrUpdate(false);
    }
    
    private void jBMostTActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            //Load all the items
            this.jTab.loadAllItemsInTable();
            
            //Clear
            clearFields();
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ImpsViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(ImpsViewController.class.getName()).log(Level.SEVERE, null, ex1);
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
            LoggerUtility.getSingleton().logError(ImpsViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(ImpsViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBNewActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            this.saveOrUpdate(true);
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ImpsViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(ImpsViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBDelActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
            //Select before continue            
            if(!jTab.isRowSelected()){
                DialogsFactory.getSingleton().showOKEmptyFieldCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                    jTab.requestFocus();
                });
                return;
            }
            
            //Question if continue
            DialogsFactory.getSingleton().showQuestionContinueDialog(baseJFrame, (JFrame jFrame) -> {
                
                try {                    
               
                    //Get the selected object
                    final Tax Tax = (Tax)jTab.getRowSelected();
                                        
                    //Remove from the database
                    RepositoryFactory.getInstance().getTaxesRepository().delete(Tax);
                    
                    //Remove from table
                    jTab.deleteObject(Tax);
                    
                    //Success
                    DialogsFactory.getSingleton().showOKOperationCompletedCallbackDialog(jFrame, (JFrame jFrame1) -> {
                    });
                    
                } catch (Exception ex) {
                    LoggerUtility.getSingleton().logError(ImpsViewController.class, ex);
                    try {
                        DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
                    } catch (Exception ex1) {
                        Logger.getLogger(ImpsViewController.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                }
            });
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ImpsViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(ImpsViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    @Override
    public List<?> getItemsToLoadInTable() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
