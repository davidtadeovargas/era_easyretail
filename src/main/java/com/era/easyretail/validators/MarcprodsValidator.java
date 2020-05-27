package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.MarcprodsValidatorsExceptions;
import com.era.models.Marcprod;
import com.era.repositories.RepositoryFactory;

public class MarcprodsValidator extends IValidate{

   private String code;
   private String marc;
   private String prod;

   @Override
   public void validateInsert() throws Exception {

       if(marc==null || marc.isEmpty()){
           throw new MarcprodsValidatorsExceptions().getMarcException();
       }

       if(prod==null || prod.isEmpty()){
           throw new MarcprodsValidatorsExceptions().getProdException();
       }

       final Marcprod Marcprod = (Marcprod) RepositoryFactory.getInstance().getMarcprodsRepository().getByCode(code);
       if(Marcprod != null){            
           throw new MarcprodsValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new MarcprodsValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new MarcprodsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new MarcprodsValidatorsExceptions().getCodeException();
       }

       final Marcprod Marcprod = (Marcprod) RepositoryFactory.getInstance().getMarcprodsRepository().getByCode(code);
       if(Marcprod == null){            
           throw new MarcprodsValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new MarcprodsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}