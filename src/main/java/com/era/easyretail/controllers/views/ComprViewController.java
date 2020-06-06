/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.easyretail.controllers.views;

import com.era.logger.LoggerUtility;
import com.era.views.ComprJFrame;
import com.era.views.dialogs.DialogsFactory;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class ComprViewController extends ComprJFrame {
    
    public ComprViewController() {
        super("window_title_newcomp");
        
        try{
         
            //Post inicialization
            postInitComponents();

            javax.swing.ButtonGroup bG = new javax.swing.ButtonGroup();
            bG.add(jRComp);
            bG.add(jROrd);
            bG.add(jRTod);

            jBNew.grabFocus();
            
            this.disposeButton(jBSal);
            
            jBCan.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBCanActionPerformed(evt);
            });
            jBDev.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBDevActionPerformed(evt);
            });
            jBDevPar.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBDevParActionPerformed(evt);
            });
            jBNew.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBNewActionPerformed(evt);
            });
            jButtonAbrir1.addActionListener((java.awt.event.ActionEvent evt) -> {
                jButtonAbrir1ActionPerformed(evt);
            });
            jBNotC.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBNotCActionPerformed(evt);
            });
            jBVe.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBVeActionPerformed(evt);
            });
            jBVer.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBVerActionPerformed(evt);
            });
            jBCarg.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBCargActionPerformed(evt);
            });
            jBDel.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBDelActionPerformed(evt);
            });
            jBActua.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBActuaActionPerformed(evt);
            });
            jBImp.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBImpActionPerformed(evt);
            });
            jBVePDF.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBVePDActionPerformed(evt);
            });
            jBDirOr.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBDirOrGenPDFActionPerformed(evt);
            });
            jBRecOr.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBRecOrActionPerformed(evt);
            });
            jBMostT.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBMostTActionPerformed(evt);
            });
            jBBusc.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBBuscActionPerformed(evt);
            });
            
        }catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ComprViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(ComprViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    @Override
    public void loadModelInFields(Object ObjectModel) throws  Exception {        
    }
    
    @Override
    public void clearFields(){            
    }
    
    private void jBCanActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ComprViewController.class, ex);
            try {
                    DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                    Logger.getLogger(ComprViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    private void jBDevActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ComprViewController.class, ex);
            try {
                    DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                    Logger.getLogger(ComprViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    private void jBDevParActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            ViewControlersFactory.getSingleton().getDevPComViewController().setVisible();
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ComprViewController.class, ex);
            try {
                    DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                    Logger.getLogger(ComprViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    private void jBNewActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            ViewControlersFactory.getSingleton().getIngrComViewController().setVisible();
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ComprViewController.class, ex);
            try {
                    DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                    Logger.getLogger(ComprViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    private void jButtonAbrir1ActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            ViewControlersFactory.getSingleton().getIngrComViewController().setVisible();
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ComprViewController.class, ex);
            try {
                    DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                    Logger.getLogger(ComprViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    private void jBNotCActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            ViewControlersFactory.getSingleton().getNewNotProvViewController().setVisible();
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ComprViewController.class, ex);
            try {
                    DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                    Logger.getLogger(ComprViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    private void jBVeActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            ViewControlersFactory.getSingleton().getVCompViewController().setVisible();
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ComprViewController.class, ex);
            try {
                    DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                    Logger.getLogger(ComprViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    private void jBVerActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ComprViewController.class, ex);
            try {
                    DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                    Logger.getLogger(ComprViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    private void jBCargActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ComprViewController.class, ex);
            try {
                    DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                    Logger.getLogger(ComprViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    private void jBDelActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ComprViewController.class, ex);
            try {
                    DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                    Logger.getLogger(ComprViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    private void jBActuaActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ComprViewController.class, ex);
            try {
                    DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                    Logger.getLogger(ComprViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    private void jBImpActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ComprViewController.class, ex);
            try {
                    DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                    Logger.getLogger(ComprViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    private void jBVePDActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ComprViewController.class, ex);
            try {
                    DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                    Logger.getLogger(ComprViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    private void jBDirOrGenPDFActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ComprViewController.class, ex);
            try {
                    DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                    Logger.getLogger(ComprViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    private void jBRecOrActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            ViewControlersFactory.getSingleton().getRecibOrdViewController().setVisible();
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ComprViewController.class, ex);
            try {
                    DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                    Logger.getLogger(ComprViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    private void jBMostTActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ComprViewController.class, ex);
            try {
                    DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                    Logger.getLogger(ComprViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    private void ActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ComprViewController.class, ex);
            try {
                    DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                    Logger.getLogger(ComprViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    private void jBBuscActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ComprViewController.class, ex);
            try {
                    DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                    Logger.getLogger(ComprViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    @Override
    public List<?> getItemsToLoadInTable() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
