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
public class WebsitelValidator {

    private String webpage;    
    
    
    
    public WebsitelValidator(){        
    }
    
    public boolean isValid() throws Exception{
        
        if((!webpage.contains("www") || !webpage.contains(".")) && webpage.compareTo("")!=0){
            throw new Exception("errors_webpage_invalid_sintax");
        }
        
        //Al is fine with the moral
        return true;
    }

    public void setWebpage(String webpage) {
        this.webpage = webpage;
    }
}
