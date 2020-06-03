package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.SerieprodsValidatorsExceptions;
import com.era.models.Serieprod;
import com.era.repositories.RepositoryFactory;

public class SerieprodsValidator extends IValidate{

   private String alma;
   public void setAlma(String property){
       this.alma = property;
   }

   private String comen;
   public void setComen(String property){
       this.comen = property;
   }

   private String prod;
   public void setProd(String property){
       this.prod = property;
   }

   private String ser;
   public void setSer(String property){
       this.ser = property;
   }


   @Override
   public void validateInsert() throws Exception {

       if(alma==null || alma.isEmpty()){
           throw new SerieprodsValidatorsExceptions().getAlmaException();
       }

       if(comen==null || comen.isEmpty()){
           throw new SerieprodsValidatorsExceptions().getComenException();
       }

       if(prod==null || prod.isEmpty()){
           throw new SerieprodsValidatorsExceptions().getProdException();
       }

       if(ser==null || ser.isEmpty()){
           throw new SerieprodsValidatorsExceptions().getSerException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new SerieprodsValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new SerieprodsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

}