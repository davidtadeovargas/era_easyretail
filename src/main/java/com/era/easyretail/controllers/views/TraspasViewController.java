/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.easyretail.controllers.views;

import com.era.datamodels.enums.SearchCommonTypeEnum;
import com.era.logger.LoggerUtility;
import com.era.models.Conceps;
import com.era.models.Existalma;
import com.era.models.Product;
import com.era.models.Traspas;
import com.era.models.Unid;
import com.era.models.Warehouse;
import com.era.repositories.RepositoryFactory;
import com.era.views.TraspasJFrame;
import com.era.views.dialogs.DialogsFactory;
import com.era.views.tables.headers.TableHeaderFactory;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author PC
 */
public class TraspasViewController extends TraspasJFrame{
    
    public TraspasViewController() {
        super("window_title_trapas");
        
        try{
            
            jBProd.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBProdActionPerformed(evt);
            });
            jBExisAlma.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBExisAlmaActionPerformed(evt);
            });
            jBConcep.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBConcepActionPerformed(evt);
            });
            jBconfirmar.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBconfirmarActionPerformed(evt);
            });
            jBTransfe.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBTransfeActionPerformed(evt);
            });
            jBSal.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBSalActionPerformed(evt);
            });
            jBBusc.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBBuscActionPerformed(evt);
            });
            jBMosTod.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBPrec1ActionPerformed(evt);
            });
            jBMosTod.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBMosTodActionPerformed(evt);
            });
            
            //Config table
            this.BaseJTable = jTab;
            jTab.addShowColumn(TableHeaderFactory.getSigleton().getTraspassTableHeader().getROWNUMBER());
            jTab.addShowColumn(TableHeaderFactory.getSigleton().getTraspassTableHeader().getCODE());
            jTab.addShowColumn(TableHeaderFactory.getSigleton().getTraspassTableHeader().getALMA());
            jTab.addShowColumn(TableHeaderFactory.getSigleton().getTraspassTableHeader().getUNID());
            jTab.addShowColumn(TableHeaderFactory.getSigleton().getTraspassTableHeader().getCONCEP());
            jTab.addShowColumn(TableHeaderFactory.getSigleton().getTraspassTableHeader().getCANTSAL());
            jTab.addShowColumn(TableHeaderFactory.getSigleton().getTraspassTableHeader().getALMAA());
            jTab.addShowColumn(TableHeaderFactory.getSigleton().getTraspassTableHeader().getCANTENT());
            jTab.addShowColumn(TableHeaderFactory.getSigleton().getTraspassTableHeader().getFALT());
            jTab.addShowColumn(TableHeaderFactory.getSigleton().getTraspassTableHeader().getSUCU());
            jTab.addShowColumn(TableHeaderFactory.getSigleton().getTraspassTableHeader().getNOCAJ());
            jTab.addShowColumn(TableHeaderFactory.getSigleton().getTraspassTableHeader().getESTAC());
            
            //Load all the records
            jTab.initTableWithPagination();
            
            //Load warehouses combobox
            jComAlma.loadItems();
            jComAlma2.loadItems();
            jComUnid.loadItems();
            
            this.JComponentUtils.onlyDecimals(jTCant);
            
            jComAlma.setChangeSelectionListener((Object ObjectModel) -> {
                
                //Cast model
                final Warehouse Warehouse = (Warehouse)ObjectModel;
                
                //Set the existence in field
                loadWarehouseExistence();
            });
            
        }catch (Exception ex) {
            LoggerUtility.getSingleton().logError(TraspasViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(TraspasViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    @Override
    public void loadModelInFields(Object ObjectModel) throws  Exception {        
    }
    
    private void jBPrec1ActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
            //Load all the users
            this.jTab.loadAllItemsInTable();
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(TraspasViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(TraspasViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    @Override
    public void clearFields(){
    }
    
    private void jBMosTodActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(TraspasViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(TraspasViewController.class.getName()).log(Level.SEVERE, null, ex1);
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
            LoggerUtility.getSingleton().logError(TraspasViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(TraspasViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBSalActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
            DialogsFactory.getSingleton().showQuestionExitDialog(baseJFrame, (JFrame jFrame) -> {
                dispose(); 
            });
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(TraspasViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(TraspasViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBTransfeActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
            //Fist select a product
            final String productCode = jTProd.getText().trim();
            if(productCode.isEmpty()){
                DialogsFactory.getSingleton().showOKEmptyFieldCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                    jTProd.grabFocus();
                });
                return;
            }
            
            //Get the product
            final Product Product = (Product)RepositoryFactory.getInstance().getProductsRepository().getByCode(productCode);

            //If product not exists stop
            if(Product==null){
                DialogsFactory.getSingleton().showErrorOKRecordNotExistsCallbackDialog(baseJFrame, (JFrame jFrame_) -> {
                    jTProd.grabFocus();
                });
                return;
            }
            
            //First select warehouse from
            if(!jComAlma.isSelectedObject()){
                DialogsFactory.getSingleton().showErrorOKNoSelectionCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                    jComAlma.requestFocus();
                });
                return;
            }
            
            //First select unid from
            if(!jComUnid.isSelectedObject()){
                DialogsFactory.getSingleton().showErrorOKNoSelectionCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                    jComUnid.requestFocus();
                });
                return;
            }
            
            //First select warehouse to
            if(!jComAlma2.isSelectedObject()){
                DialogsFactory.getSingleton().showErrorOKNoSelectionCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                    jComAlma2.requestFocus();
                });
                return;
            }
            
            //Fist select a concept
            final String coceptCode = jTConcep.getText().trim();
            if(coceptCode.isEmpty()){
                DialogsFactory.getSingleton().showOKEmptyFieldCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                    jTConcep.grabFocus();
                });
                return;
            }
            
            //Get the concep
            final Conceps Conceps = (Conceps)RepositoryFactory.getInstance().getConcepssRepository().getByCode(coceptCode);
            
            //If the concep doesnt exists stop
            if(Conceps==null){
                DialogsFactory.getSingleton().showErrorOKRecordNotExistsCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                    jTConcep.grabFocus();
                });
                return;
            }
            
            //Get the warehouse from
            final Warehouse Warehouse = (Warehouse)jComAlma.getSelectedObject();
            
            //Validate that there are existences from
            final Existalma Existalma = RepositoryFactory.getInstance().getExistalmasRepository().getByWarehouseAndProduct(Warehouse.getCode(), productCode);
            if(Existalma==null || Existalma.getExist() <= 0){
                DialogsFactory.getSingleton().showErrorOKCallbackDialog(baseJFrame, "errors_missing_existences", (JFrame jFrame) -> {
                    jComAlma.requestFocus();
                });
                return;
            }
            
            //Question if continue
            DialogsFactory.getSingleton().showQuestionContinueDialog(baseJFrame, (JFrame jFrame) -> {
                
                try {

                    //Get the unid
                    final Unid Unid = (Unid)jComUnid.getSelectedObject();
                    
                    //Get the amount
                    final double cant = Double.valueOf(jTCant.getText().trim());
                    
                    //Get the warehouse to
                    final Warehouse WarehouseTo = (Warehouse)jComAlma2.getSelectedObject();
                    
                    //Create the model
                    final Traspas Traspas = new Traspas();
                    Traspas.setCode(productCode);
                    Traspas.setAlma(Warehouse.getCode());
                    Traspas.setUnid(Unid.getCode());
                    Traspas.setConcep(coceptCode);
                    Traspas.setAlmaa(WarehouseTo.getCode());
                    Traspas.setCantsal((float)cant);
                    Traspas.setCantent((float)cant);
                    
                    //Save the new record
                    RepositoryFactory.getInstance().getTraspassRepository().traspass(Traspas);
                    
                    //Realod table
                    jTab.initTableWithPagination();
                    
                    //Success
                    DialogsFactory.getSingleton().showOKOperationCompletedCallbackDialog(jFrame, (JFrame jFrame1) -> {
                    });
                    
                } catch (Exception ex) {
                    LoggerUtility.getSingleton().logError(TraspasViewController.class, ex);
                    try {
                        DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
                    } catch (Exception ex1) {
                        Logger.getLogger(TraspasViewController.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                }
            });
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(TraspasViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(TraspasViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBconfirmarActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(TraspasViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(TraspasViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBConcepActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
            //Search concep
            final SearchViewController SearchViewController = new SearchViewController();
            SearchViewController.setSEARCH_TYPE(SearchCommonTypeEnum.CONCEPTS);
            SearchViewController.setButtonAceptClicked(() -> {

                final String concepCode = SearchViewController.getCod();
                jTConcep.setText(concepCode);
            });
            SearchViewController.setVisible();
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(TraspasViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(TraspasViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBExisAlmaActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
    
            //Fist select a product
            final String productCode = jTProd.getText().trim();
            if(productCode.isEmpty()){
                DialogsFactory.getSingleton().showOKEmptyFieldCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                    jTProd.grabFocus();
                });
                return;
            }
            
            //Show the existences product by warehouse
            final ProdExisAlmViewController ProdExisAlmViewController = ViewControlersFactory.getSingleton().getProdExisAlmViewController();
            ProdExisAlmViewController.setProductCode(productCode);
            ProdExisAlmViewController.setVisible();
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(TraspasViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(TraspasViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void loadWarehouseExistence(){
        
        try {
            
            //If no product selected return
            final String productCode = jTProd.getText().trim();
            if(productCode.isEmpty()){
                return;
            }
            
            //First select a warehouse
            if(!jComAlma.isSelectedObject()){
                return;
            }
            
            //Get selected object
            final Warehouse Warehouse = (Warehouse)jComAlma.getSelectedObject();
            
            //Get existence for the warehouse and product
            final Existalma Existalma = RepositoryFactory.getInstance().getExistalmasRepository().getByWarehouseAndProduct(Warehouse.getCode(), productCode);
            
            double existence = 0;
            if(Existalma!=null){
                existence = Existalma.getExist();
            }
            
            //Set existence
            jTExist.setText(String.valueOf(existence));
            
        } catch (Exception ex) {
            LoggerUtility.getSingleton().logError(TraspasViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(TraspasViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    private void jBProdActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
            //Search warehouse
            final SearchViewController SearchViewController = new SearchViewController();
            SearchViewController.setSEARCH_TYPE(SearchCommonTypeEnum.PRODUCTS);
            SearchViewController.setButtonAceptClicked(() -> {

                final String productCode = SearchViewController.getCod();
                jTProd.setText(productCode);
                final String description = SearchViewController.getDescrip();
                jTDescrip.setText(description);
                
                //Set the existence in field
                loadWarehouseExistence();
            });
            SearchViewController.setVisible();
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(TraspasViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(TraspasViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    @Override
    public List<?> getItemsToLoadInTable() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
