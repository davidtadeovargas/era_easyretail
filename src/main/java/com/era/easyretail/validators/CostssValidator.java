package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.CostssValidatorsExceptions;
import com.era.models.Costs;
import com.era.repositories.RepositoryFactory;

public class CostssValidator extends IValidate{

   private String code;
   private String monedaID;
   private String prod;
   private String tipcam;

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

       final Costs Costs = (Costs) RepositoryFactory.getInstance().getCostssRepository().getByCode(code);
       if(Costs != null){            
           throw new CostssValidatorsExceptions().getModelExistsException();
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

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new CostssValidatorsExceptions().getCodeException();
       }

       final Costs Costs = (Costs) RepositoryFactory.getInstance().getCostssRepository().getByCode(code);
       if(Costs == null){            
           throw new CostssValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new CostssValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}