/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.easyretail.controllers.views;

import com.era.datamodels.enums.SearchCommonTypeEnum;
import com.era.easyretail.swingworkers.BaseSwingWorker;
import com.era.easyretail.swingworkers.ISwingWorkerActions;
import com.era.views.CorrElecsJFrame;
import java.util.List;
import com.era.logger.LoggerUtility;
import com.era.models.Corrselec;
import com.era.models.User;
import com.era.repositories.RepositoryFactory;
import com.era.utilities.UtilitiesFactory;
import com.era.utilities.models.EmailModel;
import com.era.views.dialogs.DialogsFactory;
import com.era.views.tables.headers.TableHeaderFactory;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.event.ListSelectionEvent;
/**
 *
 * @author PC
 */
public class CorrElecsViewController extends CorrElecsJFrame {
    
    public CorrElecsViewController(){
        super("window_title_emails");
        
        try{
                     
            jBUsr.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBUsrActionPerformed(evt);
            });
            jBNew.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBNewActionPerformed(evt);
            });
            jBLim.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBLimActionPerformed(evt);
            });
            jBSal.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBSalActionPerformed(evt);
            });
            jBMosrT.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBMosrTActionPerformed(evt);
            });
            jBBusc.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBBuscActionPerformed(evt);
            });
            jBGuar.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBGuarActionPerformed(evt);
            });
            jBDel.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBDelActionPerformed(evt);
            });
            jBProbCon.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBProbConActionPerformed(evt);
            });
            
            this.BaseJTable = jTab;
            jTab.addShowColumn(TableHeaderFactory.getSigleton().getCorrselecsTableHeader().getROWNUMBER());
            jTab.addShowColumn(TableHeaderFactory.getSigleton().getCorrselecsTableHeader().getESTACGLO());
            jTab.addShowColumn(TableHeaderFactory.getSigleton().getCorrselecsTableHeader().getFALT());
            jTab.addShowColumn(TableHeaderFactory.getSigleton().getCorrselecsTableHeader().getFMOD());
            
            jTab.setITableRowSelected((ListSelectionEvent lse, Object Object) -> {
                
                try {
                 
                    clearFields();
                    
                    //Load all items in fields
                    loadModelInFields(Object);
                    
                } catch (Exception ex) {
                    LoggerUtility.getSingleton().logError(this.getClass(), ex);
                    try {
                        DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
                    } catch (Exception ex1) {
                        Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex1);
                    }
                }
            });
            
            jTab.loadAllItemsInTable();
            
            jTabPan1.setTitleAt(0, "");
            
            jTServSMTPSal.grabFocus();
            
            this.JComponentUtils.onlyNumbers(jTPortSMTP);
            
        }catch (Exception ex) {
            LoggerUtility.getSingleton().logError(CorrElecsViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(CorrElecsViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }

    @Override
    public void loadModelInFields(Object ObjectModel) throws  Exception {
        
        //Cast the model
        final Corrselec Corrselec = (Corrselec)ObjectModel;
        
        //Fill the fields
        jTServSMTPSal.setText(Corrselec.getSrvsmtpsal());
        jTPortSMTP.setText(String.valueOf(Corrselec.getPortsmtp()));
        jCActSSLLog.setSelected(Corrselec.isActslenlog());
        jTUsr.setText(Corrselec.getUsr());
        jPContra.setText(Corrselec.getPass());
        jTCorAlter.setText(Corrselec.getCorralter());
        jTEsta.setText(Corrselec.getEstacglo());
    }
    
    @Override
    public void clearFields() throws Exception{
        
        jTServSMTPSal.setText("");
        jTPortSMTP.setText("");
        jCActSSLLog.setSelected(false);
        jTUsr.setText("");
        jPContra.setText("");
        jTCorAlter.setText("");
        jTEsta.setText("");
        jTBusc.setText("");
    }
    
    private void jBUsrActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
            final SearchViewController SearchViewController = new SearchViewController();
            SearchViewController.setSEARCH_TYPE(SearchCommonTypeEnum.USERS);
            SearchViewController.setButtonAceptClicked(() -> {
                final String userCode = SearchViewController.getCod();                
                jTEsta.setText(userCode);
            });
            SearchViewController.setVisible();
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(CorrElecsViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(CorrElecsViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBNewActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            saveOrUpdate(true);
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(CorrElecsViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(CorrElecsViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBLimActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
            this.clearFields();
            
            jTab.clearSelection();
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(CorrElecsViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(CorrElecsViewController.class.getName()).log(Level.SEVERE, null, ex1);
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
            LoggerUtility.getSingleton().logError(CorrElecsViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(CorrElecsViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBMosrTActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            this.jTab.loadAllItemsInTable();
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(CorrElecsViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(CorrElecsViewController.class.getName()).log(Level.SEVERE, null, ex1);
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
            this.jTab.getByLikeEncabezados(search);
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(CorrElecsViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(CorrElecsViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void saveOrUpdate(final boolean save) throws Exception {
        
        //Get all fields
        String serverSMTPOut = jTServSMTPSal.getText().trim();
        String portSMTP = jTPortSMTP.getText().trim();
        String userEmial = jTUsr.getText().trim();
        String password = new String(jPContra.getPassword()).trim(); 
        String alternativeEmial = jTCorAlter.getText().trim();
        String user = jTEsta.getText().trim();

        //Validate that all fields have data
        if(serverSMTPOut.isEmpty()){
            DialogsFactory.getSingleton().showOKEmptyFieldCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                jTServSMTPSal.grabFocus();
            });
            return;
        }
        if(portSMTP.isEmpty()){
            DialogsFactory.getSingleton().showOKEmptyFieldCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                jTPortSMTP.grabFocus();
            });
            return;
        }
        if(userEmial.isEmpty()){
            DialogsFactory.getSingleton().showOKEmptyFieldCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                jTUsr.grabFocus();
            });
            return;
        }
        if(password.isEmpty()){
            DialogsFactory.getSingleton().showOKEmptyFieldCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                jPContra.grabFocus();
            });
            return;
        }
        if(alternativeEmial.isEmpty()){
            DialogsFactory.getSingleton().showOKEmptyFieldCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                jTCorAlter.grabFocus();
            });
            return;
        }
        if(user.isEmpty()){
            DialogsFactory.getSingleton().showOKEmptyFieldCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                jTEsta.grabFocus();
            });
            return;
        }

        //If new record check that already doesnt exists by user
        if(save){
            
            final Corrselec Corrselec = RepositoryFactory.getInstance().getCorrselecRepository().getByEstacGlob(user);
            if(Corrselec!=null){
                DialogsFactory.getSingleton().showErrorRecordExistsOKDialog(baseJFrame, (JFrame jFrame1) -> {
                    jTEsta.grabFocus();
                });
                return;
            }
        }
        
        //Get the user
        final User User = (User)RepositoryFactory.getInstance().getUsersRepository().getByCode(user);
        if(User==null){
            DialogsFactory.getSingleton().showErrorOKRecordNotExistsCallbackDialog(baseJFrame, (JFrame jFrame) -> {
            });
            return;
        }

        DialogsFactory.getSingleton().showQuestionContinueDialog(baseJFrame, (JFrame jFrame) -> {

            try {

                //Determine SSL
                final boolean sActSSL;
                if(jCActSSLLog.isSelected())
                    sActSSL = true;
                else
                    sActSSL = false;

                //Create the model
                Corrselec Corrselec;
                if(save){
                    Corrselec = new Corrselec();
                }
                else{
                    Corrselec = RepositoryFactory.getInstance().getCorrselecRepository().getByEstacGlob(user);
                }                
                Corrselec.setSrvsmtpsal(serverSMTPOut);
                Corrselec.setPortsmtp(Integer.valueOf(portSMTP));
                Corrselec.setUsr(userEmial);
                Corrselec.setPass(password);
                Corrselec.setCorralter(alternativeEmial);
                Corrselec.setEstacglo(user);
                Corrselec.setActslenlog(sActSSL);
                
                //Save or update the model
                if(save){
                    RepositoryFactory.getInstance().getCorrselecRepository().save(Corrselec);
                }
                else{
                    RepositoryFactory.getInstance().getCorrselecRepository().update(Corrselec);
                }                

                //Reload table
                jTab.loadAllItemsInTable();
                
                //Success
                DialogsFactory.getSingleton().showOKOperationCompletedCallbackDialog(jFrame, (JFrame jFrame1) -> {
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
    
    private void jBGuarActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            saveOrUpdate(false);
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(CorrElecsViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(CorrElecsViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBDelActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{
            
            //First select something to delete
            if(!jTab.isRowSelected()){
                DialogsFactory.getSingleton().showErrorOKNoSelectionCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                    jTab.grabFocus();
                });
                return;
            }
            
            DialogsFactory.getSingleton().showQuestionContinueDialog(baseJFrame, (JFrame jFrame) -> {
                
                try {
               
                    //Get selected record
                    final Corrselec Corrselec = (Corrselec)jTab.getRowSelected();
                    
                    //Delete from db
                    RepositoryFactory.getInstance().getCorrselecRepository().delete(Corrselec);
                    
                    //Reload table
                    jTab.loadAllItemsInTable();
                    
                    DialogsFactory.getSingleton().showOKOperationCompletedCallbackDialog(jFrame, (JFrame jFrame1) -> {
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
            LoggerUtility.getSingleton().logError(CorrElecsViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(CorrElecsViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBProbConActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
            //Get all fields
            String serverSMTPOut = jTServSMTPSal.getText().trim();
            String portSMTP = jTPortSMTP.getText().trim();
            String userEmial = jTUsr.getText().trim();
            String password = new String(jPContra.getPassword()).trim();             

            //Validate that all fields have data
            if(serverSMTPOut.isEmpty()){
                DialogsFactory.getSingleton().showOKEmptyFieldCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                    jTServSMTPSal.grabFocus();
                });
                return;
            }
            if(portSMTP.isEmpty()){
                DialogsFactory.getSingleton().showOKEmptyFieldCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                    jTPortSMTP.grabFocus();
                });
                return;
            }
            if(userEmial.isEmpty()){
                DialogsFactory.getSingleton().showOKEmptyFieldCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                    jTUsr.grabFocus();
                });
                return;
            }
            if(password.isEmpty()){
                DialogsFactory.getSingleton().showOKEmptyFieldCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                    jPContra.grabFocus();
                });
                return;
            }
            
            DialogsFactory.getSingleton().showQuestionContinueDialog(baseJFrame, (JFrame jFrame) -> {
                
                try {
            
                    final BaseSwingWorker BaseSwingWorker = new BaseSwingWorker();
                    BaseSwingWorker.setShowLoading(baseJFrame);
                    BaseSwingWorker.setISwingWorkerActions(new ISwingWorkerActions(){

                        @Override
                        public void before() {
                            
                        }

                        @Override
                        public Object doinbackground() {
                            
                            try{
                                
                                //Determine SSL
                                final boolean useSSL = jCActSSLLog.isSelected();
                                
                                //Create the email model
                                final EmailModel EmailModel_ = new EmailModel();
                                EmailModel_.setSmtpSal(serverSMTPOut);
                                EmailModel_.setSmtpPort(Integer.valueOf(portSMTP));
                                EmailModel_.setUsername(userEmial);
                                EmailModel_.setPassword(password);
                                EmailModel_.setUseSSL(useSSL);
                                
                                //Send the test
                                UtilitiesFactory.getSingleton().getEmailUtility().sendTest(EmailModel_);
                                
                            }catch (Exception ex) {
                                LoggerUtility.getSingleton().logError(PrincipViewController.class, ex);
                                return ex;
                            }
                            
                            return true;
                        }

                        @Override
                        public void after(Object Object) {
                            
                            try{

                                if(Object instanceof Boolean){
                                    DialogsFactory.getSingleton().showOKOperationCompletedCallbackDialog(jFrame, (JFrame jFrame1) -> {
                                    });
                                }
                                else{
                                    
                                    final Exception ex = (Exception)Object;
                                    
                                    try {
                                        DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
                                    } catch (Exception ex1) {
                                        Logger.getLogger(PrincipViewController.class.getName()).log(Level.SEVERE, null, ex1);
                                    }
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
                        
                    });
                    BaseSwingWorker.execute();
                                        
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
            LoggerUtility.getSingleton().logError(CorrElecsViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(CorrElecsViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    @Override
    public List<?> getItemsToLoadInTable() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
