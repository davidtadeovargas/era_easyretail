package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.MetogoPagosValidatorsExceptions;
import com.era.models.MetogoPago;
import com.era.repositories.RepositoryFactory;

public class MetogoPagosValidator extends IValidate{

   private String code;
   public void setCode(String property){
       this.code = property;
   }

   private String description;
   public void setDescription(String property){
       this.description = property;
   }


   @Override
   public void validateInsert() throws Exception {

       if(code==null || code.isEmpty()){
           throw new MetogoPagosValidatorsExceptions().getCodeException();
       }

       if(description==null || description.isEmpty()){
           throw new MetogoPagosValidatorsExceptions().getDescriptionException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new MetogoPagosValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new MetogoPagosValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

}