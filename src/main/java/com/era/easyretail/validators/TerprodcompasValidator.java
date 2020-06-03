package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.TerprodcompasValidatorsExceptions;
import com.era.models.Terprodcompa;
import com.era.repositories.RepositoryFactory;

public class TerprodcompasValidator extends IValidate{

   private String marc;
   public void setMarc(String property){
       this.marc = property;
   }

   private String model;
   public void setModel(String property){
       this.model = property;
   }

   private String prod;
   public void setProd(String property){
       this.prod = property;
   }

   private String rut;
   public void setRut(String property){
       this.rut = property;
   }


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

}