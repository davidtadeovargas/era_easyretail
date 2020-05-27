package com.era.easyretail.validators.exceptions;

public class CTipoComprobantesValidatorsExceptions {

   private static CTipoComprobantesValidatorsExceptions CTipoComprobantesValidatorsExceptions;

   public static CTipoComprobantesValidatorsExceptions getSigleton(){
       if(CTipoComprobantesValidatorsExceptions==null){CTipoComprobantesValidatorsExceptions = new CTipoComprobantesValidatorsExceptions();}return CTipoComprobantesValidatorsExceptions;
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

}