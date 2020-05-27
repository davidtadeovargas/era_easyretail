package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.DocumentOriginsValidatorsExceptions;
import com.era.models.DocumentOrigin;
import com.era.repositories.RepositoryFactory;

public class DocumentOriginsValidator extends IValidate{

   private String code;

   @Override
   public void validateInsert() throws Exception {

       final DocumentOrigin DocumentOrigin = (DocumentOrigin) RepositoryFactory.getInstance().getDocumentOriginsRepository().getByCode(code);
       if(DocumentOrigin != null){            
           throw new DocumentOriginsValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new DocumentOriginsValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new DocumentOriginsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new DocumentOriginsValidatorsExceptions().getCodeException();
       }

       final DocumentOrigin DocumentOrigin = (DocumentOrigin) RepositoryFactory.getInstance().getDocumentOriginsRepository().getByCode(code);
       if(DocumentOrigin == null){            
           throw new DocumentOriginsValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new DocumentOriginsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}