/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.easyretail.controllers.views;

import com.era.logger.LoggerUtility;
import com.era.models.Almas;
import com.era.models.Anaqs;
import com.era.models.Banco;
import com.era.models.BasDats;
import com.era.models.CCodigopostal;
import com.era.models.Clasificacion;
import com.era.models.Clasprov;
import com.era.models.Coin;
import com.era.models.Colos;
import com.era.models.Company;
import com.era.models.Conceppag;
import com.era.models.Conceps;
import com.era.models.Country;
import com.era.models.Fabs;
import com.era.models.Giro;
import com.era.models.Kits;
import com.era.models.Line;
import com.era.models.Lugs;
import com.era.models.Marcs;
import com.era.models.Measure;
import com.era.models.Payment;
import com.era.models.Pes;
import com.era.models.Product;
import com.era.models.Responsable;
import com.era.models.Rubr;
import com.era.models.Sales;
import com.era.models.Sectores;
import com.era.models.Serie;
import com.era.models.Sucursal;
import com.era.models.Supplier;
import com.era.models.Tall;
import com.era.models.Tax;
import com.era.models.Tips;
import com.era.models.Ubiad;
import com.era.models.Unid;
import com.era.models.User;
import com.era.models.Zona;
import com.era.repositories.RepositoryManager;
import com.era.views.SearchJFrame;
import com.era.views.abstracttablesmodel.AditionalUbiqsAbstractTableModel;
import com.era.views.abstracttablesmodel.AnaqsAbstractTableModel;
import com.era.views.abstracttablesmodel.BanksAbstractTableModel;
import com.era.views.abstracttablesmodel.BasDatsAbstractTableModel;
import com.era.views.abstracttablesmodel.BrandsAbstractTableModel;
import com.era.views.abstracttablesmodel.CPSAbstractTableModel;
import com.era.views.abstracttablesmodel.ClasificationsAbstractTableModel;
import com.era.views.abstracttablesmodel.CoinsAbstractTableModel;
import com.era.views.abstracttablesmodel.ColorsAbstractTableModel;
import com.era.views.abstracttablesmodel.ConceptPaymentsAbstractTableModel;
import com.era.views.abstracttablesmodel.ConceptsAbstractTableModel;
import com.era.views.abstracttablesmodel.CountriesAbstractTableModel;
import com.era.views.abstracttablesmodel.CustomersAbstractTableModel;
import com.era.views.abstracttablesmodel.FabricsAbstractTableModel;
import com.era.views.abstracttablesmodel.GirosAbstractTableModel;
import com.era.views.abstracttablesmodel.KitsAbstractTableModel;
import com.era.views.abstracttablesmodel.LinesAbstractTableModel;
import com.era.views.abstracttablesmodel.MeasuresAbstractTableModel;
import com.era.views.abstracttablesmodel.PaymentTypesAbstractTableModel;
import com.era.views.abstracttablesmodel.PlacesAbstractTableModel;
import com.era.views.abstracttablesmodel.ProductsAbstractTableModel;
import com.era.views.abstracttablesmodel.ResponsablesAbstractTableModel;
import com.era.views.abstracttablesmodel.RubrosAbstractTableModel;
import com.era.views.abstracttablesmodel.SalesAbstractTableModel;
import com.era.views.abstracttablesmodel.SectorsAbstractTableModel;
import com.era.views.abstracttablesmodel.SeriesAbstractTableModel;
import com.era.views.abstracttablesmodel.SucursalsAbstractTableModel;
import com.era.views.abstracttablesmodel.SuppliersAbstractTableModel;
import com.era.views.abstracttablesmodel.SuppliersClasifcAbstractTableModel;
import com.era.views.abstracttablesmodel.TallasAbstractTableModel;
import com.era.views.abstracttablesmodel.TaxesAbstractTableModel;
import com.era.views.abstracttablesmodel.TypesAbstractTableModel;
import com.era.views.abstracttablesmodel.UnidsAbstractTableModel;
import com.era.views.abstracttablesmodel.UsersAbstractTableModel;
import com.era.views.abstracttablesmodel.WarehousesAbstractTableModel;
import com.era.views.abstracttablesmodel.WeightsAbstractTableModel;
import com.era.views.abstracttablesmodel.ZonesAbstractTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author PC
 */
public class SearchViewController extends SearchJFrame {
    
