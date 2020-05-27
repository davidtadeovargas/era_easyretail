package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.PerssValidatorsExceptions;
import com.era.models.Pers;
import com.era.repositories.RepositoryFactory;

public class PerssValidator extends IValidate{

   private String code;
   private String fingemp;
   private String fsalemp;
   private String nom;

   @Override
   public void validateInsert() throws Exception {

       if(fingemp==null || fingemp.isEmpty()){
           throw new PerssValidatorsExceptions().getFingempException();
       }

       if(fsalemp==null || fsalemp.isEmpty()){
           throw new PerssValidatorsExceptions().getFsalempException();
       }

       if(nom==null || nom.isEmpty()){
           throw new PerssValidatorsExceptions().getNomException();
       }

       final Pers Pers = (Pers) RepositoryFactory.getInstance().getPerssRepository().getByCode(code);
       if(Pers != null){            
           throw new PerssValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new PerssValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new PerssValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new PerssValidatorsExceptions().getCodeException();
       }

       final Pers Pers = (Pers) RepositoryFactory.getInstance().getPerssRepository().getByCode(code);
       if(Pers == null){            
           throw new PerssValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new PerssValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}