package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.PartprevcomprsTmpsValidatorsExceptions;
import com.era.models.PartprevcomprsTmp;
import com.era.repositories.RepositoryFactory;

public class PartprevcomprsTmpsValidator extends IValidate{

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
           throw new PartprevcomprsTmpsValidatorsExceptions().getAlmaException();
       }

       if(cant==null || cant.isEmpty()){
           throw new PartprevcomprsTmpsValidatorsExceptions().getCantException();
       }

       if(cantlotpend==null || cantlotpend.isEmpty()){
           throw new PartprevcomprsTmpsValidatorsExceptions().getCantlotpendException();
       }

       if(codcom==null || codcom.isEmpty()){
           throw new PartprevcomprsTmpsValidatorsExceptions().getCodcomException();
       }

       if(codimpue==null || codimpue.isEmpty()){
           throw new PartprevcomprsTmpsValidatorsExceptions().getCodimpueException();
       }

       if(comenser==null || comenser.isEmpty()){
           throw new PartprevcomprsTmpsValidatorsExceptions().getComenserException();
       }

       if(cost==null || cost.isEmpty()){
           throw new PartprevcomprsTmpsValidatorsExceptions().getCostException();
       }

       if(costpro==null || costpro.isEmpty()){
           throw new PartprevcomprsTmpsValidatorsExceptions().getCostproException();
       }

       if(descad==null || descad.isEmpty()){
           throw new PartprevcomprsTmpsValidatorsExceptions().getDescadException();
       }

       if(descrip==null || descrip.isEmpty()){
           throw new PartprevcomprsTmpsValidatorsExceptions().getDescripException();
       }

       if(descu==null || descu.isEmpty()){
           throw new PartprevcomprsTmpsValidatorsExceptions().getDescuException();
       }

       if(flotvenc==null || flotvenc.isEmpty()){
           throw new PartprevcomprsTmpsValidatorsExceptions().getFlotvencException();
       }

       if(garan==null || garan.isEmpty()){
           throw new PartprevcomprsTmpsValidatorsExceptions().getGaranException();
       }

       if(impo==null || impo.isEmpty()){
           throw new PartprevcomprsTmpsValidatorsExceptions().getImpoException();
       }

       if(mon==null || mon.isEmpty()){
           throw new PartprevcomprsTmpsValidatorsExceptions().getMonException();
       }

       if(prod==null || prod.isEmpty()){
           throw new PartprevcomprsTmpsValidatorsExceptions().getProdException();
       }

       if(serprod==null || serprod.isEmpty()){
           throw new PartprevcomprsTmpsValidatorsExceptions().getSerprodException();
       }

       if(tipcam==null || tipcam.isEmpty()){
           throw new PartprevcomprsTmpsValidatorsExceptions().getTipcamException();
       }

       if(unid==null || unid.isEmpty()){
           throw new PartprevcomprsTmpsValidatorsExceptions().getUnidException();
       }

       final PartprevcomprsTmp PartprevcomprsTmp = (PartprevcomprsTmp) RepositoryFactory.getInstance().getPartprevcomprsTmpsRepository().getByCode(code);
       if(PartprevcomprsTmp != null){            
           throw new PartprevcomprsTmpsValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new PartprevcomprsTmpsValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new PartprevcomprsTmpsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new PartprevcomprsTmpsValidatorsExceptions().getCodeException();
       }

       final PartprevcomprsTmp PartprevcomprsTmp = (PartprevcomprsTmp) RepositoryFactory.getInstance().getPartprevcomprsTmpsRepository().getByCode(code);
       if(PartprevcomprsTmp == null){            
           throw new PartprevcomprsTmpsValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new PartprevcomprsTmpsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}