    private List<?> list;
    
    private String cod;
    private String descrip;
    private String others;
    
    private JTable jTab;
    
    private boolean canceled;
    
    public static enum SEARCH_TYPE {
        CUSTOMERS,
        BASDATS,
        PRODUCTS,
        SUPPLIERS,
        USERS,        
        KITS,
        CONCEPTS,
        PAYMENT_TYPES,
        COINS,
        WAREHOUSES,
        CLASSIFICATIONS,
        SUPPLIERS_CLASIFICATION,
        ANAQS,
        GENERAL_PLACES,
        BRANDS,
        LINES,
        TAXES,
        UNIDS,
        PESOS,
        COLORS,
        ADITIONAL_UBIQS,
        MEASURES,
        FABRICANTES,
        SALES_MAN,
        MODELS,
        ALL_COMPUESTS_PRODUCTS, // AND prods.COMPUE = 0
        TYPES,
        ZONES,
        GIROS,
        PRODDS_SERIE,
        PRODS_NOT_SERIE,
        RUBROS,
        CREDIT_NOTES,
        TALLAS,
        PAYMENT_CONCEPTS,
        BANKS,
        SUCURSALS,
        RESPONSABLES,
        CUSTOMERS_SERIE,
        CPS,
        COUNTRIES,
        SECTORS
    }
    
    private SEARCH_TYPE SEARCH_TYPE;
    
    
    
    public SearchViewController(){
        
        this.setTitle("Busqueda general");
        
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
    }
    
    private void buttonExitClicked(ActionEvent ActionEvent){
        this.canceled = true;
        dispose();
    }
    
    private void tableMouseClicked(MouseEvent evt){        
        if(evt.getClickCount() == 2) 
            jBCarg.doClick();
    }
    
    @Override
    public void setVisible() {
        
        search();
        super.setVisible();                 
    }
    
