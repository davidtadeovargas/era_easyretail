/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.easyretail.controllers.views;

import com.era.logger.LoggerUtility;
import com.era.models.Product;
import com.era.repositories.RepositoryFactory;
import com.era.views.BajsMinJFrame;
import com.era.views.dialogs.DialogsFactory;
import com.era.views.tables.headers.TableHeaderFactory;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class BajsMinViewController extends BajsMinJFrame {
    
    public BajsMinViewController() {
        super("window_title_prodsbajmin");
        
        try{
            
            jTBusc.grabFocus();
            
            jBActua.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBActuaActionPerformed(evt);
            });
            jBMosT.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBMosTActionPerformed(evt);
            });
            jBBusc.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBBuscActionPerformed(evt);
            });
            
            this.disposeButton(jBSal);
            
            //Init table
            this.BaseJTable = jTab;
            jTab.addShowColumn(TableHeaderFactory.getSigleton().getProductsTableHeader().getROWNUMBER());
            jTab.addShowColumn(TableHeaderFactory.getSigleton().getProductsTableHeader().getCODE());
            jTab.addShowColumn(TableHeaderFactory.getSigleton().getProductsTableHeader().getDESCRIPTION());
            jTab.addShowColumn(TableHeaderFactory.getSigleton().getProductsTableHeader().getMINIMUN());
            jTab.addShowColumn(TableHeaderFactory.getSigleton().getProductsTableHeader().getGENERAL_EXISTENCE());
            
            //Load all the items in the table
            getItemsToLoadInTable();
            
        }catch (Exception ex) {
            LoggerUtility.getSingleton().logError(BajsMinViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(BajsMinViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
        
    
    @Override
    public void loadModelInFields(Object ObjectModel) throws  Exception {        
    }
    
    @Override
    public void clearFields(){            
    }
    
    private void jBActuaActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
            //Get all the products under minimun
            final List<Product> products = RepositoryFactory.getInstance().getExistalmasRepository().getAllProductsBajMin();
            
            //Realod all the table
            this.jTab.initTable(products);
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(BajsMinViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(BajsMinViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBMosTActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
            //Load all the items in the table
            getItemsToLoadInTable();
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(BajsMinViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(BajsMinViewController.class.getName()).log(Level.SEVERE, null, ex1);
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
            final List<Product> items = RepositoryFactory.getInstance().getExistalmasRepository().getAllProductsBajMinLikeFilter(search);
            this.jTab.initTable(items);
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(BajsMinViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(BajsMinViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    @Override
    public List<?> getItemsToLoadInTable() throws Exception {
        
        //Load all the items in the table
        final List<Product> products = RepositoryFactory.getInstance().getExistalmasRepository().getAllProductsBajMin();                        
        this.jTab.initTable(products);
        
        return products;
    }
}
