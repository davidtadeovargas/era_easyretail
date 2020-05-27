package com.era.easyretail.validators.exceptions;

public class PerssValidatorsExceptions {

   private static PerssValidatorsExceptions PerssValidatorsExceptions;

   public static PerssValidatorsExceptions getSigleton(){
       if(PerssValidatorsExceptions==null){PerssValidatorsExceptions = new PerssValidatorsExceptions();}return PerssValidatorsExceptions;
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

   public Exception getFingempException(){
       return new Exception("Falta espeficiar Fingemp");
   }

   public Exception getFsalempException(){
       return new Exception("Falta espeficiar Fsalemp");
   }

   public Exception getNomException(){
       return new Exception("Falta espeficiar Nom");
   }

}