package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.PartprevcomprssValidatorsExceptions;
import com.era.models.Partprevcomprs;
import com.era.repositories.RepositoryFactory;

public class PartprevcomprssValidator extends IValidate{

   private String code;
   private String alma;
   private String cant;
   private String codcom;
   private String codimpue;
   private String comenser;
   private String descrip;
   private String flotvenc;
   private String garan;
   private String mon;
   private String prod;
   private String serprod;
   private String unid;

   @Override
   public void validateInsert() throws Exception {

       if(alma==null || alma.isEmpty()){
           throw new PartprevcomprssValidatorsExceptions().getAlmaException();
       }

       if(cant==null || cant.isEmpty()){
           throw new PartprevcomprssValidatorsExceptions().getCantException();
       }

       if(codcom==null || codcom.isEmpty()){
           throw new PartprevcomprssValidatorsExceptions().getCodcomException();
       }

       if(codimpue==null || codimpue.isEmpty()){
           throw new PartprevcomprssValidatorsExceptions().getCodimpueException();
       }

       if(comenser==null || comenser.isEmpty()){
           throw new PartprevcomprssValidatorsExceptions().getComenserException();
       }

       if(descrip==null || descrip.isEmpty()){
           throw new PartprevcomprssValidatorsExceptions().getDescripException();
       }

       if(flotvenc==null || flotvenc.isEmpty()){
           throw new PartprevcomprssValidatorsExceptions().getFlotvencException();
       }

       if(garan==null || garan.isEmpty()){
           throw new PartprevcomprssValidatorsExceptions().getGaranException();
       }

       if(mon==null || mon.isEmpty()){
           throw new PartprevcomprssValidatorsExceptions().getMonException();
       }

       if(prod==null || prod.isEmpty()){
           throw new PartprevcomprssValidatorsExceptions().getProdException();
       }

       if(serprod==null || serprod.isEmpty()){
           throw new PartprevcomprssValidatorsExceptions().getSerprodException();
       }

       if(unid==null || unid.isEmpty()){
           throw new PartprevcomprssValidatorsExceptions().getUnidException();
       }

       final Partprevcomprs Partprevcomprs = (Partprevcomprs) RepositoryFactory.getInstance().getPartprevcomprssRepository().getByCode(code);
       if(Partprevcomprs != null){            
           throw new PartprevcomprssValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new PartprevcomprssValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new PartprevcomprssValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new PartprevcomprssValidatorsExceptions().getCodeException();
       }

       final Partprevcomprs Partprevcomprs = (Partprevcomprs) RepositoryFactory.getInstance().getPartprevcomprssRepository().getByCode(code);
       if(Partprevcomprs == null){            
           throw new PartprevcomprssValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new PartprevcomprssValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}