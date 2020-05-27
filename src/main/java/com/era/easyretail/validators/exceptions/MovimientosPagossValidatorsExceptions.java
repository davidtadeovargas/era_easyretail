package com.era.easyretail.validators.exceptions;

public class MovimientosPagossValidatorsExceptions {

   private static MovimientosPagossValidatorsExceptions MovimientosPagossValidatorsExceptions;

   public static MovimientosPagossValidatorsExceptions getSigleton(){
       if(MovimientosPagossValidatorsExceptions==null){MovimientosPagossValidatorsExceptions = new MovimientosPagossValidatorsExceptions();}return MovimientosPagossValidatorsExceptions;
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

}