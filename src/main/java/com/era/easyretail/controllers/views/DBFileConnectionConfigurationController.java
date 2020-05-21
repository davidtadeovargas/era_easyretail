/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.easyretail.controllers.views;

import com.era.easyretail.constants.Constants;
import com.era.logger.LoggerUtility;
import com.era.repositories.RepositoryFactory;
import com.era.repositories.utils.MysqlScriptsUtil;
import com.era.utilities.ConfigFileUtil;
import com.era.utilities.SecurityUtil;
import com.era.utilities.UtilitiesFactory;
import com.era.utilities.models.ConfigFileModel;
import com.era.views.DBFileConnectionConfigurationJFrame;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import javax.swing.JOptionPane;

/**
 *
 * @author PC
 */
public class DBFileConnectionConfigurationController extends DBFileConnectionConfigurationJFrame {
    
    private ConfigFileModel ConfigFileModel;
    private boolean closeSystem;
    private boolean onSaveExistApp;
    private OnSave OnSave;
    
    public DBFileConnectionConfigurationController(){
        
        super("window_title_conectionfile");
        
        // 03 Julio 2015 // Heriberto // Configuracion de sistema
        jTNom.setEnabled(true); 
        jTNom.setToolTipText("");
                   
        JComponentUtils.addComponentToKeyPress(jBGua);
        JComponentUtils.addComponentToKeyPress(jP1);
        JComponentUtils.addComponentToKeyPress(jBSal);
        JComponentUtils.addComponentToKeyPress(jTUsr);
        JComponentUtils.addComponentToKeyPress(jTBD);
        JComponentUtils.addComponentToKeyPress(jPCont);
        JComponentUtils.addComponentToKeyPress(jTNom);
        JComponentUtils.addComponentToKeyPress(jBProb);
        JComponentUtils.addComponentToKeyPress(jCMosC);
        JComponentUtils.addComponentToKeyPress(jTSuc);
        JComponentUtils.addComponentToKeyPress(jTNoCaj);
        JComponentUtils.addComponentToKeyPress(jTPort);        
                
        JComponentUtils.selectAllTextInControlOnFocus(jTInst);
        JComponentUtils.selectAllTextInControlOnFocus(jTUsr);
        JComponentUtils.selectAllTextInControlOnFocus(jTBD);
        JComponentUtils.selectAllTextInControlOnFocus(jPCont);
        JComponentUtils.selectAllTextInControlOnFocus(jTNom);
        JComponentUtils.selectAllTextInControlOnFocus(jTSuc);
        JComponentUtils.selectAllTextInControlOnFocus(jTNoCaj);
        JComponentUtils.selectAllTextInControlOnFocus(jTPort);        
        
        JComponentUtils.interceptWindowClosingToButton(jBSal);
        
        JComponentUtils.onKeyTypedToMayus(jTBD);
        JComponentUtils.onKeyTypedToMayus(jTSuc);
        JComponentUtils.onKeyTypedToMayus(jTNoCaj);        
                
        JComponentUtils.onlyNumbers(jTPort);
        
        JComponentUtils.setF4Event(() -> {
            showOrHidePassword();
        });        
        
        setDefaultButton(jBGua);
        
        jTNom.grabFocus();                
        
        jBGua.addActionListener((ActionEvent e) -> {
            buttonSaveClicked(e);
        });
        
        jBSal.addActionListener((ActionEvent e) -> {
            buttonExitClicked(e);
        });
        
        jBProb.addActionListener((ActionEvent e) -> {
            testConnection(e);
        });
                
        jCMosC.addActionListener((ActionEvent e) -> {
            showPasswordChecked(e);
        });        
            
        jTBD.addFocusListener(new FocusListener(){
            @Override
            public void focusGained(FocusEvent e) {
            }
            @Override
            public void focusLost(FocusEvent e) {
                onDababseFocusLost(e);
            }
        });
        jTNom.addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent e) {
                companyNameKeyTyped(e);
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {                
            }            
        });
        
        //If config file exists load it
        if(!new File(Constants.CONFIG_FILE).exists()){
            try{            
                loadConfigFile();
            }catch(Exception e){
                LoggerUtility.getSingleton().logError(DBFileConnectionConfigurationController.class, e);
            }
        }
    }
    
    private void showOrHidePassword(){
        
        //Check or uncheck the show password
        if(jCMosC.isSelected())
        {
            if(JComponentUtils.F4EventFired()){
                jCMosC.setSelected(false);
            }            
            jPCont.setEchoChar('*');         
        }
        else
        {
            if(JComponentUtils.F4EventFired()){
                jCMosC.setSelected(true);
            }            
            jPCont.setEchoChar((char)0);
        }
    }
    
    private void showPasswordChecked(ActionEvent ActionEvent){
                
        if(jCMosC.isSelected())
        {
            jPCont.setEchoChar((char)0);            
        }        
        else
        {
            jPCont.setEchoChar('*');
        }
    }
    
    private void testConnection(ActionEvent ActionEvent){
        
        try{
            
            final String instance = jTInst.getText().trim();
            if(instance.trim().compareTo("")==0)
            {
                JOptionPane.showMessageDialog(null, "El campo de instancia esta vacio.", "Campo vacio", JOptionPane.INFORMATION_MESSAGE);
                jTInst.grabFocus();           
                return;
            }

            final String user = jTUsr.getText().trim();
            if(user.compareTo("")==0)
            {
                JOptionPane.showMessageDialog(null, "El campo de usuario esta vacio.", "Campo vacio", JOptionPane.INFORMATION_MESSAGE);
                jTUsr.grabFocus();           
                return;
            }

            final String port = jTPort.getText();
            if(port.compareTo("")==0)
            {
                JOptionPane.showMessageDialog(null, "El campo del puerto esta vacio.", "Campo vacio", JOptionPane.INFORMATION_MESSAGE);
                jTPort.grabFocus();           
                return;
            }
            
            final String database = jTBD.getText();               
            if(database.compareTo("")==0)
            {
                JOptionPane.showMessageDialog(null, "El campo de base de datos esta vacio.", "Campo vacio", JOptionPane.INFORMATION_MESSAGE);
                jTBD.grabFocus();               
                return;
            }

            final String password = new String(jPCont.getPassword());
                    
            //Test connection
            final boolean successConnection = MysqlScriptsUtil.getInstance().testSysConnection(user, password, instance, Integer.valueOf(port));
            if(successConnection){
                JOptionPane.showMessageDialog(null, "Conexión exitosa a la base de datos", "Conexión", JOptionPane.INFORMATION_MESSAGE); 
            }
            else{
                JOptionPane.showMessageDialog(null, "Conexión no exitosa a la base de datos", "Conexión", JOptionPane.ERROR_MESSAGE); 
            }
                        
        }catch(Exception e){
            LoggerUtility.getSingleton().logError(DBFileConnectionConfigurationController.class, e);
        }
    }
    
    
    private void onDababseFocusLost(FocusEvent e){
        
        /* Felipe Ruiz Garcia 29 05 2015 */
        /* Valida que el nombre de la base de datos no comienze con un numero y no contenga caracteres especiales */
            
        final String database =  jTBD.getText();
        
        char character = database.charAt(0);        
        final boolean isLetter = Character.isLetter(character);
        
        if(!isLetter){
    
            JOptionPane.showMessageDialog(null, "El nombre base de datos no puede iniciar con números, operadores o caracteres especiales.\n\tPor favor ingrese un nombre valido.", "Base de datos invalida", JOptionPane.INFORMATION_MESSAGE);
            jTBD.grabFocus();
            return;
        }        
        
        boolean valid = true;
        for( char x : database.toCharArray()){
            if(!Character.isDigit(x) && !Character.isLetter(x)){
                valid = false;
            }
        }
        
        if(!valid){
            
            JOptionPane.showMessageDialog(null, "El nombre base de datos no puede contener operadores o caracteres especiales.\n\tPor favor ingrese un nombre valido.", "Base de datos invalida", JOptionPane.INFORMATION_MESSAGE);
            jTBD.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.RED));
            jTBD.grabFocus();
        }
    }
    
    private void companyNameKeyTyped(KeyEvent evt){
        
        //To mayus
        if(Character.isLowerCase(evt.getKeyChar()))       
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));                              
        
        /* 29 05 2015 Felipe Ruiz Garcia / Carlos Ramirez Ramirez */
        /* No permite la inserccion de los simbolos | ¬  \b */
        if((evt.getKeyChar() != '\b') &&(evt.getKeyChar() != '|') && (evt.getKeyChar() != '¬'))         
        {}
        else
            evt.consume();
    }
    
    private void buttonExitClicked(ActionEvent e){
                
        Object[] op = {"Si","No"};
        int iRes    = JOptionPane.showOptionDialog(this, "¿Seguro que quieres salir?", "Salir Aplicación", JOptionPane.YES_NO_OPTION,  JOptionPane.QUESTION_MESSAGE, null, op, op[0]);
        if(iRes==JOptionPane.NO_OPTION || iRes==JOptionPane.CLOSED_OPTION)
            return;   
                
        if(closeSystem)
            System.exit(0);                    
        else            
            dispose();
    }
    
    private void buttonSaveClicked(ActionEvent e){
     
        try{
            
            final String companyName = jTNom.getText().trim();

            //The company can not contain special characters
            int z= companyName.length();
            z--;
            for(;z>=0;z--)
            if((companyName.charAt(z) == '|')  || (companyName.charAt(z) == '¬') ){
                JOptionPane.showMessageDialog(null, "El nombre de la empresa no puede contener caracteres especiales." + "" + "", "Atención", JOptionPane.INFORMATION_MESSAGE);
                jTNom.grabFocus();
                return;
            }

            //Instance should have value
            final String instance = jTInst.getText().trim();
            if(instance.compareTo("")==0)
            {
                JOptionPane.showMessageDialog(null, "El campo de instancia esta vacio.", "Campo vacio", JOptionPane.INFORMATION_MESSAGE);
                jTInst.grabFocus();           
                return;
            }

            //User should contain a value
            final String user = jTUsr.getText().trim();                
            if(user.compareTo("")==0)
            {
                JOptionPane.showMessageDialog(null, "El campo de usuario esta vacio.", "Campo vacio", JOptionPane.INFORMATION_MESSAGE);
                jTUsr.grabFocus();            
                return;
            }

            final String password = new String(jPCont.getPassword()).trim();

            //Database should contains a value
            final String database = jTBD.getText().trim();
            if(database.compareTo("")==0)
            {
                JOptionPane.showMessageDialog(null, "El campo de base de datos esta vacio.", "Campo vacio", JOptionPane.INFORMATION_MESSAGE);
                jTBD.grabFocus();            
                return;
            }

            //Sucursal should contain data
            final String sucursal = jTSuc.getText().trim();                
            if(sucursal.compareTo("")==0)
            {
                JOptionPane.showMessageDialog(null, "El campo de base de la sucursal esta vacio.", "Campo vacio", JOptionPane.INFORMATION_MESSAGE);
                jTSuc.grabFocus();            
                return;
            }

            final String nocaj = jTNoCaj.getText().trim();
            if(nocaj.compareTo("")==0)
            {
                JOptionPane.showMessageDialog(null, "El campo del número de caja esta vacio.", "Campo vacio", JOptionPane.INFORMATION_MESSAGE);
                jTNoCaj.grabFocus();            
                return;
            }

            final String port = jTPort.getText().trim();
            if(port.compareTo("")==0)
            {
                JOptionPane.showMessageDialog(null, "El campo del puerto esta vacio.", "Campo vacio", JOptionPane.INFORMATION_MESSAGE);
                jTPort.grabFocus();           
                return;
            }

            //Check database connection before continue
            final boolean successConnection = MysqlScriptsUtil.getInstance().testSysConnection(user, password, instance, Integer.valueOf(port));
            if(!successConnection){
                JOptionPane.showMessageDialog(null, "Conexión no exitosa a la base de datos", "Conexión", JOptionPane.ERROR_MESSAGE);
                return;
            }           
            
            Object[] op = {"Si","No"};
            int iRes = JOptionPane.showOptionDialog(this, "¿Seguro que estan bien los datos?", "Guardar conexión", JOptionPane.YES_NO_OPTION,  JOptionPane.QUESTION_MESSAGE, null, op, op[0]);
            if(iRes==JOptionPane.NO_OPTION || iRes==JOptionPane.CLOSED_OPTION)
                return;

            //If file exists
            if(ConfigFileUtil.getSingleton().configFileExists())
            {
               JOptionPane.showMessageDialog(null, "El archivo de configuracion ya existe. Borrando archivo.", "Instalación", JOptionPane.ERROR_MESSAGE, null); 

               ConfigFileUtil.getSingleton().deleteFile();

               //If any error deleting notice user
               if(ConfigFileUtil.getSingleton().configFileExists())
               {
                   JOptionPane.showMessageDialog(null, "No se pudo borrar el archivo existente de configuración.", "Archivo de Configuración", JOptionPane.INFORMATION_MESSAGE); 
                   return;
               }
            }                

            //Create the config file in disk
            final ConfigFileModel ConfigFileModel_ = new ConfigFileModel();
            ConfigFileModel_.setInstance(instance);
            ConfigFileModel_.setUser(user);
            ConfigFileModel_.setPassword(password);
            ConfigFileModel_.setDb(database);
            ConfigFileModel_.setSucursal(sucursal);
            ConfigFileModel_.setCashNumber(nocaj);
            ConfigFileModel_.setPort(port);
            ConfigFileModel_.setCompanyName(companyName);

            ConfigFileUtil.getSingleton(Constants.CONFIG_FILE).createConfigFile(ConfigFileModel_);
                        
            LoggerUtility.getSingleton().logInfo(DBFileConnectionConfigurationController.class, "Exito en el archivo de configuración.");            
        
            //Should close system to reload config file?
            if(onSaveExistApp){
                
                JOptionPane.showMessageDialog(null, "La aplicación se va a cerrar.", "Aplicación", JOptionPane.INFORMATION_MESSAGE);

                //Reigster the user logut                
                RepositoryFactory.getInstance().getLogRepository().userLoggedOutToSystem();
                                
                System.exit(0);
            }
            else{
                this.close();
            }
            
            //Inversion of control
            if(OnSave!=null){
                OnSave.OnSave();
            }
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            LoggerUtility.getSingleton().logError(DBFileConnectionConfigurationController.class, ex);
        }
    }
    
    private void loadConfigFile() throws Exception {
                
        try(FileInputStream fileIn = new FileInputStream(Constants.CONFIG_FILE); ObjectInputStream in = new ObjectInputStream(fileIn);){
            ConfigFileModel = (ConfigFileModel)in.readObject();
         }

        final SecurityUtil SecurityUtil = UtilitiesFactory.getSingleton().getSecurityUtil();
        
        //Decryp all data
        ConfigFileModel.setInstance(SecurityUtil.decryptString(ConfigFileModel.getInstance()));
        ConfigFileModel.setUser(SecurityUtil.decryptString(ConfigFileModel.getUser()));
        ConfigFileModel.setPassword(SecurityUtil.decryptString(ConfigFileModel.getPassword()));
        ConfigFileModel.setDb(SecurityUtil.decryptString(ConfigFileModel.getDb()));
        ConfigFileModel.setPort(SecurityUtil.decryptString(ConfigFileModel.getPort()));
        ConfigFileModel.setSucursal(SecurityUtil.decryptString(ConfigFileModel.getSucursal()));
        ConfigFileModel.setCashNumber(SecurityUtil.decryptString(ConfigFileModel.getCashNumber()));
        ConfigFileModel.setCompanyName(SecurityUtil.decryptString(ConfigFileModel.getCompanyName()));        
        
        //Place the data in fields
        jTInst.setText(ConfigFileModel.getInstance());
        jTUsr.setText(ConfigFileModel.getUser());
        jPCont.setText(ConfigFileModel.getPassword());
        jTBD.setText(ConfigFileModel.getDb());
        jTSuc.setText(ConfigFileModel.getSucursal());
        jTNoCaj.setText(ConfigFileModel.getCashNumber());
        jTNom.setText(ConfigFileModel.getCompanyName());
        jTPort.setText(ConfigFileModel.getPort());
    }

    public void setCloseSystem(boolean closeSystem) {
        this.closeSystem = closeSystem;
    }
    
    public interface OnSave{
        public void OnSave();
    }

    public void setOnSave(OnSave OnSave) {
        this.OnSave = OnSave;
    }

    public void setOnSaveExistApp(boolean onSaveExistApp) {
        this.onSaveExistApp = onSaveExistApp;
    }
    
    
}
