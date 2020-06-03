package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.SucursalsValidatorsExceptions;
import com.era.models.Sucursal;
import com.era.repositories.RepositoryFactory;

public class SucursalsValidator extends IValidate{

   private String codZona;
   public void setCodZona(String property){
       this.codZona = property;
   }

   private String code;
   public void setCode(String property){
       this.code = property;
   }

   private String descrip;
   public void setDescrip(String property){
       this.descrip = property;
   }


   @Override
   public void validateInsert() throws Exception {

       if(codZona==null || codZona.isEmpty()){
           throw new SucursalsValidatorsExceptions().getCodZonaException();
       }

       if(code==null || code.isEmpty()){
           throw new SucursalsValidatorsExceptions().getCodeException();
       }

       if(descrip==null || descrip.isEmpty()){
           throw new SucursalsValidatorsExceptions().getDescripException();
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

}