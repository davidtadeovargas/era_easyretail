/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.easyretail.controllers.views;

import static com.era.easyretail.controllers.views.SearchViewController.SEARCH_TYPE.BASDATS;
import com.era.logger.LoggerUtility;
import com.era.repositories.RepositoryManager;
import com.era.repositories.models.HibernateConfigModel;
import com.era.repositories.utils.HibernateUtil;
import com.era.views.Login;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author PC
 */
public class LoginController extends Login {
    
    private String company;
    private String database;
    private boolean onlyExitWindow;
    
    //Contiene el contador de intentos de ingreso al sistema
    int iContEnt = 0;
    
    
    
    
    public LoginController(){
        
        try{                        
                                
            setDefaultButton(jbuttonLogin);
            
            jTEmp.grabFocus();
                        
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
            LoggerUtility.getSingleton().logError(LoginController.class, e);
        }
    }
    
    private void onSearchComapnyCliced(ActionEvent ActionEvent){
        
        final SearchViewController SearchViewController = new SearchViewController();
        SearchViewController.setSEARCH_TYPE(BASDATS);
        SearchViewController.setVisible();
    }
    
    private void showOrHidePassword(){
        
        //Show ot hide the password
        if(jCMostC.isSelected()){                        
            jCMostC.setSelected(false);
            jPContra.setEchoChar('*');
        }
        else{
            jCMostC.setSelected(true);            
            jPContra.setEchoChar((char)0);
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
    
    private void buttonLoginClicked(ActionEvent e){
        
        try{
            
            if(jTEmp.getText().compareTo("")==0){

                JOptionPane.showMessageDialog(null, "La empresa esta vacia.", "Empresa", JOptionPane.INFORMATION_MESSAGE, null);
                jBEmp.grabFocus();
                return;
            }

            //Check if a valid company 
            if(company.compareTo("")==0){

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

            //Save the local connections param
            HibernateConfigModel HibernateConfigModel = HibernateUtil.getSingleton().getHibernateConfigModel();
            HibernateConfigModel HibernateConfigModel_ = new HibernateConfigModel();
            HibernateConfigModel_.setInstance(HibernateConfigModel.getInstance());
            HibernateConfigModel_.setPassword(HibernateConfigModel.getPassword());
            HibernateConfigModel_.setPort(HibernateConfigModel.getPort());
            HibernateConfigModel_.setUrl(HibernateConfigModel.getUrl());
            HibernateConfigModel_.setUser(HibernateConfigModel.getUser());
            HibernateConfigModel_.setDatabase(database);
            HibernateUtil.getSingleton().setHibernateConfigModelLocal(HibernateConfigModel_);

            //Connect to local
            HibernateUtil.getSingleton().connectToDbLocal();

            final String user = jTEsta.getText();
            final String password = new String(jPContra.getPassword());
            
            //Valid password
            if(password.compareTo("")==0){

                JOptionPane.showMessageDialog(null, "El campo de contraseña esta vacio.", "Password", JOptionPane.INFORMATION_MESSAGE);
                jPContra.grabFocus();
                return;
            }

            final boolean userExists = RepositoryManager.getInstance().getUsersRepository().userExists(user);
            
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
            
            final String decryptedPassword = RepositoryManager.getInstance().getUsersRepository().getDecryptedUserPassword(user);
            
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

            //Log the loggin of the user
            RepositoryManager.getInstance().getUsersRepository().userLoggedToSystem(user);
                        
            //Open the main window
            
            
        }catch(Exception ex){
            LoggerUtility.getSingleton().logError(LoginController.class, ex);
        }
    }
    
    
    public void buttonExitClicked(ActionEvent event){
    
        //Close the window or exit the system
        if(onlyExitWindow){
                        
            System.gc();        
            dispose();
        }        
        else                
            System.exit(0);
        
    }
}