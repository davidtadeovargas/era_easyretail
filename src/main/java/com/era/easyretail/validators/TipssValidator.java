package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.TipssValidatorsExceptions;
import com.era.models.Tips;
import com.era.repositories.RepositoryFactory;

public class TipssValidator extends IValidate{

   private String code;
   private String cod;
   private String descrip;

   @Override
   public void validateInsert() throws Exception {

       if(cod==null || cod.isEmpty()){
           throw new TipssValidatorsExceptions().getCodException();
       }

       if(descrip==null || descrip.isEmpty()){
           throw new TipssValidatorsExceptions().getDescripException();
       }

       final Tips Tips = (Tips) RepositoryFactory.getInstance().getTipssRepository().getByCode(code);
       if(Tips != null){            
           throw new TipssValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new TipssValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new TipssValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new TipssValidatorsExceptions().getCodeException();
       }

       final Tips Tips = (Tips) RepositoryFactory.getInstance().getTipssRepository().getByCode(code);
       if(Tips == null){            
           throw new TipssValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new TipssValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}