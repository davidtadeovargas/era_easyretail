package com.era.easyretail.validators.exceptions;

public class CorreoTerminalsValidatorsExceptions {

   private static CorreoTerminalsValidatorsExceptions CorreoTerminalsValidatorsExceptions;

   public static CorreoTerminalsValidatorsExceptions getSigleton(){
       if(CorreoTerminalsValidatorsExceptions==null){CorreoTerminalsValidatorsExceptions = new CorreoTerminalsValidatorsExceptions();}return CorreoTerminalsValidatorsExceptions;
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

   public Exception getContraException(){
       return new Exception("Falta espeficiar Contra");
   }

   public Exception getCorreoException(){
       return new Exception("Falta espeficiar Correo");
   }

   public Exception getCorreoAException(){
       return new Exception("Falta espeficiar CorreoA");
   }

   public Exception getDireccionserverException(){
       return new Exception("Falta espeficiar Direccionserver");
   }

   public Exception getMuestracomoException(){
       return new Exception("Falta espeficiar Muestracomo");
   }

   public Exception getPuertoException(){
       return new Exception("Falta espeficiar Puerto");
   }

}