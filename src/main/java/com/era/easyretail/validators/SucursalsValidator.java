package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.SucursalsValidatorsExceptions;
import com.era.models.Sucursal;
import com.era.repositories.RepositoryFactory;

public class SucursalsValidator extends IValidate{

   private String code;
   private String cod;
   private String codZona;
   private String descrip;

   @Override
   public void validateInsert() throws Exception {

       if(cod==null || cod.isEmpty()){
           throw new SucursalsValidatorsExceptions().getCodException();
       }

       if(codZona==null || codZona.isEmpty()){
           throw new SucursalsValidatorsExceptions().getCodZonaException();
       }

       if(descrip==null || descrip.isEmpty()){
           throw new SucursalsValidatorsExceptions().getDescripException();
       }

       final Sucursal Sucursal = (Sucursal) RepositoryFactory.getInstance().getSucursalsRepository().getByCode(code);
       if(Sucursal != null){            
           throw new SucursalsValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new SucursalsValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new SucursalsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new SucursalsValidatorsExceptions().getCodeException();
       }

       final Sucursal Sucursal = (Sucursal) RepositoryFactory.getInstance().getSucursalsRepository().getByCode(code);
       if(Sucursal == null){            
           throw new SucursalsValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new SucursalsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}