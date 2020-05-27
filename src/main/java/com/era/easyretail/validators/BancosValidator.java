package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.BancosValidatorsExceptions;
import com.era.models.Banco;
import com.era.repositories.RepositoryFactory;

public class BancosValidator extends IValidate{

   private String code;
   private String cuentabanco;
   private String descrip;

   @Override
   public void validateInsert() throws Exception {

       if(cuentabanco==null || cuentabanco.isEmpty()){
           throw new BancosValidatorsExceptions().getCuentabancoException();
       }

       if(descrip==null || descrip.isEmpty()){
           throw new BancosValidatorsExceptions().getDescripException();
       }

       final Banco Banco = (Banco) RepositoryFactory.getInstance().getBancosRepository().getByCode(code);
       if(Banco != null){            
           throw new BancosValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new BancosValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new BancosValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new BancosValidatorsExceptions().getCodeException();
       }

       final Banco Banco = (Banco) RepositoryFactory.getInstance().getBancosRepository().getByCode(code);
       if(Banco == null){            
           throw new BancosValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new BancosValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}