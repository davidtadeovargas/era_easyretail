package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.CClaveUnidadsValidatorsExceptions;
import com.era.models.CClaveUnidad;
import com.era.repositories.RepositoryFactory;

public class CClaveUnidadsValidator extends IValidate{


   @Override
   public void validateInsert() throws Exception {

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new CClaveUnidadsValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new CClaveUnidadsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

}