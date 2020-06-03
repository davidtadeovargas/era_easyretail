package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.AduanasValidatorsExceptions;
import com.era.models.Aduana;
import com.era.repositories.RepositoryFactory;

public class AduanasValidator extends IValidate{

   private String codigo;
   public void setCodigo(String property){
       this.codigo = property;
   }

   private String descripcion;
   public void setDescripcion(String property){
       this.descripcion = property;
   }


   @Override
   public void validateInsert() throws Exception {

       if(codigo==null || codigo.isEmpty()){
           throw new AduanasValidatorsExceptions().getCodigoException();
       }

       if(descripcion==null || descripcion.isEmpty()){
           throw new AduanasValidatorsExceptions().getDescripcionException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new AduanasValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new AduanasValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

}