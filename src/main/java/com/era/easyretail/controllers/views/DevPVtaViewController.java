/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.easyretail.controllers.views;

import com.era.logger.LoggerUtility;
import com.era.views.DevPVtaJFrame;
import com.era.views.dialogs.DialogsFactory;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class DevPVtaViewController extends DevPVtaJFrame {

    public DevPVtaViewController(){
        super("window_title_devptovta");
        
        try{
            
            jBSal.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBSalActionPerformed(evt);
            });
            jBGuar.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBGuarActionPerformed(evt);
            });            
            
        }catch (Exception ex) {
            LoggerUtility.getSingleton().logError(DevPVtaViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(DevPVtaViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    @Override
    public void clearFields(){            
    }
    
    private void jBGuarActionPerformed(java.awt.event.ActionEvent evt) {

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ActivosViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(ActivosViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBSalActionPerformed(java.awt.event.ActionEvent evt) {

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ActivosViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(ActivosViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    @Override
    public List<?> getItemsToLoadInTable() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}