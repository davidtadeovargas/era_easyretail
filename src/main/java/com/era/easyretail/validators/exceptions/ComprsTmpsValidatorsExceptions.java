package com.era.easyretail.validators.exceptions;

public class ComprsTmpsValidatorsExceptions {

   private static ComprsTmpsValidatorsExceptions ComprsTmpsValidatorsExceptions;

   public static ComprsTmpsValidatorsExceptions getSigleton(){
       if(ComprsTmpsValidatorsExceptions==null){ComprsTmpsValidatorsExceptions = new ComprsTmpsValidatorsExceptions();}return ComprsTmpsValidatorsExceptions;
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

   public Exception getCodcompException(){
       return new Exception("Falta espeficiar Codcomp");
   }

   public Exception getEstadoException(){
       return new Exception("Falta espeficiar Estado");
   }

   public Exception getFvencException(){
       return new Exception("Falta espeficiar Fvenc");
   }

   public Exception getImpueException(){
       return new Exception("Falta espeficiar Impue");
   }

   public Exception getMonedaIDException(){
       return new Exception("Falta espeficiar MonedaID");
   }

   public Exception getMotivException(){
       return new Exception("Falta espeficiar Motiv");
   }

   public Exception getNodocException(){
       return new Exception("Falta espeficiar Nodoc");
   }

   public Exception getNomprovException(){
       return new Exception("Falta espeficiar Nomprov");
   }

   public Exception getNoserException(){
       return new Exception("Falta espeficiar Noser");
   }

   public Exception getProvException(){
       return new Exception("Falta espeficiar Prov");
   }

   public Exception getSerException(){
       return new Exception("Falta espeficiar Ser");
   }

   public Exception getSubtotException(){
       return new Exception("Falta espeficiar Subtot");
   }

   public Exception getTipcamException(){
       return new Exception("Falta espeficiar Tipcam");
   }

   public Exception getTipcamnacException(){
       return new Exception("Falta espeficiar Tipcamnac");
   }

   public Exception getTotException(){
       return new Exception("Falta espeficiar Tot");
   }

   public Exception getTotal_retencionException(){
       return new Exception("Falta espeficiar Total_retencion");
   }

   public Exception getTotal_trasladoException(){
       return new Exception("Falta espeficiar Total_traslado");
   }

}