package com.era.easyretail.validators.exceptions;

public class TipactfijsValidatorsExceptions {

   private static TipactfijsValidatorsExceptions TipactfijsValidatorsExceptions;

   public static TipactfijsValidatorsExceptions getSigleton(){
       if(TipactfijsValidatorsExceptions==null){TipactfijsValidatorsExceptions = new TipactfijsValidatorsExceptions();}return TipactfijsValidatorsExceptions;
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

   public Exception getTipException(){
       return new Exception("Falta espeficiar Tip");
   }

}