package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.FacturassValidatorsExceptions;
import com.era.models.Facturas;
import com.era.repositories.RepositoryFactory;

public class FacturassValidator extends IValidate{

   private String code;
   private String cantidad;
   private String clavesat;
   private String cliente;
   private String descripcion;
   private String descuento;
   private String fentrega;
   private String importe;
   private String pdescuento;
   private String precio;
   private String producto;
   private String subtotal;
   private String tdescuento;
   private String total;
   private String total_retencion;
   private String total_traslado;
   private String unidad;
   private String usocfdi;

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

       final Facturas Facturas = (Facturas) RepositoryFactory.getInstance().getFacturassRepository().getByCode(code);
       if(Facturas != null){            
           throw new FacturassValidatorsExceptions().getModelExistsException();
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

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new FacturassValidatorsExceptions().getCodeException();
       }

       final Facturas Facturas = (Facturas) RepositoryFactory.getInstance().getFacturassRepository().getByCode(code);
       if(Facturas == null){            
           throw new FacturassValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new FacturassValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}