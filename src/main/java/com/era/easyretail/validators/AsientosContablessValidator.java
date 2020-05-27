package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.AsientosContablessValidatorsExceptions;
import com.era.models.AsientosContables;
import com.era.repositories.RepositoryFactory;

public class AsientosContablessValidator extends IValidate{

   private String code;
   private String concepto;
   private String documento;
   private String fecha_alta;
   private String fecha_modificacion;
   private String frecuencia;
   private String idSerie;
   private String nombre;
   private String tipo;

   @Override
   public void validateInsert() throws Exception {

       if(concepto==null || concepto.isEmpty()){
           throw new AsientosContablessValidatorsExceptions().getConceptoException();
       }

       if(documento==null || documento.isEmpty()){
           throw new AsientosContablessValidatorsExceptions().getDocumentoException();
       }

       if(fecha_alta==null || fecha_alta.isEmpty()){
           throw new AsientosContablessValidatorsExceptions().getFecha_altaException();
       }

       if(fecha_modificacion==null || fecha_modificacion.isEmpty()){
           throw new AsientosContablessValidatorsExceptions().getFecha_modificacionException();
       }

       if(frecuencia==null || frecuencia.isEmpty()){
           throw new AsientosContablessValidatorsExceptions().getFrecuenciaException();
       }

       if(idSerie==null || idSerie.isEmpty()){
           throw new AsientosContablessValidatorsExceptions().getIdSerieException();
       }

       if(nombre==null || nombre.isEmpty()){
           throw new AsientosContablessValidatorsExceptions().getNombreException();
       }

       if(tipo==null || tipo.isEmpty()){
           throw new AsientosContablessValidatorsExceptions().getTipoException();
       }

       final AsientosContables AsientosContables = (AsientosContables) RepositoryFactory.getInstance().getAsientosContablessRepository().getByCode(code);
       if(AsientosContables != null){            
           throw new AsientosContablessValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new AsientosContablessValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new AsientosContablessValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new AsientosContablessValidatorsExceptions().getCodeException();
       }

       final AsientosContables AsientosContables = (AsientosContables) RepositoryFactory.getInstance().getAsientosContablessRepository().getByCode(code);
       if(AsientosContables == null){            
           throw new AsientosContablessValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new AsientosContablessValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}