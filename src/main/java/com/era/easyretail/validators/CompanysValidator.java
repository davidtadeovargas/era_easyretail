package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.CompanysValidatorsExceptions;

public class CompanysValidator extends IValidate{

   private String companyCode;
   public void setCompanyCode(String property){
       this.companyCode = property;
   }

   private String nom;
   public void setNom(String property){
       this.nom = property;
   }
   
   private String RFC;
   public void setRFC(String property){
       this.RFC = property;
   }


   @Override
   public void validateInsert() throws Exception {

       if(companyCode==null || companyCode.isEmpty()){
           throw new CompanysValidatorsExceptions().getCompanyCodeException();
       }

       if(nom==null || nom.isEmpty()){
           throw new CompanysValidatorsExceptions().getNomException();
       }

       if(RFC==null || RFC.isEmpty()){
           throw new CompanysValidatorsExceptions().getRFCVaidationException();
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