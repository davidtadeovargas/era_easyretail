/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.easyretail.controllers.views;

import com.era.datamodels.enums.MovinvenType;
import com.era.logger.LoggerUtility;
import com.era.models.Ingres;
import com.era.models.IngresosEncab;
import com.era.repositories.RepositoryFactory;
import com.era.views.EntradasSalidasJFrame;
import com.era.views.dialogs.DialogsFactory;
import com.era.views.tables.headers.TableHeaderFactory;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.event.ListSelectionEvent;

/**
 *
 * @author PC
 */
public class EntradasSalidasViewController extends EntradasSalidasJFrame {
 
    public EntradasSalidasViewController() {
        super("window_title_entsals");
        
        try{
            
            btnEntrada.addActionListener((java.awt.event.ActionEvent evt) -> {
                btnEntradaActionPerformed(evt);
            });
            btnSalida.addActionListener((java.awt.event.ActionEvent evt) -> {
                btnSalidaActionPerformed(evt);
            });
            btnVer.addActionListener((java.awt.event.ActionEvent evt) -> {
                btnVerActionPerformed(evt);
            });
            btnGenerarPdf.addActionListener((java.awt.event.ActionEvent evt) -> {
                btnGenerarPdfActionPerformed(evt);
            });
            btnVerPdf.addActionListener((java.awt.event.ActionEvent evt) -> {
                btnVerPdfActionPerformed(evt);
            });
            btnMostrar.addActionListener((java.awt.event.ActionEvent evt) -> {
                btnMostrarActionPerformed(evt);
            });
            btnBuscar.addActionListener((java.awt.event.ActionEvent evt) -> {
                btnBuscarActionPerformed(evt);
            });
            
            this.disposeButton(btnSalir);
            
            //Config table
            this.BaseJTable = tblEncabezados;
            tblEncabezados.addShowColumn(TableHeaderFactory.getSigleton().getIngresosEncabsTableHeader().getROWNUMBER());
            tblEncabezados.addShowColumn(TableHeaderFactory.getSigleton().getIngresosEncabsTableHeader().getCONCEP());
            tblEncabezados.addShowColumn(TableHeaderFactory.getSigleton().getIngresosEncabsTableHeader().getALMA());
            tblEncabezados.addShowColumn(TableHeaderFactory.getSigleton().getIngresosEncabsTableHeader().getNOREFER());
            tblEncabezados.addShowColumn(TableHeaderFactory.getSigleton().getIngresosEncabsTableHeader().getCANTTOTAL());
            
            tblPartidas.addShowColumn(TableHeaderFactory.getSigleton().getIngressTableHeader().getROWNUMBER());
            tblPartidas.addShowColumn(TableHeaderFactory.getSigleton().getIngressTableHeader().getPROD());
            tblPartidas.addShowColumn(TableHeaderFactory.getSigleton().getIngressTableHeader().getPRODUCT_DESCRIPTION());
            tblPartidas.addShowColumn(TableHeaderFactory.getSigleton().getIngressTableHeader().getALMA());
            tblPartidas.addShowColumn(TableHeaderFactory.getSigleton().getIngressTableHeader().getENTSAL());
            tblPartidas.addShowColumn(TableHeaderFactory.getSigleton().getIngressTableHeader().getCOSTO());
            tblPartidas.addShowColumn(TableHeaderFactory.getSigleton().getIngressTableHeader().getLOTE());
            tblPartidas.addShowColumn(TableHeaderFactory.getSigleton().getIngressTableHeader().getPEDIMENTO());
            tblPartidas.addShowColumn(TableHeaderFactory.getSigleton().getIngressTableHeader().getCANT());
            tblPartidas.addShowColumn(TableHeaderFactory.getSigleton().getIngressTableHeader().getCANTSAL());
                    
            //When selecting a row show all the details in the other table
            tblEncabezados.setITableRowSelected((ListSelectionEvent lse, Object Object) -> {
                
                try {
                 
                    //Cast object
                    final IngresosEncab IngresosEncab = (IngresosEncab)Object;

                    //Get all the details
                    final List<Ingres> items = RepositoryFactory.getInstance().getIngresRepository().geAllByIngresosEncabId(IngresosEncab.getId());
                    
                    tblPartidas.initTable(items);
                    
                } catch (Exception ex) {
                    LoggerUtility.getSingleton().logError(EntradasSalidasViewController.class, ex);
                    try {
                        DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
                    } catch (Exception ex1) {
                        Logger.getLogger(EntradasSalidasViewController.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                }
            });
            
            //Load all items with pagination
            tblEncabezados.initTableWithPagination();
            
        }catch (Exception ex) {
            LoggerUtility.getSingleton().logError(EntradasSalidasViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(EntradasSalidasViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    @Override
    public void loadModelInFields(Object ObjectModel) throws  Exception {        
    }
    
    @Override
    public void clearFields() throws Exception{            
    }
    
    private void btnEntradaActionPerformed(java.awt.event.ActionEvent evt) {

	try{
            final SalidaEntradaViewController SalidaEntradaViewController = ViewControlersFactory.getSingleton().getSalidaEntradaViewController();
            SalidaEntradaViewController.setMovinvenType(MovinvenType.ENTRADA);
            SalidaEntradaViewController.setVisible();
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(EntradasSalidasViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(EntradasSalidasViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void btnSalidaActionPerformed(java.awt.event.ActionEvent evt) {

	try{            	
            final SalidaEntradaViewController SalidaEntradaViewController = ViewControlersFactory.getSingleton().getSalidaEntradaViewController();
            SalidaEntradaViewController.setMovinvenType(MovinvenType.SALIDA);
            SalidaEntradaViewController.setVisible();
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(EntradasSalidasViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(EntradasSalidasViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void btnVerActionPerformed(java.awt.event.ActionEvent evt) {

	try{
            
            //First select an item
            if(!tblEncabezados.isRowSelected()){
                DialogsFactory.getSingleton().showErrorOKNoSelectionCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                    tblEncabezados.grabFocus();
                });
                return;
            }
            
            //Get selected object
            final IngresosEncab IngresosEncab = (IngresosEncab)tblEncabezados.getRowSelected();
            
            //Open the screen to view
            final SalidaEntradaViewController SalidaEntradaViewController = ViewControlersFactory.getSingleton().getSalidaEntradaViewController();
            SalidaEntradaViewController.view(IngresosEncab);
            SalidaEntradaViewController.setVisible();
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(EntradasSalidasViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(EntradasSalidasViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void btnGenerarPdfActionPerformed(java.awt.event.ActionEvent evt) {

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(EntradasSalidasViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(EntradasSalidasViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void btnVerPdfActionPerformed(java.awt.event.ActionEvent evt) {

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(EntradasSalidasViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(EntradasSalidasViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void btnMostrarActionPerformed(java.awt.event.ActionEvent evt) {

	try{            	
            this.tblEncabezados.loadAllItemsInTable();
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(EntradasSalidasViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(EntradasSalidasViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {

	try{            	
            
            //Get the value to search
            final String search = btnBuscar.getText().trim();
            
            //If nothing to search so return
            if(search.isEmpty()){
                return;
            }
            
            //Search all the ocurrences
            this.tblEncabezados.getByLikeEncabezados(search);
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(EntradasSalidasViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(EntradasSalidasViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    @Override
    public List<?> getItemsToLoadInTable() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
