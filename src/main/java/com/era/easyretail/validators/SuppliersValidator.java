package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.SuppliersValidatorsExceptions;

public class SuppliersValidator extends IValidate{

   private String code;
   public void setCode(String property){
       this.code = property;
   }

   private String name;
   public void setName(String property){
       this.name = property;
   }

   private String serie;
   public void setSerie(String property){
       this.serie = property;
   }

   

   @Override
   public void validateInsert() throws Exception {

        if(code==null || code.isEmpty()){
           throw new SuppliersValidatorsExceptions().getCodeException();
        }
        if(name==null || name.isEmpty()){
           throw new SuppliersValidatorsExceptions().getNameException();
        }

        if(serie==null || serie.isEmpty()){
           throw new SuppliersValidatorsExceptions().getSerieException();
        }
       
        if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new SuppliersValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new SuppliersValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

}