package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.UnidsValidatorsExceptions;
import com.era.models.Unid;
import com.era.repositories.RepositoryFactory;

public class UnidsValidator extends IValidate{

   private String code;
   private String claveSAT;

   @Override
   public void validateInsert() throws Exception {

       if(claveSAT==null || claveSAT.isEmpty()){
           throw new UnidsValidatorsExceptions().getClaveSATException();
       }

       if(code==null || code.isEmpty()){
           throw new UnidsValidatorsExceptions().getCodeException();
       }

       final Unid Unid = (Unid) RepositoryFactory.getInstance().getUnidsRepository().getByCode(code);
       if(Unid != null){            
           throw new UnidsValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new UnidsValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new UnidsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new UnidsValidatorsExceptions().getCodeException();
       }

       final Unid Unid = (Unid) RepositoryFactory.getInstance().getUnidsRepository().getByCode(code);
       if(Unid == null){            
           throw new UnidsValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new UnidsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}