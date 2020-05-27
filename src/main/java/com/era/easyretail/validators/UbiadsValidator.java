package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.UbiadsValidatorsExceptions;
import com.era.models.Ubiad;
import com.era.repositories.RepositoryFactory;

public class UbiadsValidator extends IValidate{

   private String code;
   private String cod;
   private String descrip;

   @Override
   public void validateInsert() throws Exception {

       if(cod==null || cod.isEmpty()){
           throw new UbiadsValidatorsExceptions().getCodException();
       }

       if(descrip==null || descrip.isEmpty()){
           throw new UbiadsValidatorsExceptions().getDescripException();
       }

       final Ubiad Ubiad = (Ubiad) RepositoryFactory.getInstance().getUbiadsRepository().getByCode(code);
       if(Ubiad != null){            
           throw new UbiadsValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new UbiadsValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new UbiadsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new UbiadsValidatorsExceptions().getCodeException();
       }

       final Ubiad Ubiad = (Ubiad) RepositoryFactory.getInstance().getUbiadsRepository().getByCode(code);
       if(Ubiad == null){            
           throw new UbiadsValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new UbiadsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}