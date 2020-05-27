package com.era.easyretail.validators.exceptions;

public class RutssValidatorsExceptions {

   private static RutssValidatorsExceptions RutssValidatorsExceptions;

   public static RutssValidatorsExceptions getSigleton(){
       if(RutssValidatorsExceptions==null){RutssValidatorsExceptions = new RutssValidatorsExceptions();}return RutssValidatorsExceptions;
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

   public Exception getNomException(){
       return new Exception("Falta espeficiar Nom");
   }

   public Exception getProgramException(){
       return new Exception("Falta espeficiar Program");
   }

   public Exception getRutException(){
       return new Exception("Falta espeficiar Rut");
   }

}