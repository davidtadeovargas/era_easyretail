package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.CPaymentFormsValidatorsExceptions;
import com.era.models.CPaymentForm;
import com.era.repositories.RepositoryFactory;

public class CPaymentFormsValidator extends IValidate{

   private String description;
   public void setDescription(String property){
       this.description = property;
   }


   @Override
   public void validateInsert() throws Exception {

       if(description==null || description.isEmpty()){
           throw new CPaymentFormsValidatorsExceptions().getDescriptionException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new CPaymentFormsValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new CPaymentFormsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

}