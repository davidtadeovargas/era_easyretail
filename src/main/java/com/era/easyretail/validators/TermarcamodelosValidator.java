package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.TermarcamodelosValidatorsExceptions;
import com.era.models.Termarcamodelo;
import com.era.repositories.RepositoryFactory;

public class TermarcamodelosValidator extends IValidate{

   private String marc;
   public void setMarc(String property){
       this.marc = property;
   }

   private String model;
   public void setModel(String property){
       this.model = property;
   }


   @Override
   public void validateInsert() throws Exception {

       if(marc==null || marc.isEmpty()){
           throw new TermarcamodelosValidatorsExceptions().getMarcException();
       }

       if(model==null || model.isEmpty()){
           throw new TermarcamodelosValidatorsExceptions().getModelException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new TermarcamodelosValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new TermarcamodelosValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

}