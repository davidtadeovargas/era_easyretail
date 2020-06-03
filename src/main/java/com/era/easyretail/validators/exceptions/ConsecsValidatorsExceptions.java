package com.era.easyretail.validators.exceptions;

public class ConsecsValidatorsExceptions {

   private static ConsecsValidatorsExceptions ConsecsValidatorsExceptions;

   public static ConsecsValidatorsExceptions getSigleton(){
       if(ConsecsValidatorsExceptions==null){ConsecsValidatorsExceptions = new ConsecsValidatorsExceptions();}return ConsecsValidatorsExceptions;
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

   public Exception getConsecException(){
       return new Exception("Falta espeficiar Consec");
   }

   public Exception getDescriptionException(){
       return new Exception("Falta espeficiar Description");
   }

   public Exception getSerieException(){
       return new Exception("Falta espeficiar Serie");
   }

   public Exception getTypeException(){
       return new Exception("Falta espeficiar Type");
   }

}