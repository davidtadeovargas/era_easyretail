package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.DocumentosPagosValidatorsExceptions;
import com.era.models.DocumentosPago;
import com.era.repositories.RepositoryFactory;

public class DocumentosPagosValidator extends IValidate{

   private String code;
   private String cadenaOriginal;
   private String certificadosat;
   private String color;
   private String fecha_alta;
   private String lugarExpedicion;
   private String regimenFiscal;
   private String selloDigital;
   private String selloSat;
   private String transactionid;
   private String uuid_fiscal;

   @Override
   public void validateInsert() throws Exception {

       if(cadenaOriginal==null || cadenaOriginal.isEmpty()){
           throw new DocumentosPagosValidatorsExceptions().getCadenaOriginalException();
       }

       if(certificadosat==null || certificadosat.isEmpty()){
           throw new DocumentosPagosValidatorsExceptions().getCertificadosatException();
       }

       if(color==null || color.isEmpty()){
           throw new DocumentosPagosValidatorsExceptions().getColorException();
       }

       if(fecha_alta==null || fecha_alta.isEmpty()){
           throw new DocumentosPagosValidatorsExceptions().getFecha_altaException();
       }

       if(lugarExpedicion==null || lugarExpedicion.isEmpty()){
           throw new DocumentosPagosValidatorsExceptions().getLugarExpedicionException();
       }

       if(regimenFiscal==null || regimenFiscal.isEmpty()){
           throw new DocumentosPagosValidatorsExceptions().getRegimenFiscalException();
       }

       if(selloDigital==null || selloDigital.isEmpty()){
           throw new DocumentosPagosValidatorsExceptions().getSelloDigitalException();
       }

       if(selloSat==null || selloSat.isEmpty()){
           throw new DocumentosPagosValidatorsExceptions().getSelloSatException();
       }

       if(transactionid==null || transactionid.isEmpty()){
           throw new DocumentosPagosValidatorsExceptions().getTransactionidException();
       }

       if(uuid_fiscal==null || uuid_fiscal.isEmpty()){
           throw new DocumentosPagosValidatorsExceptions().getUuid_fiscalException();
       }

       final DocumentosPago DocumentosPago = (DocumentosPago) RepositoryFactory.getInstance().getDocumentosPagosRepository().getByCode(code);
       if(DocumentosPago != null){            
           throw new DocumentosPagosValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new DocumentosPagosValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new DocumentosPagosValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new DocumentosPagosValidatorsExceptions().getCodeException();
       }

       final DocumentosPago DocumentosPago = (DocumentosPago) RepositoryFactory.getInstance().getDocumentosPagosRepository().getByCode(code);
       if(DocumentosPago == null){            
           throw new DocumentosPagosValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new DocumentosPagosValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}