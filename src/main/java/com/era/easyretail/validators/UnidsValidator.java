package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.UnidsValidatorsExceptions;
import com.era.models.Unid;
import com.era.repositories.RepositoryFactory;

public class UnidsValidator extends IValidate{

   private String claveSAT;
   public void setClaveSAT(String property){
       this.claveSAT = property;
   }

   private String code;
   public void setCode(String property){
       this.code = property;
   }


   @Override
   public void validateInsert() throws Exception {

       if(claveSAT==null || claveSAT.isEmpty()){
           throw new UnidsValidatorsExceptions().getClaveSATException();
       }

       if(code==null || code.isEmpty()){
           throw new UnidsValidatorsExceptions().getCodeException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new UnidsValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new UnidsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

}