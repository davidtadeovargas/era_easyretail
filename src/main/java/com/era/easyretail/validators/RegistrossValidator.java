package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.RegistrossValidatorsExceptions;
import com.era.models.Registros;
import com.era.repositories.RepositoryFactory;

public class RegistrossValidator extends IValidate{

   private String code;

   @Override
   public void validateInsert() throws Exception {

       final Registros Registros = (Registros) RepositoryFactory.getInstance().getRegistrossRepository().getByCode(code);
       if(Registros != null){            
           throw new RegistrossValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new RegistrossValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new RegistrossValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new RegistrossValidatorsExceptions().getCodeException();
       }

       final Registros Registros = (Registros) RepositoryFactory.getInstance().getRegistrossRepository().getByCode(code);
       if(Registros == null){            
           throw new RegistrossValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new RegistrossValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}