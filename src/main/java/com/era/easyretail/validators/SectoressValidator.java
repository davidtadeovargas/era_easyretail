package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.SectoressValidatorsExceptions;
import com.era.models.Sectores;
import com.era.repositories.RepositoryFactory;

public class SectoressValidator extends IValidate{

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
           throw new SectoressValidatorsExceptions().getCodeException();
       }

       if(descripcion==null || descripcion.isEmpty()){
           throw new SectoressValidatorsExceptions().getDescripcionException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new SectoressValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new SectoressValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

}