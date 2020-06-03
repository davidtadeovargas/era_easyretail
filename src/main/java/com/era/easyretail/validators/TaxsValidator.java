package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.TaxsValidatorsExceptions;
import com.era.models.Tax;
import com.era.repositories.RepositoryFactory;

public class TaxsValidator extends IValidate{

   private String code;
   public void setCode(String property){
       this.code = property;
   }

   private String value;
   public void setValue(String property){
       this.value = property;
   }


   @Override
   public void validateInsert() throws Exception {

       if(code==null || code.isEmpty()){
           throw new TaxsValidatorsExceptions().getCodeException();
       }

       if(value==null || value.isEmpty()){
           throw new TaxsValidatorsExceptions().getValueException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new TaxsValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new TaxsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

}