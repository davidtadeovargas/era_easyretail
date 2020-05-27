package com.era.easyretail.validators.exceptions;

public class CCoinsValidatorsExceptions {

   private static CCoinsValidatorsExceptions CCoinsValidatorsExceptions;

   public static CCoinsValidatorsExceptions getSigleton(){
       if(CCoinsValidatorsExceptions==null){CCoinsValidatorsExceptions = new CCoinsValidatorsExceptions();}return CCoinsValidatorsExceptions;
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

   public Exception getInitVigencyDateException(){
       return new Exception("Falta espeficiar InitVigencyDate");
   }

   public Exception getVariationPorcentException(){
       return new Exception("Falta espeficiar VariationPorcent");
   }

}