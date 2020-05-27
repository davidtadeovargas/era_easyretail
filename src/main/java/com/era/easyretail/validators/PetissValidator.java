package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.PetissValidatorsExceptions;
import com.era.models.Petis;
import com.era.repositories.RepositoryFactory;

public class PetissValidator extends IValidate{

   private String code;
   private String estacdestin;
   private String estad;
   private String nomarch;
   private String path;
   private String val;

   @Override
   public void validateInsert() throws Exception {

       if(estacdestin==null || estacdestin.isEmpty()){
           throw new PetissValidatorsExceptions().getEstacdestinException();
       }

       if(estad==null || estad.isEmpty()){
           throw new PetissValidatorsExceptions().getEstadException();
       }

       if(nomarch==null || nomarch.isEmpty()){
           throw new PetissValidatorsExceptions().getNomarchException();
       }

       if(path==null || path.isEmpty()){
           throw new PetissValidatorsExceptions().getPathException();
       }

       if(val==null || val.isEmpty()){
           throw new PetissValidatorsExceptions().getValException();
       }

       final Petis Petis = (Petis) RepositoryFactory.getInstance().getPetissRepository().getByCode(code);
       if(Petis != null){            
           throw new PetissValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new PetissValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new PetissValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new PetissValidatorsExceptions().getCodeException();
       }

       final Petis Petis = (Petis) RepositoryFactory.getInstance().getPetissRepository().getByCode(code);
       if(Petis == null){            
           throw new PetissValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new PetissValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}