package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.PushNotificationsValidatorsExceptions;
import com.era.models.PushNotification;
import com.era.repositories.RepositoryFactory;

public class PushNotificationsValidator extends IValidate{

   private String code;
   private String bannerAction;

   @Override
   public void validateInsert() throws Exception {

       if(bannerAction==null || bannerAction.isEmpty()){
           throw new PushNotificationsValidatorsExceptions().getBannerActionException();
       }

       final PushNotification PushNotification = (PushNotification) RepositoryFactory.getInstance().getPushNotificationsRepository().getByCode(code);
       if(PushNotification != null){            
           throw new PushNotificationsValidatorsExceptions().getModelExistsException();
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

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new PushNotificationsValidatorsExceptions().getCodeException();
       }

       final PushNotification PushNotification = (PushNotification) RepositoryFactory.getInstance().getPushNotificationsRepository().getByCode(code);
       if(PushNotification == null){            
           throw new PushNotificationsValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new PushNotificationsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}