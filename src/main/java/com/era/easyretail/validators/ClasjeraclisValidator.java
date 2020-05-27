package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.ClasjeraclisValidatorsExceptions;
import com.era.models.Clasjeracli;
import com.era.repositories.RepositoryFactory;

public class ClasjeraclisValidator extends IValidate{

   private String code;
   private String clas;
   private String rut;

   @Override
   public void validateInsert() throws Exception {

       if(clas==null || clas.isEmpty()){
           throw new ClasjeraclisValidatorsExceptions().getClasException();
       }

       if(rut==null || rut.isEmpty()){
           throw new ClasjeraclisValidatorsExceptions().getRutException();
       }

       final Clasjeracli Clasjeracli = (Clasjeracli) RepositoryFactory.getInstance().getClasjeraclisRepository().getByCode(code);
       if(Clasjeracli != null){            
           throw new ClasjeraclisValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new ClasjeraclisValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new ClasjeraclisValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new ClasjeraclisValidatorsExceptions().getCodeException();
       }

       final Clasjeracli Clasjeracli = (Clasjeracli) RepositoryFactory.getInstance().getClasjeraclisRepository().getByCode(code);
       if(Clasjeracli == null){            
           throw new ClasjeraclisValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new ClasjeraclisValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}