package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.FlujsValidatorsExceptions;
import com.era.models.Fluj;
import com.era.repositories.RepositoryFactory;

public class FlujsValidator extends IValidate{

   private String code;
   private String concep;
   private String ing_eg;
   private String modd;
   private String mon;
   private String ncortz;
   private String norefer;
   private String tipdoc;
   private String vta;

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

       final Fluj Fluj = (Fluj) RepositoryFactory.getInstance().getFlujsRepository().getByCode(code);
       if(Fluj != null){            
           throw new FlujsValidatorsExceptions().getModelExistsException();
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

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new FlujsValidatorsExceptions().getCodeException();
       }

       final Fluj Fluj = (Fluj) RepositoryFactory.getInstance().getFlujsRepository().getByCode(code);
       if(Fluj == null){            
           throw new FlujsValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new FlujsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}