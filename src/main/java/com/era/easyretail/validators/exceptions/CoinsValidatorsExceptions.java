package com.era.easyretail.validators.exceptions;

public class CoinsValidatorsExceptions {

   private static CoinsValidatorsExceptions CoinsValidatorsExceptions;

   public static CoinsValidatorsExceptions getSigleton(){
       if(CoinsValidatorsExceptions==null){CoinsValidatorsExceptions = new CoinsValidatorsExceptions();}return CoinsValidatorsExceptions;
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

   public Exception getC_monedaException(){
       return new Exception("Falta espeficiar C_moneda");
   }

   public Exception getDescriptionException(){
       return new Exception("Falta espeficiar Description");
   }

   public Exception getSimbolException(){
       return new Exception("Falta espeficiar Simbol");
   }

}