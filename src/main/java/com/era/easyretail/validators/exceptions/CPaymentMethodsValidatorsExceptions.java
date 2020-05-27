package com.era.easyretail.validators.exceptions;

public class CPaymentMethodsValidatorsExceptions {

   private static CPaymentMethodsValidatorsExceptions CPaymentMethodsValidatorsExceptions;

   public static CPaymentMethodsValidatorsExceptions getSigleton(){
       if(CPaymentMethodsValidatorsExceptions==null){CPaymentMethodsValidatorsExceptions = new CPaymentMethodsValidatorsExceptions();}return CPaymentMethodsValidatorsExceptions;
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