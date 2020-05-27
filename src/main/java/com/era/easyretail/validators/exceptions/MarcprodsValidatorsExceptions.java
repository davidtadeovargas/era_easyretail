package com.era.easyretail.validators.exceptions;

public class MarcprodsValidatorsExceptions {

   private static MarcprodsValidatorsExceptions MarcprodsValidatorsExceptions;

   public static MarcprodsValidatorsExceptions getSigleton(){
       if(MarcprodsValidatorsExceptions==null){MarcprodsValidatorsExceptions = new MarcprodsValidatorsExceptions();}return MarcprodsValidatorsExceptions;
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

   public Exception getMarcException(){
       return new Exception("Falta espeficiar Marc");
   }

   public Exception getProdException(){
       return new Exception("Falta espeficiar Prod");
   }

}