/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.easyretail.controllers.views;

import com.era.datamodels.enums.DocumentType;
import com.era.logger.LoggerUtility;
import com.era.models.DocumentOrigin;
import com.era.models.Partvta;
import com.era.models.Sales;
import com.era.repositories.RepositoryFactory;
import com.era.repositories.datamodels.DocumentTypeFilter;
import com.era.utilities.UtilitiesFactory;
import com.era.views.VtasJFrame;
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
public class VtasViewController extends VtasJFrame {
    
    private DocumentType DocumentType_;
    
    public VtasViewController() {
        super("window_title_sales");
        
        try{
            
            this.PostInitComponents = () -> {
                maximizedWindow();
            };
                        
            jMenuItemInvoicesNotRinged.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMenuItemInvoicesNotRingedActionPerformed(evt);
            });
            jBBusc.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBBuscActionPerformed(evt);
            });
            jMenuItemTicketsFacturados.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMenuItemTicketsFacturadosActionPerformed(evt);
            });            
            jBMosT.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBMosTActionPerformed(evt);
            });
            jMenuItemSalesFacTick.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMenuItemSalesFacTickActionPerformed(evt);
            });
            jMenuItemDocuSatGetXML.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMenuItemDocuSatGetXMLActionPerformed(evt);
            });            
            jMenuItemGralGeneratePDF.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBGenPDFActionPerformed(evt);
            });
            jMenuItemGralCancel.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBCaActionPerformed(evt);
            });
            jMenuItemFoldersRems.addActionListener((java.awt.event.ActionEvent evt) -> {
                jButtonDirectorioRemisionesActionPerformed(evt);
            });
            jMenuItemFoldersCortX.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBDirXActionPerformed(evt);
            });
            jMenuItemSalesDev.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBDevActionPerformed(evt);
            });
            jMenuItemFoldersCortZ.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBDirZActionPerformed(evt);
            });
            jMenuItemSalesDevP.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBDevPActionPerformed(evt);
            });
            jMenuItemFoldersCreditNot.addActionListener((java.awt.event.ActionEvent evt) -> {
                jButtonDirectorioNotaCreditoActionPerformed(evt);
            });
            jMenuItemGralNew.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBNewActionPerformed(evt);
            });
            jMenuItemFoldersCFDI.addActionListener((java.awt.event.ActionEvent evt) -> {
                jButtonDirectorioCFDIActionPerformed(evt);
            });
            jMenuItemFoldersTicks.addActionListener((java.awt.event.ActionEvent evt) -> {
                jButtonDirectorioTicketsActionPerformed(evt);
            });
            jMenuItemGralView.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBVerActionPerformed(evt);
            });
            jMenuItemFoldersCancels.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBDirCanActionPerformed(evt);
            });
            jMenuItemGralSend.addActionListener((java.awt.event.ActionEvent evt) -> {
                jButtonEnviarActionPerformed(evt);
            });
            jMenuItemGralViewPDF.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBPDFActionPerformed(evt);
            });
            jMenuItemFoldersDevs.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBDirDevActionPerformed(evt);
            });
            /*jButtonActualizar.addActionListener((java.awt.event.ActionEvent evt) -> {
                jButtonActualizarActionPerformed(evt);
            });*/
            jMenuItemFoldersDevsP.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBDirDevPActionPerformed(evt);
            });
            jMenuItemDocuSatRing.addActionListener((java.awt.event.ActionEvent evt) -> {
                jButtonTimbrarActionPerformed(evt);
            });
            jMenuItemFoldersAcuses.addActionListener((java.awt.event.ActionEvent evt) -> {
                jButtonDirectorioAcusesActionPerformed(evt);
            });
            jMenuItemDocuSatCheck.addActionListener((java.awt.event.ActionEvent evt) -> {
                jButtonComprobarActionPerformed(evt);
            });
            jMenuItemDocuSatAcuse.addActionListener((java.awt.event.ActionEvent evt) -> {
                jButtonAcuseActionPerformed(evt);
            });
            jMenuItemGetXML.addActionListener((java.awt.event.ActionEvent evt) -> {
                jButtonObtenerXMLActionPerformed(evt);
            });
            /*jButtonTicketsFacturados.addActionListener((java.awt.event.ActionEvent evt) -> {
                jButtonTicketsFacturadosActionPerformed(evt);
            });*/
            jMenuItemExit.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBSalActionPerformed(evt);
            });
            jMenuItemGralOpen.addActionListener((java.awt.event.ActionEvent evt) -> {
                jButtonAbrirActionPerformed(evt);
            });
            /*jBAbrNotCred.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBAbrNotCredActionPerformed(evt);
            });*/
            
            //Config partvta table
            jTab2.addShowColumn(TableHeaderFactory.getSigleton().getPartvtasTableHeader().getROWNUMBER());
            jTab2.addShowColumn(TableHeaderFactory.getSigleton().getPartvtasTableHeader().getCANT());
            jTab2.addShowColumn(TableHeaderFactory.getSigleton().getPartvtasTableHeader().getPROD());
            jTab2.addShowColumn(TableHeaderFactory.getSigleton().getPartvtasTableHeader().getALMA());
            jTab2.addShowColumn(TableHeaderFactory.getSigleton().getPartvtasTableHeader().getDESCRIP());
            jTab2.addShowColumn(TableHeaderFactory.getSigleton().getPartvtasTableHeader().getDESCU());
            jTab2.addShowColumn(TableHeaderFactory.getSigleton().getPartvtasTableHeader().getIMPO());
            jTab2.addShowColumn(TableHeaderFactory.getSigleton().getPartvtasTableHeader().getIMPUE());
            jTab2.addShowColumn(TableHeaderFactory.getSigleton().getPartvtasTableHeader().getLIST());
            
            //Show the columns
            jTableVentas.showCommonColumnsWithRingedInformation();
            
            //Event when row is selected
            jTableVentas.setITableRowSelected((ListSelectionEvent lse, Object Object) -> {
                
                try {
                    
                    //Get the model
                    final Sales Sale = (Sales)Object;

                    //Get all the items from that sale
                    final List<Partvta> parts = RepositoryFactory.getInstance().getPartvtaRepository().getPartsVta(Sale.getId());
                                        
                    //Load the parts in table
                    jTab2.initTable(parts);                                        
                        
                    //Show the type of sale
                    String type;
                    if(RepositoryFactory.getInstance().getSalessRepository().isInvoiceDocument(Sale)){
                        type = this.props.getProperty("invoice");
                    }
                    else if(RepositoryFactory.getInstance().getSalessRepository().isRemDocument(Sale)){
                        type = this.props.getProperty("remision");
                    }
                    else if(RepositoryFactory.getInstance().getSalessRepository().isTicketDocument(Sale)){
                        type = this.props.getProperty("ticket");
                    }
                    else if(RepositoryFactory.getInstance().getSalessRepository().isNotcDocument(Sale)){
                        type = this.props.getProperty("notc");
                    }
                    else{
                        UtilitiesFactory.getSingleton().getGenericExceptionUtil().generateException("");
                        return;
                    }
                    jLabelTypeSale.setText(type);
                            
                } catch (Exception ex) {
                    LoggerUtility.getSingleton().logError(this.getClass(), ex);
                    try {
                        DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
                    } catch (Exception ex1) {
                        Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex1);
                    }
                }
            });
            
            //Load all the sales
            jTableVentas.setScrollAtStartWhenEnd(true);
            jTableVentas.setJScrollPane(jScrollPane3);
            jTableVentas.setOnPaginationLabelUpdate((String paginationUpdate) -> {
                jLabelPagination.setText(paginationUpdate);
            });
            
            //Load all the documents for sales
            final List<DocumentOrigin> documents = RepositoryFactory.getInstance().getDocumentOriginRepository().getSalesModuleItems();
            jRadioBoxTipoDeVentas.loadItems(documents);
            
            jRadioBoxTipoDeVentas.setChangeSelectionListener((Object ObjectModel) -> {
                
                try {
                 
                    //Cast the model
                    final DocumentOrigin DocumentOrigin_ = (DocumentOrigin)ObjectModel;

                    //Determine the document type
                    DocumentType DocumentType_ = DocumentType.SALES;
                    if(DocumentOrigin_.isInvoice()){
                        DocumentType_ = DocumentType.INVOICE;
                    }
                    else if(DocumentOrigin_.isNotc()){
                        DocumentType_ = DocumentType.NOTC;
                    }
                    else if(DocumentOrigin_.isRemision()){
                        DocumentType_ = DocumentType.REMISION;
                    }
                    else if(DocumentOrigin_.isTicket()){
                        DocumentType_ = DocumentType.TICKETS;
                    }

                    //Change the type of sales of the module
                    setDocumentType(DocumentType_);
                    
                } catch (Exception ex) {
                    LoggerUtility.getSingleton().logError(this.getClass(), ex);
                    try {
                        DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
                    } catch (Exception ex1) {
                        Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex1);
                    }
                }
            });
            
        }catch (Exception ex) {
            LoggerUtility.getSingleton().logError(VtasViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(VtasViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }

    public void setDocumentType(DocumentType DocumentType) throws Exception {
        
        //Enable menus
        jMenuItemGralNew.setEnabled(true);
        jMenuDocuSAT.setEnabled(true);
        jMenuItemGralSend.setEnabled(true);

        this.DocumentType_ = DocumentType;
        
        String type = "";
        
        switch(DocumentType){
            
            case REMISION:
                jTableVentas.setDocumentTypeFilter(DocumentTypeFilter.JUST_REM);
                type = this.props.getProperty("remisions");
                break;
                
            case INVOICE:
                jTableVentas.setDocumentTypeFilter(DocumentTypeFilter.JUST_INVOICES);
                type = this.props.getProperty("invoices");
                break;
                
            case SALES:
                jTableVentas.setDocumentTypeFilter(DocumentTypeFilter.ALL_SALES);
                type = this.props.getProperty("sales");
                break;
                
            case TICKETS:
                jTableVentas.setDocumentTypeFilter(DocumentTypeFilter.JUST_TICKET);
                type = this.props.getProperty("tickets");
                
                jMenuItemGralNew.setEnabled(false);
                jMenuDocuSAT.setEnabled(false);
                jMenuItemGralSend.setEnabled(false);
                
                break;
                
            case NOTC:
                jTableVentas.setDocumentTypeFilter(DocumentTypeFilter.JUST_NOTCS);
                type = this.props.getProperty("tickets");
                break;
        }
        
        //Set the label
        jLabelTipDoc.setText(type);
        
        //Load all the records
        jTableVentas.initTableWithPagination();
    }
        
    
    @Override
    public void clearFields() throws Exception{
    }
    
    @Override
    public void loadModelInFields(Object ObjectModel) throws  Exception {        
    }
    
    private void jBAbrNotCredActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(VtasViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(VtasViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jButtonAbrirActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(VtasViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(VtasViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBSalActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            dispose();
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(VtasViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(VtasViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jButtonTicketsFacturadosActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(VtasViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(VtasViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jButtonObtenerXMLActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(VtasViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(VtasViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jButtonAcuseActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(VtasViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(VtasViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jButtonComprobarActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(VtasViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(VtasViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jButtonDirectorioAcusesActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            UtilitiesFactory.getSingleton().getImagesUtility().openAcusesPath();
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(VtasViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(VtasViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jButtonTimbrarActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{
            ViewControlersFactory.getSingleton().getInvoicesNotRingedViewController().setVisible();
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(VtasViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(VtasViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBDirDevPActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            UtilitiesFactory.getSingleton().getImagesUtility().openDevspPath();
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(VtasViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(VtasViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jButtonActualizarActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(VtasViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(VtasViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBDirDevActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            UtilitiesFactory.getSingleton().getImagesUtility().openDevsPath();
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(VtasViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(VtasViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBPDFActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(VtasViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(VtasViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jButtonEnviarActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(VtasViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(VtasViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBDirCanActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            UtilitiesFactory.getSingleton().getImagesUtility().openCancelsPath();
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(VtasViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(VtasViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBVerActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
            //First select a sale to view
            if(!jTableVentas.isRowSelected()){
                DialogsFactory.getSingleton().showErrorOKNoSelectionCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                    jTableVentas.grabFocus();
                });
                return;
            }
            
            //Get selected sale
            final Sales Sale = (Sales)jTableVentas.getRowSelected();
            final NewVtaViewController NewVtaViewController = ViewControlersFactory.getSingleton().getNewVtaViewController();
            if(RepositoryFactory.getInstance().getSalessRepository().isInvoiceDocument(Sale)){
                NewVtaViewController.setDocumentType(DocumentType.INVOICE);
            }
            else if(RepositoryFactory.getInstance().getSalessRepository().isRemDocument(Sale)){
                NewVtaViewController.setDocumentType(DocumentType.REMISION);
            }
            else if(RepositoryFactory.getInstance().getSalessRepository().isTicketDocument(Sale)){
                NewVtaViewController.setDocumentType(DocumentType.TICKETS);
            }
            else if(RepositoryFactory.getInstance().getSalessRepository().isNotcDocument(Sale)){
                NewVtaViewController.setDocumentType(DocumentType.NOTC);
            }
            NewVtaViewController.setSale(Sale);
            NewVtaViewController.setReadOnly(true);
            NewVtaViewController.setVisible();            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(VtasViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(VtasViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jButtonDirectorioTicketsActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            UtilitiesFactory.getSingleton().getImagesUtility().openTicketsPath();
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(VtasViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(VtasViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jButtonDirectorioCFDIActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            UtilitiesFactory.getSingleton().getImagesUtility().openInvoicesPath();
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(VtasViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(VtasViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBNewActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            final NewVtaViewController NewVtaViewController_ = ViewControlersFactory.getSingleton().getNewVtaViewController();
            NewVtaViewController_.setDocumentType(DocumentType_);
            NewVtaViewController_.setVisible();            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(VtasViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(VtasViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jButtonDirectorioNotaCreditoActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            UtilitiesFactory.getSingleton().getImagesUtility().openNotcPath();
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(VtasViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(VtasViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBDevPActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            
            final DevPVtaPtoViewController DevPVtaPtoViewController = ViewControlersFactory.getSingleton().getDevPVtaPtoViewController();
            switch(DocumentType_){
            
                case REMISION:
                    DevPVtaPtoViewController.setDocumentTypeFilter(DocumentTypeFilter.JUST_REM_CO_DEVP);
                    break;

                case INVOICE:
                    DevPVtaPtoViewController.setDocumentTypeFilter(DocumentTypeFilter.JUST_INVOICES_CO_DEVP);
                    break;

                case SALES:
                    DevPVtaPtoViewController.setDocumentTypeFilter(DocumentTypeFilter.ALL_SALES_CO_DEVP);
                    break;

                case TICKETS:
                    DevPVtaPtoViewController.setDocumentTypeFilter(DocumentTypeFilter.JUST_TICKET_CO_DEVP);
                    break;

                case NOTC:
                    DevPVtaPtoViewController.setDocumentTypeFilter(DocumentTypeFilter.JUST_NOTCS_CO_DEVP);
                    break;
            }
            DevPVtaPtoViewController.setVisible();
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(VtasViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(VtasViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBDirZActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            UtilitiesFactory.getSingleton().getImagesUtility().openCortzPath();
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(VtasViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(VtasViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBDevActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{
            final DevVtaPtoViewController DevVtaPtoViewController = ViewControlersFactory.getSingleton().getDevVtaPtoViewController();
            switch(DocumentType_){
            
                case REMISION:
                    DevVtaPtoViewController.setDocumentTypeFilter(DocumentTypeFilter.JUST_REM_CO);
                    break;

                case INVOICE:
                    DevVtaPtoViewController.setDocumentTypeFilter(DocumentTypeFilter.JUST_INVOICES_CO);
                    break;

                case SALES:
                    DevVtaPtoViewController.setDocumentTypeFilter(DocumentTypeFilter.ALL_SALES_CO);
                    break;

                case TICKETS:
                    DevVtaPtoViewController.setDocumentTypeFilter(DocumentTypeFilter.JUST_TICKET_CO);
                    break;

                case NOTC:
                    DevVtaPtoViewController.setDocumentTypeFilter(DocumentTypeFilter.JUST_NOTCS_CO);
                    break;
            }
            DevVtaPtoViewController.setVisible();
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(VtasViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(VtasViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBDirXActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            UtilitiesFactory.getSingleton().getImagesUtility().openCortxPath();
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(VtasViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(VtasViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jButtonDirectorioRemisionesActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            UtilitiesFactory.getSingleton().getImagesUtility().openRemsPath();
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(VtasViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(VtasViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBCaActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try {
                        
            final CanVtasViewController CanVtasViewController = ViewControlersFactory.getSingleton().getCanVtasViewController();
            switch(DocumentType_){
            
                case REMISION:
                    CanVtasViewController.setDocumentTypeFilter(DocumentTypeFilter.JUST_REM_CO);                    
                    break;

                case INVOICE:
                    CanVtasViewController.setDocumentTypeFilter(DocumentTypeFilter.JUST_INVOICES_CO);
                    break;

                case SALES:
                    CanVtasViewController.setDocumentTypeFilter(DocumentTypeFilter.ALL_SALES_CO);
                    break;

                case TICKETS:
                    CanVtasViewController.setDocumentTypeFilter(DocumentTypeFilter.JUST_TICKET_CO);
                    break;

                case NOTC:
                    CanVtasViewController.setDocumentTypeFilter(DocumentTypeFilter.JUST_NOTCS_CO);
                    break;
            }
            CanVtasViewController.setVisible();
            
        } catch (Exception ex) {
            LoggerUtility.getSingleton().logError(this.getClass(), ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
        
    
    private void jMenuItemDocuSatGetXMLActionPerformed(java.awt.event.ActionEvent evt) {
        
        try {
            
        } catch (Exception ex) {
            LoggerUtility.getSingleton().logError(this.getClass(), ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    private void jBGenPDFActionPerformed(java.awt.event.ActionEvent evt) {

	try{            	
                        
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(VtasViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(VtasViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jMenuItemSalesFacTickActionPerformed(java.awt.event.ActionEvent evt) {
        
        try {
            ViewControlersFactory.getSingleton().getFacturarTicketsViewController().setVisible();
        } catch (Exception ex) {
            LoggerUtility.getSingleton().logError(this.getClass(), ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    
    private void jMenuItemTicketsFacturadosActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            
            //First select a sale to view
            if(!jTableVentas.isRowSelected()){
                DialogsFactory.getSingleton().showErrorOKNoSelectionCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                    jTableVentas.grabFocus();
                });
                return;
            }
            
            //Get selected sale
            final Sales Sale = (Sales)jTableVentas.getRowSelected();
            
            //If the document is not an invoice stop
            if(!RepositoryFactory.getInstance().getSalessRepository().isInvoiceDocument(Sale)){
                DialogsFactory.getSingleton().showErrorOKCallbackDialog(baseJFrame, "errors_document_has_to_be_invoice", null);
                return;
            }
            
            //Get all the ticket sales related
            final List<Sales> sales = RepositoryFactory.getInstance().getSalessRepository().getAllTicketSales(Sale.getId());
            
            //If no one stop
            if(sales.isEmpty()){
                DialogsFactory.getSingleton().showErrorOKCallbackDialog(baseJFrame, "errors_records_not_exists", null);
                return;
            }
            
            final TicketsFacturadosViewController TicketsFacturadosViewController = ViewControlersFactory.getSingleton().getTicketsFacturadosViewController();
            TicketsFacturadosViewController.init(Sale,sales);
            TicketsFacturadosViewController.setVisible();
            
        } catch (Exception ex) {
            LoggerUtility.getSingleton().logError(this.getClass(), ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    private void jBMosTActionPerformed(java.awt.event.ActionEvent evt) {

	try{            	
            
            this.jTableVentas.initTableWithPagination();
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(VtasViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(VtasViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
        
    private void jMenuItemInvoicesNotRingedActionPerformed(java.awt.event.ActionEvent evt) {                                             
        
        try {
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
    
    private void jBBuscActionPerformed(java.awt.event.ActionEvent evt) {

	try{            	
            
            //Get the value to search
            final String search = jTBusc.getText().trim();
            
            //If nothing to search so return
            if(search.isEmpty()){
                return;
            }
            
            //Search all the ocurrences
            this.jTableVentas.getByLikeEncabezados(search);            
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(VtasViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(VtasViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    @Override
    public List<?> getItemsToLoadInTable() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
