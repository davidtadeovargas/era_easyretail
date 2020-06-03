package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.PartordssValidatorsExceptions;
import com.era.models.Partords;
import com.era.repositories.RepositoryFactory;

public class PartordssValidator extends IValidate{

   private String alma;
   public void setAlma(String property){
       this.alma = property;
   }

   private String cant;
   public void setCant(String property){
       this.cant = property;
   }

   private String codcot;
   public void setCodcot(String property){
       this.codcot = property;
   }

   private String codord;
   public void setCodord(String property){
       this.codord = property;
   }

   private String descad;
   public void setDescad(String property){
       this.descad = property;
   }

   private String descrip;
   public void setDescrip(String property){
       this.descrip = property;
   }

   private String descu;
   public void setDescu(String property){
       this.descu = property;
   }

   private String fent;
   public void setFent(String property){
       this.fent = property;
   }

   private String impue;
   public void setImpue(String property){
       this.impue = property;
   }

   private String impueval;
   public void setImpueval(String property){
       this.impueval = property;
   }

   private String mon;
   public void setMon(String property){
       this.mon = property;
   }

   private String prod;
   public void setProd(String property){
       this.prod = property;
   }

   private String unid;
   public void setUnid(String property){
       this.unid = property;
   }


   @Override
   public void validateInsert() throws Exception {

       if(alma==null || alma.isEmpty()){
           throw new PartordssValidatorsExceptions().getAlmaException();
       }

       if(cant==null || cant.isEmpty()){
           throw new PartordssValidatorsExceptions().getCantException();
       }

       if(codcot==null || codcot.isEmpty()){
           throw new PartordssValidatorsExceptions().getCodcotException();
       }

       if(codord==null || codord.isEmpty()){
           throw new PartordssValidatorsExceptions().getCodordException();
       }

       if(descad==null || descad.isEmpty()){
           throw new PartordssValidatorsExceptions().getDescadException();
       }

       if(descrip==null || descrip.isEmpty()){
           throw new PartordssValidatorsExceptions().getDescripException();
       }

       if(descu==null || descu.isEmpty()){
           throw new PartordssValidatorsExceptions().getDescuException();
       }

       if(fent==null || fent.isEmpty()){
           throw new PartordssValidatorsExceptions().getFentException();
       }

       if(impue==null || impue.isEmpty()){
           throw new PartordssValidatorsExceptions().getImpueException();
       }

       if(impueval==null || impueval.isEmpty()){
           throw new PartordssValidatorsExceptions().getImpuevalException();
       }

       if(mon==null || mon.isEmpty()){
           throw new PartordssValidatorsExceptions().getMonException();
       }

       if(prod==null || prod.isEmpty()){
           throw new PartordssValidatorsExceptions().getProdException();
       }

       if(unid==null || unid.isEmpty()){
           throw new PartordssValidatorsExceptions().getUnidException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new PartordssValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new PartordssValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

}