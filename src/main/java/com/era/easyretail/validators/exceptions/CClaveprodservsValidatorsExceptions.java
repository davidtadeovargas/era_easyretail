package com.era.easyretail.validators.exceptions;

public class CClaveprodservsValidatorsExceptions {

   private static CClaveprodservsValidatorsExceptions CClaveprodservsValidatorsExceptions;

   public static CClaveprodservsValidatorsExceptions getSigleton(){
       if(CClaveprodservsValidatorsExceptions==null){CClaveprodservsValidatorsExceptions = new CClaveprodservsValidatorsExceptions();}return CClaveprodservsValidatorsExceptions;
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

   public Exception getC_ClaveProdServException(){
       return new Exception("Falta espeficiar C_ClaveProdServ");
   }

   public Exception getDescriptionException(){
       return new Exception("Falta espeficiar Description");
   }

}