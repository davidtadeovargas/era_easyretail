package com.era.easyretail.validators.exceptions;

public class PaymentsValidatorsExceptions {

   private static PaymentsValidatorsExceptions PaymentsValidatorsExceptions;

   public static PaymentsValidatorsExceptions getSigleton(){
       if(PaymentsValidatorsExceptions==null){PaymentsValidatorsExceptions = new PaymentsValidatorsExceptions();}return PaymentsValidatorsExceptions;
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