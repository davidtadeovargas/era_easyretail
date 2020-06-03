package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.IngressValidatorsExceptions;
import com.era.models.Ingres;
import com.era.repositories.RepositoryFactory;

public class IngressValidator extends IValidate{

   private String alma;
   public void setAlma(String property){
       this.alma = property;
   }

   private String caducidad;
   public void setCaducidad(String property){
       this.caducidad = property;
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

   private String pedimento;
   public void setPedimento(String property){
       this.pedimento = property;
   }

   private String prod;
   public void setProd(String property){
       this.prod = property;
   }

   private String tipcamnac;
   public void setTipcamnac(String property){
       this.tipcamnac = property;
   }

   private String unid;
   public void setUnid(String property){
       this.unid = property;
   }


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

}