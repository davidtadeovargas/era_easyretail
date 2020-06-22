/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.easyretail.controllers.views;

import com.era.views.IngrInventJFrame;
import java.util.List;
import com.era.logger.LoggerUtility;
import com.era.views.dialogs.DialogsFactory;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author PC
 */
public class IngrInventViewController extends IngrInventJFrame
{
    public IngrInventViewController() {
        super("window_title_inginven");
        
        try{
                     
            jButtonSalir.addActionListener((java.awt.event.ActionEvent evt) -> {
                jButtonSalirActionPerformed(evt);
            });
            jBNew.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBNewActionPerformed(evt);
            });
            jButtonProducto.addActionListener((java.awt.event.ActionEvent evt) -> {
                jButtonProductoActionPerformed(evt);
            });
            jButtonBuscarConceptos.addActionListener((java.awt.event.ActionEvent evt) -> {
                jButtonBuscarConceptosActionPerformed(evt);
            });
            jBTab1.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBTab1ActionPerformed(evt);
            });
            jBPrec.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBPrecActionPerformed(evt);
            });
            jBExisAlma.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBExisAlmaActionPerformed(evt);
            });
            jBCarSer.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBCarSerActionPerformed(evt);
            });
            jBtnReferencia.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBtnReferenciaActionPerformed(evt);
            });
            jButtonQuitar.addActionListener((java.awt.event.ActionEvent evt) -> {
                jButtonQuitarActionPerformed(evt);
            });
            jButtonAceptar.addActionListener((java.awt.event.ActionEvent evt) -> {
                jButtonAceptarActionPerformed(evt);
            });
            
        }catch (Exception ex) {
            LoggerUtility.getSingleton().logError(IngrInventViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(IngrInventViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }

    @Override
    public void clearFields() throws Exception{            
    }
    
    @Override
    public void loadModelInFields(Object ObjectModel) throws  Exception {        
    }
    
    private void jButtonQuitarActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(IngrInventViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(IngrInventViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBtnReferenciaActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(IngrInventViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(IngrInventViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBCarSerActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(IngrInventViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(IngrInventViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBExisAlmaActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(IngrInventViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(IngrInventViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBPrecActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(IngrInventViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(IngrInventViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBTab1ActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(IngrInventViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(IngrInventViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jButtonBuscarConceptosActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(IngrInventViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(IngrInventViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jButtonProductoActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(IngrInventViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(IngrInventViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBNewActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(IngrInventViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(IngrInventViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(IngrInventViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(IngrInventViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jButtonAceptarActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(IngrInventViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(IngrInventViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    @Override
    public List<?> getItemsToLoadInTable() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
