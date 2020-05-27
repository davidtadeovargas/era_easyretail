package com.era.easyretail.validators.exceptions;

public class PartcotsValidatorsExceptions {

   private static PartcotsValidatorsExceptions PartcotsValidatorsExceptions;

   public static PartcotsValidatorsExceptions getSigleton(){
       if(PartcotsValidatorsExceptions==null){PartcotsValidatorsExceptions = new PartcotsValidatorsExceptions();}return PartcotsValidatorsExceptions;
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

   public Exception getCantException(){
       return new Exception("Falta espeficiar Cant");
   }

   public Exception getCodcotException(){
       return new Exception("Falta espeficiar Codcot");
   }

   public Exception getCodimpueException(){
       return new Exception("Falta espeficiar Codimpue");
   }

   public Exception getComenserException(){
       return new Exception("Falta espeficiar Comenser");
   }

   public Exception getDesc1Exception(){
       return new Exception("Falta espeficiar Desc1");
   }

   public Exception getDesc2Exception(){
       return new Exception("Falta espeficiar Desc2");
   }

   public Exception getDesc3Exception(){
       return new Exception("Falta espeficiar Desc3");
   }

   public Exception getDesc4Exception(){
       return new Exception("Falta espeficiar Desc4");
   }

   public Exception getDesc5Exception(){
       return new Exception("Falta espeficiar Desc5");
   }

   public Exception getDescripException(){
       return new Exception("Falta espeficiar Descrip");
   }

   public Exception getFcaduException(){
       return new Exception("Falta espeficiar Fcadu");
   }

   public Exception getImpo2Exception(){
       return new Exception("Falta espeficiar Impo2");
   }

   public Exception getImpueimpo2Exception(){
       return new Exception("Falta espeficiar Impueimpo2");
   }

   public Exception getMonException(){
       return new Exception("Falta espeficiar Mon");
   }

   public Exception getPre2Exception(){
       return new Exception("Falta espeficiar Pre2");
   }

   public Exception getProdException(){
       return new Exception("Falta espeficiar Prod");
   }

   public Exception getSerprodException(){
       return new Exception("Falta espeficiar Serprod");
   }

   public Exception getUnidException(){
       return new Exception("Falta espeficiar Unid");
   }

}