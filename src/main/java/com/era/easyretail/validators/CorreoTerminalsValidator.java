package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.CorreoTerminalsValidatorsExceptions;
import com.era.models.CorreoTerminal;
import com.era.repositories.RepositoryFactory;

public class CorreoTerminalsValidator extends IValidate{

   private String contra;
   public void setContra(String property){
       this.contra = property;
   }

   private String correo;
   public void setCorreo(String property){
       this.correo = property;
   }

   private String correoA;
   public void setCorreoA(String property){
       this.correoA = property;
   }

   private String direccionserver;
   public void setDireccionserver(String property){
       this.direccionserver = property;
   }

   private String muestracomo;
   public void setMuestracomo(String property){
       this.muestracomo = property;
   }

   private String puerto;
   public void setPuerto(String property){
       this.puerto = property;
   }


   @Override
   public void validateInsert() throws Exception {

       if(contra==null || contra.isEmpty()){
           throw new CorreoTerminalsValidatorsExceptions().getContraException();
       }

       if(correo==null || correo.isEmpty()){
           throw new CorreoTerminalsValidatorsExceptions().getCorreoException();
       }

       if(correoA==null || correoA.isEmpty()){
           throw new CorreoTerminalsValidatorsExceptions().getCorreoAException();
       }

       if(direccionserver==null || direccionserver.isEmpty()){
           throw new CorreoTerminalsValidatorsExceptions().getDireccionserverException();
       }

       if(muestracomo==null || muestracomo.isEmpty()){
           throw new CorreoTerminalsValidatorsExceptions().getMuestracomoException();
       }

       if(puerto==null || puerto.isEmpty()){
           throw new CorreoTerminalsValidatorsExceptions().getPuertoException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new CorreoTerminalsValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new CorreoTerminalsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

}