package com.era.easyretail.validators.exceptions;

public class PaymentFormsValidatorsExceptions {

   private static PaymentFormsValidatorsExceptions PaymentFormsValidatorsExceptions;

   public static PaymentFormsValidatorsExceptions getSigleton(){
       if(PaymentFormsValidatorsExceptions==null){PaymentFormsValidatorsExceptions = new PaymentFormsValidatorsExceptions();}return PaymentFormsValidatorsExceptions;
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