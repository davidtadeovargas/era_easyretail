package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.ControlexportarsValidatorsExceptions;
import com.era.models.Controlexportar;
import com.era.repositories.RepositoryFactory;

public class ControlexportarsValidator extends IValidate{

   private String id_ultimaVentaExpo;
   public void setId_ultimaVentaExpo(String property){
       this.id_ultimaVentaExpo = property;
   }

   private String id_ultimapartidaExpo;
   public void setId_ultimapartidaExpo(String property){
       this.id_ultimapartidaExpo = property;
   }

   private String tipo;
   public void setTipo(String property){
       this.tipo = property;
   }


   @Override
   public void validateInsert() throws Exception {

       if(id_ultimaVentaExpo==null || id_ultimaVentaExpo.isEmpty()){
           throw new ControlexportarsValidatorsExceptions().getId_ultimaVentaExpoException();
       }

       if(id_ultimapartidaExpo==null || id_ultimapartidaExpo.isEmpty()){
           throw new ControlexportarsValidatorsExceptions().getId_ultimapartidaExpoException();
       }

       if(tipo==null || tipo.isEmpty()){
           throw new ControlexportarsValidatorsExceptions().getTipoException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new ControlexportarsValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new ControlexportarsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

}