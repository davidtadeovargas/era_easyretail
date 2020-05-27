package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.CorrselecsValidatorsExceptions;
import com.era.models.Corrselec;
import com.era.repositories.RepositoryFactory;

public class CorrselecsValidator extends IValidate{

   private String code;
   private String actslenlog;
   private String asuncontra;
   private String asuncot;
   private String asunfac;
   private String asunord;
   private String asunrec1;
   private String asunrec2;
   private String asunrec3;
   private String corralter;
   private String cuerpcontra;
   private String cuerpcot;
   private String cuerpfac;
   private String cuerpord;
   private String cuerprec1;
   private String cuerprec2;
   private String cuerprec3;
   private String estacglo;
   private String pass;
   private String portsmtp;
   private String srvsmtpsal;
   private String usr;

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

       final Corrselec Corrselec = (Corrselec) RepositoryFactory.getInstance().getCorrselecsRepository().getByCode(code);
       if(Corrselec != null){            
           throw new CorrselecsValidatorsExceptions().getModelExistsException();
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

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new CorrselecsValidatorsExceptions().getCodeException();
       }

       final Corrselec Corrselec = (Corrselec) RepositoryFactory.getInstance().getCorrselecsRepository().getByCode(code);
       if(Corrselec == null){            
           throw new CorrselecsValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new CorrselecsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}