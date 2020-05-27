package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.ImpuestosXVentasValidatorsExceptions;
import com.era.models.ImpuestosXVenta;
import com.era.repositories.RepositoryFactory;

public class ImpuestosXVentasValidator extends IValidate{

   private String code;
   private String fvenc;
   private String id_partida;
   private String impuesto;
   private String retencion;
   private String total;

   @Override
   public void validateInsert() throws Exception {

       if(fvenc==null || fvenc.isEmpty()){
           throw new ImpuestosXVentasValidatorsExceptions().getFvencException();
       }

       if(id_partida==null || id_partida.isEmpty()){
           throw new ImpuestosXVentasValidatorsExceptions().getId_partidaException();
       }

       if(impuesto==null || impuesto.isEmpty()){
           throw new ImpuestosXVentasValidatorsExceptions().getImpuestoException();
       }

       if(retencion==null || retencion.isEmpty()){
           throw new ImpuestosXVentasValidatorsExceptions().getRetencionException();
       }

       if(total==null || total.isEmpty()){
           throw new ImpuestosXVentasValidatorsExceptions().getTotalException();
       }

       final ImpuestosXVenta ImpuestosXVenta = (ImpuestosXVenta) RepositoryFactory.getInstance().getImpuestosXVentasRepository().getByCode(code);
       if(ImpuestosXVenta != null){            
           throw new ImpuestosXVentasValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new ImpuestosXVentasValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new ImpuestosXVentasValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new ImpuestosXVentasValidatorsExceptions().getCodeException();
       }

       final ImpuestosXVenta ImpuestosXVenta = (ImpuestosXVenta) RepositoryFactory.getInstance().getImpuestosXVentasRepository().getByCode(code);
       if(ImpuestosXVenta == null){            
           throw new ImpuestosXVentasValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new ImpuestosXVentasValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}