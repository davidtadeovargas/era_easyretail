/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.easyretail.controllers.views;

import com.era.logger.LoggerUtility;
import com.era.views.EntradasSalidasJFrame;
import com.era.views.dialogs.DialogsFactory;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class EntradasSalidasViewController extends EntradasSalidasJFrame {
 
    public EntradasSalidasViewController() {
        super("window_title_entsals");
        
        try{
            
            btnEntrada.addActionListener((java.awt.event.ActionEvent evt) -> {
                btnEntradaActionPerformed(evt);
            });
            btnSalida.addActionListener((java.awt.event.ActionEvent evt) -> {
                btnSalidaActionPerformed(evt);
            });
            btnEditar.addActionListener((java.awt.event.ActionEvent evt) -> {
                btnEditarActionPerformed(evt);
            });
            btnEliminar.addActionListener((java.awt.event.ActionEvent evt) -> {
                btnEliminarActionPerformed(evt);
            });
            btnVer.addActionListener((java.awt.event.ActionEvent evt) -> {
                btnVerActionPerformed(evt);
            });
            btnGenerarPdf.addActionListener((java.awt.event.ActionEvent evt) -> {
                btnGenerarPdfActionPerformed(evt);
            });
            btnVerPdf.addActionListener((java.awt.event.ActionEvent evt) -> {
                btnVerPdfActionPerformed(evt);
            });
            btnSalir.addActionListener((java.awt.event.ActionEvent evt) -> {
                btnSalirActionPerformed(evt);
            });
            btnMostrar.addActionListener((java.awt.event.ActionEvent evt) -> {
                btnMostrarActionPerformed(evt);
            });
            btnBuscar.addActionListener((java.awt.event.ActionEvent evt) -> {
                btnBuscarActionPerformed(evt);
            });
            
        }catch (Exception ex) {
            LoggerUtility.getSingleton().logError(EntradasSalidasViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(EntradasSalidasViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    @Override
    public void loadModelInFields(Object ObjectModel) throws  Exception {        
    }
    
    @Override
    public void clearFields(){            
    }
    
    private void btnEntradaActionPerformed(java.awt.event.ActionEvent evt) {

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(EntradasSalidasViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(EntradasSalidasViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void btnSalidaActionPerformed(java.awt.event.ActionEvent evt) {

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(EntradasSalidasViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(EntradasSalidasViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(EntradasSalidasViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(EntradasSalidasViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(EntradasSalidasViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(EntradasSalidasViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void btnVerActionPerformed(java.awt.event.ActionEvent evt) {

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(EntradasSalidasViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(EntradasSalidasViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void btnGenerarPdfActionPerformed(java.awt.event.ActionEvent evt) {

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(EntradasSalidasViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(EntradasSalidasViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void btnVerPdfActionPerformed(java.awt.event.ActionEvent evt) {

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(EntradasSalidasViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(EntradasSalidasViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(EntradasSalidasViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(EntradasSalidasViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void btnMostrarActionPerformed(java.awt.event.ActionEvent evt) {

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(EntradasSalidasViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(EntradasSalidasViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(EntradasSalidasViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(EntradasSalidasViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void ActionPerformed(java.awt.event.ActionEvent evt) {

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(EntradasSalidasViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(EntradasSalidasViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    @Override
    public List<?> getItemsToLoadInTable() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
