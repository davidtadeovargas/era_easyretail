package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.GaransValidatorsExceptions;
import com.era.models.Garan;
import com.era.repositories.RepositoryFactory;

public class GaransValidator extends IValidate{

   private String code;
   private String descrip;
   private String gara;

   @Override
   public void validateInsert() throws Exception {

       if(descrip==null || descrip.isEmpty()){
           throw new GaransValidatorsExceptions().getDescripException();
       }

       if(gara==null || gara.isEmpty()){
           throw new GaransValidatorsExceptions().getGaraException();
       }

       final Garan Garan = (Garan) RepositoryFactory.getInstance().getGaransRepository().getByCode(code);
       if(Garan != null){            
           throw new GaransValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new GaransValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new GaransValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new GaransValidatorsExceptions().getCodeException();
       }

       final Garan Garan = (Garan) RepositoryFactory.getInstance().getGaransRepository().getByCode(code);
       if(Garan == null){            
           throw new GaransValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new GaransValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}