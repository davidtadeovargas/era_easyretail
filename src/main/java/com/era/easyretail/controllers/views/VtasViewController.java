/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.easyretail.controllers.views;

import com.era.logger.LoggerUtility;
import com.era.models.Partvta;
import com.era.models.Sales;
import com.era.repositories.RepositoryFactory;
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
    
    public VtasViewController() {
        super("window_title_sales");
        
        try{
            
            this.PostInitComponents = () -> {
                maximizedWindow();
            };
            
            jBBusc.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBBuscActionPerformed(evt);
            });
            jBMosT.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBMosTActionPerformed(evt);
            });
            jBGenPDF.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBGenPDFActionPerformed(evt);
            });
            jBCa.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBCaActionPerformed(evt);
            });
            jButtonDirectorioRemisiones.addActionListener((java.awt.event.ActionEvent evt) -> {
                jButtonDirectorioRemisionesActionPerformed(evt);
            });
            jBDirX.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBDirXActionPerformed(evt);
            });
            jBDev.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBDevActionPerformed(evt);
            });
            jBDirZ.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBDirZActionPerformed(evt);
            });
            jBDevP.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBDevPActionPerformed(evt);
            });
            jButtonDirectorioNotaCredito.addActionListener((java.awt.event.ActionEvent evt) -> {
                jButtonDirectorioNotaCreditoActionPerformed(evt);
            });
            jBNew.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBNewActionPerformed(evt);
            });
            jButtonDirectorioCFDI.addActionListener((java.awt.event.ActionEvent evt) -> {
                jButtonDirectorioCFDIActionPerformed(evt);
            });
            jButtonNotaCredito.addActionListener((java.awt.event.ActionEvent evt) -> {
                jButtonNotaCreditoActionPerformed(evt);
            });
            jButtonDirectorioTickets.addActionListener((java.awt.event.ActionEvent evt) -> {
                jButtonDirectorioTicketsActionPerformed(evt);
            });
            jBVer.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBVerActionPerformed(evt);
            });
            jBDirCan.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBDirCanActionPerformed(evt);
            });
            jButtonEnviar.addActionListener((java.awt.event.ActionEvent evt) -> {
                jButtonEnviarActionPerformed(evt);
            });
            jBDirBack.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBDirBackActionPerformed(evt);
            });
            jBPDF.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBPDFActionPerformed(evt);
            });
            jBDirDev.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBDirDevActionPerformed(evt);
            });
            jButtonActualizar.addActionListener((java.awt.event.ActionEvent evt) -> {
                jButtonActualizarActionPerformed(evt);
            });
            jBDirDevP.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBDirDevPActionPerformed(evt);
            });
            jButtonTimbrar.addActionListener((java.awt.event.ActionEvent evt) -> {
                jButtonTimbrarActionPerformed(evt);
            });
            jButtonDirectorioAcuses.addActionListener((java.awt.event.ActionEvent evt) -> {
                jButtonDirectorioAcusesActionPerformed(evt);
            });
            jBEntre.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBEntreActionPerformed(evt);
            });
            jButtonComprobar.addActionListener((java.awt.event.ActionEvent evt) -> {
                jButtonComprobarActionPerformed(evt);
            });
            jButtonAcuse.addActionListener((java.awt.event.ActionEvent evt) -> {
                jButtonAcuseActionPerformed(evt);
            });
            jButtonObtenerXML.addActionListener((java.awt.event.ActionEvent evt) -> {
                jButtonObtenerXMLActionPerformed(evt);
            });
            jButtonTicketsFacturados.addActionListener((java.awt.event.ActionEvent evt) -> {
                jButtonTicketsFacturadosActionPerformed(evt);
            });
            jButtonBorrarDocumento.addActionListener((java.awt.event.ActionEvent evt) -> {
                jButtonBorrarDocumentoActionPerformed(evt);
            });
            jButtonVerArchivos.addActionListener((java.awt.event.ActionEvent evt) -> {
                jButtonVerArchivosActionPerformed(evt);
            });
            jButtonCargar.addActionListener((java.awt.event.ActionEvent evt) -> {
                jButtonCargarActionPerformed(evt);
            });
            jBCli.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBCliActionPerformed(evt);
            });
            jBSal.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBSalActionPerformed(evt);
            });
            jButtonAbrir.addActionListener((java.awt.event.ActionEvent evt) -> {
                jButtonAbrirActionPerformed(evt);
            });
            jButtonRelacionar.addActionListener((java.awt.event.ActionEvent evt) -> {
                jButtonRelacionarActionPerformed(evt);
            });
            jBAbrNotCred.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBAbrNotCredActionPerformed(evt);
            });
            
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
            
            //Config sales table            
            jTableVentas.addShowColumn(TableHeaderFactory.getSigleton().getSalessTableHeader().getSALE_ID());
            jTableVentas.addShowColumn(TableHeaderFactory.getSigleton().getSalessTableHeader().getCOMPANYCODE());
            jTableVentas.addShowColumn(TableHeaderFactory.getSigleton().getSalessTableHeader().getRAZON());
            jTableVentas.addShowColumn(TableHeaderFactory.getSigleton().getSalessTableHeader().getESTATUS());
            jTableVentas.addShowColumn(TableHeaderFactory.getSigleton().getSalessTableHeader().getEMISIONDATE());
            jTableVentas.addShowColumn(TableHeaderFactory.getSigleton().getSalessTableHeader().getFACTURADO());
            jTableVentas.addShowColumn(TableHeaderFactory.getSigleton().getSalessTableHeader().getOBSERVATION());
            jTableVentas.addShowColumn(TableHeaderFactory.getSigleton().getSalessTableHeader().getPAYMENTFORM());
            jTableVentas.addShowColumn(TableHeaderFactory.getSigleton().getSalessTableHeader().getSUBTOTAL());
            jTableVentas.addShowColumn(TableHeaderFactory.getSigleton().getSalessTableHeader().getTAX());
            jTableVentas.addShowColumn(TableHeaderFactory.getSigleton().getSalessTableHeader().getTOTAL());
            jTableVentas.setITableRowSelected((ListSelectionEvent lse, Object Object) -> {
                
                try {
                    
                    //Get the model
                    final Sales Sale = (Sales)Object;

                    //Get all the items from that sale
                    final List<Partvta> parts = RepositoryFactory.getInstance().getPartvtaRepository().getPartsVta(Sale.getId());
                                        
                    //Load the parts in table
                    jTab2.initTable(parts);
                            
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
            jTableVentas.setJScrollPane(panelTable);
            jTableVentas.setOnPaginationLabelUpdate((String paginationUpdate) -> {
                jLabelPagination.setText(paginationUpdate);
            });
            jTableVentas.initTableWithPagination();
            
        }catch (Exception ex) {
            LoggerUtility.getSingleton().logError(VtasViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(VtasViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
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
    
    private void jButtonRelacionarActionPerformed(java.awt.event.ActionEvent evt) {                                             

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
    
    private void jBCliActionPerformed(java.awt.event.ActionEvent evt) {                                             

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
    
    private void jButtonCargarActionPerformed(java.awt.event.ActionEvent evt) {                                             

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
    
    private void jButtonVerArchivosActionPerformed(java.awt.event.ActionEvent evt) {                                             

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
    
    private void jButtonBorrarDocumentoActionPerformed(java.awt.event.ActionEvent evt) {                                             

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
    
    private void jBEntreActionPerformed(java.awt.event.ActionEvent evt) {                                             

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
    
    private void jBDirBackActionPerformed(java.awt.event.ActionEvent evt) {                                             

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
            
            //Open the sale in view mode
            final NewVtaViewController NewVtaViewController = ViewControlersFactory.getSingleton().getNewVtaViewController();
            NewVtaViewController.setSale(Sale);
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
    
    private void jButtonNotaCreditoActionPerformed(java.awt.event.ActionEvent evt) {                                             

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
    
    private void jButtonDirectorioCFDIActionPerformed(java.awt.event.ActionEvent evt) {                                             

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
    
    private void jBNewActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            ViewControlersFactory.getSingleton().getNewVtaViewController().setVisible();
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
            ViewControlersFactory.getSingleton().getDevPVtaPtoViewController().setVisible();
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
            ViewControlersFactory.getSingleton().getDevVtaPtoViewController().setVisible();
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
                        
            ViewControlersFactory.getSingleton().getCanVtasViewController().setVisible();
            
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
