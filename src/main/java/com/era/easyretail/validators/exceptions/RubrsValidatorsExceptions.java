package com.era.easyretail.validators.exceptions;

public class RubrsValidatorsExceptions {

   private static RubrsValidatorsExceptions RubrsValidatorsExceptions;

   public static RubrsValidatorsExceptions getSigleton(){
       if(RubrsValidatorsExceptions==null){RubrsValidatorsExceptions = new RubrsValidatorsExceptions();}return RubrsValidatorsExceptions;
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

   public Exception getCodException(){
       return new Exception("Falta espeficiar Cod");
   }

   public Exception getDescripException(){
       return new Exception("Falta espeficiar Descrip");
   }

}