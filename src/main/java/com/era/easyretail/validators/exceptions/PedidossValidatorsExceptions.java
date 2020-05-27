package com.era.easyretail.validators.exceptions;

public class PedidossValidatorsExceptions {

   private static PedidossValidatorsExceptions PedidossValidatorsExceptions;

   public static PedidossValidatorsExceptions getSigleton(){
       if(PedidossValidatorsExceptions==null){PedidossValidatorsExceptions = new PedidossValidatorsExceptions();}return PedidossValidatorsExceptions;
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

   public Exception getImpueException(){
       return new Exception("Falta espeficiar Impue");
   }

   public Exception getMonedaIDException(){
       return new Exception("Falta espeficiar MonedaID");
   }

   public Exception getNoserException(){
       return new Exception("Falta espeficiar Noser");
   }

   public Exception getObservException(){
       return new Exception("Falta espeficiar Observ");
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

   public Exception getTotcostException(){
       return new Exception("Falta espeficiar Totcost");
   }

   public Exception getTotdescuException(){
       return new Exception("Falta espeficiar Totdescu");
   }

}