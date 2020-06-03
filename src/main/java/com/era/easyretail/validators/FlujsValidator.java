package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.FlujsValidatorsExceptions;
import com.era.models.Fluj;
import com.era.repositories.RepositoryFactory;

public class FlujsValidator extends IValidate{

   private String concep;
   public void setConcep(String property){
       this.concep = property;
   }

   private String ing_eg;
   public void setIng_eg(String property){
       this.ing_eg = property;
   }

   private String modd;
   public void setModd(String property){
       this.modd = property;
   }

   private String mon;
   public void setMon(String property){
       this.mon = property;
   }

   private String ncortz;
   public void setNcortz(String property){
       this.ncortz = property;
   }

   private String norefer;
   public void setNorefer(String property){
       this.norefer = property;
   }

   private String tipdoc;
   public void setTipdoc(String property){
       this.tipdoc = property;
   }

   private String vta;
   public void setVta(String property){
       this.vta = property;
   }


   @Override
   public void validateInsert() throws Exception {

       if(concep==null || concep.isEmpty()){
           throw new FlujsValidatorsExceptions().getConcepException();
       }

       if(ing_eg==null || ing_eg.isEmpty()){
           throw new FlujsValidatorsExceptions().getIng_egException();
       }

       if(modd==null || modd.isEmpty()){
           throw new FlujsValidatorsExceptions().getModdException();
       }

       if(mon==null || mon.isEmpty()){
           throw new FlujsValidatorsExceptions().getMonException();
       }

       if(ncortz==null || ncortz.isEmpty()){
           throw new FlujsValidatorsExceptions().getNcortzException();
       }

       if(norefer==null || norefer.isEmpty()){
           throw new FlujsValidatorsExceptions().getNoreferException();
       }

       if(tipdoc==null || tipdoc.isEmpty()){
           throw new FlujsValidatorsExceptions().getTipdocException();
       }

       if(vta==null || vta.isEmpty()){
           throw new FlujsValidatorsExceptions().getVtaException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new FlujsValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new FlujsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

}