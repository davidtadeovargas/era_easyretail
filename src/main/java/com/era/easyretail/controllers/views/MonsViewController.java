/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.easyretail.controllers.views;

import com.era.datamodels.enums.SearchCommonTypeEnum;
import java.util.List;
import com.era.logger.LoggerUtility;
import com.era.models.Coin;
import com.era.repositories.RepositoryFactory;
import com.era.views.MonssJFrame;
import com.era.views.dialogs.DialogsFactory;
import com.era.views.tables.headers.TableHeaderFactory;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.event.ListSelectionEvent;
/**
 *
 * @author PC
 */
public class MonsViewController extends MonssJFrame {

    private double tipCam = 0;
            
    public MonsViewController() {
        super("window_title_mons");
        
        try{
                     
            jBDel.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBDelActionPerformed(evt);
            });
            jButton1.addActionListener((java.awt.event.ActionEvent evt) -> {
                updateButtonActionPerformed(evt);
            });
            jBNew.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBNewActionPerformed(evt);
            });
            jBBusc.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBBuscActionPerformed(evt);
            });
            jBMostT.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBMostTActionPerformed(evt);
            });
            jBDol.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBDolActionPerformed(evt);
            });
            jBGua.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBGuaActionPerformed(evt);
            });
            jBClaveSat.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBClaveSatActionPerformed(evt);
            });
            
            this.disposeButton(jBSal);
            
            //Config table
            this.BaseJTable = jTab;
            jTab.addShowColumn(TableHeaderFactory.getSigleton().getCoinsTableHeader().getROWNUMBER());
            jTab.addShowColumn(TableHeaderFactory.getSigleton().getCoinsTableHeader().getCODE());
            jTab.addShowColumn(TableHeaderFactory.getSigleton().getCoinsTableHeader().getDESCRIPTION());
            
            //When the table is selected
            jTab.setITableRowSelected((ListSelectionEvent lse, Object Object) -> {
         
                try{
                    
                    //Cast the model
                    final Coin Coin = (Coin)Object;

                    //Clear all fields befor load new ones
                    clearFields();

                    //The code can not change for editing
                    jTCod.setEditable(false);

                    //Load all the user information in fields
                    loadModelInFields(Coin);                    
                    
                }catch (Exception ex) {
                    LoggerUtility.getSingleton().logError(MonsViewController.class, ex);
                    try {
                        DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
                    } catch (Exception ex1) {
                        Logger.getLogger(MonsViewController.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                }
            });
            
            //Load all the coins in the table
            jTab.loadAllItemsInTable();
            
        }catch (Exception ex) {
            LoggerUtility.getSingleton().logError(MonsViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(MonsViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    @Override
    public void loadModelInFields(Object ObjectModel) throws  Exception {
        
        //Cast the model
        final Coin Coin = (Coin)ObjectModel;
        
        jTCod.setText(Coin.getCode());
        jTDescrip.setText(Coin.getDescription());
        jTSim.setText(Coin.getSimbol());
        jTClaveSat.setText(Coin.getC_moneda());
        jCMN.setSelected(Coin.isNational());
    }
    
    @Override
    public void clearFields(){
        
        jTCod.setText("");
        jTDescrip.setText("");
        jTSim.setText("");
        jTClaveSat.setText("");
        jCMN.setSelected(false);
        
        jTCod.setEditable(true);
        
        tipCam = 0;
    }
    
    private void jBClaveSatActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
            //Search warehouse
            final SearchViewController SearchViewController = new SearchViewController();
            SearchViewController.setSEARCH_TYPE(SearchCommonTypeEnum.CCOINS);
            SearchViewController.setButtonAceptClicked(() -> {

                final String satCode = SearchViewController.getCod();
                jTClaveSat.setText(satCode);
            });
            SearchViewController.setVisible();
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(MonsViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(MonsViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBGuaActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(MonsViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(MonsViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBDolActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{
            
            //First select a valid coin
            if(!jTab.isRowSelected()){
                DialogsFactory.getSingleton().showErrorOKNoSelectionCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                    jTab.grabFocus();
                });
                return;
            }
            
            //Get selected object
            final Coin Coin = (Coin)jTab.getRowSelected();
            
            if(tipCam==0){
                tipCam = Coin.getValue();
            }
            
            //Open the tip cam view controller
            final TipCamViewController TipCamViewController = ViewControlersFactory.getSingleton().getTipCamViewController();
            TipCamViewController.setTipCam(tipCam);
            TipCamViewController.setOnResult((double tipCam_) -> {
                tipCam = tipCam_;
            });
            TipCamViewController.setVisible();
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(MonsViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(MonsViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBMostTActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
         
            //Load all the records
            this.jTab.loadAllItemsInTable();
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(MonsViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(MonsViewController.class.getName()).log(Level.SEVERE, null, ex1);
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
            LoggerUtility.getSingleton().logError(MonsViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(MonsViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void saveOrUpdate(final boolean save) throws Exception {
        
        //Get all the values
        final String coinCode = jTCod.getText().trim();
        final String description = jTDescrip.getText().trim();
        final String simbol = jTSim.getText().trim();
        final String satCode = jTClaveSat.getText().trim();

        //Validate all the fields are properly filled
        if(coinCode.isEmpty()){
            DialogsFactory.getSingleton().showOKEmptyFieldCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                jTCod.grabFocus();
            });
            return;
        }
        if(description.isEmpty()){
            DialogsFactory.getSingleton().showOKEmptyFieldCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                jTDescrip.grabFocus();
            });
            return;
        }
        if(simbol.isEmpty()){
            DialogsFactory.getSingleton().showOKEmptyFieldCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                jTSim.grabFocus();
            });
            return;
        }
        if(satCode.isEmpty()){
            DialogsFactory.getSingleton().showOKEmptyFieldCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                jTClaveSat.grabFocus();
            });
            return;
        }
        
        if(save){ //New
            
            //Validate that the currency doesnt exists
            Coin Coin_ = (Coin)RepositoryFactory.getInstance().getCoinsRepository().getByCode(coinCode);
            if(Coin_!=null){
                DialogsFactory.getSingleton().showErrorRecordExistsOKDialog(baseJFrame, (JFrame jFrame1) -> {
                    jTCod.grabFocus();
                });
                return;
            }
        }
        
        //Question if continue
        DialogsFactory.getSingleton().showQuestionContinueDialog(baseJFrame, (JFrame jFrame) -> {

            try {

                final boolean mnNational = jCMN.isSelected();

                //Create the model
                final Coin Coin = new Coin();
                Coin.setCode(coinCode);
                Coin.setValue((float)tipCam);
                Coin.setDescription(description);
                Coin.setSimbol(simbol);
                Coin.setC_moneda(satCode);
                Coin.setNational(mnNational);

                //Save or update into database
                RepositoryFactory.getInstance().getCoinsRepository().saveOrUpdate(Coin);                

                //Reload table
                jTab.loadAllItemsInTable();

                //Announce susccess
                DialogsFactory.getSingleton().showOKOperationCompletedCallbackDialog(jFrame, (JFrame jFrame1) -> {
                });
                
            } catch (Exception ex) {
                LoggerUtility.getSingleton().logError(MonsViewController.class, ex);
                try {
                    DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
                } catch (Exception ex1) {
                    Logger.getLogger(MaxsMinsViewController.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }
        });
    }
        
    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {
        
        try{
            saveOrUpdate(false);
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(MonsViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(MonsViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBNewActionPerformed(java.awt.event.ActionEvent evt) {

	try{
            
            saveOrUpdate(true);
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(MonsViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(MonsViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBDelActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
            //First select a valid coin            
            final Coin Coin = (Coin)jTab.getRowSelected();
            if(Coin==null){
                DialogsFactory.getSingleton().showErrorOKNoSelectionCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                    jTab.grabFocus();
                });
                return;
            }
            
            //Question if continue
            DialogsFactory.getSingleton().showQuestionContinueDialog(baseJFrame, (JFrame jFrame) -> {
                
                try {                    
                    
                    //Delete from database
                    RepositoryFactory.getInstance().getCoinsRepository().delete(Coin);
                    
                    //Delete from table
                    jTab.deleteObject(Coin);
                    
                    //Announce success
                    DialogsFactory.getSingleton().showOKOperationCompletedCallbackDialog(jFrame, (JFrame jFrame1) -> {
                    });
                    
                } catch (Exception ex) {
                    LoggerUtility.getSingleton().logError(MonsViewController.class, ex);
                    try {
                        DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
                    } catch (Exception ex1) {
                        Logger.getLogger(MonsViewController.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                }
            });
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(MonsViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(MonsViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    @Override
    public List<?> getItemsToLoadInTable() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
