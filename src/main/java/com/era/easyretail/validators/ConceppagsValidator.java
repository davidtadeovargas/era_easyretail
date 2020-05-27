package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.ConceppagsValidatorsExceptions;
import com.era.models.Conceppag;
import com.era.repositories.RepositoryFactory;

public class ConceppagsValidator extends IValidate{

   private String code;
   private String concep;
   private String descrip;

   @Override
   public void validateInsert() throws Exception {

       if(concep==null || concep.isEmpty()){
           throw new ConceppagsValidatorsExceptions().getConcepException();
       }

       if(descrip==null || descrip.isEmpty()){
           throw new ConceppagsValidatorsExceptions().getDescripException();
       }

       final Conceppag Conceppag = (Conceppag) RepositoryFactory.getInstance().getConceppagsRepository().getByCode(code);
       if(Conceppag != null){            
           throw new ConceppagsValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new ConceppagsValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new ConceppagsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new ConceppagsValidatorsExceptions().getCodeException();
       }

       final Conceppag Conceppag = (Conceppag) RepositoryFactory.getInstance().getConceppagsRepository().getByCode(code);
       if(Conceppag == null){            
           throw new ConceppagsValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new ConceppagsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}