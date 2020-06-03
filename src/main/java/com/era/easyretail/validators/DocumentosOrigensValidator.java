package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.DocumentosOrigensValidatorsExceptions;
import com.era.models.DocumentosOrigen;
import com.era.repositories.RepositoryFactory;

public class DocumentosOrigensValidator extends IValidate{

   private String nombre;
   public void setNombre(String property){
       this.nombre = property;
   }

   private String tipo;
   public void setTipo(String property){
       this.tipo = property;
   }


   @Override
   public void validateInsert() throws Exception {

       if(nombre==null || nombre.isEmpty()){
           throw new DocumentosOrigensValidatorsExceptions().getNombreException();
       }

       if(tipo==null || tipo.isEmpty()){
           throw new DocumentosOrigensValidatorsExceptions().getTipoException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new DocumentosOrigensValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new DocumentosOrigensValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

}