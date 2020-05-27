package com.era.easyretail.validators.exceptions;

public class ActfijsValidatorsExceptions {

   private static ActfijsValidatorsExceptions ActfijsValidatorsExceptions;

   public static ActfijsValidatorsExceptions getSigleton(){
       if(ActfijsValidatorsExceptions==null){ActfijsValidatorsExceptions = new ActfijsValidatorsExceptions();}return ActfijsValidatorsExceptions;
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

   public Exception getCtadeduException(){
       return new Exception("Falta espeficiar Ctadedu");
   }

   public Exception getCtadepreException(){
       return new Exception("Falta espeficiar Ctadepre");
   }

   public Exception getCtagastException(){
       return new Exception("Falta espeficiar Ctagast");
   }

   public Exception getDescripException(){
       return new Exception("Falta espeficiar Descrip");
   }

   public Exception getEstadusrException(){
       return new Exception("Falta espeficiar Estadusr");
   }

   public Exception getFadquisrealException(){
       return new Exception("Falta espeficiar Fadquisreal");
   }

   public Exception getFadquisusrException(){
       return new Exception("Falta espeficiar Fadquisusr");
   }

   public Exception getFbajException(){
       return new Exception("Falta espeficiar Fbaj");
   }

   public Exception getFbajdepException(){
       return new Exception("Falta espeficiar Fbajdep");
   }

   public Exception getFfindepException(){
       return new Exception("Falta espeficiar Ffindep");
   }

   public Exception getFinidepException(){
       return new Exception("Falta espeficiar Finidep");
   }

   public Exception getProdException(){
       return new Exception("Falta espeficiar Prod");
   }

   public Exception getTipactException(){
       return new Exception("Falta espeficiar Tipact");
   }

}