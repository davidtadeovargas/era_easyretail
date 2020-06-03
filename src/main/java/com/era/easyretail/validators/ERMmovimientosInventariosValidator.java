package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.ERMmovimientosInventariosValidatorsExceptions;
import com.era.models.ERMmovimientosInventario;
import com.era.repositories.RepositoryFactory;

public class ERMmovimientosInventariosValidator extends IValidate{

   private String fechaMovimiento;
   public void setFechaMovimiento(String property){
       this.fechaMovimiento = property;
   }

   private String idAlmacen;
   public void setIdAlmacen(String property){
       this.idAlmacen = property;
   }

   private String idMovtoComercial;
   public void setIdMovtoComercial(String property){
       this.idMovtoComercial = property;
   }

   private String idProducto;
   public void setIdProducto(String property){
       this.idProducto = property;
   }

   private String timestamp;
   public void setTimestamp(String property){
       this.timestamp = property;
   }


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

}