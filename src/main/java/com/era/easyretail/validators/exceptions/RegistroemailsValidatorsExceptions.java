package com.era.easyretail.validators.exceptions;

public class RegistroemailsValidatorsExceptions {

   private static RegistroemailsValidatorsExceptions RegistroemailsValidatorsExceptions;

   public static RegistroemailsValidatorsExceptions getSigleton(){
       if(RegistroemailsValidatorsExceptions==null){RegistroemailsValidatorsExceptions = new RegistroemailsValidatorsExceptions();}return RegistroemailsValidatorsExceptions;
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

   public Exception getCambiada_fechaException(){
       return new Exception("Falta espeficiar Cambiada_fecha");
   }

   public Exception getContraException(){
       return new Exception("Falta espeficiar Contra");
   }

   public Exception getCorreoException(){
       return new Exception("Falta espeficiar Correo");
   }

   public Exception getGenerada_fechaException(){
       return new Exception("Falta espeficiar Generada_fecha");
   }

   public Exception getYa_entro_booleanoException(){
       return new Exception("Falta espeficiar Ya_entro_booleano");
   }

}