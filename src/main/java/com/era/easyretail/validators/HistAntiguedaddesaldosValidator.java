package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.HistAntiguedaddesaldosValidatorsExceptions;
import com.era.models.HistAntiguedaddesaldo;
import com.era.repositories.RepositoryFactory;

public class HistAntiguedaddesaldosValidator extends IValidate{

   private String code;
   private String codemp;
   private String idCorte;
   private String nom;

   @Override
   public void validateInsert() throws Exception {

       if(codemp==null || codemp.isEmpty()){
           throw new HistAntiguedaddesaldosValidatorsExceptions().getCodempException();
       }

       if(idCorte==null || idCorte.isEmpty()){
           throw new HistAntiguedaddesaldosValidatorsExceptions().getIdCorteException();
       }

       if(nom==null || nom.isEmpty()){
           throw new HistAntiguedaddesaldosValidatorsExceptions().getNomException();
       }

       final HistAntiguedaddesaldo HistAntiguedaddesaldo = (HistAntiguedaddesaldo) RepositoryFactory.getInstance().getHistAntiguedaddesaldosRepository().getByCode(code);
       if(HistAntiguedaddesaldo != null){            
           throw new HistAntiguedaddesaldosValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new HistAntiguedaddesaldosValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new HistAntiguedaddesaldosValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new HistAntiguedaddesaldosValidatorsExceptions().getCodeException();
       }

       final HistAntiguedaddesaldo HistAntiguedaddesaldo = (HistAntiguedaddesaldo) RepositoryFactory.getInstance().getHistAntiguedaddesaldosRepository().getByCode(code);
       if(HistAntiguedaddesaldo == null){            
           throw new HistAntiguedaddesaldosValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new HistAntiguedaddesaldosValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}