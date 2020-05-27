package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.GirosValidatorsExceptions;
import com.era.models.Giro;
import com.era.repositories.RepositoryFactory;

public class GirosValidator extends IValidate{

   private String code;
   private String descrip;
   private String gir;

   @Override
   public void validateInsert() throws Exception {

       if(descrip==null || descrip.isEmpty()){
           throw new GirosValidatorsExceptions().getDescripException();
       }

       if(gir==null || gir.isEmpty()){
           throw new GirosValidatorsExceptions().getGirException();
       }

       final Giro Giro = (Giro) RepositoryFactory.getInstance().getGirosRepository().getByCode(code);
       if(Giro != null){            
           throw new GirosValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new GirosValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new GirosValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new GirosValidatorsExceptions().getCodeException();
       }

       final Giro Giro = (Giro) RepositoryFactory.getInstance().getGirosRepository().getByCode(code);
       if(Giro == null){            
           throw new GirosValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new GirosValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}