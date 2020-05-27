package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.MaxminconfsValidatorsExceptions;
import com.era.models.Maxminconf;
import com.era.repositories.RepositoryFactory;

public class MaxminconfsValidator extends IValidate{

   private String code;
   private String estacglo;
   private String hrs;

   @Override
   public void validateInsert() throws Exception {

       if(estacglo==null || estacglo.isEmpty()){
           throw new MaxminconfsValidatorsExceptions().getEstacgloException();
       }

       if(hrs==null || hrs.isEmpty()){
           throw new MaxminconfsValidatorsExceptions().getHrsException();
       }

       final Maxminconf Maxminconf = (Maxminconf) RepositoryFactory.getInstance().getMaxminconfsRepository().getByCode(code);
       if(Maxminconf != null){            
           throw new MaxminconfsValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new MaxminconfsValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new MaxminconfsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new MaxminconfsValidatorsExceptions().getCodeException();
       }

       final Maxminconf Maxminconf = (Maxminconf) RepositoryFactory.getInstance().getMaxminconfsRepository().getByCode(code);
       if(Maxminconf == null){            
           throw new MaxminconfsValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new MaxminconfsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}