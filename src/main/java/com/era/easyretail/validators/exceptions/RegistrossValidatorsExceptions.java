package com.era.easyretail.validators.exceptions;

public class RegistrossValidatorsExceptions {

   private static RegistrossValidatorsExceptions RegistrossValidatorsExceptions;

   public static RegistrossValidatorsExceptions getSigleton(){
       if(RegistrossValidatorsExceptions==null){RegistrossValidatorsExceptions = new RegistrossValidatorsExceptions();}return RegistrossValidatorsExceptions;
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