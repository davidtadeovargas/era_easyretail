/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.easyretail.controllers.views;

import com.era.logger.LoggerUtility;
import com.era.views.SalidaEntradaJFrame;
import com.era.views.dialogs.DialogsFactory;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class SalidaEntradaViewController extends SalidaEntradaJFrame {
 
    public SalidaEntradaViewController() {
        super("window_title_salidaentrada");
        
        try{
            
            jBtnAceptar.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBtnAceptarActionPerformed(evt);
            });
            jBtnSalir.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBtnSalirActionPerformed(evt);
            });
            jBtnConcepto.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBtnConceptoActionPerformed(evt);
            });
            jBtnBusProducto.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBtnBusProductoActionPerformed(evt);
            });
            jBtnActivo.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBtnActivoActionPerformed(evt);
            });
            btnBorrar.addActionListener((java.awt.event.ActionEvent evt) -> {
                btnBorrarActionPerformed(evt);
            });
            btnAgregar.addActionListener((java.awt.event.ActionEvent evt) -> {
                btnAgregarActionPerformed(evt);
            });
            
        }catch (Exception ex) {
            LoggerUtility.getSingleton().logError(SalidaEntradaViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(SalidaEntradaViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    @Override
    public void clearFields(){
    }
    
    private void jBtnActivoActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
         
            
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(SalidaEntradaViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(SalidaEntradaViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
         
            
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(SalidaEntradaViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(SalidaEntradaViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
         
            
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(SalidaEntradaViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(SalidaEntradaViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBtnBusProductoActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
         
            
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(SalidaEntradaViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(SalidaEntradaViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBtnConceptoActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
         
            
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(SalidaEntradaViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(SalidaEntradaViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBtnSalirActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
         
            
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(SalidaEntradaViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(SalidaEntradaViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBtnAceptarActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
         
            
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(SalidaEntradaViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(SalidaEntradaViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    @Override
    public List<?> getItemsToLoadInTable() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
