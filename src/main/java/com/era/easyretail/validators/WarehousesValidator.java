package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.WarehousesValidatorsExceptions;
import com.era.models.Warehouse;
import com.era.repositories.RepositoryFactory;

public class WarehousesValidator extends IValidate{

   private String code;
   public void setCode(String property){
       this.code = property;
   }

   private String description;
   public void setDescription(String property){
       this.description = property;
   }

   private String responsable;
   public void setResponsable(String property){
       this.responsable = property;
   }


   @Override
   public void validateInsert() throws Exception {

       if(code==null || code.isEmpty()){
           throw new WarehousesValidatorsExceptions().getCodeException();
       }

       if(description==null || description.isEmpty()){
           throw new WarehousesValidatorsExceptions().getDescriptionException();
       }

       if(responsable==null || responsable.isEmpty()){
           throw new WarehousesValidatorsExceptions().getResponsableException();
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

}