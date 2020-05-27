package com.era.easyretail.validators.exceptions;

public class CorrselecsValidatorsExceptions {

   private static CorrselecsValidatorsExceptions CorrselecsValidatorsExceptions;

   public static CorrselecsValidatorsExceptions getSigleton(){
       if(CorrselecsValidatorsExceptions==null){CorrselecsValidatorsExceptions = new CorrselecsValidatorsExceptions();}return CorrselecsValidatorsExceptions;
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

   public Exception getActslenlogException(){
       return new Exception("Falta espeficiar Actslenlog");
   }

   public Exception getAsuncontraException(){
       return new Exception("Falta espeficiar Asuncontra");
   }

   public Exception getAsuncotException(){
       return new Exception("Falta espeficiar Asuncot");
   }

   public Exception getAsunfacException(){
       return new Exception("Falta espeficiar Asunfac");
   }

   public Exception getAsunordException(){
       return new Exception("Falta espeficiar Asunord");
   }

   public Exception getAsunrec1Exception(){
       return new Exception("Falta espeficiar Asunrec1");
   }

   public Exception getAsunrec2Exception(){
       return new Exception("Falta espeficiar Asunrec2");
   }

   public Exception getAsunrec3Exception(){
       return new Exception("Falta espeficiar Asunrec3");
   }

   public Exception getCorralterException(){
       return new Exception("Falta espeficiar Corralter");
   }

   public Exception getCuerpcontraException(){
       return new Exception("Falta espeficiar Cuerpcontra");
   }

   public Exception getCuerpcotException(){
       return new Exception("Falta espeficiar Cuerpcot");
   }

   public Exception getCuerpfacException(){
       return new Exception("Falta espeficiar Cuerpfac");
   }

   public Exception getCuerpordException(){
       return new Exception("Falta espeficiar Cuerpord");
   }

   public Exception getCuerprec1Exception(){
       return new Exception("Falta espeficiar Cuerprec1");
   }

   public Exception getCuerprec2Exception(){
       return new Exception("Falta espeficiar Cuerprec2");
   }

   public Exception getCuerprec3Exception(){
       return new Exception("Falta espeficiar Cuerprec3");
   }

   public Exception getEstacgloException(){
       return new Exception("Falta espeficiar Estacglo");
   }

   public Exception getPassException(){
       return new Exception("Falta espeficiar Pass");
   }

   public Exception getPortsmtpException(){
       return new Exception("Falta espeficiar Portsmtp");
   }

   public Exception getSrvsmtpsalException(){
       return new Exception("Falta espeficiar Srvsmtpsal");
   }

   public Exception getUsrException(){
       return new Exception("Falta espeficiar Usr");
   }

}