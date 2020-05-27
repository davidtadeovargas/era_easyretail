package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.MsjssValidatorsExceptions;
import com.era.models.Msjs;
import com.era.repositories.RepositoryFactory;

public class MsjssValidator extends IValidate{

   private String code;
   private String msj;

   @Override
   public void validateInsert() throws Exception {

       if(msj==null || msj.isEmpty()){
           throw new MsjssValidatorsExceptions().getMsjException();
       }

       final Msjs Msjs = (Msjs) RepositoryFactory.getInstance().getMsjssRepository().getByCode(code);
       if(Msjs != null){            
           throw new MsjssValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new MsjssValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new MsjssValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new MsjssValidatorsExceptions().getCodeException();
       }

       final Msjs Msjs = (Msjs) RepositoryFactory.getInstance().getMsjssRepository().getByCode(code);
       if(Msjs == null){            
           throw new MsjssValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new MsjssValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}