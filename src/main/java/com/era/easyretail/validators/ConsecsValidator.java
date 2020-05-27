package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.ConsecsValidatorsExceptions;
import com.era.models.Consec;
import com.era.repositories.RepositoryFactory;

public class ConsecsValidator extends IValidate{

   private String code;
   private String cashNumber;
   private String consec;
   private String description;
   private String serie;
   private String station;
   private String sucursal;
   private String type;

   @Override
   public void validateInsert() throws Exception {

       if(cashNumber==null || cashNumber.isEmpty()){
           throw new ConsecsValidatorsExceptions().getCashNumberException();
       }

       if(consec==null || consec.isEmpty()){
           throw new ConsecsValidatorsExceptions().getConsecException();
       }

       if(description==null || description.isEmpty()){
           throw new ConsecsValidatorsExceptions().getDescriptionException();
       }

       if(serie==null || serie.isEmpty()){
           throw new ConsecsValidatorsExceptions().getSerieException();
       }

       if(station==null || station.isEmpty()){
           throw new ConsecsValidatorsExceptions().getStationException();
       }

       if(sucursal==null || sucursal.isEmpty()){
           throw new ConsecsValidatorsExceptions().getSucursalException();
       }

       if(type==null || type.isEmpty()){
           throw new ConsecsValidatorsExceptions().getTypeException();
       }

       final Consec Consec = (Consec) RepositoryFactory.getInstance().getConsecsRepository().getByCode(code);
       if(Consec != null){            
           throw new ConsecsValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new ConsecsValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new ConsecsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new ConsecsValidatorsExceptions().getCodeException();
       }

       final Consec Consec = (Consec) RepositoryFactory.getInstance().getConsecsRepository().getByCode(code);
       if(Consec == null){            
           throw new ConsecsValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new ConsecsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}