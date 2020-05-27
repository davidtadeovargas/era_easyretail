package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.ConcepssValidatorsExceptions;
import com.era.models.Conceps;
import com.era.repositories.RepositoryFactory;

public class ConcepssValidator extends IValidate{

   private String code;
   private String concep;
   private String descrip;

   @Override
   public void validateInsert() throws Exception {

       if(concep==null || concep.isEmpty()){
           throw new ConcepssValidatorsExceptions().getConcepException();
       }

       if(descrip==null || descrip.isEmpty()){
           throw new ConcepssValidatorsExceptions().getDescripException();
       }

       final Conceps Conceps = (Conceps) RepositoryFactory.getInstance().getConcepssRepository().getByCode(code);
       if(Conceps != null){            
           throw new ConcepssValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new ConcepssValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new ConcepssValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new ConcepssValidatorsExceptions().getCodeException();
       }

       final Conceps Conceps = (Conceps) RepositoryFactory.getInstance().getConcepssRepository().getByCode(code);
       if(Conceps == null){            
           throw new ConcepssValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new ConcepssValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}