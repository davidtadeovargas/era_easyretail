package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.ContrassValidatorsExceptions;
import com.era.models.Contras;
import com.era.repositories.RepositoryFactory;

public class ContrassValidator extends IValidate{

   private String code;
   private String comp;
   private String id_idp;
   private String prov;
   private String respon;

   @Override
   public void validateInsert() throws Exception {

       if(comp==null || comp.isEmpty()){
           throw new ContrassValidatorsExceptions().getCompException();
       }

       if(id_idp==null || id_idp.isEmpty()){
           throw new ContrassValidatorsExceptions().getId_idpException();
       }

       if(prov==null || prov.isEmpty()){
           throw new ContrassValidatorsExceptions().getProvException();
       }

       if(respon==null || respon.isEmpty()){
           throw new ContrassValidatorsExceptions().getResponException();
       }

       final Contras Contras = (Contras) RepositoryFactory.getInstance().getContrassRepository().getByCode(code);
       if(Contras != null){            
           throw new ContrassValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new ContrassValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new ContrassValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new ContrassValidatorsExceptions().getCodeException();
       }

       final Contras Contras = (Contras) RepositoryFactory.getInstance().getContrassRepository().getByCode(code);
       if(Contras == null){            
           throw new ContrassValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new ContrassValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}