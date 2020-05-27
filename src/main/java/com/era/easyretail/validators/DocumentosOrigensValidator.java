package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.DocumentosOrigensValidatorsExceptions;
import com.era.models.DocumentosOrigen;
import com.era.repositories.RepositoryFactory;

public class DocumentosOrigensValidator extends IValidate{

   private String code;
   private String nombre;
   private String tipo;

   @Override
   public void validateInsert() throws Exception {

       if(nombre==null || nombre.isEmpty()){
           throw new DocumentosOrigensValidatorsExceptions().getNombreException();
       }

       if(tipo==null || tipo.isEmpty()){
           throw new DocumentosOrigensValidatorsExceptions().getTipoException();
       }

       final DocumentosOrigen DocumentosOrigen = (DocumentosOrigen) RepositoryFactory.getInstance().getDocumentosOrigensRepository().getByCode(code);
       if(DocumentosOrigen != null){            
           throw new DocumentosOrigensValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new DocumentosOrigensValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new DocumentosOrigensValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new DocumentosOrigensValidatorsExceptions().getCodeException();
       }

       final DocumentosOrigen DocumentosOrigen = (DocumentosOrigen) RepositoryFactory.getInstance().getDocumentosOrigensRepository().getByCode(code);
       if(DocumentosOrigen == null){            
           throw new DocumentosOrigensValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new DocumentosOrigensValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}