package com.era.easyretail.validators.exceptions;

public class LicensesValidatorsExceptions {

   private static LicensesValidatorsExceptions LicensesValidatorsExceptions;

   public static LicensesValidatorsExceptions getSigleton(){
       if(LicensesValidatorsExceptions==null){LicensesValidatorsExceptions = new LicensesValidatorsExceptions();}return LicensesValidatorsExceptions;
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