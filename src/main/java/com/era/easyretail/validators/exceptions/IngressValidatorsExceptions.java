package com.era.easyretail.validators.exceptions;

public class IngressValidatorsExceptions {

   private static IngressValidatorsExceptions IngressValidatorsExceptions;

   public static IngressValidatorsExceptions getSigleton(){
       if(IngressValidatorsExceptions==null){IngressValidatorsExceptions = new IngressValidatorsExceptions();}return IngressValidatorsExceptions;
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

   public Exception getCaducidadException(){
       return new Exception("Falta espeficiar Caducidad");
   }

   public Exception getConcepException(){
       return new Exception("Falta espeficiar Concep");
   }

   public Exception getEntsalException(){
       return new Exception("Falta espeficiar Entsal");
   }

   public Exception getLoteException(){
       return new Exception("Falta espeficiar Lote");
   }

   public Exception getPedimentoException(){
       return new Exception("Falta espeficiar Pedimento");
   }

   public Exception getProdException(){
       return new Exception("Falta espeficiar Prod");
   }

   public Exception getTipcamnacException(){
       return new Exception("Falta espeficiar Tipcamnac");
   }

   public Exception getUnidException(){
       return new Exception("Falta espeficiar Unid");
   }

}