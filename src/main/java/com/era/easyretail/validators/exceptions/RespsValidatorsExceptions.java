package com.era.easyretail.validators.exceptions;

public class RespsValidatorsExceptions {

   private static RespsValidatorsExceptions RespsValidatorsExceptions;

   public static RespsValidatorsExceptions getSigleton(){
       if(RespsValidatorsExceptions==null){RespsValidatorsExceptions = new RespsValidatorsExceptions();}return RespsValidatorsExceptions;
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

   public Exception getEstacresException(){
       return new Exception("Falta espeficiar Estacres");
   }

   public Exception getHrsException(){
       return new Exception("Falta espeficiar Hrs");
   }

}