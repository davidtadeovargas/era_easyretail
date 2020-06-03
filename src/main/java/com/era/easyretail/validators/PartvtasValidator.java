package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.PartvtasValidatorsExceptions;
import com.era.models.Partvta;
import com.era.repositories.RepositoryFactory;

public class PartvtasValidator extends IValidate{

   private String activo;
   public void setActivo(String property){
       this.activo = property;
   }

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

   private String descrip;
   public void setDescrip(String property){
       this.descrip = property;
   }

   private String descripcionOpcional;
   public void setDescripcionOpcional(String property){
       this.descripcionOpcional = property;
   }

   private String descu;
   public void setDescu(String property){
       this.descu = property;
   }

   private String fcadu;
   public void setFcadu(String property){
       this.fcadu = property;
   }

   private String fentre;
   public void setFentre(String property){
       this.fentre = property;
   }

   private String impo;
   public void setImpo(String property){
       this.impo = property;
   }

   private String impue;
   public void setImpue(String property){
       this.impue = property;
   }

   private String mon;
   public void setMon(String property){
       this.mon = property;
   }

   private String monedaID;
   public void setMonedaID(String property){
       this.monedaID = property;
   }

   private String partidaIdOriginal;
   public void setPartidaIdOriginal(String property){
       this.partidaIdOriginal = property;
   }

   private String peps;
   public void setPeps(String property){
       this.peps = property;
   }

   private String pre;
   public void setPre(String property){
       this.pre = property;
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

   private String tipdoc;
   public void setTipdoc(String property){
       this.tipdoc = property;
   }

   private String ueps;
   public void setUeps(String property){
       this.ueps = property;
   }

   private String unid;
   public void setUnid(String property){
       this.unid = property;
   }

   private String vta;
   public void setVta(String property){
       this.vta = property;
   }


   @Override
   public void validateInsert() throws Exception {

       if(activo==null || activo.isEmpty()){
           throw new PartvtasValidatorsExceptions().getActivoException();
       }

       if(alma==null || alma.isEmpty()){
           throw new PartvtasValidatorsExceptions().getAlmaException();
       }

       if(cant==null || cant.isEmpty()){
           throw new PartvtasValidatorsExceptions().getCantException();
       }

       if(codimpue==null || codimpue.isEmpty()){
           throw new PartvtasValidatorsExceptions().getCodimpueException();
       }

       if(comenser==null || comenser.isEmpty()){
           throw new PartvtasValidatorsExceptions().getComenserException();
       }

       if(descrip==null || descrip.isEmpty()){
           throw new PartvtasValidatorsExceptions().getDescripException();
       }

       if(descripcionOpcional==null || descripcionOpcional.isEmpty()){
           throw new PartvtasValidatorsExceptions().getDescripcionOpcionalException();
       }

       if(descu==null || descu.isEmpty()){
           throw new PartvtasValidatorsExceptions().getDescuException();
       }

       if(fcadu==null || fcadu.isEmpty()){
           throw new PartvtasValidatorsExceptions().getFcaduException();
       }

       if(fentre==null || fentre.isEmpty()){
           throw new PartvtasValidatorsExceptions().getFentreException();
       }

       if(impo==null || impo.isEmpty()){
           throw new PartvtasValidatorsExceptions().getImpoException();
       }

       if(impue==null || impue.isEmpty()){
           throw new PartvtasValidatorsExceptions().getImpueException();
       }

       if(mon==null || mon.isEmpty()){
           throw new PartvtasValidatorsExceptions().getMonException();
       }

       if(monedaID==null || monedaID.isEmpty()){
           throw new PartvtasValidatorsExceptions().getMonedaIDException();
       }

       if(partidaIdOriginal==null || partidaIdOriginal.isEmpty()){
           throw new PartvtasValidatorsExceptions().getPartidaIdOriginalException();
       }

       if(peps==null || peps.isEmpty()){
           throw new PartvtasValidatorsExceptions().getPepsException();
       }

       if(pre==null || pre.isEmpty()){
           throw new PartvtasValidatorsExceptions().getPreException();
       }

       if(prod==null || prod.isEmpty()){
           throw new PartvtasValidatorsExceptions().getProdException();
       }

       if(serprod==null || serprod.isEmpty()){
           throw new PartvtasValidatorsExceptions().getSerprodException();
       }

       if(tipcam==null || tipcam.isEmpty()){
           throw new PartvtasValidatorsExceptions().getTipcamException();
       }

       if(tipdoc==null || tipdoc.isEmpty()){
           throw new PartvtasValidatorsExceptions().getTipdocException();
       }

       if(ueps==null || ueps.isEmpty()){
           throw new PartvtasValidatorsExceptions().getUepsException();
       }

       if(unid==null || unid.isEmpty()){
           throw new PartvtasValidatorsExceptions().getUnidException();
       }

       if(vta==null || vta.isEmpty()){
           throw new PartvtasValidatorsExceptions().getVtaException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new PartvtasValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new PartvtasValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

}