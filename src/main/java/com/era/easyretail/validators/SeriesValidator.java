package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.SeriesValidatorsExceptions;
import com.era.models.Serie;
import com.era.repositories.RepositoryFactory;

public class SeriesValidator extends IValidate{

   private String code;
   private String cashNumber;
   private String consecutive;
   private String description;
   private String estation;
   private String serie;
   private String sucursal;
   private String type;

   @Override
   public void validateInsert() throws Exception {

       if(cashNumber==null || cashNumber.isEmpty()){
           throw new SeriesValidatorsExceptions().getCashNumberException();
       }

       if(consecutive==null || consecutive.isEmpty()){
           throw new SeriesValidatorsExceptions().getConsecutiveException();
       }

       if(description==null || description.isEmpty()){
           throw new SeriesValidatorsExceptions().getDescriptionException();
       }

       if(estation==null || estation.isEmpty()){
           throw new SeriesValidatorsExceptions().getEstationException();
       }

       if(serie==null || serie.isEmpty()){
           throw new SeriesValidatorsExceptions().getSerieException();
       }

       if(sucursal==null || sucursal.isEmpty()){
           throw new SeriesValidatorsExceptions().getSucursalException();
       }

       if(type==null || type.isEmpty()){
           throw new SeriesValidatorsExceptions().getTypeException();
       }

       final Serie Serie = (Serie) RepositoryFactory.getInstance().getSeriesRepository().getByCode(code);
       if(Serie != null){            
           throw new SeriesValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new SeriesValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new SeriesValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new SeriesValidatorsExceptions().getCodeException();
       }

       final Serie Serie = (Serie) RepositoryFactory.getInstance().getSeriesRepository().getByCode(code);
       if(Serie == null){            
           throw new SeriesValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new SeriesValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}