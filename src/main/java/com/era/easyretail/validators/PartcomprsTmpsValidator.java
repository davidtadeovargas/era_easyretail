package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.PartcomprsTmpsValidatorsExceptions;
import com.era.models.PartcomprsTmp;
import com.era.repositories.RepositoryFactory;

public class PartcomprsTmpsValidator extends IValidate{

   private String code;
   private String alma;
   private String cant;
   private String cantlotpend;
   private String codcom;
   private String codimpue;
   private String comenser;
   private String cost;
   private String costpro;
   private String descad;
   private String descrip;
   private String descu;
   private String flotvenc;
   private String garan;
   private String impo;
   private String mon;
   private String prod;
   private String serprod;
   private String tipcam;
   private String unid;

   @Override
   public void validateInsert() throws Exception {

       if(alma==null || alma.isEmpty()){
           throw new PartcomprsTmpsValidatorsExceptions().getAlmaException();
       }

       if(cant==null || cant.isEmpty()){
           throw new PartcomprsTmpsValidatorsExceptions().getCantException();
       }

       if(cantlotpend==null || cantlotpend.isEmpty()){
           throw new PartcomprsTmpsValidatorsExceptions().getCantlotpendException();
       }

       if(codcom==null || codcom.isEmpty()){
           throw new PartcomprsTmpsValidatorsExceptions().getCodcomException();
       }

       if(codimpue==null || codimpue.isEmpty()){
           throw new PartcomprsTmpsValidatorsExceptions().getCodimpueException();
       }

       if(comenser==null || comenser.isEmpty()){
           throw new PartcomprsTmpsValidatorsExceptions().getComenserException();
       }

       if(cost==null || cost.isEmpty()){
           throw new PartcomprsTmpsValidatorsExceptions().getCostException();
       }

       if(costpro==null || costpro.isEmpty()){
           throw new PartcomprsTmpsValidatorsExceptions().getCostproException();
       }

       if(descad==null || descad.isEmpty()){
           throw new PartcomprsTmpsValidatorsExceptions().getDescadException();
       }

       if(descrip==null || descrip.isEmpty()){
           throw new PartcomprsTmpsValidatorsExceptions().getDescripException();
       }

       if(descu==null || descu.isEmpty()){
           throw new PartcomprsTmpsValidatorsExceptions().getDescuException();
       }

       if(flotvenc==null || flotvenc.isEmpty()){
           throw new PartcomprsTmpsValidatorsExceptions().getFlotvencException();
       }

       if(garan==null || garan.isEmpty()){
           throw new PartcomprsTmpsValidatorsExceptions().getGaranException();
       }

       if(impo==null || impo.isEmpty()){
           throw new PartcomprsTmpsValidatorsExceptions().getImpoException();
       }

       if(mon==null || mon.isEmpty()){
           throw new PartcomprsTmpsValidatorsExceptions().getMonException();
       }

       if(prod==null || prod.isEmpty()){
           throw new PartcomprsTmpsValidatorsExceptions().getProdException();
       }

       if(serprod==null || serprod.isEmpty()){
           throw new PartcomprsTmpsValidatorsExceptions().getSerprodException();
       }

       if(tipcam==null || tipcam.isEmpty()){
           throw new PartcomprsTmpsValidatorsExceptions().getTipcamException();
       }

       if(unid==null || unid.isEmpty()){
           throw new PartcomprsTmpsValidatorsExceptions().getUnidException();
       }

       final PartcomprsTmp PartcomprsTmp = (PartcomprsTmp) RepositoryFactory.getInstance().getPartcomprsTmpsRepository().getByCode(code);
       if(PartcomprsTmp != null){            
           throw new PartcomprsTmpsValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new PartcomprsTmpsValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new PartcomprsTmpsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new PartcomprsTmpsValidatorsExceptions().getCodeException();
       }

       final PartcomprsTmp PartcomprsTmp = (PartcomprsTmp) RepositoryFactory.getInstance().getPartcomprsTmpsRepository().getByCode(code);
       if(PartcomprsTmp == null){            
           throw new PartcomprsTmpsValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new PartcomprsTmpsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}