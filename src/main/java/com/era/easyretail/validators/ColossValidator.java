package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.ColossValidatorsExceptions;
import com.era.models.Colos;
import com.era.repositories.RepositoryFactory;

public class ColossValidator extends IValidate{

   private String code;
   private String cod;
   private String descrip;

   @Override
   public void validateInsert() throws Exception {

       if(cod==null || cod.isEmpty()){
           throw new ColossValidatorsExceptions().getCodException();
       }

       if(descrip==null || descrip.isEmpty()){
           throw new ColossValidatorsExceptions().getDescripException();
       }

       final Colos Colos = (Colos) RepositoryFactory.getInstance().getColossRepository().getByCode(code);
       if(Colos != null){            
           throw new ColossValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new ColossValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new ColossValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new ColossValidatorsExceptions().getCodeException();
       }

       final Colos Colos = (Colos) RepositoryFactory.getInstance().getColossRepository().getByCode(code);
       if(Colos == null){            
           throw new ColossValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new ColossValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}