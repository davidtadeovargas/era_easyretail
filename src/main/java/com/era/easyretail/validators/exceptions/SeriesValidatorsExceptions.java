package com.era.easyretail.validators.exceptions;

public class SeriesValidatorsExceptions {

   private static SeriesValidatorsExceptions SeriesValidatorsExceptions;

   public static SeriesValidatorsExceptions getSigleton(){
       if(SeriesValidatorsExceptions==null){SeriesValidatorsExceptions = new SeriesValidatorsExceptions();}return SeriesValidatorsExceptions;
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

   public Exception getConsecutiveException(){
       return new Exception("Falta espeficiar Consecutive");
   }

   public Exception getDescriptionException(){
       return new Exception("Falta espeficiar Description");
   }

   public Exception getTypeException(){
       return new Exception("Falta espeficiar Type");
   }

}