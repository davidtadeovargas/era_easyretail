package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.AuxiliarsValidatorsExceptions;
import com.era.models.Auxiliar;
import com.era.repositories.RepositoryFactory;

public class AuxiliarsValidator extends IValidate{

   private String code;

   @Override
   public void validateInsert() throws Exception {

       final Auxiliar Auxiliar = (Auxiliar) RepositoryFactory.getInstance().getAuxiliarsRepository().getByCode(code);
       if(Auxiliar != null){            
           throw new AuxiliarsValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new AuxiliarsValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new AuxiliarsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new AuxiliarsValidatorsExceptions().getCodeException();
       }

       final Auxiliar Auxiliar = (Auxiliar) RepositoryFactory.getInstance().getAuxiliarsRepository().getByCode(code);
       if(Auxiliar == null){            
           throw new AuxiliarsValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new AuxiliarsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}