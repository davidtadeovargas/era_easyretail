package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.MoninvensValidatorsExceptions;
import com.era.models.Moninven;
import com.era.repositories.RepositoryFactory;

public class MoninvensValidator extends IValidate{

   private String code;
   private String alma;
   private String concep;
   private String descrip;
   private String emp;
   private String entsal;
   private String nodoc;
   private String noser;
   private String prod;
   private String unid;

   @Override
   public void validateInsert() throws Exception {

       if(alma==null || alma.isEmpty()){
           throw new MoninvensValidatorsExceptions().getAlmaException();
       }

       if(concep==null || concep.isEmpty()){
           throw new MoninvensValidatorsExceptions().getConcepException();
       }

       if(descrip==null || descrip.isEmpty()){
           throw new MoninvensValidatorsExceptions().getDescripException();
       }

       if(emp==null || emp.isEmpty()){
           throw new MoninvensValidatorsExceptions().getEmpException();
       }

       if(entsal==null || entsal.isEmpty()){
           throw new MoninvensValidatorsExceptions().getEntsalException();
       }

       if(nodoc==null || nodoc.isEmpty()){
           throw new MoninvensValidatorsExceptions().getNodocException();
       }

       if(noser==null || noser.isEmpty()){
           throw new MoninvensValidatorsExceptions().getNoserException();
       }

       if(prod==null || prod.isEmpty()){
           throw new MoninvensValidatorsExceptions().getProdException();
       }

       if(unid==null || unid.isEmpty()){
           throw new MoninvensValidatorsExceptions().getUnidException();
       }

       final Moninven Moninven = (Moninven) RepositoryFactory.getInstance().getMoninvensRepository().getByCode(code);
       if(Moninven != null){            
           throw new MoninvensValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new MoninvensValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new MoninvensValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new MoninvensValidatorsExceptions().getCodeException();
       }

       final Moninven Moninven = (Moninven) RepositoryFactory.getInstance().getMoninvensRepository().getByCode(code);
       if(Moninven == null){            
           throw new MoninvensValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new MoninvensValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}