package com.era.easyretail.validators.exceptions;

public class ProdpartsValidatorsExceptions {

   private static ProdpartsValidatorsExceptions ProdpartsValidatorsExceptions;

   public static ProdpartsValidatorsExceptions getSigleton(){
       if(ProdpartsValidatorsExceptions==null){ProdpartsValidatorsExceptions = new ProdpartsValidatorsExceptions();}return ProdpartsValidatorsExceptions;
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

   public Exception getPartException(){
       return new Exception("Falta espeficiar Part");
   }

}