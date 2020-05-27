package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.CPaymentMethodsValidatorsExceptions;
import com.era.models.CPaymentMethod;
import com.era.repositories.RepositoryFactory;

public class CPaymentMethodsValidator extends IValidate{

   private String code;

   @Override
   public void validateInsert() throws Exception {

       final CPaymentMethod CPaymentMethod = (CPaymentMethod) RepositoryFactory.getInstance().getCPaymentMethodsRepository().getByCode(code);
       if(CPaymentMethod != null){            
           throw new CPaymentMethodsValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new CPaymentMethodsValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new CPaymentMethodsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new CPaymentMethodsValidatorsExceptions().getCodeException();
       }

       final CPaymentMethod CPaymentMethod = (CPaymentMethod) RepositoryFactory.getInstance().getCPaymentMethodsRepository().getByCode(code);
       if(CPaymentMethod == null){            
           throw new CPaymentMethodsValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new CPaymentMethodsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}