package com.era.easyretail.validators.exceptions;

public class KitssValidatorsExceptions {

   private static KitssValidatorsExceptions KitssValidatorsExceptions;

   public static KitssValidatorsExceptions getSigleton(){
       if(KitssValidatorsExceptions==null){KitssValidatorsExceptions = new KitssValidatorsExceptions();}return KitssValidatorsExceptions;
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

   public Exception getAlmaException(){
       return new Exception("Falta espeficiar Alma");
   }

   public Exception getProdException(){
       return new Exception("Falta espeficiar Prod");
   }

}