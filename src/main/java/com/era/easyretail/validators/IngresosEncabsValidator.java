package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.IngresosEncabsValidatorsExceptions;
import com.era.models.IngresosEncab;
import com.era.repositories.RepositoryFactory;

public class IngresosEncabsValidator extends IValidate{

   private String alma;
   public void setAlma(String property){
       this.alma = property;
   }

   private String caducidad;
   public void setCaducidad(String property){
       this.caducidad = property;
   }

   private String canttotal;
   public void setCanttotal(String property){
       this.canttotal = property;
   }

   private String concep;
   public void setConcep(String property){
       this.concep = property;
   }

   private String entsal;
   public void setEntsal(String property){
       this.entsal = property;
   }

   private String lote;
   public void setLote(String property){
       this.lote = property;
   }

   private String norefer;
   public void setNorefer(String property){
       this.norefer = property;
   }

   private String noser;
   public void setNoser(String property){
       this.noser = property;
   }

   private String pedimento;
   public void setPedimento(String property){
       this.pedimento = property;
   }


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

}