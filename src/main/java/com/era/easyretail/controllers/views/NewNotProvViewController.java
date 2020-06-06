/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.easyretail.controllers.views;

import com.era.logger.LoggerUtility;
import com.era.views.NewNotProvJFrame;
import com.era.views.dialogs.DialogsFactory;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class NewNotProvViewController extends NewNotProvJFrame {
   
    public NewNotProvViewController() {
        super("window_title_newnotprov");
        
        try{
            
            jBProv.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBProvActionPerformed(evt);
            });
            jBFilt.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBFiltActionPerformed(evt);
            });
            jBConcep.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBConcepActionPerformed(evt);
            });
            jBVePart.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBVePartActionPerformed(evt);
            });
            jBNew.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBNewActionPerformed(evt);
            });
            jBDel.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBDelActionPerformed(evt);
            });
            jBGuar.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBGuarActionPerformed(evt);
            });
            jBSal.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBSalActionPerformed(evt);
            });
            
        }catch (Exception ex) {
            LoggerUtility.getSingleton().logError(NewNotProvViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(NewNotProvViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    @Override
    public void loadModelInFields(Object ObjectModel) throws  Exception {        
    }
    
    @Override
    public void clearFields(){
    }
    
    private void jBProvActionPerformed(java.awt.event.ActionEvent evt) {

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(NewNotProvViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(NewNotProvViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBFiltActionPerformed(java.awt.event.ActionEvent evt) {

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(NewNotProvViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(NewNotProvViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBConcepActionPerformed(java.awt.event.ActionEvent evt) {

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(NewNotProvViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(NewNotProvViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBVePartActionPerformed(java.awt.event.ActionEvent evt) {

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(NewNotProvViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(NewNotProvViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBNewActionPerformed(java.awt.event.ActionEvent evt) {

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(NewNotProvViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(NewNotProvViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBDelActionPerformed(java.awt.event.ActionEvent evt) {

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(NewNotProvViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(NewNotProvViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBGuarActionPerformed(java.awt.event.ActionEvent evt) {

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(NewNotProvViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(NewNotProvViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBSalActionPerformed(java.awt.event.ActionEvent evt) {

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(NewNotProvViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(NewNotProvViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    @Override
    public List<?> getItemsToLoadInTable() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
