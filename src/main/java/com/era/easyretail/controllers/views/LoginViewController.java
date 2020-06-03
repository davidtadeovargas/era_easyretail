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
import com.era.repositories.models.HibernateConfigModel;
import com.era.repositories.utils.HibernateUtil;
import com.era.utilities.UtilitiesFactory;
import com.era.views.LoginJFrame;
import com.era.views.dialogs.DialogsFactory;
import com.era.views.dialogs.ExceptionDialog;
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
public class LoginViewController extends LoginJFrame {
    
    private String companyCode;        
    private boolean alreadyDBConfig;
    
    private LoginTypeEmpresa LoginTypeEmpresa;
    
    
    
    
    public LoginViewController(){
        
        super("window_title_login");
        
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

    @Override
    public void clearFields(){            
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

                final OKDialog OKDialog = DialogsFactory.getSingleton().getOKDialog(baseJFrame);
                OKDialog.setPropertyText("company_missing_filled_fields");
                OKDialog.setOKDialogInterface((JFrame jFrame) -> {
                    jBEmp.grabFocus();                    
                });
                OKDialog.show();                
                return;
            }

            //Check if a valid company 
            if(companyCode.compareTo("")==0){

                final OKDialog OKDialog = DialogsFactory.getSingleton().getOKDialog(baseJFrame);
                OKDialog.setPropertyText("company_not_exists");
                OKDialog.setOKDialogInterface((JFrame jFrame) -> {
                    jTEmp.grabFocus();                    
                });
                OKDialog.show();
                return;
            }

            //Valid user
            if(jTEsta.getText().compareTo("")==0){

                final OKDialog OKDialog = DialogsFactory.getSingleton().getOKDialog(baseJFrame);
                OKDialog.setPropertyText("company_missing_filled_fields");
                OKDialog.setOKDialogInterface((JFrame jFrame) -> {
                    jTEsta.grabFocus();                    
                });
                OKDialog.show();
                return;
            }
            
            if(!alreadyDBConfig){
                
                //Create the hibernate config model connection file                
                final HibernateConfigModel HibernateConfigModel = HibernateUtil.getSingleton().createLocalHibernateConfigModel(companyCode);
                
                //Save the local connections param
                HibernateUtil.getSingleton().setHibernateConfigModelLocal(HibernateConfigModel);
                
                //Load the local factory
                HibernateUtil.getSingleton().loadDbLocal();

                alreadyDBConfig = true;
            }
            
            final String user = jTEsta.getText();
            final String password = new String(jPContra.getPassword());
                        
            //Valid password
            if(password.compareTo("")==0){

                final OKDialog OKDialog = DialogsFactory.getSingleton().getOKDialog(baseJFrame);
                OKDialog.setPropertyText("company_missing_filled_fields");
                OKDialog.setOKDialogInterface((JFrame jFrame) -> {
                    jPContra.grabFocus();                    
                });
                OKDialog.show();
                return;
            }

            final boolean userExists = RepositoryFactory.getInstance().getUsersRepository().userExists(user);
            
            //If the user does not exists
            if(!userExists){
                
                final OKDialog OKDialog = DialogsFactory.getSingleton().getOKDialog(baseJFrame);
                OKDialog.setPropertyText("users_invalid_login");
                OKDialog.setOKDialogInterface((JFrame jFrame) -> {
                    jTEsta.grabFocus();                    
                });
                OKDialog.show();
                return;
            }
            
            final String decryptedPassword = RepositoryFactory.getInstance().getUsersRepository().getDecryptedUserPassword(user);
            
            //Passwords match ?
            if(password.compareTo(decryptedPassword)!=0){
                
                final OKDialog OKDialog = DialogsFactory.getSingleton().getOKDialog(baseJFrame);
                OKDialog.setPropertyText("users_invalid_login");
                OKDialog.setOKDialogInterface((JFrame jFrame) -> {
                    jTEsta.grabFocus();                    
                });
                OKDialog.show();
                return;
            }
            
            //Get the user from db
            final User User = (User) RepositoryFactory.getInstance().getUsersRepository().getByCode(user);           
            
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
            final BasDats BasDats = RepositoryFactory.getInstance().getBasDatssRepository().getByDBName(companyCode);            
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
    
    @Override
    public List<?> getItemsToLoadInTable() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}