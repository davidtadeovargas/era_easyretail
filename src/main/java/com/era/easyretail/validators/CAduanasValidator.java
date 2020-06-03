package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.CAduanasValidatorsExceptions;
import com.era.models.CAduana;
import com.era.repositories.RepositoryFactory;

public class CAduanasValidator extends IValidate{

   private String c_Aduana;
   public void setC_Aduana(String property){
       this.c_Aduana = property;
   }

   private String description;
   public void setDescription(String property){
       this.description = property;
   }


   @Override
   public void validateInsert() throws Exception {

       if(c_Aduana==null || c_Aduana.isEmpty()){
           throw new CAduanasValidatorsExceptions().getC_AduanaException();
       }

       if(description==null || description.isEmpty()){
           throw new CAduanasValidatorsExceptions().getDescriptionException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new CAduanasValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new CAduanasValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

}