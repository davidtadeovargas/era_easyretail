package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.DomentclisValidatorsExceptions;
import com.era.models.Domentcli;
import com.era.repositories.RepositoryFactory;

public class DomentclisValidator extends IValidate{

   private String code;
   private String codemp;

   @Override
   public void validateInsert() throws Exception {

       if(codemp==null || codemp.isEmpty()){
           throw new DomentclisValidatorsExceptions().getCodempException();
       }

       final Domentcli Domentcli = (Domentcli) RepositoryFactory.getInstance().getDomentclisRepository().getByCode(code);
       if(Domentcli != null){            
           throw new DomentclisValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new DomentclisValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new DomentclisValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new DomentclisValidatorsExceptions().getCodeException();
       }

       final Domentcli Domentcli = (Domentcli) RepositoryFactory.getInstance().getDomentclisRepository().getByCode(code);
       if(Domentcli == null){            
           throw new DomentclisValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new DomentclisValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}