/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.easyretail.premium;

import com.era.datamodels.PremiumFuntionsDataModel;

/**
 *
 * @author PC
 */
public class PremiumFunctionsManager {
    
    private static PremiumFunctionsManager PremiumFunctionsManager;
    
    private PremiumFuntionsDataModel PremiumFuntionsDataModel;
    
    
    
    private PremiumFunctionsManager(){
        
        //Initially there is not premium funtions
        PremiumFuntionsDataModel = new PremiumFuntionsDataModel();
        PremiumFuntionsDataModel.setPremium(false);
        PremiumFuntionsDataModel.setSendToOnlyOneDestinataryInFact(true);
        PremiumFuntionsDataModel.setOnlyUseIVATax(true);
        PremiumFuntionsDataModel.setOnlyOneSerieForDocument(true);
        PremiumFuntionsDataModel.setDisableInvoiceTicketsWindow(true);
    }
    
    final public static PremiumFunctionsManager getSingleton(){
        if(PremiumFunctionsManager==null){
            PremiumFunctionsManager = new PremiumFunctionsManager();
        }
        return PremiumFunctionsManager;
    }

    public PremiumFuntionsDataModel getPremiumFuntionsDataModel() {
        return PremiumFuntionsDataModel;
    }

    public void setPremiumFuntionsDataModel(PremiumFuntionsDataModel PremiumFuntionsDataModel) {
        this.PremiumFuntionsDataModel = PremiumFuntionsDataModel;
    }   

    public boolean isPremium(){
        return PremiumFuntionsDataModel.isPremium();
    }
    
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }
}
