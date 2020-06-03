package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.AsocdescsValidatorsExceptions;
import com.era.models.Asocdesc;
import com.era.repositories.RepositoryFactory;

public class AsocdescsValidator extends IValidate{

   private String clas;
   public void setClas(String property){
       this.clas = property;
   }

   private String clasjera;
   public void setClasjera(String property){
       this.clasjera = property;
   }

   private String clien;
   public void setClien(String property){
       this.clien = property;
   }

   private String prod;
   public void setProd(String property){
       this.prod = property;
   }

   private String usar;
   public void setUsar(String property){
       this.usar = property;
   }


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

}