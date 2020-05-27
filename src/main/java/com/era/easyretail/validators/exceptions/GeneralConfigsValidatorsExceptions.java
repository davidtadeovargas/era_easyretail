package com.era.easyretail.validators.exceptions;

public class GeneralConfigsValidatorsExceptions {

   private static GeneralConfigsValidatorsExceptions GeneralConfigsValidatorsExceptions;

   public static GeneralConfigsValidatorsExceptions getSigleton(){
       if(GeneralConfigsValidatorsExceptions==null){GeneralConfigsValidatorsExceptions = new GeneralConfigsValidatorsExceptions();}return GeneralConfigsValidatorsExceptions;
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

   public Exception getCashNumberException(){
       return new Exception("Falta espeficiar CashNumber");
   }

   public Exception getCasificationException(){
       return new Exception("Falta espeficiar Casification");
   }

   public Exception getConfigurationException(){
       return new Exception("Falta espeficiar Configuration");
   }

   public Exception getExtraException(){
       return new Exception("Falta espeficiar Extra");
   }

   public Exception getNumextException(){
       return new Exception("Falta espeficiar Numext");
   }

   public Exception getStationException(){
       return new Exception("Falta espeficiar Station");
   }

   public Exception getSucursalException(){
       return new Exception("Falta espeficiar Sucursal");
   }

   public Exception getValueException(){
       return new Exception("Falta espeficiar Value");
   }

}