package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.AnaqssValidatorsExceptions;
import com.era.models.Anaqs;
import com.era.repositories.RepositoryFactory;

public class AnaqssValidator extends IValidate{

   private String cod;
   public void setCod(String property){
       this.cod = property;
   }

   private String descrip;
   public void setDescrip(String property){
       this.descrip = property;
   }


   @Override
   public void validateInsert() throws Exception {

       if(cod==null || cod.isEmpty()){
           throw new AnaqssValidatorsExceptions().getCodException();
       }

       if(descrip==null || descrip.isEmpty()){
           throw new AnaqssValidatorsExceptions().getDescripException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new AnaqssValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new AnaqssValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

}