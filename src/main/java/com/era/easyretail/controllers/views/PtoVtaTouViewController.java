/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.easyretail.controllers.views;

import com.era.datamodels.TotalsDataModel;
import com.era.datamodels.enums.SearchCommonTypeEnum;
import com.era.views.PtoVtaTouJFrame;
import java.util.List;
import com.era.logger.LoggerUtility;
import com.era.models.Coin;
import com.era.models.Company;
import com.era.models.Existalma;
import com.era.models.Kits;
import com.era.models.Line;
import com.era.models.Partvta;
import com.era.models.Product;
import com.era.models.Sales;
import com.era.models.Unid;
import com.era.models.User;
import com.era.repositories.RepositoryFactory;
import com.era.utilities.UtilitiesFactory;
import com.era.views.dialogs.DialogsFactory;
import com.era.views.tables.headers.TableHeaderFactory;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
/**
 *
 * @author PC
 */
public class PtoVtaTouViewController extends PtoVtaTouJFrame {
 
    private String productCode;
    private String productDescription;
    private TotalsDataModel Totals;
    private Company Company;
    
    //Configs
    private boolean useListPriceCustomer;
    private boolean showProductsPanelInSalespoint;
    private String warehouseForSalesOnPointOfSales;
    private boolean showMessageWithNoExistencesInSalespoint;
    private boolean newCustomersOnPointOfSales;    
    
    private CobroViewController CobroViewController;
    
