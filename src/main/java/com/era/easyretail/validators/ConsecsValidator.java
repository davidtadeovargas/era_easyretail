package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.ConsecsValidatorsExceptions;
import com.era.models.Consec;
import com.era.repositories.RepositoryFactory;

public class ConsecsValidator extends IValidate{

   private String consec;
   public void setConsec(String property){
       this.consec = property;
   }

   private String description;
   public void setDescription(String property){
       this.description = property;
   }

   private String serie;
   public void setSerie(String property){
       this.serie = property;
   }

   private String type;
   public void setType(String property){
       this.type = property;
   }


   @Override
   public void validateInsert() throws Exception {

       if(consec==null || consec.isEmpty()){
           throw new ConsecsValidatorsExceptions().getConsecException();
       }

       if(description==null || description.isEmpty()){
           throw new ConsecsValidatorsExceptions().getDescriptionException();
       }

       if(serie==null || serie.isEmpty()){
           throw new ConsecsValidatorsExceptions().getSerieException();
       }

       if(type==null || type.isEmpty()){
           throw new ConsecsValidatorsExceptions().getTypeException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new ConsecsValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new ConsecsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

}