/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.easyretail.controllers.views;

import com.era.logger.LoggerUtility;
import com.era.views.DescripGranJFrame;
import com.era.views.dialogs.DialogsFactory;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class DescripGranViewController extends DescripGranJFrame {
            
    public DescripGranViewController() {
        super("window_title_acerd");
        
        try{
                              
            jTAInfo.grabFocus();
            
            this.JComponentUtils.setDisposeInEscapeEvent(true);
            
        }catch (Exception ex) {
            LoggerUtility.getSingleton().logError(DescripGranViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(DescripGranViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        
    }
    
    public void setText(final String text){
        
        jTAInfo.setText(text);
        jTAInfo.setCaretPosition(0);
    }
    
    @Override
    public void loadModelInFields(Object ObjectModel) throws  Exception {        
    }
    
    @Override
    public void clearFields() throws Exception{            
    }
    
    @Override
    public List<?> getItemsToLoadInTable() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
