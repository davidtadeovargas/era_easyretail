/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.easyretail.controllers.views;

import com.era.logger.LoggerUtility;
import com.era.views.PrevCompJFrame;
import com.era.views.dialogs.DialogsFactory;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class PrevCompViewController extends PrevCompJFrame {
    
    public PrevCompViewController() {
        super("window_title_prevcomp");
        
        try{
            
            jBNew.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBNewActionPerformed(evt);
            });
            jBAbr.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBAbrActionPerformed(evt);
            });
            jBVer.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBVerActionPerformed(evt);
            });
            jBCan.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBCanActionPerformed(evt);
            });
            jBActua.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBActuaActionPerformed(evt);
            });
            jBPDF.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBPDFActionPerformed(evt);
            });
            jBDirCots.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBDirCotsActionPerformed(evt);
            });
            jBVta.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBVtaActionPerformed(evt);
            });
            jBSal.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBSalActionPerformed(evt);
            });
            jBPonSer.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBPonSerActionPerformed(evt);
            });
            jBMosT.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBMosTActionPerformed(evt);
            });
            jBBusc.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBBuscActionPerformed(evt);
            });
            
        }catch (Exception ex) {
            LoggerUtility.getSingleton().logError(PrevCompViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(PrevCompViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    private void jBNewActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
         
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(PrevCompViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(PrevCompViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBAbrActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
         
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(PrevCompViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(PrevCompViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBVerActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
         
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(PrevCompViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(PrevCompViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBCanActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
         
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(PrevCompViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(PrevCompViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBActuaActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
         
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(PrevCompViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(PrevCompViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBPDFActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
         
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(PrevCompViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(PrevCompViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBGenPDFActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
         
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(PrevCompViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(PrevCompViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBDirCotsActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
         
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(PrevCompViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(PrevCompViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBVtaActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
         
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(PrevCompViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(PrevCompViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBSalActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
         
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(PrevCompViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(PrevCompViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBPonSerActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
         
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(PrevCompViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(PrevCompViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBMosTActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
         
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(PrevCompViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(PrevCompViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBBuscActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
         
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(PrevCompViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(PrevCompViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    @Override
    public List<?> getItemsToLoadInTable() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
