package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.UsersValidatorsExceptions;
import com.era.models.User;
import com.era.repositories.RepositoryFactory;

public class UsersValidator extends IValidate{

   private String code;
   private String cort;
   private String disccount;
   private String m52;
   private String password;
   private String userOfsalesOfPoint;

   @Override
   public void validateInsert() throws Exception {

       if(code==null || code.isEmpty()){
           throw new UsersValidatorsExceptions().getCodeException();
       }

       if(cort==null || cort.isEmpty()){
           throw new UsersValidatorsExceptions().getCortException();
       }

       if(disccount==null || disccount.isEmpty()){
           throw new UsersValidatorsExceptions().getDisccountException();
       }

       if(m52==null || m52.isEmpty()){
           throw new UsersValidatorsExceptions().getM52Exception();
       }

       if(password==null || password.isEmpty()){
           throw new UsersValidatorsExceptions().getPasswordException();
       }

       if(userOfsalesOfPoint==null || userOfsalesOfPoint.isEmpty()){
           throw new UsersValidatorsExceptions().getUserOfsalesOfPointException();
       }

       final User User = (User) RepositoryFactory.getInstance().getUsersRepository().getByCode(code);
       if(User != null){            
           throw new UsersValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new UsersValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new UsersValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new UsersValidatorsExceptions().getCodeException();
       }

       final User User = (User) RepositoryFactory.getInstance().getUsersRepository().getByCode(code);
       if(User == null){            
           throw new UsersValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new UsersValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}