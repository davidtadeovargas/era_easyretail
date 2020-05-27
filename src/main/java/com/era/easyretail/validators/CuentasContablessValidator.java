package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.CuentasContablessValidatorsExceptions;
import com.era.models.CuentasContables;
import com.era.repositories.RepositoryFactory;

public class CuentasContablessValidator extends IValidate{

   private String code;
   private String cuenta;
   private String descrip;

   @Override
   public void validateInsert() throws Exception {

       if(cuenta==null || cuenta.isEmpty()){
           throw new CuentasContablessValidatorsExceptions().getCuentaException();
       }

       if(descrip==null || descrip.isEmpty()){
           throw new CuentasContablessValidatorsExceptions().getDescripException();
       }

       final CuentasContables CuentasContables = (CuentasContables) RepositoryFactory.getInstance().getCuentasContablessRepository().getByCode(code);
       if(CuentasContables != null){            
           throw new CuentasContablessValidatorsExceptions().getModelExistsException();
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

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new CuentasContablessValidatorsExceptions().getCodeException();
       }

       final CuentasContables CuentasContables = (CuentasContables) RepositoryFactory.getInstance().getCuentasContablessRepository().getByCode(code);
       if(CuentasContables == null){            
           throw new CuentasContablessValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new CuentasContablessValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}