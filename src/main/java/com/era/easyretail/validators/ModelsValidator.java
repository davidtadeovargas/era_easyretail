package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.ModelsValidatorsExceptions;
import com.era.models.Model;
import com.era.repositories.RepositoryFactory;

public class ModelsValidator extends IValidate{

   private String code;
   private String cod;
   private String descrip;

   @Override
   public void validateInsert() throws Exception {

       if(cod==null || cod.isEmpty()){
           throw new ModelsValidatorsExceptions().getCodException();
       }

       if(descrip==null || descrip.isEmpty()){
           throw new ModelsValidatorsExceptions().getDescripException();
       }

       final Model Model = (Model) RepositoryFactory.getInstance().getModelsRepository().getByCode(code);
       if(Model != null){            
           throw new ModelsValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new ModelsValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new ModelsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new ModelsValidatorsExceptions().getCodeException();
       }

       final Model Model = (Model) RepositoryFactory.getInstance().getModelsRepository().getByCode(code);
       if(Model == null){            
           throw new ModelsValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new ModelsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}