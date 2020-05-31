/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.easyretail.controllers.views;

import com.era.logger.LoggerUtility;
import com.era.views.ProdExisAlmJFrame;
import com.era.views.dialogs.DialogsFactory;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class ProdExisAlmViewController extends ProdExisAlmJFrame {
    
    public ProdExisAlmViewController() {
        super("window_title_exisalma");
        
        try{
            
            jBSal.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBSalActionPerformed(evt);
            });            
            
        }catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ProdExisAlmViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(ProdExisAlmViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }

    private void jBSalActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
	}
	catch (Exception ex) {
		LoggerUtility.getSingleton().logError(PrincipViewController.class, ex);
		try {
			DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
		} catch (Exception ex1) {
			Logger.getLogger(PrincipViewController.class.getName()).log(Level.SEVERE, null, ex1);
		}
	}
    }
    
    @Override
    public List<?> getItemsToLoadInTable() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
