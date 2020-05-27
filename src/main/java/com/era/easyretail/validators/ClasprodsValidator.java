package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.ClasprodsValidatorsExceptions;
import com.era.models.Clasprod;
import com.era.repositories.RepositoryFactory;

public class ClasprodsValidator extends IValidate{

   private String code;
   private String cod;
   private String descrip;

   @Override
   public void validateInsert() throws Exception {

       if(cod==null || cod.isEmpty()){
           throw new ClasprodsValidatorsExceptions().getCodException();
       }

       if(descrip==null || descrip.isEmpty()){
           throw new ClasprodsValidatorsExceptions().getDescripException();
       }

       final Clasprod Clasprod = (Clasprod) RepositoryFactory.getInstance().getClasprodsRepository().getByCode(code);
       if(Clasprod != null){            
           throw new ClasprodsValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new ClasprodsValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new ClasprodsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new ClasprodsValidatorsExceptions().getCodeException();
       }

       final Clasprod Clasprod = (Clasprod) RepositoryFactory.getInstance().getClasprodsRepository().getByCode(code);
       if(Clasprod == null){            
           throw new ClasprodsValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new ClasprodsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}