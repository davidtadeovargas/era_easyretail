package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.ServerSessionsValidatorsExceptions;
import com.era.models.ServerSession;
import com.era.repositories.RepositoryFactory;

public class ServerSessionsValidator extends IValidate{

   private String code;
   private String genericSerial;

   @Override
   public void validateInsert() throws Exception {

       if(genericSerial==null || genericSerial.isEmpty()){
           throw new ServerSessionsValidatorsExceptions().getGenericSerialException();
       }

       final ServerSession ServerSession = (ServerSession) RepositoryFactory.getInstance().getServerSessionsRepository().getByCode(code);
       if(ServerSession != null){            
           throw new ServerSessionsValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new ServerSessionsValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new ServerSessionsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new ServerSessionsValidatorsExceptions().getCodeException();
       }

       final ServerSession ServerSession = (ServerSession) RepositoryFactory.getInstance().getServerSessionsRepository().getByCode(code);
       if(ServerSession == null){            
           throw new ServerSessionsValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new ServerSessionsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}