package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.PartcotsValidatorsExceptions;
import com.era.models.Partcot;
import com.era.repositories.RepositoryFactory;

public class PartcotsValidator extends IValidate{

   private String code;
   private String alma;
   private String cant;
   private String codcot;
   private String codimpue;
   private String comenser;
   private String desc1;
   private String desc2;
   private String desc3;
   private String desc4;
   private String desc5;
   private String descrip;
   private String fcadu;
   private String impo2;
   private String impueimpo2;
   private String mon;
   private String pre2;
   private String prod;
   private String serprod;
   private String unid;

   @Override
   public void validateInsert() throws Exception {

       if(alma==null || alma.isEmpty()){
           throw new PartcotsValidatorsExceptions().getAlmaException();
       }

       if(cant==null || cant.isEmpty()){
           throw new PartcotsValidatorsExceptions().getCantException();
       }

       if(codcot==null || codcot.isEmpty()){
           throw new PartcotsValidatorsExceptions().getCodcotException();
       }

       if(codimpue==null || codimpue.isEmpty()){
           throw new PartcotsValidatorsExceptions().getCodimpueException();
       }

       if(comenser==null || comenser.isEmpty()){
           throw new PartcotsValidatorsExceptions().getComenserException();
       }

       if(desc1==null || desc1.isEmpty()){
           throw new PartcotsValidatorsExceptions().getDesc1Exception();
       }

       if(desc2==null || desc2.isEmpty()){
           throw new PartcotsValidatorsExceptions().getDesc2Exception();
       }

       if(desc3==null || desc3.isEmpty()){
           throw new PartcotsValidatorsExceptions().getDesc3Exception();
       }

       if(desc4==null || desc4.isEmpty()){
           throw new PartcotsValidatorsExceptions().getDesc4Exception();
       }

       if(desc5==null || desc5.isEmpty()){
           throw new PartcotsValidatorsExceptions().getDesc5Exception();
       }

       if(descrip==null || descrip.isEmpty()){
           throw new PartcotsValidatorsExceptions().getDescripException();
       }

       if(fcadu==null || fcadu.isEmpty()){
           throw new PartcotsValidatorsExceptions().getFcaduException();
       }

       if(impo2==null || impo2.isEmpty()){
           throw new PartcotsValidatorsExceptions().getImpo2Exception();
       }

       if(impueimpo2==null || impueimpo2.isEmpty()){
           throw new PartcotsValidatorsExceptions().getImpueimpo2Exception();
       }

       if(mon==null || mon.isEmpty()){
           throw new PartcotsValidatorsExceptions().getMonException();
       }

       if(pre2==null || pre2.isEmpty()){
           throw new PartcotsValidatorsExceptions().getPre2Exception();
       }

       if(prod==null || prod.isEmpty()){
           throw new PartcotsValidatorsExceptions().getProdException();
       }

       if(serprod==null || serprod.isEmpty()){
           throw new PartcotsValidatorsExceptions().getSerprodException();
       }

       if(unid==null || unid.isEmpty()){
           throw new PartcotsValidatorsExceptions().getUnidException();
       }

       final Partcot Partcot = (Partcot) RepositoryFactory.getInstance().getPartcotsRepository().getByCode(code);
       if(Partcot != null){            
           throw new PartcotsValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new PartcotsValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new PartcotsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new PartcotsValidatorsExceptions().getCodeException();
       }

       final Partcot Partcot = (Partcot) RepositoryFactory.getInstance().getPartcotsRepository().getByCode(code);
       if(Partcot == null){            
           throw new PartcotsValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new PartcotsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}