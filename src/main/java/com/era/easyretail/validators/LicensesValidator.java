package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.LicensesValidatorsExceptions;
import com.era.models.License;
import com.era.repositories.RepositoryFactory;

public class LicensesValidator extends IValidate{


   @Override
   public void validateInsert() throws Exception {

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new LicensesValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new LicensesValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

}