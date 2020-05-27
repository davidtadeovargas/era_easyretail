package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.LugssValidatorsExceptions;
import com.era.models.Lugs;
import com.era.repositories.RepositoryFactory;

public class LugssValidator extends IValidate{

   private String code;
   private String cod;
   private String descrip;

   @Override
   public void validateInsert() throws Exception {

       if(cod==null || cod.isEmpty()){
           throw new LugssValidatorsExceptions().getCodException();
       }

       if(descrip==null || descrip.isEmpty()){
           throw new LugssValidatorsExceptions().getDescripException();
       }

       final Lugs Lugs = (Lugs) RepositoryFactory.getInstance().getLugssRepository().getByCode(code);
       if(Lugs != null){            
           throw new LugssValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new LugssValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new LugssValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new LugssValidatorsExceptions().getCodeException();
       }

       final Lugs Lugs = (Lugs) RepositoryFactory.getInstance().getLugssRepository().getByCode(code);
       if(Lugs == null){            
           throw new LugssValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new LugssValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}