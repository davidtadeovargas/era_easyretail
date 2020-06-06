/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.easyretail.controllers.views;

import com.era.logger.LoggerUtility;
import com.era.views.VCompJFrame;
import com.era.views.dialogs.DialogsFactory;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class VCompViewController extends VCompJFrame {
 
    public VCompViewController() {
        super("window_title_vercomps");
        
        try{
            
            jBSal.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBSalActionPerformed(evt);
            });
            jButton1.addActionListener((java.awt.event.ActionEvent evt) -> {
                jButton1ActionPerformed(evt);
            });
            
        }catch (Exception ex) {
            LoggerUtility.getSingleton().logError(VCompViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(VCompViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    @Override
    public void clearFields(){
    }
    
    @Override
    public void loadModelInFields(Object ObjectModel) throws  Exception {        
    }
    
    private void jBSalActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(VCompViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(VCompViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(VCompViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(VCompViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    @Override
    public List<?> getItemsToLoadInTable() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
