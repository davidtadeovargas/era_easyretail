package com.era.easyretail.validators.exceptions;

public class ProductsValidatorsExceptions {

   private static ProductsValidatorsExceptions ProductsValidatorsExceptions;

   public static ProductsValidatorsExceptions getSigleton(){
       if(ProductsValidatorsExceptions==null){ProductsValidatorsExceptions = new ProductsValidatorsExceptions();}return ProductsValidatorsExceptions;
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
       return new Exception("Falta espeficiar el código");
   }

   public Exception getDescriptionException(){
       return new Exception("Falta espeficiar la descripción");
   }

   public Exception getNameException(){
       return new Exception("Falta espeficiar el nombre");
   }
   
   public Exception getKeySATException(){
       return new Exception("Falta espeficiar KeySAT");
   }

}