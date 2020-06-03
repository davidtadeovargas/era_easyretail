package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.BancosValidatorsExceptions;
import com.era.models.Banco;
import com.era.repositories.RepositoryFactory;

public class BancosValidator extends IValidate{

   private String cuentabanco;
   public void setCuentabanco(String property){
       this.cuentabanco = property;
   }

   private String descrip;
   public void setDescrip(String property){
       this.descrip = property;
   }


   @Override
   public void validateInsert() throws Exception {

       if(cuentabanco==null || cuentabanco.isEmpty()){
           throw new BancosValidatorsExceptions().getCuentabancoException();
       }

       if(descrip==null || descrip.isEmpty()){
           throw new BancosValidatorsExceptions().getDescripException();
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

}