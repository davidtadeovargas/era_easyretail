package com.era.easyretail.validators.exceptions;

public class CumplesValidatorsExceptions {

   private static CumplesValidatorsExceptions CumplesValidatorsExceptions;

   public static CumplesValidatorsExceptions getSigleton(){
       if(CumplesValidatorsExceptions==null){CumplesValidatorsExceptions = new CumplesValidatorsExceptions();}return CumplesValidatorsExceptions;
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

   public Exception getAException(){
       return new Exception("Falta espeficiar A");
   }

   public Exception getCodempException(){
       return new Exception("Falta espeficiar Codemp");
   }

   public Exception getDeException(){
       return new Exception("Falta espeficiar De");
   }

   public Exception getEstadException(){
       return new Exception("Falta espeficiar Estad");
   }

   public Exception getFcumpleException(){
       return new Exception("Falta espeficiar Fcumple");
   }

   public Exception getFhoyException(){
       return new Exception("Falta espeficiar Fhoy");
   }

   public Exception getSerException(){
       return new Exception("Falta espeficiar Ser");
   }

   public Exception getUsuarioException(){
       return new Exception("Falta espeficiar Usuario");
   }

}