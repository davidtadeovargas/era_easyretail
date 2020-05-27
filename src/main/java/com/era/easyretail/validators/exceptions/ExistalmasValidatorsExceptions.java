package com.era.easyretail.validators.exceptions;

public class ExistalmasValidatorsExceptions {

   private static ExistalmasValidatorsExceptions ExistalmasValidatorsExceptions;

   public static ExistalmasValidatorsExceptions getSigleton(){
       if(ExistalmasValidatorsExceptions==null){ExistalmasValidatorsExceptions = new ExistalmasValidatorsExceptions();}return ExistalmasValidatorsExceptions;
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

   public Exception getAlmaException(){
       return new Exception("Falta espeficiar Alma");
   }

   public Exception getProdException(){
       return new Exception("Falta espeficiar Prod");
   }

}