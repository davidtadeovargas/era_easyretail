package com.era.easyretail.validators.exceptions;

public class TraspassValidatorsExceptions {

   private static TraspassValidatorsExceptions TraspassValidatorsExceptions;

   public static TraspassValidatorsExceptions getSigleton(){
       if(TraspassValidatorsExceptions==null){TraspassValidatorsExceptions = new TraspassValidatorsExceptions();}return TraspassValidatorsExceptions;
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

   public Exception getAlmaException(){
       return new Exception("Falta espeficiar Alma");
   }

   public Exception getAlmaaException(){
       return new Exception("Falta espeficiar Almaa");
   }

   public Exception getConcepException(){
       return new Exception("Falta espeficiar Concep");
   }

   public Exception getUnidException(){
       return new Exception("Falta espeficiar Unid");
   }

}