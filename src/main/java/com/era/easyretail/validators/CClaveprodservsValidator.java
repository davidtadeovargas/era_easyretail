package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.CClaveprodservsValidatorsExceptions;
import com.era.models.CClaveprodserv;
import com.era.repositories.RepositoryFactory;

public class CClaveprodservsValidator extends IValidate{

   private String c_ClaveProdServ;
   public void setC_ClaveProdServ(String property){
       this.c_ClaveProdServ = property;
   }

   private String description;
   public void setDescription(String property){
       this.description = property;
   }


   @Override
   public void validateInsert() throws Exception {

       if(c_ClaveProdServ==null || c_ClaveProdServ.isEmpty()){
           throw new CClaveprodservsValidatorsExceptions().getC_ClaveProdServException();
       }

       if(description==null || description.isEmpty()){
           throw new CClaveprodservsValidatorsExceptions().getDescriptionException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new CClaveprodservsValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new CClaveprodservsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

}