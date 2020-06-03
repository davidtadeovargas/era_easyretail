package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.PartflujactsValidatorsExceptions;
import com.era.models.Partflujact;
import com.era.repositories.RepositoryFactory;

public class PartflujactsValidator extends IValidate{

   private String idfluj;
   public void setIdfluj(String property){
       this.idfluj = property;
   }

   private String segui;
   public void setSegui(String property){
       this.segui = property;
   }


   @Override
   public void validateInsert() throws Exception {

       if(idfluj==null || idfluj.isEmpty()){
           throw new PartflujactsValidatorsExceptions().getIdflujException();
       }

       if(segui==null || segui.isEmpty()){
           throw new PartflujactsValidatorsExceptions().getSeguiException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new PartflujactsValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new PartflujactsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

}