package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.PedidossValidatorsExceptions;
import com.era.models.Pedidos;
import com.era.repositories.RepositoryFactory;

public class PedidossValidator extends IValidate{

   private String codcot;
   public void setCodcot(String property){
       this.codcot = property;
   }

   private String codemp;
   public void setCodemp(String property){
       this.codemp = property;
   }

   private String descrip;
   public void setDescrip(String property){
       this.descrip = property;
   }

   private String estad;
   public void setEstad(String property){
       this.estad = property;
   }

   private String fdoc;
   public void setFdoc(String property){
       this.fdoc = property;
   }

   private String fentre;
   public void setFentre(String property){
       this.fentre = property;
   }

   private String fvenc;
   public void setFvenc(String property){
       this.fvenc = property;
   }

   private String impue;
   public void setImpue(String property){
       this.impue = property;
   }

   private String monedaID;
   public void setMonedaID(String property){
       this.monedaID = property;
   }

   private String noser;
   public void setNoser(String property){
       this.noser = property;
   }

   private String observ;
   public void setObserv(String property){
       this.observ = property;
   }

   private String ser;
   public void setSer(String property){
       this.ser = property;
   }

   private String subtot;
   public void setSubtot(String property){
       this.subtot = property;
   }

   private String tipcam;
   public void setTipcam(String property){
       this.tipcam = property;
   }

   private String tipcamnac;
   public void setTipcamnac(String property){
       this.tipcamnac = property;
   }

   private String tot;
   public void setTot(String property){
       this.tot = property;
   }

   private String total_retencion;
   public void setTotal_retencion(String property){
       this.total_retencion = property;
   }

   private String total_traslado;
   public void setTotal_traslado(String property){
       this.total_traslado = property;
   }

   private String totcost;
   public void setTotcost(String property){
       this.totcost = property;
   }

   private String totdescu;
   public void setTotdescu(String property){
       this.totdescu = property;
   }


   @Override
   public void validateInsert() throws Exception {

       if(codcot==null || codcot.isEmpty()){
           throw new PedidossValidatorsExceptions().getCodcotException();
       }

       if(codemp==null || codemp.isEmpty()){
           throw new PedidossValidatorsExceptions().getCodempException();
       }

       if(descrip==null || descrip.isEmpty()){
           throw new PedidossValidatorsExceptions().getDescripException();
       }

       if(estad==null || estad.isEmpty()){
           throw new PedidossValidatorsExceptions().getEstadException();
       }

       if(fdoc==null || fdoc.isEmpty()){
           throw new PedidossValidatorsExceptions().getFdocException();
       }

       if(fentre==null || fentre.isEmpty()){
           throw new PedidossValidatorsExceptions().getFentreException();
       }

       if(fvenc==null || fvenc.isEmpty()){
           throw new PedidossValidatorsExceptions().getFvencException();
       }

       if(impue==null || impue.isEmpty()){
           throw new PedidossValidatorsExceptions().getImpueException();
       }

       if(monedaID==null || monedaID.isEmpty()){
           throw new PedidossValidatorsExceptions().getMonedaIDException();
       }

       if(noser==null || noser.isEmpty()){
           throw new PedidossValidatorsExceptions().getNoserException();
       }

       if(observ==null || observ.isEmpty()){
           throw new PedidossValidatorsExceptions().getObservException();
       }

       if(ser==null || ser.isEmpty()){
           throw new PedidossValidatorsExceptions().getSerException();
       }

       if(subtot==null || subtot.isEmpty()){
           throw new PedidossValidatorsExceptions().getSubtotException();
       }

       if(tipcam==null || tipcam.isEmpty()){
           throw new PedidossValidatorsExceptions().getTipcamException();
       }

       if(tipcamnac==null || tipcamnac.isEmpty()){
           throw new PedidossValidatorsExceptions().getTipcamnacException();
       }

       if(tot==null || tot.isEmpty()){
           throw new PedidossValidatorsExceptions().getTotException();
       }

       if(total_retencion==null || total_retencion.isEmpty()){
           throw new PedidossValidatorsExceptions().getTotal_retencionException();
       }

       if(total_traslado==null || total_traslado.isEmpty()){
           throw new PedidossValidatorsExceptions().getTotal_trasladoException();
       }

       if(totcost==null || totcost.isEmpty()){
           throw new PedidossValidatorsExceptions().getTotcostException();
       }

       if(totdescu==null || totdescu.isEmpty()){
           throw new PedidossValidatorsExceptions().getTotdescuException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new PedidossValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new PedidossValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

}