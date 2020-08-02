/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.easyretail.controllers.views;

import com.era.logger.LoggerUtility;
import com.era.models.Product;
import com.era.repositories.RepositoryFactory;
import com.era.views.ProductsListJFrame;
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
public class ProductsListViewController extends ProductsListJFrame {
            
    public ProductsListViewController() {
        super("window_title_prods");
        
        try{
            
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
            jBMostT.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBMostTActionPerformed(evt);
            });
            
            jBNew.grabFocus();
            
            //Connect table
            this.BaseJTable = jTab;
            
            //Get all the customers and load them in table            
            this.BaseJTable.addShowColumn(TableHeaderFactory.getSigleton().getProductsTableHeader().getROWNUMBER());
            this.BaseJTable.addShowColumn(TableHeaderFactory.getSigleton().getProductsTableHeader().getCODE());
            this.BaseJTable.addShowColumn(TableHeaderFactory.getSigleton().getProductsTableHeader().getDESCRIPTION());
            this.BaseJTable.addShowColumn(TableHeaderFactory.getSigleton().getProductsTableHeader().getINFORMATION());
            this.BaseJTable.initTableWithPagination();
                        
        }catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ProductsListViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(ProductsListViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    @Override
    public void loadModelInFields(Object ObjectModel) throws  Exception {        
    }
    
    @Override
    public void clearFields() throws Exception{            
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
            LoggerUtility.getSingleton().logError(ProductsListViewController.class, ex);
            try {
                    DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                    Logger.getLogger(ProductsListViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBMostTActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
            //Load all the customers
            this.jTab.loadAllItemsInTable();
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ProductsListViewController.class, ex);
            try {
                    DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                    Logger.getLogger(ProductsListViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    
    private void jBDelActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
    
            //First select a customer
            if(!jTab.isRowSelected()){
                DialogsFactory.getSingleton().showErrorOKNoSelectionCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                    jTab.requestFocus();
                });
                return;
            }
            
            //Get the selected model
            final Product Product = (Product)jTab.getRowSelected();
            
            //Question if continue
            DialogsFactory.getSingleton().showQuestionContinueDialog(baseJFrame, (JFrame jFrame) -> {
                
                try{
                    
                    //Delete the product from the database
                    RepositoryFactory.getInstance().getProductsRepository().deleteProductByCode(Product.getCode());
                    
                    //Reload the table
                    jTab.initTableWithPagination();
                    
                    //Annoucne the user of the success
                    DialogsFactory.getSingleton().showOKOperationCompletedCallbackDialog(jFrame, null);
                    
                }catch (Exception ex) {
                    LoggerUtility.getSingleton().logError(ProductsListViewController.class, ex);
                    try {
                            DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
                    } catch (Exception ex1) {
                            Logger.getLogger(ProductsListViewController.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                }
            });
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ProductsListViewController.class, ex);
            try {
                    DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                    Logger.getLogger(ProductsListViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBAbrActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
            //First select a customer
            if(!jTab.isRowSelected()){
                DialogsFactory.getSingleton().showErrorOKNoSelectionCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                    jTab.requestFocus();
                });
                return;
            }
            
            //Get the selected model
            final Product Product_ = (Product)jTab.getRowSelected();
                        
            //Show product window
            final ProdsViewController ProdsViewController = ViewControlersFactory.getSingleton().getProdsViewController();
            ProdsViewController.setProduct_(Product_.getCode());
            ProdsViewController.setVisible();
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ProductsListViewController.class, ex);
            try {
                    DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                    Logger.getLogger(ProductsListViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBNewActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
            //Show product window
            final ProdsViewController ProdsViewController = ViewControlersFactory.getSingleton().getProdsViewController();            
            ProdsViewController.setVisible();
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ProductsListViewController.class, ex);
            try {
                    DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                    Logger.getLogger(ProductsListViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    @Override
    public List<?> getItemsToLoadInTable() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
