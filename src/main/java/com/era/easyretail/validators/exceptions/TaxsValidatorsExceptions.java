package com.era.easyretail.validators.exceptions;

public class TaxsValidatorsExceptions {

   private static TaxsValidatorsExceptions TaxsValidatorsExceptions;

   public static TaxsValidatorsExceptions getSigleton(){
       if(TaxsValidatorsExceptions==null){TaxsValidatorsExceptions = new TaxsValidatorsExceptions();}return TaxsValidatorsExceptions;
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