package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.LogsValidatorsExceptions;
import com.era.models.Log;
import com.era.repositories.RepositoryFactory;

public class LogsValidator extends IValidate{

   private String accio;
   public void setAccio(String property){
       this.accio = property;
   }

   private String code;
   public void setCode(String property){
       this.code = property;
   }

   private String descrip;
   public void setDescrip(String property){
       this.descrip = property;
   }

   private String type;
   public void setType(String property){
       this.type = property;
   }


   @Override
   public void validateInsert() throws Exception {

       if(accio==null || accio.isEmpty()){
           throw new LogsValidatorsExceptions().getAccioException();
       }

       if(code==null || code.isEmpty()){
           throw new LogsValidatorsExceptions().getCodeException();
       }

       if(descrip==null || descrip.isEmpty()){
           throw new LogsValidatorsExceptions().getDescripException();
       }

       if(type==null || type.isEmpty()){
           throw new LogsValidatorsExceptions().getTypeException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new LogsValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new LogsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

}