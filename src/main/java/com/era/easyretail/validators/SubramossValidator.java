package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.SubramossValidatorsExceptions;
import com.era.models.Subramos;
import com.era.repositories.RepositoryFactory;

public class SubramossValidator extends IValidate{

   private String code;
   private String codigo;
   private String descripcion;

   @Override
   public void validateInsert() throws Exception {

       if(codigo==null || codigo.isEmpty()){
           throw new SubramossValidatorsExceptions().getCodigoException();
       }

       if(descripcion==null || descripcion.isEmpty()){
           throw new SubramossValidatorsExceptions().getDescripcionException();
       }

       final Subramos Subramos = (Subramos) RepositoryFactory.getInstance().getSubramossRepository().getByCode(code);
       if(Subramos != null){            
           throw new SubramossValidatorsExceptions().getModelExistsException();
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

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new SubramossValidatorsExceptions().getCodeException();
       }

       final Subramos Subramos = (Subramos) RepositoryFactory.getInstance().getSubramossRepository().getByCode(code);
       if(Subramos == null){            
           throw new SubramossValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new SubramossValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}