/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.easyretail.controllers.views;

import com.era.views.ReportsJFrame;
import java.util.List;
import com.era.logger.LoggerUtility;
import com.era.views.dialogs.DialogsFactory;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author PC
 */
public class ReportsViewController extends ReportsJFrame {
    
    public ReportsViewController(){
     
        super("window_title_general_reports");
        
        try{
                     
            jBSal.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBSalActionPerformed(evt);
            });
            generateButton.addActionListener((java.awt.event.ActionEvent evt) -> {
                generateButtonActionPerformed(evt);
            });
            
        }catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ReportsViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(ReportsViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }    

    @Override
    public void loadModelInFields(Object ObjectModel) throws  Exception {        
    }
    
    @Override
    public void clearFields(){
    }
    
    private void generateButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
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
    
    private void jBSalActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
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
