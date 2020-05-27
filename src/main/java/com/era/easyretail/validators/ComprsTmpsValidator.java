package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.ComprsTmpsValidatorsExceptions;
import com.era.models.ComprsTmp;
import com.era.repositories.RepositoryFactory;

public class ComprsTmpsValidator extends IValidate{

   private String code;
   private String codcomp;
   private String estado;
   private String fvenc;
   private String impue;
   private String monedaID;
   private String motiv;
   private String nodoc;
   private String nomprov;
   private String noser;
   private String prov;
   private String ser;
   private String subtot;
   private String tipcam;
   private String tipcamnac;
   private String tot;
   private String total_retencion;
   private String total_traslado;

   @Override
   public void validateInsert() throws Exception {

       if(codcomp==null || codcomp.isEmpty()){
           throw new ComprsTmpsValidatorsExceptions().getCodcompException();
       }

       if(estado==null || estado.isEmpty()){
           throw new ComprsTmpsValidatorsExceptions().getEstadoException();
       }

       if(fvenc==null || fvenc.isEmpty()){
           throw new ComprsTmpsValidatorsExceptions().getFvencException();
       }

       if(impue==null || impue.isEmpty()){
           throw new ComprsTmpsValidatorsExceptions().getImpueException();
       }

       if(monedaID==null || monedaID.isEmpty()){
           throw new ComprsTmpsValidatorsExceptions().getMonedaIDException();
       }

       if(motiv==null || motiv.isEmpty()){
           throw new ComprsTmpsValidatorsExceptions().getMotivException();
       }

       if(nodoc==null || nodoc.isEmpty()){
           throw new ComprsTmpsValidatorsExceptions().getNodocException();
       }

       if(nomprov==null || nomprov.isEmpty()){
           throw new ComprsTmpsValidatorsExceptions().getNomprovException();
       }

       if(noser==null || noser.isEmpty()){
           throw new ComprsTmpsValidatorsExceptions().getNoserException();
       }

       if(prov==null || prov.isEmpty()){
           throw new ComprsTmpsValidatorsExceptions().getProvException();
       }

       if(ser==null || ser.isEmpty()){
           throw new ComprsTmpsValidatorsExceptions().getSerException();
       }

       if(subtot==null || subtot.isEmpty()){
           throw new ComprsTmpsValidatorsExceptions().getSubtotException();
       }

       if(tipcam==null || tipcam.isEmpty()){
           throw new ComprsTmpsValidatorsExceptions().getTipcamException();
       }

       if(tipcamnac==null || tipcamnac.isEmpty()){
           throw new ComprsTmpsValidatorsExceptions().getTipcamnacException();
       }

       if(tot==null || tot.isEmpty()){
           throw new ComprsTmpsValidatorsExceptions().getTotException();
       }

       if(total_retencion==null || total_retencion.isEmpty()){
           throw new ComprsTmpsValidatorsExceptions().getTotal_retencionException();
       }

       if(total_traslado==null || total_traslado.isEmpty()){
           throw new ComprsTmpsValidatorsExceptions().getTotal_trasladoException();
       }

       final ComprsTmp ComprsTmp = (ComprsTmp) RepositoryFactory.getInstance().getComprsTmpsRepository().getByCode(code);
       if(ComprsTmp != null){            
           throw new ComprsTmpsValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new ComprsTmpsValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new ComprsTmpsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new ComprsTmpsValidatorsExceptions().getCodeException();
       }

       final ComprsTmp ComprsTmp = (ComprsTmp) RepositoryFactory.getInstance().getComprsTmpsRepository().getByCode(code);
       if(ComprsTmp == null){            
           throw new ComprsTmpsValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new ComprsTmpsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}