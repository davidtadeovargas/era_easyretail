package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.AsocdescsValidatorsExceptions;
import com.era.models.Asocdesc;
import com.era.repositories.RepositoryFactory;

public class AsocdescsValidator extends IValidate{

   private String code;
   private String clas;
   private String clasjera;
   private String clien;
   private String prod;
   private String usar;

   @Override
   public void validateInsert() throws Exception {

       if(clas==null || clas.isEmpty()){
           throw new AsocdescsValidatorsExceptions().getClasException();
       }

       if(clasjera==null || clasjera.isEmpty()){
           throw new AsocdescsValidatorsExceptions().getClasjeraException();
       }

       if(clien==null || clien.isEmpty()){
           throw new AsocdescsValidatorsExceptions().getClienException();
       }

       if(prod==null || prod.isEmpty()){
           throw new AsocdescsValidatorsExceptions().getProdException();
       }

       if(usar==null || usar.isEmpty()){
           throw new AsocdescsValidatorsExceptions().getUsarException();
       }

       final Asocdesc Asocdesc = (Asocdesc) RepositoryFactory.getInstance().getAsocdescsRepository().getByCode(code);
       if(Asocdesc != null){            
           throw new AsocdescsValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new AsocdescsValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new AsocdescsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new AsocdescsValidatorsExceptions().getCodeException();
       }

       final Asocdesc Asocdesc = (Asocdesc) RepositoryFactory.getInstance().getAsocdescsRepository().getByCode(code);
       if(Asocdesc == null){            
           throw new AsocdescsValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new AsocdescsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}