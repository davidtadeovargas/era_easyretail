package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.PrevcomprssValidatorsExceptions;
import com.era.models.Prevcomprs;
import com.era.repositories.RepositoryFactory;

public class PrevcomprssValidator extends IValidate{

   private String code;
   public void setCode(String property){
       this.code = property;
   }

   private String estado;
   public void setEstado(String property){
       this.estado = property;
   }

   private String fvenc;
   public void setFvenc(String property){
       this.fvenc = property;
   }

   private String mon;
   public void setMon(String property){
       this.mon = property;
   }

   private String motiv;
   public void setMotiv(String property){
       this.motiv = property;
   }

   private String noser;
   public void setNoser(String property){
       this.noser = property;
   }

   private String nosercomp;
   public void setNosercomp(String property){
       this.nosercomp = property;
   }

   private String prov;
   public void setProv(String property){
       this.prov = property;
   }

   private String ser;
   public void setSer(String property){
       this.ser = property;
   }


   @Override
   public void validateInsert() throws Exception {

       if(code==null || code.isEmpty()){
           throw new PrevcomprssValidatorsExceptions().getCodeException();
       }

       if(estado==null || estado.isEmpty()){
           throw new PrevcomprssValidatorsExceptions().getEstadoException();
       }

       if(fvenc==null || fvenc.isEmpty()){
           throw new PrevcomprssValidatorsExceptions().getFvencException();
       }

       if(mon==null || mon.isEmpty()){
           throw new PrevcomprssValidatorsExceptions().getMonException();
       }

       if(motiv==null || motiv.isEmpty()){
           throw new PrevcomprssValidatorsExceptions().getMotivException();
       }

       if(noser==null || noser.isEmpty()){
           throw new PrevcomprssValidatorsExceptions().getNoserException();
       }

       if(nosercomp==null || nosercomp.isEmpty()){
           throw new PrevcomprssValidatorsExceptions().getNosercompException();
       }

       if(prov==null || prov.isEmpty()){
           throw new PrevcomprssValidatorsExceptions().getProvException();
       }

       if(ser==null || ser.isEmpty()){
           throw new PrevcomprssValidatorsExceptions().getSerException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new PrevcomprssValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new PrevcomprssValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

}