package com.era.easyretail.validators.exceptions;

public class TipssValidatorsExceptions {

   private static TipssValidatorsExceptions TipssValidatorsExceptions;

   public static TipssValidatorsExceptions getSigleton(){
       if(TipssValidatorsExceptions==null){TipssValidatorsExceptions = new TipssValidatorsExceptions();}return TipssValidatorsExceptions;
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

   public Exception getDescripException(){
       return new Exception("Falta espeficiar Descrip");
   }

}