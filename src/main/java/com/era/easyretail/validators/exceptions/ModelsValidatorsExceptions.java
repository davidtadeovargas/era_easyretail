package com.era.easyretail.validators.exceptions;

public class ModelsValidatorsExceptions {

   private static ModelsValidatorsExceptions ModelsValidatorsExceptions;

   public static ModelsValidatorsExceptions getSigleton(){
       if(ModelsValidatorsExceptions==null){ModelsValidatorsExceptions = new ModelsValidatorsExceptions();}return ModelsValidatorsExceptions;
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

   public Exception getDescripException(){
       return new Exception("Falta espeficiar Descrip");
   }

}