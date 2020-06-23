/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.easyretail.exceptions;

/**
 *
 * @author PC
 */
public class InternalUnexpectedErrorException extends Exception {
    
    public InternalUnexpectedErrorException(final String object){
        super("Error interno inesperado: " + object);
    }
}
