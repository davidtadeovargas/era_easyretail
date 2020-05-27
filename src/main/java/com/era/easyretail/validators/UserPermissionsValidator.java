package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.UserPermissionsValidatorsExceptions;
import com.era.models.UserPermission;
import com.era.repositories.RepositoryFactory;

public class UserPermissionsValidator extends IValidate{

   private String code;
   private String otorgaPermisoCxc;
   private String otorgaPermisosClientes;
   private String otorgaPermisosCompras;
   private String otorgaPermisosConfig;
   private String otorgaPermisosCotiza;
   private String otorgaPermisosInventario;
   private String otorgaPermisosModulos;
   private String otorgaPermisosPrevio;
   private String otorgaPermisosProvee;
   private String otorgaPermisosSistema;
   private String otorgaPermisosVentas;
   private String permisProductosBorrar;
   private String permisProductosCargadoImagen;
   private String permisProductosListaPrecio;
   private String permisoActivarSistema;
   private String permisoBaseDatos;
   private String permisoBaseDatosArchivo;
   private String permisoBaseDatosConexiones;
   private String permisoCambiarIcono;
   private String permisoCancelarPago;
   private String permisoCatalogoGarantias;
   private String permisoClaves;
   private String permisoClientes;
   private String permisoClientesBorrar;
   private String permisoClientesEnviar;
   private String permisoClientesModificar;
   private String permisoClientesNuevo;
   private String permisoClientesVer;
   private String permisoCompras;
   private String permisoComprasBorrarArchivo;
   private String permisoComprasCancelar;
   private String permisoComprasCargarArchivo;
   private String permisoComprasDevolucion;
   private String permisoComprasNotCredito;
   private String permisoComprasNuevo;
   private String permisoComprasParcial;
   private String permisoComprasRecibirOrden;
   private String permisoComprasVer;
   private String permisoConceptosNC;
   private String permisoConf;
   private String permisoConfiguracionesGenerales;
   private String permisoContabilidad;
   private String permisoCorreos;
   private String permisoCotiza;
   private String permisoCotizaAbrir;
   private String permisoCotizaCancelar;
   private String permisoCotizaNueva;
   private String permisoCotizaReenviar;
   private String permisoCotizaVenta;
   private String permisoCotizaVer;
   private String permisoCxc;
   private String permisoDatosEmpresa;
   private String permisoGiros;
   private String permisoImpresoras;
   private String permisoImpuestos;
   private String permisoInventario;
   private String permisoMonedas;
   private String permisoPagoNuevo;
   private String permisoPrevio;
   private String permisoPrevioAbrir;
   private String permisoPrevioCancelar;
   private String permisoPrevioCompra;
   private String permisoPrevioNueva;
   private String permisoPrevioSeries;
   private String permisoPrevioVer;
   private String permisoProductos;
   private String permisoProductosModificar;
   private String permisoProductosNuevo;
   private String permisoProvee;
   private String permisoProveeBorrar;
   private String permisoProveeModificar;
   private String permisoProveeNuevo;
   private String permisoProveeVer;
   private String permisoReparar;
   private String permisoRepararErrores;
   private String permisoRepararRestaurar;
   private String permisoReportes;
   private String permisoReportesEstadistica;
   private String permisoReportesLog;
   private String permisoReportesRespaldos;
   private String permisoReportesUsuarios;
   private String permisoRevocacion;
   private String permisoSeries;
   private String permisoUsuarios;
   private String permisoUsuariosConectados;
   private String permisoUsuariosDefinir;
   private String permisoUsuariosPermisos;
   private String permisoVentas;
   private String permisoVentasAcuse;
   private String permisoVentasBorrarArchivo;
   private String permisoVentasCancelar;
   private String permisoVentasCargarArchivo;
   private String permisoVentasComprobar;
   private String permisoVentasDevolucion;
   private String permisoVentasEntregar;
   private String permisoVentasEnviar;
   private String permisoVentasFacturar;
   private String permisoVentasNotCredito;
   private String permisoVentasNueva;
   private String permisoVentasObtenerXml;
   private String permisoVentasParcial;
   private String permisoVentasTimbrar;
   private String permisoVentasVer;
   private String permisoZonas;
   private String userID;

