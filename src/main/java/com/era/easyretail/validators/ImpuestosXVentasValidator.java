package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.ImpuestosXVentasValidatorsExceptions;
import com.era.models.ImpuestosXVenta;
import com.era.repositories.RepositoryFactory;

public class ImpuestosXVentasValidator extends IValidate{

   private String fvenc;
   public void setFvenc(String property){
       this.fvenc = property;
   }

   private String id_partida;
   public void setId_partida(String property){
       this.id_partida = property;
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

}