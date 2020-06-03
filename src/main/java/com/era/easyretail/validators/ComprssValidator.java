package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.ComprssValidatorsExceptions;
import com.era.models.Comprs;
import com.era.repositories.RepositoryFactory;

public class ComprssValidator extends IValidate{

   private String codcomp;
   public void setCodcomp(String property){
       this.codcomp = property;
   }

   private String estado;
   public void setEstado(String property){
       this.estado = property;
   }

   private String fdoc;
   public void setFdoc(String property){
       this.fdoc = property;
   }

   private String fvenc;
   public void setFvenc(String property){
       this.fvenc = property;
   }

   private String impue;
   public void setImpue(String property){
       this.impue = property;
   }

   private String monedaID;
   public void setMonedaID(String property){
       this.monedaID = property;
   }

   private String motiv;
   public void setMotiv(String property){
       this.motiv = property;
   }

   private String nodoc;
   public void setNodoc(String property){
       this.nodoc = property;
   }

   private String nomprov;
   public void setNomprov(String property){
       this.nomprov = property;
   }

   private String noser;
   public void setNoser(String property){
       this.noser = property;
   }

   private String prov;
   public void setProv(String property){
       this.prov = property;
   }

   private String ser;
   public void setSer(String property){
       this.ser = property;
   }

   private String subtot;
   public void setSubtot(String property){
       this.subtot = property;
   }

   private String tipcam;
   public void setTipcam(String property){
       this.tipcam = property;
   }

   private String tipcamnac;
   public void setTipcamnac(String property){
       this.tipcamnac = property;
   }

   private String tot;
   public void setTot(String property){
       this.tot = property;
   }

   private String total_retencion;
   public void setTotal_retencion(String property){
       this.total_retencion = property;
   }

   private String total_traslado;
   public void setTotal_traslado(String property){
       this.total_traslado = property;
   }


   @Override
   public void validateInsert() throws Exception {

       if(codcomp==null || codcomp.isEmpty()){
           throw new ComprssValidatorsExceptions().getCodcompException();
       }

       if(estado==null || estado.isEmpty()){
           throw new ComprssValidatorsExceptions().getEstadoException();
       }

       if(fdoc==null || fdoc.isEmpty()){
           throw new ComprssValidatorsExceptions().getFdocException();
       }

       if(fvenc==null || fvenc.isEmpty()){
           throw new ComprssValidatorsExceptions().getFvencException();
       }

       if(impue==null || impue.isEmpty()){
           throw new ComprssValidatorsExceptions().getImpueException();
       }

       if(monedaID==null || monedaID.isEmpty()){
           throw new ComprssValidatorsExceptions().getMonedaIDException();
       }

       if(motiv==null || motiv.isEmpty()){
           throw new ComprssValidatorsExceptions().getMotivException();
       }

       if(nodoc==null || nodoc.isEmpty()){
           throw new ComprssValidatorsExceptions().getNodocException();
       }

       if(nomprov==null || nomprov.isEmpty()){
           throw new ComprssValidatorsExceptions().getNomprovException();
       }

       if(noser==null || noser.isEmpty()){
           throw new ComprssValidatorsExceptions().getNoserException();
       }

       if(prov==null || prov.isEmpty()){
           throw new ComprssValidatorsExceptions().getProvException();
       }

       if(ser==null || ser.isEmpty()){
           throw new ComprssValidatorsExceptions().getSerException();
       }

       if(subtot==null || subtot.isEmpty()){
           throw new ComprssValidatorsExceptions().getSubtotException();
       }

       if(tipcam==null || tipcam.isEmpty()){
           throw new ComprssValidatorsExceptions().getTipcamException();
       }

       if(tipcamnac==null || tipcamnac.isEmpty()){
           throw new ComprssValidatorsExceptions().getTipcamnacException();
       }

       if(tot==null || tot.isEmpty()){
           throw new ComprssValidatorsExceptions().getTotException();
       }

       if(total_retencion==null || total_retencion.isEmpty()){
           throw new ComprssValidatorsExceptions().getTotal_retencionException();
       }

       if(total_traslado==null || total_traslado.isEmpty()){
           throw new ComprssValidatorsExceptions().getTotal_trasladoException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new ComprssValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new ComprssValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

}