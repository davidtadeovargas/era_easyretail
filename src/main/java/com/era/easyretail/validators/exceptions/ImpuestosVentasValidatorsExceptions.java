package com.era.easyretail.validators.exceptions;

public class ImpuestosVentasValidatorsExceptions {

   private static ImpuestosVentasValidatorsExceptions ImpuestosVentasValidatorsExceptions;

   public static ImpuestosVentasValidatorsExceptions getSigleton(){
       if(ImpuestosVentasValidatorsExceptions==null){ImpuestosVentasValidatorsExceptions = new ImpuestosVentasValidatorsExceptions();}return ImpuestosVentasValidatorsExceptions;
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

   public Exception getFvencException(){
       return new Exception("Falta espeficiar Fvenc");
   }

   public Exception getImpuestoException(){
       return new Exception("Falta espeficiar Impuesto");
   }

   public Exception getRetencionException(){
       return new Exception("Falta espeficiar Retencion");
   }

   public Exception getTotalException(){
       return new Exception("Falta espeficiar Total");
   }

}