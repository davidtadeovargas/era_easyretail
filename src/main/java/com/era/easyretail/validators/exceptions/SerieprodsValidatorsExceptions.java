package com.era.easyretail.validators.exceptions;

public class SerieprodsValidatorsExceptions {

   private static SerieprodsValidatorsExceptions SerieprodsValidatorsExceptions;

   public static SerieprodsValidatorsExceptions getSigleton(){
       if(SerieprodsValidatorsExceptions==null){SerieprodsValidatorsExceptions = new SerieprodsValidatorsExceptions();}return SerieprodsValidatorsExceptions;
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

   public Exception getAlmaException(){
       return new Exception("Falta espeficiar Alma");
   }

   public Exception getComenException(){
       return new Exception("Falta espeficiar Comen");
   }

   public Exception getProdException(){
       return new Exception("Falta espeficiar Prod");
   }

   public Exception getSerException(){
       return new Exception("Falta espeficiar Ser");
   }

}