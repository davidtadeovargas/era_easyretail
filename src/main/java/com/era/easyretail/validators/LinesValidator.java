package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.LinesValidatorsExceptions;
import com.era.models.Line;
import com.era.repositories.RepositoryFactory;

public class LinesValidator extends IValidate{

   private String code;
   private String cashNumber;
   private String description;
   private String station;
   private String sucursal;

   @Override
   public void validateInsert() throws Exception {

       if(cashNumber==null || cashNumber.isEmpty()){
           throw new LinesValidatorsExceptions().getCashNumberException();
       }

       if(code==null || code.isEmpty()){
           throw new LinesValidatorsExceptions().getCodeException();
       }

       if(description==null || description.isEmpty()){
           throw new LinesValidatorsExceptions().getDescriptionException();
       }

       if(station==null || station.isEmpty()){
           throw new LinesValidatorsExceptions().getStationException();
       }

       if(sucursal==null || sucursal.isEmpty()){
           throw new LinesValidatorsExceptions().getSucursalException();
       }

       final Line Line = (Line) RepositoryFactory.getInstance().getLinesRepository().getByCode(code);
       if(Line != null){            
           throw new LinesValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new LinesValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new LinesValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new LinesValidatorsExceptions().getCodeException();
       }

       final Line Line = (Line) RepositoryFactory.getInstance().getLinesRepository().getByCode(code);
       if(Line == null){            
           throw new LinesValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new LinesValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}