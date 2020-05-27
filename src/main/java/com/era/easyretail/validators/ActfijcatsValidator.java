package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.ActfijcatsValidatorsExceptions;
import com.era.models.Actfijcat;
import com.era.repositories.RepositoryFactory;

public class ActfijcatsValidator extends IValidate{

   private String code;
   private String concep;
   private String descrip;

   @Override
   public void validateInsert() throws Exception {

       if(concep==null || concep.isEmpty()){
           throw new ActfijcatsValidatorsExceptions().getConcepException();
       }

       if(descrip==null || descrip.isEmpty()){
           throw new ActfijcatsValidatorsExceptions().getDescripException();
       }

       final Actfijcat Actfijcat = (Actfijcat) RepositoryFactory.getInstance().getActfijcatsRepository().getByCode(code);
       if(Actfijcat != null){            
           throw new ActfijcatsValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new ActfijcatsValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new ActfijcatsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new ActfijcatsValidatorsExceptions().getCodeException();
       }

       final Actfijcat Actfijcat = (Actfijcat) RepositoryFactory.getInstance().getActfijcatsRepository().getByCode(code);
       if(Actfijcat == null){            
           throw new ActfijcatsValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new ActfijcatsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}