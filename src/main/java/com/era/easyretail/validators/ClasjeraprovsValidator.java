package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.ClasjeraprovsValidatorsExceptions;
import com.era.models.Clasjeraprov;
import com.era.repositories.RepositoryFactory;

public class ClasjeraprovsValidator extends IValidate{

   private String code;
   private String clas;
   private String rut;

   @Override
   public void validateInsert() throws Exception {

       if(clas==null || clas.isEmpty()){
           throw new ClasjeraprovsValidatorsExceptions().getClasException();
       }

       if(rut==null || rut.isEmpty()){
           throw new ClasjeraprovsValidatorsExceptions().getRutException();
       }

       final Clasjeraprov Clasjeraprov = (Clasjeraprov) RepositoryFactory.getInstance().getClasjeraprovsRepository().getByCode(code);
       if(Clasjeraprov != null){            
           throw new ClasjeraprovsValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new ClasjeraprovsValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new ClasjeraprovsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new ClasjeraprovsValidatorsExceptions().getCodeException();
       }

       final Clasjeraprov Clasjeraprov = (Clasjeraprov) RepositoryFactory.getInstance().getClasjeraprovsRepository().getByCode(code);
       if(Clasjeraprov == null){            
           throw new ClasjeraprovsValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new ClasjeraprovsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}