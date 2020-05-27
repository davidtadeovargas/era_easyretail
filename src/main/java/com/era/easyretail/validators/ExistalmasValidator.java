package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.ExistalmasValidatorsExceptions;
import com.era.models.Existalma;
import com.era.repositories.RepositoryFactory;

public class ExistalmasValidator extends IValidate{

   private String code;
   private String alma;
   private String prod;

   @Override
   public void validateInsert() throws Exception {

       if(alma==null || alma.isEmpty()){
           throw new ExistalmasValidatorsExceptions().getAlmaException();
       }

       if(prod==null || prod.isEmpty()){
           throw new ExistalmasValidatorsExceptions().getProdException();
       }

       final Existalma Existalma = (Existalma) RepositoryFactory.getInstance().getExistalmasRepository().getByCode(code);
       if(Existalma != null){            
           throw new ExistalmasValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new ExistalmasValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new ExistalmasValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new ExistalmasValidatorsExceptions().getCodeException();
       }

       final Existalma Existalma = (Existalma) RepositoryFactory.getInstance().getExistalmasRepository().getByCode(code);
       if(Existalma == null){            
           throw new ExistalmasValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new ExistalmasValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}