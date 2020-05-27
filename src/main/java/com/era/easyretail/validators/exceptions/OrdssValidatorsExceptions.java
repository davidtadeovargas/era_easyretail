package com.era.easyretail.validators.exceptions;

public class OrdssValidatorsExceptions {

   private static OrdssValidatorsExceptions OrdssValidatorsExceptions;

   public static OrdssValidatorsExceptions getSigleton(){
       if(OrdssValidatorsExceptions==null){OrdssValidatorsExceptions = new OrdssValidatorsExceptions();}return OrdssValidatorsExceptions;
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

   public Exception getEjeException(){
       return new Exception("Falta espeficiar Eje");
   }

   public Exception getFentException(){
       return new Exception("Falta espeficiar Fent");
   }

   public Exception getProvException(){
       return new Exception("Falta espeficiar Prov");
   }

   public Exception getProyException(){
       return new Exception("Falta espeficiar Proy");
   }

}