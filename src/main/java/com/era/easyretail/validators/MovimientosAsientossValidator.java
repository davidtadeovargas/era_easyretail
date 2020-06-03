package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.MovimientosAsientossValidatorsExceptions;
import com.era.models.MovimientosAsientos;
import com.era.repositories.RepositoryFactory;

public class MovimientosAsientossValidator extends IValidate{

   private String concepto;
   public void setConcepto(String property){
       this.concepto = property;
   }

   private String cuenta;
   public void setCuenta(String property){
       this.cuenta = property;
   }

   private String idAsiento;
   public void setIdAsiento(String property){
       this.idAsiento = property;
   }

   private String importe;
   public void setImporte(String property){
       this.importe = property;
   }

   private String numeroMovimiento;
   public void setNumeroMovimiento(String property){
       this.numeroMovimiento = property;
   }

   private String referencia;
   public void setReferencia(String property){
       this.referencia = property;
   }

   private String segmento_negocio;
   public void setSegmento_negocio(String property){
       this.segmento_negocio = property;
   }

   private String tipo;
   public void setTipo(String property){
       this.tipo = property;
   }


   @Override
   public void validateInsert() throws Exception {

       if(concepto==null || concepto.isEmpty()){
           throw new MovimientosAsientossValidatorsExceptions().getConceptoException();
       }

       if(cuenta==null || cuenta.isEmpty()){
           throw new MovimientosAsientossValidatorsExceptions().getCuentaException();
       }

       if(idAsiento==null || idAsiento.isEmpty()){
           throw new MovimientosAsientossValidatorsExceptions().getIdAsientoException();
       }

       if(importe==null || importe.isEmpty()){
           throw new MovimientosAsientossValidatorsExceptions().getImporteException();
       }

       if(numeroMovimiento==null || numeroMovimiento.isEmpty()){
           throw new MovimientosAsientossValidatorsExceptions().getNumeroMovimientoException();
       }

       if(referencia==null || referencia.isEmpty()){
           throw new MovimientosAsientossValidatorsExceptions().getReferenciaException();
       }

       if(segmento_negocio==null || segmento_negocio.isEmpty()){
           throw new MovimientosAsientossValidatorsExceptions().getSegmento_negocioException();
       }

       if(tipo==null || tipo.isEmpty()){
           throw new MovimientosAsientossValidatorsExceptions().getTipoException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new MovimientosAsientossValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new MovimientosAsientossValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

}