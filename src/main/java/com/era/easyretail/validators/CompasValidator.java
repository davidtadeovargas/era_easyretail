package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.CompasValidatorsExceptions;
import com.era.models.Compa;
import com.era.repositories.RepositoryFactory;

public class CompasValidator extends IValidate{

   private String code;
   private String compa;
   private String prod;

   @Override
   public void validateInsert() throws Exception {

       if(compa==null || compa.isEmpty()){
           throw new CompasValidatorsExceptions().getCompaException();
       }

       if(prod==null || prod.isEmpty()){
           throw new CompasValidatorsExceptions().getProdException();
       }

       final Compa Compa = (Compa) RepositoryFactory.getInstance().getCompasRepository().getByCode(code);
       if(Compa != null){            
           throw new CompasValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new CompasValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new CompasValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new CompasValidatorsExceptions().getCodeException();
       }

       final Compa Compa = (Compa) RepositoryFactory.getInstance().getCompasRepository().getByCode(code);
       if(Compa == null){            
           throw new CompasValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new CompasValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}