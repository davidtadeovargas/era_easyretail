package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.ZonasValidatorsExceptions;
import com.era.models.Zona;
import com.era.repositories.RepositoryFactory;

public class ZonasValidator extends IValidate{

   private String code;
   private String cod;
   private String descrip;

   @Override
   public void validateInsert() throws Exception {

       if(cod==null || cod.isEmpty()){
           throw new ZonasValidatorsExceptions().getCodException();
       }

       if(descrip==null || descrip.isEmpty()){
           throw new ZonasValidatorsExceptions().getDescripException();
       }

       final Zona Zona = (Zona) RepositoryFactory.getInstance().getZonasRepository().getByCode(code);
       if(Zona != null){            
           throw new ZonasValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new ZonasValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new ZonasValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new ZonasValidatorsExceptions().getCodeException();
       }

       final Zona Zona = (Zona) RepositoryFactory.getInstance().getZonasRepository().getByCode(code);
       if(Zona == null){            
           throw new ZonasValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new ZonasValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}