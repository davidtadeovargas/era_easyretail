package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.RegistroemailsValidatorsExceptions;
import com.era.models.Registroemail;
import com.era.repositories.RepositoryFactory;

public class RegistroemailsValidator extends IValidate{

   private String cambiada_fecha;
   public void setCambiada_fecha(String property){
       this.cambiada_fecha = property;
   }

   private String contra;
   public void setContra(String property){
       this.contra = property;
   }

   private String correo;
   public void setCorreo(String property){
       this.correo = property;
   }

   private String generada_fecha;
   public void setGenerada_fecha(String property){
       this.generada_fecha = property;
   }

   private String ya_entro_booleano;
   public void setYa_entro_booleano(String property){
       this.ya_entro_booleano = property;
   }


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

}