/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.easyretail.controllers.views;

import com.era.logger.LoggerUtility;
import com.era.views.IngrComJFrame;
import com.era.views.dialogs.DialogsFactory;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class IngrComViewController extends IngrComJFrame {

    public IngrComViewController() {
        super("window_title_ingcomp");
        
        try{
            
            jBGuar.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBGuarActionPerformed(evt);
            });
            jBSal.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBSalActionPerformed(evt);
            });
            jBProv.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBProvActionPerformed(evt);
            });
            jBGranDescrip.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBGranDescripActionPerformed(evt);
            });
            jBExisAlma.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBExisAlmaActionPerformed(evt);
            });
            jBCarg.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBCargActionPerformed(evt);
            });
            jBLimp.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBLimpActionPerformed(evt);
            });
            jBCuentaCont.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBCuentaContActionPerformed(evt);
            });
            jBtnReferencia1.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBtnReferencia1ActionPerformed(evt);
            });
            jBCarSer.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBCarSerActionPerformed(evt);
            });
            jBNew.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBNewActionPerformed(evt);
            });
            jBDel.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBDelActionPerformed(evt);
            });
            
        }catch (Exception ex) {
            LoggerUtility.getSingleton().logError(IngrComViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(IngrComViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    @Override
    public void clearFields() throws Exception{            
    }
    
    @Override
    public void loadModelInFields(Object ObjectModel) throws  Exception {        
    }
    
    private void jBGuarActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(IngrComViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(IngrComViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBSalActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(IngrComViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(IngrComViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBProvActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(IngrComViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(IngrComViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBGranDescripActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(IngrComViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(IngrComViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBExisAlmaActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(IngrComViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(IngrComViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBCargActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(IngrComViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(IngrComViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBLimpActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(IngrComViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(IngrComViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBCuentaContActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(IngrComViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(IngrComViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBtnReferencia1ActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(IngrComViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(IngrComViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBCarSerActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(IngrComViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(IngrComViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBVeGranActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(IngrComViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(IngrComViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBNewActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(IngrComViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(IngrComViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBDelActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(IngrComViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(IngrComViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    @Override
    public List<?> getItemsToLoadInTable() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
