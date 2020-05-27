package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.ClasempsValidatorsExceptions;
import com.era.models.Clasemp;
import com.era.repositories.RepositoryFactory;

public class ClasempsValidator extends IValidate{

   private String code;
   private String cod;
   private String descrip;

   @Override
   public void validateInsert() throws Exception {

       if(cod==null || cod.isEmpty()){
           throw new ClasempsValidatorsExceptions().getCodException();
       }

       if(descrip==null || descrip.isEmpty()){
           throw new ClasempsValidatorsExceptions().getDescripException();
       }

       final Clasemp Clasemp = (Clasemp) RepositoryFactory.getInstance().getClasempsRepository().getByCode(code);
       if(Clasemp != null){            
           throw new ClasempsValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new ClasempsValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new ClasempsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new ClasempsValidatorsExceptions().getCodeException();
       }

       final Clasemp Clasemp = (Clasemp) RepositoryFactory.getInstance().getClasempsRepository().getByCode(code);
       if(Clasemp == null){            
           throw new ClasempsValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new ClasempsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}