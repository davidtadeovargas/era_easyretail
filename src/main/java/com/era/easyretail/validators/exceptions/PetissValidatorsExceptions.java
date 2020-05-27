package com.era.easyretail.validators.exceptions;

public class PetissValidatorsExceptions {

   private static PetissValidatorsExceptions PetissValidatorsExceptions;

   public static PetissValidatorsExceptions getSigleton(){
       if(PetissValidatorsExceptions==null){PetissValidatorsExceptions = new PetissValidatorsExceptions();}return PetissValidatorsExceptions;
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

   public Exception getEstacdestinException(){
       return new Exception("Falta espeficiar Estacdestin");
   }

   public Exception getEstadException(){
       return new Exception("Falta espeficiar Estad");
   }

   public Exception getNomarchException(){
       return new Exception("Falta espeficiar Nomarch");
   }

   public Exception getPathException(){
       return new Exception("Falta espeficiar Path");
   }

   public Exception getValException(){
       return new Exception("Falta espeficiar Val");
   }

}