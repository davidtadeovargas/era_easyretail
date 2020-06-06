/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.easyretail.controllers.views;

import com.era.logger.LoggerUtility;
import com.era.views.TraspasJFrame;
import com.era.views.dialogs.DialogsFactory;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class TraspasViewController extends TraspasJFrame{
    
    public TraspasViewController() {
        super("window_title_trapas");
        
        try{
            
            jBProd.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBProdActionPerformed(evt);
            });
            jBExisAlma.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBExisAlmaActionPerformed(evt);
            });
            jBExisAlma1.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBExisAlma1ActionPerformed(evt);
            });
            jBConcep.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBConcepActionPerformed(evt);
            });
            btnUsuario.addActionListener((java.awt.event.ActionEvent evt) -> {
                btnUsuarioActionPerformed(evt);
            });
            jBconfirmar.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBconfirmarActionPerformed(evt);
            });
            jBTransfe.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBTransfeActionPerformed(evt);
            });
            jBSal.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBSalActionPerformed(evt);
            });
            jButton1.addActionListener((java.awt.event.ActionEvent evt) -> {
                jButton1ActionPerformed(evt);
            });
            jBBusc.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBBuscActionPerformed(evt);
            });
            jBMosTod.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBPrec1ActionPerformed(evt);
            });
            jBMosTod.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBMosTodActionPerformed(evt);
            });
            
        }catch (Exception ex) {
            LoggerUtility.getSingleton().logError(TraspasViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(TraspasViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    @Override
    public void loadModelInFields(Object ObjectModel) throws  Exception {        
    }
    
    private void jBPrec1ActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(TraspasViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(TraspasViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    @Override
    public void clearFields(){
    }
    
    private void jBMosTodActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(TraspasViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(TraspasViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBBuscActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(TraspasViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(TraspasViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(TraspasViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(TraspasViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBSalActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(TraspasViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(TraspasViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBTransfeActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(TraspasViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(TraspasViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBconfirmarActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(TraspasViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(TraspasViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void btnUsuarioActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(TraspasViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(TraspasViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBConcepActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(TraspasViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(TraspasViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBExisAlma1ActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(TraspasViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(TraspasViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBExisAlmaActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(TraspasViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(TraspasViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBProdActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(TraspasViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(TraspasViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    @Override
    public List<?> getItemsToLoadInTable() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
