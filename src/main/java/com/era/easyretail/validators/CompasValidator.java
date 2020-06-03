package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.CompasValidatorsExceptions;
import com.era.models.Compa;
import com.era.repositories.RepositoryFactory;

public class CompasValidator extends IValidate{

   private String compa;
   public void setCompa(String property){
       this.compa = property;
   }

   private String prod;
   public void setProd(String property){
       this.prod = property;
   }


   @Override
   public void validateInsert() throws Exception {

       if(compa==null || compa.isEmpty()){
           throw new CompasValidatorsExceptions().getCompaException();
       }

       if(prod==null || prod.isEmpty()){
           throw new CompasValidatorsExceptions().getProdException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new CompasValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new CompasValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

}