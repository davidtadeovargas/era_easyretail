package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.CxcsValidatorsExceptions;
import com.era.models.Cxc;
import com.era.repositories.RepositoryFactory;

public class CxcsValidator extends IValidate{

   private String code;
   private String abon;
   private String carg;
   private String empre;
   private String fdoc;
   private String id_venta;
   private String impue;
   private String monedaID;
   private String norefer;
   private String noser;
   private String ser;
   private String subtot;
   private String tot;

   @Override
   public void validateInsert() throws Exception {

       if(abon==null || abon.isEmpty()){
           throw new CxcsValidatorsExceptions().getAbonException();
       }

       if(carg==null || carg.isEmpty()){
           throw new CxcsValidatorsExceptions().getCargException();
       }

       if(empre==null || empre.isEmpty()){
           throw new CxcsValidatorsExceptions().getEmpreException();
       }

       if(fdoc==null || fdoc.isEmpty()){
           throw new CxcsValidatorsExceptions().getFdocException();
       }

       if(id_venta==null || id_venta.isEmpty()){
           throw new CxcsValidatorsExceptions().getId_ventaException();
       }

       if(impue==null || impue.isEmpty()){
           throw new CxcsValidatorsExceptions().getImpueException();
       }

       if(monedaID==null || monedaID.isEmpty()){
           throw new CxcsValidatorsExceptions().getMonedaIDException();
       }

       if(norefer==null || norefer.isEmpty()){
           throw new CxcsValidatorsExceptions().getNoreferException();
       }

       if(noser==null || noser.isEmpty()){
           throw new CxcsValidatorsExceptions().getNoserException();
       }

       if(ser==null || ser.isEmpty()){
           throw new CxcsValidatorsExceptions().getSerException();
       }

       if(subtot==null || subtot.isEmpty()){
           throw new CxcsValidatorsExceptions().getSubtotException();
       }

       if(tot==null || tot.isEmpty()){
           throw new CxcsValidatorsExceptions().getTotException();
       }

       final Cxc Cxc = (Cxc) RepositoryFactory.getInstance().getCxcsRepository().getByCode(code);
       if(Cxc != null){            
           throw new CxcsValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new CxcsValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new CxcsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new CxcsValidatorsExceptions().getCodeException();
       }

       final Cxc Cxc = (Cxc) RepositoryFactory.getInstance().getCxcsRepository().getByCode(code);
       if(Cxc == null){            
           throw new CxcsValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new CxcsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}