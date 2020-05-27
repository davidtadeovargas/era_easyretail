package com.era.easyretail.validators.exceptions;

public class BasDatssValidatorsExceptions {

   private static BasDatssValidatorsExceptions BasDatssValidatorsExceptions;

   public static BasDatssValidatorsExceptions getSigleton(){
       if(BasDatssValidatorsExceptions==null){BasDatssValidatorsExceptions = new BasDatssValidatorsExceptions();}return BasDatssValidatorsExceptions;
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

   public Exception getCodempException(){
       return new Exception("Falta espeficiar Codemp");
   }

   public Exception getNomException(){
       return new Exception("Falta espeficiar Nom");
   }

}