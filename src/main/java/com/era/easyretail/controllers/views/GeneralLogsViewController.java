/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.easyretail.controllers.views;

import com.era.datamodels.LogsComboDataModel;
import com.era.views.GeneralLogsJFrame;
import com.era.logger.LoggerUtility;
import com.era.models.Log;
import com.era.repositories.RepositoryFactory;
import com.era.views.dialogs.DialogsFactory;
import com.era.views.tables.LogTable;
import com.era.views.tables.headers.TableHeaderFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author PC
 */
public class GeneralLogsViewController extends GeneralLogsJFrame {
    
    private LogsComboDataModel LogsComboDataModel;
    
    public GeneralLogsViewController(){
        super("window_title_general_catlog");
        
        try{
                     
            jBBusc.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBBuscActionPerformed(evt);
            });
            jBMosT.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBMosTActionPerformed(evt);
            });
            
            this.disposeButton(jBSal);
            
            //Config table
            this.BaseJTable = jTab;
            jTab.addShowColumn(TableHeaderFactory.getSigleton().getLogsTableHeader().getROWNUMBER());
            jTab.addShowColumn(TableHeaderFactory.getSigleton().getLogsTableHeader().getACCIO());
            jTab.addShowColumn(TableHeaderFactory.getSigleton().getLogsTableHeader().getCODE());
            jTab.addShowColumn(TableHeaderFactory.getSigleton().getLogsTableHeader().getDESCRIP());
            jTab.addShowColumn(TableHeaderFactory.getSigleton().getLogsTableHeader().getFALT());
            jTab.addShowColumn(TableHeaderFactory.getSigleton().getLogsTableHeader().getFMOD());
            
            //Load all items in combobox
            jComboBox1.loadItems();
            
            //Init combo
            jComboBox1.setChangeSelectionListener((Object ObjectModel) -> {
                
                try {
                    
                    //Cast the model
                    LogsComboDataModel = (LogsComboDataModel)ObjectModel;

                    List<Log> items = new ArrayList<>();

                    if(LogsComboDataModel.isRegistrosCreados()){
                        items = RepositoryFactory.getInstance().getLogsRepository().getAllAccioSave();
                    }
                    else if(LogsComboDataModel.isRegistrosActualizados()){
                        items = RepositoryFactory.getInstance().getLogsRepository().getAllAccioUpdate();
                    }
                    else if(LogsComboDataModel.isLoginUsuarios()){
                        items = RepositoryFactory.getInstance().getLogsRepository().getAllLogins();
                    }
                    else if(LogsComboDataModel.isCierreSesionUsuarios()){
                        items = RepositoryFactory.getInstance().getLogsRepository().getAllAccioLoggedout();
                    }
                    else if(LogsComboDataModel.isInicioSesionUsuarios()){
                        items = RepositoryFactory.getInstance().getLogsRepository().getAllAccioLogged();
                    }

                    //Load all the items in the table
                    jTab.initTable(items);
                    
                } catch (Exception ex) {
                    LoggerUtility.getSingleton().logError(this.getClass(), ex);
                    try {
                        DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
                    } catch (Exception ex1) {
                        Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex1);
                    }
                }
            });
            
        }catch (Exception ex) {
            LoggerUtility.getSingleton().logError(GeneralLogsViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(GeneralLogsViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    @Override
    public void clearFields() throws Exception{            
    }
    
    @Override
    public void loadModelInFields(Object ObjectModel) throws  Exception {        
    }
    
    private void jBMosTActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
            if(LogsComboDataModel==null){
                return;
            }
            
            List<Log> items = new ArrayList<>();

            if(LogsComboDataModel.isRegistrosCreados()){
                items = RepositoryFactory.getInstance().getLogsRepository().getAllAccioSave();
            }
            else if(LogsComboDataModel.isRegistrosActualizados()){
                items = RepositoryFactory.getInstance().getLogsRepository().getAllAccioUpdate();
            }
            else if(LogsComboDataModel.isLoginUsuarios()){
                items = RepositoryFactory.getInstance().getLogsRepository().getAllLogins();
            }
            else if(LogsComboDataModel.isCierreSesionUsuarios()){
                items = RepositoryFactory.getInstance().getLogsRepository().getAllAccioLoggedout();
            }
            else if(LogsComboDataModel.isInicioSesionUsuarios()){
                items = RepositoryFactory.getInstance().getLogsRepository().getAllAccioLogged();
            }

            //Load all the items in the table
            jTab.initTable(items);
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(GeneralLogsViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(GeneralLogsViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBBuscActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
            //Get the value to search
            final String search = jTBusc.getText().trim();
            
            //If nothing to search so return
            if(search.isEmpty()){
                return;
            }                        
            
            if(LogsComboDataModel==null){
                return;
            }
            
            LogTable.Type Type = null;
            
            if(LogsComboDataModel.isRegistrosCreados()){
                Type = LogTable.Type.REGISTROS_CREADOS;
            }
            else if(LogsComboDataModel.isRegistrosActualizados()){
                Type = LogTable.Type.REGISTROS_ACTUALIZADOS;
            }
            else if(LogsComboDataModel.isLoginUsuarios()){
                Type = LogTable.Type.LOGIN_USUARIOS;
            }
            else if(LogsComboDataModel.isCierreSesionUsuarios()){
                Type = LogTable.Type.CIERRE_SESION_USUARIOS;
            }
            else if(LogsComboDataModel.isInicioSesionUsuarios()){
                Type = LogTable.Type.INICIO_SESION_USUARIOS;
            }
            
            this.jTab.getByLikeEncabezadosByType(search, Type);
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(GeneralLogsViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(GeneralLogsViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
}
