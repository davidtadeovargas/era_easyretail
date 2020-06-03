package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.ActfijsValidatorsExceptions;
import com.era.models.Actfij;
import com.era.repositories.RepositoryFactory;

public class ActfijsValidator extends IValidate{

   private String alma;
   public void setAlma(String property){
       this.alma = property;
   }

   private String ctadedu;
   public void setCtadedu(String property){
       this.ctadedu = property;
   }

   private String ctadepre;
   public void setCtadepre(String property){
       this.ctadepre = property;
   }

   private String ctagast;
   public void setCtagast(String property){
       this.ctagast = property;
   }

   private String descrip;
   public void setDescrip(String property){
       this.descrip = property;
   }

   private String estadusr;
   public void setEstadusr(String property){
       this.estadusr = property;
   }

   private String fadquisreal;
   public void setFadquisreal(String property){
       this.fadquisreal = property;
   }

   private String fadquisusr;
   public void setFadquisusr(String property){
       this.fadquisusr = property;
   }

   private String fbaj;
   public void setFbaj(String property){
       this.fbaj = property;
   }

   private String fbajdep;
   public void setFbajdep(String property){
       this.fbajdep = property;
   }

   private String ffindep;
   public void setFfindep(String property){
       this.ffindep = property;
   }

   private String finidep;
   public void setFinidep(String property){
       this.finidep = property;
   }

   private String prod;
   public void setProd(String property){
       this.prod = property;
   }

   private String tipact;
   public void setTipact(String property){
       this.tipact = property;
   }


   @Override
   public void validateInsert() throws Exception {

       if(alma==null || alma.isEmpty()){
           throw new ActfijsValidatorsExceptions().getAlmaException();
       }

       if(ctadedu==null || ctadedu.isEmpty()){
           throw new ActfijsValidatorsExceptions().getCtadeduException();
       }

       if(ctadepre==null || ctadepre.isEmpty()){
           throw new ActfijsValidatorsExceptions().getCtadepreException();
       }

       if(ctagast==null || ctagast.isEmpty()){
           throw new ActfijsValidatorsExceptions().getCtagastException();
       }

       if(descrip==null || descrip.isEmpty()){
           throw new ActfijsValidatorsExceptions().getDescripException();
       }

       if(estadusr==null || estadusr.isEmpty()){
           throw new ActfijsValidatorsExceptions().getEstadusrException();
       }

       if(fadquisreal==null || fadquisreal.isEmpty()){
           throw new ActfijsValidatorsExceptions().getFadquisrealException();
       }

       if(fadquisusr==null || fadquisusr.isEmpty()){
           throw new ActfijsValidatorsExceptions().getFadquisusrException();
       }

       if(fbaj==null || fbaj.isEmpty()){
           throw new ActfijsValidatorsExceptions().getFbajException();
       }

       if(fbajdep==null || fbajdep.isEmpty()){
           throw new ActfijsValidatorsExceptions().getFbajdepException();
       }

       if(ffindep==null || ffindep.isEmpty()){
           throw new ActfijsValidatorsExceptions().getFfindepException();
       }

       if(finidep==null || finidep.isEmpty()){
           throw new ActfijsValidatorsExceptions().getFinidepException();
       }

       if(prod==null || prod.isEmpty()){
           throw new ActfijsValidatorsExceptions().getProdException();
       }

       if(tipact==null || tipact.isEmpty()){
           throw new ActfijsValidatorsExceptions().getTipactException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new ActfijsValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new ActfijsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

}