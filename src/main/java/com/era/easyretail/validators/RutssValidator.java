package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.RutssValidatorsExceptions;
import com.era.models.Ruts;
import com.era.repositories.RepositoryFactory;

public class RutssValidator extends IValidate{

   private String code;
   private String nom;
   private String program;
   private String rut;

   @Override
   public void validateInsert() throws Exception {

       if(nom==null || nom.isEmpty()){
           throw new RutssValidatorsExceptions().getNomException();
       }

       if(program==null || program.isEmpty()){
           throw new RutssValidatorsExceptions().getProgramException();
       }

       if(rut==null || rut.isEmpty()){
           throw new RutssValidatorsExceptions().getRutException();
       }

       final Ruts Ruts = (Ruts) RepositoryFactory.getInstance().getRutssRepository().getByCode(code);
       if(Ruts != null){            
           throw new RutssValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new RutssValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new RutssValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new RutssValidatorsExceptions().getCodeException();
       }

       final Ruts Ruts = (Ruts) RepositoryFactory.getInstance().getRutssRepository().getByCode(code);
       if(Ruts == null){            
           throw new RutssValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new RutssValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}