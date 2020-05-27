package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.RubrsValidatorsExceptions;
import com.era.models.Rubr;
import com.era.repositories.RepositoryFactory;

public class RubrsValidator extends IValidate{

   private String code;
   private String cod;
   private String descrip;

   @Override
   public void validateInsert() throws Exception {

       if(cod==null || cod.isEmpty()){
           throw new RubrsValidatorsExceptions().getCodException();
       }

       if(descrip==null || descrip.isEmpty()){
           throw new RubrsValidatorsExceptions().getDescripException();
       }

       final Rubr Rubr = (Rubr) RepositoryFactory.getInstance().getRubrsRepository().getByCode(code);
       if(Rubr != null){            
           throw new RubrsValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new RubrsValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new RubrsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new RubrsValidatorsExceptions().getCodeException();
       }

       final Rubr Rubr = (Rubr) RepositoryFactory.getInstance().getRubrsRepository().getByCode(code);
       if(Rubr == null){            
           throw new RubrsValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new RubrsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}