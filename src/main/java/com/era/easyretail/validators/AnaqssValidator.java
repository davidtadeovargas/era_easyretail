package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.AnaqssValidatorsExceptions;
import com.era.models.Anaqs;
import com.era.repositories.RepositoryFactory;

public class AnaqssValidator extends IValidate{

   private String code;
   private String cod;
   private String descrip;

   @Override
   public void validateInsert() throws Exception {

       if(cod==null || cod.isEmpty()){
           throw new AnaqssValidatorsExceptions().getCodException();
       }

       if(descrip==null || descrip.isEmpty()){
           throw new AnaqssValidatorsExceptions().getDescripException();
       }

       final Anaqs Anaqs = (Anaqs) RepositoryFactory.getInstance().getAnaqssRepository().getByCode(code);
       if(Anaqs != null){            
           throw new AnaqssValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new AnaqssValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new AnaqssValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new AnaqssValidatorsExceptions().getCodeException();
       }

       final Anaqs Anaqs = (Anaqs) RepositoryFactory.getInstance().getAnaqssRepository().getByCode(code);
       if(Anaqs == null){            
           throw new AnaqssValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new AnaqssValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}