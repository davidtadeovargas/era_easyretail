package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.FlujactsValidatorsExceptions;
import com.era.models.Flujact;
import com.era.repositories.RepositoryFactory;

public class FlujactsValidator extends IValidate{

   private String tit;
   public void setTit(String property){
       this.tit = property;
   }

   private String usrenvi;
   public void setUsrenvi(String property){
       this.usrenvi = property;
   }

   private String usrrecib;
   public void setUsrrecib(String property){
       this.usrrecib = property;
   }


   @Override
   public void validateInsert() throws Exception {

       if(tit==null || tit.isEmpty()){
           throw new FlujactsValidatorsExceptions().getTitException();
       }

       if(usrenvi==null || usrenvi.isEmpty()){
           throw new FlujactsValidatorsExceptions().getUsrenviException();
       }

       if(usrrecib==null || usrrecib.isEmpty()){
           throw new FlujactsValidatorsExceptions().getUsrrecibException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new FlujactsValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new FlujactsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

}