package com.era.easyretail.validators.exceptions;

public class ConfgralsValidatorsExceptions {

   private static ConfgralsValidatorsExceptions ConfgralsValidatorsExceptions;

   public static ConfgralsValidatorsExceptions getSigleton(){
       if(ConfgralsValidatorsExceptions==null){ConfgralsValidatorsExceptions = new ConfgralsValidatorsExceptions();}return ConfgralsValidatorsExceptions;
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

   public Exception getClasifException(){
       return new Exception("Falta espeficiar Clasif");
   }

   public Exception getConfException(){
       return new Exception("Falta espeficiar Conf");
   }

   public Exception getValException(){
       return new Exception("Falta espeficiar Val");
   }

}