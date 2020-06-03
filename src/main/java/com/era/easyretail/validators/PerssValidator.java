package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.PerssValidatorsExceptions;
import com.era.models.Pers;
import com.era.repositories.RepositoryFactory;

public class PerssValidator extends IValidate{

   private String fingemp;
   public void setFingemp(String property){
       this.fingemp = property;
   }

   private String fsalemp;
   public void setFsalemp(String property){
       this.fsalemp = property;
   }

   private String nom;
   public void setNom(String property){
       this.nom = property;
   }


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

}