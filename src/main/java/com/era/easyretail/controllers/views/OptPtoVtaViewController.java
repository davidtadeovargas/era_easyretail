/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.easyretail.controllers.views;

import com.era.views.OptPtoVtaJFrame;
import java.util.List;
import com.era.logger.LoggerUtility;
import com.era.models.Cortszx;
import com.era.repositories.CortszxsRepository;
import com.era.repositories.RepositoryFactory;
import com.era.repositories.SalessRepository;
import com.era.repositories.datamodels.DocumentTypeFilter;
import com.era.views.dialogs.DialogsFactory;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
/**
 *
 * @author PC
 */
public class OptPtoVtaViewController extends OptPtoVtaJFrame {
 
    private boolean returnSalesOnPointOfSales;
    private boolean partialReturnsOfSalesOnPointOfSales;
    
    public OptPtoVtaViewController() {
        super("window_title_optsptovta");
        
        try{
                     
            jBCortZ.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBCortZActionPerformed(evt);
            });
            jBCortX.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBCortXActionPerformed(evt);
            });
            jBImpVtas.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBImpVtasActionPerformed(evt);
            });
            jBCanVtas.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBCanVtasActionPerformed(evt);
            });
            jBVtas.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBVtasActionPerformed(evt);
            });
            jBDevP.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBDevPActionPerformed(evt);
            });
            jBDev.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBDevActionPerformed(evt);
            });
            jBChangeLogin.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBChangeLoginActionPerformed(evt);
            });
            jBRingInvoices.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBRingInvoicesActionPerformed(evt);
            });
            
            alwaysOnTop();
                    
            this.disposeButton(jBSal);
            
        }catch (Exception ex) {
            LoggerUtility.getSingleton().logError(OptPtoVtaViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(OptPtoVtaViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    public void readConfigs(){
        
        try {
            
            //Get configs
            returnSalesOnPointOfSales = RepositoryFactory.getInstance().getConfgralRepository().getReturnSalesOnPointOfSales().getVal()==1;
            partialReturnsOfSalesOnPointOfSales = RepositoryFactory.getInstance().getConfgralRepository().getPartialReturnsOfSalesOnPointOfSales().getVal()==1;
        
        } catch (Exception ex) {
            LoggerUtility.getSingleton().logError(this.getClass(), ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    @Override
    public void clearFields() throws Exception{
    }
    
    @Override
    public void loadModelInFields(Object ObjectModel) throws  Exception {        
    }
    
    private void generateCort(final boolean isCortX) throws Exception {
        
        //If there is not anything for cut stop
        final SalessRepository.CortZXData CortZXData = RepositoryFactory.getInstance().getSalessRepository().getTotalsForCortXZ();
        if(CortZXData.getSales().isEmpty()){
            DialogsFactory.getSingleton().showErrorOKCallbackDialog(baseJFrame, "errors_not_available_cort", (JFrame jFrame) -> {
                this.setAlwaysOnTop(true);
            });
            return;
        }
        
        DialogsFactory.getSingleton().showQuestionContinueDialog(baseJFrame, (JFrame jFrame) -> {
            
            try {
                
                final Cortszx Cortszx = new Cortszx();                
                Cortszx.setTotvtas(CortZXData.getTotalSales());
                Cortszx.setTotingr(CortZXData.getTotal());
                Cortszx.setTotegre(BigDecimal.ZERO);
                Cortszx.setTotcaj(CortZXData.getTotalExistenceMoneyInCasher());
                Cortszx.setVtabruta(CortZXData.getTotal());
                Cortszx.setDescu(CortZXData.getDisccount());
                Cortszx.setDevs(CortZXData.getTotalImportDevs());
                Cortszx.setVtanet(CortZXData.getSubtotal());
                Cortszx.setImpue(CortZXData.getTaxes());
                Cortszx.setVtanetimp(CortZXData.getSubtotal());
                Cortszx.setTotfacs(CortZXData.getTotalImportFactus());
                Cortszx.setTottics(CortZXData.getTotalImportTickets());
                Cortszx.setCantfac(CortZXData.getTotalFactus());
                Cortszx.setCanttics(CortZXData.getTotalTickets());
                Cortszx.setTotefe(CortZXData.getTotalCashPayment());
                Cortszx.setTotdeb(CortZXData.getTotalCardDebitPayment());
                Cortszx.setTottarcred(CortZXData.getTotalCardCreditPayment());
                Cortszx.setTotdep(BigDecimal.ZERO);
                
                //Get the next cort
                BigInteger consec;
                if(isCortX){
                    
                    consec = RepositoryFactory.getInstance().getCortszxsRepository().getNextCorteXZ(CortszxsRepository.Type.X);
                    
                    //Update the next cort
                    RepositoryFactory.getInstance().getCortszxsRepository().updateNextCortX(Cortszx);
                }
                else{
                    consec = RepositoryFactory.getInstance().getCortszxsRepository().getNextCorteXZ(CortszxsRepository.Type.Z);

                    //Update the next cort
                    RepositoryFactory.getInstance().getCortszxsRepository().updateNextCortZ(Cortszx);
                    
                    //Update all the corts as no more available corts
                    RepositoryFactory.getInstance().getCortszxsRepository().updateAllAvailableCortsAsZNotAvailableAnyMore();
                }

                //Meanwhile console logs
                final String temp = "Cort number: " + consec +
                                    "Total sales: " + CortZXData.getSales() +
                                    "---------------------" +
                                    "Subtotal: " + CortZXData.getSubtotal() +
                                    "Disccount: " + CortZXData.getDisccount() +
                                    "Taxes: " + CortZXData.getTaxes() +                                            
                                    "Total: " + CortZXData.getTotal() +
                                    "---------------------" +
                                    "Cash payment total: " + CortZXData.getTotalCashPayment() +
                                    "Card debit payment total: " + CortZXData.getTotalCardDebitPayment() +
                                    "Card credit payment total: " + CortZXData.getTotalCardCreditPayment() +
                                    "---------------------" +
                                    "Total money with casher: " + CortZXData.getTotalExistenceMoneyInCasher() +
                                    "---------------------" +
                                    "Total import tickets: " + CortZXData.getTotalImportTickets() +
                                    "Total import invoices: " + CortZXData.getTotalImportFactus() +
                                    "Total import remisions: " + CortZXData.getTotalImportRems() +
                                    "---------------------" +
                                    "Total amount tickets: " + CortZXData.getTotalTickets() +
                                    "Total amount invoices: " + CortZXData.getTotalSales() +
                                    "Total amount remisions: " + CortZXData.getTotalRems() +
                                    "Total amount devs: " + CortZXData.getTotalSalesDevs();
                System.out.println(temp);
                
                dispose();
                
                DialogsFactory.getSingleton().showOKOperationCompletedCallbackDialog(jFrame, (JFrame jFrame1) -> {
                    
                    if(isCortX){

                    }
                    else{ //Corte Z

                        final LoginOtraViewController LoginOtraViewController = ViewControlersFactory.getSingleton().getLoginOtraViewController();
                        LoginOtraViewController.setOnResult(new LoginOtraViewController.OnResult(){

                            @Override
                            public void onCorrectLogin() {

                                try {

                                    //Ask for the money for the box
                                    ViewControlersFactory.getSingleton().getIngreCajViewController().setVisible();

                                } catch (Exception ex) {
                                    LoggerUtility.getSingleton().logError(this.getClass(), ex);
                                    try {
                                        DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
                                    } catch (Exception ex1) {
                                        Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex1);
                                    }
                                }
                            }

                            @Override
                            public void onInvalidLogin() {
                            }

                        });
                        LoginOtraViewController.setVisible();
                    }
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
        
    private void jBRingInvoicesActionPerformed(java.awt.event.ActionEvent evt) {
        
        try {
            
            dispose();
            
            ViewControlersFactory.getSingleton().getInvoicesNotRingedViewController().setVisible();
            
        } catch (Exception ex) {
            LoggerUtility.getSingleton().logError(this.getClass(), ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    private void jBCortZActionPerformed(java.awt.event.ActionEvent evt) {

	try{            	
            
            generateCort(false);
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
    
    
    private void jBCortXActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
            generateCort(true);
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
    
    private void jBImpVtasActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{
            
            dispose();
            
            final ImprVtasViewController ImprVtasViewController = ViewControlersFactory.getSingleton().getImprVtasViewController();
            ImprVtasViewController.setDocumentTypeFilter(DocumentTypeFilter.ALL_SALES);
            ImprVtasViewController.setVisible();
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
    
    private void jBCanVtasActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{
            
            dispose();
            
            final CanVtasViewController CanVtasViewController = ViewControlersFactory.getSingleton().getCanVtasViewController();
            CanVtasViewController.setDocumentTypeFilter(DocumentTypeFilter.ALL_SALES_CO);
            CanVtasViewController.setVisible();
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
    
    private void jBVtasActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{
            
            dispose();
            
            final VVtasViewController VVtasViewController = ViewControlersFactory.getSingleton().getVVtasViewController();
            VVtasViewController.setDocumentTypeFilter(DocumentTypeFilter.ALL_SALES);
            VVtasViewController.setVisible();
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
    
    private void jBDevPActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
            //If the config is not permitted stop
            if(!partialReturnsOfSalesOnPointOfSales){
                DialogsFactory.getSingleton().showErrorStopByConfigOKDialog(baseJFrame, null);
                return;
            }
            
            dispose();
            
            //Open the window
            final DevPVtaPtoViewController DevPVtaPtoViewController = ViewControlersFactory.getSingleton().getDevPVtaPtoViewController();
            DevPVtaPtoViewController.setDocumentTypeFilter(DocumentTypeFilter.ALL_SALES_CO_DEVP);
            DevPVtaPtoViewController.setVisible();
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
    
    private void jBChangeLoginActionPerformed(java.awt.event.ActionEvent evt) {
        
        try {
            
            //Close window
            dispose();
            
            final LoginOtraViewController LoginOtraViewController = ViewControlersFactory.getSingleton().getLoginOtraViewController();
            LoginOtraViewController.setOnResult(new LoginOtraViewController.OnResult(){

                @Override
                public void onCorrectLogin() {
                    
                    try {
                     
                        //Get if any pending zorte z
                        final SalessRepository.CortZXData CortZXData = RepositoryFactory.getInstance().getSalessRepository().getTotalsForCortXZ();
                        if(!CortZXData.getSales().isEmpty()){
                            DialogsFactory.getSingleton().showErrorOKCallbackDialog(baseJFrame, "cort_pending_to_make_dont_forget", (JFrame jFrame) -> {
                            });
                        }
                        
                    } catch (Exception ex) {
                        LoggerUtility.getSingleton().logError(this.getClass(), ex);
                        try {
                            DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
                        } catch (Exception ex1) {
                            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex1);
                        }
                    }
                }

                @Override
                public void onInvalidLogin() {
                    
                }
                
            });
            LoginOtraViewController.setVisible();
            
        } catch (Exception ex) {
            LoggerUtility.getSingleton().logError(this.getClass(), ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    private void jBDevActionPerformed(java.awt.event.ActionEvent evt) {

	try{            	
    
            //If the config is not permitted stop
            if(!returnSalesOnPointOfSales){
                DialogsFactory.getSingleton().showErrorStopByConfigOKDialog(baseJFrame, null);
                return;
            }
            
            dispose();
            
            //Open the window
            final DevVtaPtoViewController DevVtaPtoViewController = ViewControlersFactory.getSingleton().getDevVtaPtoViewController();
            DevVtaPtoViewController.setDocumentTypeFilter(DocumentTypeFilter.ALL_SALES_CO);
            DevVtaPtoViewController.setVisible();
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
