package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.AsientosContablessValidatorsExceptions;
import com.era.models.AsientosContables;
import com.era.repositories.RepositoryFactory;

public class AsientosContablessValidator extends IValidate{

   private String concepto;
   public void setConcepto(String property){
       this.concepto = property;
   }

   private String documento;
   public void setDocumento(String property){
       this.documento = property;
   }

   private String fecha_alta;
   public void setFecha_alta(String property){
       this.fecha_alta = property;
   }

   private String fecha_modificacion;
   public void setFecha_modificacion(String property){
       this.fecha_modificacion = property;
   }

   private String frecuencia;
   public void setFrecuencia(String property){
       this.frecuencia = property;
   }

   private String idSerie;
   public void setIdSerie(String property){
       this.idSerie = property;
   }

   private String nombre;
   public void setNombre(String property){
       this.nombre = property;
   }

   private String tipo;
   public void setTipo(String property){
       this.tipo = property;
   }


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

}