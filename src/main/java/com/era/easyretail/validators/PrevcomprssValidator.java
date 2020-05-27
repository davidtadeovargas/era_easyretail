package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.PrevcomprssValidatorsExceptions;
import com.era.models.Prevcomprs;
import com.era.repositories.RepositoryFactory;

public class PrevcomprssValidator extends IValidate{

   private String code;
   private String codprevcomp;
   private String estado;
   private String fvenc;
   private String mon;
   private String motiv;
   private String noser;
   private String nosercomp;
   private String prov;
   private String ser;

   @Override
   public void validateInsert() throws Exception {

       if(codprevcomp==null || codprevcomp.isEmpty()){
           throw new PrevcomprssValidatorsExceptions().getCodprevcompException();
       }

       if(estado==null || estado.isEmpty()){
           throw new PrevcomprssValidatorsExceptions().getEstadoException();
       }

       if(fvenc==null || fvenc.isEmpty()){
           throw new PrevcomprssValidatorsExceptions().getFvencException();
       }

       if(mon==null || mon.isEmpty()){
           throw new PrevcomprssValidatorsExceptions().getMonException();
       }

       if(motiv==null || motiv.isEmpty()){
           throw new PrevcomprssValidatorsExceptions().getMotivException();
       }

       if(noser==null || noser.isEmpty()){
           throw new PrevcomprssValidatorsExceptions().getNoserException();
       }

       if(nosercomp==null || nosercomp.isEmpty()){
           throw new PrevcomprssValidatorsExceptions().getNosercompException();
       }

       if(prov==null || prov.isEmpty()){
           throw new PrevcomprssValidatorsExceptions().getProvException();
       }

       if(ser==null || ser.isEmpty()){
           throw new PrevcomprssValidatorsExceptions().getSerException();
       }

       final Prevcomprs Prevcomprs = (Prevcomprs) RepositoryFactory.getInstance().getPrevcomprssRepository().getByCode(code);
       if(Prevcomprs != null){            
           throw new PrevcomprssValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new PrevcomprssValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new PrevcomprssValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new PrevcomprssValidatorsExceptions().getCodeException();
       }

       final Prevcomprs Prevcomprs = (Prevcomprs) RepositoryFactory.getInstance().getPrevcomprssRepository().getByCode(code);
       if(Prevcomprs == null){            
           throw new PrevcomprssValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new PrevcomprssValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}