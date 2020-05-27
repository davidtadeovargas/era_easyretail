package com.era.easyretail.validators.exceptions;

public class ImpuesXProductsValidatorsExceptions {

   private static ImpuesXProductsValidatorsExceptions ImpuesXProductsValidatorsExceptions;

   public static ImpuesXProductsValidatorsExceptions getSigleton(){
       if(ImpuesXProductsValidatorsExceptions==null){ImpuesXProductsValidatorsExceptions = new ImpuesXProductsValidatorsExceptions();}return ImpuesXProductsValidatorsExceptions;
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

   public Exception getImpueException(){
       return new Exception("Falta espeficiar Impue");
   }

   public Exception getProduException(){
       return new Exception("Falta espeficiar Produ");
   }

}