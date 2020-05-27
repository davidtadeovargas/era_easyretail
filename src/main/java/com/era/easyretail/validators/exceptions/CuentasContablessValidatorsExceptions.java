package com.era.easyretail.validators.exceptions;

public class CuentasContablessValidatorsExceptions {

   private static CuentasContablessValidatorsExceptions CuentasContablessValidatorsExceptions;

   public static CuentasContablessValidatorsExceptions getSigleton(){
       if(CuentasContablessValidatorsExceptions==null){CuentasContablessValidatorsExceptions = new CuentasContablessValidatorsExceptions();}return CuentasContablessValidatorsExceptions;
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

   public Exception getCuentaException(){
       return new Exception("Falta espeficiar Cuenta");
   }

   public Exception getDescripException(){
       return new Exception("Falta espeficiar Descrip");
   }

}