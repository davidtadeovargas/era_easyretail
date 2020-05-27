package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.CxpsValidatorsExceptions;
import com.era.models.Cxp;
import com.era.repositories.RepositoryFactory;

public class CxpsValidator extends IValidate{

   private String code;
   private String abon;
   private String carg;
   private String fdoc;
   private String impue;
   private String monedaID;
   private String norefer;
   private String noser;
   private String prov;
   private String ser;
   private String subtot;
   private String tipcam;
   private String tot;

   @Override
   public void validateInsert() throws Exception {

       if(abon==null || abon.isEmpty()){
           throw new CxpsValidatorsExceptions().getAbonException();
       }

       if(carg==null || carg.isEmpty()){
           throw new CxpsValidatorsExceptions().getCargException();
       }

       if(fdoc==null || fdoc.isEmpty()){
           throw new CxpsValidatorsExceptions().getFdocException();
       }

       if(impue==null || impue.isEmpty()){
           throw new CxpsValidatorsExceptions().getImpueException();
       }

       if(monedaID==null || monedaID.isEmpty()){
           throw new CxpsValidatorsExceptions().getMonedaIDException();
       }

       if(norefer==null || norefer.isEmpty()){
           throw new CxpsValidatorsExceptions().getNoreferException();
       }

       if(noser==null || noser.isEmpty()){
           throw new CxpsValidatorsExceptions().getNoserException();
       }

       if(prov==null || prov.isEmpty()){
           throw new CxpsValidatorsExceptions().getProvException();
       }

       if(ser==null || ser.isEmpty()){
           throw new CxpsValidatorsExceptions().getSerException();
       }

       if(subtot==null || subtot.isEmpty()){
           throw new CxpsValidatorsExceptions().getSubtotException();
       }

       if(tipcam==null || tipcam.isEmpty()){
           throw new CxpsValidatorsExceptions().getTipcamException();
       }

       if(tot==null || tot.isEmpty()){
           throw new CxpsValidatorsExceptions().getTotException();
       }

       final Cxp Cxp = (Cxp) RepositoryFactory.getInstance().getCxpsRepository().getByCode(code);
       if(Cxp != null){            
           throw new CxpsValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new CxpsValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new CxpsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new CxpsValidatorsExceptions().getCodeException();
       }

       final Cxp Cxp = (Cxp) RepositoryFactory.getInstance().getCxpsRepository().getByCode(code);
       if(Cxp == null){            
           throw new CxpsValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new CxpsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}