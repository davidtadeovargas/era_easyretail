package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.LogsValidatorsExceptions;
import com.era.models.Log;
import com.era.repositories.RepositoryFactory;

public class LogsValidator extends IValidate{

   private String code;
   private String accio;
   private String cod;
   private String descrip;
   private String type;

   @Override
   public void validateInsert() throws Exception {

       if(accio==null || accio.isEmpty()){
           throw new LogsValidatorsExceptions().getAccioException();
       }

       if(cod==null || cod.isEmpty()){
           throw new LogsValidatorsExceptions().getCodException();
       }

       if(descrip==null || descrip.isEmpty()){
           throw new LogsValidatorsExceptions().getDescripException();
       }

       if(type==null || type.isEmpty()){
           throw new LogsValidatorsExceptions().getTypeException();
       }

       final Log Log = (Log) RepositoryFactory.getInstance().getLogsRepository().getByCode(code);
       if(Log != null){            
           throw new LogsValidatorsExceptions().getModelExistsException();
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

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new LogsValidatorsExceptions().getCodeException();
       }

       final Log Log = (Log) RepositoryFactory.getInstance().getLogsRepository().getByCode(code);
       if(Log == null){            
           throw new LogsValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new LogsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}