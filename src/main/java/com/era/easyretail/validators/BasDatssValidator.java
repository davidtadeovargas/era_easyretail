package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.BasDatssValidatorsExceptions;
import com.era.models.BasDats;
import com.era.repositories.RepositoryFactory;

public class BasDatssValidator extends IValidate{

   private String code;
   private String codemp;
   private String nom;

   @Override
   public void validateInsert() throws Exception {

       if(codemp==null || codemp.isEmpty()){
           throw new BasDatssValidatorsExceptions().getCodempException();
       }

       if(nom==null || nom.isEmpty()){
           throw new BasDatssValidatorsExceptions().getNomException();
       }

       final BasDats BasDats = (BasDats) RepositoryFactory.getInstance().getBasDatssRepository().getByCode(code);
       if(BasDats != null){            
           throw new BasDatssValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new BasDatssValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new BasDatssValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new BasDatssValidatorsExceptions().getCodeException();
       }

       final BasDats BasDats = (BasDats) RepositoryFactory.getInstance().getBasDatssRepository().getByCode(code);
       if(BasDats == null){            
           throw new BasDatssValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new BasDatssValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}