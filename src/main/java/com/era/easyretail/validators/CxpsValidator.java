package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.CxpsValidatorsExceptions;
import com.era.models.Cxp;
import com.era.repositories.RepositoryFactory;

public class CxpsValidator extends IValidate{

   private String abon;
   public void setAbon(String property){
       this.abon = property;
   }

   private String carg;
   public void setCarg(String property){
       this.carg = property;
   }

   private String fdoc;
   public void setFdoc(String property){
       this.fdoc = property;
   }

   private String impue;
   public void setImpue(String property){
       this.impue = property;
   }

   private String monedaID;
   public void setMonedaID(String property){
       this.monedaID = property;
   }

   private String norefer;
   public void setNorefer(String property){
       this.norefer = property;
   }

   private String noser;
   public void setNoser(String property){
       this.noser = property;
   }

   private String prov;
   public void setProv(String property){
       this.prov = property;
   }

   private String ser;
   public void setSer(String property){
       this.ser = property;
   }

   private String subtot;
   public void setSubtot(String property){
       this.subtot = property;
   }

   private String tipcam;
   public void setTipcam(String property){
       this.tipcam = property;
   }

   private String tot;
   public void setTot(String property){
       this.tot = property;
   }


   @Override
   public void validateInsert() throws Exception {

       if(abon==null || abon.isEmpty()){
           throw new CxpsValidatorsExceptions().getAbonException();
       }

       if(carg==null || carg.isEmpty()){
           throw new CxpsValidatorsExceptions().getCargException();
       }

       if(fdoc==null || fdoc.isEmpty()){
           throw new CxpsValidatorsExceptions().getFdocException();
       }

       if(impue==null || impue.isEmpty()){
           throw new CxpsValidatorsExceptions().getImpueException();
       }

       if(monedaID==null || monedaID.isEmpty()){
           throw new CxpsValidatorsExceptions().getMonedaIDException();
       }

       if(norefer==null || norefer.isEmpty()){
           throw new CxpsValidatorsExceptions().getNoreferException();
       }

       if(noser==null || noser.isEmpty()){
           throw new CxpsValidatorsExceptions().getNoserException();
       }

       if(prov==null || prov.isEmpty()){
           throw new CxpsValidatorsExceptions().getProvException();
       }

       if(ser==null || ser.isEmpty()){
           throw new CxpsValidatorsExceptions().getSerException();
       }

       if(subtot==null || subtot.isEmpty()){
           throw new CxpsValidatorsExceptions().getSubtotException();
       }

       if(tipcam==null || tipcam.isEmpty()){
           throw new CxpsValidatorsExceptions().getTipcamException();
       }

       if(tot==null || tot.isEmpty()){
           throw new CxpsValidatorsExceptions().getTotException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new CxpsValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new CxpsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

}