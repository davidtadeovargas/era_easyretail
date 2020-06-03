package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.DocumentosContabilizadossValidatorsExceptions;
import com.era.models.DocumentosContabilizados;
import com.era.repositories.RepositoryFactory;

public class DocumentosContabilizadossValidator extends IValidate{

   private String documento_id;
   public void setDocumento_id(String property){
       this.documento_id = property;
   }

   private String fecha_poliza;
   public void setFecha_poliza(String property){
       this.fecha_poliza = property;
   }

   private String folio;
   public void setFolio(String property){
       this.folio = property;
   }

   private String numero_poliza;
   public void setNumero_poliza(String property){
       this.numero_poliza = property;
   }

   private String serie;
   public void setSerie(String property){
       this.serie = property;
   }

   private String tipo_documento;
   public void setTipo_documento(String property){
       this.tipo_documento = property;
   }

   private String tipo_poliza;
   public void setTipo_poliza(String property){
       this.tipo_poliza = property;
   }


   @Override
   public void validateInsert() throws Exception {

       if(documento_id==null || documento_id.isEmpty()){
           throw new DocumentosContabilizadossValidatorsExceptions().getDocumento_idException();
       }

       if(fecha_poliza==null || fecha_poliza.isEmpty()){
           throw new DocumentosContabilizadossValidatorsExceptions().getFecha_polizaException();
       }

       if(folio==null || folio.isEmpty()){
           throw new DocumentosContabilizadossValidatorsExceptions().getFolioException();
       }

       if(numero_poliza==null || numero_poliza.isEmpty()){
           throw new DocumentosContabilizadossValidatorsExceptions().getNumero_polizaException();
       }

       if(serie==null || serie.isEmpty()){
           throw new DocumentosContabilizadossValidatorsExceptions().getSerieException();
       }

       if(tipo_documento==null || tipo_documento.isEmpty()){
           throw new DocumentosContabilizadossValidatorsExceptions().getTipo_documentoException();
       }

       if(tipo_poliza==null || tipo_poliza.isEmpty()){
           throw new DocumentosContabilizadossValidatorsExceptions().getTipo_polizaException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new DocumentosContabilizadossValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new DocumentosContabilizadossValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

}