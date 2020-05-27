package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.ClasificacionsValidatorsExceptions;
import com.era.models.Clasificacion;
import com.era.repositories.RepositoryFactory;

public class ClasificacionsValidator extends IValidate{

   private String code;
   private String cod;
   private String descrip;

   @Override
   public void validateInsert() throws Exception {

       if(cod==null || cod.isEmpty()){
           throw new ClasificacionsValidatorsExceptions().getCodException();
       }

       if(descrip==null || descrip.isEmpty()){
           throw new ClasificacionsValidatorsExceptions().getDescripException();
       }

       final Clasificacion Clasificacion = (Clasificacion) RepositoryFactory.getInstance().getClasificacionsRepository().getByCode(code);
       if(Clasificacion != null){            
           throw new ClasificacionsValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new ClasificacionsValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new ClasificacionsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new ClasificacionsValidatorsExceptions().getCodeException();
       }

       final Clasificacion Clasificacion = (Clasificacion) RepositoryFactory.getInstance().getClasificacionsRepository().getByCode(code);
       if(Clasificacion == null){            
           throw new ClasificacionsValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new ClasificacionsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}