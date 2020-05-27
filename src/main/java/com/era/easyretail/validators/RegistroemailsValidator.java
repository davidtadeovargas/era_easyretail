package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.RegistroemailsValidatorsExceptions;
import com.era.models.Registroemail;
import com.era.repositories.RepositoryFactory;

public class RegistroemailsValidator extends IValidate{

   private String code;
   private String cambiada_fecha;
   private String contra;
   private String correo;
   private String generada_fecha;
   private String ya_entro_booleano;

   @Override
   public void validateInsert() throws Exception {

       if(cambiada_fecha==null || cambiada_fecha.isEmpty()){
           throw new RegistroemailsValidatorsExceptions().getCambiada_fechaException();
       }

       if(contra==null || contra.isEmpty()){
           throw new RegistroemailsValidatorsExceptions().getContraException();
       }

       if(correo==null || correo.isEmpty()){
           throw new RegistroemailsValidatorsExceptions().getCorreoException();
       }

       if(generada_fecha==null || generada_fecha.isEmpty()){
           throw new RegistroemailsValidatorsExceptions().getGenerada_fechaException();
       }

       if(ya_entro_booleano==null || ya_entro_booleano.isEmpty()){
           throw new RegistroemailsValidatorsExceptions().getYa_entro_booleanoException();
       }

       final Registroemail Registroemail = (Registroemail) RepositoryFactory.getInstance().getRegistroemailsRepository().getByCode(code);
       if(Registroemail != null){            
           throw new RegistroemailsValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new RegistroemailsValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new RegistroemailsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new RegistroemailsValidatorsExceptions().getCodeException();
       }

       final Registroemail Registroemail = (Registroemail) RepositoryFactory.getInstance().getRegistroemailsRepository().getByCode(code);
       if(Registroemail == null){            
           throw new RegistroemailsValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new RegistroemailsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}