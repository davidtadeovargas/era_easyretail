/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.easyretail.controllers.views;

import com.era.easyretail.enums.LoginType;
import com.era.easyretail.enums.LoginTypeEmpresa;
import com.era.logger.LoggerUtility;
import com.era.models.BasDats;
import com.era.models.Confgral;
import com.era.models.User;
import com.era.repositories.RepositoryFactory;
import com.era.utilities.FileChooserUtility;
import com.era.utilities.UtilitiesFactory;
import com.era.views.PrincipJFrame;
import com.era.views.dialogs.DialogsFactory;
import com.era.views.dialogs.ErrorOKDialog;
import com.era.views.dialogs.ExceptionDialog;
import com.era.views.dialogs.OKDialog;
import com.era.views.dialogs.QuestionDialog;
import java.awt.Desktop;
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
                                    
            //Override default functionality
            JComponentUtils.setDisposeInEscapeEvent(false);            
            
            final ImageIcon ImageIcon = UtilitiesFactory.getSingleton().getIconsUtility().getImageIconFromImage("ban.png");                
            jLImg.setIcon(ImageIcon);

            final BasDats BasDats = UtilitiesFactory.getSingleton().getSessionUtility().getBasDats();
            final User User = UtilitiesFactory.getSingleton().getSessionUtility().getUser();
            final String userLoggedTime = UtilitiesFactory.getSingleton().getSessionUtility().getUserLoggedTime();

            jMenIt4.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMenIt4ActionPerformed(evt);
            });
            jMenItCambClavSeg.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMenItCambClavSegActionPerformed(evt);
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
            jMenItModBD.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMenItModBDActionPerformed(evt);
            });
            jMenItResps.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMenItRespsActionPerformed(evt);
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
            jMenItConceps.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMenItConcepsActionPerformed(evt);
            });
            jMeItImps.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMeItImpsActionPerformed(evt);
            });
            jMenItLugs.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMenItLugsActionPerformed(evt);
            });
            jMenIt5.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMenIt5ActionPerformed(evt);
            });
            jMenItMeds.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMenItMedsActionPerformed(evt);
            });
            jMenItMons.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMenItMonsActionPerformed(evt);
            });
            jMenItAlmas.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMenItAlmasActionPerformed(evt);
            });
            jMenItUnids.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMenItUnidsActionPerformed(evt);
            });
            jMenItPesos.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMenItPesosActionPerformed(evt);
            });
            jMenItCols.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMenItColsActionPerformed(evt);
            });
            jMenItMarcs.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMenItMarcsActionPerformed(evt);
            });
            jMenIt1.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMenIt1ActionPerformed(evt);
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
            jMConfAd.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMConfAdActionPerformed(evt);
            });
            jMCXC.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMCXCActionPerformed(evt);
            });
            jMCXP.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMCXPActionPerformed(evt);
            });
            jMContra.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMContraActionPerformed(evt);
            });
            jMenConfigFil.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMenConfigFilActionPerformed(evt);
            });
            jMenCatGral.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMenCatGralActionPerformed(evt);
            });
            jMenItDeslog.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMenItDeslogActionPerformed(evt);
            });
            jMenItCamEmp.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMenItCamEmpActionPerformed(evt);
            });
            jMenCXCR.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMenCXCRActionPerformed(evt);
            });
            jMenCXP.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMenCXPActionPerformed(evt);
            });
            jMenVtasR.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMenVtasRActionPerformed(evt);
            });
            jMenProds.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMenProdsActionPerformed(evt);
            });
            jMDelLog.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMDelLogActionPerformed(evt);
            });
            jMClasProd.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMClasProdActionPerformed(evt);
            });
            jMUbiAd.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMUbiAdActionPerformed(evt);
            });
            jMUsr.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMUsrActionPerformed(evt);
            });
            jMEstacs.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMEstacsActionPerformed(evt);
            });
            jMLogProd.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMLogProdActionPerformed(evt);
            });
            jMLogK.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMLogKActionPerformed(evt);
            });
            jMLogLin.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMLogLinActionPerformed(evt);
            });
            jMLogMarc.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMLogMarcActionPerformed(evt);
            });
            jMLogFab.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMLogFabActionPerformed(evt);
            });
            jMLogColo.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMLogColoActionPerformed(evt);
            });
            jMLogClas.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMLogClasActionPerformed(evt);
            });
            jMLogPes.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMLogPesActionPerformed(evt);
            });
            jMLogMed.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMLogMedActionPerformed(evt);
            });
            jMLogUnid.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMLogUnidActionPerformed(evt);
            });
            jMLogMon.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMLogMonActionPerformed(evt);
            });
            jMLogImpu.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMLogImpuActionPerformed(evt);
            });
            jMLogConcep.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMLogConcepActionPerformed(evt);
            });
            jMLogAlma.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMLogAlmaActionPerformed(evt);
            });
            jMenuItem1.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMenuItem1ActionPerformed(evt);
            });
            jMLogLug.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMLogLugActionPerformed(evt);
            });
            jMLogUbiE.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMLogUbiEActionPerformed(evt);
            });
            jMRepCot.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMRepCotActionPerformed(evt);
            });
            jMCatMsj.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMCatMsjActionPerformed(evt);
            });
            addWindowStateListener((java.awt.event.WindowEvent evt) -> {
                formWindowStateChanged(evt);
            });
            jMChatC.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMChatCActionPerformed(evt);
            });
            jMChat.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMChatActionPerformed(evt);
            });
            jBPtoVta.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBPtoVtaActionPerformed(evt);
            });
            jBComps.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBCompsActionPerformed(evt);
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
            jMRepVend.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMRepVendActionPerformed(evt);
            });
            jMAcerc.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMAcercActionPerformed(evt);
            });
            jMRepCom.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMRepComActionPerformed(evt);
            });
            jMRepOr.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMRepOrActionPerformed(evt);
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
            jMKard.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMKardActionPerformed(evt);
            });
            jMCosts.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMCostsActionPerformed(evt);
            });
            jMLogRes.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMLogResActionPerformed(evt);
            });
            jMResp.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMRespActionPerformed(evt);
            });
            jMFluj.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMFlujActionPerformed(evt);
            });
            jMClasCli.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMClasCliActionPerformed(evt);
            });
            jMClasProv.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMClasProvActionPerformed(evt);
            });
            jMRepLogCo.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMRepLogCoActionPerformed(evt);
            });
            jMModel.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMModelActionPerformed(evt);
            });
            jMTabCompa.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMTabCompaActionPerformed(evt);
            });
            jMenuItem2.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMenuItem2ActionPerformed(evt);
            });
            jMLogMod.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMLogModActionPerformed(evt);
            });
            jMLogTall.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMLogTallActionPerformed(evt);
            });
            jMTallCol.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMTallColActionPerformed(evt);
            });
            jMLotPed.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMLotPedActionPerformed(evt);
            });
            jMRepBackO.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMRepBackOActionPerformed(evt);
            });
            jMTip.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMTipActionPerformed(evt);
            });
            jMLogTip.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMLogTipActionPerformed(evt);
            });
            jMInvenExpor.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMInvenExporActionPerformed(evt);
            });
            jMEstadisCor.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMEstadisCorActionPerformed(evt);
            });
            jMAsoc.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMAsocActionPerformed(evt);
            });
            jMZon.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMZonActionPerformed(evt);
            });
            jMGir.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMGirActionPerformed(evt);
            });
            jMEasCon.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMEasConActionPerformed(evt);
            });
            jMRubr.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMRubrActionPerformed(evt);
            });
            jMRepCli.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMRepCliActionPerformed(evt);
            });
            jMRepProv.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMRepProvActionPerformed(evt);
            });
            jMClasJer.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMClasJerActionPerformed(evt);
            });
            jMClasJerP.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMClasJerPActionPerformed(evt);
            });
            jMFlujAct.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMFlujActActionPerformed(evt);
            });
            jMForLin.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMForLinActionPerformed(evt);
            });
            jMConcepNot.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMConcepNotActionPerformed(evt);
            });
            jMImpAlma.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMImpAlmaActionPerformed(evt);
            });
            jMLogConcepNot.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMLogConcepNotActionPerformed(evt);
            });
            jMLogGir.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMLogGirActionPerformed(evt);
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
            jMenuItem4.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMenuItem4ActionPerformed(evt);
            });
            jMSucursal.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMSucursalActionPerformed(evt);
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
            jMResponsable.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMResponsableActionPerformed(evt);
            });
            jMenuItem9.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMenuItem9ActionPerformed(evt);
            });
            jMenuItemPedidos.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMenuItemPedidosActionPerformed(evt);
            });
            jMenuItemRemisiones.addActionListener((java.awt.event.ActionEvent evt) -> {
                jMenuItemRemisionesActionPerformed(evt);
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
    
    private void jMenItEstacsActionPerformed(java.awt.event.ActionEvent evt) {        
        ViewControlersFactory.getSingleton().getUsrsViewController().setVisible();
    }
    
    private void jMenIt4ActionPerformed(java.awt.event.ActionEvent evt) {                                        
        
        /*Muestra el gráfico de corrs electrónicos*/
        //CorrElecs c = new CorrElecs();
        //c.setVisible(true);       
    }
    
    private void jMenItCambClavSegActionPerformed(java.awt.event.ActionEvent evt) {                                                  
               
        /*Mostrar el gráfico de cambiar clave de seguridad 1*/
        //ClavCamb c = new ClavCamb(null, true);
        //c.getObj().setVisible(true);
        
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
        ViewControlersFactory.getSingleton().getCompsViewController().setVisible();        
    }
    
    private void jMenCotsTActionPerformed(java.awt.event.ActionEvent evt) {                                          
        ViewControlersFactory.getSingleton().getCotsViewController().setVisible();
    }
    
    private void jMenItVtasActionPerformed(java.awt.event.ActionEvent evt) {                                           
        ViewControlersFactory.getSingleton().getVtasViewController().setVisible();
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

        /*Muestra el formulario para conceptos*/
        //cats.PlanGralCat l = new cats.PlanGralCat("conceps","ingres","concep","concepto","concep","concep");
        //l.setVisible(true);
    }
    
    private void jMeItImpsActionPerformed(java.awt.event.ActionEvent evt) {                                          

        /*Muestra el formulario de impuestos*/
        //Imps i = new Imps();
        //i.setVisible(true);

    }
    
    private void jMenItLugsActionPerformed(java.awt.event.ActionEvent evt) {                                           

        /*Muestra el formulario de lugares*/
        //cats.PlanGralCat l = new cats.PlanGralCat("lugs","prods","lug","lugar","lugs","cod");
        //l.setVisible(true);

    }
    
    private void jMenIt5ActionPerformed(java.awt.event.ActionEvent evt) {                                        

        /*Muestra el formulario de los anaqueles*/
        //cats.PlanGralCat l = new cats.PlanGralCat("Anaqs","prods","anaq","anaquel","anaq","cod");
        //l.setVisible(true);

    }
    
    private void jMenItMedsActionPerformed(java.awt.event.ActionEvent evt) {                                           

        /*Muestra el formulario de medidas*/
        //cats.PlanGralCat f = new cats.PlanGralCat("meds","Prods","codmed","medida","med","cod");
        //f.setVisible(true);
    }
    
    private void jMenItMonsActionPerformed(java.awt.event.ActionEvent evt) {                                           

        /*Muestra el formulario de monedas*/
        //Mons m = new Mons();
        //m.setVisible(true);
    }
    
    private void jMenItAlmasActionPerformed(java.awt.event.ActionEvent evt) {                                            

        /*Muestra el formulario de almacenes*/
        //Almas a = new Almas();
        //a.setVisible(true);
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
        
        /*Muestra el formulario de los productos por debajo del mínimo*/
        //BajsMin b  = new BajsMin();
        //b.setVisible(true);
        
    }
    
    private void jMenItDefEstacsActionPerformed(java.awt.event.ActionEvent evt) {                                                
        
        /*Muestra el formulario para máximos y mínimos por usuario*/
        //MaxsMins m = new MaxsMins();
        //m.setVisible(true);
    }
    
    
    private void jMenItKitsActionPerformed(java.awt.event.ActionEvent evt) {                                           
        
        /*Muestra el formulario que contiene todos los kits*/
        //Kits k = new Kits();
        //k.setVisible(true);        
    }
    
    private void jMenItProdsArrMaxActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        
        /*Muestra el formulario para productos arriba del máximo*/
        //AltsMaxs a = new AltsMaxs();
        //a.setVisible(true);        
    }
    
    private void jMenItTraspasActionPerformed(java.awt.event.ActionEvent evt) {                                              
        
        /*Muestra el formulario para los traspasos*/
        //Traspas t = new Traspas();
        //t.setVisible(true);
    }
    
    private void jMenItIngrActionPerformed(java.awt.event.ActionEvent evt) {                                           
        
        /*Muestra el formulario para ingresos al inventario*/
        //EntradasSalidas i = new EntradasSalidas();
        //i.setVisible(true);
        
    }
    
    private void jMenItDatsGenEmpActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        
        /*Muestra el formulario para específicar los datos generales de la empresa*/
        //frmEmpresas empresas = new frmEmpresas();
        //empresas.setVisible(true);
        
    }
    
    private void jMenItLogCorrActionPerformed(java.awt.event.ActionEvent evt) {                                              
        
        /*Muestra el formulario de log de corrs*/
        //LogCorrs l = new LogCorrs();
        //l.setVisible(true);        
    }
    
    private void jMenItTipsPagsActionPerformed(java.awt.event.ActionEvent evt) {                                               
        
        /*Muestra el formulario para los tipos de pagos*/
        //TipsPags p = new TipsPags();
        //p.setVisible(true);
        
    }
    
    private void jMenItImpresActionPerformed(java.awt.event.ActionEvent evt) {                                             
        
        /*Muestra la forma para ver las impresoras por estacions*/
        //Impres i = new Impres();
        //i.setVisible(true);
        
    }
    
    private void jMVLogSysActionPerformed(java.awt.event.ActionEvent evt) {                                          
                
        try{
            
            if(UtilitiesFactory.getSingleton().getFilesUtility().logFileExists())
            {
                /*Si el sistema soporta esta característica entonces*/
                if(Desktop.isDesktopSupported()) 
                {          
                    /*Abre el archivo*/
                    Desktop.getDesktop().edit(UtilitiesFactory.getSingleton().getFilesUtility().getLogFile());
                } 
                else 
                {
                    //Mensajea
                    final ErrorOKDialog ErrorOKDialog = DialogsFactory.getSingleton().getErrorOKDialog(baseJFrame);
                    ErrorOKDialog.setPropertyText("errors_desktop_not_supported");
                    ErrorOKDialog.show();
                }
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
        
        /*Muestra la forma para configuraciones generales*/
        //i = new ConfGral();
        //i.setVisible(true);
        
    }
    
    private void jMCXCActionPerformed(java.awt.event.ActionEvent evt) {                                      
        
        /*Muestra la forma para ver las cuentas por pagar*/
        //Cxc c = new Cxc(btnsCxc);
        //c.setVisible(true);
        
    }
    
    private void jMCXPActionPerformed(java.awt.event.ActionEvent evt) {                                      
        
        /*Muestra la forma de cuentas por pagar*/
        //Cxp c = new Cxp(btnsCxp);
        //c.setVisible(true);
        
    }
    
    private void jMContraActionPerformed(java.awt.event.ActionEvent evt) {
        
        /*Muestra la forma para ver los contrarecibos*/
        //Contras c = new Contras();
        //c.setVisible(true);        
    }
    
    private void jMenConfigFilActionPerformed(java.awt.event.ActionEvent evt) {                                              
        
        /*Abre el archivo de configuración*/
        //BDCon b = new BDCon(false);
        //b.setVisible(true);
        
    }
    
    private void jMenCatGralActionPerformed(java.awt.event.ActionEvent evt) {                                            

        /*Muestra la forma del catálogo general*/
        //cats.PlanGralCat l = new cats.PlanGralCat("grals","prods","anaq","concepto general","CatGral","cod");
        //l.setVisible(true);
        
    }
    
    private void jMenItDeslogActionPerformed(java.awt.event.ActionEvent evt) {                                             
        
        //Close the current window and open the login screen as login
        dispose();
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
            
            /*Preguntar al usr si esta seguro de querer borrar el archivo*/
            final QuestionDialog QuestionDialog = DialogsFactory.getSingleton().getQuestionDialog(baseJFrame);
            QuestionDialog.setPropertyText("question_delete_log_file");
            QuestionDialog.setOKDialogInterface((JFrame jFrame) -> {
                
                try{
                 
                    UtilitiesFactory.getSingleton().getFilesUtility().deleteLogFile();

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
        
        /*Abre la forma para ver el log de productos*/
        //LogGral l = new LogGral("Log productos", "logprods", "descrip");
        //l.setVisible(true);
        
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
        ViewControlersFactory.getSingleton().getVtasViewController().setVisible();
    }
    
    private void jBCompsActionPerformed(java.awt.event.ActionEvent evt) {                                        
        ViewControlersFactory.getSingleton().getCompsViewController().setVisible();
    }
    
    private void jBEmpsActionPerformed(java.awt.event.ActionEvent evt) {
        ViewControlersFactory.getSingleton().getClientsViewController().setVisible();
    }
    
    private void jBProdsActionPerformed(java.awt.event.ActionEvent evt) {                                        
        ViewControlersFactory.getSingleton().getProdsViewController().setVisible();
    }
    
    private void jBCotsActionPerformed(java.awt.event.ActionEvent evt) {                                       
        
        /*Muestra el formulario para ver todos las cotizaciones*/
        //vAbrCots();
        
    }
    
    private void jMRepVendActionPerformed(java.awt.event.ActionEvent evt) {                                          
        
        /*Muestra la forma para ver el reporte de los vendedores*/
        //RepVends r = new RepVends();
        //r.setVisible(true);
        
    }
    
    private void jMAcercActionPerformed(java.awt.event.ActionEvent evt) {                                        
        
        /*Muestra la forma de acerca de*/
        //AcerD a = new AcerD();
        //a.setVisible(true);
        
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
        
        /*Muestra la forma de lotes y pedimentos*/
        //cats.LotPedCat l = new cats.LotPedCat();
        //l.setVisible(true);
        
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
    
    private void jMConcepNotActionPerformed(java.awt.event.ActionEvent evt) {                                            
        
        /*Muestra la forma para ver los conceptos de notas de crédito*/
        //cats.PlanGralCat l = new cats.PlanGralCat("concepnot","comprs","concep","concepto de notas de crédito","conCnot","concep");
	//l.setVisible(true);
        
    }
    
    private void jMImpAlmaActionPerformed(java.awt.event.ActionEvent evt) {                                          
        
        try{
            
            final FileChooserUtility FileChooserUtility = UtilitiesFactory.getSingleton().getFileChooserUtility();
            FileChooserUtility.setPropertyTitle("fc_titles_search_excel_file");
            FileChooserUtility.setIApproveOpption((String absolutePath, String fileName) -> {
                
                try{
                    
                    if(!fileName.endsWith("xlsx") && !fileName.endsWith("xls")){
                        final ErrorOKDialog ErrorOKDialog = DialogsFactory.getSingleton().getErrorOKDialog(baseJFrame);
                        ErrorOKDialog.setPropertyText("errors_not_excel_file");                    
                        ErrorOKDialog.show();
                        return;
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
            FileChooserUtility.showSaveDialog(baseJFrame);
            
        }catch (Exception ex) {
            LoggerUtility.getSingleton().logError(PrincipViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {               Logger.getLogger(PrincipViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
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
        
        //cats.ConceptosPago c = new cats.ConceptosPago();
        //c.setVisible(true);
        
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
    
    private void jMSucursalActionPerformed(java.awt.event.ActionEvent evt) {                                           
        //cats.CatalogoDependiente l = new cats.CatalogoDependiente("sucursal","zona"," ","sucursales","sucursal","cod");
        //l.setVisible(true);
    }
    
    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        //TraspasosSalida t = new TraspasosSalida();
        //t.setVisible(true);
    }
    
    private void jMICuentaContableActionPerformed(java.awt.event.ActionEvent evt) {                                                  
       //CuentasContables cuenta= new CuentasContables();
       // cuenta.setVisible(true);
    }
    
    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        //cats.CatalBancos l = new cats.CatalBancos("banco","emps"," ","Cuentas","banco","cuentabanco");
        //l.setVisible(true);
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
        
        //Vtas vtas = new Vtas(btnsVentas,"REM");
        //vtas.setVisible(true);
        
    }
    
    private void jButtonPedidosActionPerformed(java.awt.event.ActionEvent evt) {                                               
        ViewControlersFactory.getSingleton().getPedidosViewController().setVisible();
    }
    
    private void jButtonPedidos1ActionPerformed(java.awt.event.ActionEvent evt) {                                                
        
        /*if (Star.listadoPagos == null) {
            Star.listadoPagos = new ListadoPagos();
            Star.listadoPagos.setVisible(true);
        }else{
            Star.listadoPagos.toFront();
        }*/
    }
    
    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        //SerFac f = new SerFac();
        //f.setVisible(true);
    }
    
    private void jBReporteCajaActionPerformed(java.awt.event.ActionEvent evt) {                                              
        //RepCaja rep = new RepCaja();
        //rep.setVisible(true);
    }
    
    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        
        /*Object[] op = {"Si","No"};
        int iRes    = JOptionPane.showOptionDialog(this, "¿Seguro que quieres cerrar sesión?", "Salir", JOptionPane.YES_NO_OPTION,  JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource(Star.sRutIconDu)), op, op[0]);
        if(iRes==JOptionPane.YES_OPTION){
            try{
             
                HibernateUtil.connectToDbEmpresas();
                RepositoryManager.getInstance().getLicenseRepository().deleteLicense();                
                WinRegistry.deleteUserLicense();

                JOptionPane.showMessageDialog(null, "Sesión cerrada correctamente, el sistema se cerrará en este momento", "Sistema", JOptionPane.INFORMATION_MESSAGE, null);             

                System.exit(0);
                
            }catch(Exception e){
                LoggerUtility.getSingleton().logError(PrincipJFrame.class, e);
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE, null);             
            }
        }*/
        
    }
    
    
}