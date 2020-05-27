package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.PartordssValidatorsExceptions;
import com.era.models.Partords;
import com.era.repositories.RepositoryFactory;

public class PartordssValidator extends IValidate{

   private String code;
   private String alma;
   private String cant;
   private String codcot;
   private String codord;
   private String descad;
   private String descrip;
   private String descu;
   private String fent;
   private String impue;
   private String impueval;
   private String mon;
   private String prod;
   private String unid;

   @Override
   public void validateInsert() throws Exception {

       if(alma==null || alma.isEmpty()){
           throw new PartordssValidatorsExceptions().getAlmaException();
       }

       if(cant==null || cant.isEmpty()){
           throw new PartordssValidatorsExceptions().getCantException();
       }

       if(codcot==null || codcot.isEmpty()){
           throw new PartordssValidatorsExceptions().getCodcotException();
       }

       if(codord==null || codord.isEmpty()){
           throw new PartordssValidatorsExceptions().getCodordException();
       }

       if(descad==null || descad.isEmpty()){
           throw new PartordssValidatorsExceptions().getDescadException();
       }

       if(descrip==null || descrip.isEmpty()){
           throw new PartordssValidatorsExceptions().getDescripException();
       }

       if(descu==null || descu.isEmpty()){
           throw new PartordssValidatorsExceptions().getDescuException();
       }

       if(fent==null || fent.isEmpty()){
           throw new PartordssValidatorsExceptions().getFentException();
       }

       if(impue==null || impue.isEmpty()){
           throw new PartordssValidatorsExceptions().getImpueException();
       }

       if(impueval==null || impueval.isEmpty()){
           throw new PartordssValidatorsExceptions().getImpuevalException();
       }

       if(mon==null || mon.isEmpty()){
           throw new PartordssValidatorsExceptions().getMonException();
       }

       if(prod==null || prod.isEmpty()){
           throw new PartordssValidatorsExceptions().getProdException();
       }

       if(unid==null || unid.isEmpty()){
           throw new PartordssValidatorsExceptions().getUnidException();
       }

       final Partords Partords = (Partords) RepositoryFactory.getInstance().getPartordssRepository().getByCode(code);
       if(Partords != null){            
           throw new PartordssValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new PartordssValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new PartordssValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new PartordssValidatorsExceptions().getCodeException();
       }

       final Partords Partords = (Partords) RepositoryFactory.getInstance().getPartordssRepository().getByCode(code);
       if(Partords == null){            
           throw new PartordssValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new PartordssValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}