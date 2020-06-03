package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.ImpuesxpartidapedsValidatorsExceptions;
import com.era.models.Impuesxpartidaped;
import com.era.repositories.RepositoryFactory;

public class ImpuesxpartidapedsValidator extends IValidate{

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
           throw new ImpuesxpartidapedsValidatorsExceptions().getCodigoImpuestoException();
       }

       if(idPartida==null || idPartida.isEmpty()){
           throw new ImpuesxpartidapedsValidatorsExceptions().getIdPartidaException();
       }

       if(idParts==null || idParts.isEmpty()){
           throw new ImpuesxpartidapedsValidatorsExceptions().getIdPartsException();
       }

       if(ret_tras==null || ret_tras.isEmpty()){
           throw new ImpuesxpartidapedsValidatorsExceptions().getRet_trasException();
       }

       if(retencion==null || retencion.isEmpty()){
           throw new ImpuesxpartidapedsValidatorsExceptions().getRetencionException();
       }

       if(tasa==null || tasa.isEmpty()){
           throw new ImpuesxpartidapedsValidatorsExceptions().getTasaException();
       }

       if(total==null || total.isEmpty()){
           throw new ImpuesxpartidapedsValidatorsExceptions().getTotalException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new ImpuesxpartidapedsValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new ImpuesxpartidapedsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

}