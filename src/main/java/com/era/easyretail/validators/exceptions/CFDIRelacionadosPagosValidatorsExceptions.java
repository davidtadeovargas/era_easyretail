package com.era.easyretail.validators.exceptions;

public class CFDIRelacionadosPagosValidatorsExceptions {

   private static CFDIRelacionadosPagosValidatorsExceptions CFDIRelacionadosPagosValidatorsExceptions;

   public static CFDIRelacionadosPagosValidatorsExceptions getSigleton(){
       if(CFDIRelacionadosPagosValidatorsExceptions==null){CFDIRelacionadosPagosValidatorsExceptions = new CFDIRelacionadosPagosValidatorsExceptions();}return CFDIRelacionadosPagosValidatorsExceptions;
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

   public Exception getTipo_relacionException(){
       return new Exception("Falta espeficiar Tipo_relacion");
   }

   public Exception getUuidException(){
       return new Exception("Falta espeficiar Uuid");
   }

}