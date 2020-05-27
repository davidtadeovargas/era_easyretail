package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.CFDIRelacionadosPagosValidatorsExceptions;
import com.era.models.CFDIRelacionadosPago;
import com.era.repositories.RepositoryFactory;

public class CFDIRelacionadosPagosValidator extends IValidate{

   private String code;
   private String tipo_relacion;
   private String uuid;

   @Override
   public void validateInsert() throws Exception {

       if(tipo_relacion==null || tipo_relacion.isEmpty()){
           throw new CFDIRelacionadosPagosValidatorsExceptions().getTipo_relacionException();
       }

       if(uuid==null || uuid.isEmpty()){
           throw new CFDIRelacionadosPagosValidatorsExceptions().getUuidException();
       }

       final CFDIRelacionadosPago CFDIRelacionadosPago = (CFDIRelacionadosPago) RepositoryFactory.getInstance().getCFDIRelacionadosPagosRepository().getByCode(code);
       if(CFDIRelacionadosPago != null){            
           throw new CFDIRelacionadosPagosValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new CFDIRelacionadosPagosValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new CFDIRelacionadosPagosValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new CFDIRelacionadosPagosValidatorsExceptions().getCodeException();
       }

       final CFDIRelacionadosPago CFDIRelacionadosPago = (CFDIRelacionadosPago) RepositoryFactory.getInstance().getCFDIRelacionadosPagosRepository().getByCode(code);
       if(CFDIRelacionadosPago == null){            
           throw new CFDIRelacionadosPagosValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new CFDIRelacionadosPagosValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}