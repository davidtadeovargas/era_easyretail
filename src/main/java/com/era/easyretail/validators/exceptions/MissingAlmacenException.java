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
public class MissingAlmacenException extends Exception {
    
    public MissingAlmacenException(){
        super("still_missing_fields_to_fill");
    }
}
