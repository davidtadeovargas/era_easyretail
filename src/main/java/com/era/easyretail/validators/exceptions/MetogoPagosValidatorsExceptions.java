package com.era.easyretail.validators.exceptions;

public class MetogoPagosValidatorsExceptions {

   private static MetogoPagosValidatorsExceptions MetogoPagosValidatorsExceptions;

   public static MetogoPagosValidatorsExceptions getSigleton(){
       if(MetogoPagosValidatorsExceptions==null){MetogoPagosValidatorsExceptions = new MetogoPagosValidatorsExceptions();}return MetogoPagosValidatorsExceptions;
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

   public Exception getChasNumberException(){
       return new Exception("Falta espeficiar ChasNumber");
   }

   public Exception getDescriptionException(){
       return new Exception("Falta espeficiar Description");
   }

   public Exception getStationException(){
       return new Exception("Falta espeficiar Station");
   }

   public Exception getSucursalException(){
       return new Exception("Falta espeficiar Sucursal");
   }

}