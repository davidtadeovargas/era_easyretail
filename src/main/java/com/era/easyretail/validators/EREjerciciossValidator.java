package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.EREjerciciossValidatorsExceptions;
import com.era.models.EREjercicios;
import com.era.repositories.RepositoryFactory;

public class EREjerciciossValidator extends IValidate{

   private String code;
   private String ejercicio;
   private String fechaInicio;

   @Override
   public void validateInsert() throws Exception {

       if(ejercicio==null || ejercicio.isEmpty()){
           throw new EREjerciciossValidatorsExceptions().getEjercicioException();
       }

       if(fechaInicio==null || fechaInicio.isEmpty()){
           throw new EREjerciciossValidatorsExceptions().getFechaInicioException();
       }

       final EREjercicios EREjercicios = (EREjercicios) RepositoryFactory.getInstance().getEREjerciciossRepository().getByCode(code);
       if(EREjercicios != null){            
           throw new EREjerciciossValidatorsExceptions().getModelExistsException();
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

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new EREjerciciossValidatorsExceptions().getCodeException();
       }

       final EREjercicios EREjercicios = (EREjercicios) RepositoryFactory.getInstance().getEREjerciciossRepository().getByCode(code);
       if(EREjercicios == null){            
           throw new EREjerciciossValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new EREjerciciossValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}