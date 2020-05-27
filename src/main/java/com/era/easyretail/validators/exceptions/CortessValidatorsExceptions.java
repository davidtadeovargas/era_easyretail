package com.era.easyretail.validators.exceptions;

public class CortessValidatorsExceptions {

   private static CortessValidatorsExceptions CortessValidatorsExceptions;

   public static CortessValidatorsExceptions getSigleton(){
       if(CortessValidatorsExceptions==null){CortessValidatorsExceptions = new CortessValidatorsExceptions();}return CortessValidatorsExceptions;
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