package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.CUsoCFDIsValidatorsExceptions;
import com.era.models.CUsoCFDI;
import com.era.repositories.RepositoryFactory;

public class CUsoCFDIsValidator extends IValidate{

   private String code;

   @Override
   public void validateInsert() throws Exception {

       final CUsoCFDI CUsoCFDI = (CUsoCFDI) RepositoryFactory.getInstance().getCUsoCFDIsRepository().getByCode(code);
       if(CUsoCFDI != null){            
           throw new CUsoCFDIsValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new CUsoCFDIsValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new CUsoCFDIsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new CUsoCFDIsValidatorsExceptions().getCodeException();
       }

       final CUsoCFDI CUsoCFDI = (CUsoCFDI) RepositoryFactory.getInstance().getCUsoCFDIsRepository().getByCode(code);
       if(CUsoCFDI == null){            
           throw new CUsoCFDIsValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new CUsoCFDIsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}