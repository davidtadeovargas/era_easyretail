package com.era.easyretail.validators.exceptions;

public class ClasjeraprovsValidatorsExceptions {

   private static ClasjeraprovsValidatorsExceptions ClasjeraprovsValidatorsExceptions;

   public static ClasjeraprovsValidatorsExceptions getSigleton(){
       if(ClasjeraprovsValidatorsExceptions==null){ClasjeraprovsValidatorsExceptions = new ClasjeraprovsValidatorsExceptions();}return ClasjeraprovsValidatorsExceptions;
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

   public Exception getClasException(){
       return new Exception("Falta espeficiar Clas");
   }

   public Exception getRutException(){
       return new Exception("Falta espeficiar Rut");
   }

}