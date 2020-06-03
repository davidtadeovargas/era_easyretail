package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.GeneralConfigsValidatorsExceptions;
import com.era.models.GeneralConfig;
import com.era.repositories.RepositoryFactory;

public class GeneralConfigsValidator extends IValidate{

   private String casification;
   public void setCasification(String property){
       this.casification = property;
   }

   private String configuration;
   public void setConfiguration(String property){
       this.configuration = property;
   }

   private String extra;
   public void setExtra(String property){
       this.extra = property;
   }

   private String numext;
   public void setNumext(String property){
       this.numext = property;
   }

   private String value;
   public void setValue(String property){
       this.value = property;
   }


   @Override
   public void validateInsert() throws Exception {

       if(casification==null || casification.isEmpty()){
           throw new GeneralConfigsValidatorsExceptions().getCasificationException();
       }

       if(configuration==null || configuration.isEmpty()){
           throw new GeneralConfigsValidatorsExceptions().getConfigurationException();
       }

       if(extra==null || extra.isEmpty()){
           throw new GeneralConfigsValidatorsExceptions().getExtraException();
       }

       if(numext==null || numext.isEmpty()){
           throw new GeneralConfigsValidatorsExceptions().getNumextException();
       }

       if(value==null || value.isEmpty()){
           throw new GeneralConfigsValidatorsExceptions().getValueException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new GeneralConfigsValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new GeneralConfigsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

}