package com.era.easyretail.validators.exceptions;

public class ChatsValidatorsExceptions {

   private static ChatsValidatorsExceptions ChatsValidatorsExceptions;

   public static ChatsValidatorsExceptions getSigleton(){
       if(ChatsValidatorsExceptions==null){ChatsValidatorsExceptions = new ChatsValidatorsExceptions();}return ChatsValidatorsExceptions;
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

   public Exception getMsjException(){
       return new Exception("Falta espeficiar Msj");
   }

}