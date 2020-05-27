package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.CPaymentFormsValidatorsExceptions;
import com.era.models.CPaymentForm;
import com.era.repositories.RepositoryFactory;

public class CPaymentFormsValidator extends IValidate{

   private String code;
   private String description;

   @Override
   public void validateInsert() throws Exception {

       if(description==null || description.isEmpty()){
           throw new CPaymentFormsValidatorsExceptions().getDescriptionException();
       }

       final CPaymentForm CPaymentForm = (CPaymentForm) RepositoryFactory.getInstance().getCPaymentFormsRepository().getByCode(code);
       if(CPaymentForm != null){            
           throw new CPaymentFormsValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new CPaymentFormsValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new CPaymentFormsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new CPaymentFormsValidatorsExceptions().getCodeException();
       }

       final CPaymentForm CPaymentForm = (CPaymentForm) RepositoryFactory.getInstance().getCPaymentFormsRepository().getByCode(code);
       if(CPaymentForm == null){            
           throw new CPaymentFormsValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new CPaymentFormsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}