package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.CompanysValidatorsExceptions;
import com.era.models.Company;
import com.era.repositories.RepositoryFactory;

public class CompanysValidator extends IValidate{

   private String appPath;
   public void setAppPath(String property){
       this.appPath = property;
   }

   private String companyCode;
   public void setCompanyCode(String property){
       this.companyCode = property;
   }

   private String nom;
   public void setNom(String property){
       this.nom = property;
   }


   @Override
   public void validateInsert() throws Exception {

       if(appPath==null || appPath.isEmpty()){
           throw new CompanysValidatorsExceptions().getAppPathException();
       }

       if(companyCode==null || companyCode.isEmpty()){
           throw new CompanysValidatorsExceptions().getCompanyCodeException();
       }

       if(nom==null || nom.isEmpty()){
           throw new CompanysValidatorsExceptions().getNomException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new CompanysValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new CompanysValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

}