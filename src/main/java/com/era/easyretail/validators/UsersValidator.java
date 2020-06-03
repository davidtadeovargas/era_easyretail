package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.UsersValidatorsExceptions;
import com.era.models.User;
import com.era.repositories.RepositoryFactory;

public class UsersValidator extends IValidate{

   private String code;
   public void setCode(String property){
       this.code = property;
   }

   private String cort;
   public void setCort(String property){
       this.cort = property;
   }

   private String disccount;
   public void setDisccount(String property){
       this.disccount = property;
   }

   private String m52;
   public void setM52(String property){
       this.m52 = property;
   }

   private String password;
   public void setPassword(String property){
       this.password = property;
   }

   private String userOfsalesOfPoint;
   public void setUserOfsalesOfPoint(String property){
       this.userOfsalesOfPoint = property;
   }


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

}