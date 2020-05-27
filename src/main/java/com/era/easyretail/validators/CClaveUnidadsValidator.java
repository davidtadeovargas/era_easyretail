package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.CClaveUnidadsValidatorsExceptions;
import com.era.models.CClaveUnidad;
import com.era.repositories.RepositoryFactory;

public class CClaveUnidadsValidator extends IValidate{

   private String code;

   @Override
   public void validateInsert() throws Exception {

       final CClaveUnidad CClaveUnidad = (CClaveUnidad) RepositoryFactory.getInstance().getCClaveUnidadsRepository().getByCode(code);
       if(CClaveUnidad != null){            
           throw new CClaveUnidadsValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new CClaveUnidadsValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new CClaveUnidadsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new CClaveUnidadsValidatorsExceptions().getCodeException();
       }

       final CClaveUnidad CClaveUnidad = (CClaveUnidad) RepositoryFactory.getInstance().getCClaveUnidadsRepository().getByCode(code);
       if(CClaveUnidad == null){            
           throw new CClaveUnidadsValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new CClaveUnidadsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}