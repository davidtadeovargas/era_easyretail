/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.easyretail.controllers.views;

import com.era.datamodels.enums.SearchCommonTypeEnum;
import com.era.logger.LoggerUtility;
import com.era.repositories.RepositoryFactory;
import com.era.repositories.models.ProductPriceListModel;
import com.era.views.SearchJFrame;
import com.era.views.dialogs.DialogsFactory;
import com.era.views.dialogs.ErrorOKDialog;
import com.era.views.dialogs.OKDialog;
import com.era.views.tables.SearchCommonJTable;
import com.era.views.tables.headers.TableHeaderFactory;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author PC
 */
public class SearchViewController extends SearchJFrame {
    
    private List<?> list;
    
    private String cod;
    private String descrip;
    private String others;
    
    private String search = "";
    
    private String extraCode;
    
    private ButtonAceptClicked ButtonAceptClicked;        
    
    
    public void setButtonAceptClicked(ButtonAceptClicked ButtonAceptClicked) {
        this.ButtonAceptClicked = ButtonAceptClicked;
    }
    
    private final SearchCommonJTable jTab;
    
    private boolean canceled;
    
    private SearchCommonTypeEnum SearchCommonTypeEnum;
    
    
    
    
    protected SearchViewController() throws Exception{
        
        super("general_search_title");
        
        alwaysOnTop();
                
        this.getRootPane().setDefaultButton(jBCarg);
                        
        this.setAlwaysOnTop(true);
                
        jBSal.addActionListener((ActionEvent e) -> {
            buttonExitClicked(e);
        });
        
        JComponentUtils.setEnterEvent(() -> {
            jBCarg.doClick();
        });
                
        jBCarg.addActionListener((ActionEvent e) -> {
            aceptButtonClicked(e);
        });
        jBtnSearch.addActionListener((ActionEvent e) -> {
            jBtnSearchClicked(e);
        });        
        
        jTab = new SearchCommonJTable();
        
        this.BaseJTable = jTab;
                
    }

    public void setExtraCode(String extraCode) {
        this.extraCode = extraCode;
    }
        
    @Override
    public void loadModelInFields(Object ObjectModel) throws  Exception {        
    }
    
    @Override
    public void clearFields() throws Exception{
    }
    
    private ImageIcon scaleImage(ImageIcon icon, int w, int h){
         
        int nw = icon.getIconWidth();
        int nh = icon.getIconHeight();

        if(icon.getIconWidth() > w)
        {
          nw = w;
          nh = (nw * icon.getIconHeight()) / icon.getIconWidth();
        }

        if(nh > h)
        {
          nh = h;
          nw = (icon.getIconWidth() * nh) / icon.getIconHeight();
        }

        return new ImageIcon(icon.getImage().getScaledInstance(nw, nh, Image.SCALE_DEFAULT));
    }
     
    private void buttonExitClicked(ActionEvent ActionEvent){
        this.canceled = true;
        dispose();
    }

