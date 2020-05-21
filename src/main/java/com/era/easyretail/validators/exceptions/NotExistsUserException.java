/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.easyretail.validators.exceptions;

/**
 *
 * @author PC
 */
public class NotExistsUserException extends Exception {
    
    public NotExistsUserException(){
        super("errors_user_not_exists");
    }
}
