package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.UsoCFDIsValidatorsExceptions;
import com.era.models.UsoCFDI;
import com.era.repositories.RepositoryFactory;

public class UsoCFDIsValidator extends IValidate{

   private String code;

   @Override
   public void validateInsert() throws Exception {

       final UsoCFDI UsoCFDI = (UsoCFDI) RepositoryFactory.getInstance().getUsoCFDIsRepository().getByCode(code);
       if(UsoCFDI != null){            
           throw new UsoCFDIsValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new UsoCFDIsValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new UsoCFDIsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new UsoCFDIsValidatorsExceptions().getCodeException();
       }

       final UsoCFDI UsoCFDI = (UsoCFDI) RepositoryFactory.getInstance().getUsoCFDIsRepository().getByCode(code);
       if(UsoCFDI == null){            
           throw new UsoCFDIsValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new UsoCFDIsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}