package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.CoinsValidatorsExceptions;
import com.era.models.Coin;
import com.era.repositories.RepositoryFactory;

public class CoinsValidator extends IValidate{

   private String c_moneda;
   public void setC_moneda(String property){
       this.c_moneda = property;
   }

   private String code;
   public void setCode(String property){
       this.code = property;
   }

   private String description;
   public void setDescription(String property){
       this.description = property;
   }

   private String simbol;
   public void setSimbol(String property){
       this.simbol = property;
   }


   @Override
   public void validateInsert() throws Exception {

       if(c_moneda==null || c_moneda.isEmpty()){
           throw new CoinsValidatorsExceptions().getC_monedaException();
       }

       if(code==null || code.isEmpty()){
           throw new CoinsValidatorsExceptions().getCodeException();
       }

       if(description==null || description.isEmpty()){
           throw new CoinsValidatorsExceptions().getDescriptionException();
       }

       if(simbol==null || simbol.isEmpty()){
           throw new CoinsValidatorsExceptions().getSimbolException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new CoinsValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new CoinsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

}