package com.era.easyretail.validators.exceptions;

public class ERMmovimientosInventariosValidatorsExceptions {

   private static ERMmovimientosInventariosValidatorsExceptions ERMmovimientosInventariosValidatorsExceptions;

   public static ERMmovimientosInventariosValidatorsExceptions getSigleton(){
       if(ERMmovimientosInventariosValidatorsExceptions==null){ERMmovimientosInventariosValidatorsExceptions = new ERMmovimientosInventariosValidatorsExceptions();}return ERMmovimientosInventariosValidatorsExceptions;
   }

   public Exception getModelExistsException(){
       return new Exception("El registro ya existe");
   }

   public Exception getCustomVaidationNotPassedException(){
       return new Exception("El registro no paso las validaciones");
   }

   public Exception getModelNotExistsException(){
       return new Exception("El registro no existe");
   }

   public Exception getCodeException(){
       return new Exception("Falta espeficiar codigo");
   }

   public Exception getFechaMovimientoException(){
       return new Exception("Falta espeficiar FechaMovimiento");
   }

   public Exception getIdAlmacenException(){
       return new Exception("Falta espeficiar IdAlmacen");
   }

   public Exception getIdMovtoComercialException(){
       return new Exception("Falta espeficiar IdMovtoComercial");
   }

   public Exception getIdProductoException(){
       return new Exception("Falta espeficiar IdProducto");
   }

   public Exception getTimestampException(){
       return new Exception("Falta espeficiar Timestamp");
   }

}