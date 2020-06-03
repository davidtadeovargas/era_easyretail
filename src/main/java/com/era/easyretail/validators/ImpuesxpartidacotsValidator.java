package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.ImpuesxpartidacotsValidatorsExceptions;
import com.era.models.Impuesxpartidacot;
import com.era.repositories.RepositoryFactory;

public class ImpuesxpartidacotsValidator extends IValidate{

   private String codigoImpuesto;
   public void setCodigoImpuesto(String property){
       this.codigoImpuesto = property;
   }

   private String idPartida;
   public void setIdPartida(String property){
       this.idPartida = property;
   }

   private String idParts;
   public void setIdParts(String property){
       this.idParts = property;
   }

   private String ret_tras;
   public void setRet_tras(String property){
       this.ret_tras = property;
   }

   private String retencion;
   public void setRetencion(String property){
       this.retencion = property;
   }

   private String tasa;
   public void setTasa(String property){
       this.tasa = property;
   }

   private String total;
   public void setTotal(String property){
       this.total = property;
   }


   @Override
   public void validateInsert() throws Exception {

       if(codigoImpuesto==null || codigoImpuesto.isEmpty()){
           throw new ImpuesxpartidacotsValidatorsExceptions().getCodigoImpuestoException();
       }

       if(idPartida==null || idPartida.isEmpty()){
           throw new ImpuesxpartidacotsValidatorsExceptions().getIdPartidaException();
       }

       if(idParts==null || idParts.isEmpty()){
           throw new ImpuesxpartidacotsValidatorsExceptions().getIdPartsException();
       }

       if(ret_tras==null || ret_tras.isEmpty()){
           throw new ImpuesxpartidacotsValidatorsExceptions().getRet_trasException();
       }

       if(retencion==null || retencion.isEmpty()){
           throw new ImpuesxpartidacotsValidatorsExceptions().getRetencionException();
       }

       if(tasa==null || tasa.isEmpty()){
           throw new ImpuesxpartidacotsValidatorsExceptions().getTasaException();
       }

       if(total==null || total.isEmpty()){
           throw new ImpuesxpartidacotsValidatorsExceptions().getTotalException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new ImpuesxpartidacotsValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new ImpuesxpartidacotsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

}