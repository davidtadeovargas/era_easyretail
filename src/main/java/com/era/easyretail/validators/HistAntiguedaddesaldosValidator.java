package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.HistAntiguedaddesaldosValidatorsExceptions;
import com.era.models.HistAntiguedaddesaldo;
import com.era.repositories.RepositoryFactory;

public class HistAntiguedaddesaldosValidator extends IValidate{

   private String codemp;
   public void setCodemp(String property){
       this.codemp = property;
   }

   private String idCorte;
   public void setIdCorte(String property){
       this.idCorte = property;
   }

   private String nom;
   public void setNom(String property){
       this.nom = property;
   }


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

}