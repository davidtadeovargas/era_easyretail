package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.ModelprodsValidatorsExceptions;
import com.era.models.Modelprod;
import com.era.repositories.RepositoryFactory;

public class ModelprodsValidator extends IValidate{

   private String mode;
   public void setMode(String property){
       this.mode = property;
   }

   private String prod;
   public void setProd(String property){
       this.prod = property;
   }


   @Override
   public void validateInsert() throws Exception {

       if(mode==null || mode.isEmpty()){
           throw new ModelprodsValidatorsExceptions().getModeException();
       }

       if(prod==null || prod.isEmpty()){
           throw new ModelprodsValidatorsExceptions().getProdException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new ModelprodsValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new ModelprodsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

}