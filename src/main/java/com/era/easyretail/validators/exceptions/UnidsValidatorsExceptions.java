package com.era.easyretail.validators.exceptions;

public class UnidsValidatorsExceptions {

   private static UnidsValidatorsExceptions UnidsValidatorsExceptions;

   public static UnidsValidatorsExceptions getSigleton(){
       if(UnidsValidatorsExceptions==null){UnidsValidatorsExceptions = new UnidsValidatorsExceptions();}return UnidsValidatorsExceptions;
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

   public Exception getClaveSATException(){
       return new Exception("Falta espeficiar ClaveSAT");
   }

}