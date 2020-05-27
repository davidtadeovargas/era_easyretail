package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.ClasprovsValidatorsExceptions;
import com.era.models.Clasprov;
import com.era.repositories.RepositoryFactory;

public class ClasprovsValidator extends IValidate{

   private String code;
   private String cod;
   private String descrip;

   @Override
   public void validateInsert() throws Exception {

       if(cod==null || cod.isEmpty()){
           throw new ClasprovsValidatorsExceptions().getCodException();
       }

       if(descrip==null || descrip.isEmpty()){
           throw new ClasprovsValidatorsExceptions().getDescripException();
       }

       final Clasprov Clasprov = (Clasprov) RepositoryFactory.getInstance().getClasprovsRepository().getByCode(code);
       if(Clasprov != null){            
           throw new ClasprovsValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new ClasprovsValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new ClasprovsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new ClasprovsValidatorsExceptions().getCodeException();
       }

       final Clasprov Clasprov = (Clasprov) RepositoryFactory.getInstance().getClasprovsRepository().getByCode(code);
       if(Clasprov == null){            
           throw new ClasprovsValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new ClasprovsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}