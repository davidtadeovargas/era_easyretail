package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.MeasuresValidatorsExceptions;
import com.era.models.Measure;
import com.era.repositories.RepositoryFactory;

public class MeasuresValidator extends IValidate{

   private String code;
   private String cashNumber;
   private String description;
   private String station;
   private String sucursal;

   @Override
   public void validateInsert() throws Exception {

       if(cashNumber==null || cashNumber.isEmpty()){
           throw new MeasuresValidatorsExceptions().getCashNumberException();
       }

       if(code==null || code.isEmpty()){
           throw new MeasuresValidatorsExceptions().getCodeException();
       }

       if(description==null || description.isEmpty()){
           throw new MeasuresValidatorsExceptions().getDescriptionException();
       }

       if(station==null || station.isEmpty()){
           throw new MeasuresValidatorsExceptions().getStationException();
       }

       if(sucursal==null || sucursal.isEmpty()){
           throw new MeasuresValidatorsExceptions().getSucursalException();
       }

       final Measure Measure = (Measure) RepositoryFactory.getInstance().getMeasuresRepository().getByCode(code);
       if(Measure != null){            
           throw new MeasuresValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new MeasuresValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new MeasuresValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new MeasuresValidatorsExceptions().getCodeException();
       }

       final Measure Measure = (Measure) RepositoryFactory.getInstance().getMeasuresRepository().getByCode(code);
       if(Measure == null){            
           throw new MeasuresValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new MeasuresValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}