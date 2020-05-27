package com.era.easyretail.validators.exceptions;

public class MaxminconfsValidatorsExceptions {

   private static MaxminconfsValidatorsExceptions MaxminconfsValidatorsExceptions;

   public static MaxminconfsValidatorsExceptions getSigleton(){
       if(MaxminconfsValidatorsExceptions==null){MaxminconfsValidatorsExceptions = new MaxminconfsValidatorsExceptions();}return MaxminconfsValidatorsExceptions;
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

   public Exception getEstacgloException(){
       return new Exception("Falta espeficiar Estacglo");
   }

   public Exception getHrsException(){
       return new Exception("Falta espeficiar Hrs");
   }

}