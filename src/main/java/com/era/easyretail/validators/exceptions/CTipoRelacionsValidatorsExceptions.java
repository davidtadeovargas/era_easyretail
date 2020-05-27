package com.era.easyretail.validators.exceptions;

public class CTipoRelacionsValidatorsExceptions {

   private static CTipoRelacionsValidatorsExceptions CTipoRelacionsValidatorsExceptions;

   public static CTipoRelacionsValidatorsExceptions getSigleton(){
       if(CTipoRelacionsValidatorsExceptions==null){CTipoRelacionsValidatorsExceptions = new CTipoRelacionsValidatorsExceptions();}return CTipoRelacionsValidatorsExceptions;
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

   public Exception getDescriptionException(){
       return new Exception("Falta espeficiar Description");
   }

}