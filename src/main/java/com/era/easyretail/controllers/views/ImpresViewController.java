/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.easyretail.controllers.views;

import com.era.datamodels.PrinterDataModel;
import com.era.logger.LoggerUtility;
import com.era.models.User;
import com.era.repositories.RepositoryFactory;
import com.era.utilities.UtilitiesFactory;
import com.era.views.ImpresJFrame;
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
public class ImpresViewController extends ImpresJFrame {
    
    public ImpresViewController() {
        super("window_title_impres");
        
        try{                     

            //Load the printers
            jComImpTick.loadItems();
            jComImpFact.loadItems();

            this.setDefaultButton(jBUpdate);
            
            //Dispose button
            this.disposeButton(jBSal);
            
            //Specify the columnos to show in the table
            this.BaseJTable = this.jTab;
            this.jTab.addShowColumn(TableHeaderFactory.getSigleton().getUsersTableHeader().getROWNUMBER());
            this.jTab.addShowColumn(TableHeaderFactory.getSigleton().getUsersTableHeader().getCODE());
            this.jTab.addShowColumn(TableHeaderFactory.getSigleton().getUsersTableHeader().getTICKETPRINTER());
            this.jTab.addShowColumn(TableHeaderFactory.getSigleton().getUsersTableHeader().getINVOICEPRINTER());
            this.jTab.addShowColumn(TableHeaderFactory.getSigleton().getUsersTableHeader().getM52());
            this.jTab.addShowColumn(TableHeaderFactory.getSigleton().getUsersTableHeader().getCORT());
            this.jTab.setITableRowSelected((ListSelectionEvent lse, Object Object) -> {
                
                //Cast model
                final User User = (User)Object;
                
                //Select
                final String ticketPrinter = User.getTicketPrinter();
                final String invoicePrinter = User.getTicketPrinter();
                
                //Clear selection
                jComImpTick.clearSelection();
                jComImpFact.clearSelection();
                
                //Select the correct item
                jComImpTick.setSelectedItem(ticketPrinter);
                jComImpFact.setSelectedItem(invoicePrinter);
            });
                    
            
            //Load the items in table            
            this.jTab.loadAllItemsInTable();
            
            jBProbTick.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBProbTickActionPerformed(evt);
            });
            jBProbFac.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBProbFacActionPerformed(evt);
            });
            jBUpdate.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBNewActionPerformed(evt);
            });
            jBBusc.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBBuscActionPerformed(evt);
            });
            jBMosT.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBMosTActionPerformed(evt);
            });            
                    
        }catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ImpresViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(ImpresViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    @Override
    public void clearFields(){            
    }
    
    private void jBMosTActionPerformed(java.awt.event.ActionEvent evt) {                                        
        
        try{
                        
            this.jTab.loadAllItemsInTable();
            
        }catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ImpresViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(ImpresViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    private void jBBuscActionPerformed(java.awt.event.ActionEvent evt) {                                        
        
        try{
            
            //Get the value to search
            final String search = jTBusc.getText().trim();
            
            //If nothing to search so return
            if(search.isEmpty()){
                return;
            }
            
            //Get all the items by filter
            this.jTab.getByLikeEncabezados(search);
            
        }catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ImpresViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(ImpresViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    private void jBNewActionPerformed(java.awt.event.ActionEvent evt) {                                        
     
        try{                        
            
            //First need user selection
            if(!jTab.isRowSelected()){
                DialogsFactory.getSingleton().showErrorOKNoSelectionCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                    jTab.grabFocus();
                });
                return;
            }
            
            //Get the user code
            final User User = (User)jTab.getRowSelected();
            
            //Get the ticket printer
            final String selectedTicketPrinter  = jComImpTick.getSelectedItem().toString();

            //Can not be empty
            if(selectedTicketPrinter.isEmpty()){
                DialogsFactory.getSingleton().showOKEmptyFieldCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                    jComImpTick.grabFocus();
                });
                return;
            }
            
            //Get the invoice printer
            final String selectedInvoicePrinter = jComImpFact.getSelectedItem().toString();

            //Can not be empty
            if(selectedTicketPrinter.isEmpty()){
                DialogsFactory.getSingleton().showOKEmptyFieldCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                    jComImpFact.grabFocus();
                });
                return;
            }
            
            //Question if continue
            DialogsFactory.getSingleton().showQuestionContinueDialog(baseJFrame, (JFrame jFrame) -> {
               
                try{
                 
                    //Ticket size
                    final boolean ticket52 = jC52m.isSelected();
                    
                    //Printer with auto cut
                    final boolean printerWithCort = jCCort.isSelected();                    

                    //Update the printer for the user
                    RepositoryFactory.getInstance().getUsersRepository().updatePrinters(User.getCode(), selectedTicketPrinter, selectedInvoicePrinter, ticket52, printerWithCort);
                    
                    //Reload the table
                    jTab.reloadTable();

                    DialogsFactory.getSingleton().showOKOperationCompletedCallbackDialog(jFrame, (JFrame jFrame1) -> {
                    });
                    
                }catch (Exception ex) {
                    LoggerUtility.getSingleton().logError(ImpresViewController.class, ex);
                    try {
                        DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
                    } catch (Exception ex1) {
                        Logger.getLogger(ImpresViewController.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                }
            });

        }catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ImpresViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(ImpresViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    private void testPrinter(final String printerName) throws Exception {
        
        //Get default current printer
        final String currentPrinter = UtilitiesFactory.getSingleton().getPrintersUtility().getDefaultPrinter();

        //Change the default printer
        UtilitiesFactory.getSingleton().getPrintersUtility().changeDefaultPrinter(printerName);

        //Print the report
        /*                
            JasperReport    jas;
            try
            {
                jas = JasperCompileManager.compileReport(getClass().getResourceAsStream("/jasreport/rptPrue.jrxml"));               
            }
            catch(JRException expnJASR)
            {    
                //Procesa el error y regresa
                Star.iErrProc(this.getClass().getName() + " " + expnJASR.getMessage(), Star.sErrJASR, expnJASR.getStackTrace(), con);                                                       
                return;                                                                
            }            

            JasperPrint pri;
            try
            {
                pri = JasperFillManager.fillReport(jas, null, con);            
            }
            catch(JRException expnJASR)
            {
                //Procesa el error y regresa
                Star.iErrProc(this.getClass().getName() + " " + expnJASR.getMessage(), Star.sErrJASR, expnJASR.getStackTrace(), con);                                                       
                return;                                                                
            }
        */

        //Restore the default printer
        UtilitiesFactory.getSingleton().getPrintersUtility().changeDefaultPrinter(currentPrinter);
    }
    
    private void jBProbTickActionPerformed(java.awt.event.ActionEvent evt) {                                        
        
        try{
        
            //Get ticket printer
            final PrinterDataModel PrinterDataModel = (PrinterDataModel)jComImpTick.getSelectedObject();
            
            //Can not be empty
            if(PrinterDataModel.getName().isEmpty()){
                DialogsFactory.getSingleton().showOKEmptyFieldCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                    jComImpTick.grabFocus();
                });
                return;
            }
                    
            testPrinter(PrinterDataModel.getName());

        }catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ImpresViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(ImpresViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    private void jBProbFacActionPerformed(java.awt.event.ActionEvent evt) {                                        
        
        try{
            
            //Get invoice printer
            final PrinterDataModel PrinterDataModel = (PrinterDataModel)jComImpFact.getSelectedObject();
                                
            //Can not be empty
            if(PrinterDataModel.getName().isEmpty()){
                DialogsFactory.getSingleton().showOKEmptyFieldCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                    jComImpFact.grabFocus();
                });
                return;
            }
            
            testPrinter(PrinterDataModel.getName());
            
        }catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ImpresViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(ImpresViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    @Override
    public List<?> getItemsToLoadInTable() throws Exception {
        final List<User> users = (List<User>) RepositoryFactory.getInstance().getUsersRepository().getAll();
        return users;
    }
}
