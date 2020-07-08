/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.easyretail.controllers.views;

import com.era.datamodels.LPrecsDatamodel;
import com.era.views.LPrecsJFrame;
import java.util.List;
import com.era.logger.LoggerUtility;
import com.era.utilities.UtilitiesFactory;
import com.era.views.dialogs.DialogsFactory;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
/**
 *
 * @author PC
 */
public class LPrecsViewController extends LPrecsJFrame {
    
    private LPrecsDatamodel LPrecsDatamodel;
    private OnResult OnResult;
    
    public LPrecsViewController() {
        super("window_title_lprecs");
        
        try{
                     
            jBSal.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBSalActionPerformed(evt);
            });
            jBGuar.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBGuarActionPerformed(evt);
            });
            
            //Money format
            this.JComponentUtils.moneyFormat(jTPre1);
            this.JComponentUtils.moneyFormat(jTPre2);
            this.JComponentUtils.moneyFormat(jTPre3);
            this.JComponentUtils.moneyFormat(jTPre4);
            this.JComponentUtils.moneyFormat(jTPre5);
            this.JComponentUtils.moneyFormat(jTPre6);
            this.JComponentUtils.moneyFormat(jTPre7);
            this.JComponentUtils.moneyFormat(jTPre8);
            this.JComponentUtils.moneyFormat(jTPre9);
            this.JComponentUtils.moneyFormat(jTPre10);
            
            //Decimal format
            this.JComponentUtils.onlyDecimals(jTUti1);
            this.JComponentUtils.onlyDecimals(jTUti2);
            this.JComponentUtils.onlyDecimals(jTUti3);
            this.JComponentUtils.onlyDecimals(jTUti4);
            this.JComponentUtils.onlyDecimals(jTUti5);
            this.JComponentUtils.onlyDecimals(jTUti6);
            this.JComponentUtils.onlyDecimals(jTUti7);
            this.JComponentUtils.onlyDecimals(jTUti8);
            this.JComponentUtils.onlyDecimals(jTUti9);
            this.JComponentUtils.onlyDecimals(jTUti10);
            this.JComponentUtils.onlyDecimals(jTUtil1V);
            this.JComponentUtils.onlyDecimals(jTUtil2V);
            this.JComponentUtils.onlyDecimals(jTUtil3V);
            this.JComponentUtils.onlyDecimals(jTUtil4V);
            this.JComponentUtils.onlyDecimals(jTUtil5V);
            this.JComponentUtils.onlyDecimals(jTUtil6V);
            this.JComponentUtils.onlyDecimals(jTUtil7V);
            this.JComponentUtils.onlyDecimals(jTUtil8V);
            this.JComponentUtils.onlyDecimals(jTUtil9V);
            this.JComponentUtils.onlyDecimals(jTUtil10V);
            
            jTPre1.grabFocus();
            
        }catch (Exception ex) {
            LoggerUtility.getSingleton().logError(LPrecsViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(LPrecsViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    @Override
    public void clearFields() throws Exception{            
    }
    
    @Override
    public void loadModelInFields(Object ObjectModel) throws  Exception {
        
        //Cast model
        final LPrecsDatamodel LPrecsDatamodel_ = (LPrecsDatamodel)ObjectModel;
    
        //Create values
        String priceList1 = LPrecsDatamodel_.getPriceList1();
        String priceList2 = LPrecsDatamodel_.getPriceList2();
        String priceList3 = LPrecsDatamodel_.getPriceList3();
        String priceList4 = LPrecsDatamodel_.getPriceList4();
        String priceList5 = LPrecsDatamodel_.getPriceList5();
        String priceList6 = LPrecsDatamodel_.getPriceList6();
        String priceList7 = LPrecsDatamodel_.getPriceList7();
        String priceList8 = LPrecsDatamodel_.getPriceList8();
        String priceList9 = LPrecsDatamodel_.getPriceList9();
        String priceList10 = LPrecsDatamodel_.getPriceList10();

        //Money format
        priceList1 = UtilitiesFactory.getSingleton().getNumbersUtility().toMoneyFormat(priceList1);
        priceList2 = UtilitiesFactory.getSingleton().getNumbersUtility().toMoneyFormat(priceList2);
        priceList3 = UtilitiesFactory.getSingleton().getNumbersUtility().toMoneyFormat(priceList3);
        priceList4 = UtilitiesFactory.getSingleton().getNumbersUtility().toMoneyFormat(priceList4);
        priceList5 = UtilitiesFactory.getSingleton().getNumbersUtility().toMoneyFormat(priceList5);
        priceList6 = UtilitiesFactory.getSingleton().getNumbersUtility().toMoneyFormat(priceList6);
        priceList7 = UtilitiesFactory.getSingleton().getNumbersUtility().toMoneyFormat(priceList7);
        priceList8 = UtilitiesFactory.getSingleton().getNumbersUtility().toMoneyFormat(priceList8);
        priceList9 = UtilitiesFactory.getSingleton().getNumbersUtility().toMoneyFormat(priceList9);
        priceList10 = UtilitiesFactory.getSingleton().getNumbersUtility().toMoneyFormat(priceList10);
        
        //Load all the list prices in the fields
        jTPre1.setText(priceList1);
        jTPre2.setText(priceList2);
        jTPre3.setText(priceList3);
        jTPre4.setText(priceList4);
        jTPre5.setText(priceList5);
        jTPre6.setText(priceList6);
        jTPre7.setText(priceList7);
        jTPre8.setText(priceList8);
        jTPre9.setText(priceList9);
        jTPre10.setText(priceList10);
        
        //Load all the utility in the fields
        jTUti1.setText(String.valueOf(LPrecsDatamodel_.getUtility1()));
        jTUti2.setText(String.valueOf(LPrecsDatamodel_.getUtility2()));
        jTUti3.setText(String.valueOf(LPrecsDatamodel_.getUtility3()));
        jTUti4.setText(String.valueOf(LPrecsDatamodel_.getUtility4()));
        jTUti5.setText(String.valueOf(LPrecsDatamodel_.getUtility5()));
        jTUti6.setText(String.valueOf(LPrecsDatamodel_.getUtility6()));
        jTUti7.setText(String.valueOf(LPrecsDatamodel_.getUtility7()));
        jTUti8.setText(String.valueOf(LPrecsDatamodel_.getUtility8()));
        jTUti9.setText(String.valueOf(LPrecsDatamodel_.getUtility9()));
        jTUti10.setText(String.valueOf(LPrecsDatamodel_.getUtility10()));
        
        //Load all the utility sales in the fields
        jTUtil1V.setText(String.valueOf(LPrecsDatamodel_.getUtilSales1()));
        jTUtil2V.setText(String.valueOf(LPrecsDatamodel_.getUtilSales2()));
        jTUtil3V.setText(String.valueOf(LPrecsDatamodel_.getUtilSales3()));
        jTUtil4V.setText(String.valueOf(LPrecsDatamodel_.getUtilSales4()));
        jTUtil5V.setText(String.valueOf(LPrecsDatamodel_.getUtilSales5()));
        jTUtil6V.setText(String.valueOf(LPrecsDatamodel_.getUtilSales6()));
        jTUtil7V.setText(String.valueOf(LPrecsDatamodel_.getUtilSales7()));
        jTUtil8V.setText(String.valueOf(LPrecsDatamodel_.getUtilSales8()));
        jTUtil9V.setText(String.valueOf(LPrecsDatamodel_.getUtilSales9()));
        jTUtil10V.setText(String.valueOf(LPrecsDatamodel_.getUtilSales10()));
    }

    public void setLPrecsDatamodel(LPrecsDatamodel LPrecsDatamodel) throws Exception {
        
        //Save the produto globally
        this.LPrecsDatamodel = LPrecsDatamodel;
        
        //Load all into fields
        loadModelInFields(this.LPrecsDatamodel);
    }
    
    private void jBGuarActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{
            
            //Question if continue
            DialogsFactory.getSingleton().showQuestionContinueDialog(baseJFrame, (JFrame jFrame) -> {
                
                try{
                    
                    //Get all the fields
                    String priceList1 = jTPre1.getText().trim();
                    String priceList2 = jTPre2.getText().trim();
                    String priceList3 = jTPre3.getText().trim();
                    String priceList4 = jTPre4.getText().trim();
                    String priceList5 = jTPre5.getText().trim();
                    String priceList6 = jTPre6.getText().trim();
                    String priceList7 = jTPre7.getText().trim();
                    String priceList8 = jTPre8.getText().trim();
                    String priceList9 = jTPre9.getText().trim();
                    String priceList10 = jTPre10.getText().trim();

                    String utility1 = jTUti1.getText().trim();
                    String utility2 = jTUti2.getText().trim();
                    String utility3 = jTUti3.getText().trim();
                    String utility4 = jTUti4.getText().trim();
                    String utility5 = jTUti5.getText().trim();
                    String utility6 = jTUti6.getText().trim();
                    String utility7 = jTUti7.getText().trim();
                    String utility8 = jTUti8.getText().trim();
                    String utility9 = jTUti9.getText().trim();
                    String utility10 = jTUti10.getText().trim();

                    String utilSales1 = jTUtil1V.getText().trim();
                    String utilSales2 = jTUtil2V.getText().trim();
                    String utilSales3 = jTUtil3V.getText().trim();
                    String utilSales4 = jTUtil4V.getText().trim();
                    String utilSales5 = jTUtil5V.getText().trim();
                    String utilSales6 = jTUtil6V.getText().trim();
                    String utilSales7 = jTUtil7V.getText().trim();
                    String utilSales8 = jTUtil8V.getText().trim();
                    String utilSales9 = jTUtil9V.getText().trim();
                    String utilSales10 = jTUtil10V.getText().trim();

                    //Santice variables
                    if(!priceList1.isEmpty()){
                        priceList1 = UtilitiesFactory.getSingleton().getNumbersUtility().fromMoneyFormat(priceList1);
                    }
                    else{
                        priceList1 = "0";
                    }
                    if(!priceList2.isEmpty()){
                        priceList2 = UtilitiesFactory.getSingleton().getNumbersUtility().fromMoneyFormat(priceList2);
                    }
                    else{
                        priceList2 = "0";
                    }
                    if(!priceList3.isEmpty()){
                        priceList3 = UtilitiesFactory.getSingleton().getNumbersUtility().fromMoneyFormat(priceList3);
                    }
                    else{
                        priceList3 = "0";
                    }
                    if(!priceList4.isEmpty()){
                        priceList4 = UtilitiesFactory.getSingleton().getNumbersUtility().fromMoneyFormat(priceList4);
                    }
                    else{
                        priceList4 = "0";
                    }
                    if(!priceList5.isEmpty()){
                        priceList5 = UtilitiesFactory.getSingleton().getNumbersUtility().fromMoneyFormat(priceList5);
                    }
                    else{
                        priceList5 = "0";
                    }
                    if(!priceList6.isEmpty()){
                        priceList6 = UtilitiesFactory.getSingleton().getNumbersUtility().fromMoneyFormat(priceList6);
                    }
                    else{
                        priceList6 = "0";
                    }
                    if(!priceList7.isEmpty()){
                        priceList7 = UtilitiesFactory.getSingleton().getNumbersUtility().fromMoneyFormat(priceList7);
                    }
                    else{
                        priceList7 = "0";
                    }
                    if(!priceList8.isEmpty()){
                        priceList8 = UtilitiesFactory.getSingleton().getNumbersUtility().fromMoneyFormat(priceList8);
                    }
                    else{
                        priceList8 = "0";
                    }
                    if(!priceList9.isEmpty()){
                        priceList9 = UtilitiesFactory.getSingleton().getNumbersUtility().fromMoneyFormat(priceList9);
                    }
                    else{
                        priceList9 = "0";
                    }
                    if(!priceList10.isEmpty()){
                        priceList10 = UtilitiesFactory.getSingleton().getNumbersUtility().fromMoneyFormat(priceList10);
                    }
                    else{
                        priceList10 = "0";
                    }
                    
                    //Save in the model
                    if(LPrecsDatamodel==null){
                        LPrecsDatamodel = new LPrecsDatamodel();
                    }
                    LPrecsDatamodel.setPriceList1(priceList1);
                    LPrecsDatamodel.setPriceList2(priceList2);
                    LPrecsDatamodel.setPriceList3(priceList3);
                    LPrecsDatamodel.setPriceList4(priceList4);
                    LPrecsDatamodel.setPriceList5(priceList5);
                    LPrecsDatamodel.setPriceList6(priceList6);
                    LPrecsDatamodel.setPriceList7(priceList7);
                    LPrecsDatamodel.setPriceList8(priceList8);
                    LPrecsDatamodel.setPriceList9(priceList9);
                    LPrecsDatamodel.setPriceList10(priceList10);
                    
                    LPrecsDatamodel.setUtility1(utility1);
                    LPrecsDatamodel.setUtility2(utility2);
                    LPrecsDatamodel.setUtility3(utility3);
                    LPrecsDatamodel.setUtility4(utility4);
                    LPrecsDatamodel.setUtility5(utility5);
                    LPrecsDatamodel.setUtility6(utility6);
                    LPrecsDatamodel.setUtility7(utility7);
                    LPrecsDatamodel.setUtility8(utility8);
                    LPrecsDatamodel.setUtility9(utility9);
                    LPrecsDatamodel.setUtility10(utility10);
                    
                    LPrecsDatamodel.setUtilSales1(utilSales1);
                    LPrecsDatamodel.setUtilSales2(utilSales2);
                    LPrecsDatamodel.setUtilSales3(utilSales3);
                    LPrecsDatamodel.setUtilSales4(utilSales4);
                    LPrecsDatamodel.setUtilSales5(utilSales5);
                    LPrecsDatamodel.setUtilSales6(utilSales6);
                    LPrecsDatamodel.setUtilSales7(utilSales7);
                    LPrecsDatamodel.setUtilSales8(utilSales8);
                    LPrecsDatamodel.setUtilSales9(utilSales9);
                    LPrecsDatamodel.setUtilSales10(utilSales10);
                                       
                    //Close
                    dispose();
                    
                    if(OnResult != null){
                        OnResult.onResult(LPrecsDatamodel);
                    }
                    
                }catch (Exception ex) {
                    LoggerUtility.getSingleton().logError(LPrecsViewController.class, ex);
                    try {
                        DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
                    } catch (Exception ex1) {
                        Logger.getLogger(LPrecsViewController.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                }
            });
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(LPrecsViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(LPrecsViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBSalActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
            //Question if exit
            DialogsFactory.getSingleton().showQuestionContinueDialog(baseJFrame, (JFrame jFrame) -> {
                dispose();
            });
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(LPrecsViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(LPrecsViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    @Override
    public List<?> getItemsToLoadInTable() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public interface OnResult{
        public void onResult(final LPrecsDatamodel LPrecsDatamodel);
    }

    public void setOnResult(OnResult OnResult) {
        this.OnResult = OnResult;
    }
}
