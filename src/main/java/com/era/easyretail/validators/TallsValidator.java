package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.TallsValidatorsExceptions;
import com.era.models.Tall;
import com.era.repositories.RepositoryFactory;

public class TallsValidator extends IValidate{

   private String code;
   private String cod;
   private String descrip;

   @Override
   public void validateInsert() throws Exception {

       if(cod==null || cod.isEmpty()){
           throw new TallsValidatorsExceptions().getCodException();
       }

       if(descrip==null || descrip.isEmpty()){
           throw new TallsValidatorsExceptions().getDescripException();
       }

       final Tall Tall = (Tall) RepositoryFactory.getInstance().getTallsRepository().getByCode(code);
       if(Tall != null){            
           throw new TallsValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new TallsValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new TallsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new TallsValidatorsExceptions().getCodeException();
       }

       final Tall Tall = (Tall) RepositoryFactory.getInstance().getTallsRepository().getByCode(code);
       if(Tall == null){            
           throw new TallsValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new TallsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}