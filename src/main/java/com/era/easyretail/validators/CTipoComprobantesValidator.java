package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.CTipoComprobantesValidatorsExceptions;
import com.era.models.CTipoComprobante;
import com.era.repositories.RepositoryFactory;

public class CTipoComprobantesValidator extends IValidate{

   private String code;

   @Override
   public void validateInsert() throws Exception {

       final CTipoComprobante CTipoComprobante = (CTipoComprobante) RepositoryFactory.getInstance().getCTipoComprobantesRepository().getByCode(code);
       if(CTipoComprobante != null){            
           throw new CTipoComprobantesValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new CTipoComprobantesValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new CTipoComprobantesValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new CTipoComprobantesValidatorsExceptions().getCodeException();
       }

       final CTipoComprobante CTipoComprobante = (CTipoComprobante) RepositoryFactory.getInstance().getCTipoComprobantesRepository().getByCode(code);
       if(CTipoComprobante == null){            
           throw new CTipoComprobantesValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new CTipoComprobantesValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}