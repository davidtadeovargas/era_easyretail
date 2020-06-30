/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.easyretail.controllers.views;

import com.era.easyretail.enums.LoginType;
import com.era.logger.LoggerUtility;
import com.era.models.User;
import com.era.repositories.RepositoryFactory;
import com.era.utilities.UtilitiesFactory;
import com.era.views.LoginOtraJFrame;
import com.era.views.dialogs.DialogsFactory;
import com.era.views.dialogs.ErrorOKDialog;
import com.era.views.dialogs.OKDialog;
import java.awt.event.ActionEvent;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author PC
 */
public class LoginOtraViewController extends LoginOtraJFrame {
    
    private LoginType LoginType;
    
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

    @Override
    public void loadModelInFields(Object ObjectModel) throws  Exception {        
    }
    
    @Override
    public void clearFields() throws Exception{            
    }
    
    public void setLoginType(LoginType LoginType) {
        this.LoginType = LoginType;                
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
                return;
            }                        
            
            //Get the user from database
            final User User = (User) RepositoryFactory.getInstance().getUsersRepository().getByCode(user);                       
            
            dispose();
            
            if(this.LoginType == LoginType.DESLOGIN){
                
                //Deslog the user in system
                UtilitiesFactory.getSingleton().getSessionUtility().deslogUserSession();
                
                //Open the principal screen
                ViewControlersFactory.getSingleton().getPrincipViewController().setVisible();
            }
            else{
                
                //Register in system de logged user
                UtilitiesFactory.getSingleton().getSessionUtility().userInitSession(User);
                
                //Show the correct message login to the user
                final OKDialog OKDialog = DialogsFactory.getSingleton().getOKDialog(baseJFrame);
                OKDialog.setPropertyText("session_changed");
                OKDialog.setOKDialogInterface((JFrame jFrame) -> {
                    dispose();
                });
                OKDialog.show();
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
        
        if(this.LoginType == LoginType.DESLOGIN){
            System.exit(0);
        }
        else{
            this.dispose();            
        }                
    }
    
    @Override
    public List<?> getItemsToLoadInTable() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}