package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.CAduanasValidatorsExceptions;
import com.era.models.CAduana;
import com.era.repositories.RepositoryFactory;

public class CAduanasValidator extends IValidate{

   private String code;
   private String c_Aduana;
   private String description;

   @Override
   public void validateInsert() throws Exception {

       if(c_Aduana==null || c_Aduana.isEmpty()){
           throw new CAduanasValidatorsExceptions().getC_AduanaException();
       }

       if(description==null || description.isEmpty()){
           throw new CAduanasValidatorsExceptions().getDescriptionException();
       }

       final CAduana CAduana = (CAduana) RepositoryFactory.getInstance().getCAduanasRepository().getByCode(code);
       if(CAduana != null){            
           throw new CAduanasValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new CAduanasValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new CAduanasValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new CAduanasValidatorsExceptions().getCodeException();
       }

       final CAduana CAduana = (CAduana) RepositoryFactory.getInstance().getCAduanasRepository().getByCode(code);
       if(CAduana == null){            
           throw new CAduanasValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new CAduanasValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}