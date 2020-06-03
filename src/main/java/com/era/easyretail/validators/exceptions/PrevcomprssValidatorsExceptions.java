package com.era.easyretail.validators.exceptions;

public class PrevcomprssValidatorsExceptions {

   private static PrevcomprssValidatorsExceptions PrevcomprssValidatorsExceptions;

   public static PrevcomprssValidatorsExceptions getSigleton(){
       if(PrevcomprssValidatorsExceptions==null){PrevcomprssValidatorsExceptions = new PrevcomprssValidatorsExceptions();}return PrevcomprssValidatorsExceptions;
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

   public Exception getEstadoException(){
       return new Exception("Falta espeficiar Estado");
   }

   public Exception getFvencException(){
       return new Exception("Falta espeficiar Fvenc");
   }

   public Exception getMonException(){
       return new Exception("Falta espeficiar Mon");
   }

   public Exception getMotivException(){
       return new Exception("Falta espeficiar Motiv");
   }

   public Exception getNoserException(){
       return new Exception("Falta espeficiar Noser");
   }

   public Exception getNosercompException(){
       return new Exception("Falta espeficiar Nosercomp");
   }

   public Exception getProvException(){
       return new Exception("Falta espeficiar Prov");
   }

   public Exception getSerException(){
       return new Exception("Falta espeficiar Ser");
   }

}