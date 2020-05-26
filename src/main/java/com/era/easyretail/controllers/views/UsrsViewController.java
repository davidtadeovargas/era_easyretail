/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.easyretail.controllers.views;

import com.era.datamodels.enums.SearchCommonTypeEnum;
import com.era.easyretail.validators.NewUsersValidator;
import com.era.easyretail.validators.UpdateUsersValidator;
import com.era.easyretail.validators.exceptions.ExistsUserException;
import com.era.easyretail.validators.exceptions.MissingUserException;
import com.era.easyretail.validators.exceptions.NotExistsUserException;
import com.era.easyretail.validators.exceptions.WarehouseNotExistsException;
import com.era.logger.LoggerUtility;
import com.era.models.User;
import com.era.repositories.RepositoryFactory;
import com.era.utilities.FileChooserUtility;
import com.era.utilities.UtilitiesFactory;
import com.era.views.UsrsJFrame;
import com.era.views.dialogs.DialogsFactory;
import com.era.views.dialogs.ErrorOKDialog;
import com.era.views.dialogs.OKDialog;
import com.era.views.dialogs.QuestionDialog;
import com.era.views.tables.headers.TableHeaderFactory;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.event.ListSelectionEvent;

/**
 *
 * @author PC
 */
public class UsrsViewController extends UsrsJFrame {
    
