package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.TipscambsValidatorsExceptions;
import com.era.models.Tipscamb;
import com.era.repositories.RepositoryFactory;

public class TipscambsValidator extends IValidate{

   private String code;
   public void setCode(String property){
       this.code = property;
   }


   @Override
   public void validateInsert() throws Exception {

       if(code==null || code.isEmpty()){
           throw new TipscambsValidatorsExceptions().getCodeException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new TipscambsValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new TipscambsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

}