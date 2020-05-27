package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.MarcssValidatorsExceptions;
import com.era.models.Marcs;
import com.era.repositories.RepositoryFactory;

public class MarcssValidator extends IValidate{

   private String code;
   private String cod;
   private String descrip;

   @Override
   public void validateInsert() throws Exception {

       if(cod==null || cod.isEmpty()){
           throw new MarcssValidatorsExceptions().getCodException();
       }

       if(descrip==null || descrip.isEmpty()){
           throw new MarcssValidatorsExceptions().getDescripException();
       }

       final Marcs Marcs = (Marcs) RepositoryFactory.getInstance().getMarcssRepository().getByCode(code);
       if(Marcs != null){            
           throw new MarcssValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new MarcssValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new MarcssValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new MarcssValidatorsExceptions().getCodeException();
       }

       final Marcs Marcs = (Marcs) RepositoryFactory.getInstance().getMarcssRepository().getByCode(code);
       if(Marcs == null){            
           throw new MarcssValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new MarcssValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}