package com.era.easyretail.validators.exceptions;

public class TallcolosValidatorsExceptions {

   private static TallcolosValidatorsExceptions TallcolosValidatorsExceptions;

   public static TallcolosValidatorsExceptions getSigleton(){
       if(TallcolosValidatorsExceptions==null){TallcolosValidatorsExceptions = new TallcolosValidatorsExceptions();}return TallcolosValidatorsExceptions;
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

   public Exception getAlmaException(){
       return new Exception("Falta espeficiar Alma");
   }

   public Exception getColoException(){
       return new Exception("Falta espeficiar Colo");
   }

   public Exception getProdException(){
       return new Exception("Falta espeficiar Prod");
   }

   public Exception getTallException(){
       return new Exception("Falta espeficiar Tall");
   }

}