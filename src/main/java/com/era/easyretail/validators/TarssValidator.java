package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.TarssValidatorsExceptions;
import com.era.models.Tars;
import com.era.repositories.RepositoryFactory;

public class TarssValidator extends IValidate{

   private String cli;
   public void setCli(String property){
       this.cli = property;
   }

   private String exter;
   public void setExter(String property){
       this.exter = property;
   }

   private String factur;
   public void setFactur(String property){
       this.factur = property;
   }

   private String factuya;
   public void setFactuya(String property){
       this.factuya = property;
   }

   private String ffactu;
   public void setFfactu(String property){
       this.ffactu = property;
   }

   private String loc;
   public void setLoc(String property){
       this.loc = property;
   }

   private String pag;
   public void setPag(String property){
       this.pag = property;
   }

   private String prepag;
   public void setPrepag(String property){
       this.prepag = property;
   }

   private String tar;
   public void setTar(String property){
       this.tar = property;
   }


   @Override
   public void validateInsert() throws Exception {

       if(cli==null || cli.isEmpty()){
           throw new TarssValidatorsExceptions().getCliException();
       }

       if(exter==null || exter.isEmpty()){
           throw new TarssValidatorsExceptions().getExterException();
       }

       if(factur==null || factur.isEmpty()){
           throw new TarssValidatorsExceptions().getFacturException();
       }

       if(factuya==null || factuya.isEmpty()){
           throw new TarssValidatorsExceptions().getFactuyaException();
       }

       if(ffactu==null || ffactu.isEmpty()){
           throw new TarssValidatorsExceptions().getFfactuException();
       }

       if(loc==null || loc.isEmpty()){
           throw new TarssValidatorsExceptions().getLocException();
       }

       if(pag==null || pag.isEmpty()){
           throw new TarssValidatorsExceptions().getPagException();
       }

       if(prepag==null || prepag.isEmpty()){
           throw new TarssValidatorsExceptions().getPrepagException();
       }

       if(tar==null || tar.isEmpty()){
           throw new TarssValidatorsExceptions().getTarException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new TarssValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new TarssValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

}