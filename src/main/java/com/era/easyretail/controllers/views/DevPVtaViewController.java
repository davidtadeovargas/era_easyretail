/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.easyretail.controllers.views;

import com.era.logger.LoggerUtility;
import com.era.models.Company;
import com.era.models.Partvta;
import com.era.models.Sales;
import com.era.repositories.RepositoryFactory;
import com.era.utilities.UtilitiesFactory;
import com.era.views.DevPVtaJFrame;
import com.era.views.dialogs.DialogsFactory;
import com.era.views.tables.headers.TableHeaderFactory;
import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author PC
 */
public class DevPVtaViewController extends DevPVtaJFrame {

    private Sales Sale;
    
    public DevPVtaViewController(){
        super("window_title_devptovta");
        
        try{
            
            jBSal.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBSalActionPerformed(evt);
            });
            jBGuar.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBGuarActionPerformed(evt);
            });            
            
            this.JComponentUtils.moneyFormat(jTSubTot);
            this.JComponentUtils.moneyFormat(jTImp);
            this.JComponentUtils.moneyFormat(jTTot);
            
            //Config partvta table
            jTab.addShowColumn(TableHeaderFactory.getSigleton().getPartvtasTableHeader().getROWNUMBER());
            jTab.addShowColumn(TableHeaderFactory.getSigleton().getPartvtasTableHeader().getCANT());
            jTab.addShowColumn(TableHeaderFactory.getSigleton().getPartvtasTableHeader().getCANT_DEV_ORI());
            jTab.addShowColumn(TableHeaderFactory.getSigleton().getPartvtasTableHeader().getCANT_DEV());
            jTab.addShowColumn(TableHeaderFactory.getSigleton().getPartvtasTableHeader().getPROD());
            jTab.addShowColumn(TableHeaderFactory.getSigleton().getPartvtasTableHeader().getALMA());
            jTab.addShowColumn(TableHeaderFactory.getSigleton().getPartvtasTableHeader().getDESCRIP());
            jTab.addShowColumn(TableHeaderFactory.getSigleton().getPartvtasTableHeader().getDESCU());
            jTab.addShowColumn(TableHeaderFactory.getSigleton().getPartvtasTableHeader().getIMPO());
            jTab.addShowColumn(TableHeaderFactory.getSigleton().getPartvtasTableHeader().getIMPUE());
            jTab.addShowColumn(TableHeaderFactory.getSigleton().getPartvtasTableHeader().getLIST());
            
            jTab.addEditableColumn(TableHeaderFactory.getSigleton().getPartvtasTableHeader().getCANT_DEV().getValue());
            
        }catch (Exception ex) {
            LoggerUtility.getSingleton().logError(DevPVtaViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(DevPVtaViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    @Override
    public void clearFields() throws Exception{            
    }
    
    @Override
    public void loadModelInFields(Object ObjectModel) throws  Exception {
        
        //Cast the model
        final Sales Sale_ = (Sales)ObjectModel;
        
        //Get the customer 
        final Company Company = (Company)RepositoryFactory.getInstance().getCompanysRepository().getCustomerByCode(Sale_.getCompanyCode());
        
        //Create document type
        String typeDocument = "Indefinido (error)";
        if(Sale_.isInvoiceDocument()){
            typeDocument = "Factura";
        }
        else if(Sale_.isRemDocument()){
            typeDocument = "Remisión";
        }
        else if(Sale_.isTicketDocument()){
            typeDocument = "Ticket";
        }
        
        jTCli.setText(Sale_.getCompanyCode());
        jTNomEmp.setText(Company.getNom());
        jTNoDoc.setText(Sale_.getReference());
        jTFec.setText(Sale_.getEmisionDate().toString());
        jTVta.setText(String.valueOf(Sale_.getId()));
        jTNoSer.setText(Sale_.getSerie());
        jTTipDoc.setText(typeDocument);
        jTEst.setText(Sale_.getEstac());        
                
        jTSubTot.setText(UtilitiesFactory.getSingleton().getNumbersUtility().toMoneyFormat(String.valueOf(Sale_.getSubtotal())));
        jTImp.setText(UtilitiesFactory.getSingleton().getNumbersUtility().toMoneyFormat(String.valueOf(Sale_.getTax())));
        jTTot.setText(UtilitiesFactory.getSingleton().getNumbersUtility().toMoneyFormat(String.valueOf(Sale_.getTotal())));
        
        //Load the parts
        final List<Partvta> items = RepositoryFactory.getInstance().getPartvtaRepository().getPartsVta(Sale_.getId());
        jTab.initTable(items);
    }
    
    public void setSale(final Sales Sale) throws Exception {
        
        this.Sale = Sale;
        
        loadModelInFields(Sale);
    }
    
    private void jBGuarActionPerformed(java.awt.event.ActionEvent evt) {

	try{            	
    
            //With no reason stop
            final String razon = jTMot.getText().trim();
            if(razon.isEmpty()){
                DialogsFactory.getSingleton().showOKEmptyFieldCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                    jTMot.grabFocus();
                });
                return;
            }
            
            boolean stop = false;
            
            //Loop all rows to check if any amount is invalid
            final List<Partvta> partvtas = (List<Partvta>)jTab.getAllItemsInTable();
            int row = 0;
            for(Partvta Partvta_:partvtas){
                                                
                final BigDecimal cant = Partvta_.getCant();
                final BigDecimal devs = Partvta_.getDevs();
                final BigDecimal availableDevs = cant.subtract(devs);
                
                final int columnIndex = jTab.getColumnIndex(TableHeaderFactory.getSigleton().getPartvtasTableHeader().getCANT_DEV().getValue());
                
                final BigDecimal wantsToDev = new BigDecimal((String)jTab.getValueAt(row, columnIndex));
                
                //If is greater than
                if(wantsToDev.compareTo(availableDevs)==1){
                    stop = true;
                    break;
                }
                
                Partvta_.setToDevs(wantsToDev);
            }
            
            //If any error with de amount of devolutions
            if(stop){
                DialogsFactory.getSingleton().showErrorOKCallbackDialog(baseJFrame, "errors_in_devs_invalid_amount", (JFrame jFrame) -> {
                    jTab.grabFocus();
                });
                return;
            }
            
            DialogsFactory.getSingleton().showQuestionContinueDialog(baseJFrame, (JFrame jFrame) -> {
                
                try {
                    
                    //Return the sale
                    RepositoryFactory.getInstance().getSalessRepository().returnPartialSale(Sale.getId(), razon,partvtas);

                    //Success
                    DialogsFactory.getSingleton().showOKOperationCompletedCallbackDialog(baseJFrame, (JFrame jFrame1) -> {
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
            LoggerUtility.getSingleton().logError(ActivosViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(ActivosViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBSalActionPerformed(java.awt.event.ActionEvent evt) {

	try{            	
            DialogsFactory.getSingleton().showQuestionContinueDialog(baseJFrame, (JFrame jFrame) -> {
                
                try {
                    dispose();
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
            LoggerUtility.getSingleton().logError(ActivosViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(ActivosViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    @Override
    public List<?> getItemsToLoadInTable() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
