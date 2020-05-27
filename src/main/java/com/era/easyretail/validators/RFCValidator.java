/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.easyretail.validators;

import org.apache.commons.lang3.math.NumberUtils;

/**
 *
 * @author PC
 */
public class RFCValidator {

    private String RFC;
    private boolean moral;    
    private final String genericRFC = "XAXX010101000";
    
    
    
    public RFCValidator(){        
    }
    
    public boolean isRFCGeneric(){
        
        //Convert to mayus
        RFC = RFC.toUpperCase().trim();
        
        //Validate that the RFC be a generic one
        return RFC.compareTo(genericRFC)==0;
    }
    
    public boolean isRFCMoralValid() throws Exception{
        
        //Convert to mayus
        RFC = RFC.toUpperCase().trim();
        
        if(isRFCGeneric()){
            throw new Exception("El RFC es genérico");
        }
        
        //If length is valid continue
        if(RFC.length()==12) {

            //Validation
            if(NumberUtils.isDigits(RFC.substring(0, 1)) || NumberUtils.isDigits(RFC.substring(1, 2)) || NumberUtils.isDigits(RFC.substring(2, 3))){                
                throw new Exception("Los primeros 3 caracteres del RFC deben ser letras.");
            }

            //Validation
            if(Integer.parseInt(RFC.substring(5, 7)) > 12){
                throw new Exception("Los dígitos 6 y 7 del mes del RFC no deben ser mayor a 12");
            }

            //Validate
            if(Integer.parseInt(RFC.substring(7, 9)) > 31){
                throw new Exception("Los dígitos 8 y 9 del día no deben ser mayores a 31");
            }
        }
        //Else invalid inital length
        else{
            throw new Exception("La longitud debe ser de 12 dítigos para persona moral");
        }
        
        //Al is fine with the moral
        return true;
    }
    
    public boolean isRFCFisicValid() throws Exception {
              
        //Convert to mayus
        RFC = RFC.toUpperCase().trim();
        
        if(isRFCGeneric()){
            throw new Exception("El RFC es genérico");
        }
        
        if(RFC.length()==13) {
            
            if(NumberUtils.isDigits(RFC.substring(0, 1)) || NumberUtils.isDigits(RFC.substring(1, 2)) || NumberUtils.isDigits(RFC.substring(2, 3)) || NumberUtils.isDigits(RFC.substring(3, 4))){
                throw new Exception("Los primeros 4 caracteres del RFC deben ser letras");
            }

            if(!NumberUtils.isDigits(RFC.substring(5, 6)) || !NumberUtils.isDigits(RFC.substring(6, 7)) || !NumberUtils.isDigits(RFC.substring(7, 8)) || !NumberUtils.isDigits(RFC.substring(8, 9)) || !NumberUtils.isDigits(RFC.substring(9, 10))){                
                throw new Exception("Los dígitos del 5 al 10 deben ser numéricos");
            }                                    

            if(Integer.parseInt(RFC.substring(6, 8)) > 12){
                throw new Exception("Los dígitos 7 y 8 del mes del RFC no deben ser mayor a 12");
            }

            if(Integer.parseInt(RFC.substring(8, 10)) > 31){
                throw new Exception("Los dígitos 9 y 10 del día no deben ser mayores a 31");
            }
        }
        else{
            throw new Exception("La longitud debe ser de 13 dítigos para persona física");
        }
        
        //All was good
        return true;
    }

    public RFCValidator setRFC(String RFC) {
        this.RFC = RFC;
        return this;
    }

    public void setMoral(boolean moral) {
        this.moral = moral;
    }
}
