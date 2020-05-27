package com.era.easyretail.validators.exceptions;

public class ClasjeraprodsValidatorsExceptions {

   private static ClasjeraprodsValidatorsExceptions ClasjeraprodsValidatorsExceptions;

   public static ClasjeraprodsValidatorsExceptions getSigleton(){
       if(ClasjeraprodsValidatorsExceptions==null){ClasjeraprodsValidatorsExceptions = new ClasjeraprodsValidatorsExceptions();}return ClasjeraprodsValidatorsExceptions;
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