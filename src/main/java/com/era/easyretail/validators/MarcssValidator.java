package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.MarcssValidatorsExceptions;
import com.era.models.Marcs;
import com.era.repositories.RepositoryFactory;

public class MarcssValidator extends IValidate{

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
           throw new MarcssValidatorsExceptions().getCodeException();
       }

       if(descrip==null || descrip.isEmpty()){
           throw new MarcssValidatorsExceptions().getDescripException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new MarcssValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new MarcssValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

}