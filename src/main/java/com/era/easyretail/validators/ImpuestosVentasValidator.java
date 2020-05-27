package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.ImpuestosVentasValidatorsExceptions;
import com.era.models.ImpuestosVenta;
import com.era.repositories.RepositoryFactory;

public class ImpuestosVentasValidator extends IValidate{

   private String code;
   private String fvenc;
   private String impuesto;
   private String retencion;
   private String total;

   @Override
   public void validateInsert() throws Exception {

       if(fvenc==null || fvenc.isEmpty()){
           throw new ImpuestosVentasValidatorsExceptions().getFvencException();
       }

       if(impuesto==null || impuesto.isEmpty()){
           throw new ImpuestosVentasValidatorsExceptions().getImpuestoException();
       }

       if(retencion==null || retencion.isEmpty()){
           throw new ImpuestosVentasValidatorsExceptions().getRetencionException();
       }

       if(total==null || total.isEmpty()){
           throw new ImpuestosVentasValidatorsExceptions().getTotalException();
       }

       final ImpuestosVenta ImpuestosVenta = (ImpuestosVenta) RepositoryFactory.getInstance().getImpuestosVentasRepository().getByCode(code);
       if(ImpuestosVenta != null){            
           throw new ImpuestosVentasValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new ImpuestosVentasValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new ImpuestosVentasValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new ImpuestosVentasValidatorsExceptions().getCodeException();
       }

       final ImpuestosVenta ImpuestosVenta = (ImpuestosVenta) RepositoryFactory.getInstance().getImpuestosVentasRepository().getByCode(code);
       if(ImpuestosVenta == null){            
           throw new ImpuestosVentasValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new ImpuestosVentasValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}