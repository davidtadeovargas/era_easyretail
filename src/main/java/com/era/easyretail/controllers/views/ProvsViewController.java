/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.easyretail.controllers.views;

import com.era.logger.LoggerUtility;
import com.era.models.Supplier;
import com.era.repositories.RepositoryFactory;
import com.era.views.ProvsJFrame;
import com.era.views.dialogs.DialogsFactory;
import com.era.views.tables.headers.TableHeaderFactory;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author PC
 */
public class ProvsViewController extends ProvsJFrame {
    
    public ProvsViewController() {
        super("window_title_provs");
        
        try{
         
            jBNew.grabFocus();

            this.disposeButton(jBSal);

            jBDel.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBDelActionPerformed(evt);
            });
            jBAbr.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBAbrActionPerformed(evt);
            });
            jBNew.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBNewActionPerformed(evt);
            });
            jBBusc.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBBuscActionPerformed(evt);
            });
            jBMosT.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBMosTActionPerformed(evt);
            });

            //Connect table
            this.BaseJTable = jTab;

            //Get all the customers and load them in table            
            this.BaseJTable.addShowColumn(TableHeaderFactory.getSigleton().getSuppliersTableHeader().getROWNUMBER());
            this.BaseJTable.addShowColumn(TableHeaderFactory.getSigleton().getSuppliersTableHeader().getCODE());
            this.BaseJTable.addShowColumn(TableHeaderFactory.getSigleton().getSuppliersTableHeader().getNAME());
            this.BaseJTable.addShowColumn(TableHeaderFactory.getSigleton().getSuppliersTableHeader().getRFC());
            this.BaseJTable.loadAllItemsInTable();

        }catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ProvsViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(ClientsViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    @Override
    public void loadModelInFields(Object ObjectModel) throws  Exception {        
    }
    
    @Override
    public void clearFields(){
    }
    
    @Override
    public List<?> getItemsToLoadInTable() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private void jBDelActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
            //First select a model
            if(!jTab.isRowSelected()){
                DialogsFactory.getSingleton().showErrorOKNoSelectionCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                    jTab.requestFocus();
                });
                return;
            }
            
            //Get the selected model
            final Supplier Supplier = (Supplier)jTab.getRowSelected();
            
            
            //Validate that the supplier doesnt have any purchase related
                        
            
            //Question if continue
            DialogsFactory.getSingleton().showQuestionContinueDialog(baseJFrame, (JFrame jFrame) -> {
                
                try{
                    
                    //Delete the customer
                    RepositoryFactory.getInstance().getSuppliersRepository().delete(Supplier);
                    
                    //Reload the table
                    BaseJTable.loadAllItemsInTable();
                    
                    //Announce to the user
                    DialogsFactory.getSingleton().showOKOperationCompletedCallbackDialog(jFrame, null);
                    
                }catch (Exception ex) {
                    LoggerUtility.getSingleton().logError(ClientsViewController.class, ex);
                    try {
                            DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
                    } catch (Exception ex1) {
                            Logger.getLogger(ClientsViewController.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                }
            });
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ProvsViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(ProvsViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBAbrActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
            //First select a model
            if(!jTab.isRowSelected()){
                DialogsFactory.getSingleton().showErrorOKNoSelectionCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                    jTab.requestFocus();
                });
                return;
            }
            
            //Get the selected model
            final Supplier Supplier = (Supplier)jTab.getRowSelected();
            
            //Open the supplier window to see the supplier information
            final ProvViewController ProvViewController = ViewControlersFactory.getSingleton().getProvViewController();
            ProvViewController.setSupplierGlobal(Supplier);
            ProvViewController.setVisible();
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ProvsViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(ProvsViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBNewActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            ViewControlersFactory.getSingleton().getProvViewController().setVisible();
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ProvsViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(ProvsViewController.class.getName()).log(Level.SEVERE, null, ex1);
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
            LoggerUtility.getSingleton().logError(ProvsViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(ProvsViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBMosTActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
         
            //Load all the customers
            this.jTab.loadAllItemsInTable();
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ProvsViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(ProvsViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
}
