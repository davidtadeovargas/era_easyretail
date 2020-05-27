package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.ImpuestosXComprasValidatorsExceptions;
import com.era.models.ImpuestosXCompra;
import com.era.repositories.RepositoryFactory;

public class ImpuestosXComprasValidator extends IValidate{

   private String code;
   private String fvenc;
   private String total;

   @Override
   public void validateInsert() throws Exception {

       if(fvenc==null || fvenc.isEmpty()){
           throw new ImpuestosXComprasValidatorsExceptions().getFvencException();
       }

       if(total==null || total.isEmpty()){
           throw new ImpuestosXComprasValidatorsExceptions().getTotalException();
       }

       final ImpuestosXCompra ImpuestosXCompra = (ImpuestosXCompra) RepositoryFactory.getInstance().getImpuestosXComprasRepository().getByCode(code);
       if(ImpuestosXCompra != null){            
           throw new ImpuestosXComprasValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new ImpuestosXComprasValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new ImpuestosXComprasValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new ImpuestosXComprasValidatorsExceptions().getCodeException();
       }

       final ImpuestosXCompra ImpuestosXCompra = (ImpuestosXCompra) RepositoryFactory.getInstance().getImpuestosXComprasRepository().getByCode(code);
       if(ImpuestosXCompra == null){            
           throw new ImpuestosXComprasValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new ImpuestosXComprasValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}