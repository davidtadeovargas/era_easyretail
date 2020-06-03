package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.TraspassValidatorsExceptions;
import com.era.models.Traspas;
import com.era.repositories.RepositoryFactory;

public class TraspassValidator extends IValidate{

   private String alma;
   public void setAlma(String property){
       this.alma = property;
   }

   private String almaa;
   public void setAlmaa(String property){
       this.almaa = property;
   }

   private String code;
   public void setCode(String property){
       this.code = property;
   }

   private String concep;
   public void setConcep(String property){
       this.concep = property;
   }

   private String unid;
   public void setUnid(String property){
       this.unid = property;
   }


   @Override
   public void validateInsert() throws Exception {

       if(alma==null || alma.isEmpty()){
           throw new TraspassValidatorsExceptions().getAlmaException();
       }

       if(almaa==null || almaa.isEmpty()){
           throw new TraspassValidatorsExceptions().getAlmaaException();
       }

       if(code==null || code.isEmpty()){
           throw new TraspassValidatorsExceptions().getCodeException();
       }

       if(concep==null || concep.isEmpty()){
           throw new TraspassValidatorsExceptions().getConcepException();
       }

       if(unid==null || unid.isEmpty()){
           throw new TraspassValidatorsExceptions().getUnidException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new TraspassValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new TraspassValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

}