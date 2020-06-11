package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.ProductsValidatorsExceptions;

public class ProductsValidator extends IValidate{

   private String code;
   public void setCode(String property){
       this.code = property;
   }

   private String name;
   public void setName(String property){
       this.name = property;
   }
   
   private String description;
   public void setDescription(String property){
       this.description = property;
   }

   private String keySAT;
   public void setKeySAT(String property){
       this.keySAT = property;
   }


   @Override
   public void validateInsert() throws Exception {

       if(code==null || code.isEmpty()){
           throw new ProductsValidatorsExceptions().getCodeException();
       }

       if(name==null || name.isEmpty()){
           throw new ProductsValidatorsExceptions().getNameException();
       }
       
       if(description==null || description.isEmpty()){
           throw new ProductsValidatorsExceptions().getDescriptionException();
       }

       if(keySAT==null || keySAT.isEmpty()){
           throw new ProductsValidatorsExceptions().getKeySATException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new ProductsValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new ProductsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

}