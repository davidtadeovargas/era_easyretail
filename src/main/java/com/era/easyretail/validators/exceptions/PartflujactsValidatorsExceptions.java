package com.era.easyretail.validators.exceptions;

public class PartflujactsValidatorsExceptions {

   private static PartflujactsValidatorsExceptions PartflujactsValidatorsExceptions;

   public static PartflujactsValidatorsExceptions getSigleton(){
       if(PartflujactsValidatorsExceptions==null){PartflujactsValidatorsExceptions = new PartflujactsValidatorsExceptions();}return PartflujactsValidatorsExceptions;
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

   public Exception getIdflujException(){
       return new Exception("Falta espeficiar Idfluj");
   }

   public Exception getSeguiException(){
       return new Exception("Falta espeficiar Segui");
   }

}