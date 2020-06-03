package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.CortszxsValidatorsExceptions;
import com.era.models.Cortszx;
import com.era.repositories.RepositoryFactory;

public class CortszxsValidator extends IValidate{

   private String cort;
   public void setCort(String property){
       this.cort = property;
   }

   private String numcort;
   public void setNumcort(String property){
       this.numcort = property;
   }

   private String totvtas;
   public void setTotvtas(String property){
       this.totvtas = property;
   }


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

}