   @Override
   public void validateInsert() throws Exception {

       if(otorgaPermisoCxc==null || otorgaPermisoCxc.isEmpty()){
           throw new UserPermissionsValidatorsExceptions().getOtorgaPermisoCxcException();
       }

       if(otorgaPermisosClientes==null || otorgaPermisosClientes.isEmpty()){
           throw new UserPermissionsValidatorsExceptions().getOtorgaPermisosClientesException();
       }

       if(otorgaPermisosCompras==null || otorgaPermisosCompras.isEmpty()){
           throw new UserPermissionsValidatorsExceptions().getOtorgaPermisosComprasException();
       }

       if(otorgaPermisosConfig==null || otorgaPermisosConfig.isEmpty()){
           throw new UserPermissionsValidatorsExceptions().getOtorgaPermisosConfigException();
       }

       if(otorgaPermisosCotiza==null || otorgaPermisosCotiza.isEmpty()){
           throw new UserPermissionsValidatorsExceptions().getOtorgaPermisosCotizaException();
       }

       if(otorgaPermisosInventario==null || otorgaPermisosInventario.isEmpty()){
           throw new UserPermissionsValidatorsExceptions().getOtorgaPermisosInventarioException();
       }

       if(otorgaPermisosModulos==null || otorgaPermisosModulos.isEmpty()){
           throw new UserPermissionsValidatorsExceptions().getOtorgaPermisosModulosException();
       }

       if(otorgaPermisosPrevio==null || otorgaPermisosPrevio.isEmpty()){
           throw new UserPermissionsValidatorsExceptions().getOtorgaPermisosPrevioException();
       }

       if(otorgaPermisosProvee==null || otorgaPermisosProvee.isEmpty()){
           throw new UserPermissionsValidatorsExceptions().getOtorgaPermisosProveeException();
       }

       if(otorgaPermisosSistema==null || otorgaPermisosSistema.isEmpty()){
           throw new UserPermissionsValidatorsExceptions().getOtorgaPermisosSistemaException();
       }

       if(otorgaPermisosVentas==null || otorgaPermisosVentas.isEmpty()){
           throw new UserPermissionsValidatorsExceptions().getOtorgaPermisosVentasException();
       }

       if(permisProductosBorrar==null || permisProductosBorrar.isEmpty()){
           throw new UserPermissionsValidatorsExceptions().getPermisProductosBorrarException();
       }

       if(permisProductosCargadoImagen==null || permisProductosCargadoImagen.isEmpty()){
           throw new UserPermissionsValidatorsExceptions().getPermisProductosCargadoImagenException();
       }

       if(permisProductosListaPrecio==null || permisProductosListaPrecio.isEmpty()){
           throw new UserPermissionsValidatorsExceptions().getPermisProductosListaPrecioException();
       }

       if(permisoActivarSistema==null || permisoActivarSistema.isEmpty()){
           throw new UserPermissionsValidatorsExceptions().getPermisoActivarSistemaException();
       }

       if(permisoBaseDatos==null || permisoBaseDatos.isEmpty()){
           throw new UserPermissionsValidatorsExceptions().getPermisoBaseDatosException();
       }

       if(permisoBaseDatosArchivo==null || permisoBaseDatosArchivo.isEmpty()){
           throw new UserPermissionsValidatorsExceptions().getPermisoBaseDatosArchivoException();
       }

       if(permisoBaseDatosConexiones==null || permisoBaseDatosConexiones.isEmpty()){
           throw new UserPermissionsValidatorsExceptions().getPermisoBaseDatosConexionesException();
       }

       if(permisoCambiarIcono==null || permisoCambiarIcono.isEmpty()){
           throw new UserPermissionsValidatorsExceptions().getPermisoCambiarIconoException();
       }

       if(permisoCancelarPago==null || permisoCancelarPago.isEmpty()){
           throw new UserPermissionsValidatorsExceptions().getPermisoCancelarPagoException();
       }

       if(permisoCatalogoGarantias==null || permisoCatalogoGarantias.isEmpty()){
           throw new UserPermissionsValidatorsExceptions().getPermisoCatalogoGarantiasException();
       }

       if(permisoClaves==null || permisoClaves.isEmpty()){
           throw new UserPermissionsValidatorsExceptions().getPermisoClavesException();
       }

       if(permisoClientes==null || permisoClientes.isEmpty()){
           throw new UserPermissionsValidatorsExceptions().getPermisoClientesException();
       }

       if(permisoClientesBorrar==null || permisoClientesBorrar.isEmpty()){
           throw new UserPermissionsValidatorsExceptions().getPermisoClientesBorrarException();
       }

       if(permisoClientesEnviar==null || permisoClientesEnviar.isEmpty()){
           throw new UserPermissionsValidatorsExceptions().getPermisoClientesEnviarException();
       }

       if(permisoClientesModificar==null || permisoClientesModificar.isEmpty()){
           throw new UserPermissionsValidatorsExceptions().getPermisoClientesModificarException();
       }

       if(permisoClientesNuevo==null || permisoClientesNuevo.isEmpty()){
           throw new UserPermissionsValidatorsExceptions().getPermisoClientesNuevoException();
       }

       if(permisoClientesVer==null || permisoClientesVer.isEmpty()){
           throw new UserPermissionsValidatorsExceptions().getPermisoClientesVerException();
       }

       if(permisoCompras==null || permisoCompras.isEmpty()){
           throw new UserPermissionsValidatorsExceptions().getPermisoComprasException();
       }

       if(permisoComprasBorrarArchivo==null || permisoComprasBorrarArchivo.isEmpty()){
           throw new UserPermissionsValidatorsExceptions().getPermisoComprasBorrarArchivoException();
       }

       if(permisoComprasCancelar==null || permisoComprasCancelar.isEmpty()){
           throw new UserPermissionsValidatorsExceptions().getPermisoComprasCancelarException();
       }

       if(permisoComprasCargarArchivo==null || permisoComprasCargarArchivo.isEmpty()){
           throw new UserPermissionsValidatorsExceptions().getPermisoComprasCargarArchivoException();
       }

       if(permisoComprasDevolucion==null || permisoComprasDevolucion.isEmpty()){
           throw new UserPermissionsValidatorsExceptions().getPermisoComprasDevolucionException();
       }

       if(permisoComprasNotCredito==null || permisoComprasNotCredito.isEmpty()){
           throw new UserPermissionsValidatorsExceptions().getPermisoComprasNotCreditoException();
       }

       if(permisoComprasNuevo==null || permisoComprasNuevo.isEmpty()){
           throw new UserPermissionsValidatorsExceptions().getPermisoComprasNuevoException();
       }

       if(permisoComprasParcial==null || permisoComprasParcial.isEmpty()){
           throw new UserPermissionsValidatorsExceptions().getPermisoComprasParcialException();
       }

       if(permisoComprasRecibirOrden==null || permisoComprasRecibirOrden.isEmpty()){
           throw new UserPermissionsValidatorsExceptions().getPermisoComprasRecibirOrdenException();
       }

       if(permisoComprasVer==null || permisoComprasVer.isEmpty()){
           throw new UserPermissionsValidatorsExceptions().getPermisoComprasVerException();
       }

       if(permisoConceptosNC==null || permisoConceptosNC.isEmpty()){
           throw new UserPermissionsValidatorsExceptions().getPermisoConceptosNCException();
       }

       if(permisoConf==null || permisoConf.isEmpty()){
           throw new UserPermissionsValidatorsExceptions().getPermisoConfException();
       }

       if(permisoConfiguracionesGenerales==null || permisoConfiguracionesGenerales.isEmpty()){
           throw new UserPermissionsValidatorsExceptions().getPermisoConfiguracionesGeneralesException();
       }

       if(permisoContabilidad==null || permisoContabilidad.isEmpty()){
           throw new UserPermissionsValidatorsExceptions().getPermisoContabilidadException();
       }

       if(permisoCorreos==null || permisoCorreos.isEmpty()){
           throw new UserPermissionsValidatorsExceptions().getPermisoCorreosException();
       }

       if(permisoCotiza==null || permisoCotiza.isEmpty()){
           throw new UserPermissionsValidatorsExceptions().getPermisoCotizaException();
       }

       if(permisoCotizaAbrir==null || permisoCotizaAbrir.isEmpty()){
           throw new UserPermissionsValidatorsExceptions().getPermisoCotizaAbrirException();
       }

       if(permisoCotizaCancelar==null || permisoCotizaCancelar.isEmpty()){
           throw new UserPermissionsValidatorsExceptions().getPermisoCotizaCancelarException();
       }

       if(permisoCotizaNueva==null || permisoCotizaNueva.isEmpty()){
           throw new UserPermissionsValidatorsExceptions().getPermisoCotizaNuevaException();
       }

       if(permisoCotizaReenviar==null || permisoCotizaReenviar.isEmpty()){
           throw new UserPermissionsValidatorsExceptions().getPermisoCotizaReenviarException();
       }

       if(permisoCotizaVenta==null || permisoCotizaVenta.isEmpty()){
           throw new UserPermissionsValidatorsExceptions().getPermisoCotizaVentaException();
       }

       if(permisoCotizaVer==null || permisoCotizaVer.isEmpty()){
           throw new UserPermissionsValidatorsExceptions().getPermisoCotizaVerException();
       }

       if(permisoCxc==null || permisoCxc.isEmpty()){
           throw new UserPermissionsValidatorsExceptions().getPermisoCxcException();
       }

       if(permisoDatosEmpresa==null || permisoDatosEmpresa.isEmpty()){
           throw new UserPermissionsValidatorsExceptions().getPermisoDatosEmpresaException();
       }

       if(permisoGiros==null || permisoGiros.isEmpty()){
           throw new UserPermissionsValidatorsExceptions().getPermisoGirosException();
       }

       if(permisoImpresoras==null || permisoImpresoras.isEmpty()){
           throw new UserPermissionsValidatorsExceptions().getPermisoImpresorasException();
       }

       if(permisoImpuestos==null || permisoImpuestos.isEmpty()){
           throw new UserPermissionsValidatorsExceptions().getPermisoImpuestosException();
       }

       if(permisoInventario==null || permisoInventario.isEmpty()){
           throw new UserPermissionsValidatorsExceptions().getPermisoInventarioException();
       }

       if(permisoMonedas==null || permisoMonedas.isEmpty()){
           throw new UserPermissionsValidatorsExceptions().getPermisoMonedasException();
       }

       if(permisoPagoNuevo==null || permisoPagoNuevo.isEmpty()){
           throw new UserPermissionsValidatorsExceptions().getPermisoPagoNuevoException();
       }

       if(permisoPrevio==null || permisoPrevio.isEmpty()){
           throw new UserPermissionsValidatorsExceptions().getPermisoPrevioException();
       }

       if(permisoPrevioAbrir==null || permisoPrevioAbrir.isEmpty()){
           throw new UserPermissionsValidatorsExceptions().getPermisoPrevioAbrirException();
       }

       if(permisoPrevioCancelar==null || permisoPrevioCancelar.isEmpty()){
           throw new UserPermissionsValidatorsExceptions().getPermisoPrevioCancelarException();
       }

       if(permisoPrevioCompra==null || permisoPrevioCompra.isEmpty()){
           throw new UserPermissionsValidatorsExceptions().getPermisoPrevioCompraException();
       }

       if(permisoPrevioNueva==null || permisoPrevioNueva.isEmpty()){
           throw new UserPermissionsValidatorsExceptions().getPermisoPrevioNuevaException();
       }

       if(permisoPrevioSeries==null || permisoPrevioSeries.isEmpty()){
           throw new UserPermissionsValidatorsExceptions().getPermisoPrevioSeriesException();
       }

       if(permisoPrevioVer==null || permisoPrevioVer.isEmpty()){
           throw new UserPermissionsValidatorsExceptions().getPermisoPrevioVerException();
       }

       if(permisoProductos==null || permisoProductos.isEmpty()){
           throw new UserPermissionsValidatorsExceptions().getPermisoProductosException();
       }

       if(permisoProductosModificar==null || permisoProductosModificar.isEmpty()){
           throw new UserPermissionsValidatorsExceptions().getPermisoProductosModificarException();
       }

       if(permisoProductosNuevo==null || permisoProductosNuevo.isEmpty()){
           throw new UserPermissionsValidatorsExceptions().getPermisoProductosNuevoException();
       }

       if(permisoProvee==null || permisoProvee.isEmpty()){
           throw new UserPermissionsValidatorsExceptions().getPermisoProveeException();
       }

       if(permisoProveeBorrar==null || permisoProveeBorrar.isEmpty()){
           throw new UserPermissionsValidatorsExceptions().getPermisoProveeBorrarException();
       }

       if(permisoProveeModificar==null || permisoProveeModificar.isEmpty()){
           throw new UserPermissionsValidatorsExceptions().getPermisoProveeModificarException();
       }

       if(permisoProveeNuevo==null || permisoProveeNuevo.isEmpty()){
           throw new UserPermissionsValidatorsExceptions().getPermisoProveeNuevoException();
       }

       if(permisoProveeVer==null || permisoProveeVer.isEmpty()){
           throw new UserPermissionsValidatorsExceptions().getPermisoProveeVerException();
       }

       if(permisoReparar==null || permisoReparar.isEmpty()){
           throw new UserPermissionsValidatorsExceptions().getPermisoRepararException();
       }

       if(permisoRepararErrores==null || permisoRepararErrores.isEmpty()){
           throw new UserPermissionsValidatorsExceptions().getPermisoRepararErroresException();
       }

       if(permisoRepararRestaurar==null || permisoRepararRestaurar.isEmpty()){
           throw new UserPermissionsValidatorsExceptions().getPermisoRepararRestaurarException();
       }

       if(permisoReportes==null || permisoReportes.isEmpty()){
           throw new UserPermissionsValidatorsExceptions().getPermisoReportesException();
       }

       if(permisoReportesEstadistica==null || permisoReportesEstadistica.isEmpty()){
           throw new UserPermissionsValidatorsExceptions().getPermisoReportesEstadisticaException();
       }

       if(permisoReportesLog==null || permisoReportesLog.isEmpty()){
           throw new UserPermissionsValidatorsExceptions().getPermisoReportesLogException();
       }

       if(permisoReportesRespaldos==null || permisoReportesRespaldos.isEmpty()){
           throw new UserPermissionsValidatorsExceptions().getPermisoReportesRespaldosException();
       }

       if(permisoReportesUsuarios==null || permisoReportesUsuarios.isEmpty()){
           throw new UserPermissionsValidatorsExceptions().getPermisoReportesUsuariosException();
       }

       if(permisoRevocacion==null || permisoRevocacion.isEmpty()){
           throw new UserPermissionsValidatorsExceptions().getPermisoRevocacionException();
       }

       if(permisoSeries==null || permisoSeries.isEmpty()){
           throw new UserPermissionsValidatorsExceptions().getPermisoSeriesException();
       }

       if(permisoUsuarios==null || permisoUsuarios.isEmpty()){
           throw new UserPermissionsValidatorsExceptions().getPermisoUsuariosException();
       }

       if(permisoUsuariosConectados==null || permisoUsuariosConectados.isEmpty()){
           throw new UserPermissionsValidatorsExceptions().getPermisoUsuariosConectadosException();
       }

       if(permisoUsuariosDefinir==null || permisoUsuariosDefinir.isEmpty()){
           throw new UserPermissionsValidatorsExceptions().getPermisoUsuariosDefinirException();
       }

       if(permisoUsuariosPermisos==null || permisoUsuariosPermisos.isEmpty()){
           throw new UserPermissionsValidatorsExceptions().getPermisoUsuariosPermisosException();
       }

       if(permisoVentas==null || permisoVentas.isEmpty()){
           throw new UserPermissionsValidatorsExceptions().getPermisoVentasException();
       }

       if(permisoVentasAcuse==null || permisoVentasAcuse.isEmpty()){
           throw new UserPermissionsValidatorsExceptions().getPermisoVentasAcuseException();
       }

       if(permisoVentasBorrarArchivo==null || permisoVentasBorrarArchivo.isEmpty()){
           throw new UserPermissionsValidatorsExceptions().getPermisoVentasBorrarArchivoException();
       }

       if(permisoVentasCancelar==null || permisoVentasCancelar.isEmpty()){
           throw new UserPermissionsValidatorsExceptions().getPermisoVentasCancelarException();
       }

       if(permisoVentasCargarArchivo==null || permisoVentasCargarArchivo.isEmpty()){
           throw new UserPermissionsValidatorsExceptions().getPermisoVentasCargarArchivoException();
       }

       if(permisoVentasComprobar==null || permisoVentasComprobar.isEmpty()){
           throw new UserPermissionsValidatorsExceptions().getPermisoVentasComprobarException();
       }

       if(permisoVentasDevolucion==null || permisoVentasDevolucion.isEmpty()){
           throw new UserPermissionsValidatorsExceptions().getPermisoVentasDevolucionException();
       }

       if(permisoVentasEntregar==null || permisoVentasEntregar.isEmpty()){
           throw new UserPermissionsValidatorsExceptions().getPermisoVentasEntregarException();
       }

       if(permisoVentasEnviar==null || permisoVentasEnviar.isEmpty()){
           throw new UserPermissionsValidatorsExceptions().getPermisoVentasEnviarException();
       }

       if(permisoVentasFacturar==null || permisoVentasFacturar.isEmpty()){
           throw new UserPermissionsValidatorsExceptions().getPermisoVentasFacturarException();
       }

       if(permisoVentasNotCredito==null || permisoVentasNotCredito.isEmpty()){
           throw new UserPermissionsValidatorsExceptions().getPermisoVentasNotCreditoException();
       }

       if(permisoVentasNueva==null || permisoVentasNueva.isEmpty()){
           throw new UserPermissionsValidatorsExceptions().getPermisoVentasNuevaException();
       }

       if(permisoVentasObtenerXml==null || permisoVentasObtenerXml.isEmpty()){
           throw new UserPermissionsValidatorsExceptions().getPermisoVentasObtenerXmlException();
       }

       if(permisoVentasParcial==null || permisoVentasParcial.isEmpty()){
           throw new UserPermissionsValidatorsExceptions().getPermisoVentasParcialException();
       }

       if(permisoVentasTimbrar==null || permisoVentasTimbrar.isEmpty()){
           throw new UserPermissionsValidatorsExceptions().getPermisoVentasTimbrarException();
       }

       if(permisoVentasVer==null || permisoVentasVer.isEmpty()){
           throw new UserPermissionsValidatorsExceptions().getPermisoVentasVerException();
       }

       if(permisoZonas==null || permisoZonas.isEmpty()){
           throw new UserPermissionsValidatorsExceptions().getPermisoZonasException();
       }

       if(userID==null || userID.isEmpty()){
           throw new UserPermissionsValidatorsExceptions().getUserIDException();
       }

       final UserPermission UserPermission = (UserPermission) RepositoryFactory.getInstance().getUserPermissionsRepository().getByCode(code);
       if(UserPermission != null){            
           throw new UserPermissionsValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new UserPermissionsValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new UserPermissionsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new UserPermissionsValidatorsExceptions().getCodeException();
       }

       final UserPermission UserPermission = (UserPermission) RepositoryFactory.getInstance().getUserPermissionsRepository().getByCode(code);
       if(UserPermission == null){            
           throw new UserPermissionsValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new UserPermissionsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}