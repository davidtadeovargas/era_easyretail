/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.easyretail.controllers.views;

import com.era.views.IngrPrevComJFrame;
import java.util.List;
import com.era.logger.LoggerUtility;
import com.era.views.dialogs.DialogsFactory;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author PC
 */
public class IngrPrevComViewController extends IngrPrevComJFrame {
    
    public IngrPrevComViewController() {
        super("window_title_prevcomp");
        
        try{
                     
            jBGuar.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBGuarActionPerformed(evt);
            });
            jBSal.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBSalActionPerformed(evt);
            });
            jBProd.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBProdActionPerformed(evt);
            });
            jBVeGran.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBVeGranActionPerformed(evt);
            });
            jBUltPre.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBUltPreActionPerformed(evt);
            });
            jBGranDescrip.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBGranDescripActionPerformed(evt);
            });
            jBUltCostT.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBUltCostTActionPerformed(evt);
            });
            jBExisAlma.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBExisAlmaActionPerformed(evt);
            });
            jBTipCam.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBTipCamActionPerformed(evt);
            });
            jBCarSer.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBCarSerActionPerformed(evt);
            });
            jBProv.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBProvActionPerformed(evt);
            });
            jButtonGenerarPDF.addActionListener((java.awt.event.ActionEvent evt) -> {
                jButtonGenerarPDFActionPerformed(evt);
            });
            jBNew.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBNewActionPerformed(evt);
            });
            jBDel.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBDelActionPerformed(evt);
            });
            
        }catch (Exception ex) {
            LoggerUtility.getSingleton().logError(IngrPrevComViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(IngrPrevComViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    @Override
    public void clearFields(){            
    }
    
    private void jBDelActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(IngrPrevComViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(IngrPrevComViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    private void jBNewActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(IngrPrevComViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(IngrPrevComViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    private void jButtonGenerarPDFActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(IngrPrevComViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(IngrPrevComViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    private void jBProvActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(IngrPrevComViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(IngrPrevComViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    private void jBCarSerActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(IngrPrevComViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(IngrPrevComViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    private void jBTipCamActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(IngrPrevComViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(IngrPrevComViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    private void jBExisAlmaActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(IngrPrevComViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(IngrPrevComViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    private void jBUltCostTActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(IngrPrevComViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(IngrPrevComViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    private void jBGranDescripActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(IngrPrevComViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(IngrPrevComViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    private void jBUltPreActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(IngrPrevComViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(IngrPrevComViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    private void jBVeGranActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(IngrPrevComViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(IngrPrevComViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    private void jBProdActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(IngrPrevComViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(IngrPrevComViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    private void jBSalActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(IngrPrevComViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(IngrPrevComViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    private void jBGuarActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(IngrPrevComViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(IngrPrevComViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
        
    @Override
    public List<?> getItemsToLoadInTable() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
