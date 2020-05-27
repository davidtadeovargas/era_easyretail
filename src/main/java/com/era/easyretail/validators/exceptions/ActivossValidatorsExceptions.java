package com.era.easyretail.validators.exceptions;

public class ActivossValidatorsExceptions {

   private static ActivossValidatorsExceptions ActivossValidatorsExceptions;

   public static ActivossValidatorsExceptions getSigleton(){
       if(ActivossValidatorsExceptions==null){ActivossValidatorsExceptions = new ActivossValidatorsExceptions();}return ActivossValidatorsExceptions;
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