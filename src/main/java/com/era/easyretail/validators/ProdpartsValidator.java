package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.ProdpartsValidatorsExceptions;
import com.era.models.Prodpart;
import com.era.repositories.RepositoryFactory;

public class ProdpartsValidator extends IValidate{

   private String code;
   public void setCode(String property){
       this.code = property;
   }

   private String part;
   public void setPart(String property){
       this.part = property;
   }


   @Override
   public void validateInsert() throws Exception {

       if(code==null || code.isEmpty()){
           throw new ProdpartsValidatorsExceptions().getCodeException();
       }

       if(part==null || part.isEmpty()){
           throw new ProdpartsValidatorsExceptions().getPartException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new ProdpartsValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new ProdpartsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

}