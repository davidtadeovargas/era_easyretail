package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.ResplogsValidatorsExceptions;
import com.era.models.Resplog;
import com.era.repositories.RepositoryFactory;

public class ResplogsValidator extends IValidate{

   private String tip;
   public void setTip(String property){
       this.tip = property;
   }


   @Override
   public void validateInsert() throws Exception {

       if(tip==null || tip.isEmpty()){
           throw new ResplogsValidatorsExceptions().getTipException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new ResplogsValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new ResplogsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

}