package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.MovimientosPagossValidatorsExceptions;
import com.era.models.MovimientosPagos;
import com.era.repositories.RepositoryFactory;

public class MovimientosPagossValidator extends IValidate{

   private String code;

   @Override
   public void validateInsert() throws Exception {

       final MovimientosPagos MovimientosPagos = (MovimientosPagos) RepositoryFactory.getInstance().getMovimientosPagossRepository().getByCode(code);
       if(MovimientosPagos != null){            
           throw new MovimientosPagossValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new MovimientosPagossValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new MovimientosPagossValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new MovimientosPagossValidatorsExceptions().getCodeException();
       }

       final MovimientosPagos MovimientosPagos = (MovimientosPagos) RepositoryFactory.getInstance().getMovimientosPagossRepository().getByCode(code);
       if(MovimientosPagos == null){            
           throw new MovimientosPagossValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new MovimientosPagossValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}