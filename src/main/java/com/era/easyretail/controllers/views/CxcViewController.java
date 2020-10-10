/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.easyretail.controllers.views;

import com.era.datamodels.enums.SearchCommonTypeEnum;
import com.era.views.CxcJFrame;
import java.util.List;
import com.era.logger.LoggerUtility;
import com.era.models.Company;
import com.era.models.Cxc;
import com.era.repositories.RepositoryFactory;
import com.era.repositories.utils.SatusDocuments;
import com.era.utilities.UtilitiesFactory;
import com.era.views.dialogs.DialogsFactory;
import com.era.views.utils.JComponentUtils;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
/**
 *
 * @author PC
 */
public class CxcViewController extends CxcJFrame {
 
    private Company Company_;
            
    public CxcViewController() {
        super("window_title_cxc");
        
        try{
               
            this.disposeButton(jBSal);
            
            this.JComponentUtils.onlyNumbers(jTDia);
            
            jBAbon.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBAbonActionPerformed(evt);
            });
            jBVerA.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBVerAActionPerformed(evt);
            });
            jBCli.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBCliActionPerformed(evt);
            });
            jBVis.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBVisActionPerformed(evt);
            });
            jBSearch.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBSearchActionPerformed(evt);
            });            
                        
            this.JComponentUtils.onCheckboxChangeListener(jCCo, new JComponentUtils.OnCheckboxChange(){

                @Override
                public void onChecked() {
                    
                    jCVen.setSelected(false);
                }

                @Override
                public void onUncheked() {
                }
                
            });
                    
            this.JComponentUtils.onCheckboxChangeListener(jCVen, new JComponentUtils.OnCheckboxChange(){

                @Override
                public void onChecked() {
                    
                    jCPe.setSelected(true);
                    jCCo.setSelected(false);
                }

                @Override
                public void onUncheked() {
                }
                
            });
            
            //Init caducity date to today
            jCalendarFrom.setCalendar(UtilitiesFactory.getSingleton().getDateTimeUtility().getCurrentDateInCalendar());
            jCalendarUntil.setCalendar(UtilitiesFactory.getSingleton().getDateTimeUtility().getCurrentDateInCalendar());
            
            //Init the table 
            jTabCXC.showCommonColumns();
            
        }catch (Exception ex) {
            LoggerUtility.getSingleton().logError(CxcViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(CxcViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    @Override
    public void clearFields() throws Exception{            
    }
    
    @Override
    public void loadModelInFields(Object ObjectModel) throws  Exception {        
    }
            
    private void jBSearchActionPerformed(java.awt.event.ActionEvent evt) {
        
        try {
            
            if(Company_==null){
                DialogsFactory.getSingleton().showOKEmptyFieldCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                    jTCli.grabFocus();
                });
                return;
            }
            
            //Load the cxc records
            loadCustomerPendingPayments();
            
        } catch (Exception ex) {
            LoggerUtility.getSingleton().logError(this.getClass(), ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    private void ActionPerformed(java.awt.event.ActionEvent evt) {

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(CxcViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(CxcViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBLibActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(CxcViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(CxcViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBClasActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(CxcViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(CxcViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBVisActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(CxcViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(CxcViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBCliActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
            //Search warehouse
            final SearchViewController SearchViewController = new SearchViewController();
            SearchViewController.setSEARCH_TYPE(SearchCommonTypeEnum.CUSTOMERS);
            SearchViewController.setButtonAceptClicked(() -> {

                try {
                    
                    final String customerCode = SearchViewController.getCod();
                    jTCli.setText(customerCode);

                    final String customerName = SearchViewController.getDescrip();
                    jTNom.setText(customerName);

                    //Get the company
                    Company_ = RepositoryFactory.getInstance().getCompanysRepository().getCustomerByCode(customerCode);

                    //Get the conditions
                    final String conditions = RepositoryFactory.getInstance().getCompanysRepository().getCustomerConditions(Company_);

                    //Show the customer conditions
                    jTCond.setText(conditions);
                    
                } catch (Exception ex) {
                    LoggerUtility.getSingleton().logError(this.getClass(), ex);
                    try {
                        DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
                    } catch (Exception ex1) {
                        Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex1);
                    }
                }
            });
            SearchViewController.setVisible();
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(CxcViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(CxcViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void loadCustomerPendingPayments() throws Exception {
        
        
        final List<String> estatus = new ArrayList<>();
        if(jCPe.isSelected()){
            estatus.add(SatusDocuments.getSingleton().getPendingEstate());            
        }
        if(jCCo.isSelected()){
            estatus.add(SatusDocuments.getSingleton().getConfirmedEstate());
        }
        
        int days = -1;
        if(jCVen.isSelected()){
            days = Integer.valueOf(jTDia.getText().trim());
        }
        
        //Get from and until dates
        final Date dateFrom = jCalendarFrom.getCalendar().getTime();
        final Date dateTo = jCalendarUntil.getCalendar().getTime();
            
        //Load all the records
        final List<Cxc> items = RepositoryFactory.getInstance().getCxcRepository().getAllPaymentFromCustomerByStatus(Company_.getCompanyCode(), estatus, dateFrom, dateTo, days);
        jTabCXC.initTable(items);
    }
    
    private void jBVerAActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{
            
            //If nothing selected yet
            if(!jTabCXC.isRowSelected()){
                DialogsFactory.getSingleton().showErrorOKNoSelectionCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                    jTabCXC.requestFocus();
                });
                return;
            }
            
            //Get selected row
            final Cxc Cxc = (Cxc)jTabCXC.getRowSelected();
            
            final AbonosViewController AbonosViewController = ViewControlersFactory.getSingleton().getAbonosViewController();
            AbonosViewController.setCxc(Cxc);
            AbonosViewController.setVisible();
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(CxcViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(CxcViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBAbonActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{
            
            //If nothing selected yet
            if(!jTabCXC.isRowSelected()){
                DialogsFactory.getSingleton().showErrorOKNoSelectionCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                    jTabCXC.requestFocus();
                });
                return;
            }
            
            //Get selected row
            final Cxc Cxc = (Cxc)jTabCXC.getRowSelected();
            
            //Determine the pending of payment
            final BigDecimal totalPaid = RepositoryFactory.getInstance().getPaymentsRepository().getTotalPaidForDocument(Cxc.getNoser(),Cxc.getNorefer());
            final BigDecimal pendingToPay = Cxc.getCarg().subtract(totalPaid==null?BigDecimal.ZERO:totalPaid);
            if(pendingToPay.compareTo(BigDecimal.ZERO)==0){
                DialogsFactory.getSingleton().showOKCallbackDialog(baseJFrame, "document_already_paid", (JFrame jFrame) -> { 
                });
                return;
            }
            
            //Open the window to make payments to the sale
            final FormPagoViewController FormPagoViewController = ViewControlersFactory.getSingleton().getFormPagoViewController();
            FormPagoViewController.setCxc(Cxc);
            FormPagoViewController.setVisible();
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(CxcViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(CxcViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    @Override
    public List<?> getItemsToLoadInTable() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
