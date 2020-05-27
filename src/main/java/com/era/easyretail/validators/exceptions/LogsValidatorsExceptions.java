package com.era.easyretail.validators.exceptions;

public class LogsValidatorsExceptions {

   private static LogsValidatorsExceptions LogsValidatorsExceptions;

   public static LogsValidatorsExceptions getSigleton(){
       if(LogsValidatorsExceptions==null){LogsValidatorsExceptions = new LogsValidatorsExceptions();}return LogsValidatorsExceptions;
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

   public Exception getAccioException(){
       return new Exception("Falta espeficiar Accio");
   }

   public Exception getCodException(){
       return new Exception("Falta espeficiar Cod");
   }

   public Exception getDescripException(){
       return new Exception("Falta espeficiar Descrip");
   }

   public Exception getTypeException(){
       return new Exception("Falta espeficiar Type");
   }

}