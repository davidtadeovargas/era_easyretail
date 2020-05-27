package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.FlujactsValidatorsExceptions;
import com.era.models.Flujact;
import com.era.repositories.RepositoryFactory;

public class FlujactsValidator extends IValidate{

   private String code;
   private String tit;
   private String usrenvi;
   private String usrrecib;

   @Override
   public void validateInsert() throws Exception {

       if(tit==null || tit.isEmpty()){
           throw new FlujactsValidatorsExceptions().getTitException();
       }

       if(usrenvi==null || usrenvi.isEmpty()){
           throw new FlujactsValidatorsExceptions().getUsrenviException();
       }

       if(usrrecib==null || usrrecib.isEmpty()){
           throw new FlujactsValidatorsExceptions().getUsrrecibException();
       }

       final Flujact Flujact = (Flujact) RepositoryFactory.getInstance().getFlujactsRepository().getByCode(code);
       if(Flujact != null){            
           throw new FlujactsValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new FlujactsValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new FlujactsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new FlujactsValidatorsExceptions().getCodeException();
       }

       final Flujact Flujact = (Flujact) RepositoryFactory.getInstance().getFlujactsRepository().getByCode(code);
       if(Flujact == null){            
           throw new FlujactsValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new FlujactsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}