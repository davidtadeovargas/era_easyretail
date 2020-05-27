package com.era.easyretail.validators.exceptions;

public class UsuarioseriesValidatorsExceptions {

   private static UsuarioseriesValidatorsExceptions UsuarioseriesValidatorsExceptions;

   public static UsuarioseriesValidatorsExceptions getSigleton(){
       if(UsuarioseriesValidatorsExceptions==null){UsuarioseriesValidatorsExceptions = new UsuarioseriesValidatorsExceptions();}return UsuarioseriesValidatorsExceptions;
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