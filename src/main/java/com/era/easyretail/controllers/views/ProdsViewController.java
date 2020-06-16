/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.easyretail.controllers.views;

import com.era.datamodels.LPrecsDatamodel;
import com.era.datamodels.enums.SearchCommonTypeEnum;
import com.era.easyretail.validators.ProductsValidator;
import com.era.logger.LoggerUtility;
import com.era.models.Anaqs;
import com.era.models.CClaveprodserv;
import com.era.models.ImpuesXProduct;
import com.era.models.Kits;
import com.era.models.Line;
import com.era.models.Lugs;
import com.era.models.Meds;
import com.era.models.Product;
import com.era.models.Supplier;
import com.era.models.Unid;
import com.era.repositories.RepositoryFactory;
import com.era.utilities.UtilitiesFactory;
import com.era.utilities.filechooser.FTecnicaFileChooserUtility;
import com.era.utilities.filechooser.ImageFileChooserUtility;
import com.era.views.ProdsJFrame;
import com.era.views.dialogs.DialogsFactory;
import com.era.views.dialogs.ErrorOKDialog;
import com.era.views.tables.headers.TableHeaderFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.event.ListSelectionEvent;

/**
 *
 * @author PC
 */
public class ProdsViewController extends ProdsJFrame {
    
    private List<ImpuesXProduct> taxesGlobal = new ArrayList<>();
    private List<Kits> kits;
    private LPrecsDatamodel LPrecsDatamodel;
            
