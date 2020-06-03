package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.CxcsValidatorsExceptions;
import com.era.models.Cxc;
import com.era.repositories.RepositoryFactory;

public class CxcsValidator extends IValidate{

   private String abon;
   public void setAbon(String property){
       this.abon = property;
   }

   private String carg;
   public void setCarg(String property){
       this.carg = property;
   }

   private String empre;
   public void setEmpre(String property){
       this.empre = property;
   }

   private String fdoc;
   public void setFdoc(String property){
       this.fdoc = property;
   }

   private String id_venta;
   public void setId_venta(String property){
       this.id_venta = property;
   }

   private String impue;
   public void setImpue(String property){
       this.impue = property;
   }

   private String monedaID;
   public void setMonedaID(String property){
       this.monedaID = property;
   }

   private String norefer;
   public void setNorefer(String property){
       this.norefer = property;
   }

   private String noser;
   public void setNoser(String property){
       this.noser = property;
   }

   private String ser;
   public void setSer(String property){
       this.ser = property;
   }

   private String subtot;
   public void setSubtot(String property){
       this.subtot = property;
   }

   private String tot;
   public void setTot(String property){
       this.tot = property;
   }


   @Override
   public void validateInsert() throws Exception {

       if(abon==null || abon.isEmpty()){
           throw new CxcsValidatorsExceptions().getAbonException();
       }

       if(carg==null || carg.isEmpty()){
           throw new CxcsValidatorsExceptions().getCargException();
       }

       if(empre==null || empre.isEmpty()){
           throw new CxcsValidatorsExceptions().getEmpreException();
       }

       if(fdoc==null || fdoc.isEmpty()){
           throw new CxcsValidatorsExceptions().getFdocException();
       }

       if(id_venta==null || id_venta.isEmpty()){
           throw new CxcsValidatorsExceptions().getId_ventaException();
       }

       if(impue==null || impue.isEmpty()){
           throw new CxcsValidatorsExceptions().getImpueException();
       }

       if(monedaID==null || monedaID.isEmpty()){
           throw new CxcsValidatorsExceptions().getMonedaIDException();
       }

       if(norefer==null || norefer.isEmpty()){
           throw new CxcsValidatorsExceptions().getNoreferException();
       }

       if(noser==null || noser.isEmpty()){
           throw new CxcsValidatorsExceptions().getNoserException();
       }

       if(ser==null || ser.isEmpty()){
           throw new CxcsValidatorsExceptions().getSerException();
       }

       if(subtot==null || subtot.isEmpty()){
           throw new CxcsValidatorsExceptions().getSubtotException();
       }

       if(tot==null || tot.isEmpty()){
           throw new CxcsValidatorsExceptions().getTotException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new CxcsValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new CxcsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

}