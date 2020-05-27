package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.TarssValidatorsExceptions;
import com.era.models.Tars;
import com.era.repositories.RepositoryFactory;

public class TarssValidator extends IValidate{

   private String code;
   private String cli;
   private String exter;
   private String factur;
   private String factuya;
   private String ffactu;
   private String loc;
   private String pag;
   private String prepag;
   private String tar;

   @Override
   public void validateInsert() throws Exception {

       if(cli==null || cli.isEmpty()){
           throw new TarssValidatorsExceptions().getCliException();
       }

       if(exter==null || exter.isEmpty()){
           throw new TarssValidatorsExceptions().getExterException();
       }

       if(factur==null || factur.isEmpty()){
           throw new TarssValidatorsExceptions().getFacturException();
       }

       if(factuya==null || factuya.isEmpty()){
           throw new TarssValidatorsExceptions().getFactuyaException();
       }

       if(ffactu==null || ffactu.isEmpty()){
           throw new TarssValidatorsExceptions().getFfactuException();
       }

       if(loc==null || loc.isEmpty()){
           throw new TarssValidatorsExceptions().getLocException();
       }

       if(pag==null || pag.isEmpty()){
           throw new TarssValidatorsExceptions().getPagException();
       }

       if(prepag==null || prepag.isEmpty()){
           throw new TarssValidatorsExceptions().getPrepagException();
       }

       if(tar==null || tar.isEmpty()){
           throw new TarssValidatorsExceptions().getTarException();
       }

       final Tars Tars = (Tars) RepositoryFactory.getInstance().getTarssRepository().getByCode(code);
       if(Tars != null){            
           throw new TarssValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new TarssValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new TarssValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new TarssValidatorsExceptions().getCodeException();
       }

       final Tars Tars = (Tars) RepositoryFactory.getInstance().getTarssRepository().getByCode(code);
       if(Tars == null){            
           throw new TarssValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new TarssValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}