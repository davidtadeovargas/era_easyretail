package com.era.easyretail.validators.exceptions;

public class CompasValidatorsExceptions {

   private static CompasValidatorsExceptions CompasValidatorsExceptions;

   public static CompasValidatorsExceptions getSigleton(){
       if(CompasValidatorsExceptions==null){CompasValidatorsExceptions = new CompasValidatorsExceptions();}return CompasValidatorsExceptions;
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

   public Exception getCompaException(){
       return new Exception("Falta espeficiar Compa");
   }

   public Exception getProdException(){
       return new Exception("Falta espeficiar Prod");
   }

}