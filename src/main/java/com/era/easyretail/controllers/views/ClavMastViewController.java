/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.easyretail.controllers.views;

import com.era.views.ClavMastJFrame;
import java.util.List;
import com.era.logger.LoggerUtility;
import com.era.repositories.RepositoryFactory;
import com.era.views.dialogs.DialogsFactory;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author PC
 */
public class ClavMastViewController extends ClavMastJFrame {
 
    private OnResult OnResult;
    
    
    public ClavMastViewController() {
        super("window_title_adminpassword");
        
        try{
                                 
            jBGuar.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBGuarActionPerformed(evt);
            });
            
            this.disposeButton(jBSal);
            
        }catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ClavMastViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(ClavMastViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }

    public void setOnResult(OnResult OnResult) {
        this.OnResult = OnResult;
    }
    
    @Override
    public void loadModelInFields(Object ObjectModel) throws  Exception {        
    }
    
    @Override
    public void clearFields() throws Exception{            
    }
    
    private void jBGuarActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{
            
            //If the user has not enter a user stop
            final String user = jTEsta.getText().trim();
            if(user.isEmpty()){
                DialogsFactory.getSingleton().showOKEmptyFieldCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                   jTEsta.grabFocus();
                });
                return;
            }
            
            //If the user has not enter a user stop
            final String password = new String(jPClav.getPassword());
            if(password.isEmpty()){
                DialogsFactory.getSingleton().showOKEmptyFieldCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                   jPClav.grabFocus();
                });
                return;
            }
            
            dispose();
            
            //Check if is valid admin user
            final boolean adminValid = RepositoryFactory.getInstance().getUsersRepository().isValidAdminUser(user, password);
            if(adminValid){
                if(this.OnResult!=null){
                    this.OnResult.onValidAdminUser();
                }
            }
            else{
                
                if(this.OnResult!=null){
                    this.OnResult.onInvalidAdminUser();
                }
            }
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ClavMastViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(ClavMastViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    public interface OnResult{
        public void onValidAdminUser();
        public void onInvalidAdminUser();
    }
    
    @Override
    public List<?> getItemsToLoadInTable() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
