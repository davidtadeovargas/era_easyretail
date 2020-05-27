package com.era.easyretail.validators.exceptions;

public class BancosValidatorsExceptions {

   private static BancosValidatorsExceptions BancosValidatorsExceptions;

   public static BancosValidatorsExceptions getSigleton(){
       if(BancosValidatorsExceptions==null){BancosValidatorsExceptions = new BancosValidatorsExceptions();}return BancosValidatorsExceptions;
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

   public Exception getCuentabancoException(){
       return new Exception("Falta espeficiar Cuentabanco");
   }

   public Exception getDescripException(){
       return new Exception("Falta espeficiar Descrip");
   }

}