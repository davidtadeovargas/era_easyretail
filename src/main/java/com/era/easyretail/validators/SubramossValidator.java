package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.SubramossValidatorsExceptions;
import com.era.models.Subramos;
import com.era.repositories.RepositoryFactory;

public class SubramossValidator extends IValidate{

   private String code;
   public void setCode(String property){
       this.code = property;
   }

   private String descripcion;
   public void setDescripcion(String property){
       this.descripcion = property;
   }


   @Override
   public void validateInsert() throws Exception {

       if(code==null || code.isEmpty()){
           throw new SubramossValidatorsExceptions().getCodeException();
       }

       if(descripcion==null || descripcion.isEmpty()){
           throw new SubramossValidatorsExceptions().getDescripcionException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new SubramossValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new SubramossValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

}