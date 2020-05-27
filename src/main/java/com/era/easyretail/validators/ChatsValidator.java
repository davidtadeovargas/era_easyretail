package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.ChatsValidatorsExceptions;
import com.era.models.Chat;
import com.era.repositories.RepositoryFactory;

public class ChatsValidator extends IValidate{

   private String code;
   private String msj;

   @Override
   public void validateInsert() throws Exception {

       if(msj==null || msj.isEmpty()){
           throw new ChatsValidatorsExceptions().getMsjException();
       }

       final Chat Chat = (Chat) RepositoryFactory.getInstance().getChatsRepository().getByCode(code);
       if(Chat != null){            
           throw new ChatsValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new ChatsValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new ChatsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new ChatsValidatorsExceptions().getCodeException();
       }

       final Chat Chat = (Chat) RepositoryFactory.getInstance().getChatsRepository().getByCode(code);
       if(Chat == null){            
           throw new ChatsValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new ChatsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}