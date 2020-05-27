package com.era.easyretail.validators.exceptions;

public class PedidosPartssValidatorsExceptions {

   private static PedidosPartssValidatorsExceptions PedidosPartssValidatorsExceptions;

   public static PedidosPartssValidatorsExceptions getSigleton(){
       if(PedidosPartssValidatorsExceptions==null){PedidosPartssValidatorsExceptions = new PedidosPartssValidatorsExceptions();}return PedidosPartssValidatorsExceptions;
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

   public Exception getCodimpueException(){
       return new Exception("Falta espeficiar Codimpue");
   }

   public Exception getComenserException(){
       return new Exception("Falta espeficiar Comenser");
   }

   public Exception getDesc_1Exception(){
       return new Exception("Falta espeficiar Desc_1");
   }

   public Exception getDesc_2Exception(){
       return new Exception("Falta espeficiar Desc_2");
   }

   public Exception getDesc_3Exception(){
       return new Exception("Falta espeficiar Desc_3");
   }

   public Exception getDesc_4Exception(){
       return new Exception("Falta espeficiar Desc_4");
   }

   public Exception getDesc_5Exception(){
       return new Exception("Falta espeficiar Desc_5");
   }

   public Exception getDescripException(){
       return new Exception("Falta espeficiar Descrip");
   }

   public Exception getFcaduException(){
       return new Exception("Falta espeficiar Fcadu");
   }

   public Exception getImpoException(){
       return new Exception("Falta espeficiar Impo");
   }

   public Exception getImpo_2Exception(){
       return new Exception("Falta espeficiar Impo_2");
   }

   public Exception getImpueimpoException(){
       return new Exception("Falta espeficiar Impueimpo");
   }

   public Exception getImpueimpo_2Exception(){
       return new Exception("Falta espeficiar Impueimpo_2");
   }

   public Exception getImpuevalException(){
       return new Exception("Falta espeficiar Impueval");
   }

   public Exception getMonException(){
       return new Exception("Falta espeficiar Mon");
   }

   public Exception getPedidoIDException(){
       return new Exception("Falta espeficiar PedidoID");
   }

   public Exception getPreException(){
       return new Exception("Falta espeficiar Pre");
   }

   public Exception getPre_2Exception(){
       return new Exception("Falta espeficiar Pre_2");
   }

   public Exception getProdException(){
       return new Exception("Falta espeficiar Prod");
   }

   public Exception getRecibidasException(){
       return new Exception("Falta espeficiar Recibidas");
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