package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.EstadiscorsValidatorsExceptions;
import com.era.models.Estadiscor;
import com.era.repositories.RepositoryFactory;

public class EstadiscorsValidator extends IValidate{

   private String code;
   private String corr;
   private String corrde;
   private String estad;
   private String motiv;
   private String nodoc;
   private String tipdoc;

   @Override
   public void validateInsert() throws Exception {

       if(corr==null || corr.isEmpty()){
           throw new EstadiscorsValidatorsExceptions().getCorrException();
       }

       if(corrde==null || corrde.isEmpty()){
           throw new EstadiscorsValidatorsExceptions().getCorrdeException();
       }

       if(estad==null || estad.isEmpty()){
           throw new EstadiscorsValidatorsExceptions().getEstadException();
       }

       if(motiv==null || motiv.isEmpty()){
           throw new EstadiscorsValidatorsExceptions().getMotivException();
       }

       if(nodoc==null || nodoc.isEmpty()){
           throw new EstadiscorsValidatorsExceptions().getNodocException();
       }

       if(tipdoc==null || tipdoc.isEmpty()){
           throw new EstadiscorsValidatorsExceptions().getTipdocException();
       }

       final Estadiscor Estadiscor = (Estadiscor) RepositoryFactory.getInstance().getEstadiscorsRepository().getByCode(code);
       if(Estadiscor != null){            
           throw new EstadiscorsValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new EstadiscorsValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new EstadiscorsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new EstadiscorsValidatorsExceptions().getCodeException();
       }

       final Estadiscor Estadiscor = (Estadiscor) RepositoryFactory.getInstance().getEstadiscorsRepository().getByCode(code);
       if(Estadiscor == null){            
           throw new EstadiscorsValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new EstadiscorsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}