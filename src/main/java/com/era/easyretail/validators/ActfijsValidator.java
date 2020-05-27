package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.ActfijsValidatorsExceptions;
import com.era.models.Actfij;
import com.era.repositories.RepositoryFactory;

public class ActfijsValidator extends IValidate{

   private String code;
   private String alma;
   private String ctadedu;
   private String ctadepre;
   private String ctagast;
   private String descrip;
   private String estadusr;
   private String fadquisreal;
   private String fadquisusr;
   private String fbaj;
   private String fbajdep;
   private String ffindep;
   private String finidep;
   private String prod;
   private String tipact;

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

       final Actfij Actfij = (Actfij) RepositoryFactory.getInstance().getActfijsRepository().getByCode(code);
       if(Actfij != null){            
           throw new ActfijsValidatorsExceptions().getModelExistsException();
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

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new ActfijsValidatorsExceptions().getCodeException();
       }

       final Actfij Actfij = (Actfij) RepositoryFactory.getInstance().getActfijsRepository().getByCode(code);
       if(Actfij == null){            
           throw new ActfijsValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new ActfijsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}