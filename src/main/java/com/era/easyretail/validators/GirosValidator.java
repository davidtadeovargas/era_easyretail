package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.GirosValidatorsExceptions;
import com.era.models.Giro;
import com.era.repositories.RepositoryFactory;

public class GirosValidator extends IValidate{

   private String descrip;
   public void setDescrip(String property){
       this.descrip = property;
   }

   private String gir;
   public void setGir(String property){
       this.gir = property;
   }


   @Override
   public void validateInsert() throws Exception {

       if(descrip==null || descrip.isEmpty()){
           throw new GirosValidatorsExceptions().getDescripException();
       }

       if(gir==null || gir.isEmpty()){
           throw new GirosValidatorsExceptions().getGirException();
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

}