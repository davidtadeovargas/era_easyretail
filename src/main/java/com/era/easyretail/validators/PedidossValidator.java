package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.PedidossValidatorsExceptions;
import com.era.models.Pedidos;
import com.era.repositories.RepositoryFactory;

public class PedidossValidator extends IValidate{

   private String code;
   private String codcot;
   private String codemp;
   private String descrip;
   private String estad;
   private String fdoc;
   private String fentre;
   private String fvenc;
   private String impue;
   private String monedaID;
   private String noser;
   private String observ;
   private String ser;
   private String subtot;
   private String tipcam;
   private String tipcamnac;
   private String tot;
   private String total_retencion;
   private String total_traslado;
   private String totcost;
   private String totdescu;

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

       final Pedidos Pedidos = (Pedidos) RepositoryFactory.getInstance().getPedidossRepository().getByCode(code);
       if(Pedidos != null){            
           throw new PedidossValidatorsExceptions().getModelExistsException();
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

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new PedidossValidatorsExceptions().getCodeException();
       }

       final Pedidos Pedidos = (Pedidos) RepositoryFactory.getInstance().getPedidossRepository().getByCode(code);
       if(Pedidos == null){            
           throw new PedidossValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new PedidossValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}