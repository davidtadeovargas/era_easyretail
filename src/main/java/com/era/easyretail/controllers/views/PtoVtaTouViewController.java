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
import com.era.models.ImpuesXProduct;
import com.era.models.Line;
import com.era.models.Partvta;
import com.era.models.Product;
import com.era.models.Sales;
import com.era.models.Tax;
import com.era.models.Unid;
import com.era.models.User;
import com.era.repositories.RepositoryFactory;
import com.era.utilities.UtilitiesFactory;
import com.era.views.dialogs.DialogsFactory;
import com.era.views.tables.headers.TableHeaderFactory;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
/**
 *
 * @author PC
 */
public class PtoVtaTouViewController extends PtoVtaTouJFrame {
 
    private String productCode;
    private String productDescription;
    private TotalsDataModel Totals;
    
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
                  
            this.JComponentUtils.onlyNumbers(jTDesc);
            
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
            final Company Company = (Company)RepositoryFactory.getInstance().getCompanysRepository().getClienteMostrador();
            jTCli.setText(Company.getCompanyCode());
            jTNomb.setText(Company.getNom());
            
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
    
    private void newSale() throws Exception {
        
        final Company Company = (Company)RepositoryFactory.getInstance().getCompanysRepository().getClienteMostrador();
        jTCli.setText(Company.getCompanyCode());
        jTNomb.setText(Company.getNom());
        
        jTProd.setText("");
        jTab.clearRows();
        jTCant.setText("1");
        
        showOrHideProductImage(false, null);
        
        //Select unid
        final Unid Unid = (Unid)RepositoryFactory.getInstance().getUnidsRepository().getUnidPIEZA();
        jComUnid.selectByObject(Unid);
        
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

        //Loop to calculate totals
        for(Partvta Partvta:items){

            //Get the price
            final BigDecimal price = Partvta.getPre();

            //Get amount
            final BigDecimal qty = Partvta.getCant();

            //Calculate the import
            final BigDecimal import_ = price.multiply(qty);

            //Continue adding the subtotal
            subtotal = subtotal.add(import_);

            //Continue adding the quantity
            cant = cant.add(qty);
            
            //Get the taxes of the product
            final List<ImpuesXProduct> taxesProduct = RepositoryFactory.getInstance().getImpuesXProductRepository().getAllByProd(Partvta.getProd());

            //Iterate over all the taxes to calculate to taxes total
            for(ImpuesXProduct ImpuesXProduct: taxesProduct){
                final String taxCode = ImpuesXProduct.getImpue();
                final Tax Tax = (Tax)RepositoryFactory.getInstance().getTaxesRepository().getByCode(taxCode);
                taxes = taxes.add(import_.multiply(new BigDecimal(Tax.getValue(), MathContext.DECIMAL64)));
            }
        }

        //Create the total
        total = total.add(subtotal.add(taxes));

        //Create the model
        final TotalsDataModel Totals = new TotalsDataModel();
        Totals.setTaxes(taxes);
        Totals.setDisccount(BigDecimal.ZERO);
        Totals.setSubtotal(subtotal);
        Totals.setTotal(total);
        Totals.setCant(cant);

        return Totals;
    }
    
    private void jBNewVtaActionPerformed(java.awt.event.ActionEvent evt) {

	try{
            
            DialogsFactory.getSingleton().showQuestionContinueDialog(baseJFrame, (JFrame jFrame) -> {
                
                try {
                    
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

                //Set product code
                productCode = SearchViewController.getCod();
                jTProd.setText(productCode);                                
    
                //Set product descriptión
                productDescription = SearchViewController.getDescrip();
                
                //Get the product imageicon
                final ImageIcon productImageIcon = UtilitiesFactory.getSingleton().getImagesUtility().getProductImagePathImageIcon(productCode);
                
                //Show the control
                showOrHideProductImage(true, productImageIcon);
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
            
            //Get the selected unid
            final Unid Unid = (Unid)jComUnid.getSelectedObject();
            
            //Get qty
            final double qty = Double.valueOf(jTCant.getText().trim());
            
            //Get the national coin
            final Coin Coin = (Coin)RepositoryFactory.getInstance().getCoinsRepository().getNationalCoin();
            
            //Calculate the imports
            final double import_ = qty * Product.getPriceList1();
            
            //Create the model
            final Partvta Partvta = new Partvta();
            Partvta.setAlma("SYS");
            Partvta.setMon(Coin.getCode());
            Partvta.setCant(new BigDecimal(qty, MathContext.DECIMAL64));
            Partvta.setDescrip(Product.getDescription());
            Partvta.setEskit(Product.getCompound());
            Partvta.setList(1);
            Partvta.setPre(new BigDecimal(Product.getPriceList1(), MathContext.DECIMAL64));
            Partvta.setTipcam(new BigDecimal(Coin.getValue(), MathContext.DECIMAL64));
            Partvta.setUnid(Unid.getCode());
            Partvta.setImpo(new BigDecimal(import_, MathContext.DECIMAL64));
            Partvta.setImpue(0);
            Partvta.setProd(Product.getCode());
            Partvta.setDescu(BigDecimal.ZERO);
            
            //Add it to the table
            jTab.addObject(Partvta);
            
            //Get the totals
            Totals = calculateTotals();                        
            
            //Fill the totals
            fillTotals(Totals);
            
            //Clear for a new product insertion
            clearNewProduct();
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
    
    private void showOrHideProductImage(final boolean show, final ImageIcon ImageIcon){
        
        //Remove image
        jLImg.setIcon(ImageIcon);
        jLImg.setVisible(show);
    }
    
    private void clearNewProduct() throws Exception {
        
        jTProd.setText("");
        jTCant.setText("1");
        
        //Remove image
        showOrHideProductImage(false, null);
                
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
            final CobroViewController CobroViewController = ViewControlersFactory.getSingleton().getCobroViewController();
            CobroViewController.init(Sales, items);
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

                final String customerCode = SearchViewController.getCod();
                jTCli.setText(customerCode);
                
                final String customerName = SearchViewController.getDescrip();
                jTNomb.setText(customerName);
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
    
    private void jBNewEmpActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
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
