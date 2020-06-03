package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.ConcepssValidatorsExceptions;
import com.era.models.Conceps;
import com.era.repositories.RepositoryFactory;

public class ConcepssValidator extends IValidate{

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
           throw new ConcepssValidatorsExceptions().getConcepException();
       }

       if(descrip==null || descrip.isEmpty()){
           throw new ConcepssValidatorsExceptions().getDescripException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new ConcepssValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new ConcepssValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

}