package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.WarehousesValidatorsExceptions;
import com.era.models.Warehouse;
import com.era.repositories.RepositoryFactory;

public class WarehousesValidator extends IValidate{

   private String code;
   private String cashNumber;
   private String description;
   private String responsible;
   private String station;
   private String sucursal;

   @Override
   public void validateInsert() throws Exception {

       if(cashNumber==null || cashNumber.isEmpty()){
           throw new WarehousesValidatorsExceptions().getCashNumberException();
       }

       if(code==null || code.isEmpty()){
           throw new WarehousesValidatorsExceptions().getCodeException();
       }

       if(description==null || description.isEmpty()){
           throw new WarehousesValidatorsExceptions().getDescriptionException();
       }

       if(responsible==null || responsible.isEmpty()){
           throw new WarehousesValidatorsExceptions().getResponsibleException();
       }

       if(station==null || station.isEmpty()){
           throw new WarehousesValidatorsExceptions().getStationException();
       }

       if(sucursal==null || sucursal.isEmpty()){
           throw new WarehousesValidatorsExceptions().getSucursalException();
       }

       final Warehouse Warehouse = (Warehouse) RepositoryFactory.getInstance().getWarehousesRepository().getByCode(code);
       if(Warehouse != null){            
           throw new WarehousesValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new WarehousesValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new WarehousesValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new WarehousesValidatorsExceptions().getCodeException();
       }

       final Warehouse Warehouse = (Warehouse) RepositoryFactory.getInstance().getWarehousesRepository().getByCode(code);
       if(Warehouse == null){            
           throw new WarehousesValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new WarehousesValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}