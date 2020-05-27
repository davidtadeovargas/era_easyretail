package com.era.easyretail.validators.exceptions;

public class FacturassValidatorsExceptions {

   private static FacturassValidatorsExceptions FacturassValidatorsExceptions;

   public static FacturassValidatorsExceptions getSigleton(){
       if(FacturassValidatorsExceptions==null){FacturassValidatorsExceptions = new FacturassValidatorsExceptions();}return FacturassValidatorsExceptions;
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

   public Exception getCantidadException(){
       return new Exception("Falta espeficiar Cantidad");
   }

   public Exception getClavesatException(){
       return new Exception("Falta espeficiar Clavesat");
   }

   public Exception getClienteException(){
       return new Exception("Falta espeficiar Cliente");
   }

   public Exception getDescripcionException(){
       return new Exception("Falta espeficiar Descripcion");
   }

   public Exception getDescuentoException(){
       return new Exception("Falta espeficiar Descuento");
   }

   public Exception getFentregaException(){
       return new Exception("Falta espeficiar Fentrega");
   }

   public Exception getImporteException(){
       return new Exception("Falta espeficiar Importe");
   }

   public Exception getPdescuentoException(){
       return new Exception("Falta espeficiar Pdescuento");
   }

   public Exception getPrecioException(){
       return new Exception("Falta espeficiar Precio");
   }

   public Exception getProductoException(){
       return new Exception("Falta espeficiar Producto");
   }

   public Exception getSubtotalException(){
       return new Exception("Falta espeficiar Subtotal");
   }

   public Exception getTdescuentoException(){
       return new Exception("Falta espeficiar Tdescuento");
   }

   public Exception getTotalException(){
       return new Exception("Falta espeficiar Total");
   }

   public Exception getTotal_retencionException(){
       return new Exception("Falta espeficiar Total_retencion");
   }

   public Exception getTotal_trasladoException(){
       return new Exception("Falta espeficiar Total_traslado");
   }

   public Exception getUnidadException(){
       return new Exception("Falta espeficiar Unidad");
   }

   public Exception getUsocfdiException(){
       return new Exception("Falta espeficiar Usocfdi");
   }

}