package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.PaymentsValidatorsExceptions;
import com.era.models.Payment;
import com.era.repositories.RepositoryFactory;

public class PaymentsValidator extends IValidate{

   private String code;
   private String cashNumber;
   private String station;
   private String sucursal;

   @Override
   public void validateInsert() throws Exception {

       if(cashNumber==null || cashNumber.isEmpty()){
           throw new PaymentsValidatorsExceptions().getCashNumberException();
       }

       if(code==null || code.isEmpty()){
           throw new PaymentsValidatorsExceptions().getCodeException();
       }

       if(station==null || station.isEmpty()){
           throw new PaymentsValidatorsExceptions().getStationException();
       }

       if(sucursal==null || sucursal.isEmpty()){
           throw new PaymentsValidatorsExceptions().getSucursalException();
       }

       final Payment Payment = (Payment) RepositoryFactory.getInstance().getPaymentsRepository().getByCode(code);
       if(Payment != null){            
           throw new PaymentsValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new PaymentsValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new PaymentsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new PaymentsValidatorsExceptions().getCodeException();
       }

       final Payment Payment = (Payment) RepositoryFactory.getInstance().getPaymentsRepository().getByCode(code);
       if(Payment == null){            
           throw new PaymentsValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new PaymentsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}