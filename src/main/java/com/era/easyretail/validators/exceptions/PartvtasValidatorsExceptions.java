package com.era.easyretail.validators.exceptions;

public class PartvtasValidatorsExceptions {

   private static PartvtasValidatorsExceptions PartvtasValidatorsExceptions;

   public static PartvtasValidatorsExceptions getSigleton(){
       if(PartvtasValidatorsExceptions==null){PartvtasValidatorsExceptions = new PartvtasValidatorsExceptions();}return PartvtasValidatorsExceptions;
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

   public Exception getActivoException(){
       return new Exception("Falta espeficiar Activo");
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

   public Exception getDescripException(){
       return new Exception("Falta espeficiar Descrip");
   }

   public Exception getDescripcionOpcionalException(){
       return new Exception("Falta espeficiar DescripcionOpcional");
   }

   public Exception getDescuException(){
       return new Exception("Falta espeficiar Descu");
   }

   public Exception getFcaduException(){
       return new Exception("Falta espeficiar Fcadu");
   }

   public Exception getFentreException(){
       return new Exception("Falta espeficiar Fentre");
   }

   public Exception getImpoException(){
       return new Exception("Falta espeficiar Impo");
   }

   public Exception getImpueException(){
       return new Exception("Falta espeficiar Impue");
   }

   public Exception getMonException(){
       return new Exception("Falta espeficiar Mon");
   }

   public Exception getMonedaIDException(){
       return new Exception("Falta espeficiar MonedaID");
   }

   public Exception getPartidaIdOriginalException(){
       return new Exception("Falta espeficiar PartidaIdOriginal");
   }

   public Exception getPepsException(){
       return new Exception("Falta espeficiar Peps");
   }

   public Exception getPreException(){
       return new Exception("Falta espeficiar Pre");
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

   public Exception getTipdocException(){
       return new Exception("Falta espeficiar Tipdoc");
   }

   public Exception getUepsException(){
       return new Exception("Falta espeficiar Ueps");
   }

   public Exception getUnidException(){
       return new Exception("Falta espeficiar Unid");
   }

   public Exception getVtaException(){
       return new Exception("Falta espeficiar Vta");
   }

}