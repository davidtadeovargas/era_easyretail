/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.easyretail.controllers.views;

import com.era.datamodels.enums.SearchCommonTypeEnum;
import com.era.views.FacturarTicketsJFrame;
import java.util.List;
import com.era.logger.LoggerUtility;
import com.era.models.Company;
import com.era.models.MetogoPago;
import com.era.models.Sales;
import com.era.models.Serie;
import com.era.repositories.RepositoryFactory;
import com.era.utilities.UtilitiesFactory;
import com.era.views.comboboxes.SeriesCombobox;
import com.era.views.dialogs.DialogsFactory;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
/**
 *
 * @author PC
 */
public class FacturarTicketsViewController extends FacturarTicketsJFrame {
    
    private String customerCode;
    private List<Sales> sales = new ArrayList<>();
    
    public FacturarTicketsViewController() {
        super("window_title_factiks");
        
        try{
                     
            jBtnCliente.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBtnClienteActionPerformed(evt);
            });
            btnBuscar.addActionListener((java.awt.event.ActionEvent evt) -> {
                btnBuscarActionPerformed(evt);
            });
            btnLugExp.addActionListener((java.awt.event.ActionEvent evt) -> {
                btnLugExpActionPerformed(evt);
            });
            jBtnFacturar.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBtnFacturarActionPerformed(evt);
            });
            
            //Show the columns
            jTableSales.showCommonColumns();
            
            //Load all the combos items
            jComSerie.setType(SeriesCombobox.Type.FAC);
            jComSerie.loadItems();
            jComMetodoPago.loadItems();
            
            //Init caducity date to today
            jDayChooserFrom.setCalendar(UtilitiesFactory.getSingleton().getDateTimeUtility().getCurrentDateInCalendar());
            jDayChooserUntil.setCalendar(UtilitiesFactory.getSingleton().getDateTimeUtility().getCurrentDateInCalendar());
            
        }catch (Exception ex) {
            LoggerUtility.getSingleton().logError(FacturarTicketsViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(FacturarTicketsViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    @Override
    public void clearFields() throws Exception{            
    }
    
    @Override
    public void loadModelInFields(Object ObjectModel) throws  Exception {        
    }
    
    private void jBtnFacturarActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
    
            //If no customer selected
            if(customerCode==null){
                DialogsFactory.getSingleton().showOKEmptyFieldCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                    jTxtNomCliente.grabFocus();
                });
                return;
            }
            
            //Get the serie
            final Serie Serie = (Serie)jComSerie.getSelectedObject();
                    
            //If serie is not selected            
            if(Serie.getSer().isEmpty()){
                DialogsFactory.getSingleton().showErrorOKNoSelectionCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                    jComSerie.grabFocus();
                });
                return;
            }
            
            //Get the payment method
            final MetogoPago MetogoPago = (MetogoPago)jComMetodoPago.getSelectedObject();
                    
            //If payment method is not selected
            if(MetogoPago.getCode().isEmpty()){
                DialogsFactory.getSingleton().showErrorOKNoSelectionCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                    jComMetodoPago.grabFocus();
                });
                return;
            }
            
            //If expedition place is not present
            final String expeditionPlace = txtLugarExp.getText().trim();
            if(expeditionPlace.isEmpty()){
                DialogsFactory.getSingleton().showOKEmptyFieldCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                    txtLugarExp.grabFocus();
                });
                return;
            }
            
            //If expedition place doesnt exist
            /*final boolean exists = RepositoryFactory.getInstance().getCCodigoPostalRepository().existsExpeditionPlace(expeditionPlace);
            if(!exists){
                DialogsFactory.getSingleton().showErrorOKRecordNotExistsCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                    txtLugarExp.grabFocus();
                });
                return;
            }*/
            
            //If nothing to process
            if(sales.isEmpty()){
                DialogsFactory.getSingleton().showErrorCeroItemsOKDialog(baseJFrame, (JFrame jFrame) -> {
                    jTableSales.grabFocus();
                });
                return;
            }
            
            DialogsFactory.getSingleton().showQuestionContinueDialog(baseJFrame, (JFrame jFrame) -> {
                
                try {
                                       
                    //Get observations
                    final String observations = jTxtArObservaciones.getText().trim();
                    
                    //Get the company
                    final Company Company = RepositoryFactory.getInstance().getCompanysRepository().getCustomerByCode(customerCode);
                    
                    //Update the sales
                    RepositoryFactory.getInstance().getSalessRepository().ringTicketSales(Company, sales, observations,Serie.getCode(),MetogoPago.getCode());
                    
                    //Ring the document
                    
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
            LoggerUtility.getSingleton().logError(FacturarTicketsViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(FacturarTicketsViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void btnLugExpActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
            final SearchViewController SearchViewController = new SearchViewController();
            SearchViewController.setSEARCH_TYPE(SearchCommonTypeEnum.EXPEDITION_PLACE);
            SearchViewController.setButtonAceptClicked(() -> {
                final String expeditionPlace = SearchViewController.getCod();                
                txtLugarExp.setText(expeditionPlace);
            });
            SearchViewController.setVisible();
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(FacturarTicketsViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(FacturarTicketsViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
            //If no customer selected
            if(customerCode==null){
                DialogsFactory.getSingleton().showOKEmptyFieldCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                    jTxtNomCliente.grabFocus();
                });
                return;
            }
            
            final Date dateFrom = jDayChooserFrom.getCalendar().getTime();
            final Date dateTo = jDayChooserUntil.getCalendar().getTime();
                        
            //If the dates are invalid
            if(dateFrom.compareTo(dateTo)>0){
                DialogsFactory.getSingleton().showErrorOKCallbackDialog(baseJFrame, "", (JFrame jFrame) -> {
                    jDayChooserFrom.grabFocus();
                });
                return;
            }
            
            //Get all the sales 
            sales = RepositoryFactory.getInstance().getSalessRepository().getAllTicketsByDatesRange(customerCode,dateFrom, dateTo);
            
            //Load all the sales
            jTableSales.initTable(sales);                        
            
            //Calculate the total
            BigDecimal total = BigDecimal.ZERO;
            for(Sales Sale:sales){
                total = total.add(Sale.getTotal());
            }
            final String totalString = UtilitiesFactory.getSingleton().getNumbersUtility().toMoneyFormat(String.valueOf(total));
            jLabelTotal.setText(totalString);
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(FacturarTicketsViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(FacturarTicketsViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBtnClienteActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
            final SearchViewController SearchViewController = new SearchViewController();
            SearchViewController.setSEARCH_TYPE(SearchCommonTypeEnum.CUSTOMERS);
            SearchViewController.setButtonAceptClicked(() -> {
                
                customerCode = SearchViewController.getCod();
                
                final String customerName = SearchViewController.getDescrip();
                
                jTxtNomCliente.setText(customerName);
            });
            SearchViewController.setVisible();
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(FacturarTicketsViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(FacturarTicketsViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    @Override
    public List<?> getItemsToLoadInTable() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
