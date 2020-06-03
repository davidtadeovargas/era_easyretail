package com.era.easyretail.validators.exceptions;

public class SucursalsValidatorsExceptions {

   private static SucursalsValidatorsExceptions SucursalsValidatorsExceptions;

   public static SucursalsValidatorsExceptions getSigleton(){
       if(SucursalsValidatorsExceptions==null){SucursalsValidatorsExceptions = new SucursalsValidatorsExceptions();}return SucursalsValidatorsExceptions;
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

   public Exception getCodZonaException(){
       return new Exception("Falta espeficiar CodZona");
   }

   public Exception getDescripException(){
       return new Exception("Falta espeficiar Descrip");
   }

}