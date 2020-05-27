package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.CumplesValidatorsExceptions;
import com.era.models.Cumple;
import com.era.repositories.RepositoryFactory;

public class CumplesValidator extends IValidate{

   private String code;
   private String a;
   private String codemp;
   private String de;
   private String estad;
   private String fcumple;
   private String fhoy;
   private String ser;
   private String usuario;

   @Override
   public void validateInsert() throws Exception {

       if(a==null || a.isEmpty()){
           throw new CumplesValidatorsExceptions().getAException();
       }

       if(codemp==null || codemp.isEmpty()){
           throw new CumplesValidatorsExceptions().getCodempException();
       }

       if(de==null || de.isEmpty()){
           throw new CumplesValidatorsExceptions().getDeException();
       }

       if(estad==null || estad.isEmpty()){
           throw new CumplesValidatorsExceptions().getEstadException();
       }

       if(fcumple==null || fcumple.isEmpty()){
           throw new CumplesValidatorsExceptions().getFcumpleException();
       }

       if(fhoy==null || fhoy.isEmpty()){
           throw new CumplesValidatorsExceptions().getFhoyException();
       }

       if(ser==null || ser.isEmpty()){
           throw new CumplesValidatorsExceptions().getSerException();
       }

       if(usuario==null || usuario.isEmpty()){
           throw new CumplesValidatorsExceptions().getUsuarioException();
       }

       final Cumple Cumple = (Cumple) RepositoryFactory.getInstance().getCumplesRepository().getByCode(code);
       if(Cumple != null){            
           throw new CumplesValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new CumplesValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new CumplesValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new CumplesValidatorsExceptions().getCodeException();
       }

       final Cumple Cumple = (Cumple) RepositoryFactory.getInstance().getCumplesRepository().getByCode(code);
       if(Cumple == null){            
           throw new CumplesValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new CumplesValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}