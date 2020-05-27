package com.era.easyretail.validators.exceptions;

public class CUsoCFDIsValidatorsExceptions {

   private static CUsoCFDIsValidatorsExceptions CUsoCFDIsValidatorsExceptions;

   public static CUsoCFDIsValidatorsExceptions getSigleton(){
       if(CUsoCFDIsValidatorsExceptions==null){CUsoCFDIsValidatorsExceptions = new CUsoCFDIsValidatorsExceptions();}return CUsoCFDIsValidatorsExceptions;
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