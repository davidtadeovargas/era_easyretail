package com.era.easyretail.validators.exceptions;

public class PushNotificationsValidatorsExceptions {

   private static PushNotificationsValidatorsExceptions PushNotificationsValidatorsExceptions;

   public static PushNotificationsValidatorsExceptions getSigleton(){
       if(PushNotificationsValidatorsExceptions==null){PushNotificationsValidatorsExceptions = new PushNotificationsValidatorsExceptions();}return PushNotificationsValidatorsExceptions;
   }

   public Exception getModelExistsException(){
       return new Exception("El registro ya existe");
   }

   public Exception getCustomVaidationNotPassedException(){
       return new Exception("El registro no paso las validaciones");
   }

   public Exception getModelNotExistsException(){
       return new Exception("El registro no existe");
   }

   public Exception getCodeException(){
       return new Exception("Falta espeficiar codigo");
   }

   public Exception getBannerActionException(){
       return new Exception("Falta espeficiar BannerAction");
   }

}