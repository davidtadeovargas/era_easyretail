package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.PessValidatorsExceptions;
import com.era.models.Pes;
import com.era.repositories.RepositoryFactory;

public class PessValidator extends IValidate{

   private String code;
   public void setCode(String property){
       this.code = property;
   }

   private String descrip;
   public void setDescrip(String property){
       this.descrip = property;
   }


   @Override
   public void validateInsert() throws Exception {

       if(code==null || code.isEmpty()){
           throw new PessValidatorsExceptions().getCodeException();
       }

       if(descrip==null || descrip.isEmpty()){
           throw new PessValidatorsExceptions().getDescripException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new PessValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new PessValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

}