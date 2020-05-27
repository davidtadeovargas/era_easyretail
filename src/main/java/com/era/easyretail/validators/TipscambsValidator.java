package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.TipscambsValidatorsExceptions;
import com.era.models.Tipscamb;
import com.era.repositories.RepositoryFactory;

public class TipscambsValidator extends IValidate{

   private String code;
   private String mon;

   @Override
   public void validateInsert() throws Exception {

       if(mon==null || mon.isEmpty()){
           throw new TipscambsValidatorsExceptions().getMonException();
       }

       final Tipscamb Tipscamb = (Tipscamb) RepositoryFactory.getInstance().getTipscambsRepository().getByCode(code);
       if(Tipscamb != null){            
           throw new TipscambsValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new TipscambsValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new TipscambsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new TipscambsValidatorsExceptions().getCodeException();
       }

       final Tipscamb Tipscamb = (Tipscamb) RepositoryFactory.getInstance().getTipscambsRepository().getByCode(code);
       if(Tipscamb == null){            
           throw new TipscambsValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new TipscambsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}