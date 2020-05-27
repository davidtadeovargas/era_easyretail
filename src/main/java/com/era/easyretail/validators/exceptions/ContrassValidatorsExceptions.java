package com.era.easyretail.validators.exceptions;

public class ContrassValidatorsExceptions {

   private static ContrassValidatorsExceptions ContrassValidatorsExceptions;

   public static ContrassValidatorsExceptions getSigleton(){
       if(ContrassValidatorsExceptions==null){ContrassValidatorsExceptions = new ContrassValidatorsExceptions();}return ContrassValidatorsExceptions;
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

   public Exception getCompException(){
       return new Exception("Falta espeficiar Comp");
   }

   public Exception getId_idpException(){
       return new Exception("Falta espeficiar Id_idp");
   }

   public Exception getProvException(){
       return new Exception("Falta espeficiar Prov");
   }

   public Exception getResponException(){
       return new Exception("Falta espeficiar Respon");
   }

}