package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.SeriesValidatorsExceptions;
import com.era.models.Serie;
import com.era.repositories.RepositoryFactory;

public class SeriesValidator extends IValidate{

   private String code;
   public void setCode(String property){
       this.code = property;
   }

   private String consecutive;
   public void setConsecutive(String property){
       this.consecutive = property;
   }

   private String description;
   public void setDescription(String property){
       this.description = property;
   }

   private String type;
   public void setType(String property){
       this.type = property;
   }


   @Override
   public void validateInsert() throws Exception {

       if(code==null || code.isEmpty()){
           throw new SeriesValidatorsExceptions().getCodeException();
       }

       if(consecutive==null || consecutive.isEmpty()){
           throw new SeriesValidatorsExceptions().getConsecutiveException();
       }

       if(description==null || description.isEmpty()){
           throw new SeriesValidatorsExceptions().getDescriptionException();
       }

       if(type==null || type.isEmpty()){
           throw new SeriesValidatorsExceptions().getTypeException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new SeriesValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new SeriesValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

}