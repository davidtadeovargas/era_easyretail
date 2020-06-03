package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.PartcotsValidatorsExceptions;
import com.era.models.Partcot;
import com.era.repositories.RepositoryFactory;

public class PartcotsValidator extends IValidate{

   private String alma;
   public void setAlma(String property){
       this.alma = property;
   }

   private String cant;
   public void setCant(String property){
       this.cant = property;
   }

   private String codcot;
   public void setCodcot(String property){
       this.codcot = property;
   }

   private String codimpue;
   public void setCodimpue(String property){
       this.codimpue = property;
   }

   private String comenser;
   public void setComenser(String property){
       this.comenser = property;
   }

   private String desc1;
   public void setDesc1(String property){
       this.desc1 = property;
   }

   private String desc2;
   public void setDesc2(String property){
       this.desc2 = property;
   }

   private String desc3;
   public void setDesc3(String property){
       this.desc3 = property;
   }

   private String desc4;
   public void setDesc4(String property){
       this.desc4 = property;
   }

   private String desc5;
   public void setDesc5(String property){
       this.desc5 = property;
   }

   private String descrip;
   public void setDescrip(String property){
       this.descrip = property;
   }

   private String fcadu;
   public void setFcadu(String property){
       this.fcadu = property;
   }

   private String impo2;
   public void setImpo2(String property){
       this.impo2 = property;
   }

   private String impueimpo2;
   public void setImpueimpo2(String property){
       this.impueimpo2 = property;
   }

   private String mon;
   public void setMon(String property){
       this.mon = property;
   }

   private String pre2;
   public void setPre2(String property){
       this.pre2 = property;
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
           throw new PartcotsValidatorsExceptions().getAlmaException();
       }

       if(cant==null || cant.isEmpty()){
           throw new PartcotsValidatorsExceptions().getCantException();
       }

       if(codcot==null || codcot.isEmpty()){
           throw new PartcotsValidatorsExceptions().getCodcotException();
       }

       if(codimpue==null || codimpue.isEmpty()){
           throw new PartcotsValidatorsExceptions().getCodimpueException();
       }

       if(comenser==null || comenser.isEmpty()){
           throw new PartcotsValidatorsExceptions().getComenserException();
       }

       if(desc1==null || desc1.isEmpty()){
           throw new PartcotsValidatorsExceptions().getDesc1Exception();
       }

       if(desc2==null || desc2.isEmpty()){
           throw new PartcotsValidatorsExceptions().getDesc2Exception();
       }

       if(desc3==null || desc3.isEmpty()){
           throw new PartcotsValidatorsExceptions().getDesc3Exception();
       }

       if(desc4==null || desc4.isEmpty()){
           throw new PartcotsValidatorsExceptions().getDesc4Exception();
       }

       if(desc5==null || desc5.isEmpty()){
           throw new PartcotsValidatorsExceptions().getDesc5Exception();
       }

       if(descrip==null || descrip.isEmpty()){
           throw new PartcotsValidatorsExceptions().getDescripException();
       }

       if(fcadu==null || fcadu.isEmpty()){
           throw new PartcotsValidatorsExceptions().getFcaduException();
       }

       if(impo2==null || impo2.isEmpty()){
           throw new PartcotsValidatorsExceptions().getImpo2Exception();
       }

       if(impueimpo2==null || impueimpo2.isEmpty()){
           throw new PartcotsValidatorsExceptions().getImpueimpo2Exception();
       }

       if(mon==null || mon.isEmpty()){
           throw new PartcotsValidatorsExceptions().getMonException();
       }

       if(pre2==null || pre2.isEmpty()){
           throw new PartcotsValidatorsExceptions().getPre2Exception();
       }

       if(prod==null || prod.isEmpty()){
           throw new PartcotsValidatorsExceptions().getProdException();
       }

       if(serprod==null || serprod.isEmpty()){
           throw new PartcotsValidatorsExceptions().getSerprodException();
       }

       if(unid==null || unid.isEmpty()){
           throw new PartcotsValidatorsExceptions().getUnidException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new PartcotsValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new PartcotsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

}