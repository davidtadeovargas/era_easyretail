package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.IngressValidatorsExceptions;
import com.era.models.Ingres;
import com.era.repositories.RepositoryFactory;

public class IngressValidator extends IValidate{

   private String code;
   private String alma;
   private String caducidad;
   private String concep;
   private String entsal;
   private String lote;
   private String pedimento;
   private String prod;
   private String tipcamnac;
   private String unid;

   @Override
   public void validateInsert() throws Exception {

       if(alma==null || alma.isEmpty()){
           throw new IngressValidatorsExceptions().getAlmaException();
       }

       if(caducidad==null || caducidad.isEmpty()){
           throw new IngressValidatorsExceptions().getCaducidadException();
       }

       if(concep==null || concep.isEmpty()){
           throw new IngressValidatorsExceptions().getConcepException();
       }

       if(entsal==null || entsal.isEmpty()){
           throw new IngressValidatorsExceptions().getEntsalException();
       }

       if(lote==null || lote.isEmpty()){
           throw new IngressValidatorsExceptions().getLoteException();
       }

       if(pedimento==null || pedimento.isEmpty()){
           throw new IngressValidatorsExceptions().getPedimentoException();
       }

       if(prod==null || prod.isEmpty()){
           throw new IngressValidatorsExceptions().getProdException();
       }

       if(tipcamnac==null || tipcamnac.isEmpty()){
           throw new IngressValidatorsExceptions().getTipcamnacException();
       }

       if(unid==null || unid.isEmpty()){
           throw new IngressValidatorsExceptions().getUnidException();
       }

       final Ingres Ingres = (Ingres) RepositoryFactory.getInstance().getIngressRepository().getByCode(code);
       if(Ingres != null){            
           throw new IngressValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new IngressValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new IngressValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new IngressValidatorsExceptions().getCodeException();
       }

       final Ingres Ingres = (Ingres) RepositoryFactory.getInstance().getIngressRepository().getByCode(code);
       if(Ingres == null){            
           throw new IngressValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new IngressValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}