package com.era.easyretail.validators.exceptions;

public class CAduanasValidatorsExceptions {

   private static CAduanasValidatorsExceptions CAduanasValidatorsExceptions;

   public static CAduanasValidatorsExceptions getSigleton(){
       if(CAduanasValidatorsExceptions==null){CAduanasValidatorsExceptions = new CAduanasValidatorsExceptions();}return CAduanasValidatorsExceptions;
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

   public Exception getC_AduanaException(){
       return new Exception("Falta espeficiar C_Aduana");
   }

   public Exception getDescriptionException(){
       return new Exception("Falta espeficiar Description");
   }

}