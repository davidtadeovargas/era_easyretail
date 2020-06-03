package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.MoninvensValidatorsExceptions;
import com.era.models.Moninven;
import com.era.repositories.RepositoryFactory;

public class MoninvensValidator extends IValidate{

   private String alma;
   public void setAlma(String property){
       this.alma = property;
   }

   private String concep;
   public void setConcep(String property){
       this.concep = property;
   }

   private String descrip;
   public void setDescrip(String property){
       this.descrip = property;
   }

   private String emp;
   public void setEmp(String property){
       this.emp = property;
   }

   private String entsal;
   public void setEntsal(String property){
       this.entsal = property;
   }

   private String nodoc;
   public void setNodoc(String property){
       this.nodoc = property;
   }

   private String noser;
   public void setNoser(String property){
       this.noser = property;
   }

   private String prod;
   public void setProd(String property){
       this.prod = property;
   }

   private String unid;
   public void setUnid(String property){
       this.unid = property;
   }


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

}