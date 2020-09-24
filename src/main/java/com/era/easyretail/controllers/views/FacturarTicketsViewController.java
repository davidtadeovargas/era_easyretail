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
import com.era.models.BasDats;
import com.era.models.CCodigopostal;
import com.era.models.Company;
import com.era.models.MetogoPago;
import com.era.models.Sales;
import com.era.models.Serie;
import com.era.repositories.RepositoryFactory;
import com.era.utilities.UtilitiesFactory;
import com.era.views.comboboxes.SeriesCombobox;
import com.era.views.dialogs.DialogsFactory;
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
            
            jComMetodoPago.setChangeSelectionListener((Object ObjectModel) -> {
                
                final MetogoPago MetogoPago = (MetogoPago)ObjectModel;
                
                formaPagoDescrip.setText(MetogoPago.getDescription());
            });
            jComMetodoPago.loadItems();
            
            //Init caducity date to today
            jDayChooserFrom.setCalendar(UtilitiesFactory.getSingleton().getDateTimeUtility().getCurrentDateInCalendar());
            jDayChooserUntil.setCalendar(UtilitiesFactory.getSingleton().getDateTimeUtility().getCurrentDateInCalendar());
            
            //Load the company CP by default
            final BasDats BasDats = UtilitiesFactory.getSingleton().getSessionUtility().getBasDats();
            txtLugarExp.setText(BasDats.getCP());
            final CCodigopostal CCodigopostal = RepositoryFactory.getInstance().getCCodigoPostalRepository().getByPostalCode(BasDats.getCP());
            lugarExpedicionDescrip.setText(CCodigopostal.getEstate());
            
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
            if(Serie.getSer()==null ||Serie.getSer().isEmpty()){
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
            
            //Get the expedition place
            final String expeditionPlace = txtLugarExp.getText().trim();
            
            //If expedition place is empty stop
            if(expeditionPlace.isEmpty()){
                DialogsFactory.getSingleton().showOKEmptyFieldCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                    txtLugarExp.grabFocus();
                });
                return;
            }
                        
            //Validate that the expedition place exists
            final boolean exists = RepositoryFactory.getInstance().getCCodigoPostalRepository().existsExpeditionPlace(expeditionPlace);
            if(!exists){
                DialogsFactory.getSingleton().showErrorOKCallbackDialog(baseJFrame, "errors_expedition_place_not_exists", (JFrame jFrame) -> {
                    txtLugarExp.grabFocus();
                });
                return;
            }
            
            //If nothing to process
            if(sales.isEmpty()){
                DialogsFactory.getSingleton().showErrorCeroItemsOKDialog(baseJFrame, (JFrame jFrame) -> {
                    jTableSales.grabFocus();
                });
                return;
            }
            
            //Get the company
             final Company Company = RepositoryFactory.getInstance().getCompanysRepository().getCustomerByCode(customerCode);
                    
            //Is the customer is not mostrador
            if(!Company.isCashCustomer()){

                //The customer need to have all the fiscal data
                if(     Company.getCalle().isEmpty() || 
                        Company.getCol().isEmpty() || 
                        Company.getCP().isEmpty() || 
                        Company.getNoext().isEmpty() || 
                        Company.getRFC().isEmpty() || 
                        Company.getCiu().isEmpty() || 
                        Company.getEstad().isEmpty()){
                    UtilitiesFactory.getSingleton().getGenericExceptionUtil().generateException("errors_missing_fiscal_info");
                    return;
                }
            }
            
            DialogsFactory.getSingleton().showQuestionContinueDialog(baseJFrame, (JFrame jFrame) -> {
                
                try {
                                       
                    //Get observations
                    final String observations = jTxtArObservaciones.getText().trim();
                    
                    //Update the sales
                    RepositoryFactory.getInstance().getSalessRepository().ringTicketSales(Company, sales, observations,Serie.getSer(),MetogoPago.getCode());
                    
                    //Ring the document
                    
                    //Success
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
                
                final String descrip = SearchViewController.getDescrip();
                lugarExpedicionDescrip.setText(descrip);
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
            sales = RepositoryFactory.getInstance().getSalessRepository().getAllTicketsByDatesRangeOnlyNotFactured(customerCode,dateFrom, dateTo);
            
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
