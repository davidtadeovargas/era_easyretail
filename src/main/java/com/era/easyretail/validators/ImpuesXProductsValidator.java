package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.ImpuesXProductsValidatorsExceptions;
import com.era.models.ImpuesXProduct;
import com.era.repositories.RepositoryFactory;

public class ImpuesXProductsValidator extends IValidate{

   private String impue;
   public void setImpue(String property){
       this.impue = property;
   }

   private String produ;
   public void setProdu(String property){
       this.produ = property;
   }


   @Override
   public void validateInsert() throws Exception {

       if(impue==null || impue.isEmpty()){
           throw new ImpuesXProductsValidatorsExceptions().getImpueException();
       }

       if(produ==null || produ.isEmpty()){
           throw new ImpuesXProductsValidatorsExceptions().getProduException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new ImpuesXProductsValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new ImpuesXProductsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

}