package com.era.easyretail.validators.exceptions;

public class UsersValidatorsExceptions {

   private static UsersValidatorsExceptions UsersValidatorsExceptions;

   public static UsersValidatorsExceptions getSigleton(){
       if(UsersValidatorsExceptions==null){UsersValidatorsExceptions = new UsersValidatorsExceptions();}return UsersValidatorsExceptions;
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

   public Exception getCortException(){
       return new Exception("Falta espeficiar Cort");
   }

   public Exception getDisccountException(){
       return new Exception("Falta espeficiar Disccount");
   }

   public Exception getM52Exception(){
       return new Exception("Falta espeficiar M52");
   }

   public Exception getPasswordException(){
       return new Exception("Falta espeficiar Password");
   }

   public Exception getUserOfsalesOfPointException(){
       return new Exception("Falta espeficiar UserOfsalesOfPoint");
   }

}