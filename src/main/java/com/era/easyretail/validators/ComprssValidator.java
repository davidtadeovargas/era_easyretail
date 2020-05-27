package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.ComprssValidatorsExceptions;
import com.era.models.Comprs;
import com.era.repositories.RepositoryFactory;

public class ComprssValidator extends IValidate{

   private String code;
   private String codcomp;
   private String estado;
   private String fdoc;
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

       final Comprs Comprs = (Comprs) RepositoryFactory.getInstance().getComprssRepository().getByCode(code);
       if(Comprs != null){            
           throw new ComprssValidatorsExceptions().getModelExistsException();
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

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new ComprssValidatorsExceptions().getCodeException();
       }

       final Comprs Comprs = (Comprs) RepositoryFactory.getInstance().getComprssRepository().getByCode(code);
       if(Comprs == null){            
           throw new ComprssValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new ComprssValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}