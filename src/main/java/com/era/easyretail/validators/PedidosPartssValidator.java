package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.PedidosPartssValidatorsExceptions;
import com.era.models.PedidosParts;
import com.era.repositories.RepositoryFactory;

public class PedidosPartssValidator extends IValidate{

   private String alma;
   public void setAlma(String property){
       this.alma = property;
   }

   private String cant;
   public void setCant(String property){
       this.cant = property;
   }

   private String codimpue;
   public void setCodimpue(String property){
       this.codimpue = property;
   }

   private String comenser;
   public void setComenser(String property){
       this.comenser = property;
   }

   private String desc_1;
   public void setDesc_1(String property){
       this.desc_1 = property;
   }

   private String desc_2;
   public void setDesc_2(String property){
       this.desc_2 = property;
   }

   private String desc_3;
   public void setDesc_3(String property){
       this.desc_3 = property;
   }

   private String desc_4;
   public void setDesc_4(String property){
       this.desc_4 = property;
   }

   private String desc_5;
   public void setDesc_5(String property){
       this.desc_5 = property;
   }

   private String descrip;
   public void setDescrip(String property){
       this.descrip = property;
   }

   private String fcadu;
   public void setFcadu(String property){
       this.fcadu = property;
   }

   private String impo;
   public void setImpo(String property){
       this.impo = property;
   }

   private String impo_2;
   public void setImpo_2(String property){
       this.impo_2 = property;
   }

   private String impueimpo;
   public void setImpueimpo(String property){
       this.impueimpo = property;
   }

   private String impueimpo_2;
   public void setImpueimpo_2(String property){
       this.impueimpo_2 = property;
   }

   private String impueval;
   public void setImpueval(String property){
       this.impueval = property;
   }

   private String mon;
   public void setMon(String property){
       this.mon = property;
   }

   private String pedidoID;
   public void setPedidoID(String property){
       this.pedidoID = property;
   }

   private String pre;
   public void setPre(String property){
       this.pre = property;
   }

   private String pre_2;
   public void setPre_2(String property){
       this.pre_2 = property;
   }

   private String prod;
   public void setProd(String property){
       this.prod = property;
   }

   private String recibidas;
   public void setRecibidas(String property){
       this.recibidas = property;
   }

   private String serprod;
   public void setSerprod(String property){
       this.serprod = property;
   }

   private String tipcam;
   public void setTipcam(String property){
       this.tipcam = property;
   }

   private String unid;
   public void setUnid(String property){
       this.unid = property;
   }


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

}