/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.easyretail.validators;

/**
 *
 * @author PC
 */
public class ValidatorManager {

    private static ValidatorManager ValidatorManager;
    private RFCValidator RFCValidator;
    
    
    
    private ValidatorManager(){        
    }

    public static ValidatorManager getSingleton(){
        if(ValidatorManager==null){
            ValidatorManager = new ValidatorManager();
        }
        return ValidatorManager;
    }
    
    public RFCValidator getRFCValidator(){
        if(RFCValidator==null){
            RFCValidator = new RFCValidator();
        }
        return RFCValidator;
    }
    
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
}
