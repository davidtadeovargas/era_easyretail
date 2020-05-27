package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.ImpuesXProductsValidatorsExceptions;
import com.era.models.ImpuesXProduct;
import com.era.repositories.RepositoryFactory;

public class ImpuesXProductsValidator extends IValidate{

   private String code;
   private String impue;
   private String produ;

   @Override
   public void validateInsert() throws Exception {

       if(impue==null || impue.isEmpty()){
           throw new ImpuesXProductsValidatorsExceptions().getImpueException();
       }

       if(produ==null || produ.isEmpty()){
           throw new ImpuesXProductsValidatorsExceptions().getProduException();
       }

       final ImpuesXProduct ImpuesXProduct = (ImpuesXProduct) RepositoryFactory.getInstance().getImpuesXProductsRepository().getByCode(code);
       if(ImpuesXProduct != null){            
           throw new ImpuesXProductsValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new ImpuesXProductsValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new ImpuesXProductsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new ImpuesXProductsValidatorsExceptions().getCodeException();
       }

       final ImpuesXProduct ImpuesXProduct = (ImpuesXProduct) RepositoryFactory.getInstance().getImpuesXProductsRepository().getByCode(code);
       if(ImpuesXProduct == null){            
           throw new ImpuesXProductsValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new ImpuesXProductsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}