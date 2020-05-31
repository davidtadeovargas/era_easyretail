/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.easyretail.controllers.views;

import com.era.logger.LoggerUtility;
import com.era.views.ProvJFrame;
import com.era.views.dialogs.DialogsFactory;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class ProvViewController extends ProvJFrame {

    public ProvViewController(){
        
        super("window_title_supplier");
        
        try{
            
            jBGuar.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBGuarActionPerformed(evt);
            });
            jBSal.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBSalActionPerformed(evt);
            });
            jBClas.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBClasActionPerformed(evt);
            });
            jBRub.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBRubActionPerformed(evt);
            });
            jBGir.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBGirActionPerformed(evt);
            });
            jBZon.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBZonActionPerformed(evt);
            });
            
            
        }catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ProvViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(ProvViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }            
    
    private void jBGuarActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
	}
	catch (Exception ex) {
		LoggerUtility.getSingleton().logError(ProvViewController.class, ex);
		try {
                    DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
		} catch (Exception ex1) {
                    Logger.getLogger(ProvViewController.class.getName()).log(Level.SEVERE, null, ex1);
		}
	}
    }
    
    private void jBSalActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
	}
	catch (Exception ex) {
		LoggerUtility.getSingleton().logError(ProvViewController.class, ex);
		try {
                    DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
		} catch (Exception ex1) {
                    Logger.getLogger(ProvViewController.class.getName()).log(Level.SEVERE, null, ex1);
		}
	}
    }
    
    private void jBClasActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
	}
	catch (Exception ex) {
		LoggerUtility.getSingleton().logError(ProvViewController.class, ex);
		try {
                    DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
		} catch (Exception ex1) {
                    Logger.getLogger(ProvViewController.class.getName()).log(Level.SEVERE, null, ex1);
		}
	}
    }
    
    private void jBRubActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
	}
	catch (Exception ex) {
		LoggerUtility.getSingleton().logError(ProvViewController.class, ex);
		try {
                    DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
		} catch (Exception ex1) {
                    Logger.getLogger(ProvViewController.class.getName()).log(Level.SEVERE, null, ex1);
		}
	}
    }
    
    private void jBGirActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
	}
	catch (Exception ex) {
		LoggerUtility.getSingleton().logError(ProvViewController.class, ex);
		try {
                    DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
		} catch (Exception ex1) {
                    Logger.getLogger(ProvViewController.class.getName()).log(Level.SEVERE, null, ex1);
		}
	}
    }
    
    private void jBZonActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
	}
	catch (Exception ex) {
		LoggerUtility.getSingleton().logError(ProvViewController.class, ex);
		try {
                    DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
		} catch (Exception ex1) {
                    Logger.getLogger(ProvViewController.class.getName()).log(Level.SEVERE, null, ex1);
		}
	}
    }
    
    @Override
    public List<?> getItemsToLoadInTable() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
