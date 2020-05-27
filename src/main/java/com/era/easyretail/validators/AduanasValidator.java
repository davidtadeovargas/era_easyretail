package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.AduanasValidatorsExceptions;
import com.era.models.Aduana;
import com.era.repositories.RepositoryFactory;

public class AduanasValidator extends IValidate{

   private String code;
   private String codigo;
   private String descripcion;

   @Override
   public void validateInsert() throws Exception {

       if(codigo==null || codigo.isEmpty()){
           throw new AduanasValidatorsExceptions().getCodigoException();
       }

       if(descripcion==null || descripcion.isEmpty()){
           throw new AduanasValidatorsExceptions().getDescripcionException();
       }

       final Aduana Aduana = (Aduana) RepositoryFactory.getInstance().getAduanasRepository().getByCode(code);
       if(Aduana != null){            
           throw new AduanasValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new AduanasValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new AduanasValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new AduanasValidatorsExceptions().getCodeException();
       }

       final Aduana Aduana = (Aduana) RepositoryFactory.getInstance().getAduanasRepository().getByCode(code);
       if(Aduana == null){            
           throw new AduanasValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new AduanasValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}