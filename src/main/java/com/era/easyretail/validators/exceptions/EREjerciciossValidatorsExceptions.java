package com.era.easyretail.validators.exceptions;

public class EREjerciciossValidatorsExceptions {

   private static EREjerciciossValidatorsExceptions EREjerciciossValidatorsExceptions;

   public static EREjerciciossValidatorsExceptions getSigleton(){
       if(EREjerciciossValidatorsExceptions==null){EREjerciciossValidatorsExceptions = new EREjerciciossValidatorsExceptions();}return EREjerciciossValidatorsExceptions;
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

   public Exception getEjercicioException(){
       return new Exception("Falta espeficiar Ejercicio");
   }

   public Exception getFechaInicioException(){
       return new Exception("Falta espeficiar FechaInicio");
   }

}