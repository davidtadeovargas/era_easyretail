package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.ModelprodsValidatorsExceptions;
import com.era.models.Modelprod;
import com.era.repositories.RepositoryFactory;

public class ModelprodsValidator extends IValidate{

   private String code;
   private String mode;
   private String prod;

   @Override
   public void validateInsert() throws Exception {

       if(mode==null || mode.isEmpty()){
           throw new ModelprodsValidatorsExceptions().getModeException();
       }

       if(prod==null || prod.isEmpty()){
           throw new ModelprodsValidatorsExceptions().getProdException();
       }

       final Modelprod Modelprod = (Modelprod) RepositoryFactory.getInstance().getModelprodsRepository().getByCode(code);
       if(Modelprod != null){            
           throw new ModelprodsValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new ModelprodsValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new ModelprodsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new ModelprodsValidatorsExceptions().getCodeException();
       }

       final Modelprod Modelprod = (Modelprod) RepositoryFactory.getInstance().getModelprodsRepository().getByCode(code);
       if(Modelprod == null){            
           throw new ModelprodsValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new ModelprodsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}