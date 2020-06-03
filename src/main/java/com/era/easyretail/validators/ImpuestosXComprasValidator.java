package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.ImpuestosXComprasValidatorsExceptions;
import com.era.models.ImpuestosXCompra;
import com.era.repositories.RepositoryFactory;

public class ImpuestosXComprasValidator extends IValidate{

   private String fvenc;
   public void setFvenc(String property){
       this.fvenc = property;
   }

   private String total;
   public void setTotal(String property){
       this.total = property;
   }


   @Override
   public void validateInsert() throws Exception {

       if(fvenc==null || fvenc.isEmpty()){
           throw new ImpuestosXComprasValidatorsExceptions().getFvencException();
       }

       if(total==null || total.isEmpty()){
           throw new ImpuestosXComprasValidatorsExceptions().getTotalException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new ImpuestosXComprasValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new ImpuestosXComprasValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

}