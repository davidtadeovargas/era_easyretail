package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.MetogoPagosValidatorsExceptions;
import com.era.models.MetogoPago;
import com.era.repositories.RepositoryFactory;

public class MetogoPagosValidator extends IValidate{

   private String code;
   private String chasNumber;
   private String description;
   private String station;
   private String sucursal;

   @Override
   public void validateInsert() throws Exception {

       if(chasNumber==null || chasNumber.isEmpty()){
           throw new MetogoPagosValidatorsExceptions().getChasNumberException();
       }

       if(code==null || code.isEmpty()){
           throw new MetogoPagosValidatorsExceptions().getCodeException();
       }

       if(description==null || description.isEmpty()){
           throw new MetogoPagosValidatorsExceptions().getDescriptionException();
       }

       if(station==null || station.isEmpty()){
           throw new MetogoPagosValidatorsExceptions().getStationException();
       }

       if(sucursal==null || sucursal.isEmpty()){
           throw new MetogoPagosValidatorsExceptions().getSucursalException();
       }

       final MetogoPago MetogoPago = (MetogoPago) RepositoryFactory.getInstance().getMetogoPagosRepository().getByCode(code);
       if(MetogoPago != null){            
           throw new MetogoPagosValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new MetogoPagosValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new MetogoPagosValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new MetogoPagosValidatorsExceptions().getCodeException();
       }

       final MetogoPago MetogoPago = (MetogoPago) RepositoryFactory.getInstance().getMetogoPagosRepository().getByCode(code);
       if(MetogoPago == null){            
           throw new MetogoPagosValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new MetogoPagosValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}