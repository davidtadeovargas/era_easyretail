package com.era.easyretail.validators.exceptions;

public class GirosValidatorsExceptions {

   private static GirosValidatorsExceptions GirosValidatorsExceptions;

   public static GirosValidatorsExceptions getSigleton(){
       if(GirosValidatorsExceptions==null){GirosValidatorsExceptions = new GirosValidatorsExceptions();}return GirosValidatorsExceptions;
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

   public Exception getGirException(){
       return new Exception("Falta espeficiar Gir");
   }

}