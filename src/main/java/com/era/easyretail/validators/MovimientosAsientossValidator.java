package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.MovimientosAsientossValidatorsExceptions;
import com.era.models.MovimientosAsientos;
import com.era.repositories.RepositoryFactory;

public class MovimientosAsientossValidator extends IValidate{

   private String code;
   private String concepto;
   private String cuenta;
   private String idAsiento;
   private String importe;
   private String numeroMovimiento;
   private String referencia;
   private String segmento_negocio;
   private String tipo;

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

       final MovimientosAsientos MovimientosAsientos = (MovimientosAsientos) RepositoryFactory.getInstance().getMovimientosAsientossRepository().getByCode(code);
       if(MovimientosAsientos != null){            
           throw new MovimientosAsientossValidatorsExceptions().getModelExistsException();
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

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new MovimientosAsientossValidatorsExceptions().getCodeException();
       }

       final MovimientosAsientos MovimientosAsientos = (MovimientosAsientos) RepositoryFactory.getInstance().getMovimientosAsientossRepository().getByCode(code);
       if(MovimientosAsientos == null){            
           throw new MovimientosAsientossValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new MovimientosAsientossValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}