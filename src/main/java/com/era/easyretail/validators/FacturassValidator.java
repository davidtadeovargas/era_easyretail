package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.FacturassValidatorsExceptions;
import com.era.models.Facturas;
import com.era.repositories.RepositoryFactory;

public class FacturassValidator extends IValidate{

   private String cantidad;
   public void setCantidad(String property){
       this.cantidad = property;
   }

   private String clavesat;
   public void setClavesat(String property){
       this.clavesat = property;
   }

   private String cliente;
   public void setCliente(String property){
       this.cliente = property;
   }

   private String descripcion;
   public void setDescripcion(String property){
       this.descripcion = property;
   }

   private String descuento;
   public void setDescuento(String property){
       this.descuento = property;
   }

   private String fentrega;
   public void setFentrega(String property){
       this.fentrega = property;
   }

   private String importe;
   public void setImporte(String property){
       this.importe = property;
   }

   private String pdescuento;
   public void setPdescuento(String property){
       this.pdescuento = property;
   }

   private String precio;
   public void setPrecio(String property){
       this.precio = property;
   }

   private String producto;
   public void setProducto(String property){
       this.producto = property;
   }

   private String subtotal;
   public void setSubtotal(String property){
       this.subtotal = property;
   }

   private String tdescuento;
   public void setTdescuento(String property){
       this.tdescuento = property;
   }

   private String total;
   public void setTotal(String property){
       this.total = property;
   }

   private String total_retencion;
   public void setTotal_retencion(String property){
       this.total_retencion = property;
   }

   private String total_traslado;
   public void setTotal_traslado(String property){
       this.total_traslado = property;
   }

   private String unidad;
   public void setUnidad(String property){
       this.unidad = property;
   }

   private String usocfdi;
   public void setUsocfdi(String property){
       this.usocfdi = property;
   }


   @Override
   public void validateInsert() throws Exception {

       if(cantidad==null || cantidad.isEmpty()){
           throw new FacturassValidatorsExceptions().getCantidadException();
       }

       if(clavesat==null || clavesat.isEmpty()){
           throw new FacturassValidatorsExceptions().getClavesatException();
       }

       if(cliente==null || cliente.isEmpty()){
           throw new FacturassValidatorsExceptions().getClienteException();
       }

       if(descripcion==null || descripcion.isEmpty()){
           throw new FacturassValidatorsExceptions().getDescripcionException();
       }

       if(descuento==null || descuento.isEmpty()){
           throw new FacturassValidatorsExceptions().getDescuentoException();
       }

       if(fentrega==null || fentrega.isEmpty()){
           throw new FacturassValidatorsExceptions().getFentregaException();
       }

       if(importe==null || importe.isEmpty()){
           throw new FacturassValidatorsExceptions().getImporteException();
       }

       if(pdescuento==null || pdescuento.isEmpty()){
           throw new FacturassValidatorsExceptions().getPdescuentoException();
       }

       if(precio==null || precio.isEmpty()){
           throw new FacturassValidatorsExceptions().getPrecioException();
       }

       if(producto==null || producto.isEmpty()){
           throw new FacturassValidatorsExceptions().getProductoException();
       }

       if(subtotal==null || subtotal.isEmpty()){
           throw new FacturassValidatorsExceptions().getSubtotalException();
       }

       if(tdescuento==null || tdescuento.isEmpty()){
           throw new FacturassValidatorsExceptions().getTdescuentoException();
       }

       if(total==null || total.isEmpty()){
           throw new FacturassValidatorsExceptions().getTotalException();
       }

       if(total_retencion==null || total_retencion.isEmpty()){
           throw new FacturassValidatorsExceptions().getTotal_retencionException();
       }

       if(total_traslado==null || total_traslado.isEmpty()){
           throw new FacturassValidatorsExceptions().getTotal_trasladoException();
       }

       if(unidad==null || unidad.isEmpty()){
           throw new FacturassValidatorsExceptions().getUnidadException();
       }

       if(usocfdi==null || usocfdi.isEmpty()){
           throw new FacturassValidatorsExceptions().getUsocfdiException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new FacturassValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new FacturassValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

}