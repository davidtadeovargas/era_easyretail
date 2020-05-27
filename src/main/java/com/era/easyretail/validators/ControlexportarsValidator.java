package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.ControlexportarsValidatorsExceptions;
import com.era.models.Controlexportar;
import com.era.repositories.RepositoryFactory;

public class ControlexportarsValidator extends IValidate{

   private String code;
   private String id_ultimaVentaExpo;
   private String id_ultimapartidaExpo;
   private String tipo;

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

       final Controlexportar Controlexportar = (Controlexportar) RepositoryFactory.getInstance().getControlexportarsRepository().getByCode(code);
       if(Controlexportar != null){            
           throw new ControlexportarsValidatorsExceptions().getModelExistsException();
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

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new ControlexportarsValidatorsExceptions().getCodeException();
       }

       final Controlexportar Controlexportar = (Controlexportar) RepositoryFactory.getInstance().getControlexportarsRepository().getByCode(code);
       if(Controlexportar == null){            
           throw new ControlexportarsValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new ControlexportarsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}