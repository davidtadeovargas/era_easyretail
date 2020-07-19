/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.easyretail.controllers.views;

import com.era.datamodels.enums.DocumentType;
import com.era.easyretail.enums.DBFileConnectionConfigurationType;
import com.era.easyretail.enums.LoginType;
import com.era.easyretail.enums.LoginTypeEmpresa;
import com.era.easyretail.swingworkers.BaseSwingWorker;
import com.era.easyretail.swingworkers.ISwingWorkerActions;
import com.era.logger.LoggerUtility;
import com.era.models.BasDats;
import com.era.models.Company;
import com.era.models.Confgral;
import com.era.models.Kits;
import com.era.models.Product;
import com.era.models.User;
import com.era.models.Supplier;
import com.era.models.Warehouse;
import com.era.repositories.RepositoryFactory;
import com.era.utilities.UtilitiesFactory;
import com.era.utilities.WinRegistry;
import com.era.utilities.excel.CustomersWorkbook;
import com.era.utilities.excel.KitsWorkbook;
import com.era.utilities.excel.ProductsWorkbook;
import com.era.utilities.excel.SuppliersWorkbook;
import com.era.utilities.excel.WarehouseExistencesWorkbook;
import com.era.utilities.excel.rows.models.CustomerExcelRowModel;
import com.era.utilities.excel.rows.models.KitExcelRowModel;
import com.era.utilities.excel.rows.models.SupplierExcelRowModel;
import com.era.utilities.excel.rows.models.WarehouseExistencesExcelRowModel;
import com.era.utilities.excel.rows.models.ProductExcelRowModel;
import com.era.utilities.exceptions.FilenameDontMatchException;
import com.era.utilities.exceptions.InvalidFileExtensionException;
import com.era.utilities.filechooser.ExcelFileChooserUtility;
import com.era.utilities.filechooser.FileChooserUtility;
import com.era.views.PrincipJFrame;
import com.era.views.dialogs.DialogsFactory;
import com.era.views.dialogs.ErrorOKDialog;
import com.era.views.dialogs.ExceptionDialog;
import com.era.views.dialogs.OKDialog;
import com.era.views.dialogs.QuestionDialog;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author PC
 */
public class PrincipViewController extends PrincipJFrame {
    
