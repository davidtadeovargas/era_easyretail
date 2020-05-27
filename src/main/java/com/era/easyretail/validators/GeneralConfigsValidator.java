package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.GeneralConfigsValidatorsExceptions;
import com.era.models.GeneralConfig;
import com.era.repositories.RepositoryFactory;

public class GeneralConfigsValidator extends IValidate{

   private String code;
   private String cashNumber;
   private String casification;
   private String configuration;
   private String extra;
   private String numext;
   private String station;
   private String sucursal;
   private String value;

   @Override
   public void validateInsert() throws Exception {

       if(cashNumber==null || cashNumber.isEmpty()){
           throw new GeneralConfigsValidatorsExceptions().getCashNumberException();
       }

       if(casification==null || casification.isEmpty()){
           throw new GeneralConfigsValidatorsExceptions().getCasificationException();
       }

       if(configuration==null || configuration.isEmpty()){
           throw new GeneralConfigsValidatorsExceptions().getConfigurationException();
       }

       if(extra==null || extra.isEmpty()){
           throw new GeneralConfigsValidatorsExceptions().getExtraException();
       }

       if(numext==null || numext.isEmpty()){
           throw new GeneralConfigsValidatorsExceptions().getNumextException();
       }

       if(station==null || station.isEmpty()){
           throw new GeneralConfigsValidatorsExceptions().getStationException();
       }

       if(sucursal==null || sucursal.isEmpty()){
           throw new GeneralConfigsValidatorsExceptions().getSucursalException();
       }

       if(value==null || value.isEmpty()){
           throw new GeneralConfigsValidatorsExceptions().getValueException();
       }

       final GeneralConfig GeneralConfig = (GeneralConfig) RepositoryFactory.getInstance().getGeneralConfigsRepository().getByCode(code);
       if(GeneralConfig != null){            
           throw new GeneralConfigsValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new GeneralConfigsValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new GeneralConfigsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new GeneralConfigsValidatorsExceptions().getCodeException();
       }

       final GeneralConfig GeneralConfig = (GeneralConfig) RepositoryFactory.getInstance().getGeneralConfigsRepository().getByCode(code);
       if(GeneralConfig == null){            
           throw new GeneralConfigsValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new GeneralConfigsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}