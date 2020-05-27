package com.era.easyretail.validators.exceptions;

public class AsientosContablessValidatorsExceptions {

   private static AsientosContablessValidatorsExceptions AsientosContablessValidatorsExceptions;

   public static AsientosContablessValidatorsExceptions getSigleton(){
       if(AsientosContablessValidatorsExceptions==null){AsientosContablessValidatorsExceptions = new AsientosContablessValidatorsExceptions();}return AsientosContablessValidatorsExceptions;
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

   public Exception getDocumentoException(){
       return new Exception("Falta espeficiar Documento");
   }

   public Exception getFecha_altaException(){
       return new Exception("Falta espeficiar Fecha_alta");
   }

   public Exception getFecha_modificacionException(){
       return new Exception("Falta espeficiar Fecha_modificacion");
   }

   public Exception getFrecuenciaException(){
       return new Exception("Falta espeficiar Frecuencia");
   }

   public Exception getIdSerieException(){
       return new Exception("Falta espeficiar IdSerie");
   }

   public Exception getNombreException(){
       return new Exception("Falta espeficiar Nombre");
   }

   public Exception getTipoException(){
       return new Exception("Falta espeficiar Tipo");
   }

}