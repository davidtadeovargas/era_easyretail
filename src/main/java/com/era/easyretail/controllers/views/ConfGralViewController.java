/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.easyretail.controllers.views;

import com.era.datamodels.enums.SearchCommonTypeEnum;
import com.era.views.ConfGralJFrame;
import java.util.List;
import com.era.logger.LoggerUtility;
import com.era.models.Serie;
import com.era.models.Warehouse;
import com.era.repositories.RepositoryFactory;
import com.era.utilities.UtilitiesFactory;
import com.era.views.comboboxes.SeriesCombobox;
import com.era.views.dialogs.DialogsFactory;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
/**
 *
 * @author PC
 */
public class ConfGralViewController extends ConfGralJFrame {
    
    public ConfGralViewController() {
        super("window_title_confgral");
        
        try{
                     
            jBAlma.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBAlmaActionPerformed(evt);
            });
            jBGuar.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBGuarActionPerformed(evt);
            });
            jBMaxMin.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBMaxMinActionPerformed(evt);
            });
            jBNoMaxMin.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBNoMaxMinActionPerformed(evt);
            });
            jBTBajCost.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBTBajCostActionPerformed(evt);
            });
            jBTNoBajCost.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBTNoBajCostActionPerformed(evt);
            });
            
            this.JComponentUtils.moneyFormat(jTMinFac);
            
            this.disposeButton(jBSal);
            
            //Load all configs
            
            //Inventory
            jCTraspasExis.setSelected(RepositoryFactory.getInstance().getConfgralRepository().getTrasnfersOnlyWithExistencies().getVal()==1);
            jCSerRep.setSelected(RepositoryFactory.getInstance().getConfgralRepository().getProductsWithEqualsSerie().getVal()==1);
            jCESExistMov.setSelected(RepositoryFactory.getInstance().getConfgralRepository().getOutputOfInventWithExistences().getVal()==1);
                        
            //Sales
            jCPListCFac.setSelected(RepositoryFactory.getInstance().getConfgralRepository().getApplyPriceListOfCustomersInInvoice().getVal()==1);
            jCMMEFac.setSelected(RepositoryFactory.getInstance().getConfgralRepository().getShowMessageIfNotExistencesInInvoice().getVal()==1);
            jCVendSinExistFac.setSelected(RepositoryFactory.getInstance().getConfgralRepository().getSaleWithoutExistencesInInvoice().getVal()==1);
            jCVendSinExistFac.setSelected(RepositoryFactory.getInstance().getConfgralRepository().getSaleOverlimitCreditInInvoice().getVal()==1);
            jCVendMN.setSelected(RepositoryFactory.getInstance().getConfgralRepository().getSaleJustInNationalCoin().getVal()==1);
            jCCanFacPto.setSelected(RepositoryFactory.getInstance().getConfgralRepository().getCanCancelInvoicesInSalespoint().getVal()==1);
            jTMinFac.setText(UtilitiesFactory.getSingleton().getNumbersUtility().toMoneyFormat(String.valueOf(RepositoryFactory.getInstance().getConfgralRepository().getMinAmmountToInvoice().getNume())));
            jCPLEPvta.setSelected(RepositoryFactory.getInstance().getConfgralRepository().getApplyCustomerPriceInSalespoint().getVal()==1);
            jCMMEPvta.setSelected(RepositoryFactory.getInstance().getConfgralRepository().getShowMessageWithNoExistencesInSalespoint().getVal()==1);
            jCVSinExistPvta.setSelected(RepositoryFactory.getInstance().getConfgralRepository().getSaleWithNoExistencesInSalespoint().getVal()==1);
            jCBarrLatP.setSelected(RepositoryFactory.getInstance().getConfgralRepository().getShowProductsPanelInSalespoint().getVal()==1);
            jCImgLin.setSelected(RepositoryFactory.getInstance().getConfgralRepository().getShowProductsImagesInPanelInSalespoint().getVal()==1);
            jCInitPvta.setSelected(RepositoryFactory.getInstance().getConfgralRepository().getInitSalesPointOnIinitSystem().getVal()==1);
            jCLimCredPVta.setSelected(RepositoryFactory.getInstance().getConfgralRepository().getSaleOverCreditLimitOnPointOfSales().getVal()==1);
            jCEmpsPtoVta.setSelected(RepositoryFactory.getInstance().getConfgralRepository().getNewCustomersOnPointOfSales().getVal()==1);
            jCAdmCan.setSelected(RepositoryFactory.getInstance().getConfgralRepository().getAskForAdminPasswordOnCancelInvoicesOnPointOfSales().getVal()==1);
            jCDevVtaPto.setSelected(RepositoryFactory.getInstance().getConfgralRepository().getReturnSalesOnPointOfSales().getVal()==1);
            jTAlma.setText(RepositoryFactory.getInstance().getConfgralRepository().getWarehouseForSalesOnPointOfSales().getExtr());
            jCDevPVtaPto.setSelected(RepositoryFactory.getInstance().getConfgralRepository().getPartialReturnsOfSalesOnPointOfSales().getVal()==1);
            jCLimCredRem.setSelected(RepositoryFactory.getInstance().getConfgralRepository().getSaleOverLimitCreditInRemisions().getVal()==1);
            jCCanRemPto.setSelected(RepositoryFactory.getInstance().getConfgralRepository().getCanCancelOrReturnRemisionsInPointOfSales().getVal()==1);
            jCCanTicPto.setSelected(RepositoryFactory.getInstance().getConfgralRepository().getCanCancelOrReturnTicketsInPointOfSales().getVal()==1);
                        
            //Prevs
            jBPrevMonNacional.setSelected(RepositoryFactory.getInstance().getConfgralRepository().getOnlyNationalCointInPrevComps().getVal()==1);

            //Cots
            jCMMECot.setSelected(RepositoryFactory.getInstance().getConfgralRepository().getShowMesageWhenNoExistencesInCots().getVal()==1);
            jCVSinExistCot.setSelected(RepositoryFactory.getInstance().getConfgralRepository().getSaleWithoutExistencesInCots().getVal()==1);
            jCCotMN.setSelected(RepositoryFactory.getInstance().getConfgralRepository().getSaleOnlyInNationalCoinInCots().getVal()==1);
            
            //Sist
            jCDesInac.setSelected(RepositoryFactory.getInstance().getConfgralRepository().getSuspendInInactvity().getVal()==1);
            if(RepositoryFactory.getInstance().getConfgralRepository().getDecimals().getNume()==2){
                radio_redondea_2.setSelected(true);
            }
            else if(RepositoryFactory.getInstance().getConfgralRepository().getDecimals().getNume()==3){
                radio_redondea_3.setSelected(true);
            }
            else if(RepositoryFactory.getInstance().getConfgralRepository().getDecimals().getNume()==4){
                radio_redondea_4.setSelected(true);
            }
            else if(RepositoryFactory.getInstance().getConfgralRepository().getDecimals().getNume()==5){
                radio_redondea_5.setSelected(true);
            }
            else if(RepositoryFactory.getInstance().getConfgralRepository().getDecimals().getNume()==6){
                radio_redondea_6.setSelected(true);
            }

            //Comps
            jCCompMN.setSelected(RepositoryFactory.getInstance().getConfgralRepository().getBuyOnlyInNationalCoin().getVal()==1);
                        
            //Load comboboxes
            jComSerR.setType(SeriesCombobox.Type.REM);
            jComSerR.loadItems();
            
            jComSerFac.setType(SeriesCombobox.Type.FAC);
            jComSerFac.loadItems();
            
            jComSerF.setType(SeriesCombobox.Type.FAC);
            jComSerF.loadItems();
            
            jComSerT.setType(SeriesCombobox.Type.TIK);
            jComSerT.loadItems();
            
            Serie Serie = RepositoryFactory.getInstance().getSerieRepository().getBySerie(RepositoryFactory.getInstance().getConfgralRepository().getSerieInvoiceRemain().getExtr());
            jComSerFac.selectByObject(Serie);
            Serie = RepositoryFactory.getInstance().getSerieRepository().getBySerie(RepositoryFactory.getInstance().getConfgralRepository().getSerieInvoiceInPointOfSale().getExtr());
            jComSerF.selectByObject(Serie);
            Serie = RepositoryFactory.getInstance().getSerieRepository().getBySerie(RepositoryFactory.getInstance().getConfgralRepository().getSerieTickInPointOfSale().getExtr());
            jComSerT.selectByObject(Serie);
            Serie = RepositoryFactory.getInstance().getSerieRepository().getBySerie(RepositoryFactory.getInstance().getConfgralRepository().getSerieRemisionsInPointOfSale().getExtr());
            jComSerR.selectByObject(Serie);
            
        }catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ConfGralViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(ConfGralViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    @Override
    public void loadModelInFields(Object ObjectModel) throws  Exception {        
    }
    
    @Override
    public void clearFields() throws Exception{            
    }
    
    private void jBTNoBajCostActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
            DialogsFactory.getSingleton().showQuestionContinueDialog(baseJFrame, (JFrame jFrame) -> {
                
                try {
               
                    //Update all products
                    RepositoryFactory.getInstance().getProductsRepository().updateAllProductsNotSaleUnderCost();

                    //Success
                    DialogsFactory.getSingleton().showOKOperationCompletedCallbackDialog(baseJFrame, (JFrame jFrame1) -> {
                    });
                    
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
            LoggerUtility.getSingleton().logError(ConfGralViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(ConfGralViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBTBajCostActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
            DialogsFactory.getSingleton().showQuestionContinueDialog(baseJFrame, (JFrame jFrame) -> {
                
                try {
                    
                    //Update all products
                    RepositoryFactory.getInstance().getProductsRepository().updateAllProductsSaleUnderCost();
                    
                    //Success
                    DialogsFactory.getSingleton().showOKOperationCompletedCallbackDialog(jFrame, (JFrame jFrame1) -> {
                    });
                    
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
            LoggerUtility.getSingleton().logError(ConfGralViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(ConfGralViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBNoMaxMinActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            DialogsFactory.getSingleton().showQuestionContinueDialog(baseJFrame, (JFrame jFrame) -> {
                
                try {
               
                    //Update all products
                    RepositoryFactory.getInstance().getProductsRepository().updateAllProductsNotSolmaxmin();
                    
                    //Success
                    DialogsFactory.getSingleton().showOKOperationCompletedCallbackDialog(jFrame, (JFrame jFrame1) -> {
                    });
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
            LoggerUtility.getSingleton().logError(ConfGralViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(ConfGralViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBMaxMinActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
            DialogsFactory.getSingleton().showQuestionContinueDialog(baseJFrame, (JFrame jFrame) -> {
                
                try {
                    
                    //Update all products
                    RepositoryFactory.getInstance().getProductsRepository().updateAllProductsSolmaxmin();
                    
                    //Success
                    DialogsFactory.getSingleton().showOKOperationCompletedCallbackDialog(jFrame, (JFrame jFrame1) -> {
                    });
                    
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
            LoggerUtility.getSingleton().logError(ConfGralViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(ConfGralViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBGuarActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
            //Warehouse should not be emtpy
            final String warehouseCode = jTAlma.getText().trim();            
            if(warehouseCode.isEmpty()){
                DialogsFactory.getSingleton().showOKEmptyFieldCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                    jTAlma.grabFocus();
                });
                return;
            }
            
            //If warehouse doesnt exists stop
            final Warehouse Warehouse = (Warehouse)RepositoryFactory.getInstance().getWarehousesRepository().getByCode(warehouseCode);
            if(Warehouse==null){
                DialogsFactory.getSingleton().showErrorOKRecordNotExistsCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                    jTAlma.grabFocus();
                });
                return;
            }
            
            DialogsFactory.getSingleton().showQuestionContinueDialog(baseJFrame, (JFrame jFrame) -> {
                
                try {
                    
                    //Inventory
                    RepositoryFactory.getInstance().getConfgralRepository().setTrasnfersOnlyWithExistencies(jCTraspasExis.isSelected());
                    RepositoryFactory.getInstance().getConfgralRepository().setProductsWithEqualsSerie(jCSerRep.isSelected());
                    RepositoryFactory.getInstance().getConfgralRepository().setOutputOfInventWithExistences(jCESExistMov.isSelected());
                    
                    //Sales
                    RepositoryFactory.getInstance().getConfgralRepository().setApplyPriceListOfCustomersInInvoice(jCPListCFac.isSelected());
                    RepositoryFactory.getInstance().getConfgralRepository().setShowMessageIfNotExistencesInInvoice(jCMMEFac.isSelected());
                    RepositoryFactory.getInstance().getConfgralRepository().setSaleWithoutExistencesInInvoice(jCVendSinExistFac.isSelected());
                    RepositoryFactory.getInstance().getConfgralRepository().setSaleOverlimitCreditInInvoice(jCLimCredFac.isSelected());
                    RepositoryFactory.getInstance().getConfgralRepository().setSaleJustInNationalCoin(jCVendMN.isSelected());
                    RepositoryFactory.getInstance().getConfgralRepository().setCanCancelInvoicesInSalespoint(jCCanFacPto.isSelected());
                    RepositoryFactory.getInstance().getConfgralRepository().setMinAmmountToInvoice(Double.valueOf(UtilitiesFactory.getSingleton().getNumbersUtility().fromMoneyFormat(jTMinFac.getText().trim())));
                    RepositoryFactory.getInstance().getConfgralRepository().setApplyCustomerPriceInSalespoint(jCPLEPvta.isSelected());
                    RepositoryFactory.getInstance().getConfgralRepository().setShowMessageWithNoExistencesInSalespoint(jCMMEPvta.isSelected());
                    RepositoryFactory.getInstance().getConfgralRepository().setSaleWithNoExistencesInSalespoint(jCVSinExistPvta.isSelected());
                    RepositoryFactory.getInstance().getConfgralRepository().setShowProductsPanelInSalespoint(jCBarrLatP.isSelected());
                    RepositoryFactory.getInstance().getConfgralRepository().setShowProductsImagesInPanelInSalespoint(jCImgLin.isSelected());
                    RepositoryFactory.getInstance().getConfgralRepository().setInitSalesPointOnIinitSystem(jCInitPvta.isSelected());
                    RepositoryFactory.getInstance().getConfgralRepository().setSaleOverCreditLimitOnPointOfSales(jCLimCredPVta.isSelected());
                    RepositoryFactory.getInstance().getConfgralRepository().setNewCustomersOnPointOfSales(jCEmpsPtoVta.isSelected());
                    RepositoryFactory.getInstance().getConfgralRepository().setAskForAdminPasswordOnCancelInvoicesOnPointOfSales(jCAdmCan.isSelected());
                    RepositoryFactory.getInstance().getConfgralRepository().setReturnSalesOnPointOfSales(jCDevVtaPto.isSelected());
                    RepositoryFactory.getInstance().getConfgralRepository().setWarehouseForSalesOnPointOfSales(warehouseCode);
                    RepositoryFactory.getInstance().getConfgralRepository().setPartialReturnsOfSalesOnPointOfSales(jCDevPVtaPto.isSelected());
                    RepositoryFactory.getInstance().getConfgralRepository().setSaleOverLimitCreditInRemisions(jCLimCredRem.isSelected());
                    RepositoryFactory.getInstance().getConfgralRepository().setCanCancelOrReturnRemisionsInPointOfSales(jCCanRemPto.isSelected());
                    RepositoryFactory.getInstance().getConfgralRepository().setCanCancelOrReturnTicketsInPointOfSales(jCCanTicPto.isSelected());
                    Serie Serie = (Serie)jComSerFac.getSelectedObject();
                    RepositoryFactory.getInstance().getConfgralRepository().setSerieInvoiceRemain(Serie.getSer());
                    Serie = (Serie)jComSerF.getSelectedObject();
                    RepositoryFactory.getInstance().getConfgralRepository().setSerieInvoiceInPointOfSale(Serie.getSer());
                    Serie = (Serie)jComSerT.getSelectedObject();
                    RepositoryFactory.getInstance().getConfgralRepository().setSerieTickInPointOfSale(Serie.getSer());
                    Serie = (Serie)jComSerR.getSelectedObject();
                    RepositoryFactory.getInstance().getConfgralRepository().setSerieRemisionsInPointOfSale(Serie.getSer());
                    
                    //Prevs
                    RepositoryFactory.getInstance().getConfgralRepository().setOnlyNationalCointInPrevComps(jBPrevMonNacional.isSelected());                    
                    
                    //Cots
                    RepositoryFactory.getInstance().getConfgralRepository().setShowMesageWhenNoExistencesInCots(jCMMECot.isSelected());
                    RepositoryFactory.getInstance().getConfgralRepository().setSaleWithoutExistencesInCots(jCVSinExistCot.isSelected());
                    RepositoryFactory.getInstance().getConfgralRepository().setSaleOnlyInNationalCoinInCots(jCCotMN.isSelected());
                    
                    //Sist
                    RepositoryFactory.getInstance().getConfgralRepository().setSuspendInInactvity(jCDesInac.isSelected());
                    float seleccion = 2f;
                    if(radio_redondea_2.isSelected()){
                        seleccion = 2f;
                    }
                    else if(radio_redondea_3.isSelected()){
                        seleccion = 3f;
                    }
                    else if(radio_redondea_4.isSelected()){
                        seleccion = 4f;
                    }
                    else if(radio_redondea_5.isSelected()){
                        seleccion = 5f;
                    }
                    else if(radio_redondea_6.isSelected()){
                        seleccion = 6f;
                    }
                    RepositoryFactory.getInstance().getConfgralRepository().setDecimals(seleccion);
                    
                    //Comps
                    RepositoryFactory.getInstance().getConfgralRepository().setBuyOnlyInNationalCoin(jCCompMN.isSelected());
                    
                    DialogsFactory.getSingleton().showOKOperationCompletedCallbackDialog(jFrame, (JFrame jFrame1) -> {
                        dispose();
                    });
                    
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
            LoggerUtility.getSingleton().logError(ConfGralViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(ConfGralViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void ActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ConfGralViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(ConfGralViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBAlmaActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
            //Search warehouse
            final SearchViewController SearchViewController = new SearchViewController();
            SearchViewController.setSEARCH_TYPE(SearchCommonTypeEnum.WAREHOUSES);
            SearchViewController.setButtonAceptClicked(() -> {

                final String warehouseCode = SearchViewController.getCod();
                jTAlma.setText(warehouseCode);
            });
            SearchViewController.setVisible();
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ConfGralViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(ConfGralViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
            
    @Override
    public List<?> getItemsToLoadInTable() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
