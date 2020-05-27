package com.era.easyretail.validators.exceptions;

public class AuxiliarsValidatorsExceptions {

   private static AuxiliarsValidatorsExceptions AuxiliarsValidatorsExceptions;

   public static AuxiliarsValidatorsExceptions getSigleton(){
       if(AuxiliarsValidatorsExceptions==null){AuxiliarsValidatorsExceptions = new AuxiliarsValidatorsExceptions();}return AuxiliarsValidatorsExceptions;
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