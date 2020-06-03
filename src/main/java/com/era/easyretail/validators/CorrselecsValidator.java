package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.CorrselecsValidatorsExceptions;
import com.era.models.Corrselec;
import com.era.repositories.RepositoryFactory;

public class CorrselecsValidator extends IValidate{

   private String actslenlog;
   public void setActslenlog(String property){
       this.actslenlog = property;
   }

   private String asuncontra;
   public void setAsuncontra(String property){
       this.asuncontra = property;
   }

   private String asuncot;
   public void setAsuncot(String property){
       this.asuncot = property;
   }

   private String asunfac;
   public void setAsunfac(String property){
       this.asunfac = property;
   }

   private String asunord;
   public void setAsunord(String property){
       this.asunord = property;
   }

   private String asunrec1;
   public void setAsunrec1(String property){
       this.asunrec1 = property;
   }

   private String asunrec2;
   public void setAsunrec2(String property){
       this.asunrec2 = property;
   }

   private String asunrec3;
   public void setAsunrec3(String property){
       this.asunrec3 = property;
   }

   private String corralter;
   public void setCorralter(String property){
       this.corralter = property;
   }

   private String cuerpcontra;
   public void setCuerpcontra(String property){
       this.cuerpcontra = property;
   }

   private String cuerpcot;
   public void setCuerpcot(String property){
       this.cuerpcot = property;
   }

   private String cuerpfac;
   public void setCuerpfac(String property){
       this.cuerpfac = property;
   }

   private String cuerpord;
   public void setCuerpord(String property){
       this.cuerpord = property;
   }

   private String cuerprec1;
   public void setCuerprec1(String property){
       this.cuerprec1 = property;
   }

   private String cuerprec2;
   public void setCuerprec2(String property){
       this.cuerprec2 = property;
   }

   private String cuerprec3;
   public void setCuerprec3(String property){
       this.cuerprec3 = property;
   }

   private String estacglo;
   public void setEstacglo(String property){
       this.estacglo = property;
   }

   private String pass;
   public void setPass(String property){
       this.pass = property;
   }

   private String portsmtp;
   public void setPortsmtp(String property){
       this.portsmtp = property;
   }

   private String srvsmtpsal;
   public void setSrvsmtpsal(String property){
       this.srvsmtpsal = property;
   }

   private String usr;
   public void setUsr(String property){
       this.usr = property;
   }


   @Override
   public void validateInsert() throws Exception {

       if(actslenlog==null || actslenlog.isEmpty()){
           throw new CorrselecsValidatorsExceptions().getActslenlogException();
       }

       if(asuncontra==null || asuncontra.isEmpty()){
           throw new CorrselecsValidatorsExceptions().getAsuncontraException();
       }

       if(asuncot==null || asuncot.isEmpty()){
           throw new CorrselecsValidatorsExceptions().getAsuncotException();
       }

       if(asunfac==null || asunfac.isEmpty()){
           throw new CorrselecsValidatorsExceptions().getAsunfacException();
       }

       if(asunord==null || asunord.isEmpty()){
           throw new CorrselecsValidatorsExceptions().getAsunordException();
       }

       if(asunrec1==null || asunrec1.isEmpty()){
           throw new CorrselecsValidatorsExceptions().getAsunrec1Exception();
       }

       if(asunrec2==null || asunrec2.isEmpty()){
           throw new CorrselecsValidatorsExceptions().getAsunrec2Exception();
       }

       if(asunrec3==null || asunrec3.isEmpty()){
           throw new CorrselecsValidatorsExceptions().getAsunrec3Exception();
       }

       if(corralter==null || corralter.isEmpty()){
           throw new CorrselecsValidatorsExceptions().getCorralterException();
       }

       if(cuerpcontra==null || cuerpcontra.isEmpty()){
           throw new CorrselecsValidatorsExceptions().getCuerpcontraException();
       }

       if(cuerpcot==null || cuerpcot.isEmpty()){
           throw new CorrselecsValidatorsExceptions().getCuerpcotException();
       }

       if(cuerpfac==null || cuerpfac.isEmpty()){
           throw new CorrselecsValidatorsExceptions().getCuerpfacException();
       }

       if(cuerpord==null || cuerpord.isEmpty()){
           throw new CorrselecsValidatorsExceptions().getCuerpordException();
       }

       if(cuerprec1==null || cuerprec1.isEmpty()){
           throw new CorrselecsValidatorsExceptions().getCuerprec1Exception();
       }

       if(cuerprec2==null || cuerprec2.isEmpty()){
           throw new CorrselecsValidatorsExceptions().getCuerprec2Exception();
       }

       if(cuerprec3==null || cuerprec3.isEmpty()){
           throw new CorrselecsValidatorsExceptions().getCuerprec3Exception();
       }

       if(estacglo==null || estacglo.isEmpty()){
           throw new CorrselecsValidatorsExceptions().getEstacgloException();
       }

       if(pass==null || pass.isEmpty()){
           throw new CorrselecsValidatorsExceptions().getPassException();
       }

       if(portsmtp==null || portsmtp.isEmpty()){
           throw new CorrselecsValidatorsExceptions().getPortsmtpException();
       }

       if(srvsmtpsal==null || srvsmtpsal.isEmpty()){
           throw new CorrselecsValidatorsExceptions().getSrvsmtpsalException();
       }

       if(usr==null || usr.isEmpty()){
           throw new CorrselecsValidatorsExceptions().getUsrException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new CorrselecsValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new CorrselecsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

}