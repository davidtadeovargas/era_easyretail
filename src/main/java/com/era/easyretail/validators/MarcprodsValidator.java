package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.MarcprodsValidatorsExceptions;
import com.era.models.Marcprod;
import com.era.repositories.RepositoryFactory;

public class MarcprodsValidator extends IValidate{

   private String marc;
   public void setMarc(String property){
       this.marc = property;
   }

   private String prod;
   public void setProd(String property){
       this.prod = property;
   }


   @Override
   public void validateInsert() throws Exception {

       if(marc==null || marc.isEmpty()){
           throw new MarcprodsValidatorsExceptions().getMarcException();
       }

       if(prod==null || prod.isEmpty()){
           throw new MarcprodsValidatorsExceptions().getProdException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new MarcprodsValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new MarcprodsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

}