/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.easyretail.controllers.views;

import com.era.datamodels.enums.SearchCommonTypeEnum;
import com.era.logger.LoggerUtility;
import com.era.models.Kits;
import com.era.models.Product;
import com.era.repositories.RepositoryFactory;
import com.era.views.CompsJFrame;
import com.era.views.dialogs.DialogsFactory;
import com.era.views.tables.headers.TableHeaderFactory;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author PC
 */
public class CompsViewController extends CompsJFrame {
    
    private List<Kits> kits;
    private String kitCode;
    private OnResult OnResult;
    
    public CompsViewController() {
        super("window_title_comps");
        
        try{
            
            jBNew.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBNewActionPerformed(evt);
            });
            jBBusc1.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBBusc1ActionPerformed(evt);
            });
            jBDel.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBDelActionPerformed(evt);
            });
            jBSal.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBSalActionPerformed(evt);
            });
            buttonAcept.addActionListener((java.awt.event.ActionEvent evt) -> {
                buttonAceptActionPerformed(evt);
            });
            
            this.JComponentUtils.onlyDecimals(jTCant);
            
            this.BaseJTable = jTab;
            this.jTab.addShowColumn(TableHeaderFactory.getSigleton().getKitssTableHeader().getROWNUMBER());
            this.jTab.addShowColumn(TableHeaderFactory.getSigleton().getKitssTableHeader().getCODE());
            this.jTab.addShowColumn(TableHeaderFactory.getSigleton().getKitssTableHeader().getPROD());
            this.jTab.addShowColumn(TableHeaderFactory.getSigleton().getKitssTableHeader().getCANT());
            this.jTab.addShowColumn(TableHeaderFactory.getSigleton().getKitssTableHeader().getPRODUCT_DESCRIPT());
            
        }catch (Exception ex) {
            LoggerUtility.getSingleton().logError(CompsViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(CompsViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }

    public void setOnResult(OnResult OnResult) {
        this.OnResult = OnResult;
    }

    public void initOnlyForView(List<Kits> kits, final String kitCode, final String kitDescription) {
        
        //Init 
        init(kits, kitCode, kitDescription);
        
        //Set all the read componentes
        this.setReadOnly(true);
    }
    
    public void init(List<Kits> kits, final String kitCode, final String kitDescription) {
        
        //Save globally
        this.kits = kits;
        this.kitCode = kitCode;
        
        jTKit.setText(kitCode);
        jTDescripKit.setText(kitDescription);
        
        //Load in the table
        jTab.initTable(this.kits);
    }
        
    
    @Override
    public void loadModelInFields(Object ObjectModel) throws  Exception {        
    }
    
    @Override
    public void clearFields() throws Exception{            
    }
    
    private void jBNewActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
            //Get the kit code
            final String productCode = jTProd.getText().trim();
            
            //If empty stop
            if(productCode.isEmpty()){
                DialogsFactory.getSingleton().showErrorOKNoSelectionCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                    jTProd.grabFocus();
                });
               return; 
            }
            
            //Get the product
            final Product Product = (Product)RepositoryFactory.getInstance().getProductsRepository().getByCode(productCode);
            
            //If the product not exists stop
            if(Product==null){
                DialogsFactory.getSingleton().showErrorRecordNotExistsOKDialog(baseJFrame, (JFrame jFrame) -> {
                    jTProd.grabFocus();
                });
                return;
            }
            
            //Get the quantity
            final double qty = Double.valueOf(jTCant.getText().trim());
            
            //Create model
            final Kits Kits = new Kits();
            Kits.setCode(kitCode);
            Kits.setProd(productCode);
            Kits.setCant((float)qty);
    
            //If exists stop
            if(jTab.objectExists(Kits)){
                DialogsFactory.getSingleton().showErrorRecordExistsOKDialog(baseJFrame, (JFrame jFrame) -> {
                });
                return;
            }
            
            //Add it to the table
            jTab.addObject(Kits);
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(CompsViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(CompsViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBBusc1ActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
            //Search warehouse
            final SearchViewController SearchViewController = new SearchViewController();
            SearchViewController.setSEARCH_TYPE(SearchCommonTypeEnum.PRODUCTS);
            SearchViewController.setButtonAceptClicked(() -> {

                final String productCode = SearchViewController.getCod();
                jTProd.setText(productCode);
                
                final String description = SearchViewController.getDescrip();
                jTDescrip.setText(description);
            });
            SearchViewController.setVisible();
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(CompsViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(CompsViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBDelActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
            //Select before continue
            if(!jTab.isRowSelected()){
                DialogsFactory.getSingleton().showErrorOKNoSelectionCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                    jTab.grabFocus();
                });
                return;
            }
            
            //Question if continue
            DialogsFactory.getSingleton().showQuestionContinueDialog(baseJFrame, (JFrame jFrame) -> {
                
                try{
                    
                    //Get the selected kit
                    final Kits Kits = (Kits)jTab.getRowSelected();
                    
                    //Delete it from the table
                    jTab.deleteObject(Kits);
                    
                    //Announce the user
                    DialogsFactory.getSingleton().showOKOperationCompletedCallbackDialog(jFrame, (JFrame jFrame1) -> {
                    });
                    
                }catch (Exception ex) {
                    LoggerUtility.getSingleton().logError(CompsViewController.class, ex);
                    try {
                        DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
                    } catch (Exception ex1) {
                        Logger.getLogger(CompsViewController.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                }
                
            });
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(CompsViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(CompsViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
        
    
    private void buttonAceptActionPerformed(java.awt.event.ActionEvent evt) {
        
        try{
            
            //Question if continue
            DialogsFactory.getSingleton().showQuestionContinueDialog(baseJFrame, (JFrame jFrame) -> {
                
                try{
                    
                    //Get all the objects in table
                    final List<?> items = jTab.getAllItemsInTable();
                    
                    //Calback for custome
                    if(OnResult != null){
                        OnResult.onResult(kits);
                    }
                    
                    dispose();
                
                }catch (Exception ex) {
                    LoggerUtility.getSingleton().logError(CompsViewController.class, ex);
                    try {
                        DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
                    } catch (Exception ex1) {
                        Logger.getLogger(CompsViewController.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                }
            });
            
        }catch (Exception ex) {
            LoggerUtility.getSingleton().logError(CompsViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(CompsViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    private void jBSalActionPerformed(java.awt.event.ActionEvent evt) {

	try{            	
         
            //Question if continue
            DialogsFactory.getSingleton().showQuestionContinueDialog(baseJFrame, (JFrame jFrame) -> {
                dispose();
            });
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(CompsViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(CompsViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    @Override
    public List<?> getItemsToLoadInTable() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public interface OnResult{
        public void onResult(List<Kits> kits);
    }
}
