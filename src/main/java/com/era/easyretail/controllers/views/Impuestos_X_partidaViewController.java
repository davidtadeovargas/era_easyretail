/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.easyretail.controllers.views;

import com.era.views.Impuestos_X_partidaJFrame;
import java.util.List;
import com.era.logger.LoggerUtility;
import com.era.models.Tax;
import com.era.views.dialogs.DialogsFactory;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author PC
 */
public class Impuestos_X_partidaViewController extends Impuestos_X_partidaJFrame {

    public Impuestos_X_partidaViewController() {
        super("window_title_impxpartida");
        
        try{

            this.disposeButton(jBNew);
            
            boton_borrar.addActionListener((java.awt.event.ActionEvent evt) -> {
                boton_borrarActionPerformed(evt);
            });
                
        }catch (Exception ex) {
            LoggerUtility.getSingleton().logError(Impuestos_X_partidaViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(Impuestos_X_partidaViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    @Override
    public void loadModelInFields(Object ObjectModel) throws  Exception {        
    }
    
    @Override
    public void clearFields() throws Exception{            
    }
    
    private void boton_borrarActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(Impuestos_X_partidaViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(Impuestos_X_partidaViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }

    @Override
    public List<?> getItemsToLoadInTable() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
