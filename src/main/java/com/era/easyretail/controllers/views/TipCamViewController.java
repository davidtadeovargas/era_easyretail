/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.easyretail.controllers.views;

import com.era.logger.LoggerUtility;
import com.era.views.TipCamJFrame;
import com.era.views.dialogs.DialogsFactory;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.util.List;

/**
 *
 * @author PC
 */
public class TipCamViewController extends TipCamJFrame {
       
    private OnResult OnResult;
    
    public TipCamViewController() {
        super("window_title_tipcam");
        
        try{
                     
            buttonAcept.addActionListener((java.awt.event.ActionEvent evt) -> {
                buttonAceptActionPerformed(evt);
            });

            this.JComponentUtils.onlyDecimals(valueTextField);            
            
            this.disposeButton(buttonCancel);
            
        }catch (Exception ex) {
            LoggerUtility.getSingleton().logError(TipCamViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(TipCamViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }

    public void setOnResult(OnResult OnResult) {
        this.OnResult = OnResult;
    }
        
    private void buttonAceptActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
         
            final String tipCam = valueTextField.getText().trim();
            
            final double tipCamDouble = Double.valueOf(tipCam);
            
            if(OnResult!=null){
                OnResult.onResult(tipCamDouble);
            }
            
            dispose();
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(TipCamViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(TipCamViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    final public void setTipCam(final double timCam){
        valueTextField.setText(String.valueOf(timCam));
    }
    
    @Override
    public void loadModelInFields(Object ObjectModel) throws  Exception {        
    }
    
    @Override
    public void clearFields(){            
    }
    
    @Override
    public List<?> getItemsToLoadInTable() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public interface OnResult{
        public void onResult(double tipCam);
    }
}
