package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.ResponsablesValidatorsExceptions;
import com.era.models.Responsable;
import com.era.repositories.RepositoryFactory;

public class ResponsablesValidator extends IValidate{

   private String code;
   private String cod;
   private String descrip;

   @Override
   public void validateInsert() throws Exception {

       if(cod==null || cod.isEmpty()){
           throw new ResponsablesValidatorsExceptions().getCodException();
       }

       if(descrip==null || descrip.isEmpty()){
           throw new ResponsablesValidatorsExceptions().getDescripException();
       }

       final Responsable Responsable = (Responsable) RepositoryFactory.getInstance().getResponsablesRepository().getByCode(code);
       if(Responsable != null){            
           throw new ResponsablesValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new ResponsablesValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new ResponsablesValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new ResponsablesValidatorsExceptions().getCodeException();
       }

       final Responsable Responsable = (Responsable) RepositoryFactory.getInstance().getResponsablesRepository().getByCode(code);
       if(Responsable == null){            
           throw new ResponsablesValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new ResponsablesValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}