package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.ERPermisossValidatorsExceptions;
import com.era.models.ERPermisos;
import com.era.repositories.RepositoryFactory;

public class ERPermisossValidator extends IValidate{

   private String code;
   private String FKIdUsuario;
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

   @Override
   public void validateInsert() throws Exception {

       if(FKIdUsuario==null || FKIdUsuario.isEmpty()){
           throw new ERPermisossValidatorsExceptions().getFKIdUsuarioException();
       }

       if(otorgaPermisoCxc==null || otorgaPermisoCxc.isEmpty()){
           throw new ERPermisossValidatorsExceptions().getOtorgaPermisoCxcException();
       }

       if(otorgaPermisosClientes==null || otorgaPermisosClientes.isEmpty()){
           throw new ERPermisossValidatorsExceptions().getOtorgaPermisosClientesException();
       }

       if(otorgaPermisosCompras==null || otorgaPermisosCompras.isEmpty()){
           throw new ERPermisossValidatorsExceptions().getOtorgaPermisosComprasException();
       }

       if(otorgaPermisosConfig==null || otorgaPermisosConfig.isEmpty()){
           throw new ERPermisossValidatorsExceptions().getOtorgaPermisosConfigException();
       }

       if(otorgaPermisosCotiza==null || otorgaPermisosCotiza.isEmpty()){
           throw new ERPermisossValidatorsExceptions().getOtorgaPermisosCotizaException();
       }

       if(otorgaPermisosInventario==null || otorgaPermisosInventario.isEmpty()){
           throw new ERPermisossValidatorsExceptions().getOtorgaPermisosInventarioException();
       }

       if(otorgaPermisosModulos==null || otorgaPermisosModulos.isEmpty()){
           throw new ERPermisossValidatorsExceptions().getOtorgaPermisosModulosException();
       }

       if(otorgaPermisosPrevio==null || otorgaPermisosPrevio.isEmpty()){
           throw new ERPermisossValidatorsExceptions().getOtorgaPermisosPrevioException();
       }

       if(otorgaPermisosProvee==null || otorgaPermisosProvee.isEmpty()){
           throw new ERPermisossValidatorsExceptions().getOtorgaPermisosProveeException();
       }

       if(otorgaPermisosSistema==null || otorgaPermisosSistema.isEmpty()){
           throw new ERPermisossValidatorsExceptions().getOtorgaPermisosSistemaException();
       }

       if(otorgaPermisosVentas==null || otorgaPermisosVentas.isEmpty()){
           throw new ERPermisossValidatorsExceptions().getOtorgaPermisosVentasException();
       }

       if(permisProductosBorrar==null || permisProductosBorrar.isEmpty()){
           throw new ERPermisossValidatorsExceptions().getPermisProductosBorrarException();
       }

       if(permisProductosCargadoImagen==null || permisProductosCargadoImagen.isEmpty()){
           throw new ERPermisossValidatorsExceptions().getPermisProductosCargadoImagenException();
       }

       if(permisProductosListaPrecio==null || permisProductosListaPrecio.isEmpty()){
           throw new ERPermisossValidatorsExceptions().getPermisProductosListaPrecioException();
       }

       if(permisoActivarSistema==null || permisoActivarSistema.isEmpty()){
           throw new ERPermisossValidatorsExceptions().getPermisoActivarSistemaException();
       }

       if(permisoBaseDatos==null || permisoBaseDatos.isEmpty()){
           throw new ERPermisossValidatorsExceptions().getPermisoBaseDatosException();
       }

       if(permisoBaseDatosArchivo==null || permisoBaseDatosArchivo.isEmpty()){
           throw new ERPermisossValidatorsExceptions().getPermisoBaseDatosArchivoException();
       }

       if(permisoBaseDatosConexiones==null || permisoBaseDatosConexiones.isEmpty()){
           throw new ERPermisossValidatorsExceptions().getPermisoBaseDatosConexionesException();
       }

       if(permisoCambiarIcono==null || permisoCambiarIcono.isEmpty()){
           throw new ERPermisossValidatorsExceptions().getPermisoCambiarIconoException();
       }

       if(permisoCancelarPago==null || permisoCancelarPago.isEmpty()){
           throw new ERPermisossValidatorsExceptions().getPermisoCancelarPagoException();
       }

       if(permisoCatalogoGarantias==null || permisoCatalogoGarantias.isEmpty()){
           throw new ERPermisossValidatorsExceptions().getPermisoCatalogoGarantiasException();
       }

       if(permisoClaves==null || permisoClaves.isEmpty()){
           throw new ERPermisossValidatorsExceptions().getPermisoClavesException();
       }

       if(permisoClientes==null || permisoClientes.isEmpty()){
           throw new ERPermisossValidatorsExceptions().getPermisoClientesException();
       }

       if(permisoClientesBorrar==null || permisoClientesBorrar.isEmpty()){
           throw new ERPermisossValidatorsExceptions().getPermisoClientesBorrarException();
       }

       if(permisoClientesEnviar==null || permisoClientesEnviar.isEmpty()){
           throw new ERPermisossValidatorsExceptions().getPermisoClientesEnviarException();
       }

       if(permisoClientesModificar==null || permisoClientesModificar.isEmpty()){
           throw new ERPermisossValidatorsExceptions().getPermisoClientesModificarException();
       }

       if(permisoClientesNuevo==null || permisoClientesNuevo.isEmpty()){
           throw new ERPermisossValidatorsExceptions().getPermisoClientesNuevoException();
       }

       if(permisoClientesVer==null || permisoClientesVer.isEmpty()){
           throw new ERPermisossValidatorsExceptions().getPermisoClientesVerException();
       }

       if(permisoCompras==null || permisoCompras.isEmpty()){
           throw new ERPermisossValidatorsExceptions().getPermisoComprasException();
       }

       if(permisoComprasBorrarArchivo==null || permisoComprasBorrarArchivo.isEmpty()){
           throw new ERPermisossValidatorsExceptions().getPermisoComprasBorrarArchivoException();
       }

       if(permisoComprasCancelar==null || permisoComprasCancelar.isEmpty()){
           throw new ERPermisossValidatorsExceptions().getPermisoComprasCancelarException();
       }

       if(permisoComprasCargarArchivo==null || permisoComprasCargarArchivo.isEmpty()){
           throw new ERPermisossValidatorsExceptions().getPermisoComprasCargarArchivoException();
       }

       if(permisoComprasDevolucion==null || permisoComprasDevolucion.isEmpty()){
           throw new ERPermisossValidatorsExceptions().getPermisoComprasDevolucionException();
       }

       if(permisoComprasNotCredito==null || permisoComprasNotCredito.isEmpty()){
           throw new ERPermisossValidatorsExceptions().getPermisoComprasNotCreditoException();
       }

       if(permisoComprasNuevo==null || permisoComprasNuevo.isEmpty()){
           throw new ERPermisossValidatorsExceptions().getPermisoComprasNuevoException();
       }

       if(permisoComprasParcial==null || permisoComprasParcial.isEmpty()){
           throw new ERPermisossValidatorsExceptions().getPermisoComprasParcialException();
       }

       if(permisoComprasRecibirOrden==null || permisoComprasRecibirOrden.isEmpty()){
           throw new ERPermisossValidatorsExceptions().getPermisoComprasRecibirOrdenException();
       }

       if(permisoComprasVer==null || permisoComprasVer.isEmpty()){
           throw new ERPermisossValidatorsExceptions().getPermisoComprasVerException();
       }

       if(permisoConceptosNC==null || permisoConceptosNC.isEmpty()){
           throw new ERPermisossValidatorsExceptions().getPermisoConceptosNCException();
       }

       if(permisoConf==null || permisoConf.isEmpty()){
           throw new ERPermisossValidatorsExceptions().getPermisoConfException();
       }

       if(permisoConfiguracionesGenerales==null || permisoConfiguracionesGenerales.isEmpty()){
           throw new ERPermisossValidatorsExceptions().getPermisoConfiguracionesGeneralesException();
       }

       if(permisoContabilidad==null || permisoContabilidad.isEmpty()){
           throw new ERPermisossValidatorsExceptions().getPermisoContabilidadException();
       }

       if(permisoCorreos==null || permisoCorreos.isEmpty()){
           throw new ERPermisossValidatorsExceptions().getPermisoCorreosException();
       }

       if(permisoCotiza==null || permisoCotiza.isEmpty()){
           throw new ERPermisossValidatorsExceptions().getPermisoCotizaException();
       }

       if(permisoCotizaAbrir==null || permisoCotizaAbrir.isEmpty()){
           throw new ERPermisossValidatorsExceptions().getPermisoCotizaAbrirException();
       }

       if(permisoCotizaCancelar==null || permisoCotizaCancelar.isEmpty()){
           throw new ERPermisossValidatorsExceptions().getPermisoCotizaCancelarException();
       }

       if(permisoCotizaNueva==null || permisoCotizaNueva.isEmpty()){
           throw new ERPermisossValidatorsExceptions().getPermisoCotizaNuevaException();
       }

       if(permisoCotizaReenviar==null || permisoCotizaReenviar.isEmpty()){
           throw new ERPermisossValidatorsExceptions().getPermisoCotizaReenviarException();
       }

       if(permisoCotizaVenta==null || permisoCotizaVenta.isEmpty()){
           throw new ERPermisossValidatorsExceptions().getPermisoCotizaVentaException();
       }

       if(permisoCotizaVer==null || permisoCotizaVer.isEmpty()){
           throw new ERPermisossValidatorsExceptions().getPermisoCotizaVerException();
       }

       if(permisoCxc==null || permisoCxc.isEmpty()){
           throw new ERPermisossValidatorsExceptions().getPermisoCxcException();
       }

       if(permisoDatosEmpresa==null || permisoDatosEmpresa.isEmpty()){
           throw new ERPermisossValidatorsExceptions().getPermisoDatosEmpresaException();
       }

       if(permisoGiros==null || permisoGiros.isEmpty()){
           throw new ERPermisossValidatorsExceptions().getPermisoGirosException();
       }

       if(permisoImpresoras==null || permisoImpresoras.isEmpty()){
           throw new ERPermisossValidatorsExceptions().getPermisoImpresorasException();
       }

       if(permisoImpuestos==null || permisoImpuestos.isEmpty()){
           throw new ERPermisossValidatorsExceptions().getPermisoImpuestosException();
       }

       if(permisoInventario==null || permisoInventario.isEmpty()){
           throw new ERPermisossValidatorsExceptions().getPermisoInventarioException();
       }

       if(permisoMonedas==null || permisoMonedas.isEmpty()){
           throw new ERPermisossValidatorsExceptions().getPermisoMonedasException();
       }

       if(permisoPagoNuevo==null || permisoPagoNuevo.isEmpty()){
           throw new ERPermisossValidatorsExceptions().getPermisoPagoNuevoException();
       }

       if(permisoPrevio==null || permisoPrevio.isEmpty()){
           throw new ERPermisossValidatorsExceptions().getPermisoPrevioException();
       }

       if(permisoPrevioAbrir==null || permisoPrevioAbrir.isEmpty()){
           throw new ERPermisossValidatorsExceptions().getPermisoPrevioAbrirException();
       }

       if(permisoPrevioCancelar==null || permisoPrevioCancelar.isEmpty()){
           throw new ERPermisossValidatorsExceptions().getPermisoPrevioCancelarException();
       }

       if(permisoPrevioCompra==null || permisoPrevioCompra.isEmpty()){
           throw new ERPermisossValidatorsExceptions().getPermisoPrevioCompraException();
       }

       if(permisoPrevioNueva==null || permisoPrevioNueva.isEmpty()){
           throw new ERPermisossValidatorsExceptions().getPermisoPrevioNuevaException();
       }

       if(permisoPrevioSeries==null || permisoPrevioSeries.isEmpty()){
           throw new ERPermisossValidatorsExceptions().getPermisoPrevioSeriesException();
       }

       if(permisoPrevioVer==null || permisoPrevioVer.isEmpty()){
           throw new ERPermisossValidatorsExceptions().getPermisoPrevioVerException();
       }

       if(permisoProductos==null || permisoProductos.isEmpty()){
           throw new ERPermisossValidatorsExceptions().getPermisoProductosException();
       }

       if(permisoProductosModificar==null || permisoProductosModificar.isEmpty()){
           throw new ERPermisossValidatorsExceptions().getPermisoProductosModificarException();
       }

       if(permisoProductosNuevo==null || permisoProductosNuevo.isEmpty()){
           throw new ERPermisossValidatorsExceptions().getPermisoProductosNuevoException();
       }

       if(permisoProvee==null || permisoProvee.isEmpty()){
           throw new ERPermisossValidatorsExceptions().getPermisoProveeException();
       }

       if(permisoProveeBorrar==null || permisoProveeBorrar.isEmpty()){
           throw new ERPermisossValidatorsExceptions().getPermisoProveeBorrarException();
       }

       if(permisoProveeModificar==null || permisoProveeModificar.isEmpty()){
           throw new ERPermisossValidatorsExceptions().getPermisoProveeModificarException();
       }

       if(permisoProveeNuevo==null || permisoProveeNuevo.isEmpty()){
           throw new ERPermisossValidatorsExceptions().getPermisoProveeNuevoException();
       }

       if(permisoProveeVer==null || permisoProveeVer.isEmpty()){
           throw new ERPermisossValidatorsExceptions().getPermisoProveeVerException();
       }

       if(permisoReparar==null || permisoReparar.isEmpty()){
           throw new ERPermisossValidatorsExceptions().getPermisoRepararException();
       }

       if(permisoRepararRestaurar==null || permisoRepararRestaurar.isEmpty()){
           throw new ERPermisossValidatorsExceptions().getPermisoRepararRestaurarException();
       }

       if(permisoReportes==null || permisoReportes.isEmpty()){
           throw new ERPermisossValidatorsExceptions().getPermisoReportesException();
       }

       if(permisoReportesEstadistica==null || permisoReportesEstadistica.isEmpty()){
           throw new ERPermisossValidatorsExceptions().getPermisoReportesEstadisticaException();
       }

       if(permisoReportesLog==null || permisoReportesLog.isEmpty()){
           throw new ERPermisossValidatorsExceptions().getPermisoReportesLogException();
       }

       if(permisoReportesRespaldos==null || permisoReportesRespaldos.isEmpty()){
           throw new ERPermisossValidatorsExceptions().getPermisoReportesRespaldosException();
       }

       if(permisoReportesUsuarios==null || permisoReportesUsuarios.isEmpty()){
           throw new ERPermisossValidatorsExceptions().getPermisoReportesUsuariosException();
       }

       if(permisoRevocacion==null || permisoRevocacion.isEmpty()){
           throw new ERPermisossValidatorsExceptions().getPermisoRevocacionException();
       }

       if(permisoSeries==null || permisoSeries.isEmpty()){
           throw new ERPermisossValidatorsExceptions().getPermisoSeriesException();
       }

       if(permisoUsuarios==null || permisoUsuarios.isEmpty()){
           throw new ERPermisossValidatorsExceptions().getPermisoUsuariosException();
       }

       if(permisoUsuariosConectados==null || permisoUsuariosConectados.isEmpty()){
           throw new ERPermisossValidatorsExceptions().getPermisoUsuariosConectadosException();
       }

       if(permisoUsuariosDefinir==null || permisoUsuariosDefinir.isEmpty()){
           throw new ERPermisossValidatorsExceptions().getPermisoUsuariosDefinirException();
       }

       if(permisoUsuariosPermisos==null || permisoUsuariosPermisos.isEmpty()){
           throw new ERPermisossValidatorsExceptions().getPermisoUsuariosPermisosException();
       }

       if(permisoVentas==null || permisoVentas.isEmpty()){
           throw new ERPermisossValidatorsExceptions().getPermisoVentasException();
       }

       if(permisoVentasAcuse==null || permisoVentasAcuse.isEmpty()){
           throw new ERPermisossValidatorsExceptions().getPermisoVentasAcuseException();
       }

       if(permisoVentasBorrarArchivo==null || permisoVentasBorrarArchivo.isEmpty()){
           throw new ERPermisossValidatorsExceptions().getPermisoVentasBorrarArchivoException();
       }

       if(permisoVentasCancelar==null || permisoVentasCancelar.isEmpty()){
           throw new ERPermisossValidatorsExceptions().getPermisoVentasCancelarException();
       }

       if(permisoVentasCargarArchivo==null || permisoVentasCargarArchivo.isEmpty()){
           throw new ERPermisossValidatorsExceptions().getPermisoVentasCargarArchivoException();
       }

       if(permisoVentasComprobar==null || permisoVentasComprobar.isEmpty()){
           throw new ERPermisossValidatorsExceptions().getPermisoVentasComprobarException();
       }

       if(permisoVentasDevolucion==null || permisoVentasDevolucion.isEmpty()){
           throw new ERPermisossValidatorsExceptions().getPermisoVentasDevolucionException();
       }

       if(permisoVentasEntregar==null || permisoVentasEntregar.isEmpty()){
           throw new ERPermisossValidatorsExceptions().getPermisoVentasEntregarException();
       }

       if(permisoVentasEnviar==null || permisoVentasEnviar.isEmpty()){
           throw new ERPermisossValidatorsExceptions().getPermisoVentasEnviarException();
       }

       if(permisoVentasFacturar==null || permisoVentasFacturar.isEmpty()){
           throw new ERPermisossValidatorsExceptions().getPermisoVentasFacturarException();
       }

       if(permisoVentasNotCredito==null || permisoVentasNotCredito.isEmpty()){
           throw new ERPermisossValidatorsExceptions().getPermisoVentasNotCreditoException();
       }

       if(permisoVentasNueva==null || permisoVentasNueva.isEmpty()){
           throw new ERPermisossValidatorsExceptions().getPermisoVentasNuevaException();
       }

       if(permisoVentasObtenerXml==null || permisoVentasObtenerXml.isEmpty()){
           throw new ERPermisossValidatorsExceptions().getPermisoVentasObtenerXmlException();
       }

       if(permisoVentasParcial==null || permisoVentasParcial.isEmpty()){
           throw new ERPermisossValidatorsExceptions().getPermisoVentasParcialException();
       }

       if(permisoVentasTimbrar==null || permisoVentasTimbrar.isEmpty()){
           throw new ERPermisossValidatorsExceptions().getPermisoVentasTimbrarException();
       }

       if(permisoVentasVer==null || permisoVentasVer.isEmpty()){
           throw new ERPermisossValidatorsExceptions().getPermisoVentasVerException();
       }

       if(permisoZonas==null || permisoZonas.isEmpty()){
           throw new ERPermisossValidatorsExceptions().getPermisoZonasException();
       }

       final ERPermisos ERPermisos = (ERPermisos) RepositoryFactory.getInstance().getERPermisossRepository().getByCode(code);
       if(ERPermisos != null){            
           throw new ERPermisossValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new ERPermisossValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new ERPermisossValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new ERPermisossValidatorsExceptions().getCodeException();
       }

       final ERPermisos ERPermisos = (ERPermisos) RepositoryFactory.getInstance().getERPermisossRepository().getByCode(code);
       if(ERPermisos == null){            
           throw new ERPermisossValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new ERPermisossValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}