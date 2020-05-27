package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.OrdssValidatorsExceptions;
import com.era.models.Ords;
import com.era.repositories.RepositoryFactory;

public class OrdssValidator extends IValidate{

   private String code;
   private String eje;
   private String fent;
   private String prov;
   private String proy;

   @Override
   public void validateInsert() throws Exception {

       if(eje==null || eje.isEmpty()){
           throw new OrdssValidatorsExceptions().getEjeException();
       }

       if(fent==null || fent.isEmpty()){
           throw new OrdssValidatorsExceptions().getFentException();
       }

       if(prov==null || prov.isEmpty()){
           throw new OrdssValidatorsExceptions().getProvException();
       }

       if(proy==null || proy.isEmpty()){
           throw new OrdssValidatorsExceptions().getProyException();
       }

       final Ords Ords = (Ords) RepositoryFactory.getInstance().getOrdssRepository().getByCode(code);
       if(Ords != null){            
           throw new OrdssValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new OrdssValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new OrdssValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new OrdssValidatorsExceptions().getCodeException();
       }

       final Ords Ords = (Ords) RepositoryFactory.getInstance().getOrdssRepository().getByCode(code);
       if(Ords == null){            
           throw new OrdssValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new OrdssValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}