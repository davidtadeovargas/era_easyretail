package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.CompanysValidatorsExceptions;
import com.era.models.Company;
import com.era.repositories.RepositoryFactory;

public class CompanysValidator extends IValidate{

   private String code;
   private String appPath;
   private String companyCode;
   private String nom;

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

       final Company Company = (Company) RepositoryFactory.getInstance().getCompanysRepository().getByCode(code);
       if(Company != null){            
           throw new CompanysValidatorsExceptions().getModelExistsException();
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

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new CompanysValidatorsExceptions().getCodeException();
       }

       final Company Company = (Company) RepositoryFactory.getInstance().getCompanysRepository().getByCode(code);
       if(Company == null){            
           throw new CompanysValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new CompanysValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}