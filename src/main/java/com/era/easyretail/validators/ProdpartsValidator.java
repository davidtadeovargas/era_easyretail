package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.ProdpartsValidatorsExceptions;
import com.era.models.Prodpart;
import com.era.repositories.RepositoryFactory;

public class ProdpartsValidator extends IValidate{

   private String code;
   private String part;
   private String prod;

   @Override
   public void validateInsert() throws Exception {

       if(part==null || part.isEmpty()){
           throw new ProdpartsValidatorsExceptions().getPartException();
       }

       if(prod==null || prod.isEmpty()){
           throw new ProdpartsValidatorsExceptions().getProdException();
       }

       final Prodpart Prodpart = (Prodpart) RepositoryFactory.getInstance().getProdpartsRepository().getByCode(code);
       if(Prodpart != null){            
           throw new ProdpartsValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new ProdpartsValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new ProdpartsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new ProdpartsValidatorsExceptions().getCodeException();
       }

       final Prodpart Prodpart = (Prodpart) RepositoryFactory.getInstance().getProdpartsRepository().getByCode(code);
       if(Prodpart == null){            
           throw new ProdpartsValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new ProdpartsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}