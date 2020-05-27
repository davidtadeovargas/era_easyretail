package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.TaxsValidatorsExceptions;
import com.era.models.Tax;
import com.era.repositories.RepositoryFactory;

public class TaxsValidator extends IValidate{

   private String code;
   private String cashNumber;
   private String station;
   private String sucursal;
   private String value;

   @Override
   public void validateInsert() throws Exception {

       if(cashNumber==null || cashNumber.isEmpty()){
           throw new TaxsValidatorsExceptions().getCashNumberException();
       }

       if(code==null || code.isEmpty()){
           throw new TaxsValidatorsExceptions().getCodeException();
       }

       if(station==null || station.isEmpty()){
           throw new TaxsValidatorsExceptions().getStationException();
       }

       if(sucursal==null || sucursal.isEmpty()){
           throw new TaxsValidatorsExceptions().getSucursalException();
       }

       if(value==null || value.isEmpty()){
           throw new TaxsValidatorsExceptions().getValueException();
       }

       final Tax Tax = (Tax) RepositoryFactory.getInstance().getTaxsRepository().getByCode(code);
       if(Tax != null){            
           throw new TaxsValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new TaxsValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new TaxsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new TaxsValidatorsExceptions().getCodeException();
       }

       final Tax Tax = (Tax) RepositoryFactory.getInstance().getTaxsRepository().getByCode(code);
       if(Tax == null){            
           throw new TaxsValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new TaxsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}