    public PrincipViewController(){
     
        super("window_title_principl");
        
        try{                        
            
            final Confgral Confgral = RepositoryFactory.getInstance().getConfgralRepository().getSistemClasifByConf("reporteCaja");
            if(Confgral==null){
                jBReporteCaja.setEnabled(false);
            }
            else{
                jBReporteCaja.setEnabled(Confgral.getVal()==1);
            }
            
            //Temporal
            jBReporteCaja.setEnabled(true);
            
            //Override default functionality
            JComponentUtils.setDisposeInEscapeEvent(false);            
            
            final ImageIcon ImageIcon = UtilitiesFactory.getSingleton().getIconsUtility().getImageIconFromImage("ban.png");                
            jLImg.setIcon(ImageIcon);

            final BasDats BasDats = UtilitiesFactory.getSingleton().getSessionUtility().getBasDats();
            final User User = UtilitiesFactory.getSingleton().getSessionUtility().getUser();
            final String userLoggedTime = UtilitiesFactory.getSingleton().getSessionUtility().getUserLoggedTime();
                        
            linesMenuItem.addActionListener((java.awt.event.ActionEvent evt) -> {
                linesMenuItemActionPerformed(evt);
            });
            importKitsMenItem.addActionListener((java.awt.event.ActionEvent evt) -> {
                importKitsMenItemActionPerformed(evt);
            });
            jMenIt4.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMenIt4ActionPerformed(evt);
            });
            jMInvenImpo.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMInvenImpoActionPerformed(evt);
            });            
            jMMClien.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMMClienActionPerformed(evt);
            });
            jMenItManProvs.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMenItManProvsActionPerformed(evt);
            });
            jMenItPermEstacs.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMenItPermEstacsActionPerformed(evt);
            });
            jBProvs.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBProvsActionPerformed(evt);
            });
            jMenItEstacs.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMenItEstacsActionPerformed(evt);
            });
            jMenItLogear.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMenItLogearActionPerformed(evt);
            });
            jMenItSal.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMenItSalActionPerformed(evt);
            });
            jMenItComps.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMenItCompsActionPerformed(evt);
            });
            jMenCotsT.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMenCotsTActionPerformed(evt);
            });
            jMenItVtas.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMenItVtasActionPerformed(evt);
            });
            jMenItTouch.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMenItTouchActionPerformed(evt);
            });
            jMeItImps.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMeItImpsActionPerformed(evt);
            });
            jMenItMons.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMenItMonsActionPerformed(evt);
            });
            jMVProd.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMVProdActionPerformed(evt);
            });
            jMenItProdsBajMin.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMenItProdsBajMinActionPerformed(evt);
            });
            jMenItDefEstacs.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMenItDefEstacsActionPerformed(evt);
            });
            jMenItKits.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMenItKitsActionPerformed(evt);
            });
            jMenItProdsArrMax.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMenItProdsArrMaxActionPerformed(evt);
            });
            jMenItTraspas.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMenItTraspasActionPerformed(evt);
            });
            jMenItIngr.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMenItIngrActionPerformed(evt);
            });
            jMenItDatsGenEmp.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMenItDatsGenEmpActionPerformed(evt);
            });
            jMenItLogCorr.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMenItLogCorrActionPerformed(evt);
            });
            jMenItTipsPags.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMenItTipsPagsActionPerformed(evt);
            });
            jMVLogSys.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMVLogSysActionPerformed(evt);
            });
            jMConfAd.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMConfAdActionPerformed(evt);
            });
            jMCXC.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMCXCActionPerformed(evt);
            });
            jMCXP.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMCXPActionPerformed(evt);
            });
            jMenConfigFil.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMenConfigFilActionPerformed(evt);
            });
            jMenItDeslog.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMenItDeslogActionPerformed(evt);
            });
            jMenItCamEmp.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMenItCamEmpActionPerformed(evt);
            });
            jMDelLog.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMDelLogActionPerformed(evt);
            });
            reportsMenu.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMEstacsActionPerformed(evt);
            });
            jMLogProd.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMLogProdActionPerformed(evt);
            });
            addWindowStateListener((java.awt.event.WindowEvent evt) -> {
                formWindowStateChanged(evt);
            });
            jBPtoVta.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBPtoVtaActionPerformed(evt);
            });
            jBVtas.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBVtasActionPerformed(evt);
            });
            jBComps.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBCompsActionPerformed(evt);
            });
            jBEmps.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBEmpsActionPerformed(evt);
            });
            jBProds.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBProdsActionPerformed(evt);
            });
            jBCots.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBCotsActionPerformed(evt);
            });
            jMAcerc.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMAcercActionPerformed(evt);
            });
            jMImpProvs.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMImpProvsActionPerformed(evt);
            });
            addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowActivated(java.awt.event.WindowEvent evt) {
                }
                @Override
                public void windowClosing(java.awt.event.WindowEvent evt) {
                    formWindowClosing(evt);
                }
            });
            jMLotPed.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMLotPedActionPerformed(evt);
            });
            jMConcepPags.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMConcepPagsActionPerformed(evt);
            });
            jBPrevComp.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBPrevCompActionPerformed(evt);
            });
            jMPrevioComp.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMPrevioCompActionPerformed(evt);
            });
            jMenuItem7.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMenuItem7ActionPerformed(evt);
            });
            jMICuentaContable.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMICuentaContableActionPerformed(evt);
            });
            jMenuItem5.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMenuItem5ActionPerformed(evt);
            });
            jMenuItemPedidos.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMenuItemPedidosActionPerformed(evt);
            });
            jMenuItemRemisiones.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMenuItemRemisionesActionPerformed(evt);
            });
            jMenuItemTickets.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMenuItemTicketsActionPerformed(evt);
            });
            jMenuItemNotc.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMenuItemNotcActionPerformed(evt);
            });
            jMenuItemInvoices.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMenuItemInvoicesActionPerformed(evt);
            });
            jButtonPedidos.addActionListener((java.awt.event.ActionEvent evt) -> {
                jButtonPedidosActionPerformed(evt);
            });
            jButtonPedidos1.addActionListener((java.awt.event.ActionEvent evt) -> {
                jButtonPedidos1ActionPerformed(evt);
            });
            jMenuItem3.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMenuItem3ActionPerformed(evt);
            });
            jBReporteCaja.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBReporteCajaActionPerformed(evt);
            });
            jMenuItem6.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMenuItem6ActionPerformed(evt);
            });
            reportsMenu.addActionListener((java.awt.event.ActionEvent evt) -> {
                reportsMenuActionPerformed(evt);
            });
            clasificationsMenu.addActionListener((java.awt.event.ActionEvent evt) -> {
                clasificationsMenuActionPerformed(evt);
            });
            jMActivo.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMActivoActionPerformed(evt);
            });
            jMenItImpres.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMenItImpresActionPerformed(evt);
            });
            warehousesMenu.addActionListener((java.awt.event.ActionEvent evt) -> {
                warehousesMenuActionPerformed(evt);
            });
            jMImpExistAlm.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMImpExistAlmActionPerformed(evt);
            });
            jMImpCliens.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMImpCliensActionPerformed(evt);
            });
                        
            onCloseWindowDoNothing();
            
        }catch (Exception ex) {
            LoggerUtility.getSingleton().logError(PrincipViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(PrincipViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    @Override
    public void loadModelInFields(Object ObjectModel) throws  Exception {        
    }
            
    private void loadWarehousesExistencesFromExcel(String absolutePath, String fileName){
        
        try{
            
            //Question if really continue
            DialogsFactory.getSingleton().showQuestionContinueDialog(baseJFrame, (JFrame jFrame) -> {
            
                try{
                    
                    final BaseSwingWorker BaseSwingWorker = new BaseSwingWorker();
                    BaseSwingWorker.setShowLoading(baseJFrame);
                    BaseSwingWorker.setISwingWorkerActions(new ISwingWorkerActions(){

                        @Override
                        public void before() {
                            
                        }

                        @Override
                        public Object doinbackground() {
                            
                            try{
                                
                                //Load the warehouses existences
                                final WarehouseExistencesWorkbook WarehouseExistencesWorkbook = new WarehouseExistencesWorkbook();
                                WarehouseExistencesWorkbook.setFilePath(absolutePath + "\\" + fileName);                    
                                WarehouseExistencesWorkbook.setOnFinish(() -> {

                                    
                                });
                                WarehouseExistencesWorkbook.setOnCellRender((Object CellModel) -> {
                                    try{

                                        //Cast model
                                        final WarehouseExistencesExcelRowModel WarehouseExistencesExcelRowModel = (WarehouseExistencesExcelRowModel)CellModel;

                                        //Get values
                                        final String warehouseCode = WarehouseExistencesExcelRowModel.getWarehouseCode();
                                        final String productCode = WarehouseExistencesExcelRowModel.getProductCode();
                                        final double existence = WarehouseExistencesExcelRowModel.getExistence();

                                        //If the warehouse doesnt existe create it
                                        Warehouse Warehouse = (Warehouse)RepositoryFactory.getInstance().getWarehousesRepository().getByCode(warehouseCode);
                                        if(Warehouse==null){
                                            Warehouse = new Warehouse();
                                            Warehouse.setCode(warehouseCode);
                                            Warehouse.setDescription("");
                                            Warehouse.setResponsable("SUP");
                                            RepositoryFactory.getInstance().getWarehousesRepository().save(Warehouse);
                                        }

                                        //Update the warehouse existences
                                        RepositoryFactory.getInstance().getExistalmasRepository().updateExistences(warehouseCode, productCode, existence);

                                    }catch (Exception ex) {
                                        LoggerUtility.getSingleton().logError(PrincipViewController.class, ex);
                                        try {
                                            DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
                                        } catch (Exception ex1) {
                                            Logger.getLogger(PrincipViewController.class.getName()).log(Level.SEVERE, null, ex1);
                                        }
                                    }
                                });
                                WarehouseExistencesWorkbook.load();

                            }catch (Exception ex) {
                                LoggerUtility.getSingleton().logError(PrincipViewController.class, ex);
                                try {
                                    DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
                                } catch (Exception ex1) {
                                    Logger.getLogger(PrincipViewController.class.getName()).log(Level.SEVERE, null, ex1);
                                }
                            }
                            
                            return null;
                        }

                        @Override
                        public void after(Object Object) {
                            
                            try{

                                //Announce success to the user
                                DialogsFactory.getSingleton().showOKOperationCompletedCallbackDialog(jFrame, null);

                            }catch (Exception ex) {
                                LoggerUtility.getSingleton().logError(PrincipViewController.class, ex);
                                try {
                                    DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
                                } catch (Exception ex1) {
                                    Logger.getLogger(PrincipViewController.class.getName()).log(Level.SEVERE, null, ex1);
                                }
                            }
                        }
                        
                    });
                    BaseSwingWorker.execute();

                }catch (Exception ex) {
                    LoggerUtility.getSingleton().logError(PrincipViewController.class, ex);
                    try {
                        DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
                    } catch (Exception ex1) {
                        Logger.getLogger(PrincipViewController.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                }
            });
            
        }catch (Exception ex) {
            LoggerUtility.getSingleton().logError(PrincipViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(PrincipViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    private void loadKitsFromExcel(String absolutePath, String fileName){
        
        try{
            
            //Question if really continue
            DialogsFactory.getSingleton().showQuestionContinueDialog(baseJFrame, (JFrame jFrame) -> {
            
                try{
                    
                    final BaseSwingWorker BaseSwingWorker = new BaseSwingWorker();
                    BaseSwingWorker.setShowLoading(baseJFrame);
                    BaseSwingWorker.setISwingWorkerActions(new ISwingWorkerActions(){

                        @Override
                        public void before() {
                            
                        }

                        @Override
                        public Object doinbackground() {
                            
                            try{
                                
                                //Load the kits
                                final KitsWorkbook KitsWorkbook = new KitsWorkbook();
                                KitsWorkbook.setFilePath(absolutePath + "\\" + fileName);                    
                                KitsWorkbook.setOnFinish(() -> {
                                });
                                KitsWorkbook.setOnCellRender((Object CellModel) -> {
                                    try{

                                        //Cast model
                                        final KitExcelRowModel KitExcelRowModel = (KitExcelRowModel)CellModel;

                                        //Get values
                                        final String kitCode = KitExcelRowModel.getKitCode();
                                        final String productCode = KitExcelRowModel.getProductCode();
                                        final String cant = KitExcelRowModel.getCant();

                                        //If the kit doesnt exists
                                        Product Product = (Product)RepositoryFactory.getInstance().getProductsRepository().getByCode(kitCode);
                                        if(Product==null){
                                            return;
                                        }
                                        
                                        //If the product doesnt exists
                                        Product = (Product)RepositoryFactory.getInstance().getProductsRepository().getByCode(productCode);
                                        if(Product==null){
                                            return;
                                        }
                                        
                                        //If the record exists
                                        Kits Kits = (Kits)RepositoryFactory.getInstance().getKitssRepository().getByKitAndComponent(kitCode, productCode);
                                        if(Kits==null){
                                            Kits = new Kits();
                                            Kits.setCode(kitCode);
                                            Kits.setProd(productCode);
                                            Kits.setCant(Float.valueOf(cant));
                                            RepositoryFactory.getInstance().getKitssRepository().save(Kits);
                                            
                                            //Update the product that contains a kit
                                            RepositoryFactory.getInstance().getProductsRepository().updateProductAsKit(kitCode);
                                        }
                                        else{
                                            Kits.setCant(Float.valueOf(cant));
                                            RepositoryFactory.getInstance().getKitssRepository().update(Kits);
                                        }

                                    }catch (Exception ex) {
                                        LoggerUtility.getSingleton().logError(PrincipViewController.class, ex);
                                        try {
                                            DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
                                        } catch (Exception ex1) {
                                            Logger.getLogger(PrincipViewController.class.getName()).log(Level.SEVERE, null, ex1);
                                        }
                                    }
                                });
                                KitsWorkbook.load();

                            }catch (Exception ex) {
                                LoggerUtility.getSingleton().logError(PrincipViewController.class, ex);
                                try {
                                    DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
                                } catch (Exception ex1) {
                                    Logger.getLogger(PrincipViewController.class.getName()).log(Level.SEVERE, null, ex1);
                                }
                            }
                            
                            return null;
                        }

                        @Override
                        public void after(Object Object) {
                            
                            try{

                                //Announce success to the user
                                DialogsFactory.getSingleton().showOKOperationCompletedCallbackDialog(jFrame, null);

                            }catch (Exception ex) {
                                LoggerUtility.getSingleton().logError(PrincipViewController.class, ex);
                                try {
                                    DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
                                } catch (Exception ex1) {
                                    Logger.getLogger(PrincipViewController.class.getName()).log(Level.SEVERE, null, ex1);
                                }
                            }
                        }
                        
                    });
                    BaseSwingWorker.execute();

                }catch (Exception ex) {
                    LoggerUtility.getSingleton().logError(PrincipViewController.class, ex);
                    try {
                        DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
                    } catch (Exception ex1) {
                        Logger.getLogger(PrincipViewController.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                }
            });
            
        }catch (Exception ex) {
            LoggerUtility.getSingleton().logError(PrincipViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(PrincipViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    private void loadProductsFromExcel(String absolutePath, String fileName){
        
        try{
            
            //Question if really continue
            DialogsFactory.getSingleton().showQuestionContinueDialog(baseJFrame, (JFrame jFrame) -> {
            
                try{
                    
                    final BaseSwingWorker BaseSwingWorker = new BaseSwingWorker();
                    BaseSwingWorker.setShowLoading(baseJFrame);
                    BaseSwingWorker.setISwingWorkerActions(new ISwingWorkerActions(){

                        @Override
                        public void before() {
                            
                        }

                        @Override
                        public Object doinbackground() {
                            
                            try{
                                
                                //Load the warehouses existences
                                final ProductsWorkbook ProductsWorkbook = new ProductsWorkbook();
                                ProductsWorkbook.setFilePath(absolutePath + "\\" + fileName);                    
                                ProductsWorkbook.setOnFinish(() -> {

                                    
                                });
                                ProductsWorkbook.setOnCellRender((Object CellModel) -> {
                                    try{

                                        //Cast model
                                        final ProductExcelRowModel ProductExcelRowModel = (ProductExcelRowModel)CellModel;

                                        //Get values
                                        final String code = ProductExcelRowModel.getCode();
                                        final String description = ProductExcelRowModel.getDescription();
                                        final String nombre = ProductExcelRowModel.getNombre();
                                        final String satCode = ProductExcelRowModel.getSatCode();
                                        final String information = ProductExcelRowModel.getInformation();

                                        //Get the product
                                        Product Product = (Product)RepositoryFactory.getInstance().getProductsRepository().getByCode(code);
                                        
                                        //If doesnt exist create instance
                                        boolean newOne = false;
                                        if(Product==null){
                                            Product = new Product();
                                            newOne = true;
                                        }

                                        //Create the model
                                        Product.setCode(code);
                                        Product.setDescription(description);
                                        Product.setName(nombre);
                                        Product.setKeySAT(satCode);
                                        Product.setInformation(information);

                                        //If not exists save it
                                        if(newOne){
                                            RepositoryFactory.getInstance().getProductsRepository().save(Product);
                                        }
                                        else{ //Update it
                                            RepositoryFactory.getInstance().getProductsRepository().update(Product);
                                        }

                                    }catch (Exception ex) {
                                        LoggerUtility.getSingleton().logError(PrincipViewController.class, ex);
                                        try {
                                            DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
                                        } catch (Exception ex1) {
                                            Logger.getLogger(PrincipViewController.class.getName()).log(Level.SEVERE, null, ex1);
                                        }
                                    }
                                });
                                ProductsWorkbook.load();

                            }catch (Exception ex) {
                                LoggerUtility.getSingleton().logError(PrincipViewController.class, ex);
                                try {
                                    DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
                                } catch (Exception ex1) {
                                    Logger.getLogger(PrincipViewController.class.getName()).log(Level.SEVERE, null, ex1);
                                }
                            }
                            
                            return null;
                        }

                        @Override
                        public void after(Object Object) {
                            
                            try{

                                //Announce success to the user
                                DialogsFactory.getSingleton().showOKOperationCompletedCallbackDialog(jFrame, null);

                            }catch (Exception ex) {
                                LoggerUtility.getSingleton().logError(PrincipViewController.class, ex);
                                try {
                                    DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
                                } catch (Exception ex1) {
                                    Logger.getLogger(PrincipViewController.class.getName()).log(Level.SEVERE, null, ex1);
                                }
                            }
                        }
                        
                    });
                    BaseSwingWorker.execute();

                }catch (Exception ex) {
                    LoggerUtility.getSingleton().logError(PrincipViewController.class, ex);
                    try {
                        DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
                    } catch (Exception ex1) {
                        Logger.getLogger(PrincipViewController.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                }
            });
            
        }catch (Exception ex) {
            LoggerUtility.getSingleton().logError(PrincipViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(PrincipViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    private void loadCustomersFromExcel(String absolutePath, String fileName){
        
        try{
            
            //Question if really continue
            DialogsFactory.getSingleton().showQuestionContinueDialog(baseJFrame, (JFrame jFrame) -> {
            
                try{
                    
                    final BaseSwingWorker BaseSwingWorker = new BaseSwingWorker();
                    BaseSwingWorker.setShowLoading(baseJFrame);
                    BaseSwingWorker.setISwingWorkerActions(new ISwingWorkerActions(){

                        @Override
                        public void before() {
                            
                        }

                        @Override
                        public Object doinbackground() {
                            
                            try{
                                
                                //Load the warehouses existences
                                final CustomersWorkbook CustomersWorkbook = new CustomersWorkbook();
                                CustomersWorkbook.setFilePath(absolutePath + "\\" + fileName);                    
                                CustomersWorkbook.setOnFinish(() -> {

                                    
                                });
                                CustomersWorkbook.setOnCellRender((Object CellModel) -> {
                                    try{

                                        //Cast model
                                        final CustomerExcelRowModel CustomerExcelRowModel = (CustomerExcelRowModel)CellModel;

                                        //Get values
                                        final String companyCode = CustomerExcelRowModel.getCompanyCode();
                                        final String name = CustomerExcelRowModel.getName();
                                        final String RFC = CustomerExcelRowModel.getRfc();
                                        final String phone = CustomerExcelRowModel.getPhone();
                                        final String lada = CustomerExcelRowModel.getLada();
                                        final String cellphone = CustomerExcelRowModel.getCellphone();
                                        final String email = CustomerExcelRowModel.getEmail();
                                        final String city = CustomerExcelRowModel.getCity();
                                        final String estate = CustomerExcelRowModel.getEstate();
                                        final String country = CustomerExcelRowModel.getCountry();
                                        final String street = CustomerExcelRowModel.getStreet();
                                        final String colony = CustomerExcelRowModel.getColony();
                                        final String interiorNumber = CustomerExcelRowModel.getInteriorNumber();
                                        final String externalNumber = CustomerExcelRowModel.getExternalNumber();
                                        final String webpage = CustomerExcelRowModel.getWebpage();
                                        final String observations = CustomerExcelRowModel.getObservations();

                                        //Get the customer from the db
                                        Company Company = RepositoryFactory.getInstance().getCompanysRepository().getCustomerByCode(companyCode);
                                        
                                        boolean newCompany = false;
                                        if(Company==null){
                                            newCompany = true;
                                            Company = new Company();
                                            Company.setCompanyCode(companyCode);
                                        }                                        
                                               
                                        Company.setRFC(RFC);
                                        Company.setNom(name);
                                        Company.setTel(phone);
                                        Company.setLada(lada);
                                        Company.setCel(cellphone);
                                        Company.setCo1(email);
                                        Company.setCiu(city);
                                        Company.setEstad(estate);
                                        Company.setPai(country);
                                        Company.setCalle(street);
                                        Company.setCol(colony);
                                        Company.setNoint(interiorNumber);
                                        Company.setNoext(externalNumber);
                                        Company.setPagweb1(webpage);
                                        Company.setObserv(observations);
                                        
                                        if(newCompany){
                                            
                                            //Save the new comany
                                            RepositoryFactory.getInstance().getCompanysRepository().save(Company);
                                        }
                                        else{
                                            
                                            //Update the existing company
                                            RepositoryFactory.getInstance().getCompanysRepository().update(Company);
                                        }                                       

                                    }catch (Exception ex) {
                                        LoggerUtility.getSingleton().logError(PrincipViewController.class, ex);
                                        try {
                                            DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
                                        } catch (Exception ex1) {
                                            Logger.getLogger(PrincipViewController.class.getName()).log(Level.SEVERE, null, ex1);
                                        }
                                    }
                                });
                                CustomersWorkbook.load();

                            }catch (Exception ex) {
                                LoggerUtility.getSingleton().logError(PrincipViewController.class, ex);
                                try {
                                    DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
                                } catch (Exception ex1) {
                                    Logger.getLogger(PrincipViewController.class.getName()).log(Level.SEVERE, null, ex1);
                                }
                            }
                            
                            return null;
                        }

                        @Override
                        public void after(Object Object) {
                            
                            try{

                                //Announce success to the user
                                DialogsFactory.getSingleton().showOKOperationCompletedCallbackDialog(jFrame, null);

                            }catch (Exception ex) {
                                LoggerUtility.getSingleton().logError(PrincipViewController.class, ex);
                                try {
                                    DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
                                } catch (Exception ex1) {
                                    Logger.getLogger(PrincipViewController.class.getName()).log(Level.SEVERE, null, ex1);
                                }
                            }
                        }
                        
                    });
                    BaseSwingWorker.execute();

                }catch (Exception ex) {
                    LoggerUtility.getSingleton().logError(PrincipViewController.class, ex);
                    try {
                        DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
                    } catch (Exception ex1) {
                        Logger.getLogger(PrincipViewController.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                }
            });
            
        }catch (Exception ex) {
            LoggerUtility.getSingleton().logError(PrincipViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(PrincipViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    private void loadSuppliersFromExcel(String absolutePath, String fileName){
        
        try{
            
            //Question if really continue
            DialogsFactory.getSingleton().showQuestionContinueDialog(baseJFrame, (JFrame jFrame) -> {
            
                try{
                    
                    final BaseSwingWorker BaseSwingWorker = new BaseSwingWorker();
                    BaseSwingWorker.setShowLoading(baseJFrame);
                    BaseSwingWorker.setISwingWorkerActions(new ISwingWorkerActions(){

                        @Override
                        public void before() {
                            
                        }

                        @Override
                        public Object doinbackground() {
                            
                            try{
                                
                                //Load the warehouses existences
                                final SuppliersWorkbook SuppliersWorkbook = new SuppliersWorkbook();
                                SuppliersWorkbook.setFilePath(absolutePath + "\\" + fileName);                    
                                SuppliersWorkbook.setOnFinish(() -> {

                                    
                                });
                                SuppliersWorkbook.setOnCellRender((Object CellModel) -> {
                                    try{

                                        //Cast model
                                        final SupplierExcelRowModel SupplierExcelRowModel = (SupplierExcelRowModel)CellModel;

                                        //Get values
                                        final String supplierCode = SupplierExcelRowModel.getCode();
                                        final String serie = SupplierExcelRowModel.getSerie();
                                        final String name = SupplierExcelRowModel.getName();
                                        final String phone = SupplierExcelRowModel.getPhone();
                                        final String RFC = SupplierExcelRowModel.getRfc();
                                        final String lada = SupplierExcelRowModel.getLada();
                                        final String cellphone = SupplierExcelRowModel.getCellphone();
                                        final String email = SupplierExcelRowModel.getEmail();
                                        final String city = SupplierExcelRowModel.getCity();
                                        final String estate = SupplierExcelRowModel.getEstate();
                                        final String country = SupplierExcelRowModel.getCountry();
                                        final String street = SupplierExcelRowModel.getStreet();
                                        final String colony = SupplierExcelRowModel.getColony();
                                        final String interiorNumber = SupplierExcelRowModel.getInteriorNumber();
                                        final String externalNumber = SupplierExcelRowModel.getExternalNumber();
                                        final String webpage = SupplierExcelRowModel.getWebpage();
                                        final String observations = SupplierExcelRowModel.getObservations();

                                        //Get the customer from the db
                                        Supplier Supplier = (Supplier)RepositoryFactory.getInstance().getSuppliersRepository().getByCode(supplierCode);
                                        
                                        boolean newSupplier = false;
                                        if(Supplier==null){
                                            newSupplier = true;
                                            Supplier = new Supplier();
                                            Supplier.setCode(supplierCode);
                                            Supplier.setSerie(serie);
                                        }                                        
                                                
                                        Supplier.setRfc(RFC);
                                        Supplier.setName(name);
                                        Supplier.setPhone(phone);
                                        Supplier.setLada(lada);
                                        Supplier.setCelphone(cellphone);
                                        Supplier.setEmail1(email);
                                        Supplier.setCity(city);
                                        Supplier.setEstate(estate);
                                        Supplier.setCountry(country);
                                        Supplier.setStreet(street);
                                        Supplier.setColony(colony);
                                        Supplier.setInteriorNumber(interiorNumber);
                                        Supplier.setExternalNumber(externalNumber);
                                        Supplier.setWebpage1(webpage);
                                        Supplier.setObservations(observations);
                                        
                                        if(newSupplier){
                                            
                                            //Save the new record
                                            RepositoryFactory.getInstance().getSuppliersRepository().save(Supplier);
                                        }
                                        else{
                                            
                                            //Update the existing record
                                            RepositoryFactory.getInstance().getSuppliersRepository().update(Supplier);
                                        }                                       

                                    }catch (Exception ex) {
                                        LoggerUtility.getSingleton().logError(PrincipViewController.class, ex);
                                        try {
                                            DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
                                        } catch (Exception ex1) {
                                            Logger.getLogger(PrincipViewController.class.getName()).log(Level.SEVERE, null, ex1);
                                        }
                                    }
                                });
                                SuppliersWorkbook.load();

                            }catch (Exception ex) {
                                LoggerUtility.getSingleton().logError(PrincipViewController.class, ex);
                                try {
                                    DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
                                } catch (Exception ex1) {
                                    Logger.getLogger(PrincipViewController.class.getName()).log(Level.SEVERE, null, ex1);
                                }
                            }
                            
                            return null;
                        }

                        @Override
                        public void after(Object Object) {
                            
                            try{

                                //Announce success to the user
                                DialogsFactory.getSingleton().showOKOperationCompletedCallbackDialog(jFrame, null);

                            }catch (Exception ex) {
                                LoggerUtility.getSingleton().logError(PrincipViewController.class, ex);
                                try {
                                    DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
                                } catch (Exception ex1) {
                                    Logger.getLogger(PrincipViewController.class.getName()).log(Level.SEVERE, null, ex1);
                                }
                            }
                        }
                        
                    });
                    BaseSwingWorker.execute();

                }catch (Exception ex) {
                    LoggerUtility.getSingleton().logError(PrincipViewController.class, ex);
                    try {
                        DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
                    } catch (Exception ex1) {
                        Logger.getLogger(PrincipViewController.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                }
            });
            
        }catch (Exception ex) {
            LoggerUtility.getSingleton().logError(PrincipViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(PrincipViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    private void jMImpCliensActionPerformed(java.awt.event.ActionEvent evt) {        

        try{
            
            try{
             
                //Ask for the excel file path
                final FileChooserUtility FileChooserUtility = UtilitiesFactory.getSingleton().getFileChooserUtility();
                FileChooserUtility.addValidExtension("xlsx");
                FileChooserUtility.addValidExtension("xls");
                FileChooserUtility.setFileNameMatch("Catalogo de clientes.xlsx");
                FileChooserUtility.setIApproveOpption((String absolutePath, String fileName) -> {
                    loadCustomersFromExcel(absolutePath,fileName);
                });
                FileChooserUtility.showSaveDialog(baseJFrame);
                            
            }catch(InvalidFileExtensionException InvalidFileExtensionException){
                DialogsFactory.getSingleton().showErrorOKCallbackDialog(baseJFrame, "errors_invalid_file_extension", null);
            }
            catch(FilenameDontMatchException FilenameDontMatchException){
                DialogsFactory.getSingleton().showErrorOKCallbackDialog(baseJFrame, FilenameDontMatchException.getMessage(), null);
            }
                        
        }catch (Exception ex) {
            LoggerUtility.getSingleton().logError(PrincipViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(PrincipViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    private void jMImpProvsActionPerformed(java.awt.event.ActionEvent evt) {        

        try{
            
            try{
             
                //Ask for the excel file path
                final FileChooserUtility FileChooserUtility = UtilitiesFactory.getSingleton().getFileChooserUtility();
                FileChooserUtility.addValidExtension("xlsx");
                FileChooserUtility.addValidExtension("xls");
                FileChooserUtility.setFileNameMatch(com.era.Constants.FILENAME_EXCEL_IMPORT_SUPPLIERS);
                FileChooserUtility.setIApproveOpption((String absolutePath, String fileName) -> {
                    loadSuppliersFromExcel(absolutePath,fileName);
                });
                FileChooserUtility.showSaveDialog(baseJFrame);
            
            }catch(InvalidFileExtensionException InvalidFileExtensionException){
                DialogsFactory.getSingleton().showErrorOKCallbackDialog(baseJFrame, "errors_invalid_file_extension", null);
            }
            catch(FilenameDontMatchException FilenameDontMatchException){
                DialogsFactory.getSingleton().showErrorOKCallbackDialog(baseJFrame, FilenameDontMatchException.getMessage(), null);
            }
                        
        }catch (Exception ex) {
            LoggerUtility.getSingleton().logError(PrincipViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(PrincipViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    private void jMImpExistAlmActionPerformed(java.awt.event.ActionEvent evt) {        
        
        try{
         
            try{
             
                //Ask for the excel file path
                final FileChooserUtility FileChooserUtility = UtilitiesFactory.getSingleton().getFileChooserUtility();
                FileChooserUtility.addValidExtension("xlsx");
                FileChooserUtility.addValidExtension("xls");            
                FileChooserUtility.setIApproveOpption((String absolutePath, String fileName) -> {
                    loadWarehousesExistencesFromExcel(absolutePath,fileName);
                });
                FileChooserUtility.showSaveDialog(baseJFrame);
            
            }catch(InvalidFileExtensionException InvalidFileExtensionException){
                DialogsFactory.getSingleton().showErrorOKCallbackDialog(baseJFrame, "errors_invalid_file_extension", null);
            }
            
        }catch (Exception ex) {
            LoggerUtility.getSingleton().logError(PrincipViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(PrincipViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        
    }
    private void warehousesMenuActionPerformed(java.awt.event.ActionEvent evt) {        
        ViewControlersFactory.getSingleton().getAlmasViewController().setVisible();
    }
    private void jMActivoActionPerformed(java.awt.event.ActionEvent evt) {        
        ViewControlersFactory.getSingleton().getActivosViewController().setVisible();
    }
    private void clasificationsMenuActionPerformed(java.awt.event.ActionEvent evt) {        
        ViewControlersFactory.getSingleton().getGeneralCatalogsViewController().setVisible();
    }
    private void reportsMenuActionPerformed(java.awt.event.ActionEvent evt) {        
        ViewControlersFactory.getSingleton().getReportsViewController().setVisible();
    }
    
    @Override
    public void clearFields() throws Exception{
    }
    
    private void jMenItEstacsActionPerformed(java.awt.event.ActionEvent evt) {        
        ViewControlersFactory.getSingleton().getUsrsViewController().setVisible();
    }
        
    private void linesMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
        
        try {
            ViewControlersFactory.getSingleton().getLinesViewController().setVisible();
        } catch (Exception ex) {
            LoggerUtility.getSingleton().logError(this.getClass(), ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    private void importKitsMenItemActionPerformed(java.awt.event.ActionEvent evt) {
    
        try{
         
            try{
             
                //Ask for the excel file path
                final ExcelFileChooserUtility ExcelFileChooserUtility = UtilitiesFactory.getSingleton().getExcelFileChooserUtility();
                ExcelFileChooserUtility.setFileNameMatch(com.era.Constants.FILENAME_EXCEL_IMPORT_KITS);
                ExcelFileChooserUtility.setIApproveOpption((String absolutePath, String fileName) -> {
                    loadKitsFromExcel(absolutePath,fileName);
                });
                ExcelFileChooserUtility.showSaveDialog(baseJFrame);
            
            }catch(InvalidFileExtensionException InvalidFileExtensionException){
                DialogsFactory.getSingleton().showErrorOKCallbackDialog(baseJFrame, "errors_invalid_file_extension", null);
            }
            
        }catch (Exception ex) {
            LoggerUtility.getSingleton().logError(PrincipViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(PrincipViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
        
    private void jMenIt4ActionPerformed(java.awt.event.ActionEvent evt) {
        ViewControlersFactory.getSingleton().getCorrElecsViewController().setVisible();
    }
    
    private void jMenItCambClavSegActionPerformed(java.awt.event.ActionEvent evt) {                                                  
               
        /*Mostrar el gráfico de cambiar clave de seguridad 1*/
        //ClavCamb c = new ClavCamb(null, true);
        //c.getObj().setVisible(true);
        
    }
        
    private void jMInvenImpoActionPerformed(java.awt.event.ActionEvent evt) {                                         
        
        try{
         
            try{
             
                //Ask for the excel file path
                final ExcelFileChooserUtility ExcelFileChooserUtility = UtilitiesFactory.getSingleton().getExcelFileChooserUtility();
                ExcelFileChooserUtility.setFileNameMatch(com.era.Constants.FILENAME_EXCEL_IMPORT_PRODUCTS);
                ExcelFileChooserUtility.setIApproveOpption((String absolutePath, String fileName) -> {
                    loadProductsFromExcel(absolutePath,fileName);
                });
                ExcelFileChooserUtility.showSaveDialog(baseJFrame);
            
            }catch(InvalidFileExtensionException InvalidFileExtensionException){
                DialogsFactory.getSingleton().showErrorOKCallbackDialog(baseJFrame, "errors_invalid_file_extension", null);
            }
            
        }catch (Exception ex) {
            LoggerUtility.getSingleton().logError(PrincipViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(PrincipViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
            
    private void jMMClienActionPerformed(java.awt.event.ActionEvent evt) {                                         
        ViewControlersFactory.getSingleton().getClientsViewController().setVisible();
    }
    
    private void jMenItManProvsActionPerformed(java.awt.event.ActionEvent evt) {                                               
        ViewControlersFactory.getSingleton().getProvsViewController().setVisible();        
    }
    
    private void jMenItPermEstacsActionPerformed(java.awt.event.ActionEvent evt) {                                                 

        /*Muestra el módulo de permisos de usuarios*/
        //PermsEstacs p = new PermsEstacs();
        //p.setVisible(true);        
    }
    
    private void jBProvsActionPerformed(java.awt.event.ActionEvent evt) {                                             
        ViewControlersFactory.getSingleton().getProvsViewController().setVisible();
    }
    
    private void jMenItLogearActionPerformed(java.awt.event.ActionEvent evt) {                                             
        ViewControlersFactory.getSingleton().getLoginOtraViewController().setVisible();
        
    }
     
    private void jMenItSalActionPerformed(java.awt.event.ActionEvent evt) {                                          
        
        try{
            
            vExiAp();
            
        }
        catch (Exception ex) {
            LoggerUtility.getSingleton().logError(PrincipViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(PrincipViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    /*Función para cuando se tiene que salir de la aplicación*/
    private void vExiAp() throws Exception {
        
        /*Pregunta al usr si esta seguro de salir de la aplicación*/
        final QuestionDialog QuestionDialog = DialogsFactory.getSingleton().getQuestionDialog(baseJFrame);
        QuestionDialog.setPropertyText("question_exit_app");
        QuestionDialog.setOKDialogInterface((JFrame jFrame) -> {
            
            //Sal del sistema
            System.exit(0);
        });
        QuestionDialog.show();
    }
    
    private void jMenItModBDActionPerformed(java.awt.event.ActionEvent evt) {                                            

        /*Llamar al formulario de configuración*/
        //BDs b = new BDs();
        //b.setVisible(true);
    }
    
    private void jMenItRespsActionPerformed(java.awt.event.ActionEvent evt) {                                            
        
        /*Abre el formulario de respaldos*/
        //Resps r = new Resps();
        //r.setVisible(true);        
    }
    
    private void jMenItCompsActionPerformed(java.awt.event.ActionEvent evt) {                                            
        ViewControlersFactory.getSingleton().getComprViewController().setVisible();
    }
    
    private void jMenCotsTActionPerformed(java.awt.event.ActionEvent evt) {                                          
        ViewControlersFactory.getSingleton().getCotsViewController().setVisible();
    }
    
    private void jMenItVtasActionPerformed(java.awt.event.ActionEvent evt) {
        
        try {
         
            final VtasViewController VtasViewController = ViewControlersFactory.getSingleton().getVtasViewController();
            VtasViewController.setDocumentType(DocumentType.SALES);
            VtasViewController.setVisible();
            
        } catch (Exception ex) {
            LoggerUtility.getSingleton().logError(this.getClass(), ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    private void vAbrPto()
    {
        try{
            
            final String ptovtaAlmacen = RepositoryFactory.getInstance().getConfgralRepository().getPtovtaAlmacen();

            /*Si el almacén no exsite entonces*/
            if(ptovtaAlmacen==null)
            {
                final OKDialog OKDialog = DialogsFactory.getSingleton().getOKDialog(baseJFrame);
                OKDialog.setPropertyText("ptoalmacen_not_exists");
                OKDialog.show();
                return;
            }

            //Open the window
            ViewControlersFactory.getSingleton().getPtoVtaTouViewController().setVisible();
        }
        catch (Exception ex) {
            LoggerUtility.getSingleton().logError(PrincipViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(PrincipViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    private void jMenItTouchActionPerformed(java.awt.event.ActionEvent evt) {
        vAbrPto();
    }
    
    private void jMenItConcepsActionPerformed(java.awt.event.ActionEvent evt) {
        ViewControlersFactory.getSingleton().getConceptosPagoViewController().setVisible();
    }
    
    private void jMeItImpsActionPerformed(java.awt.event.ActionEvent evt) {                                          
        ViewControlersFactory.getSingleton().getImpsViewController().setVisible();
    }
    
    private void jMenItLugsActionPerformed(java.awt.event.ActionEvent evt) {                                           

        /*Muestra el formulario de lugares*/
        //cats.PlanGralCat l = new cats.PlanGralCat("lugs","prods","lug","lugar","lugs","cod");
        //l.setVisible(true);

    }
    
    private void jMenItMedsActionPerformed(java.awt.event.ActionEvent evt) {                                           

        /*Muestra el formulario de medidas*/
        //cats.PlanGralCat f = new cats.PlanGralCat("meds","Prods","codmed","medida","med","cod");
        //f.setVisible(true);
    }
    
    private void jMenItMonsActionPerformed(java.awt.event.ActionEvent evt) {                                           
        ViewControlersFactory.getSingleton().getMonsViewController().setVisible();
    }
    
    private void jMenItAlmasActionPerformed(java.awt.event.ActionEvent evt) {                                            
        ViewControlersFactory.getSingleton().getAlmasViewController().setVisible();
    }
    
    private void jMenItUnidsActionPerformed(java.awt.event.ActionEvent evt) {                                            

        //Unidades catUnidades = new Unidades();
        //catUnidades.setVisible(true);
    }
    
    private void jMenItPesosActionPerformed(java.awt.event.ActionEvent evt) {                                            

        /*Muestra el formulario de pesos*/
        //cats.PlanGralCat p = new cats.PlanGralCat("Pes","Prods","Pes","peso","pes","cod");
        //p.setVisible(true);

    }
    
    private void jMenItColsActionPerformed(java.awt.event.ActionEvent evt) {                                           

        /*Muestra la forma para los colores*/
        //cats.PlanGralCat c = new cats.PlanGralCat("Colos","Prods","Colo","color","Colo","cod");
        //c.setVisible(true);
    }
    
    private void jMenItFabsActionPerformed(java.awt.event.ActionEvent evt) {                                           

        /*Muestra el formulario de fabricantes*/
        //cats.PlanGralCat f = new cats.PlanGralCat("Fabs","Prods","Fab","fabricante","FabS","cod");
        //f.setVisible(true);

    }
    
    private void jMenItMarcsActionPerformed(java.awt.event.ActionEvent evt) {                                            

        /*Muestra el formulario de marcas*/
        //cats.PlanGralCat m = new cats.PlanGralCat("Marcs","Prods","Marc","marca","Marc","cod");
        //m.setVisible(true);
    }
    
    private void jMenIt1ActionPerformed(java.awt.event.ActionEvent evt) {                                        

        /*Muestra la froma de las líneas*/
        //cats.PlanGralCat l = new cats.PlanGralCat("lins","Prods","lin","linea","lins","cod");
        //l.setVisible(true);
    }
    
    private void jMVProdActionPerformed(java.awt.event.ActionEvent evt) {
        ViewControlersFactory.getSingleton().getProdsViewController().setVisible();
    }
    
    private void jMenItProdsBajMinActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        ViewControlersFactory.getSingleton().getBajsMinViewController().setVisible();
    }
    
    private void jMenItDefEstacsActionPerformed(java.awt.event.ActionEvent evt) {                                                
        ViewControlersFactory.getSingleton().getMaxsMinsViewController().setVisible();
    }
    
    
    private void jMenItKitsActionPerformed(java.awt.event.ActionEvent evt) {                                           
        ViewControlersFactory.getSingleton().getKitsViewController().setVisible();
    }
    
    private void jMenItProdsArrMaxActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        ViewControlersFactory.getSingleton().getAltsMaxsViewController().setVisible();
    }
    
    private void jMenItTraspasActionPerformed(java.awt.event.ActionEvent evt) {
        ViewControlersFactory.getSingleton().getTraspasViewController().setVisible();        
    }
    
    private void jMenItIngrActionPerformed(java.awt.event.ActionEvent evt) {                                           
        ViewControlersFactory.getSingleton().getEntradasSalidasViewController().setVisible();
    }
    
    private void jMenItDatsGenEmpActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        
        try{
            
            ViewControlersFactory.getSingleton().getEmpresasViewController().setVisible();
            
        }catch(Exception ex){
            
            try {
                
                LoggerUtility.getSingleton().logError(LoginViewController.class, ex);
                
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
                
            } catch (Exception ex1) {
                Logger.getLogger(LoginViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    private void jMenItLogCorrActionPerformed(java.awt.event.ActionEvent evt) {                                              
        ViewControlersFactory.getSingleton().getLogCorrsViewController().setVisible();
        
    }
    
    private void jMenItTipsPagsActionPerformed(java.awt.event.ActionEvent evt) {
        ViewControlersFactory.getSingleton().getTipsPagsViewController().setVisible();
    }
    
    private void jMenItImpresActionPerformed(java.awt.event.ActionEvent evt) {                                             
        ViewControlersFactory.getSingleton().getImpresViewController().setVisible();
    }
    
    private void jMVLogSysActionPerformed(java.awt.event.ActionEvent evt) {                                          
                
        try{
            
            if(UtilitiesFactory.getSingleton().getFilesUtility().logFileExists())
            {                                                
                if(UtilitiesFactory.getSingleton().getDesktopUtility().isSupported())
                {   
                    //Open the file in edit app of the system
                    final String logFilePath = UtilitiesFactory.getSingleton().getFilesUtility().getLogFilePath();                
                    UtilitiesFactory.getSingleton().getDesktopUtility().edit(logFilePath);
                } 
                else 
                {
                    //Mensajea
                    final ErrorOKDialog ErrorOKDialog = DialogsFactory.getSingleton().getErrorOKDialog(baseJFrame);
                    ErrorOKDialog.setPropertyText("errors_desktop_not_supported");
                    ErrorOKDialog.show();
                }
            }
            else{
                
                DialogsFactory.getSingleton().showOKDialog(baseJFrame, "errors_file_not_exists");
            }
            
        }catch(Exception e){
            
            LoggerUtility.getSingleton().logError(LoginViewController.class, e);
                                        
            try {
                final ExceptionDialog ExceptionDialog = DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, e);
                ExceptionDialog.show();
            } catch (Exception ex) {
                Logger.getLogger(LoginViewController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private void jMConfAdActionPerformed(java.awt.event.ActionEvent evt) {
        ViewControlersFactory.getSingleton().getConfGralViewController().setVisible();
    }
    
    private void jMCXCActionPerformed(java.awt.event.ActionEvent evt) {
        ViewControlersFactory.getSingleton().getCxcViewController().setVisible();
    }
    
    private void jMCXPActionPerformed(java.awt.event.ActionEvent evt) {
        ViewControlersFactory.getSingleton().getCxpViewController().setVisible();
        
    }
    
    private void jMContraActionPerformed(java.awt.event.ActionEvent evt) {
        
        /*Muestra la forma para ver los contrarecibos*/
        //Contras c = new Contras();
        //c.setVisible(true);        
    }
    
    private void jMenConfigFilActionPerformed(java.awt.event.ActionEvent evt) {                                              
        
        //Open the configuration to database screen
        final DBFileConnectionConfigurationController DBFileConnectionConfigurationController = new DBFileConnectionConfigurationController();
        DBFileConnectionConfigurationController.setDBFileConnectionConfigurationType(DBFileConnectionConfigurationType.UPDATE);
        DBFileConnectionConfigurationController.setVisible();
    }
    
    private void jMenCatGralActionPerformed(java.awt.event.ActionEvent evt) {                                            

        /*Muestra la forma del catálogo general*/
        //cats.PlanGralCat l = new cats.PlanGralCat("grals","prods","anaq","concepto general","CatGral","cod");
        //l.setVisible(true);
        
    }
    
    private void jMenItDeslogActionPerformed(java.awt.event.ActionEvent evt) {                                             
        
        //Close the current window
        dispose();
        
        //Open the login screen as login        
        final LoginOtraViewController LoginOtraViewController = ViewControlersFactory.getSingleton().getLoginOtraViewController();
        LoginOtraViewController.setLoginType(LoginType.DESLOGIN);
        LoginOtraViewController.setVisible();
    }
    
    private void jMenItCamEmpActionPerformed(java.awt.event.ActionEvent evt) {                                             
        
        //Show login company window
        final LoginViewController LoginViewController = ViewControlersFactory.getSingleton().getLoginViewController();
        LoginViewController.setLoginTypeEmpresa(LoginTypeEmpresa.ANOTHER_LOGIN);
        LoginViewController.setVisible();
    }
    
    private void jMenCXCRActionPerformed(java.awt.event.ActionEvent evt) {                                         
        
        /*Muestra la forma para reportear CXC*/
        //RepCXC r = new RepCXC();
        //r.setVisible(true);
        
    }
    
    private void jMenCXPActionPerformed(java.awt.event.ActionEvent evt) {                                        
        
        /*Muestra la forma para ver reportes de CXP*/
        //RepCXP r = new RepCXP();
        //r.setVisible(true);
    }
    
    private void jMenVtasRActionPerformed(java.awt.event.ActionEvent evt) {                                          
        
        /*Muestra la forma para reportear las ventas*/
        //RepVtas t = new RepVtas();
        //t.setVisible(true);        
    }
    
    private void jMenProdsActionPerformed(java.awt.event.ActionEvent evt) {                                          
        
        /*Muestra el reporteador de productos*/
        //RepProds r = new RepProds()
        //r.setVisible(true);
        
    }
    
    private void jMDelLogActionPerformed(java.awt.event.ActionEvent evt) {                                         
        
        try{
            
            //Question if continue
            final QuestionDialog QuestionDialog = DialogsFactory.getSingleton().getQuestionDialog(baseJFrame);
            QuestionDialog.setPropertyText("question_delete_log_file");
            QuestionDialog.setOKDialogInterface((JFrame jFrame) -> {
                
                try{
                 
                    UtilitiesFactory.getSingleton().getFilesUtility().resetLogFile();

                    final OKDialog OKDialog = DialogsFactory.getSingleton().getOKDialog(baseJFrame);
                    OKDialog.setPropertyText("log_file_reset");
                    OKDialog.show();
                    
                }catch(Exception e){
            
                    LoggerUtility.getSingleton().logError(LoginViewController.class, e);

                    try {
                        final ExceptionDialog ExceptionDialog = DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, e);
                        ExceptionDialog.show();
                    } catch (Exception ex) {
                        Logger.getLogger(LoginViewController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
            QuestionDialog.show();
            
        }catch(Exception e){
            
            LoggerUtility.getSingleton().logError(LoginViewController.class, e);
                                        
            try {
                final ExceptionDialog ExceptionDialog = DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, e);
                ExceptionDialog.show();
            } catch (Exception ex) {
                Logger.getLogger(LoginViewController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private void jMClasProdActionPerformed(java.awt.event.ActionEvent evt) {                                           
        
        /*Muestra la forma de clasificación de productos*/
        //cats.ClasExtProd c = new cats.ClasExtProd();
        //c.setVisible(true);
        
    }
    
    private void jMUbiAdActionPerformed(java.awt.event.ActionEvent evt) {                                        
        
        /*Muestra la forma para las ubicaciones adicionales*/
        //UbiAd a = new UbiAd();
        //a.setVisible(true);
        
    }
    
    private void jMUsrActionPerformed(java.awt.event.ActionEvent evt) {                                      

        /*Muestra la forma para mostrar los usuarios conectados*/
        //UsrCon c = new UsrCon();
        //c.setVisible(true);
        
    }
    
    private void jMEstacsActionPerformed(java.awt.event.ActionEvent evt) {                                         
                        
        /*Muestra la forma para ver el reporte de las usuarios*/
        //RepEstac r = new RepEstac();
        //r.setVisible(true);
        
    }
    
    private void jMLogProdActionPerformed(java.awt.event.ActionEvent evt) {
        ViewControlersFactory.getSingleton().getGeneralLogsViewController().setVisible();
    }
    private void jMLogKActionPerformed(java.awt.event.ActionEvent evt) {                                       
        
        /*Muestra la forma para ver el log de kits*/
        //LogKit k = new LogKit();
        //k.setVisible(true);
        
    }
    
    private void jMLogLinActionPerformed(java.awt.event.ActionEvent evt) {                                         
       
        /*Muestra la forma para ver los logs de líneas*/        
        //LogGral l = new LogGral("Log líneas", "loglins", "descrip");
        //l.setVisible(true);
        
    }
    
    private void jMLogMarcActionPerformed(java.awt.event.ActionEvent evt) {                                          
        
        /*Muestra la forma para ver el log de marcas*/
        //LogGral l = new LogGral("Log marcas", "logmarc", "descrip");
        //l.setVisible(true);
        
    }
    
    private void jMLogFabActionPerformed(java.awt.event.ActionEvent evt) {                                         
        
        /*Muestra la forma para ver los logs de los fabricantes*/
        //LogGral l = new LogGral("Log fabricantes", "logfabs", "descrip");
        //l.setVisible(true);
        
    }
    
    private void jMLogColoActionPerformed(java.awt.event.ActionEvent evt) {                                          
                
        /*Muestra la forma para ver el log de los colores*/
        //LogGral l = new LogGral("Log colores", "logcolo", "descrip");
        //l.setVisible(true);
        
    }
    
    private void jMLogClasActionPerformed(java.awt.event.ActionEvent evt) {                                          
        
        /*Muestra la forma para ver los logs de la clasificación extra de productos*/
        //LogGral l = new LogGral("Log clasificaciones extra", "logclasext", "descrip");
        //l.setVisible(true);
        
    }
    
    private void jMLogPesActionPerformed(java.awt.event.ActionEvent evt) {                                         
        
        /*Muestra la forma para ver el log de los pesos*/
        //LogGral l = new LogGral("Log pesos", "logpes", "descrip");
        //l.setVisible(true);
        
    }
    
    private void jMLogMedActionPerformed(java.awt.event.ActionEvent evt) {                                         
        
        /*Muestra la forma para ver el log de medidas*/
        //LogGral l = new LogGral("Log medidas", "logmed", "descrip");
        //l.setVisible(true);
        
    }
    
    private void jMLogUnidActionPerformed(java.awt.event.ActionEvent evt) {                                          
        
        /*Muestra la forma para ver el log de unidades*/
        //LogGral l = new LogGral("Log unidades", "logunid", "descrip");
        //l.setVisible(true);
        
    }
    
    private void jMLogMonActionPerformed(java.awt.event.ActionEvent evt) {                                         
        
        /*Muestra la forma para ver el log de las monedas*/
        //LogGral l = new LogGral("Log monedas", "logmons", "descrip");
        //l.setVisible(true);
        
    }
    
    private void jMLogImpuActionPerformed(java.awt.event.ActionEvent evt) {                                          
        
        /*Muestra la forma para ver el log de los impuestos*/
        //LogGral l = new LogGral("Log impuestos", "logimpue", "val");
        //l.setVisible(true);
        
    }
    
    private void jMLogConcepActionPerformed(java.awt.event.ActionEvent evt) {                                            
        
        /*Muestra la forma para ver el log de los conceptos*/
        //LogGral l = new LogGral("Log conceptos", "logconcep", "descrip");
        //l.setVisible(true);
        
    }
    
    private void jMLogAlmaActionPerformed(java.awt.event.ActionEvent evt) {                                          
        
        /*Muestra la forma para ver el log de almacenes*/
        //LogGral l = new LogGral("Log almacenes", "logalmas", "descrip");
        //l.setVisible(true);
        
    }
    
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        
        /*Muestra la forma de log de anaqueles*/
        //LogGral l = new LogGral("Log anaqueles", "loganaq", "descrip");
        //l.setVisible(true);
        
    }
    
    private void jMLogLugActionPerformed(java.awt.event.ActionEvent evt) {                                         
        
        /*Muestra la forma de log de lugares*/
        //LogGral l = new LogGral("Log lugares", "loglugs", "descrip");
        //l.setVisible(true);
        
    }
    
    private void jMLogUbiEActionPerformed(java.awt.event.ActionEvent evt) {                                          
        
        /*Muestra la forma de ubicacines adicionales*/
        //LogGral l = new LogGral("Log ubicaciones adicionales", "logubiad", "descrip");
        //l.setVisible(true);
        
    }
      
    private void jMRepCotActionPerformed(java.awt.event.ActionEvent evt) {                                         
        
        /*Muestra la forma para ver el reporteador de cotizaciones*/
        //RepCots c = new RepCots();
        //c.setVisible(true);
        
    }
    
    private void jMCatMsjActionPerformed(java.awt.event.ActionEvent evt) {                                         
        
        /*Muestra la forma para ver el catálogo de mensajes*/
        //CatMsjs c = new CatMsjs();
        //c.setVisible(true);
        
    }
    
    private void formWindowStateChanged(java.awt.event.WindowEvent evt) {                                        
        
        /*Que este máximizado siempre*/
        maximizedWindow();
        
    }
    
    private void jMChatCActionPerformed(java.awt.event.ActionEvent evt) {                                        
        
        /*Muestra la forma de chat corporativo*/
        //ChatC c = new ChatC(false);
        //c.getObj(true).setVisible(true);
        
    }
    
    private void jMChatActionPerformed(java.awt.event.ActionEvent evt) {                                       
               
        /*Muestra la forma de chat*/
        //ChatUsr c = new ChatUsr();
        //c.setVisible(true);
        
    }
    
    private void jBPtoVtaActionPerformed(java.awt.event.ActionEvent evt) {                                         
        vAbrPto();
    }
    
    private void jBVtasActionPerformed(java.awt.event.ActionEvent evt) {                                       
        
        try {
         
            final VtasViewController VtasViewController = ViewControlersFactory.getSingleton().getVtasViewController();
            VtasViewController.setDocumentType(DocumentType.SALES);
            VtasViewController.setVisible();
            
        } catch (Exception ex) {
            LoggerUtility.getSingleton().logError(this.getClass(), ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    private void jBCompsActionPerformed(java.awt.event.ActionEvent evt) {                                        
        ViewControlersFactory.getSingleton().getComprViewController().setVisible();
    }
    
    private void jBEmpsActionPerformed(java.awt.event.ActionEvent evt) {
        ViewControlersFactory.getSingleton().getClientsViewController().setVisible();
    }
    
    private void jBProdsActionPerformed(java.awt.event.ActionEvent evt) {                                        
        ViewControlersFactory.getSingleton().getProdsViewController().setVisible();
    }
    
    private void jBCotsActionPerformed(java.awt.event.ActionEvent evt) {
        ViewControlersFactory.getSingleton().getCotsViewController().setVisible();
        
    }
    
    private void jMRepVendActionPerformed(java.awt.event.ActionEvent evt) {                                          
        
        /*Muestra la forma para ver el reporte de los vendedores*/
        //RepVends r = new RepVends();
        //r.setVisible(true);
        
    }
    
    private void jMAcercActionPerformed(java.awt.event.ActionEvent evt) {
        ViewControlersFactory.getSingleton().getAcerDViewController().setVisible();        
    }
    
    private void jMRepComActionPerformed(java.awt.event.ActionEvent evt) {                                         
        
        /*Muestra la forma de reporte de compras*/
        //RepComT r = new RepComT();
        //r.setVisible(true);
        
    }
    
    private void jMRepOrActionPerformed(java.awt.event.ActionEvent evt) {                                        
        ViewControlersFactory.getSingleton().getCotsViewController().setVisible();
    }
    
    private void formWindowClosing(java.awt.event.WindowEvent evt) {                                   
        
        try{
            
            vExiAp();
        }
        catch (Exception ex) {
            LoggerUtility.getSingleton().logError(PrincipViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(PrincipViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }        
    }
    
    private void jMKardActionPerformed(java.awt.event.ActionEvent evt) {                                       
        
        /*Muestra la forma para el reporteador de kardex*/
        //RepKard k = new RepKard();
        //k.setVisible(true);
        
    }
    
    private void jMCostsActionPerformed(java.awt.event.ActionEvent evt) {                                        
        
        /*Muestra la forma par ver los reportes de costeos*/
        //RepCosts k = new RepCosts();
        //k.setVisible(true);        
    }
    
    private void jMLogResActionPerformed(java.awt.event.ActionEvent evt) {                                         
        
        /*Muestra la forma para ver el log de respaldos*/
        //LogResp l = new LogResp();
        //l.setVisible(true);
        
    }
    
    private void jMRespActionPerformed(java.awt.event.ActionEvent evt) {                                       
        
        /*Muestra la forma para reportear los respaldos*/
        //RepResp r = new RepResp();
        //r.setVisible(true);
    }
    
    private void jMFlujActionPerformed(java.awt.event.ActionEvent evt) {                                       
        
        /*Muestra la forma para reportear el flujo*/
        //report.RepFluj  r = new report.RepFluj();
        //r.setVisible(true);
        
    }
    
    private void jMClasCliActionPerformed(java.awt.event.ActionEvent evt) {                                          
                
        /*Abre la forma para dar de alta las clasificaciones de los clientes*/
        //ClasCli c = new ClasCli();
        //c.setVisible(true);
        
    }
    
    private void jMClasProvActionPerformed(java.awt.event.ActionEvent evt) {                                           
        
        /*Muestra la forma para dar de alta las clasificaciones de los provs*/
        //cats.PlanGralCat l = new cats.PlanGralCat("clasprov","ProVs","codclas","proveedor","clasprov","cod");
        //l.setVisible(true);
        
    }
    
    private void jMRepLogCoActionPerformed(java.awt.event.ActionEvent evt) {                                           
        
        /*Muestra la forma para ver el reporte de los logs de correos*/
        //RepLogCor r = new RepLogCor();
        //r.setVisible(true);
        
    }
    
    private void jMModelActionPerformed(java.awt.event.ActionEvent evt) {                                        
        
        /*Muestra la forma para ver el catálogo de Modelos*/
        //cats.PlanGralCat f = new cats.PlanGralCat("mODEL","Prods","mode","modelo","mod","cod");
        //f.setVisible(true);
        
    }
    
    private void jMTabCompaActionPerformed(java.awt.event.ActionEvent evt) {                                           
        
        /*Muestra la forma para ver la tabla de compatibilidades*/
        //ptovta.TabCompa t = new ptovta.TabCompa();
        //t.setVisible(true);
        
    }
    
    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        
        /*Muestra el formulario de marcas*/
        //cats.PlanGralCat f = new cats.PlanGralCat("Tall","TallColo","tall","talla","tall","cod");
        //f.setVisible(true);
        
    }
    
    private void jMLogModActionPerformed(java.awt.event.ActionEvent evt) {                                         
        
        /*Muestra la forma de log de Modelos*/
        //LogGral l = new LogGral("Log modelos", "logmod", "descrip");
        //l.setVisible(true);
        
    }
    
    private void jMLogTallActionPerformed(java.awt.event.ActionEvent evt) {                                          
        
        /*Muestra la forma de log de Modelos*/
        //LogGral l = new LogGral("Log tallas", "logtall", "descrip");
        //l.setVisible(true);
        
    }
    
    private void jMTallColActionPerformed(java.awt.event.ActionEvent evt) {                                          
        
        /*Muestra la forma para ver las tallas y colores*/
        //TallColo t = new TallColo();
        //t.setVisible(true);
        
    }
    
    private void jMLotPedActionPerformed(java.awt.event.ActionEvent evt) {
        ViewControlersFactory.getSingleton().getLotPedCatViewController().setVisible();
    }
    
    private void jMRepBackOActionPerformed(java.awt.event.ActionEvent evt) {                                           
    
        /*Muestra la forma para reportear el backorder*/
        //RepBack r = new RepBack();
        //r.setVisible(true);
        
    }
    
    private void jMTipActionPerformed(java.awt.event.ActionEvent evt) {                                      
        
        /*Muestra el catálogo de tipos*/
        //cats.PlanGralCat t = new cats.PlanGralCat("Tips","Prods","tip","tipo","Tip","cod");
        //t.setVisible(true);
        
    }
    
    private void jMLogTipActionPerformed(java.awt.event.ActionEvent evt) {                                         
        
        /*Muestra la forma de log de tipos*/
        //LogGral l = new LogGral("Log tipos", "logtip", "descrip");
        //l.setVisible(true);
        
    }
    
    private void jMInvenExporActionPerformed(java.awt.event.ActionEvent evt) {                                             
        
        /*final JFileChooser fc = new JFileChooser();
        fc.setDialogTitle("Exportar productos");
                
        if(fc.showSaveDialog(this) != JFileChooser.APPROVE_OPTION)
            return;
        
        Star.lCargGral = new LoadinGral("Exportando de productos a excel...");
        Star.lCargGral.setVisible(true);

                String sRut = fc.getCurrentDirectory().getAbsolutePath();


                sRut += "\\" + fc.getSelectedFile().getName(); 


                sRut += ".xlsx";

                XSSFWorkbook wkbok = new XSSFWorkbook();


                XSSFSheet sheet = wkbok.createSheet("Productos");


                int         iConta                   = 1;
                
                Connection  con;
                try
                {
                    con = DriverManager.getConnection("jdbc:mysql://" + Star.sInstancia + ":" + Star.sPort + "/" + Star.sBD + "?user=" + Star.sUsuario + "&password=" + Star.sContrasenia );
                }
                catch(SQLException | HeadlessException e)
                {
                
                    if(Star.lCargGral!=null)                        
                        Star.lCargGral.setVisible(false);
                
                    Login.vLog(e.getMessage());

                    JOptionPane.showMessageDialog(null, this.getClass().getName() + " Error por " + e.getMessage(), "Error BD", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource(Star.sRutIconEr)));
                    return;
                }
                
                Map<String, Object[]> data = new TreeMap<>();
                data.put(Integer.toString(iConta), new Object[] {"COD PRODUCTO (1)", "COD PROD OPCIONAL 1 (2)", "COD PROD OPCIONAL 2 (3)", "COD MEDIDA (4)", "MEDIDA (5)", "DESCRIPCION LARGA (6)", "DESCRIPCION CORTA (7)", "COD LINEA Y DESCRIPCIÃ“N (8)", "COD MARCA Y DESCRIPCIÃ“N (9)", "COD FABRICANTE Y DESCRIPCIÃ“N (10)", "COD COLOR Y DESCRIPCIÃ“N(11)", "COD PESO Y DESCRIPCIÃ“N (12)", "PESO (13)", "PRECIO LISTA 1 (14)", "PRECIO LISTA 2 (15)", "PRECIO LISTA 3 (16)", "PRECIO LISTA 4 (17)", "PRECIO LISTA 5 (18)", "PRECIO LISTA 6 (19)", "PRECIO LISTA 7 (20)", "PRECIO LISTA 8 (21)", "PRECIO LISTA 9 (22)", "PRECIO LISTA 10 (23)", "COSTO (24)", "COSTO RECOGER (25)", "EXISTENCIA (26)", "COD UNIDAD Y DESCRIPCIÃ“N (27)", "COD ALMACEN Y DESCRIPCIÃ“N (28)", "COD ANAQUEL Y DESCRIPCIÃ“N (29)", "COD LUGAR Y DESCRIPCIÃ“N (30)", "ANOTACIONES(31)", "INFORMACION (32)", "MINIMO (33)", "MAXIMO (34)", "COMPUESTO (35)", "IMPUESTO Y VALOR(36)", "INVENTARIABLE (37)", "VENDER ABAJO DEL COSTO (38)", "ES PARA VENTA(39)", "ES SERVICIO(40)", "TIPO(41)"});

                ++iConta;

                Statement   st;
                ResultSet   rs;                
                String      sQ              = "";
                
                try
                {
                    sQ = "SELECT CASE WHEN prods.DESCRIP = '' THEN '.' ELSE prods.DESCRIP END descripprod, CASE WHEN descripcort = '' THEN '.' ELSE descripcort END descripcort, med, prod, CASE WHEN prodop1 = '' THEN '.' ELSE prodop1 END prodop1, CASE WHEN prodop2 = '' THEN '.' ELSE prodop2 END prodop2, CASE WHEN prods.CODMED = '' THEN '.' ELSE prods.CODMED END codmed, CASE WHEN meds.DESCRIP = '' THEN 'GENERICA' ELSE meds.DESCRIP END meddescrip, CASE WHEN prods.LIN = '' THEN 'SYS' ELSE prods.LIN END lin, CASE WHEN lins.DESCRIP = '' THEN 'GENERICA' ELSE lins.DESCRIP END lindescrip, CASE WHEN prods.MARC = '' THEN 'SYS' ELSE prods.MARC END marc, CASE WHEN marcs.DESCRIP = '' THEN 'GENERICA' ELSE marcs.DESCRIP END marcdescrip, CASE WHEN prods.FAB = '' THEN 'SYS' ELSE prods.FAB END fab, CASE WHEN fabs.DESCRIP = '' THEN 'GENERICA' ELSE fabs.DESCRIP END fabdescrip, CASE WHEN prods.COLO = '' THEN 'SYS' ELSE prods.COLO END colo, CASE WHEN colos.DESCRIP = '' THEN 'GENERICA' ELSE colos.DESCRIP END colodescrip, CASE WHEN prods.PES = '' THEN 'SYS' ELSE prods.PES END pes, CASE WHEN pes.DESCRIP = '' THEN 'GENERICA' ELSE pes.DESCRIP END pesdescrip, pesman, prelist1, prelist2, prelist3, prelist4, prelist5, prelist6, prelist7, prelist8, prelist9, prelist10, cost, costre, exist, CASE WHEN prods.UNID = '' THEN 'SYS' ELSE prods.UNID END unid, CASE WHEN unids.DESCRIP = '' THEN 'GENERICA' ELSE unids.DESCRIP END uniddescrip, CASE WHEN prods.ALMA = '' THEN 'SYS' ELSE prods.ALMA END alma, CASE WHEN almadescrip = '' THEN 'GENERICA' ELSE almadescrip END almadescrip, CASE WHEN prods.ANAQ = '' THEN 'SYS' ELSE prods.ANAQ END anaq, CASE WHEN anaqs.DESCRIP = '' THEN 'GENERICA' ELSE anaqs.DESCRIP END anaqdescrip, CASE WHEN prods.LUG = '' THEN 'SYS' ELSE prods.LUG END lug, CASE WHEN lugs.DESCRIP = '' THEN 'GENERICA' ELSE lugs.DESCRIP END lugdescrip, CASE WHEN descprov = '' THEN '.' ELSE descprov END descprov, CASE WHEN infor = '' THEN '.' ELSE infor END infor, min, max, compue, CASE WHEN prods.IMPUE = '' THEN 'IVA' ELSE prods.IMPUE END impue, IFNULL(impueval,0) impueval , invent, bajcost, esvta, servi, CASE WHEN prods.TIP = '' THEN 'SYS' ELSE prods.TIP END tip, CASE WHEN tips.DESCRIP = '' THEN 'GENERICA' ELSE tips.DESCRIP END tipdescrip FROM prods LEFT OUTER JOIN tips ON tips.COD = prods.TIP LEFT OUTER JOIN impues ON impues.CODIMPUE = prods.IMPUE LEFT OUTER JOIN lugs ON lugs.COD = prods.LUG LEFT OUTER JOIN anaqs ON anaqs.COD = prods.ANAQ LEFT OUTER JOIN almas ON almas.ALMA = prods.ALMA LEFT OUTER JOIN unids ON unids.COD = prods.UNID LEFT OUTER JOIN pes ON pes.COD = prods.PES LEFT OUTER JOIN colos ON colos.COD = prods.COLO LEFT OUTER JOIN fabs ON fabs.COD = prods.FAB LEFT OUTER JOIN marcs ON marcs.COD = prods.MARC LEFT OUTER JOIN lins ON prods.LIN = lins.COD LEFT OUTER JOIN meds ON meds.COD = prods.CODMED";
                    st = con.createStatement();
                    rs = st.executeQuery(sQ);
                    while(rs.next())
                    {                                            
                        data.put(Integer.toString(iConta), new Object[] {rs.getString("prod"), rs.getString("prodop1"), rs.getString("prodop2"), rs.getString("codmed") + "," + rs.getString("meddescrip"), Integer.parseInt(rs.getString("med")), rs.getString("descripprod"),rs.getString("descripcort"), rs.getString("lin") + "," + rs.getString("lindescrip"), rs.getString("marc") + "," + rs.getString("marcdescrip"), rs.getString("fab") + "," + rs.getString("fabdescrip"), rs.getString("colo") + "," + rs.getString("colodescrip"), rs.getString("pes") + "," + rs.getString("pesdescrip"), rs.getString("pesman"), rs.getString("prelist1"), rs.getString("prelist2"), rs.getString("prelist3"), rs.getString("prelist4"), rs.getString("prelist5"), rs.getString("prelist6"), rs.getString("prelist7"),rs.getString("prelist8"), rs.getString("prelist9"), rs.getString("prelist10"), rs.getString("cost"), rs.getString("costre"), rs.getString("exist"), rs.getString("unid") + "," + rs.getString("uniddescrip"), rs.getString("alma") + "," + rs.getString("almadescrip"), rs.getString("anaq") + "," + rs.getString("anaqdescrip"), rs.getString("lug") + "," + rs.getString("lugdescrip"), rs.getString("descprov"), rs.getString("infor"), Integer.parseInt(rs.getString("min")), Integer.parseInt(rs.getString("max")), Integer.parseInt(rs.getString("compue")), rs.getString("impue") + "," + rs.getString("impueval"), Integer.parseInt(rs.getString("invent")), Integer.parseInt(rs.getString("bajcost")), Integer.parseInt(rs.getString("esvta")), Integer.parseInt(rs.getString("servi")), rs.getString("tip") + "," + rs.getString("tipdescrip")});
                        
                        ++iConta;
                    }
                }
                catch(SQLException e)
                {                    
                    if(Star.lCargGral!=null)                        
                        Star.lCargGral.setVisible(false);

                    //Cierra la base de datos
                    if(Star.iCierrBas(con)==-1)                  
                        return;
                    
                    Login.vLog(e.getMessage());

                    JOptionPane.showMessageDialog(null, this.getClass().getName() + " Error en " + sQ + " por " + e.getMessage(), "Error BD", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource(Star.sRutIconEr)));
                    return;
                }

                //Cierra la base de datos
                if(Star.iCierrBas(con)==-1)                  
                {
                    if(Star.lCargGral!=null)                        
                        Star.lCargGral.setVisible(false);
                    
                    //Regresa
                    return;
                }                    
                
                data.put(Integer.toString(iConta), new Object[] {"FINARCHIVO"});

                Set<String> keyset = data.keySet();
                int rownum = 0;
                for (String key : keyset)
                {
                    Row row = sheet.createRow(rownum++);
                    Object [] objArr = data.get(key);
                    int cellnum = 0;
                    for (Object ob : objArr)
                    {
                        Cell cell = row.createCell(cellnum++);
                        if(ob instanceof String)
                        cell.setCellValue((String)ob);
                        else if(ob instanceof Integer)
                        cell.setCellValue((Integer)ob);
                    }
                }
              
                try
                {
                    //Write the wkbok in file system
                    FileOutputStream out;
                    out = new FileOutputStream(new File(sRut));
                    wkbok.write(out);
                    out.close();
                }
                catch(IOException e)
                {
                    
                    if(Star.lCargGral!=null)                        
                        Star.lCargGral.setVisible(false);
                    
                    Login.vLog(e.getMessage());

                    JOptionPane.showMessageDialog(null, "Error por " + e.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource(Star.sRutIconEr)));
                    return;
                }

                if(Star.lCargGral!=null)                        
                    Star.lCargGral.setVisible(false);

                JOptionPane.showMessageDialog(null, "Archivo exportado en \"" + sRut + "\" con Éxito.", "Exportar", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource(Star.sRutIconAd)));

                Object[] op     = {"Si","No"};
                int iRes        = JOptionPane.showOptionDialog(null, "¿Quieres abrir el archivo?", "Abrir archivo", JOptionPane.YES_NO_OPTION,  JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource(Star.sRutIconDu)), op, op[0]);
                if(iRes==JOptionPane.NO_OPTION || iRes==JOptionPane.CLOSED_OPTION)
                    return;                       


                try 
                {
                    Desktop.getDesktop().open(new File(sRut));
                } 
                catch(IOException e) 
                {                    
                    Login.vLog(e.getMessage());            
                    JOptionPane.showMessageDialog(null, "No se puede abrir archivo por " + e.getMessage(), "Abrir Archivo", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource(Star.sRutIconEr))); 
                }*/
    }
    
    private void jMEstadisCorActionPerformed(java.awt.event.ActionEvent evt) {                                             
        
        /*Muestra la forma para ver el reporteador*/
        //RepEstadiCor r = new RepEstadiCor();
        //r.setVisible(true);
        
    }

    private void jMAsocActionPerformed(java.awt.event.ActionEvent evt) {                                       
        
        /*Muestra la forma de asociaciones de productos por cliente*/
        //cats.AsocPrec a = new cats.AsocPrec();       
        //a.setVisible(true);
        
    }

    private void jMZonActionPerformed(java.awt.event.ActionEvent evt) {                                      
        
        /*Muestra la forma para ver el catálogo de las zonas*/
        //cats.PlanGralCat l = new cats.PlanGralCat("zona","emps","zon","zona","zona","cod");
        //l.setVisible(true);
        
    }
    
    private void jMGirActionPerformed(java.awt.event.ActionEvent evt) {                                      
        
        /*Muestra la forma para ver el catálogo de las zonas*/
        //cats.PlanGralCat l = new cats.PlanGralCat("giro","emps","giro","concepto de giro","giro","gir");
        //l.setVisible(true);        
    }
    
    private void jMEasConActionPerformed(java.awt.event.ActionEvent evt) {                                         
        
        /*Muestra la forma para hacer las conversiones*/
        //EasyConv e = new EasyConv();
        //e.setVisible(true);
        
    }
    private void jMRubrActionPerformed(java.awt.event.ActionEvent evt) {                                       
        
        /*Muestra la forma de clasificaciones de rubro*/
        //cats.Rubr r = new cats.Rubr();
        //r.setVisible(true);
        
    }
    
    private void jMRepCliActionPerformed(java.awt.event.ActionEvent evt) {                                         
        
        /*Muestra la forma para ver el reporte de clientes*/
        //report.RepCliens r = new report.RepCliens();
        //r.setVisible(true);
        
    }
    
    private void jMRepProvActionPerformed(java.awt.event.ActionEvent evt) {                                          
        
        /*Muestra la forma para reportear a los proveedores*/
        //report.RepProvs r = new report.RepProvs();
        //r.setVisible(true);
        
    }
    
    private void jMClasJerActionPerformed(java.awt.event.ActionEvent evt) {                                          
        
        /*Muestra la forma de las clasificaciones de los clientes*/
        //cats.ClasJeraGral c = new cats.ClasJeraGral("clasjeracli","emps","clientes");
        //c.setVisible(true);
        
    }
    
    private void jMClasJerPActionPerformed(java.awt.event.ActionEvent evt) {                                           
        
        /*Muestra la forma para clasificaciones de proveedores*/
        //cats.ClasJeraGral c = new cats.ClasJeraGral("clasjeraprov","provs","proveedores");
        //c.setVisible(true);
        
    }
    
    private void jMFlujActActionPerformed(java.awt.event.ActionEvent evt) {                                          
        
        /*Muestra la forma de flujo de actividades*/
        //FlujAct f = new FlujAct();        
        //f.setVisible(true);
        
    }
    
    private void jMForLinActionPerformed(java.awt.event.ActionEvent evt) {                                         
        
        /*Muestra la forma de foro en línea*/
        //ForLin f = new ForLin();
        //f.setVisible(true);
        
    }
    
    
    private void jMLogConcepNotActionPerformed(java.awt.event.ActionEvent evt) {                                               
        
        /*Abre la forma para ver el log de tipo de activo fijo*/
        //LogGral l = new LogGral("Log conceptos activo fijo", "logconcnot", "descrip");
        //l.setVisible(true);
        
    }
    
    private void jMLogGirActionPerformed(java.awt.event.ActionEvent evt) {                                         
        
        //LogGral l = new LogGral("Log de giros", "loggiro", "descrip");
        //l.setVisible(true);        
    }
    
    private void jMConcepPagsActionPerformed(java.awt.event.ActionEvent evt) {
        ViewControlersFactory.getSingleton().getConceptosPagoViewController().setVisible();
    }
    
    private void jBPrevCompActionPerformed(java.awt.event.ActionEvent evt) {                                           
        ViewControlersFactory.getSingleton().getPrevCompViewController().setVisible();
    }
    
    private void jMPrevioCompActionPerformed(java.awt.event.ActionEvent evt) {                                             
        ViewControlersFactory.getSingleton().getPrevCompViewController().setVisible();
    }
    
    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        
        //RepPrevCom c = new RepPrevCom();
        //c.setVisible(true);
    }
    
    
    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {
        ViewControlersFactory.getSingleton().getTraspasosSalidaViewController().setVisible();
    }
    
    private void jMICuentaContableActionPerformed(java.awt.event.ActionEvent evt) {
        ViewControlersFactory.getSingleton().getCuentasContablesViewController().setVisible();
    }
    
    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        ViewControlersFactory.getSingleton().getCatalBancosViewController().setVisible();
    }
    
    private void jMResponsableActionPerformed(java.awt.event.ActionEvent evt) {                                              
        //cats.PlanGralCat l = new cats.PlanGralCat("responsable","emps"," ","responsables","responsable","cod");
        //l.setVisible(true); 
    }
    
    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {                                           
       //RepTraspasos t = new RepTraspasos();
       //t.setVisible(true);
    }
    
    private void jMenuItemPedidosActionPerformed(java.awt.event.ActionEvent evt) {
        ViewControlersFactory.getSingleton().getPedidosViewController().setVisible();
    }
    
    private void jMenuItemRemisionesActionPerformed(java.awt.event.ActionEvent evt) {                                                    
        
        try {
         
            final VtasViewController VtasViewController = ViewControlersFactory.getSingleton().getVtasViewController();
            VtasViewController.setDocumentType(DocumentType.REMISION);
            VtasViewController.setVisible();
            
        } catch (Exception ex) {
            LoggerUtility.getSingleton().logError(this.getClass(), ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    private void jMenuItemTicketsActionPerformed(java.awt.event.ActionEvent evt) {                                                    
        
        try {
         
            final VtasViewController VtasViewController = ViewControlersFactory.getSingleton().getVtasViewController();
            VtasViewController.setDocumentType(DocumentType.TICKETS);
            VtasViewController.setVisible();
            
        } catch (Exception ex) {
            LoggerUtility.getSingleton().logError(this.getClass(), ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
        
    private void jMenuItemNotcActionPerformed(java.awt.event.ActionEvent evt) {
        
        try {
         
            final VtasViewController VtasViewController = ViewControlersFactory.getSingleton().getVtasViewController();
            VtasViewController.setDocumentType(DocumentType.NOTC);
            VtasViewController.setVisible();
            
        } catch (Exception ex) {
            LoggerUtility.getSingleton().logError(this.getClass(), ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    private void jMenuItemInvoicesActionPerformed(java.awt.event.ActionEvent evt) {
        
        try {
         
            final VtasViewController VtasViewController = ViewControlersFactory.getSingleton().getVtasViewController();
            VtasViewController.setDocumentType(DocumentType.INVOICE);
            VtasViewController.setVisible();
            
        } catch (Exception ex) {
            LoggerUtility.getSingleton().logError(this.getClass(), ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    private void jButtonPedidosActionPerformed(java.awt.event.ActionEvent evt) {                                               
        ViewControlersFactory.getSingleton().getPedidosViewController().setVisible();
    }
    
    private void jButtonPedidos1ActionPerformed(java.awt.event.ActionEvent evt) {                                                
        ViewControlersFactory.getSingleton().getListadoPagosViewController().setVisible();
    }
    
    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {
        ViewControlersFactory.getSingleton().getSeriesViewController().setVisible();
    }
    
    private void jBReporteCajaActionPerformed(java.awt.event.ActionEvent evt) {                                              
        
    }
    
    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        
        try{
            
            //Question if continue
            DialogsFactory.getSingleton().showQuestionContinueDialog(baseJFrame, (JFrame jFrame) -> {
                try{
                    
                    //Clear the licence information in system
                    RepositoryFactory.getInstance().getLicensesRepository().deleteLicense();                    
                    WinRegistry.deleteUserLicense();
                    
                    //Exit app after queston
                    DialogsFactory.getSingleton().showOKCallbackDialog(jFrame, "session_closed_correctly", (JFrame jFrame1) -> {
                        System.exit(0);
                    });
                    
                }catch (Exception ex) {
                    LoggerUtility.getSingleton().logError(PrincipViewController.class, ex);
                    try {
                        DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
                    } catch (Exception ex1) {
                        Logger.getLogger(PrincipViewController.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                }
            });

        }catch (Exception ex) {
            LoggerUtility.getSingleton().logError(PrincipViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(PrincipViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
 
    @Override
    public List<?> getItemsToLoadInTable() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}