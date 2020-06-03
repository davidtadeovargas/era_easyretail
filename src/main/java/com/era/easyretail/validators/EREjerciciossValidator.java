package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.EREjerciciossValidatorsExceptions;
import com.era.models.EREjercicios;
import com.era.repositories.RepositoryFactory;

public class EREjerciciossValidator extends IValidate{

   private String ejercicio;
   public void setEjercicio(String property){
       this.ejercicio = property;
   }

   private String fechaInicio;
   public void setFechaInicio(String property){
       this.fechaInicio = property;
   }


   @Override
   public void validateInsert() throws Exception {

       if(ejercicio==null || ejercicio.isEmpty()){
           throw new EREjerciciossValidatorsExceptions().getEjercicioException();
       }

       if(fechaInicio==null || fechaInicio.isEmpty()){
           throw new EREjerciciossValidatorsExceptions().getFechaInicioException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new EREjerciciossValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new EREjerciciossValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

}