    @Override
    public void setVisible() {        
        
        super.setVisible(); //To change body of generated methods, choose Tools | Templates.
        
        try {
         
            initTable();
            
        } catch (Exception ex) {
            LoggerUtility.getSingleton().logError(this.getClass(), ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    private void initTable() throws Exception {
                
        jTab.setSearchCommonTypeEnum(SearchCommonTypeEnum);        
        jTab.setJTableDoubleClic((int selectedRow) -> {
            jBCarg.doClick();
        });
        jTab.loadScrollpane();
        jTab.getJScrollPane().setPreferredSize(new Dimension(70,150));
        jPanelTable.add(jTab.getJScrollPane());
        jTab.setScrollAtStartWhenEnd(true);
        jTab.setJTableEnterKeyPressed((int selectedRow) -> {
            jBCarg.doClick();
        });
        this.BaseJTable = jTab;
        
        //Init the columns table
        switch(SearchCommonTypeEnum){

            case CUSTOMERS:
                jTab.addShowColumn(TableHeaderFactory.getSigleton().getCompanysTableHeader().getCOMPANYCODE());
                jTab.addShowColumn(TableHeaderFactory.getSigleton().getCompanysTableHeader().getNOM());
                jTab.addShowColumn(TableHeaderFactory.getSigleton().getCompanysTableHeader().getRFC());
                break;
            
            case BANCOS:
                jTab.addShowColumn(TableHeaderFactory.getSigleton().getBancosTableHeader().getCUENTABANCO());
                jTab.addShowColumn(TableHeaderFactory.getSigleton().getBancosTableHeader().getDESCRIP());
                jTab.addShowColumn(TableHeaderFactory.getSigleton().getBancosTableHeader().getBANCO());
                break;
                
            case PAYMENT_METHOD:
                jTab.addShowColumn(TableHeaderFactory.getSigleton().getCPaymentMethodsTableHeader().getCODE());
                jTab.addShowColumn(TableHeaderFactory.getSigleton().getCPaymentMethodsTableHeader().getDESCRIPTION());
                jTab.addShowColumn(TableHeaderFactory.getSigleton().getCPaymentMethodsTableHeader().getFECHA_INICIO_DE_VIGENCIA());
                break;
                
            case BASDATS:
                jTab.addShowColumn(TableHeaderFactory.getSigleton().getBasDatssTableHeader().getCODEMP());
                jTab.addShowColumn(TableHeaderFactory.getSigleton().getBasDatssTableHeader().getNOM());
                jTab.addShowColumn(TableHeaderFactory.getSigleton().getBasDatssTableHeader().getBD());                
                break;
            
            case PRODUCTO_PRICE_LIST:
                jTab.addShowColumn(TableHeaderFactory.getSigleton().getProductPriceListTableHeader().getLIST());
                jTab.addShowColumn(TableHeaderFactory.getSigleton().getProductPriceListTableHeader().getCODE());                
                jTab.addShowColumn(TableHeaderFactory.getSigleton().getProductPriceListTableHeader().getPRICE());
                break;
                
            case PRODUCTS_FOR_SALE:
            case PRODUCTS:
                jTab.addShowColumn(TableHeaderFactory.getSigleton().getProductsTableHeader().getCODE());
                jTab.addShowColumn(TableHeaderFactory.getSigleton().getProductsTableHeader().getDESCRIPTION());
                jTab.addShowColumn(TableHeaderFactory.getSigleton().getProductsTableHeader().getINFORMATION());
                break;

            case SUPPLIERS:
                jTab.addShowColumn(TableHeaderFactory.getSigleton().getSuppliersTableHeader().getCODE());
                jTab.addShowColumn(TableHeaderFactory.getSigleton().getSuppliersTableHeader().getNAME());
                jTab.addShowColumn(TableHeaderFactory.getSigleton().getSuppliersTableHeader().getRFC());
                break;
                
                
            case CLAVES_PROD_SAT:
                jTab.addShowColumn(TableHeaderFactory.getSigleton().getCClaveprodservsTableHeader().getC_CLAVEPRODSERV());
                jTab.addShowColumn(TableHeaderFactory.getSigleton().getCClaveprodservsTableHeader().getDESCRIPTION());
                jTab.addShowColumn(TableHeaderFactory.getSigleton().getCClaveprodservsTableHeader().getENDVIGENCYDATE());
                break;
                
            case SALES_MAN:
            case USERS:
                jTab.addShowColumn(TableHeaderFactory.getSigleton().getUsersTableHeader().getCODE());
                jTab.addShowColumn(TableHeaderFactory.getSigleton().getUsersTableHeader().getNAME());
                jTab.addShowColumn(TableHeaderFactory.getSigleton().getUsersTableHeader().getEMAIL());
                break;

           case KITS:
                break;

           case CONCEPTS:
                jTab.addShowColumn(TableHeaderFactory.getSigleton().getConcepssTableHeader().getCONCEP());
                jTab.addShowColumn(TableHeaderFactory.getSigleton().getConcepssTableHeader().getDESCRIP());
                jTab.addShowColumn(TableHeaderFactory.getSigleton().getConcepssTableHeader().getFALT());
                break;

           case PAYMENT_TYPES:
                break;

           case COINS:
                jTab.addShowColumn(TableHeaderFactory.getSigleton().getCoinsTableHeader().getCODE());
                jTab.addShowColumn(TableHeaderFactory.getSigleton().getCoinsTableHeader().getDESCRIPTION());
                jTab.addShowColumn(TableHeaderFactory.getSigleton().getCoinsTableHeader().getC_MONEDA());
                break;
               
           case CCOINS:
                jTab.addShowColumn(TableHeaderFactory.getSigleton().getCCoinsTableHeader().getCODE());
                jTab.addShowColumn(TableHeaderFactory.getSigleton().getCCoinsTableHeader().getDESCRIPTION());
                jTab.addShowColumn(TableHeaderFactory.getSigleton().getCCoinsTableHeader().getDECIMALS());
                break;
               
           case WAREHOUSES:
                jTab.addShowColumn(TableHeaderFactory.getSigleton().getWarehousesTableHeader().getCODE());
                jTab.addShowColumn(TableHeaderFactory.getSigleton().getWarehousesTableHeader().getDESCRIPTION());
                jTab.addShowColumn(TableHeaderFactory.getSigleton().getWarehousesTableHeader().getADDRESS1());
                break;

           case CLASSIFICATIONS:
                break;

           case SUPPLIERS_CLASIFICATION:
                break;

            case ANAQS:
                break;

            case GENERAL_PLACES:
                break;

            case BRANDS:
                break;

            case LINES:
                break;

            case TAXES:
                break;

            case UNIDS:
                break;

            case PESOS:                
                break;

            case MEASURES:
                break;

            case FABRICANTES:
                break;

            case MODELS:
                break;

            case ALL_COMPUESTS_PRODUCTS: // AND prods.COMPUE = 0
                break;

            case TYPES:
                break;

            case ZONES:
                jTab.addShowColumn(TableHeaderFactory.getSigleton().getZonasTableHeader().getCOD());
                jTab.addShowColumn(TableHeaderFactory.getSigleton().getZonasTableHeader().getDESCRIP());
                jTab.addShowColumn(TableHeaderFactory.getSigleton().getZonasTableHeader().getESTAC());
                break;

            case GIROS:
                jTab.addShowColumn(TableHeaderFactory.getSigleton().getGirosTableHeader().getGIR());
                jTab.addShowColumn(TableHeaderFactory.getSigleton().getZonasTableHeader().getDESCRIP());
                jTab.addShowColumn(TableHeaderFactory.getSigleton().getZonasTableHeader().getESTAC());
                break;

            case PRODDS_SERIE:
                break;

            case PRODS_NOT_SERIE:
                break;

            case RUBROS:
                break;

            case CREDIT_NOTES:
                break;

            case PAYMENT_CONCEPTS:
                break;

            case BANKS:
                break;

            case SUCURSALS:
                break;

            case RESPONSABLES:
                break;

            case CUSTOMERS_SERIE:
                break;

            case CPS:
                jTab.addShowColumn(TableHeaderFactory.getSigleton().getCCodigoPostalsTableHeader().getC_CODIGO_POSTAL());
                jTab.addShowColumn(TableHeaderFactory.getSigleton().getCCodigoPostalsTableHeader().getC_MUNICIPIO());
                jTab.addShowColumn(TableHeaderFactory.getSigleton().getCCodigoPostalsTableHeader().getC_ESTADO());
                break;

            case EXPEDITION_PLACE:
                jTab.addShowColumn(TableHeaderFactory.getSigleton().getCCodigoPostalsTableHeader().getC_CODIGO_POSTAL());
                jTab.addShowColumn(TableHeaderFactory.getSigleton().getCCodigoPostalsTableHeader().getC_ESTADO());
                jTab.addShowColumn(TableHeaderFactory.getSigleton().getCCodigoPostalsTableHeader().getC_LOCALIDAD());
                break;

            case COUNTRIES:
                jTab.addShowColumn(TableHeaderFactory.getSigleton().getCCountriesTableHeader().getC_PAIS());
                jTab.addShowColumn(TableHeaderFactory.getSigleton().getCCountriesTableHeader().getDESCRIPTION());
                jTab.addShowColumn(TableHeaderFactory.getSigleton().getCCountriesTableHeader().getAGRUPACIONES());
                break;                   

            case SECTORS:               
               break;

            case FISCAL_REGIMEN:
                jTab.addShowColumn(TableHeaderFactory.getSigleton().getCRegimenFiscalTableHeader().getc_RegimenFiscal());
                jTab.addShowColumn(TableHeaderFactory.getSigleton().getCRegimenFiscalTableHeader().getDESCRIPTION());
                jTab.addShowColumn(TableHeaderFactory.getSigleton().getCRegimenFiscalTableHeader().getFecha_de_inicio_de_vigencia());
               break;
        }
        
        //Assign the repository
        switch(SearchCommonTypeEnum){

            case CUSTOMERS:
                jTab.setRepository(RepositoryFactory.getInstance().getCompanysRepository());
                break;
            
            case BANCOS:
                jTab.setRepository(RepositoryFactory.getInstance().getBancosRepository());
                break;
                
            case PAYMENT_METHOD:
                jTab.setRepository(RepositoryFactory.getInstance().getCPaymentFormsRepository());
                break;
                
            case BASDATS:
                jTab.setRepository(RepositoryFactory.getInstance().getBasDatssRepository());
                break;

            case PRODUCTO_PRICE_LIST:
            case PRODUCTS_FOR_SALE:
            case PRODUCTS:
                jTab.setRepository(RepositoryFactory.getInstance().getProductsRepository());
                break;

            case SUPPLIERS:
                this.jTab.setRepository(RepositoryFactory.getInstance().getSuppliersRepository());
                break;

            case CLAVES_PROD_SAT:
                this.jTab.setRepository(RepositoryFactory.getInstance().getCClaveprodservsRepository());
                break;

           case SALES_MAN:
           case USERS:
               this.jTab.setRepository(RepositoryFactory.getInstance().getUsersRepository());
                break;

           case KITS:
                break;

           case CONCEPTS:
                break;

           case PAYMENT_TYPES:
                break;

           case COINS:
                break;

           case CCOINS:
                this.jTab.setRepository(RepositoryFactory.getInstance().getCoinsRepository());
                break;

           case WAREHOUSES:
                this.jTab.setRepository(RepositoryFactory.getInstance().getWarehousesRepository());
                break;

           case CLASSIFICATIONS:
                break;

           case SUPPLIERS_CLASIFICATION:
                break;

            case ANAQS:
                break;

            case GENERAL_PLACES:
                break;

            case BRANDS:
                break;

            case LINES:
                break;

            case TAXES:
                break;

            case UNIDS:
                break;

            case PESOS:
                break;

            case MEASURES:
                break;

            case FABRICANTES:
                break;

            case MODELS:
                break;

            case ALL_COMPUESTS_PRODUCTS: // AND prods.COMPUE = 0
                break;

            case TYPES:
                break;

            case ZONES:
                break;

            case GIROS:
                break;

            case PRODDS_SERIE:
                break;

            case PRODS_NOT_SERIE:
                break;

            case RUBROS:
                break;

            case CREDIT_NOTES:
                break;

            case PAYMENT_CONCEPTS:
                break;

            case BANKS:
                break;

            case SUCURSALS:
                break;

            case RESPONSABLES:
                break;

            case CUSTOMERS_SERIE:
                break;

            case CPS:
                this.jTab.setRepository(RepositoryFactory.getInstance().getCCodigoPostalRepository());
                break;

            case EXPEDITION_PLACE:
                this.jTab.setRepository(RepositoryFactory.getInstance().getCCodigoPostalRepository());
                break;

            case COUNTRIES:
                this.jTab.setRepository(RepositoryFactory.getInstance().getCCountriesRepository());
                break;

            case SECTORS:
               break;

            case FISCAL_REGIMEN:
                this.jTab.setRepository(RepositoryFactory.getInstance().getCRegimenFiscalRepository());
               break;
        }
        
        if(isPagination()){
            
            this.jTab.setOnPaginationLabelUpdate((String paginationUpdate) -> {
                labelPaginacion.setVisible(true);
                labelPaginacion.setText(paginationUpdate);
            });
        }
        
        this.load();
                        
        this.pack();
    }
    
    private void load() throws Exception {
    
        if(isPagination()){

            
            this.jTab.resetPaginationText();
            this.labelPaginacion.setText(this.jTab.getPaginationText());
            this.jTab.initTableWithPaginationSearchFilter(search);
        }
        else if(isNormal()){
            jTab.initTableBySearchFilter(search);
        }
        else if(isPriceList()){
            final List<ProductPriceListModel> items = RepositoryFactory.getInstance().getProductsRepository().getPriceListsFromProductToListModel(extraCode);
            jTab.initTable(items);
        }
    }
    
    private boolean isNormal(){
        
        boolean value = false;
        
        //Determine if pagination or not
        switch(SearchCommonTypeEnum){
            case CUSTOMERS:
            case BASDATS:            
            case SALES_MAN:
            case USERS:
            case KITS:
            case PAYMENT_METHOD:
            case CONCEPTS:
            case PAYMENT_TYPES:
            case COINS:
            case CCOINS:
            case WAREHOUSES:
            case BANCOS:
            case CLASSIFICATIONS:
            case SUPPLIERS_CLASIFICATION:
            case ANAQS:
            case GENERAL_PLACES:
            case BRANDS:
            case LINES:
            case TAXES:
            case UNIDS:
            case PESOS:
            case MEASURES:
            case FABRICANTES:
            case MODELS:
            case ALL_COMPUESTS_PRODUCTS:
            case TYPES:
            case ZONES:
            case GIROS:
            case PRODDS_SERIE:
            case PRODS_NOT_SERIE:
            case RUBROS:
            case CREDIT_NOTES:
            case PAYMENT_CONCEPTS:
            case BANKS:
            case SUCURSALS:
            case RESPONSABLES:
            case CUSTOMERS_SERIE:
            case SECTORS:
            case FISCAL_REGIMEN:
                value = true;
                break;
        }
        
        return value;
    }
    
    private boolean isPriceList(){
        
        boolean value = false;
        
        //Determine if pagination or not
        switch(SearchCommonTypeEnum){
            case PRODUCTO_PRICE_LIST:                
                value = true;
                break;
        }
        
        return value;
    }
    
    private boolean isPagination(){
        
        boolean value = false;
        
        //Determine if pagination or not        
        switch(SearchCommonTypeEnum){
            case CPS:
            case COUNTRIES:
            case EXPEDITION_PLACE:
            case CLAVES_PROD_SAT:
            case PRODUCTS:
            case PRODUCTS_FOR_SALE:
            case SUPPLIERS:
                value = true;
                break;
        }
        
        return value;
    }
    
    private void jBtnSearchClicked(ActionEvent ActionEvent){
    
        try {
            
            //Get text to search
            search = jTextFieldSearch.getText();                        
            
            load();
            
        } catch (Exception ex) {
            LoggerUtility.getSingleton().logError(this.getClass(), ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    private void aceptButtonClicked(ActionEvent ActionEvent){
    
        try{
            
            if(jTab.getSelectedRow()==-1){

                final OKDialog OKDialog = DialogsFactory.getSingleton().getOKDialog(baseJFrame);
                OKDialog.setPropertyText("selection_first");
                OKDialog.show();
                return;
            }

            cod = jTab.getValueAt(jTab.getSelectedRow(), 0).toString();
            descrip = jTab.getValueAt(jTab.getSelectedRow(), 1)==null?"":jTab.getValueAt(jTab.getSelectedRow(), 1).toString();
            others = jTab.getValueAt(jTab.getSelectedRow(), 2)==null?"":jTab.getValueAt(jTab.getSelectedRow(), 2).toString();
            dispose();
            
            if(ButtonAceptClicked!=null){
                ButtonAceptClicked.onAceptClicked();
            }
            
        }catch(Exception e){
            
            LoggerUtility.getSingleton().logError(SearchViewController.class, e);
            
            try {
                final ErrorOKDialog ErrorOKDialog = DialogsFactory.getSingleton().getErrorOKDialog(baseJFrame);
                ErrorOKDialog.show();
            } catch (Exception ex) {
                Logger.getLogger(SearchViewController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }                    
    }

    public String getCod() {
        return cod;
    }

    public String getDescrip() {
        return descrip;
    }

    public String getOthers() {
        return others;
    }

    public boolean isCanceled() {
        return canceled;
    }

    public void setSEARCH_TYPE(SearchCommonTypeEnum SearchCommonTypeEnum) {
        this.SearchCommonTypeEnum = SearchCommonTypeEnum;
    }

    @Override
    public List<?> getItemsToLoadInTable() throws Exception {
        return this.list;
    }
    

    public interface ButtonAceptClicked{
        public void onAceptClicked();
    }
}
