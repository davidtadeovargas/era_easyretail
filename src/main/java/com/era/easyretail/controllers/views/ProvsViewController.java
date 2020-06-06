/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.easyretail.controllers.views;

import com.era.logger.LoggerUtility;
import com.era.views.ProvsJFrame;
import com.era.views.dialogs.DialogsFactory;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class ProvsViewController extends ProvsJFrame {
    
    public ProvsViewController() {
        super("window_title_provs");
        
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
