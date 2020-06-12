/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.easyretail.controllers.views;

import com.era.views.Impuestos_X_productos_nuevoJFrame;
import java.util.List;
import com.era.logger.LoggerUtility;
import com.era.models.ImpuesXProduct;
import com.era.models.Tax;
import com.era.views.dialogs.DialogsFactory;
import com.era.views.tables.headers.TableHeaderFactory;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
/**
 *
 * @author PC
 */
public class Impuestos_X_productos_nuevoViewController extends Impuestos_X_productos_nuevoJFrame {
    
    private List<ImpuesXProduct> taxes = new ArrayList<>();
    private String productCode;
    private CloseWindow CloseWindow;
    
    
    
    public Impuestos_X_productos_nuevoViewController() {
        super("window_title_impxproduct");
        
        try{
                     
            jBDel.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBDelActionPerformed(evt);
            });
            jBNew.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBNewActionPerformed(evt);
            });
            jBSal.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBSalActionPerformed(evt);
            });            
            
            this.disposeButton(jBSal);
            
            //Init the table with the items
            this.jTab.addShowColumn(TableHeaderFactory.getSigleton().getImpuesXProductsTableHeader().getROWNUMBER());
            this.jTab.addShowColumn(TableHeaderFactory.getSigleton().getImpuesXProductsTableHeader().getPRODU());
            this.jTab.addShowColumn(TableHeaderFactory.getSigleton().getImpuesXProductsTableHeader().getIMPUE());
            this.jTab.addShowColumn(TableHeaderFactory.getSigleton().getImpuesXProductsTableHeader().getVALUE());
            this.jTab.initTable(taxes);
            
            //Load the taxes combobox
            this.jComImp.loadItems();
            
        }catch (Exception ex) {
            LoggerUtility.getSingleton().logError(Impuestos_X_productos_nuevoViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(Impuestos_X_productos_nuevoViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }
        
    @Override
    public void clearFields(){            
    }
    
    @Override
    public void loadModelInFields(Object ObjectModel) throws  Exception {        
    }
    
    public interface CloseWindow {
        public void onClose(List<ImpuesXProduct> taxes);
    }

    public void setCloseWindow(CloseWindow CloseWindow) {
        this.CloseWindow = CloseWindow;
    }        
    
    private void jBSalActionPerformed(java.awt.event.ActionEvent evt) {
        
        try{
            
            //Get all the taxes from the table
            final List<ImpuesXProduct> itemsTable = (List<ImpuesXProduct>)this.jTab.getAllItemsInTable();
            
            if(CloseWindow!=null){
                CloseWindow.onClose(itemsTable);
            }
            
            //Close the window
            dispose();
            
        }catch (Exception ex) {
            LoggerUtility.getSingleton().logError(Impuestos_X_productos_nuevoViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(Impuestos_X_productos_nuevoViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBNewActionPerformed(java.awt.event.ActionEvent evt) {

	try{            	
            
            //Get the selected taxe
            final Tax Tax = (Tax)this.jComImp.getSelectedObject();
            
            //First select tax before continue
            if(Tax.getCode().compareTo("")==0){
                DialogsFactory.getSingleton().showErrorOKNoSelectionCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                    jComImp.grabFocus();
                });
                return;
            }
            
            //Create the temporal model
            final ImpuesXProduct ImpuesXProduct = new ImpuesXProduct();
            ImpuesXProduct.setCode(productCode);
            ImpuesXProduct.setImpue(Tax.getCode());
            
            //Chec that the tax is not already in the table
            if(jTab.objectExists(ImpuesXProduct)){
                DialogsFactory.getSingleton().showErrorRecordExistsOKDialog(baseJFrame, (JFrame jFrame) -> {
                    jComImp.grabFocus();
                });
                return;
            }
            
            //Add the tax to the table
            this.jTab.addObject(ImpuesXProduct);
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(Impuestos_X_productos_nuevoViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(Impuestos_X_productos_nuevoViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBDelActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
            //First select item
            if(!this.jTab.isRowSelected()){
                DialogsFactory.getSingleton().showErrorOKNoSelectionCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                    jTab.grabFocus();
                });
                return;
            }
            
            //Get the selected object
            final ImpuesXProduct ImpuesXProduct = (ImpuesXProduct)this.jTab.getRowSelected();
            
            //Delete the selected object
            this.jTab.deleteObject(ImpuesXProduct);
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(Impuestos_X_productos_nuevoViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(Impuestos_X_productos_nuevoViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }

    public void setTaxes(List<ImpuesXProduct> taxes) {
        
        //Load the taxes in the table
        jTab.initTable(taxes);
    }
    
    
    @Override
    public List<?> getItemsToLoadInTable() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
