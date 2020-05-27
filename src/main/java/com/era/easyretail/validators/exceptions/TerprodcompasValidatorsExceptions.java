package com.era.easyretail.validators.exceptions;

public class TerprodcompasValidatorsExceptions {

   private static TerprodcompasValidatorsExceptions TerprodcompasValidatorsExceptions;

   public static TerprodcompasValidatorsExceptions getSigleton(){
       if(TerprodcompasValidatorsExceptions==null){TerprodcompasValidatorsExceptions = new TerprodcompasValidatorsExceptions();}return TerprodcompasValidatorsExceptions;
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

   public Exception getMarcException(){
       return new Exception("Falta espeficiar Marc");
   }

   public Exception getModelException(){
       return new Exception("Falta espeficiar Model");
   }

   public Exception getProdException(){
       return new Exception("Falta espeficiar Prod");
   }

   public Exception getRutException(){
       return new Exception("Falta espeficiar Rut");
   }

}