package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.DeliverAddressCustomersValidatorsExceptions;
import com.era.models.DeliverAddressCustomer;
import com.era.repositories.RepositoryFactory;

public class DeliverAddressCustomersValidator extends IValidate{

   private String code;
   private String cashNumber;
   private String customerCode;
   private String station;
   private String sucursal;

   @Override
   public void validateInsert() throws Exception {

       if(cashNumber==null || cashNumber.isEmpty()){
           throw new DeliverAddressCustomersValidatorsExceptions().getCashNumberException();
       }

       if(customerCode==null || customerCode.isEmpty()){
           throw new DeliverAddressCustomersValidatorsExceptions().getCustomerCodeException();
       }

       if(station==null || station.isEmpty()){
           throw new DeliverAddressCustomersValidatorsExceptions().getStationException();
       }

       if(sucursal==null || sucursal.isEmpty()){
           throw new DeliverAddressCustomersValidatorsExceptions().getSucursalException();
       }

       final DeliverAddressCustomer DeliverAddressCustomer = (DeliverAddressCustomer) RepositoryFactory.getInstance().getDeliverAddressCustomersRepository().getByCode(code);
       if(DeliverAddressCustomer != null){            
           throw new DeliverAddressCustomersValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new DeliverAddressCustomersValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new DeliverAddressCustomersValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new DeliverAddressCustomersValidatorsExceptions().getCodeException();
       }

       final DeliverAddressCustomer DeliverAddressCustomer = (DeliverAddressCustomer) RepositoryFactory.getInstance().getDeliverAddressCustomersRepository().getByCode(code);
       if(DeliverAddressCustomer == null){            
           throw new DeliverAddressCustomersValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new DeliverAddressCustomersValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}