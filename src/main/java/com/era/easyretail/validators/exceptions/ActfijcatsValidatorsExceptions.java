package com.era.easyretail.validators.exceptions;

public class ActfijcatsValidatorsExceptions {

   private static ActfijcatsValidatorsExceptions ActfijcatsValidatorsExceptions;

   public static ActfijcatsValidatorsExceptions getSigleton(){
       if(ActfijcatsValidatorsExceptions==null){ActfijcatsValidatorsExceptions = new ActfijcatsValidatorsExceptions();}return ActfijcatsValidatorsExceptions;
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