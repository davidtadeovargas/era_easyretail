package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.FabssValidatorsExceptions;
import com.era.models.Fabs;
import com.era.repositories.RepositoryFactory;

public class FabssValidator extends IValidate{

   private String code;
   private String cod;
   private String descrip;

   @Override
   public void validateInsert() throws Exception {

       if(cod==null || cod.isEmpty()){
           throw new FabssValidatorsExceptions().getCodException();
       }

       if(descrip==null || descrip.isEmpty()){
           throw new FabssValidatorsExceptions().getDescripException();
       }

       final Fabs Fabs = (Fabs) RepositoryFactory.getInstance().getFabssRepository().getByCode(code);
       if(Fabs != null){            
           throw new FabssValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new FabssValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new FabssValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new FabssValidatorsExceptions().getCodeException();
       }

       final Fabs Fabs = (Fabs) RepositoryFactory.getInstance().getFabssRepository().getByCode(code);
       if(Fabs == null){            
           throw new FabssValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new FabssValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}