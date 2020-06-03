package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.DatoscpsValidatorsExceptions;
import com.era.models.Datoscp;
import com.era.repositories.RepositoryFactory;

public class DatoscpsValidator extends IValidate{

   private String vta;
   public void setVta(String property){
       this.vta = property;
   }


   @Override
   public void validateInsert() throws Exception {

       if(vta==null || vta.isEmpty()){
           throw new DatoscpsValidatorsExceptions().getVtaException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new DatoscpsValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new DatoscpsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

}