package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.PartprevcomprssValidatorsExceptions;
import com.era.models.Partprevcomprs;
import com.era.repositories.RepositoryFactory;

public class PartprevcomprssValidator extends IValidate{

   private String alma;
   public void setAlma(String property){
       this.alma = property;
   }

   private String cant;
   public void setCant(String property){
       this.cant = property;
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

   private String descrip;
   public void setDescrip(String property){
       this.descrip = property;
   }

   private String flotvenc;
   public void setFlotvenc(String property){
       this.flotvenc = property;
   }

   private String garan;
   public void setGaran(String property){
       this.garan = property;
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

   private String unid;
   public void setUnid(String property){
       this.unid = property;
   }


   @Override
   public void validateInsert() throws Exception {

       if(alma==null || alma.isEmpty()){
           throw new PartprevcomprssValidatorsExceptions().getAlmaException();
       }

       if(cant==null || cant.isEmpty()){
           throw new PartprevcomprssValidatorsExceptions().getCantException();
       }

       if(codcom==null || codcom.isEmpty()){
           throw new PartprevcomprssValidatorsExceptions().getCodcomException();
       }

       if(codimpue==null || codimpue.isEmpty()){
           throw new PartprevcomprssValidatorsExceptions().getCodimpueException();
       }

       if(comenser==null || comenser.isEmpty()){
           throw new PartprevcomprssValidatorsExceptions().getComenserException();
       }

       if(descrip==null || descrip.isEmpty()){
           throw new PartprevcomprssValidatorsExceptions().getDescripException();
       }

       if(flotvenc==null || flotvenc.isEmpty()){
           throw new PartprevcomprssValidatorsExceptions().getFlotvencException();
       }

       if(garan==null || garan.isEmpty()){
           throw new PartprevcomprssValidatorsExceptions().getGaranException();
       }

       if(mon==null || mon.isEmpty()){
           throw new PartprevcomprssValidatorsExceptions().getMonException();
       }

       if(prod==null || prod.isEmpty()){
           throw new PartprevcomprssValidatorsExceptions().getProdException();
       }

       if(serprod==null || serprod.isEmpty()){
           throw new PartprevcomprssValidatorsExceptions().getSerprodException();
       }

       if(unid==null || unid.isEmpty()){
           throw new PartprevcomprssValidatorsExceptions().getUnidException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new PartprevcomprssValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new PartprevcomprssValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

}