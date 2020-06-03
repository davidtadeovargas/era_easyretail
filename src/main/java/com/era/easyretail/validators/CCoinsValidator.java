package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.CCoinsValidatorsExceptions;
import com.era.models.CCoin;
import com.era.repositories.RepositoryFactory;

public class CCoinsValidator extends IValidate{

   private String code;
   public void setCode(String property){
       this.code = property;
   }

   private String initVigencyDate;
   public void setInitVigencyDate(String property){
       this.initVigencyDate = property;
   }

   private String variationPorcent;
   public void setVariationPorcent(String property){
       this.variationPorcent = property;
   }


   @Override
   public void validateInsert() throws Exception {

       if(code==null || code.isEmpty()){
           throw new CCoinsValidatorsExceptions().getCodeException();
       }

       if(initVigencyDate==null || initVigencyDate.isEmpty()){
           throw new CCoinsValidatorsExceptions().getInitVigencyDateException();
       }

       if(variationPorcent==null || variationPorcent.isEmpty()){
           throw new CCoinsValidatorsExceptions().getVariationPorcentException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new CCoinsValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new CCoinsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

}