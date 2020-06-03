package com.era.easyretail.validators.exceptions;

public class TipscambsValidatorsExceptions {

   private static TipscambsValidatorsExceptions TipscambsValidatorsExceptions;

   public static TipscambsValidatorsExceptions getSigleton(){
       if(TipscambsValidatorsExceptions==null){TipscambsValidatorsExceptions = new TipscambsValidatorsExceptions();}return TipscambsValidatorsExceptions;
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