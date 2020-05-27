package com.era.easyretail.validators.exceptions;

public class EstadiscorsValidatorsExceptions {

   private static EstadiscorsValidatorsExceptions EstadiscorsValidatorsExceptions;

   public static EstadiscorsValidatorsExceptions getSigleton(){
       if(EstadiscorsValidatorsExceptions==null){EstadiscorsValidatorsExceptions = new EstadiscorsValidatorsExceptions();}return EstadiscorsValidatorsExceptions;
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

   public Exception getCorrException(){
       return new Exception("Falta espeficiar Corr");
   }

   public Exception getCorrdeException(){
       return new Exception("Falta espeficiar Corrde");
   }

   public Exception getEstadException(){
       return new Exception("Falta espeficiar Estad");
   }

   public Exception getMotivException(){
       return new Exception("Falta espeficiar Motiv");
   }

   public Exception getNodocException(){
       return new Exception("Falta espeficiar Nodoc");
   }

   public Exception getTipdocException(){
       return new Exception("Falta espeficiar Tipdoc");
   }

}