package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.ConcepnotsValidatorsExceptions;
import com.era.models.Concepnot;
import com.era.repositories.RepositoryFactory;

public class ConcepnotsValidator extends IValidate{

   private String code;
   private String concep;
   private String descrip;

   @Override
   public void validateInsert() throws Exception {

       if(concep==null || concep.isEmpty()){
           throw new ConcepnotsValidatorsExceptions().getConcepException();
       }

       if(descrip==null || descrip.isEmpty()){
           throw new ConcepnotsValidatorsExceptions().getDescripException();
       }

       final Concepnot Concepnot = (Concepnot) RepositoryFactory.getInstance().getConcepnotsRepository().getByCode(code);
       if(Concepnot != null){            
           throw new ConcepnotsValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new ConcepnotsValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new ConcepnotsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new ConcepnotsValidatorsExceptions().getCodeException();
       }

       final Concepnot Concepnot = (Concepnot) RepositoryFactory.getInstance().getConcepnotsRepository().getByCode(code);
       if(Concepnot == null){            
           throw new ConcepnotsValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new ConcepnotsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}