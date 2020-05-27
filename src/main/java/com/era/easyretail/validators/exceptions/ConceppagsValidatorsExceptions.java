package com.era.easyretail.validators.exceptions;

public class ConceppagsValidatorsExceptions {

   private static ConceppagsValidatorsExceptions ConceppagsValidatorsExceptions;

   public static ConceppagsValidatorsExceptions getSigleton(){
       if(ConceppagsValidatorsExceptions==null){ConceppagsValidatorsExceptions = new ConceppagsValidatorsExceptions();}return ConceppagsValidatorsExceptions;
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

   public Exception getConcepException(){
       return new Exception("Falta espeficiar Concep");
   }

   public Exception getDescripException(){
       return new Exception("Falta espeficiar Descrip");
   }

}