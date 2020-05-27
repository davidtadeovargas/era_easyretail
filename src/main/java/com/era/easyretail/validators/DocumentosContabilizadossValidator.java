package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.DocumentosContabilizadossValidatorsExceptions;
import com.era.models.DocumentosContabilizados;
import com.era.repositories.RepositoryFactory;

public class DocumentosContabilizadossValidator extends IValidate{

   private String code;
   private String documento_id;
   private String fecha_poliza;
   private String folio;
   private String numero_poliza;
   private String serie;
   private String tipo_documento;
   private String tipo_poliza;

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

       final DocumentosContabilizados DocumentosContabilizados = (DocumentosContabilizados) RepositoryFactory.getInstance().getDocumentosContabilizadossRepository().getByCode(code);
       if(DocumentosContabilizados != null){            
           throw new DocumentosContabilizadossValidatorsExceptions().getModelExistsException();
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

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new DocumentosContabilizadossValidatorsExceptions().getCodeException();
       }

       final DocumentosContabilizados DocumentosContabilizados = (DocumentosContabilizados) RepositoryFactory.getInstance().getDocumentosContabilizadossRepository().getByCode(code);
       if(DocumentosContabilizados == null){            
           throw new DocumentosContabilizadossValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new DocumentosContabilizadossValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}