/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.easyretail.controllers.views;

import com.era.easyretail.era_jasperreports.ReportManager;
import com.era.views.ReportsJFrame;
import java.util.List;
import com.era.logger.LoggerUtility;
import com.era.views.comboboxes.models.ReportsOneLevel;
import com.era.views.comboboxes.models.ReportsSecondLevel;
import com.era.views.dialogs.DialogsFactory;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
/**
 *
 * @author PC
 */
public class ReportsViewController extends ReportsJFrame {
    
    public ReportsViewController(){
     
        super("window_title_general_reports");
        
        try{
                     
            generateButton.addActionListener((java.awt.event.ActionEvent evt) -> {
                generateButtonActionPerformed(evt);
            });
            
            reportsOneLevelCombobox.setChangeSelectionListener((Object ObjectModel) -> {
                
                try {
                 
                    final ReportsOneLevel ReportsOneLevel = (ReportsOneLevel)ObjectModel;

                    if(ReportsOneLevel.getCode().compareTo("COMPRAS")==0){
                        reportsSecondLevelCombobox.loadComprasItems();
                    }
                    else if(ReportsOneLevel.getCode().compareTo("VENTAS")==0){
                        reportsSecondLevelCombobox.loadVentasItems();
                    }
                    else if(ReportsOneLevel.getCode().compareTo("USUARIOS")==0){
                        reportsSecondLevelCombobox.loadUsuariosItems();
                    }
                    else if(ReportsOneLevel.getCode().compareTo("RESPALDOS")==0){
                        reportsSecondLevelCombobox.loadRespaldosItems();
                    }
                    else if(ReportsOneLevel.getCode().compareTo("ALMACEN")==0){
                        reportsSecondLevelCombobox.loadAlmacenItems();
                    }
                    else if(ReportsOneLevel.getCode().compareTo("PRODUCTOS")==0){
                        reportsSecondLevelCombobox.loadProductosItems();
                    }
                    
                } catch (Exception ex) {
                    LoggerUtility.getSingleton().logError(this.getClass(), ex);
                    try {
                        DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
                    } catch (Exception ex1) {
                        Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex1);
                    }
                }
            });
            reportsOneLevelCombobox.loadItems();
            
            reportsSecondLevelCombobox.setChangeSelectionListener((Object ObjectModel) -> {
                
                final ReportsSecondLevel ReportsSecondLevel = (ReportsSecondLevel)ObjectModel;
                                
            });
            
        }catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ReportsViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(ReportsViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }    

    @Override
    public void loadModelInFields(Object ObjectModel) throws  Exception {        
    }
    
    @Override
    public void clearFields() throws Exception{
    }
    
    private void generateButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
    
            //If no selection stop
            final ReportsOneLevel ReportsOneLevel = (ReportsOneLevel)reportsOneLevelCombobox.getSelectedObject();
            if(ReportsOneLevel==null || ReportsOneLevel.getValue().isEmpty()){
                DialogsFactory.getSingleton().showErrorOKNoSelectionCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                    reportsOneLevelCombobox.grabFocus();
                });
                return;
            }
            
            //If no selection stop
            final ReportsSecondLevel ReportsSecondLevel = (ReportsSecondLevel)reportsSecondLevelCombobox.getSelectedObject();
            if(ReportsSecondLevel==null || ReportsSecondLevel.getValue().isEmpty()){
                DialogsFactory.getSingleton().showErrorOKNoSelectionCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                    reportsSecondLevelCombobox.grabFocus();
                });
                return;
            }
            
            if(ReportsOneLevel.getCode().compareTo("COMPRAS")==0){
                
            }
            else if(ReportsOneLevel.getCode().compareTo("VENTAS")==0){
                
            }
            else if(ReportsOneLevel.getCode().compareTo("USUARIOS")==0){
                
            }
            else if(ReportsOneLevel.getCode().compareTo("RESPALDOS")==0){
                
            }
            else if(ReportsOneLevel.getCode().compareTo("ALMACEN")==0){
                
            }
            else if(ReportsOneLevel.getCode().compareTo("PRODUCTOS")==0){
                
                if(ReportsSecondLevel.getCode().compareTo("PRODUPMAX")==0){
                    ReportManager.getSingleton().generateProductsUpMaxPDF();
                }
                else if(ReportsSecondLevel.getCode().compareTo("PRODDOWNMIN")==0){                    
                    ReportManager.getSingleton().generateProductsDownMinPDF();
                }
            }
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(this.getClass(), ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    @Override
    public List<?> getItemsToLoadInTable() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
