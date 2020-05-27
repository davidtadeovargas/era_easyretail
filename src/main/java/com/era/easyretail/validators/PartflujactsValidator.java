package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.PartflujactsValidatorsExceptions;
import com.era.models.Partflujact;
import com.era.repositories.RepositoryFactory;

public class PartflujactsValidator extends IValidate{

   private String code;
   private String idfluj;
   private String segui;

   @Override
   public void validateInsert() throws Exception {

       if(idfluj==null || idfluj.isEmpty()){
           throw new PartflujactsValidatorsExceptions().getIdflujException();
       }

       if(segui==null || segui.isEmpty()){
           throw new PartflujactsValidatorsExceptions().getSeguiException();
       }

       final Partflujact Partflujact = (Partflujact) RepositoryFactory.getInstance().getPartflujactsRepository().getByCode(code);
       if(Partflujact != null){            
           throw new PartflujactsValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new PartflujactsValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new PartflujactsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new PartflujactsValidatorsExceptions().getCodeException();
       }

       final Partflujact Partflujact = (Partflujact) RepositoryFactory.getInstance().getPartflujactsRepository().getByCode(code);
       if(Partflujact == null){            
           throw new PartflujactsValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new PartflujactsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}