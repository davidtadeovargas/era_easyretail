package com.era.easyretail.validators.exceptions;

public class CostssValidatorsExceptions {

   private static CostssValidatorsExceptions CostssValidatorsExceptions;

   public static CostssValidatorsExceptions getSigleton(){
       if(CostssValidatorsExceptions==null){CostssValidatorsExceptions = new CostssValidatorsExceptions();}return CostssValidatorsExceptions;
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

   public Exception getMonedaIDException(){
       return new Exception("Falta espeficiar MonedaID");
   }

   public Exception getProdException(){
       return new Exception("Falta espeficiar Prod");
   }

   public Exception getTipcamException(){
       return new Exception("Falta espeficiar Tipcam");
   }

}