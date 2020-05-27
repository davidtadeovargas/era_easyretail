package com.era.easyretail.validators.exceptions;

public class ResplogsValidatorsExceptions {

   private static ResplogsValidatorsExceptions ResplogsValidatorsExceptions;

   public static ResplogsValidatorsExceptions getSigleton(){
       if(ResplogsValidatorsExceptions==null){ResplogsValidatorsExceptions = new ResplogsValidatorsExceptions();}return ResplogsValidatorsExceptions;
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

   public Exception getTipException(){
       return new Exception("Falta espeficiar Tip");
   }

}