/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.easyretail.controllers.views;

import com.era.logger.LoggerUtility;
import com.era.models.User;
import com.era.repositories.RepositoryFactory;
import com.era.utilities.UtilitiesFactory;
import com.era.views.LoginOtraJFrame;
import com.era.views.dialogs.DialogsFactory;
import com.era.views.dialogs.ErrorOKDialog;
import java.awt.event.ActionEvent;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class LoginOtraViewController extends LoginOtraJFrame {
    
    private OnResult OnResult;
    private OnExitButton OnExitButton;    
    
    public LoginOtraViewController(){
        
        super("window_title_login");
        
        try{
            
            //Default button
            this.setDefaultButton(jBIng);
            
            jTUsr.grabFocus();
            
            jBIng.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBIngActionPerformed(evt);
            });
            jBSal.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBSalActionPerformed(evt);
            });
            
            jCMostC.addActionListener((ActionEvent e) -> {
                onShowPasswordClicked(e);
            });
                        
        }catch (Exception ex) {
            LoggerUtility.getSingleton().logError(LoginOtraViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(LoginOtraViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }

    public void deslogUser() throws Exception {
        
        //Deslog the user in system
        UtilitiesFactory.getSingleton().getSessionUtility().deslogUserSession();
    }
    
    public void setOnExitButton(OnExitButton OnExitButton) {
        this.OnExitButton = OnExitButton;
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
    
    private void jBIngActionPerformed(java.awt.event.ActionEvent evt) {                                             
        
        try{
            
            final String user = jTUsr.getText().trim();
            if(user.compareTo("")==0)
            {
                final ErrorOKDialog ErrorOKDialog = DialogsFactory.getSingleton().getErrorOKDialog(baseJFrame);
                ErrorOKDialog.setPropertyText("empty_fields");
                ErrorOKDialog.show();
                jTUsr.grabFocus();
                return;
            }

            final String password = new String(jPContra.getPassword());            
            if(password.compareTo("")==0)
            {
                final ErrorOKDialog ErrorOKDialog = DialogsFactory.getSingleton().getErrorOKDialog(baseJFrame);
                ErrorOKDialog.setPropertyText("empty_fields");
                ErrorOKDialog.show();
                jPContra.grabFocus();
                return;
            }            

            final boolean userExists = RepositoryFactory.getInstance().getUsersRepository().userExists(user);            
            if(!userExists){
                final ErrorOKDialog ErrorOKDialog = DialogsFactory.getSingleton().getErrorOKDialog(baseJFrame);
                ErrorOKDialog.setPropertyText("errors_user_not_exists");
                ErrorOKDialog.show();
                jTUsr.grabFocus();
                return;
            }
            
            final String decryptedPassword = RepositoryFactory.getInstance().getUsersRepository().getDecryptedUserPassword(user);
            if(password.compareTo(decryptedPassword)!=0){
                final ErrorOKDialog ErrorOKDialog = DialogsFactory.getSingleton().getErrorOKDialog(baseJFrame);
                ErrorOKDialog.setPropertyText("errors_invalid_password");
                ErrorOKDialog.show();
                jPContra.grabFocus();
                
                //If the user defined response callback
                if(OnResult!=null){
                    OnResult.onInvalidLogin();
                }

                return;
            }                        
            
            //Get the user from database
            final User User = (User) RepositoryFactory.getInstance().getUsersRepository().getByCode(user);                       

            //Deslog the user in system if apply
            UtilitiesFactory.getSingleton().getSessionUtility().deslogUserSession();
            
            //Register in the system the user login
            UtilitiesFactory.getSingleton().getSessionUtility().userInitSession(User);
            
            //Close the window
            dispose();
            
            //If the user defined response callback
            if(OnResult!=null){
                OnResult.onCorrectLogin();
            }
            
        }catch (Exception ex) {
            LoggerUtility.getSingleton().logError(LoginOtraViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(LoginOtraViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    private void onShowPasswordClicked(ActionEvent ActionEvent){
        showOrHidePassword();
    }
    
    public interface OnResult{
        public void onCorrectLogin();
        public void onInvalidLogin();
    }
    
    public interface OnExitButton{
        public void onExit();        
    }
    
    private void showOrHidePassword(){
        
        //Show ot hide the password
        if(jCMostC.isSelected()){
            if(JComponentUtils.F2EventFired()){
                jCMostC.setSelected(false);
            }            
            jPContra.setEchoChar((char)0);
        }
        else{
            if(JComponentUtils.F2EventFired()){
                jCMostC.setSelected(true);
            }
            jPContra.setEchoChar('*');            
        }
    }
    
    private void jBSalActionPerformed(java.awt.event.ActionEvent evt) {
        
        //Close current window
        this.dispose();
        
        //User callback
        if(OnExitButton!=null){
            OnExitButton.onExit();
        }
    }
    
    @Override
    public List<?> getItemsToLoadInTable() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}