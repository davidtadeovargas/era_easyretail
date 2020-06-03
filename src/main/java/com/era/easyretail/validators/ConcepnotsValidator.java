package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.ConcepnotsValidatorsExceptions;
import com.era.models.Concepnot;
import com.era.repositories.RepositoryFactory;

public class ConcepnotsValidator extends IValidate{

   private String concep;
   public void setConcep(String property){
       this.concep = property;
   }

   private String descrip;
   public void setDescrip(String property){
       this.descrip = property;
   }


   @Override
   public void validateInsert() throws Exception {

       if(concep==null || concep.isEmpty()){
           throw new ConcepnotsValidatorsExceptions().getConcepException();
       }

       if(descrip==null || descrip.isEmpty()){
           throw new ConcepnotsValidatorsExceptions().getDescripException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new ConcepnotsValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new ConcepnotsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

}