package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.CotssValidatorsExceptions;
import com.era.models.Cots;
import com.era.repositories.RepositoryFactory;

public class CotssValidator extends IValidate{

   private String codcot;
   public void setCodcot(String property){
       this.codcot = property;
   }

   private String codemp;
   public void setCodemp(String property){
       this.codemp = property;
   }

   private String descrip;
   public void setDescrip(String property){
       this.descrip = property;
   }

   private String estad;
   public void setEstad(String property){
       this.estad = property;
   }

   private String fdoc;
   public void setFdoc(String property){
       this.fdoc = property;
   }

   private String fentre;
   public void setFentre(String property){
       this.fentre = property;
   }

   private String fvenc;
   public void setFvenc(String property){
       this.fvenc = property;
   }

   private String mon;
   public void setMon(String property){
       this.mon = property;
   }

   private String noser;
   public void setNoser(String property){
       this.noser = property;
   }

   private String observ;
   public void setObserv(String property){
       this.observ = property;
   }

   private String proy;
   public void setProy(String property){
       this.proy = property;
   }

   private String ser;
   public void setSer(String property){
       this.ser = property;
   }

   private String subtotgral2;
   public void setSubtotgral2(String property){
       this.subtotgral2 = property;
   }

   private String subtotmat2;
   public void setSubtotmat2(String property){
       this.subtotmat2 = property;
   }


   @Override
   public void validateInsert() throws Exception {

       if(codcot==null || codcot.isEmpty()){
           throw new CotssValidatorsExceptions().getCodcotException();
       }

       if(codemp==null || codemp.isEmpty()){
           throw new CotssValidatorsExceptions().getCodempException();
       }

       if(descrip==null || descrip.isEmpty()){
           throw new CotssValidatorsExceptions().getDescripException();
       }

       if(estad==null || estad.isEmpty()){
           throw new CotssValidatorsExceptions().getEstadException();
       }

       if(fdoc==null || fdoc.isEmpty()){
           throw new CotssValidatorsExceptions().getFdocException();
       }

       if(fentre==null || fentre.isEmpty()){
           throw new CotssValidatorsExceptions().getFentreException();
       }

       if(fvenc==null || fvenc.isEmpty()){
           throw new CotssValidatorsExceptions().getFvencException();
       }

       if(mon==null || mon.isEmpty()){
           throw new CotssValidatorsExceptions().getMonException();
       }

       if(noser==null || noser.isEmpty()){
           throw new CotssValidatorsExceptions().getNoserException();
       }

       if(observ==null || observ.isEmpty()){
           throw new CotssValidatorsExceptions().getObservException();
       }

       if(proy==null || proy.isEmpty()){
           throw new CotssValidatorsExceptions().getProyException();
       }

       if(ser==null || ser.isEmpty()){
           throw new CotssValidatorsExceptions().getSerException();
       }

       if(subtotgral2==null || subtotgral2.isEmpty()){
           throw new CotssValidatorsExceptions().getSubtotgral2Exception();
       }

       if(subtotmat2==null || subtotmat2.isEmpty()){
           throw new CotssValidatorsExceptions().getSubtotmat2Exception();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new CotssValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new CotssValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

}