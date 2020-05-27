package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.CortessValidatorsExceptions;
import com.era.models.Cortes;
import com.era.repositories.RepositoryFactory;

public class CortessValidator extends IValidate{

   private String code;

   @Override
   public void validateInsert() throws Exception {

       final Cortes Cortes = (Cortes) RepositoryFactory.getInstance().getCortessRepository().getByCode(code);
       if(Cortes != null){            
           throw new CortessValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new CortessValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new CortessValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new CortessValidatorsExceptions().getCodeException();
       }

       final Cortes Cortes = (Cortes) RepositoryFactory.getInstance().getCortessRepository().getByCode(code);
       if(Cortes == null){            
           throw new CortessValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new CortessValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}