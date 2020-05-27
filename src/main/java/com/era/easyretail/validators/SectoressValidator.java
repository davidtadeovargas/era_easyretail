package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.SectoressValidatorsExceptions;
import com.era.models.Sectores;
import com.era.repositories.RepositoryFactory;

public class SectoressValidator extends IValidate{

   private String code;
   private String codigo;
   private String descripcion;

   @Override
   public void validateInsert() throws Exception {

       if(codigo==null || codigo.isEmpty()){
           throw new SectoressValidatorsExceptions().getCodigoException();
       }

       if(descripcion==null || descripcion.isEmpty()){
           throw new SectoressValidatorsExceptions().getDescripcionException();
       }

       final Sectores Sectores = (Sectores) RepositoryFactory.getInstance().getSectoressRepository().getByCode(code);
       if(Sectores != null){            
           throw new SectoressValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new SectoressValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new SectoressValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new SectoressValidatorsExceptions().getCodeException();
       }

       final Sectores Sectores = (Sectores) RepositoryFactory.getInstance().getSectoressRepository().getByCode(code);
       if(Sectores == null){            
           throw new SectoressValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new SectoressValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}