package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.MaxminconfsValidatorsExceptions;
import com.era.models.Maxminconf;
import com.era.repositories.RepositoryFactory;

public class MaxminconfsValidator extends IValidate{

   private String estacglo;
   public void setEstacglo(String property){
       this.estacglo = property;
   }

   private String hrs;
   public void setHrs(String property){
       this.hrs = property;
   }


   @Override
   public void validateInsert() throws Exception {

       if(estacglo==null || estacglo.isEmpty()){
           throw new MaxminconfsValidatorsExceptions().getEstacgloException();
       }

       if(hrs==null || hrs.isEmpty()){
           throw new MaxminconfsValidatorsExceptions().getHrsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new MaxminconfsValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new MaxminconfsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

}