    public ProdsViewController() {
        super("window_title_prods");
        
        try{            
            lprecsButton.addActionListener((java.awt.event.ActionEvent evt) -> {
                lprecsButtonActionPerformed(evt);
            });
            jBMosT.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBMosTActionPerformed(evt);
            });
            jBGuar.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBGuarActionPerformed(evt);
            });
            jBNew.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBNewActionPerformed(evt);
            });
            jBDel.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBDelActionPerformed(evt);
            });
            jBLim1.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBLim1ActionPerformed(evt);
            });
            jBLim.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBLimActionPerformed(evt);
            });
            jBSal.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBSalActionPerformed(evt);
            });
            jBClaveSat.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBClaveSatActionPerformed(evt);
            });            
            jBBusc2.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBBusc2ActionPerformed(evt);
            });
            jBBusc.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBBuscActionPerformed(evt);
            });
            button_impuestos.addActionListener((java.awt.event.ActionEvent evt) -> {
                button_impuestosActionPerformed(evt);
            });
            jBCargImg.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBCargImgActionPerformed(evt);
            });
            jBDelImg.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBDelImgActionPerformed(evt);
            });
            jBVeGran.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBVeGranActionPerformed(evt);
            });
            jBExisAlma.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBExisAlmaActionPerformed(evt);
            });
            jBCargF.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBCargFActionPerformed(evt);
            });
            jBDelF.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBDelFActionPerformed(evt);
            });
            jBFTec.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBFTecActionPerformed(evt);
            });
            jBComps.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBCompsActionPerformed(evt);
            });
            
            //Disable the save button
            jBGuar.setEnabled(false);
                
            //Init table
            this.BaseJTable = jTab;
            jTab.addShowColumn(TableHeaderFactory.getSigleton().getProductsTableHeader().getROWNUMBER());
            jTab.addShowColumn(TableHeaderFactory.getSigleton().getProductsTableHeader().getCODE());
            jTab.addShowColumn(TableHeaderFactory.getSigleton().getProductsTableHeader().getDESCRIPTION());
            jTab.setITableRowSelected((ListSelectionEvent lse, Object Object) -> {
                
                try{
                    
                    //Cast the model
                    final Product Product = (Product)Object;

                    //Enable the save button
                    jBGuar.setEnabled(true);

                    //Load all the values in fields
                    loadModelInFields(Product);
                    
                    LPrecsDatamodel = null;
                    
                    kits = null;
                    
                }catch (Exception ex) {
                    LoggerUtility.getSingleton().logError(ProdsViewController.class, ex);
                    try {
                        DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
                    } catch (Exception ex1) {
                        Logger.getLogger(ProdsViewController.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                }
            });
            
            //Load all the table items with pagination
            this.jTab.initTableWithPagination();
            
            //Load all the comboboxes
            jComLin.loadItems();
            jComMeds.loadItems();
            jComUni.loadItems();
            jComAna.loadItems();
            jComLug.loadItems();
            
        }catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ProdsViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(ProdsViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }

    @Override
    public void loadModelInFields(Object ObjectModel) throws  Exception {
        
        //Cast the model
        final Product Product_ = (Product)ObjectModel;
        
        //Fill all the fields
        jTProd.setText(Product_.getCode());
        jTProd.setEnabled(false);
        jTADescrip.setText(Product_.getDescription());
        jTExist.setText(String.valueOf(Product_.getExistence()));
        jTAInfor.setText(Product_.getInformation());
        jTMin.setText(String.valueOf(Product_.getMinimun()));
        jTCodProv.setText(Product_.getProviderOptional1());
        jTMax.setText(String.valueOf(Product_.getMaximum()));
        jTNom.setText(Product_.getName());
        jTClaveSat.setText(Product_.getKeySAT());
        
        //Select in comboboxes
        final Line Line = (Line)RepositoryFactory.getInstance().getLinesRepository().getByCode(Product_.getCodeLine());
        if(Line != null){
            jComLin.selectByObject(Line);
        }        
        final Meds Meds = (Meds)RepositoryFactory.getInstance().getMedssRepository().getByCode(Product_.getCodeMeasure());
        if(Meds!=null){
            jComMeds.selectObject(Meds);
        }            
        final Unid Unid = (Unid)RepositoryFactory.getInstance().getUnidsRepository().getByCode(Product_.getUnit());
        if(Unid!=null){
            jComUni.selectByObject(Unid);
        }            
        final Anaqs Anaqs = (Anaqs)RepositoryFactory.getInstance().getAnaqssRepository().getByCode(Product_.getShelf());
        if(Anaqs!=null){
            jComAna.selectByObject(Anaqs);
        }            
        final Lugs Lugs = (Lugs)RepositoryFactory.getInstance().getLugssRepository().getByCode(Product_.getPlace());
        if(Lugs!=null){
            jComLug.selectByObject(Lugs);
        }            
        
        //Check if the image product exists
        final boolean imageExists = UtilitiesFactory.getSingleton().getImagesUtility().productImageExists(Product_.getCode());
        
        //If exists
        if(imageExists){
            
            //Load the image        
            final String imagePath = UtilitiesFactory.getSingleton().getImagesUtility().getProductImagePath(Product_.getCode());
            
            //Load the image in control
            jLImg.setIcon(new ImageIcon(imagePath));
            jLImg.setVisible(true);
        }
        else{
            jLImg.setVisible(false);
        }
        
        //Check or uncheck         
        jCInvent.setSelected(Product_.getIventory());
        jCPed.setSelected(Product_.isLotPediment());
        jCComp.setSelected(Product_.getCompound());
        jCEsParaVent.setSelected(Product_.getIsForSale());
        jCNoSolMaxMin.setSelected(Product_.getAskMaxMin());
        jCBajCost.setSelected(Product_.getLowerCost());
        jCNoSer.setSelected(Product_.isAskSerie());
                
        jBComps.setEnabled(Product_.getCompound());
        
        //Get the genera existence for the product
        final float generalExistence = RepositoryFactory.getInstance().getExistalmasRepository().getGeneralExistenceFromProduct(Product_.getCode());
        jTExist.setText(String.valueOf(generalExistence));
    }
    
    @Override
    public void clearFields(){
        
        jTProd.setText("");
        jTADescrip.setText("");
        jTExist.setText("");
        jTAInfor.setText("");
        jTMin.setText("1");
        jTCodProv.setText("");
        jTMax.setText("2");
        jTNom.setText("");
        jTClaveSat.setText("");
        
        taxesGlobal = new ArrayList<>(); 
        jLImg.setVisible(false);
        
        //Reset comboboxes
        jComLin.clearSelection();
        jComMeds.clearSelection();
        jComUni.clearSelection();
        jComAna.clearSelection();
        jComLug.clearSelection();
        
        jCInvent.setSelected(true);
        jCPed.setSelected(false);
        jCComp.setSelected(false);
        jCEsParaVent.setSelected(true);
        jCNoSolMaxMin.setSelected(false);
        jCBajCost.setSelected(false);
        jCNoSer.setSelected(false);
                
        jBComps.setEnabled(false);
    }
            
    private void lprecsButtonActionPerformed(java.awt.event.ActionEvent evt) {
        
        try{
            
            //First select a product or set a profuct code
            if(!jTab.isRowSelected() && jTProd.getText().trim().isEmpty()){
                DialogsFactory.getSingleton().showErrorOKNoSelectionCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                    jTProd.grabFocus();
                });
                return;
            }
            
            //Get the producto code
            String productCode;
            if(jTab.isRowSelected()){
                Product Product_ = (Product)jTab.getRowSelected();
                productCode = Product_.getCode();
            }
            else {
                productCode = jTProd.getText().trim();
            }
            
            //Get the product from db
            final Product Product_ = RepositoryFactory.getInstance().getProductsRepository().getProductByCode(productCode);
            
            //If the product doesnt exist
            if(Product_ == null){
                DialogsFactory.getSingleton().showErrorOKCallbackDialog(baseJFrame, "errors_first_product_exists_to_save_image", (JFrame jFrame) -> {
                    jTProd.grabFocus();
                });
                return;
            }
            
            //Create quantities
            if(LPrecsDatamodel==null){
                LPrecsDatamodel = new LPrecsDatamodel();
                LPrecsDatamodel.setPriceList1(String.valueOf(Product_.getPriceList1()));
                LPrecsDatamodel.setPriceList2(String.valueOf(Product_.getPriceList2()));
                LPrecsDatamodel.setPriceList3(String.valueOf(Product_.getPriceList3()));
                LPrecsDatamodel.setPriceList4(String.valueOf(Product_.getPriceList4()));
                LPrecsDatamodel.setPriceList5(String.valueOf(Product_.getPriceList5()));
                LPrecsDatamodel.setPriceList6(String.valueOf(Product_.getPriceList6()));
                LPrecsDatamodel.setPriceList7(String.valueOf(Product_.getPriceList7()));
                LPrecsDatamodel.setPriceList8(String.valueOf(Product_.getPriceList8()));
                LPrecsDatamodel.setPriceList9(String.valueOf(Product_.getPriceList9()));
                LPrecsDatamodel.setPriceList10(String.valueOf(Product_.getPriceList10()));
                LPrecsDatamodel.setUtility1(String.valueOf(Product_.getUtility1()));
                LPrecsDatamodel.setUtility2(String.valueOf(Product_.getUtility2()));
                LPrecsDatamodel.setUtility3(String.valueOf(Product_.getUtility3()));
                LPrecsDatamodel.setUtility4(String.valueOf(Product_.getUtility4()));
                LPrecsDatamodel.setUtility5(String.valueOf(Product_.getUtility5()));
                LPrecsDatamodel.setUtility6(String.valueOf(Product_.getUtility6()));
                LPrecsDatamodel.setUtility7(String.valueOf(Product_.getUtility7()));
                LPrecsDatamodel.setUtility8(String.valueOf(Product_.getUtility8()));
                LPrecsDatamodel.setUtility9(String.valueOf(Product_.getUtility9()));
                LPrecsDatamodel.setUtility10(String.valueOf(Product_.getUtility10()));
                LPrecsDatamodel.setUtilSales1(String.valueOf(Product_.getUtilSales1()));
                LPrecsDatamodel.setUtilSales2(String.valueOf(Product_.getUtilSales2()));
                LPrecsDatamodel.setUtilSales3(String.valueOf(Product_.getUtilSales3()));
                LPrecsDatamodel.setUtilSales4(String.valueOf(Product_.getUtilSales4()));
                LPrecsDatamodel.setUtilSales5(String.valueOf(Product_.getUtilSales5()));
                LPrecsDatamodel.setUtilSales6(String.valueOf(Product_.getUtilSales6()));
                LPrecsDatamodel.setUtilSales7(String.valueOf(Product_.getUtilSales7()));
                LPrecsDatamodel.setUtilSales8(String.valueOf(Product_.getUtilSales8()));
                LPrecsDatamodel.setUtilSales9(String.valueOf(Product_.getUtilSales9()));
                LPrecsDatamodel.setUtilSales10(String.valueOf(Product_.getUtilSales10()));
            }
            
            final LPrecsViewController LPrecsViewController = ViewControlersFactory.getSingleton().getLPrecsViewController();
            LPrecsViewController.setLPrecsDatamodel(LPrecsDatamodel);
            LPrecsViewController.setOnResult((LPrecsDatamodel LPrecsDatamodel_) -> {                
                LPrecsDatamodel = LPrecsDatamodel_;
            });
            LPrecsViewController.setVisible();
            
        }catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ProdsViewController.class, ex);
            try {
                    DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                    Logger.getLogger(ProdsViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBClaveSatActionPerformed(java.awt.event.ActionEvent evt) {

	try{            	
            
            //Search warehouse
            final SearchViewController SearchViewController = new SearchViewController();
            SearchViewController.setSEARCH_TYPE(SearchCommonTypeEnum.CLAVES_PROD_SAT);
            SearchViewController.setButtonAceptClicked(() -> {

                final String claveCode = SearchViewController.getCod();
                jTClaveSat.setText(claveCode);
            });
            SearchViewController.setVisible();
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ProdsViewController.class, ex);
            try {
                    DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                    Logger.getLogger(ProdsViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBBusc2ActionPerformed(java.awt.event.ActionEvent evt) {

	try{            	
            
            //Search warehouse
            final SearchViewController SearchViewController = new SearchViewController();
            SearchViewController.setSEARCH_TYPE(SearchCommonTypeEnum.SUPPLIERS);
            SearchViewController.setButtonAceptClicked(() -> {

                final String supplierCode = SearchViewController.getCod();
                jTCodProv.setText(supplierCode);
            });
            SearchViewController.setVisible();
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ProdsViewController.class, ex);
            try {
                    DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                    Logger.getLogger(ProdsViewController.class.getName()).log(Level.SEVERE, null, ex1);
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
            LoggerUtility.getSingleton().logError(ProdsViewController.class, ex);
            try {
                    DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                    Logger.getLogger(ProdsViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
        
    private void jBMosTActionPerformed(java.awt.event.ActionEvent evt) {

	try{            	
            
            //Load all the users
            this.jTab.loadAllItemsInTable();
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ProdsViewController.class, ex);
            try {
                    DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                    Logger.getLogger(ProdsViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void saveOrUpdate(final boolean save) throws Exception {
        
        //Get primary values
        final String productCode = jTProd.getText().trim();
        final String description = jTADescrip.getText().trim();
        final String name = jTNom.getText().trim();
        final String satKey = jTClaveSat.getText().trim();                        

        try{
            
            //Validate all the needed fields are filled
            final ProductsValidator ProductsValidator = new ProductsValidator();
            ProductsValidator.setCode(productCode);
            ProductsValidator.setName(name);
            ProductsValidator.setDescription(description);
            ProductsValidator.setKeySAT(productCode);
            
            if(save){
                ProductsValidator.validateInsert();
            }
            else{
                ProductsValidator.validateUpdate();
            }
            
        }catch(Exception e){
            final ErrorOKDialog ErrorOKDialog = DialogsFactory.getSingleton().getErrorOKDialog(baseJFrame);
            ErrorOKDialog.setText(e.getMessage());
            ErrorOKDialog.show();
            return;
        }
        
        //If it is for new 
        if(save){
            
            //Get the product
            final Product Product = (Product)RepositoryFactory.getInstance().getProductsRepository().getProductByCode(productCode);
            
            //If exists
            if(Product != null){
                DialogsFactory.getSingleton().showErrorRecordExistsOKDialog(baseJFrame, (JFrame jFrame) -> {
                    jTProd.grabFocus();
                });
                return;
            }
        }
        
        //If it is not empty
        if(!satKey.isEmpty()){

            //Get the model obect
            final CClaveprodserv CClaveprodserv = (CClaveprodserv)RepositoryFactory.getInstance().getCClaveprodservsRepository().getByCode(satKey);

            //If it doesnt exists
            if(CClaveprodserv==null){
                DialogsFactory.getSingleton().showErrorOKRecordNotExistsCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                    jTClaveSat.grabFocus();
                });
                return;
            }
        }

        //Validate that the supplier exists
        final String supplier = jTCodProv.getText().trim();
        if(!supplier.isEmpty()){
            final Supplier Supplier = (Supplier)RepositoryFactory.getInstance().getSuppliersRepository().getByCode(supplier);                
            if(Supplier==null){
                DialogsFactory.getSingleton().showErrorOKRecordNotExistsCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                        jTCodProv.grabFocus();
                    });
                    return;
            }
        }
        
        //Question if continue
        DialogsFactory.getSingleton().showQuestionContinueDialog(baseJFrame, (JFrame jFrame) -> {

            try{

                //Get all the values from fields
                final String information = jTAInfor.getText().trim();
                final String minimum = jTMin.getText().trim();
                final String maximum = jTMin.getText().trim();                    
                final boolean isForSale = jCEsParaVent.isSelected();
                final boolean askForMinAndMax = jCNoSolMaxMin.isSelected();
                final boolean sellUnderCost = jCBajCost.isSelected();
                final boolean isService = jCServ.isSelected();
                final boolean isInventarable = jCInvent.isSelected();
                final boolean showXml = jCMostrarXml.isSelected();
                final boolean askSerie = jCNoSer.isSelected();
                final boolean isPediment = jCPed.isSelected();
                final boolean isKit = jCComp.isSelected();

                //Create the model
                Product Product;
                if(save){
                    Product = new Product();                    
                }
                else{
                 
                    //Get the product from db
                    Product = (Product)RepositoryFactory.getInstance().getProductsRepository().getByCode(productCode);
                }
                Product.setCode(productCode);
                Product.setDescription(description);
                Product.setName(name);
                Product.setKeySAT(satKey);
                Product.setInformation(information);
                Product.setMinimun(Integer.valueOf(minimum));
                Product.setMaximum(Integer.valueOf(maximum));
                Product.setIsForSale(isForSale);
                Product.setAskMaxMin(askForMinAndMax);
                Product.setLowerCost(sellUnderCost);
                Product.setProviderOptional1(supplier);
                Product.setService(isService);
                Product.setIventory(isInventarable);
                Product.setAskSerie(askSerie);
                Product.setLotPediment(isPediment);
                Product.setCompound(isKit);

                //If any modification in price lists
                if(LPrecsDatamodel != null){
                    
                    Product.setPriceList1(Float.valueOf(LPrecsDatamodel.getPriceList1()));
                    Product.setPriceList2(Float.valueOf(LPrecsDatamodel.getPriceList2()));
                    Product.setPriceList3(Float.valueOf(LPrecsDatamodel.getPriceList3()));
                    Product.setPriceList4(Float.valueOf(LPrecsDatamodel.getPriceList4()));
                    Product.setPriceList5(Float.valueOf(LPrecsDatamodel.getPriceList5()));
                    Product.setPriceList6(Float.valueOf(LPrecsDatamodel.getPriceList6()));
                    Product.setPriceList7(Float.valueOf(LPrecsDatamodel.getPriceList7()));
                    Product.setPriceList8(Float.valueOf(LPrecsDatamodel.getPriceList8()));
                    Product.setPriceList9(Float.valueOf(LPrecsDatamodel.getPriceList9()));
                    Product.setPriceList10(Float.valueOf(LPrecsDatamodel.getPriceList10()));
                    
                    Product.setUtility1(Float.valueOf(LPrecsDatamodel.getUtility1()));
                    Product.setUtility2(Float.valueOf(LPrecsDatamodel.getUtility2()));
                    Product.setUtility3(Float.valueOf(LPrecsDatamodel.getUtility3()));
                    Product.setUtility4(Float.valueOf(LPrecsDatamodel.getUtility4()));
                    Product.setUtility5(Float.valueOf(LPrecsDatamodel.getUtility5()));
                    Product.setUtility6(Float.valueOf(LPrecsDatamodel.getUtility6()));
                    Product.setUtility7(Float.valueOf(LPrecsDatamodel.getUtility7()));
                    Product.setUtility8(Float.valueOf(LPrecsDatamodel.getUtility8()));
                    Product.setUtility9(Float.valueOf(LPrecsDatamodel.getUtility9()));
                    Product.setUtility10(Float.valueOf(LPrecsDatamodel.getUtility10()));
                    
                    Product.setUtilSales1(Float.valueOf(LPrecsDatamodel.getUtilSales1()));
                    Product.setUtilSales2(Float.valueOf(LPrecsDatamodel.getUtilSales2()));
                    Product.setUtilSales3(Float.valueOf(LPrecsDatamodel.getUtilSales3()));
                    Product.setUtilSales4(Float.valueOf(LPrecsDatamodel.getUtilSales4()));
                    Product.setUtilSales5(Float.valueOf(LPrecsDatamodel.getUtilSales5()));
                    Product.setUtilSales6(Float.valueOf(LPrecsDatamodel.getUtilSales6()));
                    Product.setUtilSales7(Float.valueOf(LPrecsDatamodel.getUtilSales7()));
                    Product.setUtilSales8(Float.valueOf(LPrecsDatamodel.getUtilSales8()));
                    Product.setUtilSales9(Float.valueOf(LPrecsDatamodel.getUtilSales9()));
                    Product.setUtilSales10(Float.valueOf(LPrecsDatamodel.getUtilSales10()));
                }
                
                //Save the product and taxes of the product
                RepositoryFactory.getInstance().getProductsRepository().addOrUpdateProduct(Product, taxesGlobal, kits);

                //Reload the table                
                jTab.loadAllItemsInTable();
                    
                //Announce the user of success
                DialogsFactory.getSingleton().showOKOperationCompletedCallbackDialog(jFrame, (JFrame jFrame1) -> {
                });

            }catch (Exception ex) {
                LoggerUtility.getSingleton().logError(ProdsViewController.class, ex);
                try {
                        DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
                } catch (Exception ex1) {
                        Logger.getLogger(ProdsViewController.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }
        });
    }
    
    private void jBGuarActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            saveOrUpdate(false);
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ProdsViewController.class, ex);
            try {
                    DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                    Logger.getLogger(ProdsViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBNewActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{
            saveOrUpdate(true);
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ProdsViewController.class, ex);
            try {
                    DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                    Logger.getLogger(ProdsViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBDelActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
                                    
            //Select first
            if(!jTab.isRowSelected()){
                
                DialogsFactory.getSingleton().showErrorOKNoSelectionCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                    jTProd.grabFocus();
                });
                return;
            }
            
            //Get the product code
            final Product Product_ = (Product)jTab.getRowSelected();
            final String productCode = Product_.getCode();
            
            //Question if continue
            DialogsFactory.getSingleton().showQuestionContinueDialog(baseJFrame, (JFrame jFrame) -> {
                
                try{
                    
                    //Delete the product from the database
                    RepositoryFactory.getInstance().getProductsRepository().deleteProductByCode(productCode);
                    
                    //Reload the table
                    jTab.loadAllItemsInTable();
                    
                    //Annoucne the user of the success
                    DialogsFactory.getSingleton().showOKOperationCompletedCallbackDialog(jFrame, null);                    
                    
                }catch (Exception ex) {
                    LoggerUtility.getSingleton().logError(ProdsViewController.class, ex);
                    try {
                            DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
                    } catch (Exception ex1) {
                            Logger.getLogger(ProdsViewController.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                }
            });
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ProdsViewController.class, ex);
            try {
                    DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                    Logger.getLogger(ProdsViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBLim1ActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ProdsViewController.class, ex);
            try {
                    DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                    Logger.getLogger(ProdsViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBLimActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            this.clearFields();
            
            //Enable the save button
            jBGuar.setEnabled(false);
            
            //Enable product code field
            jTProd.setEnabled(true);
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ProdsViewController.class, ex);
            try {
                    DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                    Logger.getLogger(ProdsViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBSalActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
            DialogsFactory.getSingleton().showQuestionContinueDialog(baseJFrame, (JFrame jFrame) -> {
                dispose();
            });
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ProdsViewController.class, ex);
            try {
                    DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                    Logger.getLogger(ProdsViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void button_impuestosActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
            //First select a product or set a profuct code
            if(!jTab.isRowSelected() && jTProd.getText().trim().isEmpty()){
                DialogsFactory.getSingleton().showErrorOKNoSelectionCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                    jTProd.grabFocus();
                });
                return;
            }
            
            //Get the producto code
            String productCode;
            if(jTab.isRowSelected()){
                Product Product_ = (Product)jTab.getRowSelected();
                productCode = Product_.getCode();
            }
            else {
                productCode = jTProd.getText().trim();
            }
            
            //Get the product from db
            final Product Product_ = RepositoryFactory.getInstance().getProductsRepository().getProductByCode(productCode);
            
            //If the product doesnt exist
            if(Product_ == null){
                DialogsFactory.getSingleton().showErrorOKCallbackDialog(baseJFrame, "errors_first_product_exists_to_save_image", (JFrame jFrame) -> {
                    jTProd.grabFocus();
                });
                return;
            }
            
            //Get all the product taxes
            taxesGlobal = RepositoryFactory.getInstance().getImpuesXProductRepository().getAllByProd(productCode);
                
            //Show the taxes producto window
            final Impuestos_X_productos_nuevoViewController Impuestos_X_productos_nuevoViewController = ViewControlersFactory.getSingleton().getImpuestos_X_productos_nuevoViewController();
            Impuestos_X_productos_nuevoViewController.setProductCode(productCode);
            Impuestos_X_productos_nuevoViewController.setTaxes(taxesGlobal);
            Impuestos_X_productos_nuevoViewController.setCloseWindow((List<ImpuesXProduct> taxes) -> {
                taxesGlobal = taxes; 
            });
            Impuestos_X_productos_nuevoViewController.setVisible();                        
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ProdsViewController.class, ex);
            try {
                    DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                    Logger.getLogger(ProdsViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBCargImgActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
            //First select a product or set a profuct code
            if(!jTab.isRowSelected() && jTProd.getText().trim().isEmpty()){
                DialogsFactory.getSingleton().showErrorOKNoSelectionCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                    jTProd.grabFocus();
                });
                return;
            }
            
            //Get the producto code
            String productCode;
            if(jTab.isRowSelected()){
                Product Product_ = (Product)jTab.getRowSelected();
                productCode = Product_.getCode();
            }
            else {
                productCode = jTProd.getText().trim();
            }
            
            //Get the product from db
            final Product Product_ = RepositoryFactory.getInstance().getProductsRepository().getProductByCode(productCode);
            
            //If the product doesnt exist
            if(Product_ == null){
                DialogsFactory.getSingleton().showErrorOKCallbackDialog(baseJFrame, "errors_first_product_exists_to_save_image", (JFrame jFrame) -> {
                    jTProd.grabFocus();
                });
                return;
            }
            
            final ImageFileChooserUtility ImageFileChooserUtility = UtilitiesFactory.getSingleton().getImageFileChooserUtility();
            ImageFileChooserUtility.setIApproveOpption((String absolutePath, String fileName) -> {
                
                try{
                    
                    //Create the final path
                    final String finalPath = absolutePath + "\\" + fileName;

                    //Save the image 
                    UtilitiesFactory.getSingleton().getImagesUtility().saveProductImage(productCode, finalPath);

                    jLImg.setIcon(new ImageIcon(finalPath));
                    jLImg.setVisible(true);
                    
                    //Announce the user
                    DialogsFactory.getSingleton().showOKOperationCompletedCallbackDialog(baseJFrame, null);
                    
                }catch (Exception ex) {
                    LoggerUtility.getSingleton().logError(ProdsViewController.class, ex);
                    try {
                            DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
                    } catch (Exception ex1) {
                            Logger.getLogger(ProdsViewController.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                }
            });
            ImageFileChooserUtility.showSaveDialog(baseJFrame);
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ProdsViewController.class, ex);
            try {
                    DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                    Logger.getLogger(ProdsViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBDelImgActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
            //First select a product or set a profuct code
            if(!jTab.isRowSelected() && jTProd.getText().trim().isEmpty()){
                DialogsFactory.getSingleton().showErrorOKNoSelectionCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                    jTProd.grabFocus();
                });
                return;
            }
            
            //Get the producto code
            String productCode;
            if(jTab.isRowSelected()){
                Product Product_ = (Product)jTab.getRowSelected();
                productCode = Product_.getCode();
            }
            else {
                productCode = jTProd.getText().trim();
            }
            
            //Get the product from db
            final Product Product_ = RepositoryFactory.getInstance().getProductsRepository().getProductByCode(productCode);
            
            //If the product doesnt exist
            if(Product_ == null){
                DialogsFactory.getSingleton().showErrorOKCallbackDialog(baseJFrame, "errors_first_product_exists_to_delete_image", (JFrame jFrame) -> {
                    jTProd.grabFocus();
                });
                return;
            }
            
            //Question if continue
            DialogsFactory.getSingleton().showQuestionContinueDialog(baseJFrame, (JFrame jFrame) -> {
               
                try{
                    
                    //Delete the product image                    
                    UtilitiesFactory.getSingleton().getImagesUtility().deleteProductImage(productCode);

                    jLImg.setVisible(false);

                    DialogsFactory.getSingleton().showOKOperationCompletedCallbackDialog(jFrame, null);
                }
                catch (Exception ex) {
                    LoggerUtility.getSingleton().logError(ProdsViewController.class, ex);
                    try {
                            DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
                    } catch (Exception ex1) {
                            Logger.getLogger(ProdsViewController.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                }
            });
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ProdsViewController.class, ex);
            try {
                    DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                    Logger.getLogger(ProdsViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBVeGranActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
            //First select a product or set a profuct code
            if(!jTab.isRowSelected() && jTProd.getText().trim().isEmpty()){
                DialogsFactory.getSingleton().showErrorOKNoSelectionCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                    jTProd.grabFocus();
                });
                return;
            }
            
            //Get the producto code
            String productCode;
            if(jTab.isRowSelected()){
                Product Product_ = (Product)jTab.getRowSelected();
                productCode = Product_.getCode();
            }
            else {
                productCode = jTProd.getText().trim();
            }
            
            //Get the product from db
            final Product Product_ = RepositoryFactory.getInstance().getProductsRepository().getProductByCode(productCode);
            
            //If the product doesnt exist
            if(Product_ == null){
                DialogsFactory.getSingleton().showErrorOKCallbackDialog(baseJFrame, "errors_first_product_exists_to_view_image", (JFrame jFrame) -> {
                    jTProd.grabFocus();
                });
                return;
            }
            
            //Get the product image path
            final String productImagePath = UtilitiesFactory.getSingleton().getImagesUtility().getProductImagePath(productCode);
            
            //Open the image
            UtilitiesFactory.getSingleton().getDesktopUtility().open(productImagePath);
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ProdsViewController.class, ex);
            try {
                    DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                    Logger.getLogger(ProdsViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBExisAlmaActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{
            
            //First select a product or set a profuct code
            if(!jTab.isRowSelected() && jTProd.getText().trim().isEmpty()){
                DialogsFactory.getSingleton().showErrorOKNoSelectionCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                    jTProd.grabFocus();
                });
                return;
            }
            
            //Get the producto code
            String productCode;
            if(jTab.isRowSelected()){
                Product Product_ = (Product)jTab.getRowSelected();
                productCode = Product_.getCode();
            }
            else {
                productCode = jTProd.getText().trim();
            }
            
            //Get the product from db
            final Product Product_ = RepositoryFactory.getInstance().getProductsRepository().getProductByCode(productCode);
            
            //If the product doesnt exist
            if(Product_ == null){
                DialogsFactory.getSingleton().showErrorRecordNotExistsOKDialog(baseJFrame, (JFrame jFrame) -> {
                    jTProd.grabFocus();
                });
                return;
            }
            
            //Show the screen of warehouses existences
            final ProdExisAlmViewController ProdExisAlmViewController = ViewControlersFactory.getSingleton().getProdExisAlmViewController();
            ProdExisAlmViewController.setProductCode(productCode);
            ProdExisAlmViewController.setVisible();
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ProdsViewController.class, ex);
            try {
                    DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                    Logger.getLogger(ProdsViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBCargFActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
            //First select a product or set a profuct code
            if(!jTab.isRowSelected() && jTProd.getText().trim().isEmpty()){
                DialogsFactory.getSingleton().showErrorOKNoSelectionCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                    jTProd.grabFocus();
                });
                return;
            }
            
            //Get the producto code
            String productCode;
            if(jTab.isRowSelected()){
                Product Product_ = (Product)jTab.getRowSelected();
                productCode = Product_.getCode();
            }
            else {
                productCode = jTProd.getText().trim();
            }
            
            //Get the product from db
            final Product Product_ = RepositoryFactory.getInstance().getProductsRepository().getProductByCode(productCode);
            
            //If the product doesnt exist
            if(Product_ == null){
                DialogsFactory.getSingleton().showErrorOKCallbackDialog(baseJFrame, "errors_first_product_exists_to_view_image", (JFrame jFrame) -> {
                    jTProd.grabFocus();
                });
                return;
            }
            
            //Search the technical product file
            final FTecnicaFileChooserUtility FTecnicaFileChooserUtility = UtilitiesFactory.getSingleton().getFTecnicaFileChooserUtility();
            FTecnicaFileChooserUtility.setIApproveOpption((String absolutePath, String fileName) -> {
                
                try{
                    
                    //Create the final path
                    final String finalPath = absolutePath + "\\" + fileName;

                    //Save the technical product file
                    UtilitiesFactory.getSingleton().getImagesUtility().saveFTecnicaProduct(productCode, finalPath);
                    
                    //Announce the user
                    DialogsFactory.getSingleton().showOKOperationCompletedCallbackDialog(baseJFrame, null);
                    
                }catch (Exception ex) {
                    LoggerUtility.getSingleton().logError(ProdsViewController.class, ex);
                    try {
                            DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
                    } catch (Exception ex1) {
                            Logger.getLogger(ProdsViewController.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                }
            });
            FTecnicaFileChooserUtility.showSaveDialog(baseJFrame);
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ProdsViewController.class, ex);
            try {
                    DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                    Logger.getLogger(ProdsViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBDelFActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
            //First select a product or set a profuct code
            if(!jTab.isRowSelected() && jTProd.getText().trim().isEmpty()){
                DialogsFactory.getSingleton().showErrorOKNoSelectionCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                    jTProd.grabFocus();
                });
                return;
            }
            
            //Get the producto code
            String productCode;
            if(jTab.isRowSelected()){
                Product Product_ = (Product)jTab.getRowSelected();
                productCode = Product_.getCode();
            }
            else {
                productCode = jTProd.getText().trim();
            }
            
            //Get the product from db
            final Product Product_ = RepositoryFactory.getInstance().getProductsRepository().getProductByCode(productCode);
            
            //If the product doesnt exist
            if(Product_ == null){
                DialogsFactory.getSingleton().showErrorOKCallbackDialog(baseJFrame, "errors_first_product_exists_to_view_image", (JFrame jFrame) -> {
                    jTProd.grabFocus();
                });
                return;
            }
            
            //Get if technical product file exists or not
            final boolean ftechinicalExists = UtilitiesFactory.getSingleton().getImagesUtility().FTechnicalProductExists(productCode);
                                    
            //If not exists announce to the user
            if(!ftechinicalExists){                
                DialogsFactory.getSingleton().showErrorFileNotExistsOKDialog(baseJFrame, (JFrame jFrame) -> {                    
                });
                return;
            }
            
            //Delete the technical product file
            UtilitiesFactory.getSingleton().getImagesUtility().deleteFTechnicalProduct(productCode);
            
            //Announce the user of success
            DialogsFactory.getSingleton().showOKOperationCompletedCallbackDialog(baseJFrame, null);
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ProdsViewController.class, ex);
            try {
                    DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                    Logger.getLogger(ProdsViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBFTecActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
            //First select a product or set a profuct code
            if(!jTab.isRowSelected() && jTProd.getText().trim().isEmpty()){
                DialogsFactory.getSingleton().showErrorOKNoSelectionCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                    jTProd.grabFocus();
                });
                return;
            }
            
            //Get the producto code
            String productCode;
            if(jTab.isRowSelected()){
                Product Product_ = (Product)jTab.getRowSelected();
                productCode = Product_.getCode();
            }
            else {
                productCode = jTProd.getText().trim();
            }
            
            //Get the product from db
            final Product Product_ = RepositoryFactory.getInstance().getProductsRepository().getProductByCode(productCode);
            
            //If the product doesnt exist
            if(Product_ == null){
                DialogsFactory.getSingleton().showErrorOKCallbackDialog(baseJFrame, "errors_first_product_exists_to_view_image", (JFrame jFrame) -> {
                    jTProd.grabFocus();
                });
                return;
            }
            
            //Get if technical product file exists or not
            final boolean ftechinicalExists = UtilitiesFactory.getSingleton().getImagesUtility().FTechnicalProductExists(productCode);
                                    
            //If not exists announce to the user
            if(!ftechinicalExists){                
                DialogsFactory.getSingleton().showErrorFileNotExistsOKDialog(baseJFrame, (JFrame jFrame) -> {                    
                });
                return;
            }
            
            //Get the technical file path
            final String pathToFile = UtilitiesFactory.getSingleton().getImagesUtility().getFTecnicalProductPath(productCode);
            
            //Open the file
            UtilitiesFactory.getSingleton().getDesktopUtility().open(pathToFile);
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ProdsViewController.class, ex);
            try {
                    DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                    Logger.getLogger(ProdsViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBCompsActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            
            
            //First select a product or set a profuct code
            if(!jTab.isRowSelected() && jTProd.getText().trim().isEmpty()){
                DialogsFactory.getSingleton().showErrorOKNoSelectionCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                    jTProd.grabFocus();
                });
                return;
            }
            
            //Get the producto code
            String productCode;
            if(jTab.isRowSelected()){
                Product Product_ = (Product)jTab.getRowSelected();
                productCode = Product_.getCode();
            }
            else {
                productCode = jTProd.getText().trim();
            }
            
            //Get the product from db
            final Product Product_ = RepositoryFactory.getInstance().getProductsRepository().getProductByCode(productCode);
            
            //If the product doesnt exist
            if(Product_ == null){
                DialogsFactory.getSingleton().showErrorOKCallbackDialog(baseJFrame, "errors_first_product_exists_to_view_image", (JFrame jFrame) -> {
                    jTProd.grabFocus();
                });
                return;
            }
            
            //If the product is not a kit can not continue
            if(!Product_.getCompound()){                
                DialogsFactory.getSingleton().showErrorOKCallbackDialog(baseJFrame, "errors_product_not_kit", (JFrame jFrame) -> {
                });
                return;
            }
                 
            //If not already init
            if(kits==null){
                
                //Get all the componentes of the kit
                kits = RepositoryFactory.getInstance().getKitssRepository().getComponentsByKit(productCode);
            }
            
            //Open the kits screen            
            final CompsViewController CompsViewController = ViewControlersFactory.getSingleton().getCompsViewController();
            CompsViewController.setOnResult((List<Kits> kits_) -> {
                kits = kits_;                
            });
            CompsViewController.init(kits, productCode, Product_.getDescription());
            CompsViewController.setVisible();
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ProdsViewController.class, ex);
            try {
                    DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                    Logger.getLogger(ProdsViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    
    @Override
    public List<?> getItemsToLoadInTable() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
