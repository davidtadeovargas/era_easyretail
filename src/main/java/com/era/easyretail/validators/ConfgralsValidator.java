package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.ConfgralsValidatorsExceptions;
import com.era.models.Confgral;
import com.era.repositories.RepositoryFactory;

public class ConfgralsValidator extends IValidate{

   private String code;
   private String clasif;
   private String conf;
   private String val;

   @Override
   public void validateInsert() throws Exception {

       if(clasif==null || clasif.isEmpty()){
           throw new ConfgralsValidatorsExceptions().getClasifException();
       }

       if(conf==null || conf.isEmpty()){
           throw new ConfgralsValidatorsExceptions().getConfException();
       }

       if(val==null || val.isEmpty()){
           throw new ConfgralsValidatorsExceptions().getValException();
       }

       final Confgral Confgral = (Confgral) RepositoryFactory.getInstance().getConfgralsRepository().getByCode(code);
       if(Confgral != null){            
           throw new ConfgralsValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new ConfgralsValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new ConfgralsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new ConfgralsValidatorsExceptions().getCodeException();
       }

       final Confgral Confgral = (Confgral) RepositoryFactory.getInstance().getConfgralsRepository().getByCode(code);
       if(Confgral == null){            
           throw new ConfgralsValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new ConfgralsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}