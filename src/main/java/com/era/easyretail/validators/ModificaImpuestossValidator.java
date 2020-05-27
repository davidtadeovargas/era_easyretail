package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.ModificaImpuestossValidatorsExceptions;
import com.era.models.ModificaImpuestos;
import com.era.repositories.RepositoryFactory;

public class ModificaImpuestossValidator extends IValidate{

   private String code;

   @Override
   public void validateInsert() throws Exception {

       final ModificaImpuestos ModificaImpuestos = (ModificaImpuestos) RepositoryFactory.getInstance().getModificaImpuestossRepository().getByCode(code);
       if(ModificaImpuestos != null){            
           throw new ModificaImpuestossValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new ModificaImpuestossValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new ModificaImpuestossValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new ModificaImpuestossValidatorsExceptions().getCodeException();
       }

       final ModificaImpuestos ModificaImpuestos = (ModificaImpuestos) RepositoryFactory.getInstance().getModificaImpuestossRepository().getByCode(code);
       if(ModificaImpuestos == null){            
           throw new ModificaImpuestossValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new ModificaImpuestossValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}