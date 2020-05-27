package com.era.easyretail.validators.exceptions;

public class DocumentosPagosValidatorsExceptions {

   private static DocumentosPagosValidatorsExceptions DocumentosPagosValidatorsExceptions;

   public static DocumentosPagosValidatorsExceptions getSigleton(){
       if(DocumentosPagosValidatorsExceptions==null){DocumentosPagosValidatorsExceptions = new DocumentosPagosValidatorsExceptions();}return DocumentosPagosValidatorsExceptions;
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

   public Exception getCadenaOriginalException(){
       return new Exception("Falta espeficiar CadenaOriginal");
   }

   public Exception getCertificadosatException(){
       return new Exception("Falta espeficiar Certificadosat");
   }

   public Exception getColorException(){
       return new Exception("Falta espeficiar Color");
   }

   public Exception getFecha_altaException(){
       return new Exception("Falta espeficiar Fecha_alta");
   }

   public Exception getLugarExpedicionException(){
       return new Exception("Falta espeficiar LugarExpedicion");
   }

   public Exception getRegimenFiscalException(){
       return new Exception("Falta espeficiar RegimenFiscal");
   }

   public Exception getSelloDigitalException(){
       return new Exception("Falta espeficiar SelloDigital");
   }

   public Exception getSelloSatException(){
       return new Exception("Falta espeficiar SelloSat");
   }

   public Exception getTransactionidException(){
       return new Exception("Falta espeficiar Transactionid");
   }

   public Exception getUuid_fiscalException(){
       return new Exception("Falta espeficiar Uuid_fiscal");
   }

}