package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.ImpuesxpartidapedsValidatorsExceptions;
import com.era.models.Impuesxpartidaped;
import com.era.repositories.RepositoryFactory;

public class ImpuesxpartidapedsValidator extends IValidate{

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
           throw new ImpuesxpartidapedsValidatorsExceptions().getCodigoImpuestoException();
       }

       if(idPartida==null || idPartida.isEmpty()){
           throw new ImpuesxpartidapedsValidatorsExceptions().getIdPartidaException();
       }

       if(idParts==null || idParts.isEmpty()){
           throw new ImpuesxpartidapedsValidatorsExceptions().getIdPartsException();
       }

       if(ret_tras==null || ret_tras.isEmpty()){
           throw new ImpuesxpartidapedsValidatorsExceptions().getRet_trasException();
       }

       if(retencion==null || retencion.isEmpty()){
           throw new ImpuesxpartidapedsValidatorsExceptions().getRetencionException();
       }

       if(tasa==null || tasa.isEmpty()){
           throw new ImpuesxpartidapedsValidatorsExceptions().getTasaException();
       }

       if(total==null || total.isEmpty()){
           throw new ImpuesxpartidapedsValidatorsExceptions().getTotalException();
       }

       final Impuesxpartidaped Impuesxpartidaped = (Impuesxpartidaped) RepositoryFactory.getInstance().getImpuesxpartidapedsRepository().getByCode(code);
       if(Impuesxpartidaped != null){            
           throw new ImpuesxpartidapedsValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new ImpuesxpartidapedsValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new ImpuesxpartidapedsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new ImpuesxpartidapedsValidatorsExceptions().getCodeException();
       }

       final Impuesxpartidaped Impuesxpartidaped = (Impuesxpartidaped) RepositoryFactory.getInstance().getImpuesxpartidapedsRepository().getByCode(code);
       if(Impuesxpartidaped == null){            
           throw new ImpuesxpartidapedsValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new ImpuesxpartidapedsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}