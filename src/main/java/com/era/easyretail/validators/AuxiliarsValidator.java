package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.AuxiliarsValidatorsExceptions;
import com.era.models.Auxiliar;
import com.era.repositories.RepositoryFactory;

public class AuxiliarsValidator extends IValidate{


   @Override
   public void validateInsert() throws Exception {

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new AuxiliarsValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new AuxiliarsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

}