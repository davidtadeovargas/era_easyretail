package com.era.easyretail.validators.exceptions;

public class CortszxsValidatorsExceptions {

   private static CortszxsValidatorsExceptions CortszxsValidatorsExceptions;

   public static CortszxsValidatorsExceptions getSigleton(){
       if(CortszxsValidatorsExceptions==null){CortszxsValidatorsExceptions = new CortszxsValidatorsExceptions();}return CortszxsValidatorsExceptions;
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

   public Exception getCortException(){
       return new Exception("Falta espeficiar Cort");
   }

   public Exception getNumcortException(){
       return new Exception("Falta espeficiar Numcort");
   }

   public Exception getTotvtasException(){
       return new Exception("Falta espeficiar Totvtas");
   }

}