    public void search(){
        
        try{
            
            final String[] columns = new String[]{"Cod.","Descripción/Valor","Otros"};
            final RepositoryManager RepositoryManager_ = RepositoryManager.getInstance();
            AbstractTableModel AbstractTableModel = null;

            switch(SEARCH_TYPE){

                case CUSTOMERS:
                    list = RepositoryManager_.getCompanyRepository().getAll();
                    AbstractTableModel = new CustomersAbstractTableModel((List<Company>) list,columns);
                    break;
                    
                case BASDATS:
                    list = RepositoryManager_.getBasDatsRepository().getAll();
                    AbstractTableModel = new BasDatsAbstractTableModel((List<BasDats>) list,columns);
                    break;

                case PRODUCTS:
                    list = RepositoryManager_.getProductRepository().getAll();
                    AbstractTableModel = new ProductsAbstractTableModel((List<Product>) list,columns);
                    break;

                case SUPPLIERS:
                    list = RepositoryManager_.getSuppliersRepository().getAll();
                    AbstractTableModel = new SuppliersAbstractTableModel((List<Supplier>) list,columns);
                    break;

               case USERS:
                    list = RepositoryManager_.getUsersRepository().getAll();
                    AbstractTableModel = new UsersAbstractTableModel((List<User>) list,columns);
                    break;

               case KITS:
                    list = RepositoryManager_.getKitsRepository().getAll();
                    AbstractTableModel = new KitsAbstractTableModel((List<Kits>) list,columns);
                    break;

               case CONCEPTS:
                    list = RepositoryManager_.getConcepnotRepository().getAll();
                    AbstractTableModel = new ConceptsAbstractTableModel((List<Conceps>) list,columns);
                    break;

               case PAYMENT_TYPES:
                    list = RepositoryManager_.getPaymentFormsRepository().getAll();
                    AbstractTableModel = new PaymentTypesAbstractTableModel((List<Payment>) list,columns);
                    break;

               case COINS:
                    list = RepositoryManager_.getCoinsRepository().getAll();
                    AbstractTableModel = new CoinsAbstractTableModel((List<Coin>) list,columns);
                    break;

               case WAREHOUSES:
                    list = RepositoryManager_.getWarehouseRepository().getAll();
                    AbstractTableModel = new WarehousesAbstractTableModel((List<Almas>) list,columns);
                    break;

               case CLASSIFICATIONS:
                    list = RepositoryManager_.getClasificacionRepository().getAll();
                    AbstractTableModel = new ClasificationsAbstractTableModel((List<Clasificacion>) list,columns);
                    break;

               case SUPPLIERS_CLASIFICATION:
                    list = RepositoryManager_.getSuppliersRepository().getAll();
                    AbstractTableModel = new SuppliersClasifcAbstractTableModel((List<Clasprov>) list,columns);
                    break;

                case ANAQS:
                    list = RepositoryManager_.getAnaqsRepository().getAll();
                    AbstractTableModel = new AnaqsAbstractTableModel((List<Anaqs>) list,columns);
                    break;

                case GENERAL_PLACES:
                    list = RepositoryManager_.getLugsRepository().getAll();
                    AbstractTableModel = new PlacesAbstractTableModel((List<Lugs>) list,columns);
                    break;

                case BRANDS:
                    list = RepositoryManager_.getMarcsRepository().getAll();
                    AbstractTableModel = new BrandsAbstractTableModel((List<Marcs>) list,columns);
                    break;

                case LINES:
                    list = RepositoryManager_.getLinesRepository().getAll();
                    AbstractTableModel = new LinesAbstractTableModel((List<Line>) list,columns);
                    break;

                case TAXES:
                    list = RepositoryManager_.getTaxesRepository().getAll();
                    AbstractTableModel = new TaxesAbstractTableModel((List<Tax>) list,columns);
                    break;

                case UNIDS:
                    list = RepositoryManager_.getUnidsRepository().getAll();
                    AbstractTableModel = new UnidsAbstractTableModel((List<Unid>) list,columns);
                    break;

                case PESOS:
                    list = RepositoryManager_.getPesRepository().getAll();
                    AbstractTableModel = new WeightsAbstractTableModel((List<Pes>) list,columns);
                    break;

                case COLORS:
                    list = RepositoryManager_.getColosRepository().getAll();
                    AbstractTableModel = new ColorsAbstractTableModel((List<Colos>) list,columns);
                    break;

                case ADITIONAL_UBIQS:
                    list = RepositoryManager_.getUbiadRepository().getAll();
                    AbstractTableModel = new AditionalUbiqsAbstractTableModel((List<Ubiad>) list,columns);
                    break;

                case MEASURES:
                    list = RepositoryManager_.getMedsRepository().getAll();
                    AbstractTableModel = new MeasuresAbstractTableModel((List<Measure>) list,columns);
                    break;

                case FABRICANTES:
                    list = RepositoryManager_.getFabsRepository().getAll();
                    AbstractTableModel = new FabricsAbstractTableModel((List<Fabs>) list,columns);
                    break;

                case SALES_MAN:
                    list = RepositoryManager_.getUsersRepository().getAllVends();
                    AbstractTableModel = new UsersAbstractTableModel((List<User>) list,columns);
                    break;

                case MODELS:
                    list = RepositoryManager_.getModelRepository().getAll();
                    AbstractTableModel = new UsersAbstractTableModel((List<User>) list,columns);
                    break;

                case ALL_COMPUESTS_PRODUCTS: // AND prods.COMPUE = 0
                    list = RepositoryManager_.getProductRepository().getAllCompuests();
                    AbstractTableModel = new ProductsAbstractTableModel((List<Product>) list,columns);
                    break;

                case TYPES:
                    list = RepositoryManager_.getTipsRepository().getAll();
                    AbstractTableModel = new TypesAbstractTableModel((List<Tips>) list,columns);
                    break;

                case ZONES:
                    list = RepositoryManager_.getZonaRepository().getAll();
                    AbstractTableModel = new ZonesAbstractTableModel((List<Zona>) list,columns);
                    break;

                case GIROS:
                    list = RepositoryManager_.getGiroRepository().getAll();
                    AbstractTableModel = new GirosAbstractTableModel((List<Giro>) list,columns);
                    break;

                case PRODDS_SERIE:
                    list = RepositoryManager_.getProductRepository().getAllProdsWithSerie();
                    AbstractTableModel = new ProductsAbstractTableModel((List<Product>) list,columns);
                    break;

                case PRODS_NOT_SERIE:
                    list = RepositoryManager_.getProductRepository().getAllProdsNotSerie();
                    AbstractTableModel = new ProductsAbstractTableModel((List<Product>) list,columns);
                    break;

                case RUBROS:
                    list = RepositoryManager_.getRubrRepository().getAll();
                    AbstractTableModel = new RubrosAbstractTableModel((List<Rubr>) list,columns);
                    break;

                case CREDIT_NOTES:
                    list = RepositoryManager_.getSalesRepository().getAllNotsCred();
                    AbstractTableModel = new SalesAbstractTableModel((List<Sales>) list,columns);
                    break;

                case TALLAS:
                    list = RepositoryManager_.getTallRepository().getAll();
                    AbstractTableModel = new TallasAbstractTableModel((List<Tall>) list,columns);
                    break;

                case PAYMENT_CONCEPTS:
                    list = RepositoryManager_.getConceppagRepository().getAll();
                    AbstractTableModel = new ConceptPaymentsAbstractTableModel((List<Conceppag>) list,columns);
                    break;

                case BANKS:
                    list = RepositoryManager_.getBancoRepository().getAll();
                    AbstractTableModel = new BanksAbstractTableModel((List<Banco>) list,columns);
                    break;

                case SUCURSALS:
                    list = RepositoryManager_.getSucursalRepository().getAll();
                    AbstractTableModel = new SucursalsAbstractTableModel((List<Sucursal>) list,columns);
                    break;

                case RESPONSABLES:
                    list = RepositoryManager_.getSucursalRepository().getAll();
                    AbstractTableModel = new ResponsablesAbstractTableModel((List<Responsable>) list,columns);
                    break;

                case CUSTOMERS_SERIE:
                    list = RepositoryManager_.getSerieRepository().getAllSerieEMP();
                    AbstractTableModel = new SeriesAbstractTableModel((List<Serie>) list,columns);
                    break;

                case CPS:
                    list = RepositoryManager_.getCCodigoPostalRepository().getAll();
                    AbstractTableModel = new CPSAbstractTableModel((List<CCodigopostal>) list,columns);
                    break;

                case COUNTRIES:
                    list = RepositoryManager_.getCountriesRepository().getAll();
                    AbstractTableModel = new CountriesAbstractTableModel((List<Country>) list,columns);
                    break;

               case SECTORS:
                   list = RepositoryManager_.getSectoresRepository().getAll();
                   AbstractTableModel = new SectorsAbstractTableModel((List<Sectores>) list,columns);
                   break;
            }
            
            if(AbstractTableModel!=null){
                initTable(AbstractTableModel);                
            }                
            
        }catch(Exception e){
            LoggerUtility.getSingleton().logError(SearchViewController.class, e);
            JOptionPane.showMessageDialog(null, e.getMessage(), "Empresa", JOptionPane.ERROR_MESSAGE, null);
        }
    }
    
