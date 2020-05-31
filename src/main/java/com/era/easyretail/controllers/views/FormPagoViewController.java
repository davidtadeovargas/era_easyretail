/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.easyretail.controllers.views;

import com.era.views.FormPagoJFrame;
import java.util.List;
import com.era.logger.LoggerUtility;
import com.era.views.dialogs.DialogsFactory;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author PC
 */
public class FormPagoViewController extends FormPagoJFrame {
    
    public FormPagoViewController() {
        super("window_title_formpag");
        
        try{
                     
            jBCliente.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBClienteActionPerformed(evt);
            });
            jBSal.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBSalActionPerformed(evt);
            });
            jBAbon.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBAbonActionPerformed(evt);
            });
            jButton2.addActionListener((java.awt.event.ActionEvent evt) -> {
                jButton2ActionPerformed(evt);
            });
            jButton1.addActionListener((java.awt.event.ActionEvent evt) -> {
                jButton1ActionPerformed(evt);
            });
            jBFormPag.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBFormPagActionPerformed(evt);
            });
            jBConcep.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBConcepActionPerformed(evt);
            });
            jBBancos.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBBancosActionPerformed(evt);
            });
            
        }catch (Exception ex) {
            LoggerUtility.getSingleton().logError(FormPagoViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(FormPagoViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    private void jBClienteActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(FormPagoViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(FormPagoViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBSalActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(FormPagoViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(FormPagoViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBAbonActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(FormPagoViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(FormPagoViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(FormPagoViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(FormPagoViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(FormPagoViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(FormPagoViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBFormPagActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(FormPagoViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(FormPagoViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBConcepActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(FormPagoViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(FormPagoViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBBancosActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(FormPagoViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(FormPagoViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    @Override
    public List<?> getItemsToLoadInTable() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
