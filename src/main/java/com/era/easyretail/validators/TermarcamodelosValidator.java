package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.TermarcamodelosValidatorsExceptions;
import com.era.models.Termarcamodelo;
import com.era.repositories.RepositoryFactory;

public class TermarcamodelosValidator extends IValidate{

   private String code;
   private String marc;
   private String model;

   @Override
   public void validateInsert() throws Exception {

       if(marc==null || marc.isEmpty()){
           throw new TermarcamodelosValidatorsExceptions().getMarcException();
       }

       if(model==null || model.isEmpty()){
           throw new TermarcamodelosValidatorsExceptions().getModelException();
       }

       final Termarcamodelo Termarcamodelo = (Termarcamodelo) RepositoryFactory.getInstance().getTermarcamodelosRepository().getByCode(code);
       if(Termarcamodelo != null){            
           throw new TermarcamodelosValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new TermarcamodelosValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new TermarcamodelosValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new TermarcamodelosValidatorsExceptions().getCodeException();
       }

       final Termarcamodelo Termarcamodelo = (Termarcamodelo) RepositoryFactory.getInstance().getTermarcamodelosRepository().getByCode(code);
       if(Termarcamodelo == null){            
           throw new TermarcamodelosValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new TermarcamodelosValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}