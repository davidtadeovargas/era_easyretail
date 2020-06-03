package com.era.easyretail.validators.exceptions;

public class PessValidatorsExceptions {

   private static PessValidatorsExceptions PessValidatorsExceptions;

   public static PessValidatorsExceptions getSigleton(){
       if(PessValidatorsExceptions==null){PessValidatorsExceptions = new PessValidatorsExceptions();}return PessValidatorsExceptions;
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

   public Exception getDescripException(){
       return new Exception("Falta espeficiar Descrip");
   }

}