package com.era.easyretail.validators.exceptions;

public class MetogoPagosValidatorsExceptions {

   private static MetogoPagosValidatorsExceptions MetogoPagosValidatorsExceptions;

   public static MetogoPagosValidatorsExceptions getSigleton(){
       if(MetogoPagosValidatorsExceptions==null){MetogoPagosValidatorsExceptions = new MetogoPagosValidatorsExceptions();}return MetogoPagosValidatorsExceptions;
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

   public Exception getDescriptionException(){
       return new Exception("Falta espeficiar Description");
   }

}