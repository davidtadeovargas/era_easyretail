package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.CotssValidatorsExceptions;
import com.era.models.Cots;
import com.era.repositories.RepositoryFactory;

public class CotssValidator extends IValidate{

   private String code;
   private String codcot;
   private String codemp;
   private String descrip;
   private String estad;
   private String fdoc;
   private String fentre;
   private String fvenc;
   private String mon;
   private String noser;
   private String observ;
   private String proy;
   private String ser;
   private String subtotgral2;
   private String subtotmat2;

   @Override
   public void validateInsert() throws Exception {

       if(codcot==null || codcot.isEmpty()){
           throw new CotssValidatorsExceptions().getCodcotException();
       }

       if(codemp==null || codemp.isEmpty()){
           throw new CotssValidatorsExceptions().getCodempException();
       }

       if(descrip==null || descrip.isEmpty()){
           throw new CotssValidatorsExceptions().getDescripException();
       }

       if(estad==null || estad.isEmpty()){
           throw new CotssValidatorsExceptions().getEstadException();
       }

       if(fdoc==null || fdoc.isEmpty()){
           throw new CotssValidatorsExceptions().getFdocException();
       }

       if(fentre==null || fentre.isEmpty()){
           throw new CotssValidatorsExceptions().getFentreException();
       }

       if(fvenc==null || fvenc.isEmpty()){
           throw new CotssValidatorsExceptions().getFvencException();
       }

       if(mon==null || mon.isEmpty()){
           throw new CotssValidatorsExceptions().getMonException();
       }

       if(noser==null || noser.isEmpty()){
           throw new CotssValidatorsExceptions().getNoserException();
       }

       if(observ==null || observ.isEmpty()){
           throw new CotssValidatorsExceptions().getObservException();
       }

       if(proy==null || proy.isEmpty()){
           throw new CotssValidatorsExceptions().getProyException();
       }

       if(ser==null || ser.isEmpty()){
           throw new CotssValidatorsExceptions().getSerException();
       }

       if(subtotgral2==null || subtotgral2.isEmpty()){
           throw new CotssValidatorsExceptions().getSubtotgral2Exception();
       }

       if(subtotmat2==null || subtotmat2.isEmpty()){
           throw new CotssValidatorsExceptions().getSubtotmat2Exception();
       }

       final Cots Cots = (Cots) RepositoryFactory.getInstance().getCotssRepository().getByCode(code);
       if(Cots != null){            
           throw new CotssValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new CotssValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new CotssValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new CotssValidatorsExceptions().getCodeException();
       }

       final Cots Cots = (Cots) RepositoryFactory.getInstance().getCotssRepository().getByCode(code);
       if(Cots == null){            
           throw new CotssValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new CotssValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}