    public PtoVtaTouViewController() {
        super("window_title_ptovta");
        
        try{
                     
            jBNewVta.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBNewVtaActionPerformed(evt);
            });
            jBDel.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBDelActionPerformed(evt);
            });
            jB1.addActionListener((java.awt.event.ActionEvent evt) -> {
                jB1ActionPerformed(evt);
            });
            jBTecla.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBTeclaActionPerformed(evt);
            });
            jBSal.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBSalActionPerformed(evt);
            });
            jBProds.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBProdsActionPerformed(evt);
            });
            jBNew.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBNewActionPerformed(evt);
            });
            jBCob.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBCobActionPerformed(evt);
            });
            jBCli.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBCliActionPerformed(evt);
            });
            jBNewEmp.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBNewEmpActionPerformed(evt);
            });
            jBVeGran.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBVeGranActionPerformed(evt);
            });
            jBLed.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBLedActionPerformed(evt);
            });
            jBScann.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBScannActionPerformed(evt);
            });
            jBSincronizar.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBSincronizarActionPerformed(evt);
            });
            
            CobroViewController = ViewControlersFactory.getSingleton().getCobroViewController();
            
            //When escape key is pressed close the dispose
            this.JComponentUtils.setDisposeInEscapeEvent(this.baseJFrame,true);
            
            //Intercept when the user wants to close the window
            this.JComponentUtils.interceptWindowClosingEvent(() -> {
                
                if(CobroViewController!=null){
                    CobroViewController.dispose();
                }
                
                dispose();
            });
            
            //When the user clics in ESC key to exit close the cobro window in case it is open            
            this.JComponentUtils.setEscapeEvent(() -> {
                if(CobroViewController!=null){
                    CobroViewController.dispose();
                }
            });
            
            this.addMouseListenerClicked(jLabel1, (MouseEvent evt) -> {
                
                try {
                    final OptPtoVtaViewController OptPtoVtaViewController = ViewControlersFactory.getSingleton().getOptPtoVtaViewController();
                    OptPtoVtaViewController.readConfigs();
                    OptPtoVtaViewController.setVisible();
                    
                } catch (Exception ex) {
                    LoggerUtility.getSingleton().logError(this.getClass(), ex);
                    try {
                        DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
                    } catch (Exception ex1) {
                        Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex1);
                    }
                }
            });
            
            //Read all configs
            useListPriceCustomer = RepositoryFactory.getInstance().getConfgralRepository().getApplyCustomerPriceInSalespoint().getVal()==1;
            showProductsPanelInSalespoint = RepositoryFactory.getInstance().getConfgralRepository().getShowProductsPanelInSalespoint().getVal()==1;
            warehouseForSalesOnPointOfSales = RepositoryFactory.getInstance().getConfgralRepository().getWarehouseForSalesOnPointOfSales().getExtr();
            showMessageWithNoExistencesInSalespoint = RepositoryFactory.getInstance().getConfgralRepository().getShowMessageWithNoExistencesInSalespoint().getVal()==1;
            newCustomersOnPointOfSales = RepositoryFactory.getInstance().getConfgralRepository().getNewCustomersOnPointOfSales().getVal()==1;            
            
            this.showHandCursorWhenComponent(jLabel1);
            
            //Connect the image
            this.initImageControls(jLImg, jPanImg);
            
            this.JComponentUtils.onlyNumbers(jTDesc);
            
            JComponentUtils.setF11Event(() -> {
                ViewControlersFactory.getSingleton().getOptPtoVtaViewController().setVisible();
            });
            
            jTProd.grabFocus();
            
            //Load all the unids
            jComUnid.loadItems();
            
            //Select unid
            final Unid Unid = (Unid)RepositoryFactory.getInstance().getUnidsRepository().getUnidPIEZA();
            jComUnid.selectByObject(Unid);
            
            this.JComponentUtils.onlyDecimals(jTCant);

            //Config table
            this.BaseJTable = jTab;
            jTab.addShowColumn(TableHeaderFactory.getSigleton().getPartvtasTableHeader().getROWNUMBER());
            jTab.addShowColumn(TableHeaderFactory.getSigleton().getPartvtasTableHeader().getCANT());
            jTab.addShowColumn(TableHeaderFactory.getSigleton().getPartvtasTableHeader().getPROD());            
            jTab.addShowColumn(TableHeaderFactory.getSigleton().getPartvtasTableHeader().getUNID());
            jTab.addShowColumn(TableHeaderFactory.getSigleton().getPartvtasTableHeader().getDESCRIP());
            jTab.addShowColumn(TableHeaderFactory.getSigleton().getPartvtasTableHeader().getPRE());
            
            //Init empty table
            final List<Partvta> items = new ArrayList<>();
            jTab.initTable(items);

            //Select the customer for the screen
            final Company Company_ = (Company)RepositoryFactory.getInstance().getCompanysRepository().getClienteMostrador();
            jTCli.setText(Company_.getCompanyCode());
            jTNomb.setText(Company_.getNom());
            
            //Hide or show the lines and products panel ?
            if(showProductsPanelInSalespoint){
                
                //Load all the lines
                jPanelLin.loadAllButtonsFromRepository();
                jPanelLin.setOnButtonClic((Object Object) -> {

                    try {

                        //Cast the model
                        final Line Line = (Line)Object;

                        //Get all the products for that line
                        final List<Product> products = RepositoryFactory.getInstance().getProductsRepository().getAllByLine(Line.getCode());

                        //Load all the productos in the panel
                        jPanProds.loadAllButtonsPageAxis(products);

                        jTProd.grabFocus();

                    } catch (Exception ex) {
                        LoggerUtility.getSingleton().logError(this.getClass(), ex);
                        try {
                            DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
                        } catch (Exception ex1) {
                            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex1);
                        }
                    }
                });
                jPanProds.setOnButtonClic((Object Object) -> {

                    try {

                        //Cast the model
                        final Product Product = (Product)Object;

                        productCode = Product.getCode();

                        jBNewActionPerformed(null);

                        jTProd.grabFocus();

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
            else{
                
                jScrollPaneLin.setVisible(false);
                jScrollProds.setVisible(false);
            }
            
            //If there is no money of the casher ask for it
            existMoneyFromCasherAlready();
            
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
    
    private boolean existMoneyFromCasherAlready() throws Exception {
        
        //If there is no money of the casher ask for it
        final boolean existsMoneyInCasherForNewCort = RepositoryFactory.getInstance().getFlujsRepository().existsMoneyInCasherForNewCort();
        if(!existsMoneyInCasherForNewCort){
            ViewControlersFactory.getSingleton().getIngreCajViewController().setVisible();
        }
        
        return existsMoneyInCasherForNewCort;
    }
    
    private void newSale() throws Exception {
        
        final Company Company_ = (Company)RepositoryFactory.getInstance().getCompanysRepository().getClienteMostrador();
        jTCli.setText(Company_.getCompanyCode());
        jTNomb.setText(Company_.getNom());
        
        jTProd.setText("");
        jTab.clearRows();
        jTCant.setText("1");
        
        hideImage();
        
        //Select unid
        final Unid Unid = (Unid)RepositoryFactory.getInstance().getUnidsRepository().getUnidPIEZA();
        jComUnid.selectByObject(Unid);
        
        Company = null;
        
        jTDesc.setText("0");
        
        jTSubTot.setText(UtilitiesFactory.getSingleton().getNumbersUtility().toMoneyFormat("0"));
        jTImpue.setText(UtilitiesFactory.getSingleton().getNumbersUtility().toMoneyFormat("0"));
        jTTotDesc.setText(UtilitiesFactory.getSingleton().getNumbersUtility().toMoneyFormat("0"));
        jTTot.setText(UtilitiesFactory.getSingleton().getNumbersUtility().toMoneyFormat("0"));
        
        jTQtyP.setText("1 pzas");
    }
    
    @Override
    public void clearFields() throws Exception{
    }
    
    private void fillTotals(final TotalsDataModel Totals) throws Exception {
        
        //Place in fields
        jTSubTot.setText(UtilitiesFactory.getSingleton().getNumbersUtility().toMoneyFormat(String.valueOf(Totals.getSubtotal().doubleValue())));
        jTImpue.setText(UtilitiesFactory.getSingleton().getNumbersUtility().toMoneyFormat(String.valueOf(Totals.getTaxes().doubleValue())));
        jTTot.setText(UtilitiesFactory.getSingleton().getNumbersUtility().toMoneyFormat(String.valueOf(Totals.getTotal().doubleValue())));
        jTTotDesc.setText(UtilitiesFactory.getSingleton().getNumbersUtility().toMoneyFormat(String.valueOf(Totals.getDisccount().doubleValue())));
        jTQtyP.setText(String.valueOf(Totals.getCant().doubleValue()) + " pzas");
    }
    
    private TotalsDataModel calculateTotals() throws Exception {
        
        //Get all table items
        final List<Partvta> items = (List<Partvta>)jTab.getAllItemsInTable();

        //Contains the total
        BigDecimal taxes = BigDecimal.ZERO;
        BigDecimal total = BigDecimal.ZERO;
        BigDecimal subtotal = BigDecimal.ZERO;
        BigDecimal cant = BigDecimal.ZERO;
        BigDecimal disccountTotal = BigDecimal.ZERO;
        
        //Loop to calculate totals
        for(Partvta Partvta:items){

            //Get the price
            final BigDecimal price = Partvta.getPre();

            //Get amount
            final BigDecimal qty = Partvta.getCant();
            
            //Calculate the import
            BigDecimal import_ = price.multiply(qty);

            //Get the disccount
            final BigDecimal descu = Partvta.getDescu();
            final BigDecimal descuTot = descu.divide(new BigDecimal(100, MathContext.DECIMAL64));
            
            //Get the disccount                        
            BigDecimal totalDisccount = descuTot.multiply(import_);

            disccountTotal = disccountTotal.add(totalDisccount);
            
            //Remove the disccount
            import_ = import_.subtract(totalDisccount);
            
            //Continue adding the subtotal
            subtotal = subtotal.add(import_);

            //Continue adding the quantity
            cant = cant.add(qty);
            
            //If the product is kit
            if(Partvta.isEskit()){
                
                //Get all the components of the product
                final List<Kits> kits = RepositoryFactory.getInstance().getKitssRepository().getComponentsByKit(Partvta.getProd());
                
                for(Kits Kit: kits){                    
                    taxes = taxes.add(RepositoryFactory.getInstance().getProductsRepository().getTotalTaxesOfProduct(Kit.getProd(), import_));
                }
            }
            else{
                taxes = taxes.add(RepositoryFactory.getInstance().getProductsRepository().getTotalTaxesOfProduct(Partvta.getProd(), import_));
            }
        }

        //Create the total
        total = total.add(subtotal.add(taxes));

        //Create the model
        final TotalsDataModel Totals_ = new TotalsDataModel();
        Totals_.setTaxes(taxes);
        Totals_.setDisccount(disccountTotal);
        Totals_.setSubtotal(subtotal);
        Totals_.setTotal(total);
        Totals_.setCant(cant);

        return Totals_;
    }
    
    private void jBNewVtaActionPerformed(java.awt.event.ActionEvent evt) {

	try{
            
            DialogsFactory.getSingleton().showQuestionContinueDialog(baseJFrame, (JFrame jFrame) -> {
                
                try {
                    
                    this.newSale();
                    
                    jTProd.grabFocus();
                    
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
    
    private void jBDelActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
    
            //First select in table
            if(!jTab.isRowSelected()){
                DialogsFactory.getSingleton().showErrorOKNoSelectionCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                    jTab.grabFocus();
                });
                return;
            }
            
            DialogsFactory.getSingleton().showQuestionContinueDialog(baseJFrame, (JFrame jFrame) -> {
                
                try {                    
                    
                    //Get selected object
                    final Partvta Partvta = (Partvta)jTab.getRowSelected();
                    
                    //Remove the object from the table
                    jTab.deleteObject(Partvta);
                    
                    //Recalc totals                    
                    Totals = calculateTotals();                        
            
                    //Fill the totals
                    fillTotals(Totals);
                    
                    jTDesc.setText("0");
                    
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
    
    private void jB1ActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
            UtilitiesFactory.getSingleton().getDesktopUtility().openCalc();
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
    
    private void jBTeclaActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            UtilitiesFactory.getSingleton().getDesktopUtility().openKeyboard();
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
    
    private void jBSalActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
            DialogsFactory.getSingleton().showQuestionExitDialog(baseJFrame, (JFrame jFrame) -> {
                
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
    
    private void jBProdsActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
            final SearchViewController SearchViewController = new SearchViewController();
            SearchViewController.setSEARCH_TYPE(SearchCommonTypeEnum.PRODUCTS);
            SearchViewController.setButtonAceptClicked(() -> {

                try {
                                     
                    //Get the product code
                    productCode = SearchViewController.getCod();                    

                    //Set product code
                    jTProd.setText(productCode);
                    
                    //Set product descriptión
                    productDescription = SearchViewController.getDescrip();

                    //Get the product imageicon
                    final String imagePath = UtilitiesFactory.getSingleton().getImagesUtility().getProductImagePath(productCode);

                    //Show the control
                    showImage(imagePath);
                    
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
    
    private void jBNewActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
            //If there is no money of the casher ask for it
            final boolean existsMoneyInCasherForNewCort = existMoneyFromCasherAlready();
            if(!existsMoneyInCasherForNewCort){
                return;
            }
            
            //No previous customer selected
            Company Company_;
            if(Company==null){
             
                //First select a customer
                final String customer = jTCli.getText().trim();

                //If not customer stop
                if(customer.isEmpty()){
                    DialogsFactory.getSingleton().showOKEmptyFieldCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                        jTCli.grabFocus();
                    });
                    return;
                }

                //Get the customer
                Company_ = (Company)RepositoryFactory.getInstance().getCompanysRepository().getCustomerByCode(customer);

                //Iif customer doesnt exists
                if(Company_==null){
                    DialogsFactory.getSingleton().showErrorOKRecordNotExistsCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                        jTCli.grabFocus();
                    });
                    return;
                }
            }
            else{
                Company_ = Company;
            }
            
            //Select a product
            if(productCode==null){
                DialogsFactory.getSingleton().showErrorOKNoSelectionCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                    jTProd.grabFocus();
                });
                return;
            }
            
            //Get the product
            final Product Product = (Product)RepositoryFactory.getInstance().getProductsRepository().getByCode(productCode);
            
            //If not exists stop
            if(Product==null){
                DialogsFactory.getSingleton().showErrorOKRecordNotExistsCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                    jTProd.grabFocus();
                });
                return;
            }
            
            //If the product doesnt have a price
            if(Product.getPriceList1()==0){
                DialogsFactory.getSingleton().showErrorOKCallbackDialog(baseJFrame, "errors_product_without_price", (JFrame jFrame) -> {
                    jTProd.grabFocus();
                });
                return;
            }
            
            //If the product is kit
            if(Product.getCompound()){
                
                //Get all the components of the kit
                final List<Kits> components = RepositoryFactory.getInstance().getKitssRepository().getComponentsByKit(productCode);
                if(components.isEmpty()){
                    DialogsFactory.getSingleton().showErrorOKCallbackDialog(baseJFrame, "errors_kit_without_components", (JFrame jFrame) -> {
                        jTProd.grabFocus();
                    });
                    return;
                }
            }
            
            //If the product is not for sale
            if(!Product.getIsForSale()){
                DialogsFactory.getSingleton().showErrorOKCallbackDialog(baseJFrame, "errors_product_not_for_sale", (JFrame jFrame) -> {
                    jTProd.grabFocus();
                });
                return;
            }
            
            //First select unid
            if(!jComUnid.isSelectedObject()){
                DialogsFactory.getSingleton().showErrorOKNoSelectionCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                    jComUnid.grabFocus();
                });
                return;
            }
            
            //Get existences for producto
            final Existalma Existalma = RepositoryFactory.getInstance().getExistalmasRepository().getByWarehouseAndProduct(warehouseForSalesOnPointOfSales, productCode);
            
            //If no existences
            if(Existalma!=null && Existalma.getExist()<=0){
                                               
                if(showMessageWithNoExistencesInSalespoint){
                    DialogsFactory.getSingleton().showOKCallbackDialog(baseJFrame, "errors_missing_existences", null);
                }
                
                if(RepositoryFactory.getInstance().getConfgralRepository().getSaleWithNoExistencesInSalespoint().getVal()==0){
                    return;
                }
            }
            
            //Get the selected unid
            final Unid Unid = (Unid)jComUnid.getSelectedObject();
            
            //Get qty
            final double qty = Double.valueOf(jTCant.getText().trim());
            
            //Get the national coin
            final Coin Coin = (Coin)RepositoryFactory.getInstance().getCoinsRepository().getNationalCoin();
            
            double priceList = getCorrectPriceList(useListPriceCustomer, Company_, Product);
            
            //Calculate the imports
            final double import_ = qty * priceList;
            
            //Create the model
            final Partvta Partvta = new Partvta();
            Partvta.setAlma("SYS");
            Partvta.setMon(Coin.getCode());
            Partvta.setCant(new BigDecimal(qty, MathContext.DECIMAL64));
            Partvta.setDescrip(Product.getDescription());
            Partvta.setEskit(Product.getCompound());
            Partvta.setList(1);
            Partvta.setPre(new BigDecimal(priceList, MathContext.DECIMAL64));
            Partvta.setTipcam(new BigDecimal(Coin.getValue(), MathContext.DECIMAL64));
            Partvta.setUnid(Unid.getCode());
            Partvta.setImpo(new BigDecimal(import_, MathContext.DECIMAL64));
            Partvta.setImpue(0);
            Partvta.setProd(Product.getCode());
            double diccount = Double.parseDouble(jTDesc.getText().trim());
            BigDecimal disccount = new BigDecimal(diccount, MathContext.DECIMAL64);
            Partvta.setDescu(disccount);
            Partvta.setInventory(true);
            
            //Add it to the table
            jTab.addObject(Partvta);
            
            //Get the totals
            Totals = calculateTotals();                        
            
            //Fill the totals
            fillTotals(Totals);
            
            //Clear for a new product insertion
            clearNewProduct();
            
            jTDesc.setText("0");
            
            //Already a customer selected
            Company = Company_;
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
    
    private double getCorrectPriceList(final boolean useListPriceCustomer, final Company Company_, final Product Product){
        
        //Determine wich price list to use
        final int list;
        if(useListPriceCustomer){
            list = Company_.getList();
        }
        else{
            list = 1;
        }

        double priceList;
        if(list==1){
            priceList = Product.getPriceList1();
        }
        else if(list==2){
            priceList = Product.getPriceList2();
        }
        else if(list==3){
            priceList = Product.getPriceList3();
        }
        else if(list==4){
            priceList = Product.getPriceList4();
        }
        else if(list==5){
            priceList = Product.getPriceList5();
        }
        else if(list==6){
            priceList = Product.getPriceList6();
        }
        else if(list==7){
            priceList = Product.getPriceList7();
        }
        else if(list==8){
            priceList = Product.getPriceList8();
        }
        else if(list==9){
            priceList = Product.getPriceList9();
        }
        else if(list==10){
            priceList = Product.getPriceList10();
        }
        else{
            priceList = Product.getPriceList1();
        }
        
        if(priceList==0){
            priceList = Product.getPriceList1();
        }
        
        return priceList;
    }
    
    private void clearNewProduct() throws Exception {
        
        jTProd.setText("");
        jTCant.setText("1");
        
        //Remove image
        hideImage();
                
        //Select unid
        final Unid Unid = (Unid)RepositoryFactory.getInstance().getUnidsRepository().getUnidPIEZA();
        jComUnid.selectByObject(Unid);
    }
    
    private void jBCobActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{
            
            //First select a customer
            final String customer = jTCli.getText().trim();
            
            //If not customer stop
            if(customer.isEmpty()){
                DialogsFactory.getSingleton().showOKEmptyFieldCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                    jTCli.grabFocus();
                });
                return;
            }
            
            //Get the customer
            final Company Company = (Company)RepositoryFactory.getInstance().getCompanysRepository().getCustomerByCode(customer);
            
            //Iif customer doesnt exists
            if(Company==null){
                DialogsFactory.getSingleton().showErrorOKRecordNotExistsCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                    jTCli.grabFocus();
                });
                return;
            }
            
            //Get all table items
            final List<Partvta> items = (List<Partvta>)jTab.getAllItemsInTable();
            
            //First need items in table
            if(items.isEmpty()){
                DialogsFactory.getSingleton().showErrorCeroItemsOKDialog(baseJFrame, (JFrame jFrame) -> {
                    jTab.grabFocus();
                });
                return;
            }
            
            //Get the user in session
            User User = UtilitiesFactory.getSingleton().getSessionUtility().getUser();
            
            //Get the associated printer to the user            
            User = (User)RepositoryFactory.getInstance().getUsersRepository().getByCode(User.getCode());
            
            //If the printer is empty
            String defaultPrinter;
            if(User.getTicketPrinter()==null){
                defaultPrinter = UtilitiesFactory.getSingleton().getPrintersUtility().getDefaultPrinter();
            }
            else{                
                defaultPrinter = User.getTicketPrinter();
            }
            
            //If not printer installed
            if(defaultPrinter.isEmpty()){
                DialogsFactory.getSingleton().showErrorOKDialog(baseJFrame, "errors_no_printers");
                return;
            }
            
            //Create the sales model
            final Sales Sales = new Sales();
            Sales.setCompanyCode(Company.getCompanyCode());
            Sales.setRazon(Company.getNom());
            Sales.setSubtotal(Totals.getSubtotal());
            Sales.setTax(Totals.getTaxes());
            Sales.setTotal(Totals.getTotal());
            
            //Open screen to make the payment
            CobroViewController = ViewControlersFactory.getSingleton().getCobroViewController();
            CobroViewController.clearFields();
            CobroViewController.init(Sales, Company,items);
            CobroViewController.setOnFinish(() -> {
                
                try {
                    
                    //New sale
                    this.newSale();
                    
                } catch (Exception ex) {
                    LoggerUtility.getSingleton().logError(this.getClass(), ex);
                    try {
                        DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
                    } catch (Exception ex1) {
                        Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex1);
                    }
                }
            });
            CobroViewController.setVisible();
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
    
    private void jBCliActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{
            
            final SearchViewController SearchViewController = new SearchViewController();
            SearchViewController.setSEARCH_TYPE(SearchCommonTypeEnum.CUSTOMERS);
            SearchViewController.setButtonAceptClicked(() -> {

                try {
                    
                    final String customerCode = SearchViewController.getCod();
                    final String customerName = SearchViewController.getDescrip();
                    
                    //If already a customer
                    if(Company!=null){

                        DialogsFactory.getSingleton().showQuestionContinueDialog(baseJFrame, (JFrame jFrame) -> {
                            try {
                                changeCustomer(customerCode,customerName);
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
                    else{
                        changeCustomer(customerCode,customerName);
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
            SearchViewController.setVisible();
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
    
    private void changeCustomer(final String customerCode, final String customerName) throws Exception {
                                
        newSale();
        
        //Get customer credit conditions
        final Company Company_ = RepositoryFactory.getInstance().getCompanysRepository().getCustomerByCode(customerCode);
        final String conditions = RepositoryFactory.getInstance().getCompanysRepository().getCustomerConditions(Company_);
                
        //Set the text conditions
        jLabelCred.setText(conditions);
        
        jTCli.setText(customerCode);        
        jTNomb.setText(customerName);
    }
    
    private void jBNewEmpActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
            //If by config user can not continue so stop
            if(!newCustomersOnPointOfSales){
                DialogsFactory.getSingleton().showErrorStopByConfigOKDialog(baseJFrame, null);
                return;
            }
            
            final ClientViewController ClientViewController = ViewControlersFactory.getSingleton().getClientViewController();
            ClientViewController.setVisible();
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
    
    private void jBVeGranActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
            //Select a product
            if(productCode==null){
                DialogsFactory.getSingleton().showErrorOKNoSelectionCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                    jTProd.grabFocus();
                });
                return;
            }
            
            //Get the product
            final Product Product = (Product)RepositoryFactory.getInstance().getProductsRepository().getByCode(productCode);
            
            //If not exists stop
            if(Product==null){
                DialogsFactory.getSingleton().showErrorOKRecordNotExistsCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                    jTProd.grabFocus();
                });
                return;
            }
            
            if(!UtilitiesFactory.getSingleton().getImagesUtility().productImageExists(productCode)){
                DialogsFactory.getSingleton().showErrorFileNotExistsOKDialog(baseJFrame, (JFrame jFrame) -> {
                    jTProd.grabFocus();
                });
                return;
            }
            
            //Get the path to the image
            final String productPath = UtilitiesFactory.getSingleton().getImagesUtility().getProductImagePath(productCode);
            
            //Open the image
            UtilitiesFactory.getSingleton().getDesktopUtility().open(productPath);
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
    
    private void jBLedActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
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
    
    private void jBScannActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
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
    
    private void jBSincronizarActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
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
