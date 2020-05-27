package com.era.easyretail.validators.exceptions;

public class ImpuestosXComprasValidatorsExceptions {

   private static ImpuestosXComprasValidatorsExceptions ImpuestosXComprasValidatorsExceptions;

   public static ImpuestosXComprasValidatorsExceptions getSigleton(){
       if(ImpuestosXComprasValidatorsExceptions==null){ImpuestosXComprasValidatorsExceptions = new ImpuestosXComprasValidatorsExceptions();}return ImpuestosXComprasValidatorsExceptions;
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

   public Exception getTotalException(){
       return new Exception("Falta espeficiar Total");
   }

}