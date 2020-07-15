/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.easyretail.controllers.views;

import com.era.datamodels.NewVtaProductInfoDataModel;
import com.era.datamodels.enums.SearchCommonTypeEnum;
import com.era.logger.LoggerUtility;
import com.era.models.Existalma;
import com.era.models.Product;
import com.era.models.Unid;
import com.era.models.Warehouse;
import com.era.repositories.RepositoryFactory;
import com.era.utilities.UtilitiesFactory;
import com.era.views.NewVtaProductInfoJFrame;
import com.era.views.dialogs.DialogsFactory;
import java.awt.event.FocusEvent;
import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author PC
 */
public class NewVtaProductInfoController extends NewVtaProductInfoJFrame {
    
    private Product Product;
    private NewVtaProductInfoDataModel NewVtaProductInfoDataModel;
    private OnResult OnResult;
            
    public NewVtaProductInfoController() {
        super("window_title_new_vta_info_product");
        
        try{
                     
            jBSal.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBSalActionPerformed(evt);
            });
            jBProd.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBProdActionPerformed(evt);
            });
            jBExisAlma.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBExisAlmaActionPerformed(evt);
            });
            jBVeGran.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBVeGranActionPerformed(evt);
            });
            jBAcept.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBAceptActionPerformed(evt);
            });
            jBGranDescrip.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBGranDescripActionPerformed(evt);
            });            
                                    
            jComboBoxAlmacenes.loadItems();
            jComUnid.loadItems();
            
            this.JComponentUtils.addFocusLost(jTList, (FocusEvent e) -> {
                
                try {
                 
                    if(Product!=null){
                     
                        final int list = Integer.valueOf(jTList.getText().trim());

                        final boolean hasPrice = RepositoryFactory.getInstance().getProductsRepository().hasProductPriceInList(Product.getCode(), list);
                        if(!hasPrice){
                            DialogsFactory.getSingleton().showErrorOKCallbackDialog(baseJFrame, "errors_no_price_in_list_of_product", (JFrame jFrame) -> {
                                jTList.setText("1");
                            });
                        }
                        else{
                            final BigDecimal price = RepositoryFactory.getInstance().getProductsRepository().getPriceList(Product.getCode(), list);
                            jTPre.setText(UtilitiesFactory.getSingleton().getNumbersUtility().toMoneyFormat(String.valueOf(price)));        
                        }
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
            
            this.JComponentUtils.moneyFormat(jTPre);
            this.JComponentUtils.moneyFormat(jTCost);            
            this.JComponentUtils.onlyNumbers(jTDesc);
            this.JComponentUtils.onlyNumbers(jTCant);
            this.JComponentUtils.onlyNumbers(jTList);
            this.JComponentUtils.onlyNumbers(jTextFieldExistencia);            
            
            this.initImageControls(jLImg, jPanImg);
                        
            //Set the sales warehouse initially            
            setSalesWarehouse();
            
        }catch (Exception ex) {
            LoggerUtility.getSingleton().logError(NewVtaProductInfoController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(NewVtaProductInfoController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        
    }

    public void setOnResult(OnResult OnResult) {
        this.OnResult = OnResult;
    }
    
    private void setSalesWarehouse() throws Exception {
        
        //Set the sales warehouse initially            
        final Warehouse Warehouse = RepositoryFactory.getInstance().getWarehousesRepository().getSalesWarehouse();
        jComboBoxAlmacenes.selectByObject(Warehouse);
    }
    
   
    private void jBGranDescripActionPerformed(java.awt.event.ActionEvent evt) {
        
        try {
         
            if(Product==null){
                DialogsFactory.getSingleton().showErrorOKNoSelectionCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                    jTextFieldProducto.grabFocus();
                });
                return;
            }
            
            final DescripGranViewController DescripGranViewController = ViewControlersFactory.getSingleton().getDescripGranViewController();
            DescripGranViewController.setText(Product.getDescription());
            DescripGranViewController.setVisible();
            
        } catch (Exception ex) {
            LoggerUtility.getSingleton().logError(this.getClass(), ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    private void jBAceptActionPerformed(java.awt.event.ActionEvent evt) {
        
        try {
         
            //First select a product or set a profuct code
            if(Product==null){
                DialogsFactory.getSingleton().showErrorOKNoSelectionCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                    jTextFieldProducto.grabFocus();
                });
                return;
            }
            
            //Get selected warehouse
            final Warehouse Warehouse = (Warehouse)jComboBoxAlmacenes.getSelectedObject();
                    
            //First select a warehose
            if(Warehouse.getCode().isEmpty()){
                DialogsFactory.getSingleton().showErrorOKNoSelectionCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                    jComboBoxAlmacenes.grabFocus();
                });
                return;
            }
            
            //Get selected unid
            final Unid Unid = (Unid)jComUnid.getSelectedObject();
            
            //First select a unid
            if(Unid.getCode().isEmpty()){
                DialogsFactory.getSingleton().showErrorOKNoSelectionCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                    jComUnid.grabFocus();
                });
                return;
            }
            
            //Firs select a vaid qty
            final BigDecimal cant = new BigDecimal(jTCant.getText().trim());
            if(cant.compareTo(BigDecimal.ZERO)==0){
                DialogsFactory.getSingleton().showErrorInvalidAmountOKDialog(baseJFrame, (JFrame jFrame) -> {
                    jTCant.grabFocus();
                });
                return;
            }
            
            //First select a list
            final int list = Integer.valueOf(jTList.getText().trim());
            if(list < 1 && list > 10){
                DialogsFactory.getSingleton().showErrorInvalidSelectionOKDialog(baseJFrame, (JFrame jFrame) -> {
                    jTList.grabFocus();
                });
                return;
            }
            
            //Check if the product has a price on that list
            final boolean hasPrice = RepositoryFactory.getInstance().getProductsRepository().hasProductPriceInList(Product.getCode(), list);
            if(!hasPrice){
                DialogsFactory.getSingleton().showErrorOKCallbackDialog(baseJFrame, "errors_no_price_in_list_of_product", (JFrame jFrame) -> {
                    jTList.grabFocus();
                });
                return;
            }
            
            //Check that the discount be in range
            final int disccount = Integer.valueOf(jTDesc.getText().trim());
            if(disccount < 1 && list > 100){
                DialogsFactory.getSingleton().showErrorInvalidSelectionOKDialog(baseJFrame, (JFrame jFrame) -> {
                    jTDesc.grabFocus();
                });
                return;
            }
            
            DialogsFactory.getSingleton().showQuestionContinueDialog(baseJFrame, (JFrame jFrame) -> {
                
                try {
                    
                    //Get observations
                    final String observations = jTxtCodOpc.getText().trim();
                    
                    //Get the price list
                    final BigDecimal price = RepositoryFactory.getInstance().getProductsRepository().getPriceList(Product.getCode(), list);
                    
                    //Create the model
                    final NewVtaProductInfoDataModel NewVtaProductInfoDataModel_ = new NewVtaProductInfoDataModel();
                    NewVtaProductInfoDataModel_.setProduct(Product);
                    NewVtaProductInfoDataModel_.setUnid(Unid);
                    NewVtaProductInfoDataModel_.setWarehouse(Warehouse);
                    NewVtaProductInfoDataModel_.setPartObservations(observations);
                    NewVtaProductInfoDataModel_.setCant(cant);
                    NewVtaProductInfoDataModel_.setList(list);
                    NewVtaProductInfoDataModel_.setPrice(price);
                    NewVtaProductInfoDataModel_.setDisccount(disccount);
                    
                    dispose();
                    
                    if(OnResult!=null){
                        OnResult.OnResult(NewVtaProductInfoDataModel_);
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
            
        } catch (Exception ex) {
            LoggerUtility.getSingleton().logError(this.getClass(), ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    private void jBVeGranActionPerformed(java.awt.event.ActionEvent evt) {
        
        try {
            
            //First select a product or set a profuct code
            if(Product==null){
                DialogsFactory.getSingleton().showErrorOKNoSelectionCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                    jTextFieldProducto.grabFocus();
                });
                return;
            }
            
            //Get the product image path
            final String productImagePath = UtilitiesFactory.getSingleton().getImagesUtility().getProductImagePath(Product.getCode());
            
            //Open the image
            UtilitiesFactory.getSingleton().getDesktopUtility().open(productImagePath);
            
        } catch (Exception ex) {
            LoggerUtility.getSingleton().logError(this.getClass(), ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    private void jBExisAlmaActionPerformed(java.awt.event.ActionEvent evt) {
    
        try {
            
            //First select a product
            if(Product==null){
                DialogsFactory.getSingleton().showOKEmptyFieldCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                    jTextFieldProducto.grabFocus();
                });
                return;
            }
            
            //Shwo window to see existences by warehouse of the product
            final ProdExisAlmViewController ProdExisAlmViewController = ViewControlersFactory.getSingleton().getProdExisAlmViewController();
            ProdExisAlmViewController.setProductCode(Product.getCode());
            ProdExisAlmViewController.setVisible();
            
        } catch (Exception ex) {
            LoggerUtility.getSingleton().logError(this.getClass(), ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    private void jBProdActionPerformed(java.awt.event.ActionEvent evt) {
        
        try {
        
            final SearchViewController SearchViewController = new SearchViewController();
            SearchViewController.setSEARCH_TYPE(SearchCommonTypeEnum.PRODUCTS);
            SearchViewController.setButtonAceptClicked(() -> {

                try {
                 
                    final String productCode = SearchViewController.getCod();
                    jTextFieldProducto.setText(productCode);

                    //Get the product
                    Product = (Product)RepositoryFactory.getInstance().getProductsRepository().getByCode(productCode);

                    //Clear all fields
                    clearFields();

                    //Fill data in components
                    loadModelInFields(Product);
                    
                } catch (Exception ex) {
                    LoggerUtility.getSingleton().logError(this.getClass(), ex);
                    try {
                        DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
                    } catch (Exception ex1) {
                        Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex1);
                    }
                }
            });
            SearchViewController.setVisible();
            
        } catch (Exception ex) {
            LoggerUtility.getSingleton().logError(this.getClass(), ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    private void jBSalActionPerformed(java.awt.event.ActionEvent evt) {

	try{            	
         
            DialogsFactory.getSingleton().showQuestionContinueDialog(baseJFrame, (JFrame jFrame) -> {
                
                try {
                    
                    dispose();
                    
                } catch (Exception ex) {
                    LoggerUtility.getSingleton().logError(this.getClass(), ex);
                    try {
                        DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
                    } catch (Exception ex1) {
                        Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex1);
                    }
                }
            });
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
    public void loadModelInFields(Object ObjectModel) throws  Exception {
        
        //Cast model
        Product Product_;
        NewVtaProductInfoDataModel NewVtaProductInfoDataModel_ = null;
        if(ObjectModel instanceof Product){
            Product_ = (Product)ObjectModel;
        }
        else{
            NewVtaProductInfoDataModel_ = (NewVtaProductInfoDataModel)ObjectModel;
            Product_ = NewVtaProductInfoDataModel_.getProduct();
        }
        
        jTextFieldProducto.setText(Product_.getCode());
        jTDescrip.setText(Product_.getDescription());        
        jTPre.setText(UtilitiesFactory.getSingleton().getNumbersUtility().toMoneyFormat(String.valueOf(Product_.getPriceList1())));        
        
        //Check if the image product exists
        final boolean imageExists = UtilitiesFactory.getSingleton().getImagesUtility().productImageExists(Product_.getCode());
        
        //If exists
        if(imageExists){
            
            //Load the image        
            final String imagePath = UtilitiesFactory.getSingleton().getImagesUtility().getProductImagePath(Product_.getCode());
            
            //Load the image in control
            showImage(imagePath);                        
        }
        else{
            hideImage();
        }                
        
        if(NewVtaProductInfoDataModel_!=null){
            
            //Get warehouse
            final Warehouse Warehouse = NewVtaProductInfoDataModel_.getWarehouse();
            jComboBoxAlmacenes.selectByObject(Warehouse);
            jTDescripAlma.setText(Warehouse.getDescription());
            
            final Unid Unid = NewVtaProductInfoDataModel_.getUnid();
            jComUnid.selectByObject(Unid);
            jTDescripUni.setText(Unid.getDescription());
            
            jTxtCodOpc.setText(NewVtaProductInfoDataModel_.getPartObservations());
            
            //Set existence by warehouse
            final Existalma Existalma =RepositoryFactory.getInstance().getExistalmasRepository().getByWarehouseAndProduct(Warehouse.getCode(), Product_.getCode());           
            float existence = 0;
            if(Existalma!=null){
                existence = Existalma.getExist();
            }
            jTextFieldExistencia.setText(String.valueOf(existence));
        }
        else{
            
            //Select the unid of the product
            final Unid Unid = (Unid)RepositoryFactory.getInstance().getUnidsRepository().getByCode(Product_.getUnit());
            jComUnid.selectByObject(Unid);
        }
    }
    
    @Override
    public void clearFields() throws Exception{
        
        jTextFieldProducto.setText("");
        jTDescrip.setText("");
        jTDescripAlma.setText("");
        jTDescripUni.setText("");
        jTxtCodOpc.setText("");
        jTPre.setText("$0.00");
        jTDesc.setText("0");
        jTCant.setText("1");
        jTList.setText("1");
        jTextFieldExistencia.setText("0");
            
        jComboBoxAlmacenes.clearSelection();
        jComUnid.clearSelection();
        
        this.hideImage();
        
        //Set the sales warehouse initially            
        setSalesWarehouse();
    }
    
    @Override
    public List<?> getItemsToLoadInTable() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public interface OnResult{
        public void OnResult(NewVtaProductInfoDataModel NewVtaProductInfoDataModel);
    }
}
