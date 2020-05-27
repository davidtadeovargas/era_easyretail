package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.KitssValidatorsExceptions;
import com.era.models.Kits;
import com.era.repositories.RepositoryFactory;

public class KitssValidator extends IValidate{

   private String code;
   private String alma;
   private String codkit;
   private String prod;

   @Override
   public void validateInsert() throws Exception {

       if(alma==null || alma.isEmpty()){
           throw new KitssValidatorsExceptions().getAlmaException();
       }

       if(codkit==null || codkit.isEmpty()){
           throw new KitssValidatorsExceptions().getCodkitException();
       }

       if(prod==null || prod.isEmpty()){
           throw new KitssValidatorsExceptions().getProdException();
       }

       final Kits Kits = (Kits) RepositoryFactory.getInstance().getKitssRepository().getByCode(code);
       if(Kits != null){            
           throw new KitssValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new KitssValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new KitssValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new KitssValidatorsExceptions().getCodeException();
       }

       final Kits Kits = (Kits) RepositoryFactory.getInstance().getKitssRepository().getByCode(code);
       if(Kits == null){            
           throw new KitssValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new KitssValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}