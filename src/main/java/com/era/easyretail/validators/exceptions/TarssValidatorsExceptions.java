package com.era.easyretail.validators.exceptions;

public class TarssValidatorsExceptions {

   private static TarssValidatorsExceptions TarssValidatorsExceptions;

   public static TarssValidatorsExceptions getSigleton(){
       if(TarssValidatorsExceptions==null){TarssValidatorsExceptions = new TarssValidatorsExceptions();}return TarssValidatorsExceptions;
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

   public Exception getCliException(){
       return new Exception("Falta espeficiar Cli");
   }

   public Exception getExterException(){
       return new Exception("Falta espeficiar Exter");
   }

   public Exception getFacturException(){
       return new Exception("Falta espeficiar Factur");
   }

   public Exception getFactuyaException(){
       return new Exception("Falta espeficiar Factuya");
   }

   public Exception getFfactuException(){
       return new Exception("Falta espeficiar Ffactu");
   }

   public Exception getLocException(){
       return new Exception("Falta espeficiar Loc");
   }

   public Exception getPagException(){
       return new Exception("Falta espeficiar Pag");
   }

   public Exception getPrepagException(){
       return new Exception("Falta espeficiar Prepag");
   }

   public Exception getTarException(){
       return new Exception("Falta espeficiar Tar");
   }

}