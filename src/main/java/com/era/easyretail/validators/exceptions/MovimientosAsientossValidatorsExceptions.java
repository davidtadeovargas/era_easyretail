package com.era.easyretail.validators.exceptions;

public class MovimientosAsientossValidatorsExceptions {

   private static MovimientosAsientossValidatorsExceptions MovimientosAsientossValidatorsExceptions;

   public static MovimientosAsientossValidatorsExceptions getSigleton(){
       if(MovimientosAsientossValidatorsExceptions==null){MovimientosAsientossValidatorsExceptions = new MovimientosAsientossValidatorsExceptions();}return MovimientosAsientossValidatorsExceptions;
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

   public Exception getConceptoException(){
       return new Exception("Falta espeficiar Concepto");
   }

   public Exception getCuentaException(){
       return new Exception("Falta espeficiar Cuenta");
   }

   public Exception getIdAsientoException(){
       return new Exception("Falta espeficiar IdAsiento");
   }

   public Exception getImporteException(){
       return new Exception("Falta espeficiar Importe");
   }

   public Exception getNumeroMovimientoException(){
       return new Exception("Falta espeficiar NumeroMovimiento");
   }

   public Exception getReferenciaException(){
       return new Exception("Falta espeficiar Referencia");
   }

   public Exception getSegmento_negocioException(){
       return new Exception("Falta espeficiar Segmento_negocio");
   }

   public Exception getTipoException(){
       return new Exception("Falta espeficiar Tipo");
   }

}