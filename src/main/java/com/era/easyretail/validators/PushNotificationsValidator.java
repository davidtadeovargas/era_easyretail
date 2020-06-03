package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.PushNotificationsValidatorsExceptions;
import com.era.models.PushNotification;
import com.era.repositories.RepositoryFactory;

public class PushNotificationsValidator extends IValidate{

   private String bannerAction;
   public void setBannerAction(String property){
       this.bannerAction = property;
   }


   @Override
   public void validateInsert() throws Exception {

       if(bannerAction==null || bannerAction.isEmpty()){
           throw new PushNotificationsValidatorsExceptions().getBannerActionException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new PushNotificationsValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new PushNotificationsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

}