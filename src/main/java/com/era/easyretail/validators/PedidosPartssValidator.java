package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.PedidosPartssValidatorsExceptions;
import com.era.models.PedidosParts;
import com.era.repositories.RepositoryFactory;

public class PedidosPartssValidator extends IValidate{

   private String code;
   private String alma;
   private String cant;
   private String codimpue;
   private String comenser;
   private String desc_1;
   private String desc_2;
   private String desc_3;
   private String desc_4;
   private String desc_5;
   private String descrip;
   private String fcadu;
   private String impo;
   private String impo_2;
   private String impueimpo;
   private String impueimpo_2;
   private String impueval;
   private String mon;
   private String pedidoID;
   private String pre;
   private String pre_2;
   private String prod;
   private String recibidas;
   private String serprod;
   private String tipcam;
   private String unid;

   @Override
   public void validateInsert() throws Exception {

       if(alma==null || alma.isEmpty()){
           throw new PedidosPartssValidatorsExceptions().getAlmaException();
       }

       if(cant==null || cant.isEmpty()){
           throw new PedidosPartssValidatorsExceptions().getCantException();
       }

       if(codimpue==null || codimpue.isEmpty()){
           throw new PedidosPartssValidatorsExceptions().getCodimpueException();
       }

       if(comenser==null || comenser.isEmpty()){
           throw new PedidosPartssValidatorsExceptions().getComenserException();
       }

       if(desc_1==null || desc_1.isEmpty()){
           throw new PedidosPartssValidatorsExceptions().getDesc_1Exception();
       }

       if(desc_2==null || desc_2.isEmpty()){
           throw new PedidosPartssValidatorsExceptions().getDesc_2Exception();
       }

       if(desc_3==null || desc_3.isEmpty()){
           throw new PedidosPartssValidatorsExceptions().getDesc_3Exception();
       }

       if(desc_4==null || desc_4.isEmpty()){
           throw new PedidosPartssValidatorsExceptions().getDesc_4Exception();
       }

       if(desc_5==null || desc_5.isEmpty()){
           throw new PedidosPartssValidatorsExceptions().getDesc_5Exception();
       }

       if(descrip==null || descrip.isEmpty()){
           throw new PedidosPartssValidatorsExceptions().getDescripException();
       }

       if(fcadu==null || fcadu.isEmpty()){
           throw new PedidosPartssValidatorsExceptions().getFcaduException();
       }

       if(impo==null || impo.isEmpty()){
           throw new PedidosPartssValidatorsExceptions().getImpoException();
       }

       if(impo_2==null || impo_2.isEmpty()){
           throw new PedidosPartssValidatorsExceptions().getImpo_2Exception();
       }

       if(impueimpo==null || impueimpo.isEmpty()){
           throw new PedidosPartssValidatorsExceptions().getImpueimpoException();
       }

       if(impueimpo_2==null || impueimpo_2.isEmpty()){
           throw new PedidosPartssValidatorsExceptions().getImpueimpo_2Exception();
       }

       if(impueval==null || impueval.isEmpty()){
           throw new PedidosPartssValidatorsExceptions().getImpuevalException();
       }

       if(mon==null || mon.isEmpty()){
           throw new PedidosPartssValidatorsExceptions().getMonException();
       }

       if(pedidoID==null || pedidoID.isEmpty()){
           throw new PedidosPartssValidatorsExceptions().getPedidoIDException();
       }

       if(pre==null || pre.isEmpty()){
           throw new PedidosPartssValidatorsExceptions().getPreException();
       }

       if(pre_2==null || pre_2.isEmpty()){
           throw new PedidosPartssValidatorsExceptions().getPre_2Exception();
       }

       if(prod==null || prod.isEmpty()){
           throw new PedidosPartssValidatorsExceptions().getProdException();
       }

       if(recibidas==null || recibidas.isEmpty()){
           throw new PedidosPartssValidatorsExceptions().getRecibidasException();
       }

       if(serprod==null || serprod.isEmpty()){
           throw new PedidosPartssValidatorsExceptions().getSerprodException();
       }

       if(tipcam==null || tipcam.isEmpty()){
           throw new PedidosPartssValidatorsExceptions().getTipcamException();
       }

       if(unid==null || unid.isEmpty()){
           throw new PedidosPartssValidatorsExceptions().getUnidException();
       }

       final PedidosParts PedidosParts = (PedidosParts) RepositoryFactory.getInstance().getPedidosPartssRepository().getByCode(code);
       if(PedidosParts != null){            
           throw new PedidosPartssValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new PedidosPartssValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new PedidosPartssValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new PedidosPartssValidatorsExceptions().getCodeException();
       }

       final PedidosParts PedidosParts = (PedidosParts) RepositoryFactory.getInstance().getPedidosPartssRepository().getByCode(code);
       if(PedidosParts == null){            
           throw new PedidosPartssValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new PedidosPartssValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}