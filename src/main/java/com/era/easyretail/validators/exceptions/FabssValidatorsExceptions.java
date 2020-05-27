package com.era.easyretail.validators.exceptions;

public class FabssValidatorsExceptions {

   private static FabssValidatorsExceptions FabssValidatorsExceptions;

   public static FabssValidatorsExceptions getSigleton(){
       if(FabssValidatorsExceptions==null){FabssValidatorsExceptions = new FabssValidatorsExceptions();}return FabssValidatorsExceptions;
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