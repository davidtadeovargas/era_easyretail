package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.OrdssValidatorsExceptions;
import com.era.models.Ords;
import com.era.repositories.RepositoryFactory;

public class OrdssValidator extends IValidate{

   private String eje;
   public void setEje(String property){
       this.eje = property;
   }

   private String fent;
   public void setFent(String property){
       this.fent = property;
   }

   private String prov;
   public void setProv(String property){
       this.prov = property;
   }


   @Override
   public void validateInsert() throws Exception {

       if(eje==null || eje.isEmpty()){
           throw new OrdssValidatorsExceptions().getEjeException();
       }

       if(fent==null || fent.isEmpty()){
           throw new OrdssValidatorsExceptions().getFentException();
       }

       if(prov==null || prov.isEmpty()){
           throw new OrdssValidatorsExceptions().getProvException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new OrdssValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new OrdssValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

}