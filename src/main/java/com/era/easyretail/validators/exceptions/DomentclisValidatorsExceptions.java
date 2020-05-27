package com.era.easyretail.validators.exceptions;

public class DomentclisValidatorsExceptions {

   private static DomentclisValidatorsExceptions DomentclisValidatorsExceptions;

   public static DomentclisValidatorsExceptions getSigleton(){
       if(DomentclisValidatorsExceptions==null){DomentclisValidatorsExceptions = new DomentclisValidatorsExceptions();}return DomentclisValidatorsExceptions;
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

   public Exception getCodempException(){
       return new Exception("Falta espeficiar Codemp");
   }

}