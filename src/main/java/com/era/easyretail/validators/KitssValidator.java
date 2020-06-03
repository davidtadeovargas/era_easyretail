package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.KitssValidatorsExceptions;
import com.era.models.Kits;
import com.era.repositories.RepositoryFactory;

public class KitssValidator extends IValidate{

   private String alma;
   public void setAlma(String property){
       this.alma = property;
   }

   private String code;
   public void setCode(String property){
       this.code = property;
   }

   private String prod;
   public void setProd(String property){
       this.prod = property;
   }


   @Override
   public void validateInsert() throws Exception {

       if(alma==null || alma.isEmpty()){
           throw new KitssValidatorsExceptions().getAlmaException();
       }

       if(code==null || code.isEmpty()){
           throw new KitssValidatorsExceptions().getCodeException();
       }

       if(prod==null || prod.isEmpty()){
           throw new KitssValidatorsExceptions().getProdException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new KitssValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new KitssValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

}