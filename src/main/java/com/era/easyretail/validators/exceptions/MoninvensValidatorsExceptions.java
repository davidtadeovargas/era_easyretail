package com.era.easyretail.validators.exceptions;

public class MoninvensValidatorsExceptions {

   private static MoninvensValidatorsExceptions MoninvensValidatorsExceptions;

   public static MoninvensValidatorsExceptions getSigleton(){
       if(MoninvensValidatorsExceptions==null){MoninvensValidatorsExceptions = new MoninvensValidatorsExceptions();}return MoninvensValidatorsExceptions;
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

   public Exception getConcepException(){
       return new Exception("Falta espeficiar Concep");
   }

   public Exception getDescripException(){
       return new Exception("Falta espeficiar Descrip");
   }

   public Exception getEmpException(){
       return new Exception("Falta espeficiar Emp");
   }

   public Exception getEntsalException(){
       return new Exception("Falta espeficiar Entsal");
   }

   public Exception getNodocException(){
       return new Exception("Falta espeficiar Nodoc");
   }

   public Exception getNoserException(){
       return new Exception("Falta espeficiar Noser");
   }

   public Exception getProdException(){
       return new Exception("Falta espeficiar Prod");
   }

   public Exception getUnidException(){
       return new Exception("Falta espeficiar Unid");
   }

}