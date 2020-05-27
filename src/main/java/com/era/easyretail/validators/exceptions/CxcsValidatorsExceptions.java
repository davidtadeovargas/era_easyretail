package com.era.easyretail.validators.exceptions;

public class CxcsValidatorsExceptions {

   private static CxcsValidatorsExceptions CxcsValidatorsExceptions;

   public static CxcsValidatorsExceptions getSigleton(){
       if(CxcsValidatorsExceptions==null){CxcsValidatorsExceptions = new CxcsValidatorsExceptions();}return CxcsValidatorsExceptions;
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

   public Exception getEmpreException(){
       return new Exception("Falta espeficiar Empre");
   }

   public Exception getFdocException(){
       return new Exception("Falta espeficiar Fdoc");
   }

   public Exception getId_ventaException(){
       return new Exception("Falta espeficiar Id_venta");
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

   public Exception getSerException(){
       return new Exception("Falta espeficiar Ser");
   }

   public Exception getSubtotException(){
       return new Exception("Falta espeficiar Subtot");
   }

   public Exception getTotException(){
       return new Exception("Falta espeficiar Tot");
   }

}