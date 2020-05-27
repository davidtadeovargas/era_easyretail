package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.CClaveprodservsValidatorsExceptions;
import com.era.models.CClaveprodserv;
import com.era.repositories.RepositoryFactory;

public class CClaveprodservsValidator extends IValidate{

   private String code;
   private String c_ClaveProdServ;
   private String description;

   @Override
   public void validateInsert() throws Exception {

       if(c_ClaveProdServ==null || c_ClaveProdServ.isEmpty()){
           throw new CClaveprodservsValidatorsExceptions().getC_ClaveProdServException();
       }

       if(description==null || description.isEmpty()){
           throw new CClaveprodservsValidatorsExceptions().getDescriptionException();
       }

       final CClaveprodserv CClaveprodserv = (CClaveprodserv) RepositoryFactory.getInstance().getCClaveprodservsRepository().getByCode(code);
       if(CClaveprodserv != null){            
           throw new CClaveprodservsValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new CClaveprodservsValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new CClaveprodservsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new CClaveprodservsValidatorsExceptions().getCodeException();
       }

       final CClaveprodserv CClaveprodserv = (CClaveprodserv) RepositoryFactory.getInstance().getCClaveprodservsRepository().getByCode(code);
       if(CClaveprodserv == null){            
           throw new CClaveprodservsValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new CClaveprodservsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}