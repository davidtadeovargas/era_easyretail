package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.PessValidatorsExceptions;
import com.era.models.Pes;
import com.era.repositories.RepositoryFactory;

public class PessValidator extends IValidate{

   private String code;
   private String cod;
   private String descrip;

   @Override
   public void validateInsert() throws Exception {

       if(cod==null || cod.isEmpty()){
           throw new PessValidatorsExceptions().getCodException();
       }

       if(descrip==null || descrip.isEmpty()){
           throw new PessValidatorsExceptions().getDescripException();
       }

       final Pes Pes = (Pes) RepositoryFactory.getInstance().getPessRepository().getByCode(code);
       if(Pes != null){            
           throw new PessValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new PessValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new PessValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new PessValidatorsExceptions().getCodeException();
       }

       final Pes Pes = (Pes) RepositoryFactory.getInstance().getPessRepository().getByCode(code);
       if(Pes == null){            
           throw new PessValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new PessValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}