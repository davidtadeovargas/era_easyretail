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
public abstract class IValidate {
    
    protected IInsertValidation IInsertValidation;
    protected IUpdateValidation IUpdateValidation;
    protected IDeleteValidation IDeleteValidation;
    
    public abstract void validateInsert() throws Exception;
    public abstract void validateUpdate() throws Exception;
    public abstract void validateDelete() throws Exception;
    
    public interface IInsertValidation{
        public boolean validate();
    }
    public interface IUpdateValidation{
        public boolean validate();
    }
    public interface IDeleteValidation{
        public boolean validate();
    }
}
