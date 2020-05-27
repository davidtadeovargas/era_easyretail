package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.TallcolosValidatorsExceptions;
import com.era.models.Tallcolo;
import com.era.repositories.RepositoryFactory;

public class TallcolosValidator extends IValidate{

   private String code;
   private String alma;
   private String colo;
   private String prod;
   private String tall;

   @Override
   public void validateInsert() throws Exception {

       if(alma==null || alma.isEmpty()){
           throw new TallcolosValidatorsExceptions().getAlmaException();
       }

       if(colo==null || colo.isEmpty()){
           throw new TallcolosValidatorsExceptions().getColoException();
       }

       if(prod==null || prod.isEmpty()){
           throw new TallcolosValidatorsExceptions().getProdException();
       }

       if(tall==null || tall.isEmpty()){
           throw new TallcolosValidatorsExceptions().getTallException();
       }

       final Tallcolo Tallcolo = (Tallcolo) RepositoryFactory.getInstance().getTallcolosRepository().getByCode(code);
       if(Tallcolo != null){            
           throw new TallcolosValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new TallcolosValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new TallcolosValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new TallcolosValidatorsExceptions().getCodeException();
       }

       final Tallcolo Tallcolo = (Tallcolo) RepositoryFactory.getInstance().getTallcolosRepository().getByCode(code);
       if(Tallcolo == null){            
           throw new TallcolosValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new TallcolosValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}