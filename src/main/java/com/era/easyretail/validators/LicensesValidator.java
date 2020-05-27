package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.LicensesValidatorsExceptions;
import com.era.models.License;
import com.era.repositories.RepositoryFactory;

public class LicensesValidator extends IValidate{

   private String code;

   @Override
   public void validateInsert() throws Exception {

       final License License = (License) RepositoryFactory.getInstance().getLicensesRepository().getByCode(code);
       if(License != null){            
           throw new LicensesValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new LicensesValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new LicensesValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new LicensesValidatorsExceptions().getCodeException();
       }

       final License License = (License) RepositoryFactory.getInstance().getLicensesRepository().getByCode(code);
       if(License == null){            
           throw new LicensesValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new LicensesValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}