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
       return new Exception("Falta espeficiar codigo");
   }

   public Exception getBranchOfficeException(){
       return new Exception("Falta espeficiar BranchOffice");
   }

   public Exception getCodeProductException(){
       return new Exception("Falta espeficiar CodeProduct");
   }

   public Exception getDescriptionException(){
       return new Exception("Falta espeficiar Description");
   }

   public Exception getEstationException(){
       return new Exception("Falta espeficiar Estation");
   }

   public Exception getKeySATException(){
       return new Exception("Falta espeficiar KeySAT");
   }

   public Exception getNumberCashException(){
       return new Exception("Falta espeficiar NumberCash");
   }

}