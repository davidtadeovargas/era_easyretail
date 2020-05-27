package com.era.easyretail.validators.exceptions;

public class WarehousesValidatorsExceptions {

   private static WarehousesValidatorsExceptions WarehousesValidatorsExceptions;

   public static WarehousesValidatorsExceptions getSigleton(){
       if(WarehousesValidatorsExceptions==null){WarehousesValidatorsExceptions = new WarehousesValidatorsExceptions();}return WarehousesValidatorsExceptions;
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

   public Exception getDescriptionException(){
       return new Exception("Falta espeficiar Description");
   }

   public Exception getResponsibleException(){
       return new Exception("Falta espeficiar Responsible");
   }

   public Exception getStationException(){
       return new Exception("Falta espeficiar Station");
   }

   public Exception getSucursalException(){
       return new Exception("Falta espeficiar Sucursal");
   }

}