/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.easyretail.controllers.views;

import com.era.logger.LoggerUtility;
import com.era.models.Kits;
import com.era.models.Product;
import com.era.repositories.RepositoryFactory;
import com.era.views.KitsJFrame;
import com.era.views.dialogs.DialogsFactory;
import com.era.views.tables.headers.TableHeaderFactory;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class KitsViewController extends KitsJFrame {
    
    public KitsViewController() {
        super("window_title_kits");
        
        try{
            
            jBAbr.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBAbrActionPerformed(evt);
            });
            jBBusc.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBBuscActionPerformed(evt);
            });
            jBMostT.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBMostTActionPerformed(evt);
            });
            
            this.disposeButton(jBSal);
            
            //Config the table            
            this.BaseJTable = jTab;
            jTab.addShowColumn(TableHeaderFactory.getSigleton().getProductsTableHeader().getROWNUMBER());
            jTab.addShowColumn(TableHeaderFactory.getSigleton().getProductsTableHeader().getCODE());
            jTab.addShowColumn(TableHeaderFactory.getSigleton().getProductsTableHeader().getDESCRIPTION());
            jTab.addShowColumn(TableHeaderFactory.getSigleton().getProductsTableHeader().getINFORMATION());
            jTab.addShowColumn(TableHeaderFactory.getSigleton().getProductsTableHeader().getKEYSAT());
            
            //Get all the kits
            final List<Product> kits = RepositoryFactory.getInstance().getProductsRepository().getAllKits();
            
            //Load all the kits
            jTab.initTable(kits);
            
        }catch (Exception ex) {
            LoggerUtility.getSingleton().logError(KitsViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(KitsViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    @Override
    public void clearFields() throws Exception{            
    }
    
    @Override
    public void loadModelInFields(Object ObjectModel) throws  Exception {        
    }
    
    private void jBAbrActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{
            
            //First select an object from table
            if(!jTab.isRowSelected()){
                DialogsFactory.getSingleton().showErrorOKNoSelectionCallbackDialog(baseJFrame, null);
                return;
            }
            
            //Get selected object
            final Product Product = (Product)jTab.getRowSelected();
            
            //Get all the kits
            final List<Kits> kits = RepositoryFactory.getInstance().getKitssRepository().getComponentsByKit(Product.getCode());
            
            //Open the kits screen            
            final CompsViewController CompsViewController = ViewControlersFactory.getSingleton().getCompsViewController();            
            CompsViewController.initOnlyForView(kits, Product.getCode(), Product.getDescription());
            CompsViewController.setVisible();
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(KitsViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(KitsViewController.class.getName()).log(Level.SEVERE, null, ex1);
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
            LoggerUtility.getSingleton().logError(KitsViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(KitsViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBMostTActionPerformed(java.awt.event.ActionEvent evt) {

	try{
            
            //Load all the records again
            this.jTab.loadAllItemsInTable();
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(KitsViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(KitsViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    @Override
    public List<?> getItemsToLoadInTable() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
