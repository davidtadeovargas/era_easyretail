package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.PaymentFormsValidatorsExceptions;
import com.era.models.PaymentForm;
import com.era.repositories.RepositoryFactory;

public class PaymentFormsValidator extends IValidate{

   private String code;
   private String description;
   private String paymentForm;

   @Override
   public void validateInsert() throws Exception {

       if(description==null || description.isEmpty()){
           throw new PaymentFormsValidatorsExceptions().getDescriptionException();
       }

       if(paymentForm==null || paymentForm.isEmpty()){
           throw new PaymentFormsValidatorsExceptions().getPaymentFormException();
       }

       final PaymentForm PaymentForm = (PaymentForm) RepositoryFactory.getInstance().getPaymentFormsRepository().getByCode(code);
       if(PaymentForm != null){            
           throw new PaymentFormsValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new PaymentFormsValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new PaymentFormsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new PaymentFormsValidatorsExceptions().getCodeException();
       }

       final PaymentForm PaymentForm = (PaymentForm) RepositoryFactory.getInstance().getPaymentFormsRepository().getByCode(code);
       if(PaymentForm == null){            
           throw new PaymentFormsValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new PaymentFormsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}