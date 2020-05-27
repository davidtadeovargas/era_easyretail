package com.era.easyretail.validators.exceptions;

public class CxpsValidatorsExceptions {

   private static CxpsValidatorsExceptions CxpsValidatorsExceptions;

   public static CxpsValidatorsExceptions getSigleton(){
       if(CxpsValidatorsExceptions==null){CxpsValidatorsExceptions = new CxpsValidatorsExceptions();}return CxpsValidatorsExceptions;
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

   public Exception getAbonException(){
       return new Exception("Falta espeficiar Abon");
   }

   public Exception getCargException(){
       return new Exception("Falta espeficiar Carg");
   }

   public Exception getFdocException(){
       return new Exception("Falta espeficiar Fdoc");
   }

   public Exception getImpueException(){
       return new Exception("Falta espeficiar Impue");
   }

   public Exception getMonedaIDException(){
       return new Exception("Falta espeficiar MonedaID");
   }

   public Exception getNoreferException(){
       return new Exception("Falta espeficiar Norefer");
   }

   public Exception getNoserException(){
       return new Exception("Falta espeficiar Noser");
   }

   public Exception getProvException(){
       return new Exception("Falta espeficiar Prov");
   }

   public Exception getSerException(){
       return new Exception("Falta espeficiar Ser");
   }

   public Exception getSubtotException(){
       return new Exception("Falta espeficiar Subtot");
   }

   public Exception getTipcamException(){
       return new Exception("Falta espeficiar Tipcam");
   }

   public Exception getTotException(){
       return new Exception("Falta espeficiar Tot");
   }

}