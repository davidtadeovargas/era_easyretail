/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.easyretail.controllers.views;

import com.era.logger.LoggerUtility;
import com.era.views.ProdsJFrame;
import com.era.views.dialogs.DialogsFactory;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class ProdsViewController extends ProdsJFrame {
    
    public ProdsViewController() {
        super("window_title_prods");
        
        try{
            
            jBProd.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBProdActionPerformed(evt);
            });
            jBConsecU.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBConsecUActionPerformed(evt);
            });
            jBGen.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBGenActionPerformed(evt);
            });
            jBTab1.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBTab1ActionPerformed(evt);
            });
            jBGuar.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBGuarActionPerformed(evt);
            });
            jBNew.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBNewActionPerformed(evt);
            });
            jBDel.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBDelActionPerformed(evt);
            });
            jBLim1.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBLim1ActionPerformed(evt);
            });
            jBLim.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBLimActionPerformed(evt);
            });
            jBSal.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBSalActionPerformed(evt);
            });
            jBPart.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBPartActionPerformed(evt);
            });
            jBCompa.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBCompaActionPerformed(evt);
            });
            jBMasSer.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBMasSerActionPerformed(evt);
            });
            button_impuestos.addActionListener((java.awt.event.ActionEvent evt) -> {
                button_impuestosActionPerformed(evt);
            });
            jBCargImg.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBCargImgActionPerformed(evt);
            });
            jBDelImg.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBDelImgActionPerformed(evt);
            });
            jBVeGran.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBVeGranActionPerformed(evt);
            });
            jBPrec.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBPrecActionPerformed(evt);
            });
            jBExisAlma.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBExisAlmaActionPerformed(evt);
            });
            jBCargF.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBCargFActionPerformed(evt);
            });
            jBDelF.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBDelFActionPerformed(evt);
            });
            jBFTec.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBFTecActionPerformed(evt);
            });
            jBComps.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBCompsActionPerformed(evt);
            });
            
        }catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ProdsViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(ProdsViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    @Override
    public void clearFields(){
    }
    
    private void jBProdActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ProdsViewController.class, ex);
            try {
                    DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                    Logger.getLogger(ProdsViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBConsecUActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ProdsViewController.class, ex);
            try {
                    DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                    Logger.getLogger(ProdsViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBGenActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ProdsViewController.class, ex);
            try {
                    DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                    Logger.getLogger(ProdsViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBTab1ActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ProdsViewController.class, ex);
            try {
                    DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                    Logger.getLogger(ProdsViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBGuarActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ProdsViewController.class, ex);
            try {
                    DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                    Logger.getLogger(ProdsViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBNewActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ProdsViewController.class, ex);
            try {
                    DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                    Logger.getLogger(ProdsViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBDelActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ProdsViewController.class, ex);
            try {
                    DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                    Logger.getLogger(ProdsViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBLim1ActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ProdsViewController.class, ex);
            try {
                    DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                    Logger.getLogger(ProdsViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBLimActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ProdsViewController.class, ex);
            try {
                    DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                    Logger.getLogger(ProdsViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBSalActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ProdsViewController.class, ex);
            try {
                    DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                    Logger.getLogger(ProdsViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBPartActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ProdsViewController.class, ex);
            try {
                    DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                    Logger.getLogger(ProdsViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBCompaActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ProdsViewController.class, ex);
            try {
                    DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                    Logger.getLogger(ProdsViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBMasSerActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ProdsViewController.class, ex);
            try {
                    DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                    Logger.getLogger(ProdsViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void button_impuestosActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ProdsViewController.class, ex);
            try {
                    DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                    Logger.getLogger(ProdsViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBCargImgActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ProdsViewController.class, ex);
            try {
                    DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                    Logger.getLogger(ProdsViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBDelImgActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ProdsViewController.class, ex);
            try {
                    DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                    Logger.getLogger(ProdsViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBVeGranActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ProdsViewController.class, ex);
            try {
                    DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                    Logger.getLogger(ProdsViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBPrecActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            ViewControlersFactory.getSingleton().getLPrecsViewController().setVisible();
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ProdsViewController.class, ex);
            try {
                    DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                    Logger.getLogger(ProdsViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBExisAlmaActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	    
            ViewControlersFactory.getSingleton().getProdExisAlmViewController().setVisible();
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ProdsViewController.class, ex);
            try {
                    DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                    Logger.getLogger(ProdsViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBCargFActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ProdsViewController.class, ex);
            try {
                    DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                    Logger.getLogger(ProdsViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBDelFActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ProdsViewController.class, ex);
            try {
                    DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                    Logger.getLogger(ProdsViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBFTecActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ProdsViewController.class, ex);
            try {
                    DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                    Logger.getLogger(ProdsViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBCompsActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ProdsViewController.class, ex);
            try {
                    DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                    Logger.getLogger(ProdsViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    
    @Override
    public List<?> getItemsToLoadInTable() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
