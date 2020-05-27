package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.DatoscpsValidatorsExceptions;
import com.era.models.Datoscp;
import com.era.repositories.RepositoryFactory;

public class DatoscpsValidator extends IValidate{

   private String code;
   private String vta;

   @Override
   public void validateInsert() throws Exception {

       if(vta==null || vta.isEmpty()){
           throw new DatoscpsValidatorsExceptions().getVtaException();
       }

       final Datoscp Datoscp = (Datoscp) RepositoryFactory.getInstance().getDatoscpsRepository().getByCode(code);
       if(Datoscp != null){            
           throw new DatoscpsValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new DatoscpsValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new DatoscpsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new DatoscpsValidatorsExceptions().getCodeException();
       }

       final Datoscp Datoscp = (Datoscp) RepositoryFactory.getInstance().getDatoscpsRepository().getByCode(code);
       if(Datoscp == null){            
           throw new DatoscpsValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new DatoscpsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}