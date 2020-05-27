package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.UsuarioseriesValidatorsExceptions;
import com.era.models.Usuarioserie;
import com.era.repositories.RepositoryFactory;

public class UsuarioseriesValidator extends IValidate{

   private String code;

   @Override
   public void validateInsert() throws Exception {

       final Usuarioserie Usuarioserie = (Usuarioserie) RepositoryFactory.getInstance().getUsuarioseriesRepository().getByCode(code);
       if(Usuarioserie != null){            
           throw new UsuarioseriesValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new UsuarioseriesValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new UsuarioseriesValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new UsuarioseriesValidatorsExceptions().getCodeException();
       }

       final Usuarioserie Usuarioserie = (Usuarioserie) RepositoryFactory.getInstance().getUsuarioseriesRepository().getByCode(code);
       if(Usuarioserie == null){            
           throw new UsuarioseriesValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new UsuarioseriesValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}