    private void initTable(AbstractTableModel AbstractTableModel){
        
        jTab = new JTable(AbstractTableModel);
        
        /*jTab.setAutoResizeMode(0);
        
        jTab.getTableHeader().setReorderingAllowed(false);
        
        TableRowSorter trs = new TableRowSorter<>((AbstractTableModel)jTab.getModel());
        jTab.setRowSorter(trs);
        trs.setSortsOnUpdates(true);
        
        jTab.grabFocus();
        
        jTab.getColumnModel().getColumn(1).setPreferredWidth(250);
        jTab.getColumnModel().getColumn(2).setPreferredWidth(250);
        
        jTab.setFocusTraversalKeys(java.awt.KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, null);
        jTab.setFocusTraversalKeys(java.awt.KeyboardFocusManager.BACKWARD_TRAVERSAL_KEYS, null);
        
        JComponentUtils.addComponentToKeyPress(jTab);
        
        jTab.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                tableMouseClicked(e);
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });*/
        
        final JScrollPane tableContainer = new JScrollPane(jTab);
        
        jPanelTable.add(tableContainer);  
        
        this.pack();
    }
    
    private void aceptButtonClicked(ActionEvent ActionEvent){
    
        if(jTab.getSelectedRow()==-1){
            return;
        }
        
        cod = jTab.getValueAt(jTab.getSelectedRow(), 0).toString();
        descrip = jTab.getValueAt(jTab.getSelectedRow(), 1).toString();
        others = jTab.getValueAt(jTab.getSelectedRow(), 1).toString();
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

    public void setSEARCH_TYPE(SEARCH_TYPE SEARCH_TYPE) {
        this.SEARCH_TYPE = SEARCH_TYPE;
    }
    
    
}
