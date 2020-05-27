package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.SerieprodsValidatorsExceptions;
import com.era.models.Serieprod;
import com.era.repositories.RepositoryFactory;

public class SerieprodsValidator extends IValidate{

   private String code;
   private String alma;
   private String comen;
   private String prod;
   private String ser;

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

       final Serieprod Serieprod = (Serieprod) RepositoryFactory.getInstance().getSerieprodsRepository().getByCode(code);
       if(Serieprod != null){            
           throw new SerieprodsValidatorsExceptions().getModelExistsException();
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

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new SerieprodsValidatorsExceptions().getCodeException();
       }

       final Serieprod Serieprod = (Serieprod) RepositoryFactory.getInstance().getSerieprodsRepository().getByCode(code);
       if(Serieprod == null){            
           throw new SerieprodsValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new SerieprodsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}