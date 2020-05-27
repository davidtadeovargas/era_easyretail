package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.PartcomprssValidatorsExceptions;
import com.era.models.Partcomprs;
import com.era.repositories.RepositoryFactory;

public class PartcomprssValidator extends IValidate{

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
           throw new PartcomprssValidatorsExceptions().getAlmaException();
       }

       if(cant==null || cant.isEmpty()){
           throw new PartcomprssValidatorsExceptions().getCantException();
       }

       if(cantlotpend==null || cantlotpend.isEmpty()){
           throw new PartcomprssValidatorsExceptions().getCantlotpendException();
       }

       if(codcom==null || codcom.isEmpty()){
           throw new PartcomprssValidatorsExceptions().getCodcomException();
       }

       if(codimpue==null || codimpue.isEmpty()){
           throw new PartcomprssValidatorsExceptions().getCodimpueException();
       }

       if(comenser==null || comenser.isEmpty()){
           throw new PartcomprssValidatorsExceptions().getComenserException();
       }

       if(cost==null || cost.isEmpty()){
           throw new PartcomprssValidatorsExceptions().getCostException();
       }

       if(costpro==null || costpro.isEmpty()){
           throw new PartcomprssValidatorsExceptions().getCostproException();
       }

       if(descad==null || descad.isEmpty()){
           throw new PartcomprssValidatorsExceptions().getDescadException();
       }

       if(descrip==null || descrip.isEmpty()){
           throw new PartcomprssValidatorsExceptions().getDescripException();
       }

       if(descu==null || descu.isEmpty()){
           throw new PartcomprssValidatorsExceptions().getDescuException();
       }

       if(flotvenc==null || flotvenc.isEmpty()){
           throw new PartcomprssValidatorsExceptions().getFlotvencException();
       }

       if(garan==null || garan.isEmpty()){
           throw new PartcomprssValidatorsExceptions().getGaranException();
       }

       if(impo==null || impo.isEmpty()){
           throw new PartcomprssValidatorsExceptions().getImpoException();
       }

       if(mon==null || mon.isEmpty()){
           throw new PartcomprssValidatorsExceptions().getMonException();
       }

       if(prod==null || prod.isEmpty()){
           throw new PartcomprssValidatorsExceptions().getProdException();
       }

       if(serprod==null || serprod.isEmpty()){
           throw new PartcomprssValidatorsExceptions().getSerprodException();
       }

       if(tipcam==null || tipcam.isEmpty()){
           throw new PartcomprssValidatorsExceptions().getTipcamException();
       }

       if(unid==null || unid.isEmpty()){
           throw new PartcomprssValidatorsExceptions().getUnidException();
       }

       final Partcomprs Partcomprs = (Partcomprs) RepositoryFactory.getInstance().getPartcomprssRepository().getByCode(code);
       if(Partcomprs != null){            
           throw new PartcomprssValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new PartcomprssValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new PartcomprssValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new PartcomprssValidatorsExceptions().getCodeException();
       }

       final Partcomprs Partcomprs = (Partcomprs) RepositoryFactory.getInstance().getPartcomprssRepository().getByCode(code);
       if(Partcomprs == null){            
           throw new PartcomprssValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new PartcomprssValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}