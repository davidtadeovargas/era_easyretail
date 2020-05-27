package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.ERMmovimientosInventariosValidatorsExceptions;
import com.era.models.ERMmovimientosInventario;
import com.era.repositories.RepositoryFactory;

public class ERMmovimientosInventariosValidator extends IValidate{

   private String code;
   private String fechaMovimiento;
   private String idAlmacen;
   private String idMovtoComercial;
   private String idProducto;
   private String timestamp;

   @Override
   public void validateInsert() throws Exception {

       if(fechaMovimiento==null || fechaMovimiento.isEmpty()){
           throw new ERMmovimientosInventariosValidatorsExceptions().getFechaMovimientoException();
       }

       if(idAlmacen==null || idAlmacen.isEmpty()){
           throw new ERMmovimientosInventariosValidatorsExceptions().getIdAlmacenException();
       }

       if(idMovtoComercial==null || idMovtoComercial.isEmpty()){
           throw new ERMmovimientosInventariosValidatorsExceptions().getIdMovtoComercialException();
       }

       if(idProducto==null || idProducto.isEmpty()){
           throw new ERMmovimientosInventariosValidatorsExceptions().getIdProductoException();
       }

       if(timestamp==null || timestamp.isEmpty()){
           throw new ERMmovimientosInventariosValidatorsExceptions().getTimestampException();
       }

       final ERMmovimientosInventario ERMmovimientosInventario = (ERMmovimientosInventario) RepositoryFactory.getInstance().getERMmovimientosInventariosRepository().getByCode(code);
       if(ERMmovimientosInventario != null){            
           throw new ERMmovimientosInventariosValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new ERMmovimientosInventariosValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new ERMmovimientosInventariosValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new ERMmovimientosInventariosValidatorsExceptions().getCodeException();
       }

       final ERMmovimientosInventario ERMmovimientosInventario = (ERMmovimientosInventario) RepositoryFactory.getInstance().getERMmovimientosInventariosRepository().getByCode(code);
       if(ERMmovimientosInventario == null){            
           throw new ERMmovimientosInventariosValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new ERMmovimientosInventariosValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}