package com.era.easyretail.validators.exceptions;

public class DatoscpsValidatorsExceptions {

   private static DatoscpsValidatorsExceptions DatoscpsValidatorsExceptions;

   public static DatoscpsValidatorsExceptions getSigleton(){
       if(DatoscpsValidatorsExceptions==null){DatoscpsValidatorsExceptions = new DatoscpsValidatorsExceptions();}return DatoscpsValidatorsExceptions;
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

   public Exception getVtaException(){
       return new Exception("Falta espeficiar Vta");
   }

}