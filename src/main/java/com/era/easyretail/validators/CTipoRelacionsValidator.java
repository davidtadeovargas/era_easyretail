package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.CTipoRelacionsValidatorsExceptions;
import com.era.models.CTipoRelacion;
import com.era.repositories.RepositoryFactory;

public class CTipoRelacionsValidator extends IValidate{

   private String code;
   private String description;

   @Override
   public void validateInsert() throws Exception {

       if(description==null || description.isEmpty()){
           throw new CTipoRelacionsValidatorsExceptions().getDescriptionException();
       }

       final CTipoRelacion CTipoRelacion = (CTipoRelacion) RepositoryFactory.getInstance().getCTipoRelacionsRepository().getByCode(code);
       if(CTipoRelacion != null){            
           throw new CTipoRelacionsValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new CTipoRelacionsValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new CTipoRelacionsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new CTipoRelacionsValidatorsExceptions().getCodeException();
       }

       final CTipoRelacion CTipoRelacion = (CTipoRelacion) RepositoryFactory.getInstance().getCTipoRelacionsRepository().getByCode(code);
       if(CTipoRelacion == null){            
           throw new CTipoRelacionsValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new CTipoRelacionsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}