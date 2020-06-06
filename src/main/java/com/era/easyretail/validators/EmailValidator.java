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
public class EmailValidator {

    private String email;    
    
    
    
    public EmailValidator(){        
    }
    
    public boolean isValid() throws Exception{
        
        if((!email.contains("@") || !email.contains(".")) && email.compareTo("")!=0){
            throw new Exception("errors_email_invalid_sintax");
        }
        
        //Al is fine with the moral
        return true;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
