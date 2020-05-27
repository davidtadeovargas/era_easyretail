package com.era.easyretail.validators.exceptions;

public class SubramossValidatorsExceptions {

   private static SubramossValidatorsExceptions SubramossValidatorsExceptions;

   public static SubramossValidatorsExceptions getSigleton(){
       if(SubramossValidatorsExceptions==null){SubramossValidatorsExceptions = new SubramossValidatorsExceptions();}return SubramossValidatorsExceptions;
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

   public Exception getCodigoException(){
       return new Exception("Falta espeficiar Codigo");
   }

   public Exception getDescripcionException(){
       return new Exception("Falta espeficiar Descripcion");
   }

}