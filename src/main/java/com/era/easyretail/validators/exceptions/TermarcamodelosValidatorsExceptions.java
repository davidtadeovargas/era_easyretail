package com.era.easyretail.validators.exceptions;

public class TermarcamodelosValidatorsExceptions {

   private static TermarcamodelosValidatorsExceptions TermarcamodelosValidatorsExceptions;

   public static TermarcamodelosValidatorsExceptions getSigleton(){
       if(TermarcamodelosValidatorsExceptions==null){TermarcamodelosValidatorsExceptions = new TermarcamodelosValidatorsExceptions();}return TermarcamodelosValidatorsExceptions;
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

   public Exception getMarcException(){
       return new Exception("Falta espeficiar Marc");
   }

   public Exception getModelException(){
       return new Exception("Falta espeficiar Model");
   }

}