package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.CorreoTerminalsValidatorsExceptions;
import com.era.models.CorreoTerminal;
import com.era.repositories.RepositoryFactory;

public class CorreoTerminalsValidator extends IValidate{

   private String code;
   private String contra;
   private String correo;
   private String correoA;
   private String direccionserver;
   private String muestracomo;
   private String puerto;

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

       final CorreoTerminal CorreoTerminal = (CorreoTerminal) RepositoryFactory.getInstance().getCorreoTerminalsRepository().getByCode(code);
       if(CorreoTerminal != null){            
           throw new CorreoTerminalsValidatorsExceptions().getModelExistsException();
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

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new CorreoTerminalsValidatorsExceptions().getCodeException();
       }

       final CorreoTerminal CorreoTerminal = (CorreoTerminal) RepositoryFactory.getInstance().getCorreoTerminalsRepository().getByCode(code);
       if(CorreoTerminal == null){            
           throw new CorreoTerminalsValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new CorreoTerminalsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}