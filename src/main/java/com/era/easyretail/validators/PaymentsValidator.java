package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.PaymentsValidatorsExceptions;
import com.era.models.Payment;
import com.era.repositories.RepositoryFactory;

public class PaymentsValidator extends IValidate{

   private String code;
   public void setCode(String property){
       this.code = property;
   }


   @Override
   public void validateInsert() throws Exception {

       if(code==null || code.isEmpty()){
           throw new PaymentsValidatorsExceptions().getCodeException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new PaymentsValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new PaymentsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

}