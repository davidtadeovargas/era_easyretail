package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.GralssValidatorsExceptions;
import com.era.models.Grals;
import com.era.repositories.RepositoryFactory;

public class GralssValidator extends IValidate{

   private String code;
   private String cod;
   private String descrip;

   @Override
   public void validateInsert() throws Exception {

       if(cod==null || cod.isEmpty()){
           throw new GralssValidatorsExceptions().getCodException();
       }

       if(descrip==null || descrip.isEmpty()){
           throw new GralssValidatorsExceptions().getDescripException();
       }

       final Grals Grals = (Grals) RepositoryFactory.getInstance().getGralssRepository().getByCode(code);
       if(Grals != null){            
           throw new GralssValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new GralssValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new GralssValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new GralssValidatorsExceptions().getCodeException();
       }

       final Grals Grals = (Grals) RepositoryFactory.getInstance().getGralssRepository().getByCode(code);
       if(Grals == null){            
           throw new GralssValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new GralssValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}