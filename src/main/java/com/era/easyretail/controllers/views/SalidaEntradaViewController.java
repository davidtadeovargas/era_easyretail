/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.easyretail.controllers.views;

import com.era.datamodels.enums.MovinvenType;
import com.era.datamodels.enums.SearchCommonTypeEnum;
import com.era.logger.LoggerUtility;
import com.era.models.Conceps;
import com.era.models.Ingres;
import com.era.models.IngresosEncab;
import com.era.models.Product;
import com.era.models.Unid;
import com.era.models.Warehouse;
import com.era.repositories.RepositoryFactory;
import com.era.utilities.DialogPropertiesUitlity;
import com.era.utilities.UtilitiesFactory;
import com.era.views.SalidaEntradaJFrame;
import com.era.views.dialogs.DialogsFactory;
import com.era.views.tables.headers.TableHeaderFactory;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author PC
 */
public class SalidaEntradaViewController extends SalidaEntradaJFrame {
 
    private MovinvenType MovinvenType_;
    
    public SalidaEntradaViewController() {
        super("window_title_salidaentrada");
        
        try{
            
            jBtnAceptar.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBtnAceptarActionPerformed(evt);
            });
            jBtnSalir.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBtnSalirActionPerformed(evt);
            });
            jBtnConcepto.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBtnConceptoActionPerformed(evt);
            });
            jBtnBusProducto.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBtnBusProductoActionPerformed(evt);
            });
            jBtnActivo.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBtnActivoActionPerformed(evt);
            });
            btnBorrar.addActionListener((java.awt.event.ActionEvent evt) -> {
                btnBorrarActionPerformed(evt);
            });
            btnAgregar.addActionListener((java.awt.event.ActionEvent evt) -> {
                btnAgregarActionPerformed(evt);
            });
 
            //Not modificable, only the product selection can do that
            cmbUnidad.setEnabled(false);
            
            //Init caducity date to today
            caducityjCalendar.setCalendar(UtilitiesFactory.getSingleton().getDateTimeUtility().getCurrentDateInCalendar());
            
            this.JComponentUtils.onlyDecimals(txtCantidad);
            this.JComponentUtils.moneyFormat(ftxCosto);
                        
            cmbUnidad.loadItems();
            cmbUnidad.setChangeSelectionListener((Object ObjectModel) -> {
                
                //Cast model
                final Unid Unid = (Unid)ObjectModel;
            });
            
            //Init the table
            this.BaseJTable = tblPartidas;
            tblPartidas.addShowColumn(TableHeaderFactory.getSigleton().getIngressTableHeader().getROWNUMBER());
            tblPartidas.addShowColumn(TableHeaderFactory.getSigleton().getIngressTableHeader().getPROD());
            tblPartidas.addShowColumn(TableHeaderFactory.getSigleton().getIngressTableHeader().getPRODUCT_DESCRIPTION());
            tblPartidas.addShowColumn(TableHeaderFactory.getSigleton().getIngressTableHeader().getCANT());
            tblPartidas.addShowColumn(TableHeaderFactory.getSigleton().getIngressTableHeader().getUNID());
            tblPartidas.addShowColumn(TableHeaderFactory.getSigleton().getIngressTableHeader().getCOSTO());
            tblPartidas.addShowColumn(TableHeaderFactory.getSigleton().getIngressTableHeader().getACTIVO());
            tblPartidas.addShowColumn(TableHeaderFactory.getSigleton().getIngressTableHeader().getPEDIMENTO());
            tblPartidas.addShowColumn(TableHeaderFactory.getSigleton().getIngressTableHeader().getLOTE());
            tblPartidas.addShowColumn(TableHeaderFactory.getSigleton().getIngressTableHeader().getCADUCIDAD());                        
            
            //Init table
            final List<Ingres> items = new ArrayList<>();            
            tblPartidas.initTable(items);
            
            cmbAlmacen.loadItems();
            cmbAlmacen.setChangeSelectionListener((Object ObjectModel) -> {
                
                //Cast model
                final Warehouse Warehouse = (Warehouse)ObjectModel;
                
                jTxtDescripAlmacen.setText(Warehouse.getDescription());
            });
            
            
        }catch (Exception ex) {
            LoggerUtility.getSingleton().logError(SalidaEntradaViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(SalidaEntradaViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    @Override
    public void clearFields() throws Exception{
    }

    public void view(final IngresosEncab IngresosEncab){
        
        try {
            
            this.setReadOnly(true);

            loadModelInFields(IngresosEncab);
            
        } catch (Exception ex) {
            LoggerUtility.getSingleton().logError(SalidaEntradaViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(SalidaEntradaViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    public void setMovinvenType(MovinvenType MovinvenType) throws Exception{
        this.MovinvenType_ = MovinvenType;
        
        final String subTitleWindow;
        if(MovinvenType_==MovinvenType.ENTRADA){
            subTitleWindow = "window_title_ingres_warehouse";
        }
        else{
            subTitleWindow = "window_title_out_warehouse";
        }

        final Properties props = DialogPropertiesUitlity.getSingleton().getProperties();
        final String subtitleString = props.getProperty(subTitleWindow);
        inoutLabel.setText(subtitleString);
    }
    
    @Override
    public void loadModelInFields(Object ObjectModel) throws  Exception {
        
        //Cast model
        final IngresosEncab IngresosEncab = (IngresosEncab)ObjectModel;
        
        //Get the concep
        final Conceps Concep = (Conceps)RepositoryFactory.getInstance().getConcepssRepository().getByCode(IngresosEncab.getConcep());
        
        //Get warehouse
        final Warehouse Warehouse = (Warehouse)RepositoryFactory.getInstance().getWarehousesRepository().getByCode(IngresosEncab.getAlma());
        
        txtConcepto.setText(IngresosEncab.getConcep());
        jTxtConcepDescrip.setText(Concep.getDescrip());
        txtFolioDocumento.setText(IngresosEncab.getNorefer());
        cmbAlmacen.selectByObject(Warehouse);
        
        //Get all the items
        final List<Ingres> items = RepositoryFactory.getInstance().getIngresRepository().geAllByIngresosEncabId(IngresosEncab.getId());
        
        //Load in table
        tblPartidas.initTable(items);
    }
    
    private void jBtnActivoActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
         
            
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(SalidaEntradaViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(SalidaEntradaViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{
            
            //First select a product
            final String productCode = txtProducto.getText().trim();
            if(productCode.isEmpty()){
                DialogsFactory.getSingleton().showOKEmptyFieldCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                });
                return;
            }
            
            //Get the product
            final Product Product = (Product)RepositoryFactory.getInstance().getProductsRepository().getByCode(productCode);
            
            //If not exists stop
            if(Product==null){
                DialogsFactory.getSingleton().showErrorOKRecordNotExistsCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                    txtProducto.grabFocus();
                });
                return;
            }
            
            //If warehouse not selected stop
            if(!cmbAlmacen.isSelectedObject()){
                DialogsFactory.getSingleton().showErrorOKRecordNotExistsCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                    cmbAlmacen.grabFocus();
                });
                return;
            }
            
            //If unid not selected stop
            if(!cmbUnidad.isSelectedObject()){
                DialogsFactory.getSingleton().showErrorOKRecordNotExistsCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                    cmbUnidad.grabFocus();
                });
                return;
            }
            
            //Get caducity
            final Date caducityDate = caducityjCalendar.getCalendar().getTime();
            
            //Get quantity
            final double qty = Double.valueOf(txtCantidad.getText().trim());
            
            //If quantity is invalid stop
            if(qty==0){
                DialogsFactory.getSingleton().showErrorOKCallbackDialog(baseJFrame, "errors_invalid_amount", (JFrame jFrame) -> {
                    txtCantidad.grabFocus();
                });
                return;
            }
            
            final String pediment = txtLote.getText().trim();
            final String lote = txtLote.getText().trim();
            
            //Get warehouse
            final Warehouse Warehouse = (Warehouse)cmbAlmacen.getSelectedObject();
            
            //Get unid
            final Unid Unid = (Unid)cmbUnidad.getSelectedObject();
            
            //If unid not selected
            if(Unid.getDescription()==null){
                DialogsFactory.getSingleton().showErrorOKNoSelectionCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                    cmbUnidad.grabFocus();
                });
                return;
            }
            
            final double cost = Double.valueOf(UtilitiesFactory.getSingleton().getNumbersUtility().fromMoneyFormat(ftxCosto.getText().trim()));
            
            //Create model
            final Ingres Ingres = new Ingres();
            Ingres.setProd(productCode);
            Ingres.setAlma(Warehouse.getCode());
            Ingres.setCant((float)qty);
            Ingres.setUnid(Unid.getCode());
            Ingres.setCosto(cost);
            Ingres.setLote(lote);
            Ingres.setPedimento(pediment);
            Ingres.setCaducidad(caducityDate);
            
            //Add it to the table            
            tblPartidas.addObject(Ingres);
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(SalidaEntradaViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(SalidaEntradaViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
         
            //If no selection stop
            if(!tblPartidas.isRowSelected()){
                DialogsFactory.getSingleton().showErrorOKNoSelectionCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                    tblPartidas.grabFocus();
                });
                return;
            }
            
            DialogsFactory.getSingleton().showQuestionContinueDialog(baseJFrame, (JFrame jFrame) -> {
                
                try {                    
                    
                    //Get selected object
                    final Ingres Ingres = (Ingres)tblPartidas.getRowSelected();

                    //Remove from the table
                    tblPartidas.deleteObject(Ingres);

                } catch (Exception ex) {
                    LoggerUtility.getSingleton().logError(SalidaEntradaViewController.class, ex);
                    try {
                        DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
                    } catch (Exception ex1) {
                        Logger.getLogger(SalidaEntradaViewController.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                }
            });
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(SalidaEntradaViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(SalidaEntradaViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBtnBusProductoActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
         
            //Search warehouse
            final SearchViewController SearchViewController = new SearchViewController();
            SearchViewController.setSEARCH_TYPE(SearchCommonTypeEnum.PRODUCTS);
            SearchViewController.setButtonAceptClicked(() -> {

                try {
                 
                    final String productCode = SearchViewController.getCod();
                    txtProducto.setText(productCode);

                    final String description = SearchViewController.getDescrip();
                    txtDescripcionProducto.setText(description);

                    //Get general existencies
                    final double existence = RepositoryFactory.getInstance().getExistalmasRepository().getGeneralExistenceFromProduct(productCode);
                    
                    txtExistencias.setText(String.valueOf(existence));
                    
                    //Get the product
                    final Product Product = (Product)RepositoryFactory.getInstance().getProductsRepository().getByCode(productCode);
                    
                    //Get the unid
                    final String unid = Product.getUnit();
                    final Unid Unid = (Unid)RepositoryFactory.getInstance().getUnidsRepository().getByCode(unid);
                    
                    //Select the unid in the combo
                    cmbUnidad.selectByObject(Unid);
                    
                } catch (Exception ex) {
                    LoggerUtility.getSingleton().logError(SalidaEntradaViewController.class, ex);
                    try {
                        DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
                    } catch (Exception ex1) {
                        Logger.getLogger(SalidaEntradaViewController.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                }
            });
            SearchViewController.setVisible();
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(SalidaEntradaViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(SalidaEntradaViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBtnConceptoActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
         
            //Search warehouse
            final SearchViewController SearchViewController = new SearchViewController();
            SearchViewController.setSEARCH_TYPE(SearchCommonTypeEnum.CONCEPTS);
            SearchViewController.setButtonAceptClicked(() -> {

                try {
                 
                    final String concepCode = SearchViewController.getCod();
                    txtConcepto.setText(concepCode);

                    final String description = SearchViewController.getDescrip();
                    jTxtConcepDescrip.setText(description);
                        
                } catch (Exception ex) {
                    LoggerUtility.getSingleton().logError(SalidaEntradaViewController.class, ex);
                    try {
                        DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
                    } catch (Exception ex1) {
                        Logger.getLogger(SalidaEntradaViewController.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                }
            });
            SearchViewController.setVisible();
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(SalidaEntradaViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(SalidaEntradaViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBtnSalirActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
         
            DialogsFactory.getSingleton().showQuestionContinueDialog(baseJFrame, (JFrame jFrame) -> {
                
                try {                    
            
                    dispose();
                    
                } catch (Exception ex) {
                    LoggerUtility.getSingleton().logError(EntradasSalidasViewController.class, ex);
                    try {
                        DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
                    } catch (Exception ex1) {
                        Logger.getLogger(EntradasSalidasViewController.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                }
            });
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(SalidaEntradaViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(SalidaEntradaViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBtnAceptarActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
         
            //First select a concept
            final String concept = txtConcepto.getText().trim();
            if(concept.isEmpty()){
                DialogsFactory.getSingleton().showOKEmptyFieldCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                });
                return;
            }
            
            //Get the concep
            final Conceps Conceps = (Conceps)RepositoryFactory.getInstance().getConcepssRepository().getByCode(concept);
            
            //If the concep doesnt exists stop
            if(Conceps==null){
                DialogsFactory.getSingleton().showErrorOKRecordNotExistsCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                    txtConcepto.grabFocus();
                });
                return;
            }
            
            //First select a document
            final String document = txtFolioDocumento.getText().trim();
            if(document.isEmpty()){
                DialogsFactory.getSingleton().showOKEmptyFieldCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                });
                return;
            }                
            
            //Get all the items from table
            final List<Ingres> items = (List<Ingres>)tblPartidas.getAllItemsInTable();
            
            //If no items stop
            if(items.isEmpty()){
                DialogsFactory.getSingleton().showErrorCeroItemsOKDialog(baseJFrame, (JFrame jFrame) -> {
                    tblPartidas.grabFocus();
                });
                return;
            }
                    
            //Question if continue
            DialogsFactory.getSingleton().showQuestionContinueDialog(baseJFrame, (JFrame jFrame) -> {
                
                try {
                    
                    //Calculate the total amount
                    double total = 0;
                    for(Ingres Ingres:items){
                        total += Ingres.getCant();
                    }
                    
                    //Get warehouse 
                    final Warehouse Warehouse = (Warehouse)cmbAlmacen.getSelectedObject();
                    
                    //Create header model
                    final IngresosEncab IngresosEncab = new IngresosEncab();
                    IngresosEncab.setConcep(concept);
                    IngresosEncab.setAlma(Warehouse.getCode());
                    IngresosEncab.setNoser("");
                    IngresosEncab.setNorefer(document);
                    IngresosEncab.setCanttotal(new BigDecimal(total, MathContext.DECIMAL64));                    
                    
                    //Save in the database
                    RepositoryFactory.getInstance().getIngresosEncabRepository().saveIngres(IngresosEncab, items, MovinvenType_);
                    
                    //Success
                    DialogsFactory.getSingleton().showOKOperationCompletedCallbackDialog(jFrame, (JFrame jFrame1) -> {
                        dispose();
                    });
                    
                } catch (Exception ex) {
                    LoggerUtility.getSingleton().logError(SalidaEntradaViewController.class, ex);
                    try {
                        DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
                    } catch (Exception ex1) {
                        Logger.getLogger(SalidaEntradaViewController.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                }
            });
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(SalidaEntradaViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(SalidaEntradaViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    @Override
    public List<?> getItemsToLoadInTable() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
