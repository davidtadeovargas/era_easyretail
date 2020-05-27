package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.MedssValidatorsExceptions;
import com.era.models.Meds;
import com.era.repositories.RepositoryFactory;

public class MedssValidator extends IValidate{

   private String code;
   private String cod;
   private String descrip;

   @Override
   public void validateInsert() throws Exception {

       if(cod==null || cod.isEmpty()){
           throw new MedssValidatorsExceptions().getCodException();
       }

       if(descrip==null || descrip.isEmpty()){
           throw new MedssValidatorsExceptions().getDescripException();
       }

       final Meds Meds = (Meds) RepositoryFactory.getInstance().getMedssRepository().getByCode(code);
       if(Meds != null){            
           throw new MedssValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new MedssValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new MedssValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new MedssValidatorsExceptions().getCodeException();
       }

       final Meds Meds = (Meds) RepositoryFactory.getInstance().getMedssRepository().getByCode(code);
       if(Meds == null){            
           throw new MedssValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new MedssValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}