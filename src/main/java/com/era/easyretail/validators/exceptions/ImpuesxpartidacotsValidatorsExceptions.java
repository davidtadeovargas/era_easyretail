package com.era.easyretail.validators.exceptions;

public class ImpuesxpartidacotsValidatorsExceptions {

   private static ImpuesxpartidacotsValidatorsExceptions ImpuesxpartidacotsValidatorsExceptions;

   public static ImpuesxpartidacotsValidatorsExceptions getSigleton(){
       if(ImpuesxpartidacotsValidatorsExceptions==null){ImpuesxpartidacotsValidatorsExceptions = new ImpuesxpartidacotsValidatorsExceptions();}return ImpuesxpartidacotsValidatorsExceptions;
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

   public Exception getCodigoImpuestoException(){
       return new Exception("Falta espeficiar CodigoImpuesto");
   }

   public Exception getIdPartidaException(){
       return new Exception("Falta espeficiar IdPartida");
   }

   public Exception getIdPartsException(){
       return new Exception("Falta espeficiar IdParts");
   }

   public Exception getRet_trasException(){
       return new Exception("Falta espeficiar Ret_tras");
   }

   public Exception getRetencionException(){
       return new Exception("Falta espeficiar Retencion");
   }

   public Exception getTasaException(){
       return new Exception("Falta espeficiar Tasa");
   }

   public Exception getTotalException(){
       return new Exception("Falta espeficiar Total");
   }

}