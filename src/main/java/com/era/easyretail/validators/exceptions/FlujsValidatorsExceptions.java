package com.era.easyretail.validators.exceptions;

public class FlujsValidatorsExceptions {

   private static FlujsValidatorsExceptions FlujsValidatorsExceptions;

   public static FlujsValidatorsExceptions getSigleton(){
       if(FlujsValidatorsExceptions==null){FlujsValidatorsExceptions = new FlujsValidatorsExceptions();}return FlujsValidatorsExceptions;
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

   public Exception getConcepException(){
       return new Exception("Falta espeficiar Concep");
   }

   public Exception getIng_egException(){
       return new Exception("Falta espeficiar Ing_eg");
   }

   public Exception getModdException(){
       return new Exception("Falta espeficiar Modd");
   }

   public Exception getMonException(){
       return new Exception("Falta espeficiar Mon");
   }

   public Exception getNcortzException(){
       return new Exception("Falta espeficiar Ncortz");
   }

   public Exception getNoreferException(){
       return new Exception("Falta espeficiar Norefer");
   }

   public Exception getTipdocException(){
       return new Exception("Falta espeficiar Tipdoc");
   }

   public Exception getVtaException(){
       return new Exception("Falta espeficiar Vta");
   }

}