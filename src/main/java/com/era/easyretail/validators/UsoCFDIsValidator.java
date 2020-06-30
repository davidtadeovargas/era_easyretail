package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.UsoCFDIsValidatorsExceptions;

public class UsoCFDIsValidator extends IValidate{


   @Override
   public void validateInsert() throws Exception {

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new UsoCFDIsValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new UsoCFDIsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

}