package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.ActivossValidatorsExceptions;
import com.era.models.Activos;
import com.era.repositories.RepositoryFactory;

public class ActivossValidator extends IValidate{

   private String code;

   @Override
   public void validateInsert() throws Exception {

       final Activos Activos = (Activos) RepositoryFactory.getInstance().getActivossRepository().getByCode(code);
       if(Activos != null){            
           throw new ActivossValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new ActivossValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new ActivossValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new ActivossValidatorsExceptions().getCodeException();
       }

       final Activos Activos = (Activos) RepositoryFactory.getInstance().getActivossRepository().getByCode(code);
       if(Activos == null){            
           throw new ActivossValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new ActivossValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}