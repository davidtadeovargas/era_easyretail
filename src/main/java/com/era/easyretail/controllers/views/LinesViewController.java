/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.easyretail.controllers.views;

import com.era.views.LinesJFrame;
import java.util.List;
import com.era.logger.LoggerUtility;
import com.era.models.Line;
import com.era.repositories.RepositoryFactory;
import com.era.utilities.UtilitiesFactory;
import com.era.utilities.filechooser.ImageFileChooserUtility;
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
public class LinesViewController extends LinesJFrame {
 
    public LinesViewController() {
        super("window_title_lines");
        
        try{
                                       
            jBVeGran.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBVeGranActionPerformed(evt);
            });
            jBDelImg.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBDelImgActionPerformed(evt);
            });
            jBCargImg.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBCargImgActionPerformed(evt);
            });
            jBDel.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBDelActionPerformed(evt);
            });
            jBNew.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBNewActionPerformed(evt);
            });
            jBBusc.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBBuscActionPerformed(evt);
            });
            jBMostT.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBMostTActionPerformed(evt);
            });
            jBActua.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBActuaActionPerformed(evt);
            });

            //Connect the image
            this.initImageControls(jLImg, jPanImg);
            
            this.disposeButton(jBSal);
            
            //Config table
            this.BaseJTable = jTab;
            jTab.addShowColumn(TableHeaderFactory.getSigleton().getLinesTableHeader().getROWNUMBER());
            jTab.addShowColumn(TableHeaderFactory.getSigleton().getLinesTableHeader().getCODE());
            jTab.addShowColumn(TableHeaderFactory.getSigleton().getLinesTableHeader().getDESCRIPTION());
            
            jTab.setITableRowSelected((ListSelectionEvent lse, Object Object) -> {
                
                try {
                    
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
            
            //Load all
            jTab.loadAllItemsInTable();
            
        }catch (Exception ex) {
            LoggerUtility.getSingleton().logError(LinesViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(LinesViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    @Override
    public void loadModelInFields(Object ObjectModel) throws  Exception {
        
        //Cast model
        final Line Line = (Line)ObjectModel;
        
        jTCod.setText(Line.getCode());
        jTDescrip.setText(Line.getDescription());
        
        //Check if the image product exists
        final boolean imageExists = UtilitiesFactory.getSingleton().getImagesUtility().lineImageExists(Line.getCode());
        
        //If exists
        if(imageExists){
            
            //Get image path
            final String imagePath = UtilitiesFactory.getSingleton().getImagesUtility().getLineImagePath(Line.getCode());
            
            //Show image
            showImage(imagePath);
        }
        else{
            hideImage();
        }
    }
    
    @Override
    public void clearFields() throws Exception{
        
        jTCod.setText("");
        jTDescrip.setText("");
        jTab.clearSelection();
    }
    
    private void jBActuaActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            saveOrUpdate(false);
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(this.getClass(), ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBMostTActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            this.jTab.loadAllItemsInTable();
            
            this.clearFields();
	}
	catch (Exception ex) {
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
            this.jTab.getByLikeEncabezados(search);
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(this.getClass(), ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void saveOrUpdate(final boolean save) {
        
        try{
            
            final String code = jTCod.getText().trim();
            if(save){
                
                //First type code
                if(code.isEmpty()){
                    DialogsFactory.getSingleton().showOKEmptyFieldCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                        jTCod.grabFocus();
                    });
                    return;
                }
            }
            else{
                
                //First select from table                
                if(!jTab.isRowSelected()){
                    DialogsFactory.getSingleton().showOKEmptyFieldCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                        jTCod.grabFocus();
                    });
                    return;
                }
            }
            
            //First select description
            final String description = jTDescrip.getText().trim();
            if(description.isEmpty()){
                DialogsFactory.getSingleton().showOKEmptyFieldCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                    jTDescrip.grabFocus();
                });
                return;
            }
            
            //If it is for new
            if(save){
                
                //The code must be unique
                Line Line = (Line)RepositoryFactory.getInstance().getLinesRepository().getByCode(code);
                if(Line!=null){
                    DialogsFactory.getSingleton().showErrorRecordExistsOKDialog(baseJFrame, (JFrame jFrame1) -> {
                        jTCod.grabFocus();
                    });
                    return;
                }
            }
            
            DialogsFactory.getSingleton().showQuestionContinueDialog(baseJFrame, (JFrame jFrame) -> {
                
                try {
                    
                    //Create the model
                    Line Lines_;
                    if(save){
                        Lines_ = new Line();
                    }
                    else{
                        Lines_ = (Line)jTab.getRowSelected();
                    }
                    Lines_.setCode(code);
                    Lines_.setDescription(description);
                    
                    if(save){
                        RepositoryFactory.getInstance().getLinesRepository().save(Lines_);
                    }
                    else{
                        RepositoryFactory.getInstance().getLinesRepository().update(Lines_);
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
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(this.getClass(), ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBNewActionPerformed(java.awt.event.ActionEvent evt) {
        saveOrUpdate(true);
    }
        
    private void jBVeGranActionPerformed(java.awt.event.ActionEvent evt) {
        
        try {
            
            //First select from table                
            if(!jTab.isRowSelected()){
                DialogsFactory.getSingleton().showErrorOKNoSelectionCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                    jTCod.grabFocus();
                });
                return;
            }
            
            //Get the selected line
            final Line Line = (Line)jTab.getRowSelected();
            
            //If the image doesnt exists
            if(!UtilitiesFactory.getSingleton().getImagesUtility().lineImageExists(Line.getCode())){
                DialogsFactory.getSingleton().showErrorFileNotExistsOKDialog(baseJFrame, (JFrame jFrame) -> {
                });
                return;
            }
            
            //Get the line image path
            final String lineImagePath = UtilitiesFactory.getSingleton().getImagesUtility().getLineImagePath(Line.getCode());
            
            //Open the image
            UtilitiesFactory.getSingleton().getDesktopUtility().open(lineImagePath);
            
        } catch (Exception ex) {
            LoggerUtility.getSingleton().logError(this.getClass(), ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    private void jBDelImgActionPerformed(java.awt.event.ActionEvent evt) {
        
        try {
            
            //First select from table                
            if(!jTab.isRowSelected()){
                DialogsFactory.getSingleton().showErrorOKNoSelectionCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                    jTCod.grabFocus();
                });
                return;
            }
            
            //Get selected line
            final Line Line = (Line)jTab.getRowSelected();
                    
            //If image doesnt exists stop
            if(!UtilitiesFactory.getSingleton().getImagesUtility().lineImageExists(Line.getCode())){
                DialogsFactory.getSingleton().showErrorFileNotExistsOKDialog(baseJFrame, (JFrame jFrame) -> {
                });
                return;
            }
            
            //Question if continue
            DialogsFactory.getSingleton().showQuestionContinueDialog(baseJFrame, (JFrame jFrame) -> {
               
                try{
                    
                    //Delete the line image                    
                    UtilitiesFactory.getSingleton().getImagesUtility().deleteLineImage(Line.getCode());

                    hideImage();

                    DialogsFactory.getSingleton().showOKOperationCompletedCallbackDialog(jFrame, null);
                }
                catch (Exception ex) {
                    LoggerUtility.getSingleton().logError(ProdsViewController.class, ex);
                    try {
                            DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
                    } catch (Exception ex1) {
                            Logger.getLogger(ProdsViewController.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                }
            });
            
        } catch (Exception ex) {
            LoggerUtility.getSingleton().logError(this.getClass(), ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    private void jBCargImgActionPerformed(java.awt.event.ActionEvent evt) {
        
        try {
            
            //First select from table                
            if(!jTab.isRowSelected()){                                
                DialogsFactory.getSingleton().showErrorOKNoSelectionCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                    jTCod.grabFocus();
                });
                return;
            }                      
            
            //User choose image
            final ImageFileChooserUtility ImageFileChooserUtility = UtilitiesFactory.getSingleton().getImageFileChooserUtility();
            ImageFileChooserUtility.setIApproveOpption((String absolutePath, String fileName) -> {
                
                try{
                    
                    //Get selected line
                    final Line Line = (Line)jTab.getRowSelected();
                    
                    //Create the final path
                    final String finalPath = absolutePath + "\\" + fileName;

                    //Save the image 
                    UtilitiesFactory.getSingleton().getImagesUtility().saveLineImage(Line.getCode(), finalPath);

                    //Show image
                    showImage(finalPath);
                    
                    //Announce the user
                    DialogsFactory.getSingleton().showOKOperationCompletedCallbackDialog(baseJFrame, null);
                    
                }catch (Exception ex) {
                    LoggerUtility.getSingleton().logError(ProdsViewController.class, ex);
                    try {
                            DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
                    } catch (Exception ex1) {
                            Logger.getLogger(ProdsViewController.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                }
            });
            ImageFileChooserUtility.showSaveDialog(baseJFrame);
            
        } catch (Exception ex) {
            LoggerUtility.getSingleton().logError(this.getClass(), ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    private void jBDelActionPerformed(java.awt.event.ActionEvent evt) {

	try{            	
            
            //First select from table                
            if(!jTab.isRowSelected()){
                DialogsFactory.getSingleton().showOKEmptyFieldCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                    jTCod.grabFocus();
                });
                return;
            }
            
            DialogsFactory.getSingleton().showQuestionContinueDialog(baseJFrame, (JFrame jFrame) -> {
                
                try {
                    
                    //Get selected object
                    final Line Line = (Line)jTab.getRowSelected();
    
                    //Delete from the db
                    RepositoryFactory.getInstance().getLinesRepository().delete(Line);                    
                    
                    //Remove from the table
                    jTab.deleteObject(Line);
                    
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
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(this.getClass(), ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    @Override
    public List<?> getItemsToLoadInTable() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
