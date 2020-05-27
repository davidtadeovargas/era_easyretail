package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.TerprodcompasValidatorsExceptions;
import com.era.models.Terprodcompa;
import com.era.repositories.RepositoryFactory;

public class TerprodcompasValidator extends IValidate{

   private String code;
   private String marc;
   private String model;
   private String prod;
   private String rut;

   @Override
   public void validateInsert() throws Exception {

       if(marc==null || marc.isEmpty()){
           throw new TerprodcompasValidatorsExceptions().getMarcException();
       }

       if(model==null || model.isEmpty()){
           throw new TerprodcompasValidatorsExceptions().getModelException();
       }

       if(prod==null || prod.isEmpty()){
           throw new TerprodcompasValidatorsExceptions().getProdException();
       }

       if(rut==null || rut.isEmpty()){
           throw new TerprodcompasValidatorsExceptions().getRutException();
       }

       final Terprodcompa Terprodcompa = (Terprodcompa) RepositoryFactory.getInstance().getTerprodcompasRepository().getByCode(code);
       if(Terprodcompa != null){            
           throw new TerprodcompasValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new TerprodcompasValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new TerprodcompasValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new TerprodcompasValidatorsExceptions().getCodeException();
       }

       final Terprodcompa Terprodcompa = (Terprodcompa) RepositoryFactory.getInstance().getTerprodcompasRepository().getByCode(code);
       if(Terprodcompa == null){            
           throw new TerprodcompasValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new TerprodcompasValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}