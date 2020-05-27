package com.era.easyretail.validators.exceptions;

public class DeliverAddressCustomersValidatorsExceptions {

   private static DeliverAddressCustomersValidatorsExceptions DeliverAddressCustomersValidatorsExceptions;

   public static DeliverAddressCustomersValidatorsExceptions getSigleton(){
       if(DeliverAddressCustomersValidatorsExceptions==null){DeliverAddressCustomersValidatorsExceptions = new DeliverAddressCustomersValidatorsExceptions();}return DeliverAddressCustomersValidatorsExceptions;
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

   public Exception getCustomerCodeException(){
       return new Exception("Falta espeficiar CustomerCode");
   }

   public Exception getStationException(){
       return new Exception("Falta espeficiar Station");
   }

   public Exception getSucursalException(){
       return new Exception("Falta espeficiar Sucursal");
   }

}