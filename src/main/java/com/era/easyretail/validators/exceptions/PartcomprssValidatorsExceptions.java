package com.era.easyretail.validators.exceptions;

public class PartcomprssValidatorsExceptions {

   private static PartcomprssValidatorsExceptions PartcomprssValidatorsExceptions;

   public static PartcomprssValidatorsExceptions getSigleton(){
       if(PartcomprssValidatorsExceptions==null){PartcomprssValidatorsExceptions = new PartcomprssValidatorsExceptions();}return PartcomprssValidatorsExceptions;
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

   public Exception getCantlotpendException(){
       return new Exception("Falta espeficiar Cantlotpend");
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

   public Exception getCostException(){
       return new Exception("Falta espeficiar Cost");
   }

   public Exception getCostproException(){
       return new Exception("Falta espeficiar Costpro");
   }

   public Exception getDescadException(){
       return new Exception("Falta espeficiar Descad");
   }

   public Exception getDescripException(){
       return new Exception("Falta espeficiar Descrip");
   }

   public Exception getDescuException(){
       return new Exception("Falta espeficiar Descu");
   }

   public Exception getFlotvencException(){
       return new Exception("Falta espeficiar Flotvenc");
   }

   public Exception getGaranException(){
       return new Exception("Falta espeficiar Garan");
   }

   public Exception getImpoException(){
       return new Exception("Falta espeficiar Impo");
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

   public Exception getTipcamException(){
       return new Exception("Falta espeficiar Tipcam");
   }

   public Exception getUnidException(){
       return new Exception("Falta espeficiar Unid");
   }

}