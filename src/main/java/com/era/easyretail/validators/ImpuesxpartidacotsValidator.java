package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.ImpuesxpartidacotsValidatorsExceptions;
import com.era.models.Impuesxpartidacot;
import com.era.repositories.RepositoryFactory;

public class ImpuesxpartidacotsValidator extends IValidate{

   private String code;
   private String codigoImpuesto;
   private String idPartida;
   private String idParts;
   private String ret_tras;
   private String retencion;
   private String tasa;
   private String total;

   @Override
   public void validateInsert() throws Exception {

       if(codigoImpuesto==null || codigoImpuesto.isEmpty()){
           throw new ImpuesxpartidacotsValidatorsExceptions().getCodigoImpuestoException();
       }

       if(idPartida==null || idPartida.isEmpty()){
           throw new ImpuesxpartidacotsValidatorsExceptions().getIdPartidaException();
       }

       if(idParts==null || idParts.isEmpty()){
           throw new ImpuesxpartidacotsValidatorsExceptions().getIdPartsException();
       }

       if(ret_tras==null || ret_tras.isEmpty()){
           throw new ImpuesxpartidacotsValidatorsExceptions().getRet_trasException();
       }

       if(retencion==null || retencion.isEmpty()){
           throw new ImpuesxpartidacotsValidatorsExceptions().getRetencionException();
       }

       if(tasa==null || tasa.isEmpty()){
           throw new ImpuesxpartidacotsValidatorsExceptions().getTasaException();
       }

       if(total==null || total.isEmpty()){
           throw new ImpuesxpartidacotsValidatorsExceptions().getTotalException();
       }

       final Impuesxpartidacot Impuesxpartidacot = (Impuesxpartidacot) RepositoryFactory.getInstance().getImpuesxpartidacotsRepository().getByCode(code);
       if(Impuesxpartidacot != null){            
           throw new ImpuesxpartidacotsValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new ImpuesxpartidacotsValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new ImpuesxpartidacotsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new ImpuesxpartidacotsValidatorsExceptions().getCodeException();
       }

       final Impuesxpartidacot Impuesxpartidacot = (Impuesxpartidacot) RepositoryFactory.getInstance().getImpuesxpartidacotsRepository().getByCode(code);
       if(Impuesxpartidacot == null){            
           throw new ImpuesxpartidacotsValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new ImpuesxpartidacotsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}