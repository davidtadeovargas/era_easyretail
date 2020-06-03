package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.ConfgralsValidatorsExceptions;
import com.era.models.Confgral;
import com.era.repositories.RepositoryFactory;

public class ConfgralsValidator extends IValidate{

   private String clasif;
   public void setClasif(String property){
       this.clasif = property;
   }

   private String conf;
   public void setConf(String property){
       this.conf = property;
   }

   private String val;
   public void setVal(String property){
       this.val = property;
   }


   @Override
   public void validateInsert() throws Exception {

       if(clasif==null || clasif.isEmpty()){
           throw new ConfgralsValidatorsExceptions().getClasifException();
       }

       if(conf==null || conf.isEmpty()){
           throw new ConfgralsValidatorsExceptions().getConfException();
       }

       if(val==null || val.isEmpty()){
           throw new ConfgralsValidatorsExceptions().getValException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new ConfgralsValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new ConfgralsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

}