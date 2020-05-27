package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.TipactfijsValidatorsExceptions;
import com.era.models.Tipactfij;
import com.era.repositories.RepositoryFactory;

public class TipactfijsValidator extends IValidate{

   private String code;
   private String descrip;
   private String tip;

   @Override
   public void validateInsert() throws Exception {

       if(descrip==null || descrip.isEmpty()){
           throw new TipactfijsValidatorsExceptions().getDescripException();
       }

       if(tip==null || tip.isEmpty()){
           throw new TipactfijsValidatorsExceptions().getTipException();
       }

       final Tipactfij Tipactfij = (Tipactfij) RepositoryFactory.getInstance().getTipactfijsRepository().getByCode(code);
       if(Tipactfij != null){            
           throw new TipactfijsValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new TipactfijsValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new TipactfijsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new TipactfijsValidatorsExceptions().getCodeException();
       }

       final Tipactfij Tipactfij = (Tipactfij) RepositoryFactory.getInstance().getTipactfijsRepository().getByCode(code);
       if(Tipactfij == null){            
           throw new TipactfijsValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new TipactfijsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}