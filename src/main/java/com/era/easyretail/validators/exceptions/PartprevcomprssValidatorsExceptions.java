package com.era.easyretail.validators.exceptions;

public class PartprevcomprssValidatorsExceptions {

   private static PartprevcomprssValidatorsExceptions PartprevcomprssValidatorsExceptions;

   public static PartprevcomprssValidatorsExceptions getSigleton(){
       if(PartprevcomprssValidatorsExceptions==null){PartprevcomprssValidatorsExceptions = new PartprevcomprssValidatorsExceptions();}return PartprevcomprssValidatorsExceptions;
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

   public Exception getCodcomException(){
       return new Exception("Falta espeficiar Codcom");
   }

   public Exception getCodimpueException(){
       return new Exception("Falta espeficiar Codimpue");
   }

   public Exception getComenserException(){
       return new Exception("Falta espeficiar Comenser");
   }

   public Exception getDescripException(){
       return new Exception("Falta espeficiar Descrip");
   }

   public Exception getFlotvencException(){
       return new Exception("Falta espeficiar Flotvenc");
   }

   public Exception getGaranException(){
       return new Exception("Falta espeficiar Garan");
   }

   public Exception getMonException(){
       return new Exception("Falta espeficiar Mon");
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