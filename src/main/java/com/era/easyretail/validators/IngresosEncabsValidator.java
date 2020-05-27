package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.IngresosEncabsValidatorsExceptions;
import com.era.models.IngresosEncab;
import com.era.repositories.RepositoryFactory;

public class IngresosEncabsValidator extends IValidate{

   private String code;
   private String alma;
   private String caducidad;
   private String canttotal;
   private String concep;
   private String entsal;
   private String lote;
   private String norefer;
   private String noser;
   private String pedimento;

   @Override
   public void validateInsert() throws Exception {

       if(alma==null || alma.isEmpty()){
           throw new IngresosEncabsValidatorsExceptions().getAlmaException();
       }

       if(caducidad==null || caducidad.isEmpty()){
           throw new IngresosEncabsValidatorsExceptions().getCaducidadException();
       }

       if(canttotal==null || canttotal.isEmpty()){
           throw new IngresosEncabsValidatorsExceptions().getCanttotalException();
       }

       if(concep==null || concep.isEmpty()){
           throw new IngresosEncabsValidatorsExceptions().getConcepException();
       }

       if(entsal==null || entsal.isEmpty()){
           throw new IngresosEncabsValidatorsExceptions().getEntsalException();
       }

       if(lote==null || lote.isEmpty()){
           throw new IngresosEncabsValidatorsExceptions().getLoteException();
       }

       if(norefer==null || norefer.isEmpty()){
           throw new IngresosEncabsValidatorsExceptions().getNoreferException();
       }

       if(noser==null || noser.isEmpty()){
           throw new IngresosEncabsValidatorsExceptions().getNoserException();
       }

       if(pedimento==null || pedimento.isEmpty()){
           throw new IngresosEncabsValidatorsExceptions().getPedimentoException();
       }

       final IngresosEncab IngresosEncab = (IngresosEncab) RepositoryFactory.getInstance().getIngresosEncabsRepository().getByCode(code);
       if(IngresosEncab != null){            
           throw new IngresosEncabsValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new IngresosEncabsValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new IngresosEncabsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new IngresosEncabsValidatorsExceptions().getCodeException();
       }

       final IngresosEncab IngresosEncab = (IngresosEncab) RepositoryFactory.getInstance().getIngresosEncabsRepository().getByCode(code);
       if(IngresosEncab == null){            
           throw new IngresosEncabsValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new IngresosEncabsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}