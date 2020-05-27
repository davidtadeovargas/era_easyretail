package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.CortszxsValidatorsExceptions;
import com.era.models.Cortszx;
import com.era.repositories.RepositoryFactory;

public class CortszxsValidator extends IValidate{

   private String code;
   private String cort;
   private String numcort;
   private String totvtas;

   @Override
   public void validateInsert() throws Exception {

       if(cort==null || cort.isEmpty()){
           throw new CortszxsValidatorsExceptions().getCortException();
       }

       if(numcort==null || numcort.isEmpty()){
           throw new CortszxsValidatorsExceptions().getNumcortException();
       }

       if(totvtas==null || totvtas.isEmpty()){
           throw new CortszxsValidatorsExceptions().getTotvtasException();
       }

       final Cortszx Cortszx = (Cortszx) RepositoryFactory.getInstance().getCortszxsRepository().getByCode(code);
       if(Cortszx != null){            
           throw new CortszxsValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new CortszxsValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new CortszxsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new CortszxsValidatorsExceptions().getCodeException();
       }

       final Cortszx Cortszx = (Cortszx) RepositoryFactory.getInstance().getCortszxsRepository().getByCode(code);
       if(Cortszx == null){            
           throw new CortszxsValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new CortszxsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}