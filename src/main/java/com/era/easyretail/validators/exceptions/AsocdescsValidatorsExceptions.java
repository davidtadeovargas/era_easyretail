package com.era.easyretail.validators.exceptions;

public class AsocdescsValidatorsExceptions {

   private static AsocdescsValidatorsExceptions AsocdescsValidatorsExceptions;

   public static AsocdescsValidatorsExceptions getSigleton(){
       if(AsocdescsValidatorsExceptions==null){AsocdescsValidatorsExceptions = new AsocdescsValidatorsExceptions();}return AsocdescsValidatorsExceptions;
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

   public Exception getClasException(){
       return new Exception("Falta espeficiar Clas");
   }

   public Exception getClasjeraException(){
       return new Exception("Falta espeficiar Clasjera");
   }

   public Exception getClienException(){
       return new Exception("Falta espeficiar Clien");
   }

   public Exception getProdException(){
       return new Exception("Falta espeficiar Prod");
   }

   public Exception getUsarException(){
       return new Exception("Falta espeficiar Usar");
   }

}