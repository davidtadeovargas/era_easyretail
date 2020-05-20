/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.easyretail.controllers.views;

import com.era.datamodels.enums.SearchCommonTypeEnum;
import com.era.easyretail.enums.LoginTypeEmpresa;
import com.era.logger.LoggerUtility;
import com.era.models.BasDats;
import com.era.models.User;
import com.era.repositories.RepositoryFactory;
import com.era.repositories.utils.HibernateUtil;
import com.era.utilities.UtilitiesFactory;
import com.era.views.LoginJFrame;
import com.era.views.dialogs.DialogsFactory;
import com.era.views.dialogs.ExceptionDialog;
import com.era.views.dialogs.OKDialog;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author PC
 */
public class LoginViewController extends LoginJFrame {
    
    private String companyCode;        
    private boolean alreadyDBConfig;
    
    private LoginTypeEmpresa LoginTypeEmpresa;
    
    //Contiene el contador de intentos de ingreso al sistema
    int iContEnt = 0;
    
    
    
    
    public LoginViewController(){
        
        try{                        
                                
            setDefaultButton(jbuttonLogin);
            
            jTEmp.grabFocus();
                                 
            JBCreaEmpresa.addActionListener((ActionEvent e) -> {
                buttonEmpresaClicked(e);
            });
                    
            jbuttonLogin.addActionListener((ActionEvent e) -> {
                buttonLoginClicked(e);
            });
            jbuttonExit.addActionListener((ActionEvent e) -> {
                buttonExitClicked(e);                
            });
            
            JComponentUtils.setEscapeEvent(() -> {
                jbuttonExit.doClick();
            });            
            
            JComponentUtils.setF2Event(() -> {
                //Show ot hide the password
                showOrHidePassword();                
            });            
            
            jCMostC.addActionListener((ActionEvent e) -> {
                onShowPasswordClicked(e);
            });
            
            jBEmp.addActionListener((ActionEvent e) -> {
                onSearchComapnyCliced(e);
            });
            
            //Only mayus for the user
            JComponentUtils.onKeyTypedToMayus(jTEmp);
            
            JComponentUtils.limitTextPasswordField(jPContra,30);
            
            JComponentUtils.interceptWindowClosingToButton(jbuttonExit);
                        
        }catch(Exception e){
            
            LoggerUtility.getSingleton().logError(LoginViewController.class, e);
                                        
            try {
                final ExceptionDialog ExceptionDialog = DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, e);
                ExceptionDialog.show();
            } catch (Exception ex) {
                Logger.getLogger(LoginViewController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void setLoginTypeEmpresa(LoginTypeEmpresa LoginTypeEmpresa) {
        this.LoginTypeEmpresa = LoginTypeEmpresa;
    }
            
    private void onSearchComapnyCliced(ActionEvent ActionEvent){
        
        try{
            
            final SearchViewController SearchViewController = new SearchViewController();
            SearchViewController.setSEARCH_TYPE(SearchCommonTypeEnum.BASDATS);
            SearchViewController.setButtonAceptClicked(() -> {

                companyCode = SearchViewController.getCod();
                final String companyName = SearchViewController.getDescrip();

                jTEmp.setText(companyName);
            });
            SearchViewController.setVisible();
            
        }catch(Exception e){
            
            LoggerUtility.getSingleton().logError(LoginViewController.class, e);
                                        
            try {
                final ExceptionDialog ExceptionDialog = DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, e);
                ExceptionDialog.show();
            } catch (Exception ex) {
                Logger.getLogger(LoginViewController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
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
    
    private void onShowPasswordClicked(ActionEvent ActionEvent){
        showOrHidePassword();
    }

    private void onCreateCopanyButtonClicked(ActionEvent ActionEvent){
        
        // TODO add your handling code here:
        /*frmEmpresas empresas = new frmEmpresas();
        empresas.setModalExclusionType(Dialog.ModalExclusionType.NO_EXCLUDE);
        empresas.setVisible(true);*/
    }
    
    //JBCreaEmpresa
    private void buttonEmpresaClicked(ActionEvent e){
        
        try{
            
            ViewControlersFactory.getSingleton().getEmpresasViewController().setVisible();
            
        }catch(Exception ex){
            
            try {
                
                LoggerUtility.getSingleton().logError(LoginViewController.class, ex);
                
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
                
            } catch (Exception ex1) {
                Logger.getLogger(LoginViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    private void buttonLoginClicked(ActionEvent e){
        
        try{
            
            if(jTEmp.getText().compareTo("")==0){

                JOptionPane.showMessageDialog(null, "La empresa esta vacia.", "Empresa", JOptionPane.INFORMATION_MESSAGE, null);
                jBEmp.grabFocus();
                return;
            }

            //Check if a valid company 
            if(companyCode.compareTo("")==0){

                JOptionPane.showMessageDialog(null, "La empresa: " + jTEmp.getText() + " no existe.", "Empresa", JOptionPane.INFORMATION_MESSAGE, null);
                jTEmp.grabFocus();
                return;
            }

            //Valid user
            if(jTEsta.getText().compareTo("")==0){

                JOptionPane.showMessageDialog(null, "El campo de usuario esta vacio.", "Usuario", JOptionPane.INFORMATION_MESSAGE, null);
                jTEsta.grabFocus();
                return;
            }
            
            if(!alreadyDBConfig){
                
                //Save the local connections param
                HibernateUtil.getSingleton().createLocalHibernateConfigModel(companyCode,true);

                alreadyDBConfig = true;
            }
            
            final String user = jTEsta.getText();
            final String password = new String(jPContra.getPassword());
                        
            //Valid password
            if(password.compareTo("")==0){

                JOptionPane.showMessageDialog(null, "El campo de contraseña esta vacio.", "Password", JOptionPane.INFORMATION_MESSAGE);
                jPContra.grabFocus();
                return;
            }

            final boolean userExists = RepositoryFactory.getInstance().getUsersRepository().userExists(user);
            
            //If the user does not exists
            if(!userExists){
                
                //Si ya se ingresarón el número máximo de intentos entonces
                if(iContEnt>3)
                {
                    //Mensajea y sal del sistema
                    JOptionPane.showMessageDialog(null, "Límite de intentos de ingreso alcanzado, el sistema se va a cerrar.", "Ingresar", JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                }

                //Aumenta el contador de intentos de ingreso
                iContEnt   += 1;
                
                JOptionPane.showMessageDialog(null, "Usuario/contraseña incorrectos.", "Datos incorrectos", JOptionPane.INFORMATION_MESSAGE);

                jTEsta.grabFocus();
                return;
            }
            
            final String decryptedPassword = RepositoryFactory.getInstance().getUsersRepository().getDecryptedUserPassword(user);
            
            //Passwords match ?
            if(password.compareTo(decryptedPassword)!=0){
                
                //Si ya se ingresarón el número máximo de intentos entonces
                if(iContEnt>3)
                {
                    //Mensajea y sal del sistema
                    JOptionPane.showMessageDialog(null, "Límite de intentos de ingreso alcanzado, el sistema se va a cerrar.", "Ingresar", JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                }

                //Aumenta el contador de intentos de ingreso
                iContEnt   += 1;
                
                JOptionPane.showMessageDialog(null, "Usuario/contraseña incorrectos." , "Datos incorrectos", JOptionPane.INFORMATION_MESSAGE);
                
                jPContra.grabFocus();
                return;
            }
            
            //Get the user from db
            final User User = RepositoryFactory.getInstance().getUsersRepository().getUsrByCode(user);           
            
            if(this.LoginTypeEmpresa == LoginTypeEmpresa.FIRST_LOGIN){                                
            }
            else{
                
                //Deslogin the current user
                UtilitiesFactory.getSingleton().getSessionUtility().deslogUserSession();
                
                //Close the principal window
                ViewControlersFactory.getSingleton().getPrincipViewController().dispose();
            }
            
            //Set the user session in the system            
            UtilitiesFactory.getSingleton().getSessionUtility().userInitSession(User);

            //Save session data for the system
            final BasDats BasDats = RepositoryFactory.getInstance().getBasDatsRepository().getByDBName(companyCode);            
            UtilitiesFactory.getSingleton().getSessionUtility().setBasDats(BasDats);                        

            dispose();

            //Open the main window
            ViewControlersFactory.getSingleton().getPrincipViewController().setVisible();

            if(this.LoginTypeEmpresa == LoginTypeEmpresa.FIRST_LOGIN){                                
            }
            else{
                
                final OKDialog OKDialog = DialogsFactory.getSingleton().getOKDialog(baseJFrame);
                OKDialog.setPropertyText("new_company_login_correct");
                OKDialog.show();                
            }
            
        }catch(Exception ex){
                                    
            try {
                
                LoggerUtility.getSingleton().logError(LoginViewController.class, ex);
                
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
                
            } catch (Exception ex1) {
                Logger.getLogger(LoginViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    
    public final void buttonExitClicked(ActionEvent event){
    
        if(this.LoginTypeEmpresa == LoginTypeEmpresa.FIRST_LOGIN){
            System.exit(0);
        }
        else{
            dispose();
        }                
    }
}