/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.easyretail.controllers.views;

import com.era.datamodels.enums.SearchCommonTypeEnum;
import com.era.easyretail.validators.ValidatorFactory;
import com.era.easyretail.validators.WarehousesValidator;
import com.era.logger.LoggerUtility;
import com.era.models.User;
import com.era.models.Warehouse;
import com.era.repositories.RepositoryFactory;
import com.era.views.AlmasJFrame;
import com.era.views.dialogs.DialogsFactory;
import com.era.views.tables.headers.TableHeaderFactory;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.event.ListSelectionEvent;

/**
 *
 * @author PC
 */
public class AlmasViewController extends AlmasJFrame {
    
    public AlmasViewController() {
        super("window_title_almas");
        
        try{
        
            this.setDefaultButton(jBNew);
            
            jBDel.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBDelActionPerformed(evt);
            });
            jBSal.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBSalActionPerformed(evt);
            });
            jBNew.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBNewActionPerformed(evt);
            });
            jBBusc.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBBuscActionPerformed(evt);
            });
            jBMosT.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBMosTActionPerformed(evt);
            });            
            jBActua.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBActuaActionPerformed(evt);
            });
            jBResp.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBRespActionPerformed(evt);
            });
            
            //Prepare table
            this.BaseJTable = this.jTab;
            this.BaseJTable.addShowColumn(TableHeaderFactory.getSigleton().getWarehousesTableHeader().getROWNUMBER());
            this.BaseJTable.addShowColumn(TableHeaderFactory.getSigleton().getWarehousesTableHeader().getCODE());
            this.BaseJTable.addShowColumn(TableHeaderFactory.getSigleton().getWarehousesTableHeader().getDESCRIPTION());
            this.BaseJTable.addShowColumn(TableHeaderFactory.getSigleton().getWarehousesTableHeader().getRESPONSABLE());
            this.BaseJTable.addShowColumn(TableHeaderFactory.getSigleton().getWarehousesTableHeader().getADDRESS1());
            this.BaseJTable.addShowColumn(TableHeaderFactory.getSigleton().getWarehousesTableHeader().getADDRESS2());
            this.BaseJTable.addShowColumn(TableHeaderFactory.getSigleton().getWarehousesTableHeader().getADDRESS3());            
            
            //Load all the warehouses
            this.jTab.loadAllItemsInTable();
            
            //When selecting a row in the table set all the fields
            this.jTab.setITableRowSelected((ListSelectionEvent lse, Object Object) -> {
                
                //Cast the model
                final Warehouse Warehouse = (Warehouse)Object;
                
                //Fill all the fields
                jTCod.setText(Warehouse.getCode());                
                jTDescrip.setText(Warehouse.getDescription());
                jTRespon.setText(Warehouse.getResponsable());
                jTDir1.setText(Warehouse.getAddress1());
                jTDir2.setText(Warehouse.getAddress2());
                jTDir3.setText(Warehouse.getAddress3());
            });
            
        }catch (Exception ex) {
            LoggerUtility.getSingleton().logError(AlmasViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(AlmasViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    private void jBRespActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
            //Search warehouse
            final SearchViewController SearchViewController = new SearchViewController();
            SearchViewController.setSEARCH_TYPE(SearchCommonTypeEnum.USERS);
            SearchViewController.setButtonAceptClicked(() -> {

                final String responsable = SearchViewController.getCod();
                jTRespon.setText(responsable);
            });
            SearchViewController.setVisible();
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(AlmasViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(AlmasViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void saveOrUpdate(final boolean save) {
        
        try{            	
            
            //For update
            if(!save){
                
                //Firts select record
                if(!jTab.isRowSelected()){
                    DialogsFactory.getSingleton().showErrorOKNoSelectionCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                        jTab.grabFocus();
                    });                
                    return;
                }
            }
            
            try{
                
                //Vaidate all is filled properly
                final WarehousesValidator WarehousesValidator = ValidatorFactory.getSigleton().getWarehousesValidator();
                WarehousesValidator.setCode(jTCod.getText().trim());            
                WarehousesValidator.setDescription(jTDescrip.getText().trim());
                WarehousesValidator.setResponsable(jTRespon.getText().trim());
                if(save){
                    WarehousesValidator.validateInsert();
                }
                else{
                    WarehousesValidator.validateUpdate();
                }                

            }catch(Exception e){
                DialogsFactory.getSingleton().showErrorTextOKDialog(baseJFrame, e.getMessage());
                return;
            }
            
            //Get the responsable
            final String responsable = jTRespon.getText().trim();
            
            //Validate that the responsable exists
            final User User = (User)RepositoryFactory.getInstance().getUsersRepository().getByCode(responsable);
            if(User==null){
                DialogsFactory.getSingleton().showErrorUserNotExistsOKDialog(baseJFrame, (JFrame jFrame) -> {
                    jTRespon.grabFocus();
                });
                return;
            }
            
            //Get the warehouse
            final String warehouse = jTCod.getText().trim();
            
            //Check taht the warehouse doent exists in the db
            final Warehouse Warehouse = (Warehouse)RepositoryFactory.getInstance().getWarehousesRepository().getByCode(warehouse);
            if(!save){ //For update
                if(Warehouse==null){
                    DialogsFactory.getSingleton().showErrorRecordNotExistsOKDialog(baseJFrame, (JFrame jFrame) -> {
                        jTCod.grabFocus();
                    });
                    return;
                }
            }
            else{ //For new one
                if(Warehouse!=null){
                    DialogsFactory.getSingleton().showErrorRecordExistsOKDialog(baseJFrame, (JFrame jFrame) -> {
                        jTCod.grabFocus();
                    });
                    return;
                }
            }
            
            //Question of continue
            DialogsFactory.getSingleton().showQuestionContinueDialog(baseJFrame, (JFrame jFrame) -> {
                
                try{
                    
                    final String description = jTDescrip.getText().trim();
                    final String addres1 = jTDir1.getText().trim();
                    final String addres2 = jTDir1.getText().trim();
                    final String addres3 = jTDir1.getText().trim();
                    
                    //Create the model
                    Warehouse Warehouse_ = null;
                    if(!save){ //For update
                        
                    }
                    else{ //New record
                        Warehouse_ = new Warehouse();
                    }
                    Warehouse_.setCode(warehouse);
                    Warehouse_.setDescription(description);
                    Warehouse_.setResponsable(responsable);                    
                    Warehouse_.setAddress1(addres1);
                    Warehouse_.setAddress2(addres2);
                    Warehouse_.setAddress3(addres3);
                    
                    //Save the new warehouse
                    if(!save){ //For update
                        RepositoryFactory.getInstance().getWarehousesRepository().update(Warehouse_);
                    }
                    else{ //New record
                        RepositoryFactory.getInstance().getWarehousesRepository().save(Warehouse_);
                    }
                    
                    //Clear all the fields                    
                    clearFields();
                    
                    //Reload the table
                    jTab.loadAllItemsInTable();
                    
                    //Announce to the user
                    DialogsFactory.getSingleton().showOKOperationCompletedCallbackDialog(jFrame, null);
                    
                }catch (Exception ex) {
                    LoggerUtility.getSingleton().logError(AlmasViewController.class, ex);
                    try {
                        DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
                    } catch (Exception ex1) {
                        Logger.getLogger(AlmasViewController.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                }
            });
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(AlmasViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(AlmasViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBActuaActionPerformed(java.awt.event.ActionEvent evt) {                                             
        saveOrUpdate(false);
    }
    
    
    private void jBMosTActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
            //Load all the users
            this.jTab.loadAllItemsInTable();
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(AlmasViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(AlmasViewController.class.getName()).log(Level.SEVERE, null, ex1);
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
            
            //Search all the ocurrences
            this.jTab.getByLikeEncabezados(search);
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(AlmasViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(AlmasViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBNewActionPerformed(java.awt.event.ActionEvent evt) {
        saveOrUpdate(true);
    }
    
    @Override
    public void clearFields(){
        
        jTCod.setText("");
        jTDir1.setText("");
        jTDescrip.setText("");
        jTDir2.setText("");
        jTRespon.setText("");
        jTDir3.setText("");        
    }
    
    private void jBSalActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
         
            DialogsFactory.getSingleton().showQuestionExitDialog(baseJFrame, (JFrame jFrame) -> {
                dispose();
            });
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(AlmasViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(AlmasViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBDelActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
            //If not selection do not continue
            if(!jTab.isRowSelected()){
                DialogsFactory.getSingleton().showErrorOKNoSelectionCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                    jTab.grabFocus();
                });
                return ;
            }
            
            //Question if continue
            DialogsFactory.getSingleton().showQuestionContinueDialog(baseJFrame, (JFrame jFrame) -> {
                
                try{
                
                    //Get the selected model
                    final Warehouse Warehouse = (Warehouse)jTab.getRowSelected();
                    
                    //Delete the record
                    RepositoryFactory.getInstance().getWarehousesRepository().delete(Warehouse);
                    
                    //Reload the table
                    jTab.loadAllItemsInTable();
                    
                    //Announce to the user
                    DialogsFactory.getSingleton().showOKOperationCompletedCallbackDialog(baseJFrame, null);

                }catch (Exception ex) {
                    LoggerUtility.getSingleton().logError(AlmasViewController.class, ex);
                    try {
                        DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
                    } catch (Exception ex1) {
                        Logger.getLogger(AlmasViewController.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                }
            });
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(AlmasViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(AlmasViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    @Override
    public List<?> getItemsToLoadInTable() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
