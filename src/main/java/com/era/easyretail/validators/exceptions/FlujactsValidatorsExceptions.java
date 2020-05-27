package com.era.easyretail.validators.exceptions;

public class FlujactsValidatorsExceptions {

   private static FlujactsValidatorsExceptions FlujactsValidatorsExceptions;

   public static FlujactsValidatorsExceptions getSigleton(){
       if(FlujactsValidatorsExceptions==null){FlujactsValidatorsExceptions = new FlujactsValidatorsExceptions();}return FlujactsValidatorsExceptions;
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

   public Exception getTitException(){
       return new Exception("Falta espeficiar Tit");
   }

   public Exception getUsrenviException(){
       return new Exception("Falta espeficiar Usrenvi");
   }

   public Exception getUsrrecibException(){
       return new Exception("Falta espeficiar Usrrecib");
   }

}