package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.ResplogsValidatorsExceptions;
import com.era.models.Resplog;
import com.era.repositories.RepositoryFactory;

public class ResplogsValidator extends IValidate{

   private String code;
   private String tip;

   @Override
   public void validateInsert() throws Exception {

       if(tip==null || tip.isEmpty()){
           throw new ResplogsValidatorsExceptions().getTipException();
       }

       final Resplog Resplog = (Resplog) RepositoryFactory.getInstance().getResplogsRepository().getByCode(code);
       if(Resplog != null){            
           throw new ResplogsValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new ResplogsValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new ResplogsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new ResplogsValidatorsExceptions().getCodeException();
       }

       final Resplog Resplog = (Resplog) RepositoryFactory.getInstance().getResplogsRepository().getByCode(code);
       if(Resplog == null){            
           throw new ResplogsValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new ResplogsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}