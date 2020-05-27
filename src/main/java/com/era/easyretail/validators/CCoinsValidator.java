package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.CCoinsValidatorsExceptions;
import com.era.models.CCoin;
import com.era.repositories.RepositoryFactory;

public class CCoinsValidator extends IValidate{

   private String code;
   private String initVigencyDate;
   private String variationPorcent;

   @Override
   public void validateInsert() throws Exception {

       if(code==null || code.isEmpty()){
           throw new CCoinsValidatorsExceptions().getCodeException();
       }

       if(initVigencyDate==null || initVigencyDate.isEmpty()){
           throw new CCoinsValidatorsExceptions().getInitVigencyDateException();
       }

       if(variationPorcent==null || variationPorcent.isEmpty()){
           throw new CCoinsValidatorsExceptions().getVariationPorcentException();
       }

       final CCoin CCoin = (CCoin) RepositoryFactory.getInstance().getCCoinsRepository().getByCode(code);
       if(CCoin != null){            
           throw new CCoinsValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new CCoinsValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new CCoinsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new CCoinsValidatorsExceptions().getCodeException();
       }

       final CCoin CCoin = (CCoin) RepositoryFactory.getInstance().getCCoinsRepository().getByCode(code);
       if(CCoin == null){            
           throw new CCoinsValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new CCoinsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}