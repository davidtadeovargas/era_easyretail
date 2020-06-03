package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.CuentasContablessValidatorsExceptions;
import com.era.models.CuentasContables;
import com.era.repositories.RepositoryFactory;

public class CuentasContablessValidator extends IValidate{

   private String cuenta;
   public void setCuenta(String property){
       this.cuenta = property;
   }

   private String descrip;
   public void setDescrip(String property){
       this.descrip = property;
   }


   @Override
   public void validateInsert() throws Exception {

       if(cuenta==null || cuenta.isEmpty()){
           throw new CuentasContablessValidatorsExceptions().getCuentaException();
       }

       if(descrip==null || descrip.isEmpty()){
           throw new CuentasContablessValidatorsExceptions().getDescripException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new CuentasContablessValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new CuentasContablessValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

}