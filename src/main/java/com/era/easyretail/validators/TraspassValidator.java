package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.TraspassValidatorsExceptions;
import com.era.models.Traspas;
import com.era.repositories.RepositoryFactory;

public class TraspassValidator extends IValidate{

   private String code;
   private String alma;
   private String almaa;
   private String concep;
   private String prod;
   private String unid;

   @Override
   public void validateInsert() throws Exception {

       if(alma==null || alma.isEmpty()){
           throw new TraspassValidatorsExceptions().getAlmaException();
       }

       if(almaa==null || almaa.isEmpty()){
           throw new TraspassValidatorsExceptions().getAlmaaException();
       }

       if(concep==null || concep.isEmpty()){
           throw new TraspassValidatorsExceptions().getConcepException();
       }

       if(prod==null || prod.isEmpty()){
           throw new TraspassValidatorsExceptions().getProdException();
       }

       if(unid==null || unid.isEmpty()){
           throw new TraspassValidatorsExceptions().getUnidException();
       }

       final Traspas Traspas = (Traspas) RepositoryFactory.getInstance().getTraspassRepository().getByCode(code);
       if(Traspas != null){            
           throw new TraspassValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new TraspassValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new TraspassValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new TraspassValidatorsExceptions().getCodeException();
       }

       final Traspas Traspas = (Traspas) RepositoryFactory.getInstance().getTraspassRepository().getByCode(code);
       if(Traspas == null){            
           throw new TraspassValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new TraspassValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}