package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.ClasjeraprodsValidatorsExceptions;
import com.era.models.Clasjeraprod;
import com.era.repositories.RepositoryFactory;

public class ClasjeraprodsValidator extends IValidate{

   private String code;
   private String clas;
   private String rut;

   @Override
   public void validateInsert() throws Exception {

       if(clas==null || clas.isEmpty()){
           throw new ClasjeraprodsValidatorsExceptions().getClasException();
       }

       if(rut==null || rut.isEmpty()){
           throw new ClasjeraprodsValidatorsExceptions().getRutException();
       }

       final Clasjeraprod Clasjeraprod = (Clasjeraprod) RepositoryFactory.getInstance().getClasjeraprodsRepository().getByCode(code);
       if(Clasjeraprod != null){            
           throw new ClasjeraprodsValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new ClasjeraprodsValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new ClasjeraprodsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new ClasjeraprodsValidatorsExceptions().getCodeException();
       }

       final Clasjeraprod Clasjeraprod = (Clasjeraprod) RepositoryFactory.getInstance().getClasjeraprodsRepository().getByCode(code);
       if(Clasjeraprod == null){            
           throw new ClasjeraprodsValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new ClasjeraprodsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}