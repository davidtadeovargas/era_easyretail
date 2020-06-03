package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.ImpuestosVentasValidatorsExceptions;
import com.era.models.ImpuestosVenta;
import com.era.repositories.RepositoryFactory;

public class ImpuestosVentasValidator extends IValidate{

   private String fvenc;
   public void setFvenc(String property){
       this.fvenc = property;
   }

   private String impuesto;
   public void setImpuesto(String property){
       this.impuesto = property;
   }

   private String retencion;
   public void setRetencion(String property){
       this.retencion = property;
   }

   private String total;
   public void setTotal(String property){
       this.total = property;
   }


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

}