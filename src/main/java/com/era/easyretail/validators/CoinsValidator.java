package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.CoinsValidatorsExceptions;
import com.era.models.Coin;
import com.era.repositories.RepositoryFactory;

public class CoinsValidator extends IValidate{

   private String code;
   private String c_moneda;
   private String cashNumber;
   private String description;
   private String simbol;
   private String station;
   private String sucursal;

   @Override
   public void validateInsert() throws Exception {

       if(c_moneda==null || c_moneda.isEmpty()){
           throw new CoinsValidatorsExceptions().getC_monedaException();
       }

       if(cashNumber==null || cashNumber.isEmpty()){
           throw new CoinsValidatorsExceptions().getCashNumberException();
       }

       if(code==null || code.isEmpty()){
           throw new CoinsValidatorsExceptions().getCodeException();
       }

       if(description==null || description.isEmpty()){
           throw new CoinsValidatorsExceptions().getDescriptionException();
       }

       if(simbol==null || simbol.isEmpty()){
           throw new CoinsValidatorsExceptions().getSimbolException();
       }

       if(station==null || station.isEmpty()){
           throw new CoinsValidatorsExceptions().getStationException();
       }

       if(sucursal==null || sucursal.isEmpty()){
           throw new CoinsValidatorsExceptions().getSucursalException();
       }

       final Coin Coin = (Coin) RepositoryFactory.getInstance().getCoinsRepository().getByCode(code);
       if(Coin != null){            
           throw new CoinsValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new CoinsValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new CoinsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new CoinsValidatorsExceptions().getCodeException();
       }

       final Coin Coin = (Coin) RepositoryFactory.getInstance().getCoinsRepository().getByCode(code);
       if(Coin == null){            
           throw new CoinsValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new CoinsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}