/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.easyretail.controllers.views;

import com.era.views.ConfGralJFrame;
import java.util.List;
import com.era.logger.LoggerUtility;
import com.era.views.dialogs.DialogsFactory;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author PC
 */
public class ConfGralViewController extends ConfGralJFrame {
    
    public ConfGralViewController() {
        super("window_title_confgral");
        
        try{
                     
            jBAlma.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBAlmaActionPerformed(evt);
            });
            jBAlmaCot.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBAlmaCotActionPerformed(evt);
            });
            jBAlmaVta.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBAlmaVtaActionPerformed(evt);
            });
            jBApFav.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBApFavActionPerformed(evt);
            });
            jBBuscCum.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBBuscCumActionPerformed(evt);
            });
            jBCXC1.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBCXC1ActionPerformed(evt);
            });
            jBCXC2.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBCXC2ActionPerformed(evt);
            });
            jBCXC3.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBCXC3ActionPerformed(evt);
            });
            jBCalc.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBCalcActionPerformed(evt);
            });
            jBCargAgra.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBCargAgraActionPerformed(evt);
            });
            jBCargCum.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBCargCumActionPerformed(evt);
            });
            jBCuade.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBCuadeActionPerformed(evt);
            });
            jBDelAgra.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBDelAgraActionPerformed(evt);
            });
            jBDelCXC1.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBDelCXC1ActionPerformed(evt);
            });
            jBDelCXC2.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBDelCXC2ActionPerformed(evt);
            });
            jBDelCXC3.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBDelCXC3ActionPerformed(evt);
            });
            jBDelCum.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBDelCumActionPerformed(evt);
            });
            jBGuar.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBGuarActionPerformed(evt);
            });
            jBMaxMin.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBMaxMinActionPerformed(evt);
            });
            jBNoMaxMin.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBNoMaxMinActionPerformed(evt);
            });
            jBSal.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBSalActionPerformed(evt);
            });
            jBTBajCost.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBTBajCostActionPerformed(evt);
            });
            jBTNoBajCost.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBTNoBajCostActionPerformed(evt);
            });
            jBUsrAgra.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBUsrAgraActionPerformed(evt);
            });
            jBUsrCump.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBUsrCumpActionPerformed(evt);
            });
            jBVerAgra.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBVerAgraActionPerformed(evt);
            });
            jBVerCXC1.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBVerCXC1ActionPerformed(evt);
            });
            jBVerCXC2.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBVerCXC2ActionPerformed(evt);
            });
            jBVerCXC3.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBVerCXC3ActionPerformed(evt);
            });
            jButton1.addActionListener((java.awt.event.ActionEvent evt) -> {
                jButton1ActionPerformed(evt);
            });
            
        }catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ConfGralViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(ConfGralViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ConfGralViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(ConfGralViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBVerCXC3ActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ConfGralViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(ConfGralViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBVerCXC2ActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ConfGralViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(ConfGralViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBVerCXC1ActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ConfGralViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(ConfGralViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBVerAgraActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ConfGralViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(ConfGralViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBUsrCumpActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ConfGralViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(ConfGralViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBUsrAgraActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ConfGralViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(ConfGralViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBTNoBajCostActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ConfGralViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(ConfGralViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBTBajCostActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ConfGralViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(ConfGralViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBSalActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ConfGralViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(ConfGralViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBNoMaxMinActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ConfGralViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(ConfGralViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBMaxMinActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ConfGralViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(ConfGralViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBGuarActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ConfGralViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(ConfGralViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBDelCumActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ConfGralViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(ConfGralViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBDelCXC3ActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ConfGralViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(ConfGralViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBDelCXC2ActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ConfGralViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(ConfGralViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBDelCXC1ActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ConfGralViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(ConfGralViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBDelAgraActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ConfGralViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(ConfGralViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBCuadeActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ConfGralViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(ConfGralViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBCargCumActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ConfGralViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(ConfGralViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBCargAgraActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ConfGralViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(ConfGralViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBCalcActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ConfGralViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(ConfGralViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBCXC3ActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ConfGralViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(ConfGralViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBCXC2ActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ConfGralViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(ConfGralViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBCXC1ActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ConfGralViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(ConfGralViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBBuscCumActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ConfGralViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(ConfGralViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBApFavActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ConfGralViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(ConfGralViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void ActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ConfGralViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(ConfGralViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBAlmaVtaActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ConfGralViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(ConfGralViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBAlmaCotActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ConfGralViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(ConfGralViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBAlmaActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ConfGralViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(ConfGralViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
            
    @Override
    public List<?> getItemsToLoadInTable() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
