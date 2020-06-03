package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.CFDIRelacionadosPagosValidatorsExceptions;
import com.era.models.CFDIRelacionadosPago;
import com.era.repositories.RepositoryFactory;

public class CFDIRelacionadosPagosValidator extends IValidate{

   private String tipo_relacion;
   public void setTipo_relacion(String property){
       this.tipo_relacion = property;
   }

   private String uuid;
   public void setUuid(String property){
       this.uuid = property;
   }


   @Override
   public void validateInsert() throws Exception {

       if(tipo_relacion==null || tipo_relacion.isEmpty()){
           throw new CFDIRelacionadosPagosValidatorsExceptions().getTipo_relacionException();
       }

       if(uuid==null || uuid.isEmpty()){
           throw new CFDIRelacionadosPagosValidatorsExceptions().getUuidException();
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

}