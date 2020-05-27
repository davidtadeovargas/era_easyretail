package com.era.easyretail.validators.exceptions;

public class IngresosEncabsValidatorsExceptions {

   private static IngresosEncabsValidatorsExceptions IngresosEncabsValidatorsExceptions;

   public static IngresosEncabsValidatorsExceptions getSigleton(){
       if(IngresosEncabsValidatorsExceptions==null){IngresosEncabsValidatorsExceptions = new IngresosEncabsValidatorsExceptions();}return IngresosEncabsValidatorsExceptions;
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

   public Exception getCanttotalException(){
       return new Exception("Falta espeficiar Canttotal");
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

   public Exception getNoreferException(){
       return new Exception("Falta espeficiar Norefer");
   }

   public Exception getNoserException(){
       return new Exception("Falta espeficiar Noser");
   }

   public Exception getPedimentoException(){
       return new Exception("Falta espeficiar Pedimento");
   }

}