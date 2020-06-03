package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.PartcomprssValidatorsExceptions;
import com.era.models.Partcomprs;
import com.era.repositories.RepositoryFactory;

public class PartcomprssValidator extends IValidate{

   private String alma;
   public void setAlma(String property){
       this.alma = property;
   }

   private String cant;
   public void setCant(String property){
       this.cant = property;
   }

   private String cantlotpend;
   public void setCantlotpend(String property){
       this.cantlotpend = property;
   }

   private String codcom;
   public void setCodcom(String property){
       this.codcom = property;
   }

   private String codimpue;
   public void setCodimpue(String property){
       this.codimpue = property;
   }

   private String comenser;
   public void setComenser(String property){
       this.comenser = property;
   }

   private String cost;
   public void setCost(String property){
       this.cost = property;
   }

   private String costpro;
   public void setCostpro(String property){
       this.costpro = property;
   }

   private String descad;
   public void setDescad(String property){
       this.descad = property;
   }

   private String descrip;
   public void setDescrip(String property){
       this.descrip = property;
   }

   private String descu;
   public void setDescu(String property){
       this.descu = property;
   }

   private String flotvenc;
   public void setFlotvenc(String property){
       this.flotvenc = property;
   }

   private String garan;
   public void setGaran(String property){
       this.garan = property;
   }

   private String impo;
   public void setImpo(String property){
       this.impo = property;
   }

   private String mon;
   public void setMon(String property){
       this.mon = property;
   }

   private String prod;
   public void setProd(String property){
       this.prod = property;
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
           throw new PartcomprssValidatorsExceptions().getAlmaException();
       }

       if(cant==null || cant.isEmpty()){
           throw new PartcomprssValidatorsExceptions().getCantException();
       }

       if(cantlotpend==null || cantlotpend.isEmpty()){
           throw new PartcomprssValidatorsExceptions().getCantlotpendException();
       }

       if(codcom==null || codcom.isEmpty()){
           throw new PartcomprssValidatorsExceptions().getCodcomException();
       }

       if(codimpue==null || codimpue.isEmpty()){
           throw new PartcomprssValidatorsExceptions().getCodimpueException();
       }

       if(comenser==null || comenser.isEmpty()){
           throw new PartcomprssValidatorsExceptions().getComenserException();
       }

       if(cost==null || cost.isEmpty()){
           throw new PartcomprssValidatorsExceptions().getCostException();
       }

       if(costpro==null || costpro.isEmpty()){
           throw new PartcomprssValidatorsExceptions().getCostproException();
       }

       if(descad==null || descad.isEmpty()){
           throw new PartcomprssValidatorsExceptions().getDescadException();
       }

       if(descrip==null || descrip.isEmpty()){
           throw new PartcomprssValidatorsExceptions().getDescripException();
       }

       if(descu==null || descu.isEmpty()){
           throw new PartcomprssValidatorsExceptions().getDescuException();
       }

       if(flotvenc==null || flotvenc.isEmpty()){
           throw new PartcomprssValidatorsExceptions().getFlotvencException();
       }

       if(garan==null || garan.isEmpty()){
           throw new PartcomprssValidatorsExceptions().getGaranException();
       }

       if(impo==null || impo.isEmpty()){
           throw new PartcomprssValidatorsExceptions().getImpoException();
       }

       if(mon==null || mon.isEmpty()){
           throw new PartcomprssValidatorsExceptions().getMonException();
       }

       if(prod==null || prod.isEmpty()){
           throw new PartcomprssValidatorsExceptions().getProdException();
       }

       if(serprod==null || serprod.isEmpty()){
           throw new PartcomprssValidatorsExceptions().getSerprodException();
       }

       if(tipcam==null || tipcam.isEmpty()){
           throw new PartcomprssValidatorsExceptions().getTipcamException();
       }

       if(unid==null || unid.isEmpty()){
           throw new PartcomprssValidatorsExceptions().getUnidException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new PartcomprssValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new PartcomprssValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

}