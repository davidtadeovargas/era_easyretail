package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.CostssValidatorsExceptions;
import com.era.models.Costs;
import com.era.repositories.RepositoryFactory;

public class CostssValidator extends IValidate{

   private String monedaID;
   public void setMonedaID(String property){
       this.monedaID = property;
   }

   private String prod;
   public void setProd(String property){
       this.prod = property;
   }

   private String tipcam;
   public void setTipcam(String property){
       this.tipcam = property;
   }


   @Override
   public void validateInsert() throws Exception {

       if(monedaID==null || monedaID.isEmpty()){
           throw new CostssValidatorsExceptions().getMonedaIDException();
       }

       if(prod==null || prod.isEmpty()){
           throw new CostssValidatorsExceptions().getProdException();
       }

       if(tipcam==null || tipcam.isEmpty()){
           throw new CostssValidatorsExceptions().getTipcamException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new CostssValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new CostssValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

}