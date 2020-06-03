package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.ExistalmasValidatorsExceptions;
import com.era.models.Existalma;
import com.era.repositories.RepositoryFactory;

public class ExistalmasValidator extends IValidate{

   private String alma;
   public void setAlma(String property){
       this.alma = property;
   }

   private String prod;
   public void setProd(String property){
       this.prod = property;
   }


   @Override
   public void validateInsert() throws Exception {

       if(alma==null || alma.isEmpty()){
           throw new ExistalmasValidatorsExceptions().getAlmaException();
       }

       if(prod==null || prod.isEmpty()){
           throw new ExistalmasValidatorsExceptions().getProdException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new ExistalmasValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new ExistalmasValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

}