    private User User_;
    
    
    
    
    public UsrsViewController(){
        
        super("window_title_verusers");
        
        try{
            
            jLImg.setVisible(false);

            //Set defalut button
            this.setDefaultButton(jBNew);

            //This button close the frame
            disposeButton(jBSal);
            
            jTEstac.grabFocus();

            //Onlu numbers
            this.JComponentUtils.onlyNumbers(jTDesc);
            this.JComponentUtils.onlyNumbers(jTComi);
            this.JComponentUtils.onlyNumbers(jTCP);
            
            //Get all the users and load them in table
            this.BaseJTable = jTab;
            this.BaseJTable.addShowColumn(TableHeaderFactory.getSigleton().getUsersTableHeader().getNO());
            this.BaseJTable.addShowColumn(TableHeaderFactory.getSigleton().getUsersTableHeader().getUSER());
            this.BaseJTable.addShowColumn(TableHeaderFactory.getSigleton().getUsersTableHeader().getNAME());
            this.loadAllItemsInTable();
            
            //When the table is selected
            jTab.setITableRowSelected((ListSelectionEvent lse, Object Object) -> {
                
                //Cast the model
                final User User = (User)Object;
                
                //Save the selected user globally
                User_ = User;                                
                
                //Clear all fields befor load new ones
                clearAllForm();
                
                //The user code can not change for editing
                jTEstac.setEditable(false);
                
                //Load all the user information in fields
                loadUserInfoInFields(User);
            });
            
            jBBusc.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBBuscActionPerformed(evt);
            });
            jBMostT.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBMostTActionPerformed(evt);
            });
            jBDel.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBDelActionPerformed(evt);
            });
            jBLim.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBLimActionPerformed(evt);
            });
            jBNew.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBNewActionPerformed(evt);
            });
            jBGuar.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBGuarActionPerformed(evt);
            });
            jBCargImg.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBCargImgActionPerformed(evt);
            });
            jBDelImg.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBDelImgActionPerformed(evt);
            });
            jBtnAlmacen.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBtnAlmacenActionPerformed(evt);
            });
            jBVe.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBVeActionPerformed(evt);
            });            
                                
        }catch (Exception ex) {
            LoggerUtility.getSingleton().logError(UsrsViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(UsrsViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    private void jBVeActionPerformed(java.awt.event.ActionEvent evt) {
        
        try{
            
            //First select user
            if(!jTab.isRowSelected()){
                final OKDialog OKDialog = DialogsFactory.getSingleton().getOKDialog(baseJFrame);
                OKDialog.setPropertyText("selection_first");
                OKDialog.show();
                return;
            }

            //Cast the model
            final User User = (User)this.jTab.getRowSelected();
            
            //Validate that the image exists before
            final String userImagePath = UtilitiesFactory.getSingleton().getImagesUtility().getUserImagePath(User.getCode());
            if(!UtilitiesFactory.getSingleton().getFilesUtility().fileExists(userImagePath)){
                DialogsFactory.getSingleton().showErrorOKDialog(baseJFrame, "errors_file_not_exists");
                return;
            }
            
            //Open the image
            UtilitiesFactory.getSingleton().getImagesUtility().openImageInVisor(userImagePath);            
            
        }catch (Exception ex) {
                    
            LoggerUtility.getSingleton().logError(UsrsViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(UsrsViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    private void jBtnAlmacenActionPerformed(java.awt.event.ActionEvent evt) {
        
        try{
            
            //Search warehouse
            final SearchViewController SearchViewController = new SearchViewController();
            SearchViewController.setSEARCH_TYPE(SearchCommonTypeEnum.WAREHOUSES);
            SearchViewController.setButtonAceptClicked(() -> {

                final String warehouseCode = SearchViewController.getCod();
                jTxtAlmacen.setText(warehouseCode);
            });
            SearchViewController.setVisible();
            
        }catch (Exception ex) {
                    
            LoggerUtility.getSingleton().logError(UsrsViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(UsrsViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    private void jBDelImgActionPerformed(java.awt.event.ActionEvent evt) {
        
        try{
            
            //First select user
            if(!jTab.isRowSelected()){
                final OKDialog OKDialog = DialogsFactory.getSingleton().getOKDialog(baseJFrame);
                OKDialog.setPropertyText("selection_first");
                OKDialog.show();
                return;
            }
            //Cast the model
            final User User = (User)this.jTab.getRowSelected();
            
            //Validate that the user has asociated image
            final boolean userImageExists = UtilitiesFactory.getSingleton().getImagesUtility().usersImageExists(User.getCode());
            if(!userImageExists){
                
                final OKDialog OKDialog = DialogsFactory.getSingleton().getOKDialog(baseJFrame);
                OKDialog.setPropertyText("errors_not_image_asociated");
                OKDialog.show();
                return;
            }
            
            //Question to continue
            DialogsFactory.getSingleton().showQuestionContinueDialog(baseJFrame, (JFrame jFrame) -> {
            
                try{
                    
                    //Remove image from disk
                    UtilitiesFactory.getSingleton().getImagesUtility().deleteUserImage(User.getCode());

                    //Remove image from user
                    jLImg.setVisible(false);
                    jLImg.setIcon(null);

                    //Show success dialog
                    final OKDialog OKDialog = DialogsFactory.getSingleton().getOKDialog(jFrame);
                    OKDialog.setPropertyText("operation_completed");
                    OKDialog.show();
                    
                }catch (Exception ex) {
                    
                    LoggerUtility.getSingleton().logError(UsrsViewController.class, ex);
                    try {
                        DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
                    } catch (Exception ex1) {
                        Logger.getLogger(UsrsViewController.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                }
            });
            
        }catch (Exception ex) {
                    
            LoggerUtility.getSingleton().logError(UsrsViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(UsrsViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    private void jBCargImgActionPerformed(java.awt.event.ActionEvent evt) {
        
        try{
            
            //First select user
            if(!jTab.isRowSelected()){
                final OKDialog OKDialog = DialogsFactory.getSingleton().getOKDialog(baseJFrame);
                OKDialog.setPropertyText("selection_first");
                OKDialog.show();
                return;
            }
            
            //Search for the image
            final FileChooserUtility FileChooserUtility = UtilitiesFactory.getSingleton().getFileChooserUtility();
            FileChooserUtility.setPropertyTitle("");
            FileChooserUtility.setIApproveOpption((String absolutePath, String fileName) -> {
                
                try{
                    
                    //Validate that the image format is valid
                    if (    !fileName.endsWith(".jpg") && 
                            !fileName.endsWith(".jpeg") && 
                            !fileName.endsWith(".bmp") && 
                            !fileName.endsWith(".gif") && 
                            !fileName.endsWith(".png")) {
                        
                        final ErrorOKDialog ErrorOKDialog = DialogsFactory.getSingleton().getErrorOKDialog(baseJFrame);
                        ErrorOKDialog.setPropertyText("error_invalid_image_format");
                        ErrorOKDialog.show();
                        return;
                    }
                    
                    //Get selected model
                    final User User = (User) jTab.getRowSelected();
                    
                    //Create the final path
                    final String finalPath = absolutePath + "\\" + fileName;
                    
                    //Save the user image in folder
                    UtilitiesFactory.getSingleton().getImagesUtility().saveUserImage(User.getCode(), finalPath);
                    
                    //Load image in the panel
                    jLImg.setIcon(new ImageIcon(UtilitiesFactory.getSingleton().getImagesUtility().getUserImagePath(User.getCode())));
                    jLImg.setVisible(true);
                    
                }catch (Exception ex) {
                    
                    LoggerUtility.getSingleton().logError(UsrsViewController.class, ex);
                    try {
                        DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
                    } catch (Exception ex1) {
                        Logger.getLogger(UsrsViewController.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                }                                    
            });
            FileChooserUtility.showSaveDialog(baseJFrame);
            
        }catch (Exception ex) {
                    
            LoggerUtility.getSingleton().logError(UsrsViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(UsrsViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    private void saveOrUpdateUser(final boolean update){
        
        try{
            
            //Validate that all is filled properly
            if(!update){
                
                try{

                    final NewUsersValidator UsersValidator = new NewUsersValidator();
                    UsersValidator.setUser(jTEstac);
                    UsersValidator.setAlmacen(jTxtAlmacen);
                    UsersValidator.validate();

                }catch(Exception ex){

                    if(ex instanceof ExistsUserException){

                    }
                    else if(ex instanceof MissingUserException){

                    }
                    else if(ex instanceof WarehouseNotExistsException){

                    }

                    final ErrorOKDialog ErrorOKDialog = DialogsFactory.getSingleton().getErrorOKDialog(baseJFrame);
                    ErrorOKDialog.setPropertyText(ex.getMessage());
                    ErrorOKDialog.show();                
                    return;
                }
            }
            else{
                
                try{

                    final UpdateUsersValidator UpdateUsersValidator = new UpdateUsersValidator();
                    UpdateUsersValidator.setUser(jTEstac);
                    UpdateUsersValidator.setAlmacen(jTxtAlmacen);
                    UpdateUsersValidator.validate();

                }catch(Exception ex){

                    if(ex instanceof NotExistsUserException){

                    }
                    else if(ex instanceof MissingUserException){

                    }
                    else if(ex instanceof WarehouseNotExistsException){

                    }

                    final ErrorOKDialog ErrorOKDialog = DialogsFactory.getSingleton().getErrorOKDialog(baseJFrame);
                    ErrorOKDialog.setPropertyText(ex.getMessage());
                    ErrorOKDialog.show();                
                    return;
                }
            }                            

            //Question if continue
            final QuestionDialog QuestionDialog = DialogsFactory.getSingleton().getQuestionDialog(baseJFrame);
            QuestionDialog.setPropertyText("question_continue");
            QuestionDialog.setOKDialogInterface((JFrame jFrame) -> {
         
                try{
                    
                    //Get all the individual fields
                    final String estacion = jTEstac.getText().replace(" ", "").trim();
                    final String almacen = jTxtAlmacen.getText().replace(" ", "").trim();                                
                    final String name = jTNom.getText();                                  
                    final String street = jTCall.getText();                                
                    final String colony = jTCol.getText();                                
                    final String cp = jTCP.getText();  
                    final String discount = jTDesc.getText();
                    final int enableDesc = jCHabDesc.isSelected() ? 1 : 0;
                    final String phone = jTTel.getText();                               
                    final String cellphone = jTCel.getText();                               
                    final String country = jTPai.getText();                               
                    final String state = jTEstad.getText().replace(" ", "").trim();                                             
                    final String noint = jTNoInt.getText();                               
                    final String noext = jTNoExt.getText();                              
                    final boolean admcaj = jCAdmCaj.isSelected();             
                    final boolean vend = jCVend.isSelected();         
                    final String city = jTCiu.getText().replace("'", "''");                         
                    final float commision = Float.valueOf(jTComi.getText().trim());                            
                    final boolean ptovta = jCPto.isSelected();               
                    final String email = jTCorreo.getText();
                    
                    if(!update){
                        User_ = new User();
                        User_.setCode(jTEstac.getText().trim());
                    }
                    
                     //Create the user model
                    User_.setState(estacion);
                    User_.setAlmacen(almacen);
                    User_.setName(name);
                    User_.setStreet(street);
                    User_.setColony(colony);
                    User_.setCp(Integer.valueOf(cp));
                    User_.setDisccount(Float.valueOf(discount));
                    User_.setEnableDisccount(enableDesc==1);
                    User_.setPhone(phone);
                    User_.setCellphone(cellphone);
                    User_.setCountry(country);
                    User_.setState(state);
                    User_.setNoext(noext);
                    User_.setNoint(noint);
                    User_.setCasherAdmin(admcaj);
                    User_.setSalesMan(vend);
                    User_.setCity(city);
                    User_.setCommission(commision);
                    User_.setPtovta(ptovta);
                    User_.setEmail(email);
                    User_.setPassword(new String(JTContrasenia.getPassword()));
                    
                    //Save or update the new user in database
                    if(!update){                        
                        RepositoryFactory.getInstance().getUsersRepository().addUser(User_);
                    }
                    else{
                        RepositoryFactory.getInstance().getUsersRepository().updateUser(User_);
                    }
                                        
                    jTEstac.grabFocus();

                    //Reload the users table
                    this.jTab.loadAllItemsInTable();
                    
                    final OKDialog OKDialog = DialogsFactory.getSingleton().getOKDialog(baseJFrame);
                    OKDialog.setPropertyText("operation_completed");
                    OKDialog.show();
                    
                }catch (Exception ex) {
                    
                    LoggerUtility.getSingleton().logError(UsrsViewController.class, ex);
                    try {
                        DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
                    } catch (Exception ex1) {
                        Logger.getLogger(UsrsViewController.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                }                    
            });
            QuestionDialog.show();                            
            
        }catch (Exception ex) {
            LoggerUtility.getSingleton().logError(UsrsViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(UsrsViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    
    private void jBGuarActionPerformed(java.awt.event.ActionEvent evt) {
        saveOrUpdateUser(true);
    }
    
    private void jBLimActionPerformed(java.awt.event.ActionEvent evt) {
        clearAllForm();
        
        //Clear table selection
        jTab.clearSelection();
    }
    
    private void clearAllForm(){
        
        try{                        
            
            JTContrasenia.setText("");
            jTEstac.setText("");
            jTxtAlmacen.setText("");
            jTNom.setText("");
            jTCall.setText("");
            jTCol.setText("");
            jTCP.setText("0");
            jTDesc.setText("0");
            jCHabDesc.setSelected(false);
            jTTel.setText("");
            jTCel.setText("");
            jTPai.setText("");
            jTEstad.setText("");
            jTNoInt.setText("");
            jTNoExt.setText("");
            jCAdmCaj.setSelected(false);
            jCVend.setSelected(false);
            jTCiu.setText("");
            jTComi.setText("0");
            jCPto.setSelected(false);
            jTCorreo.setText("");
            
            //Clear table selection
            //jTab.clearSelection();
            
            //Remove image from user
            jLImg.setVisible(false);
            jLImg.setIcon(null);

            jTEstac.setEditable(true);
                
        }catch (Exception ex) {
            LoggerUtility.getSingleton().logError(UsrsViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(UsrsViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    private void jBNewActionPerformed(java.awt.event.ActionEvent evt) {                                             
        
        try{                        
            
            saveOrUpdateUser(false);
            
        }catch (Exception ex) {
            LoggerUtility.getSingleton().logError(UsrsViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(UsrsViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    private void jBDelActionPerformed(java.awt.event.ActionEvent evt) {                                             
        
        try{                        
            
            //If no row selected return
            if(!jTab.isRowSelected()){
                final OKDialog OKDialog = DialogsFactory.getSingleton().getOKDialog(baseJFrame);
                OKDialog.setPropertyText("selection_first");
                OKDialog.show();
                return;
            }
            
            //Get the selected model
            final User User = (User) jTab.getRowSelected();
            
            //Supervisor user can not be deleted
            if(User.isSupervisor()){
                final OKDialog OKDialog = DialogsFactory.getSingleton().getOKDialog(baseJFrame);
                OKDialog.setPropertyText("user_cannot_be_deleted");
                OKDialog.show();
                return;
            }
            
            //Question if continue
            final QuestionDialog QuestionDialog = DialogsFactory.getSingleton().getQuestionDialog(baseJFrame);
            QuestionDialog.setPropertyText("question_continue");
            QuestionDialog.setOKDialogInterface((JFrame jFrame) -> {
                
                try{
                    
                    //Delete user from database
                    RepositoryFactory.getInstance().getUsersRepository().delete(User);

                    //Show success dialog to user
                    final OKDialog OKDialog = DialogsFactory.getSingleton().getOKDialog(baseJFrame);
                    OKDialog.setPropertyText("operation_completed");
                    OKDialog.show();

                    //Clear all form
                    clearAllForm();
                    
                    //Clear table selection
                    jTab.clearSelection();
                    
                    //Realod the users table
                    this.jTab.loadAllItemsInTable();
                    
                }catch (Exception ex) {
                    LoggerUtility.getSingleton().logError(UsrsViewController.class, ex);
                    try {
                        DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
                    } catch (Exception ex1) {
                        Logger.getLogger(UsrsViewController.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                }
            });
            QuestionDialog.show();                        
            
        }catch (Exception ex) {
            LoggerUtility.getSingleton().logError(UsrsViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(UsrsViewController.class.getName()).log(Level.SEVERE, null, ex1);
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
            this.jTab.loadAllItemsInTable();
            
        }catch (Exception ex) {
            LoggerUtility.getSingleton().logError(UsrsViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(UsrsViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    private void jBMostTActionPerformed(java.awt.event.ActionEvent evt) {                                             
        
        try{
            
            //Load all the users
            this.jTab.loadAllItemsInTable();
            
        }catch (Exception ex) {
            LoggerUtility.getSingleton().logError(UsrsViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(UsrsViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    private void loadUserInfoInFields(final User User){
        
        try{
            
            jTEstac.setText(User.getCode());
            jTDesc.setText(String.valueOf(User.getDisccount()));
            final String decryptedPassword = UtilitiesFactory.getSingleton().getSecurityUtil().decryptString(User.getPassword());            
            LoggerUtility.getSingleton().logInfo(UsrsViewController.class, "Decrypted password: " + decryptedPassword);
            JTContrasenia.setText(decryptedPassword);            
            jTCall.setText(User.getStreet());
            jTCol.setText(User.getColony());
            jTCP.setText(String.valueOf(User.getCp()));
            jTTel.setText(User.getPhone());
            jTCel.setText(User.getCellphone());
            jTEstad.setText(User.getState());
            jTPai.setText(User.getCountry());
            jTNoExt.setText(User.getNoext());
            jTNoInt.setText(User.getNoint());
            jTNom.setText(User.getName());
            jTCiu.setText(User.getCity());
            jTxtAlmacen.setText(User.getAlmacen());
            jCHabDesc.setSelected(User.getEnableDisccount());
            jCPto.setSelected(User.isPtovta());
            jCVend.setSelected(User.isSalesMan());
            jCAdmCaj.setSelected(User.isCasherAdmin());
            jTCorreo.setText(User.getEmail());

            //If is SUP user we can not change some properties
            if(User.isSupervisor()){
                jCPto.setEnabled(false);
                jCAdmCaj.setSelected(true);
                jCAdmCaj.setEnabled(false);
            }
            else{
                jCPto.setEnabled(true);
                jCAdmCaj.setEnabled(true);
            }
            
            //If the user has image
            if(UtilitiesFactory.getSingleton().getImagesUtility().usersImageExists(User.getCode())){
                
                //Get the user image path
                final String userImagePath = UtilitiesFactory.getSingleton().getImagesUtility().getUserImagePath(User.getCode());
                
                //Load the image in the panel
                jLImg.setIcon(new ImageIcon(userImagePath));
                jLImg.setVisible(true);
            }
            
        }catch (Exception ex) {
            LoggerUtility.getSingleton().logError(UsrsViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(UsrsViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }

    @Override
    public List<?> getItemsToLoadInTable() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}