/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.easyretail.controllers.views;

import com.era.datamodels.enums.SearchCommonTypeEnum;
import com.era.logger.LoggerUtility;
import com.era.repositories.RepositoryFactory;
import com.era.utilities.UtilitiesFactory;
import com.era.views.SearchJFrame;
import com.era.views.dialogs.DialogsFactory;
import com.era.views.dialogs.ErrorOKDialog;
import com.era.views.dialogs.OKDialog;
import com.era.views.tables.SearchCommonJTable;
import com.era.views.tables.headers.TableHeaderFactory;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author PC
 */
public class SearchViewController extends SearchJFrame {
    
    private List<?> list;
    
    private String cod;
    private String descrip;
    private String others;
    
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
        
        java.net.URL imgURL = getClass().getResource("/imgs/loading.gif");
        if (imgURL != null) {
            ImageIcon imageIcon = new ImageIcon(imgURL, "");
            imageIcon = scaleImage(imageIcon,100,100);            
            labelLoading.setIcon(imageIcon);
        } else {
            System.err.println("Couldn't find file: ");            
        }
        labelLoading.setPreferredSize(new Dimension(70,50));
        labelLoading.setVisible(false);
                
        jTab = new SearchCommonJTable();
        
        this.BaseJTable = jTab;
                
    }
    
    @Override
    public void loadModelInFields(Object ObjectModel) throws  Exception {        
    }
    
    @Override
    public void clearFields(){
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
        
        search();
        super.setVisible();                 
    }
    
    public void search(){                
                
        try{
                        
            final RepositoryFactory RepositoryManager_ = RepositoryFactory.getInstance();            
            long count;
                    
            switch(SearchCommonTypeEnum){

                case CUSTOMERS:
                    list = RepositoryManager_.getCompanysRepository().getAll();                    
                    break;
                    
                case BASDATS:
                    list = RepositoryManager_.getBasDatssRepository().getAll();
                    break;

                case PRODUCTS:
                    list = RepositoryManager_.getProductsRepository().getAll();
                    break;

                case SUPPLIERS:
                    list = RepositoryManager_.getSuppliersRepository().getAll();
                    break;

               case USERS:
                    list = RepositoryManager_.getUsersRepository().getAll();
                    break;

               case KITS:
                    list = RepositoryManager_.getKitssRepository().getAll();
                    break;

               case CONCEPTS:
                    list = RepositoryManager_.getConcepnotsRepository().getAll();
                    break;

               case PAYMENT_TYPES:
                    list = RepositoryManager_.getPaymentFormsRepository().getAll();
                    break;

               case COINS:
                    list = RepositoryManager_.getCoinsRepository().getAll();
                    break;

               case WAREHOUSES:
                    list = RepositoryManager_.getWarehousesRepository().getAll();
                    break;

               case CLASSIFICATIONS:
                    list = RepositoryManager_.getClasificacionsRepository().getAll();
                    break;

               case SUPPLIERS_CLASIFICATION:
                    list = RepositoryManager_.getSuppliersRepository().getAll();
                    break;

                case ANAQS:
                    list = RepositoryManager_.getAnaqssRepository().getAll();
                    break;

                case GENERAL_PLACES:
                    list = RepositoryManager_.getLugssRepository().getAll();
                    break;

                case BRANDS:
                    list = RepositoryManager_.getMarcssRepository().getAll();
                    break;

                case LINES:
                    list = RepositoryManager_.getLinesRepository().getAll();
                    break;

                case TAXES:
                    list = RepositoryManager_.getTaxesRepository().getAll();
                    break;

                case UNIDS:
                    list = RepositoryManager_.getUnidsRepository().getAll();
                    break;

                case PESOS:
                    list = RepositoryManager_.getPessRepository().getAll();
                    break;
                
                case MEASURES:
                    list = RepositoryManager_.getMedssRepository().getAll();
                    break;

                case FABRICANTES:
                    list = RepositoryManager_.getFabssRepository().getAll();
                    break;

                case SALES_MAN:
                    list = RepositoryManager_.getUsersRepository().getAllVends();
                    break;

                case MODELS:
                    list = RepositoryManager_.getModelsRepository().getAll();
                    break;

                case ALL_COMPUESTS_PRODUCTS: // AND prods.COMPUE = 0
                    list = RepositoryManager_.getProductsRepository().getAllCompuests();
                    break;

                case TYPES:
                    list = RepositoryManager_.getTipssRepository().getAll();
                    break;

                case ZONES:
                    list = RepositoryManager_.getZonasRepository().getAll();
                    break;

                case GIROS:
                    list = RepositoryManager_.getGirosRepository().getAll();
                    break;

                case PRODDS_SERIE:
                    list = RepositoryManager_.getProductsRepository().getAllProdsWithSerie();
                    break;

                case PRODS_NOT_SERIE:
                    list = RepositoryManager_.getProductsRepository().getAllProdsNotSerie();
                    break;

                case RUBROS:
                    list = RepositoryManager_.getRubrsRepository().getAll();
                    break;

                case CREDIT_NOTES:
                    list = RepositoryManager_.getSalessRepository().getAllNotsCred();
                    break;

                case PAYMENT_CONCEPTS:
                    list = RepositoryManager_.getConceppagsRepository().getAll();
                    break;

                case BANKS:
                    list = RepositoryManager_.getBancosRepository().getAll();
                    break;

                case SUCURSALS:
                    list = RepositoryManager_.getSucursalsRepository().getAll();
                    break;

                case RESPONSABLES:
                    list = RepositoryManager_.getSucursalsRepository().getAll();
                    break;

                case CUSTOMERS_SERIE:
                    list = RepositoryManager_.getSeriesRepository().getAllSerieEMP();
                    break;

                case CPS:
                    
                    list = RepositoryManager_.getCCodigoPostalRepository().getAllByPage(0);
                    count = RepositoryManager_.getCCodigoPostalRepository().getCount();
                    jTab.setCount(count);
                    jTab.setPagination(list.size());
                    
                    showPaginationLabel();
                    
                    break;
                
                case EXPEDITION_PLACE:
                    
                    list = RepositoryManager_.getCCodigoPostalRepository().getAllByPageExpeditionPlace(0);
                    count = RepositoryManager_.getCCodigoPostalRepository().getCount();
                    jTab.setCount(count);
                    jTab.setPagination(list.size());
                    
                    showPaginationLabel();
                    
                    break;
                    
                case COUNTRIES:
                    
                    list = RepositoryManager_.getCCountriesRepository().getAllByPage(0);
                    count = RepositoryManager_.getCCountriesRepository().getCount();
                    jTab.setCount(count);
                    jTab.setPagination(list.size());
                    
                    showPaginationLabel();
                    
                    break;                   
                    
                case SECTORS:
                   list = RepositoryManager_.getSectoressRepository().getAll();
                   break;
                   
                case FISCAL_REGIMEN:
                   list = RepositoryManager_.getCRegimenFiscalRepository().getAll();
                   break;
            }
            
            if(list!=null){                
                initTable(list);
            }                
            
        }catch(Exception e){
            LoggerUtility.getSingleton().logError(SearchViewController.class, e);
            JOptionPane.showMessageDialog(null, e.getMessage(), "Empresa", JOptionPane.ERROR_MESSAGE, null);
        }
    }

    private void showPaginationLabel() throws Exception {
        labelPaginacion.setVisible(true);
        final Properties Properties = UtilitiesFactory.getSingleton().getDialogPropertiesUitlity().getProperties();
        labelPaginacion.setText(Properties.getProperty("visible_records") + " " + jTab.getLastRowIndex() + " " + Properties.getProperty("visible_records_visibles") + " " + jTab.getPagination() + " " + Properties.getProperty("visible_records_of") + " " + jTab.getCount());
    }
    
    private void loadDataByPage(final int initialIndex) throws Exception {
        
        //Review if is paginable
        switch(SearchCommonTypeEnum){

            case CPS:
            case COUNTRIES:
            case EXPEDITION_PLACE:
                
                jTab.setPrevRowIndex(initialIndex);
                
                List<?> rows = new ArrayList<>();
                
                //Get the specific list type
                switch(SearchCommonTypeEnum){
                    case CPS:
                        rows = RepositoryFactory.getInstance().getCCodigoPostalRepository().getAllByPage(jTab.getPrevRowIndex());
                        break;
                    
                    case COUNTRIES:
                        rows = RepositoryFactory.getInstance().getCCountriesRepository().getAllByPage(jTab.getPrevRowIndex());
                        break;
                        
                    case EXPEDITION_PLACE:
                        rows = RepositoryFactory.getInstance().getCCodigoPostalRepository().getAllByPageExpeditionPlace(jTab.getPrevRowIndex());
                        break;
                }
                          
                jTab.setLastRowIndex(jTab.getPrevRowIndex() + rows.size());
                
                showPaginationLabel();
                
                if(jTab!=null){
                    jTab.clearRows();
                }
                
                jTab.addRows(rows);

                break;
                
            default:
                break;
        }
    }
    
    private void initTable(final List<?> items) throws Exception {
                
        jTab.setSearchCommonTypeEnum(SearchCommonTypeEnum);        
        jTab.setJTableDoubleClic((int selectedRow) -> {
            jBCarg.doClick();
        });
        jTab.loadScrollpane();
        jTab.getJScrollPane().setPreferredSize(new Dimension(70,150));
        jPanelTable.add(jTab.getJScrollPane());        
        jTab.setScrollAtStartWhenEnd(true);
        jTab.setOnScrollMinimum(() -> {
            try{
                
                SwingUtilities.invokeLater(() -> {
                    labelLoading.setVisible(true);
                });

                loadDataByPage(jTab.getLastRowIndex());
                
                SwingUtilities.invokeLater(() -> {
                    labelLoading.setVisible(false);
                });
                
            }catch(Exception e){
            
                LoggerUtility.getSingleton().logError(SearchViewController.class, e);

                try {
                    final ErrorOKDialog ErrorOKDialog = DialogsFactory.getSingleton().getErrorOKDialog(baseJFrame);
                    ErrorOKDialog.show();
                } catch (Exception ex) {
                    Logger.getLogger(SearchViewController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        jTab.setOnScrollBottom(() -> {
            try{
                
                SwingUtilities.invokeLater(() -> {
                    labelLoading.setVisible(true);
                });
                
                loadDataByPage(jTab.getPrevRowIndex() - jTab.getPagination());
                
                SwingUtilities.invokeLater(() -> {
                    labelLoading.setVisible(false);
                });
                
            }catch(Exception e){
            
                LoggerUtility.getSingleton().logError(SearchViewController.class, e);

                try {
                    final ErrorOKDialog ErrorOKDialog = DialogsFactory.getSingleton().getErrorOKDialog(baseJFrame);
                    ErrorOKDialog.show();
                } catch (Exception ex) {
                    Logger.getLogger(SearchViewController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }            
        });
        jTab.setJTableEnterKeyPressed((int selectedRow) -> {
            jBCarg.doClick();
        });
        this.BaseJTable = jTab;
        switch(SearchCommonTypeEnum){

            case CUSTOMERS:
                jTab.addShowColumn(TableHeaderFactory.getSigleton().getCompanysTableHeader().getCOMPANYCODE());
                jTab.addShowColumn(TableHeaderFactory.getSigleton().getCompanysTableHeader().getNOM());
                jTab.addShowColumn(TableHeaderFactory.getSigleton().getCompanysTableHeader().getCO1());
                break;

            case BASDATS:
                jTab.addShowColumn(TableHeaderFactory.getSigleton().getBasDatssTableHeader().getCODEMP());
                jTab.addShowColumn(TableHeaderFactory.getSigleton().getBasDatssTableHeader().getNOM());
                jTab.addShowColumn(TableHeaderFactory.getSigleton().getBasDatssTableHeader().getBD());                
                break;

            case PRODUCTS:
                break;

            case SUPPLIERS:
                break;

           case USERS:
                jTab.addShowColumn(TableHeaderFactory.getSigleton().getUsersTableHeader().getCODE());
                jTab.addShowColumn(TableHeaderFactory.getSigleton().getUsersTableHeader().getNAME());
                jTab.addShowColumn(TableHeaderFactory.getSigleton().getUsersTableHeader().getEMAIL());
                break;

           case KITS:
                break;

           case CONCEPTS:
                break;

           case PAYMENT_TYPES:
                break;

           case COINS:
                break;

           case WAREHOUSES:
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

            case SALES_MAN:
                jTab.addShowColumn(TableHeaderFactory.getSigleton().getUsersTableHeader().getCODE());
                jTab.addShowColumn(TableHeaderFactory.getSigleton().getUsersTableHeader().getNAME());
                jTab.addShowColumn(TableHeaderFactory.getSigleton().getUsersTableHeader().getEMAIL());
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
                jTab.addShowColumn(TableHeaderFactory.getSigleton().getCCodigoPostalsTableHeader().getC_CODIGO_POSTAL());
                jTab.addShowColumn(TableHeaderFactory.getSigleton().getCCodigoPostalsTableHeader().getC_MUNICIPIO());
                jTab.addShowColumn(TableHeaderFactory.getSigleton().getCCodigoPostalsTableHeader().getC_ESTADO());
                break;

            case EXPEDITION_PLACE:
                break;

            case COUNTRIES:
                jTab.addShowColumn(TableHeaderFactory.getSigleton().getCCountriesTableHeader().getC_PAIS());
                jTab.addShowColumn(TableHeaderFactory.getSigleton().getCCountriesTableHeader().getDESCRIPTION());
                jTab.addShowColumn(TableHeaderFactory.getSigleton().getCCountriesTableHeader().getAGRUPACIONES());                                
                break;                   

            case SECTORS:               
               break;

            case FISCAL_REGIMEN:               
               break;
        }
        
        this.loadAllItemsInTable();
        
        this.pack();
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
