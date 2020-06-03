package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.BasDatssValidatorsExceptions;
import com.era.models.BasDats;
import com.era.repositories.RepositoryFactory;

public class BasDatssValidator extends IValidate{

   private String codemp;
   public void setCodemp(String property){
       this.codemp = property;
   }

   private String nom;
   public void setNom(String property){
       this.nom = property;
   }


   @Override
   public void validateInsert() throws Exception {

       if(codemp==null || codemp.isEmpty()){
           throw new BasDatssValidatorsExceptions().getCodempException();
       }

       if(nom==null || nom.isEmpty()){
           throw new BasDatssValidatorsExceptions().getNomException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new BasDatssValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new BasDatssValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

}