package com.era.easyretail.validators.exceptions;

public class DocumentosContabilizadossValidatorsExceptions {

   private static DocumentosContabilizadossValidatorsExceptions DocumentosContabilizadossValidatorsExceptions;

   public static DocumentosContabilizadossValidatorsExceptions getSigleton(){
       if(DocumentosContabilizadossValidatorsExceptions==null){DocumentosContabilizadossValidatorsExceptions = new DocumentosContabilizadossValidatorsExceptions();}return DocumentosContabilizadossValidatorsExceptions;
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

   public Exception getDocumento_idException(){
       return new Exception("Falta espeficiar Documento_id");
   }

   public Exception getFecha_polizaException(){
       return new Exception("Falta espeficiar Fecha_poliza");
   }

   public Exception getFolioException(){
       return new Exception("Falta espeficiar Folio");
   }

   public Exception getNumero_polizaException(){
       return new Exception("Falta espeficiar Numero_poliza");
   }

   public Exception getSerieException(){
       return new Exception("Falta espeficiar Serie");
   }

   public Exception getTipo_documentoException(){
       return new Exception("Falta espeficiar Tipo_documento");
   }

   public Exception getTipo_polizaException(){
       return new Exception("Falta espeficiar Tipo_poliza");
   }

}