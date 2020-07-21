/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.easyretail.controllers.views;

import com.era.views.TicketsFacturadosJFrame;
import java.util.List;
import com.era.logger.LoggerUtility;
import com.era.models.Company;
import com.era.models.Sales;
import com.era.repositories.RepositoryFactory;
import com.era.utilities.UtilitiesFactory;
import com.era.views.dialogs.DialogsFactory;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author PC
 */
public class TicketsFacturadosViewController extends TicketsFacturadosJFrame {
    
    public TicketsFacturadosViewController() {
        super("window_title_tiksfactu");
        
        try{
                     
           this.disposeButton(jBSal);
           
           //Load the table columns
           table_tickets.showCommonColumns();
           
        }catch (Exception ex) {
            LoggerUtility.getSingleton().logError(TicketsFacturadosViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(TicketsFacturadosViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    @Override
    public void clearFields() throws Exception{
    }
    
    @Override
    public void loadModelInFields(Object ObjectModel) throws  Exception {        
    }
    
    public void init(final Sales Sale, final List<Sales> sales) throws Exception {
                
        //Get the company
        final Company Company = (Company)RepositoryFactory.getInstance().getCompanysRepository().getCustomerByCode(Sale.getCompanyCode());
        
        //Fill the fields
        txtSerie.setText(Sale.getSerie());
        txtFolio.setText(Sale.getFiscalFolio());
        txtFecha.setText(Sale.getFalt().toString());
        txtTotal.setText(UtilitiesFactory.getSingleton().getNumbersUtility().toMoneyFormat(Sale.getTotal()));
        txtUsuario.setText(Sale.getSalesMan());
        txtCaja.setText(Sale.getNocaj());
        txtSucursal.setText(Sale.getSucu());
        txtCliente.setText(Company.getNom());
                
        table_tickets.initTable(sales);
    }
    
    @Override
    public List<?> getItemsToLoadInTable() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
