package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.PartvtasValidatorsExceptions;
import com.era.models.Partvta;
import com.era.repositories.RepositoryFactory;

public class PartvtasValidator extends IValidate{

   private String code;
   private String activo;
   private String alma;
   private String cant;
   private String codimpue;
   private String comenser;
   private String descrip;
   private String descripcionOpcional;
   private String descu;
   private String fcadu;
   private String fentre;
   private String impo;
   private String impue;
   private String mon;
   private String monedaID;
   private String partidaIdOriginal;
   private String peps;
   private String pre;
   private String prod;
   private String serprod;
   private String tipcam;
   private String tipdoc;
   private String ueps;
   private String unid;
   private String vta;

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

       final Partvta Partvta = (Partvta) RepositoryFactory.getInstance().getPartvtasRepository().getByCode(code);
       if(Partvta != null){            
           throw new PartvtasValidatorsExceptions().getModelExistsException();
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

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new PartvtasValidatorsExceptions().getCodeException();
       }

       final Partvta Partvta = (Partvta) RepositoryFactory.getInstance().getPartvtasRepository().getByCode(code);
       if(Partvta == null){            
           throw new PartvtasValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new PartvtasValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}