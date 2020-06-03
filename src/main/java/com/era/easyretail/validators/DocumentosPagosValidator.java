package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.DocumentosPagosValidatorsExceptions;
import com.era.models.DocumentosPago;
import com.era.repositories.RepositoryFactory;

public class DocumentosPagosValidator extends IValidate{

   private String cadenaOriginal;
   public void setCadenaOriginal(String property){
       this.cadenaOriginal = property;
   }

   private String certificadosat;
   public void setCertificadosat(String property){
       this.certificadosat = property;
   }

   private String color;
   public void setColor(String property){
       this.color = property;
   }

   private String fecha_alta;
   public void setFecha_alta(String property){
       this.fecha_alta = property;
   }

   private String lugarExpedicion;
   public void setLugarExpedicion(String property){
       this.lugarExpedicion = property;
   }

   private String regimenFiscal;
   public void setRegimenFiscal(String property){
       this.regimenFiscal = property;
   }

   private String selloDigital;
   public void setSelloDigital(String property){
       this.selloDigital = property;
   }

   private String selloSat;
   public void setSelloSat(String property){
       this.selloSat = property;
   }

   private String transactionid;
   public void setTransactionid(String property){
       this.transactionid = property;
   }

   private String uuid_fiscal;
   public void setUuid_fiscal(String property){
       this.uuid_fiscal = property;
   }


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

}