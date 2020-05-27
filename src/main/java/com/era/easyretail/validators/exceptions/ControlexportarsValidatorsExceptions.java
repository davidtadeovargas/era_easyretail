package com.era.easyretail.validators.exceptions;

public class ControlexportarsValidatorsExceptions {

   private static ControlexportarsValidatorsExceptions ControlexportarsValidatorsExceptions;

   public static ControlexportarsValidatorsExceptions getSigleton(){
       if(ControlexportarsValidatorsExceptions==null){ControlexportarsValidatorsExceptions = new ControlexportarsValidatorsExceptions();}return ControlexportarsValidatorsExceptions;
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

   public Exception getId_ultimaVentaExpoException(){
       return new Exception("Falta espeficiar Id_ultimaVentaExpo");
   }

   public Exception getId_ultimapartidaExpoException(){
       return new Exception("Falta espeficiar Id_ultimapartidaExpo");
   }

   public Exception getTipoException(){
       return new Exception("Falta espeficiar Tipo");
   }

}