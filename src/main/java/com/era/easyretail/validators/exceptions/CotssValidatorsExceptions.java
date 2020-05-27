package com.era.easyretail.validators.exceptions;

public class CotssValidatorsExceptions {

   private static CotssValidatorsExceptions CotssValidatorsExceptions;

   public static CotssValidatorsExceptions getSigleton(){
       if(CotssValidatorsExceptions==null){CotssValidatorsExceptions = new CotssValidatorsExceptions();}return CotssValidatorsExceptions;
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

   public Exception getCodcotException(){
       return new Exception("Falta espeficiar Codcot");
   }

   public Exception getCodempException(){
       return new Exception("Falta espeficiar Codemp");
   }

   public Exception getDescripException(){
       return new Exception("Falta espeficiar Descrip");
   }

   public Exception getEstadException(){
       return new Exception("Falta espeficiar Estad");
   }

   public Exception getFdocException(){
       return new Exception("Falta espeficiar Fdoc");
   }

   public Exception getFentreException(){
       return new Exception("Falta espeficiar Fentre");
   }

   public Exception getFvencException(){
       return new Exception("Falta espeficiar Fvenc");
   }

   public Exception getMonException(){
       return new Exception("Falta espeficiar Mon");
   }

   public Exception getNoserException(){
       return new Exception("Falta espeficiar Noser");
   }

   public Exception getObservException(){
       return new Exception("Falta espeficiar Observ");
   }

   public Exception getProyException(){
       return new Exception("Falta espeficiar Proy");
   }

   public Exception getSerException(){
       return new Exception("Falta espeficiar Ser");
   }

   public Exception getSubtotgral2Exception(){
       return new Exception("Falta espeficiar Subtotgral2");
   }

   public Exception getSubtotmat2Exception(){
       return new Exception("Falta espeficiar Subtotmat2");
   }

}