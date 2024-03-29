/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.easyretail.controllers.views;

import com.era.datamodels.PrinterDataModel;
import com.era.easyretail.era_jasperreports.ReportsManager;
import com.era.easyretail.era_jasperreports.TestReportGenerator;
import com.era.easyretail.era_jasperreports.models.GenerateProperties;
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
                
                try {
                 
                    //Cast model
                    final User User = (User)Object;

                    //Get selected printers
                    final String ticketPrinter = User.getTicketPrinter();
                    final String invoicePrinter = User.getInvoicePrinter();

                    //Get objects
                    final PrinterDataModel PrinterDataModelTik = new PrinterDataModel();
                    PrinterDataModelTik.setName(ticketPrinter);
                    final PrinterDataModel PrinterDataModelInvoice = new PrinterDataModel();
                    PrinterDataModelInvoice.setName(invoicePrinter);

                    //Clear selection
                    jComImpTick.clearSelection();
                    jComImpFact.clearSelection();

                    //Select the correct item
                    jComImpTick.selectByObject(PrinterDataModelTik);
                    jComImpFact.selectByObject(PrinterDataModelInvoice);
                    
                    jC52m.setSelected(User.isM52());
                    jCCort.setSelected(User.isCort());
                    
                } catch (Exception ex) {
                    LoggerUtility.getSingleton().logError(this.getClass(), ex);
                    try {
                        DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
                    } catch (Exception ex1) {
                        Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex1);
                    }
                }
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
    public void clearFields() throws Exception{            
    }
    
    @Override
    public void loadModelInFields(Object ObjectModel) throws  Exception {        
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
            final PrinterDataModel PrinterDataModelTick = (PrinterDataModel)jComImpTick.getSelectedObject();
            final String selectedTicketPrinter = PrinterDataModelTick.getName();

            //Can not be empty
            if(selectedTicketPrinter.isEmpty()){
                DialogsFactory.getSingleton().showOKEmptyFieldCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                    jComImpTick.grabFocus();
                });
                return;
            }
            
            //Get the invoice printer
            final PrinterDataModel PrinterDataModelInvoice = (PrinterDataModel)jComImpFact.getSelectedObject();
            final String selectedInvoicePrinter = PrinterDataModelInvoice.getName();

            //Can not be empty
            if(selectedInvoicePrinter.isEmpty()){
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

                    //Update the session model
                    User.setTicketPrinter(selectedTicketPrinter);
                    User.setInvoicePrinter(selectedInvoicePrinter);
                    UtilitiesFactory.getSingleton().getSessionUtility().userInitSession(User);
                    
                    //Reload the table
                    this.jTab.loadAllItemsInTable();

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

        //Create the report properties
        final GenerateProperties GenerateProperties = new GenerateProperties();
        if(UtilitiesFactory.getSingleton().getPrintersUtility().userTicketPrinterExists()){
            GenerateProperties.setPrint(true);
        }
        
        //Generate te report
        final TestReportGenerator testReportGenerator = ReportsManager.getSingleton().getTestReportGenerator();
        testReportGenerator.generate(GenerateProperties);

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
