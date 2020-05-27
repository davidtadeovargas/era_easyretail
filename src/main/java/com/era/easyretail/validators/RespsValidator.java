package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.RespsValidatorsExceptions;
import com.era.models.Resp;
import com.era.repositories.RepositoryFactory;

public class RespsValidator extends IValidate{

   private String code;
   private String estacres;
   private String hrs;

   @Override
   public void validateInsert() throws Exception {

       if(estacres==null || estacres.isEmpty()){
           throw new RespsValidatorsExceptions().getEstacresException();
       }

       if(hrs==null || hrs.isEmpty()){
           throw new RespsValidatorsExceptions().getHrsException();
       }

       final Resp Resp = (Resp) RepositoryFactory.getInstance().getRespsRepository().getByCode(code);
       if(Resp != null){            
           throw new RespsValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new RespsValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new RespsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new RespsValidatorsExceptions().getCodeException();
       }

       final Resp Resp = (Resp) RepositoryFactory.getInstance().getRespsRepository().getByCode(code);
       if(Resp == null){            
           throw new RespsValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new RespsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}