package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.UserPermissionsValidatorsExceptions;
import com.era.models.UserPermission;
import com.era.repositories.RepositoryFactory;

public class UserPermissionsValidator extends IValidate{

   private String otorgaPermisoCxc;
   public void setOtorgaPermisoCxc(String property){
       this.otorgaPermisoCxc = property;
   }

   private String otorgaPermisosClientes;
   public void setOtorgaPermisosClientes(String property){
       this.otorgaPermisosClientes = property;
   }

   private String otorgaPermisosCompras;
   public void setOtorgaPermisosCompras(String property){
       this.otorgaPermisosCompras = property;
   }

   private String otorgaPermisosConfig;
   public void setOtorgaPermisosConfig(String property){
       this.otorgaPermisosConfig = property;
   }

   private String otorgaPermisosCotiza;
   public void setOtorgaPermisosCotiza(String property){
       this.otorgaPermisosCotiza = property;
   }

   private String otorgaPermisosInventario;
   public void setOtorgaPermisosInventario(String property){
       this.otorgaPermisosInventario = property;
   }

   private String otorgaPermisosModulos;
   public void setOtorgaPermisosModulos(String property){
       this.otorgaPermisosModulos = property;
   }

   private String otorgaPermisosPrevio;
   public void setOtorgaPermisosPrevio(String property){
       this.otorgaPermisosPrevio = property;
   }

   private String otorgaPermisosProvee;
   public void setOtorgaPermisosProvee(String property){
       this.otorgaPermisosProvee = property;
   }

   private String otorgaPermisosSistema;
   public void setOtorgaPermisosSistema(String property){
       this.otorgaPermisosSistema = property;
   }

   private String otorgaPermisosVentas;
   public void setOtorgaPermisosVentas(String property){
       this.otorgaPermisosVentas = property;
   }

   private String permisProductosBorrar;
   public void setPermisProductosBorrar(String property){
       this.permisProductosBorrar = property;
   }

   private String permisProductosCargadoImagen;
   public void setPermisProductosCargadoImagen(String property){
       this.permisProductosCargadoImagen = property;
   }

   private String permisProductosListaPrecio;
   public void setPermisProductosListaPrecio(String property){
       this.permisProductosListaPrecio = property;
   }

   private String permisoActivarSistema;
   public void setPermisoActivarSistema(String property){
       this.permisoActivarSistema = property;
   }

   private String permisoBaseDatos;
   public void setPermisoBaseDatos(String property){
       this.permisoBaseDatos = property;
   }

   private String permisoBaseDatosArchivo;
   public void setPermisoBaseDatosArchivo(String property){
       this.permisoBaseDatosArchivo = property;
   }

   private String permisoBaseDatosConexiones;
   public void setPermisoBaseDatosConexiones(String property){
       this.permisoBaseDatosConexiones = property;
   }

   private String permisoCambiarIcono;
   public void setPermisoCambiarIcono(String property){
       this.permisoCambiarIcono = property;
   }

   private String permisoCancelarPago;
   public void setPermisoCancelarPago(String property){
       this.permisoCancelarPago = property;
   }

   private String permisoCatalogoGarantias;
   public void setPermisoCatalogoGarantias(String property){
       this.permisoCatalogoGarantias = property;
   }

   private String permisoClaves;
   public void setPermisoClaves(String property){
       this.permisoClaves = property;
   }

   private String permisoClientes;
   public void setPermisoClientes(String property){
       this.permisoClientes = property;
   }

   private String permisoClientesBorrar;
   public void setPermisoClientesBorrar(String property){
       this.permisoClientesBorrar = property;
   }

   private String permisoClientesEnviar;
   public void setPermisoClientesEnviar(String property){
       this.permisoClientesEnviar = property;
   }

   private String permisoClientesModificar;
   public void setPermisoClientesModificar(String property){
       this.permisoClientesModificar = property;
   }

   private String permisoClientesNuevo;
   public void setPermisoClientesNuevo(String property){
       this.permisoClientesNuevo = property;
   }

   private String permisoClientesVer;
   public void setPermisoClientesVer(String property){
       this.permisoClientesVer = property;
   }

   private String permisoCompras;
   public void setPermisoCompras(String property){
       this.permisoCompras = property;
   }

   private String permisoComprasBorrarArchivo;
   public void setPermisoComprasBorrarArchivo(String property){
       this.permisoComprasBorrarArchivo = property;
   }

   private String permisoComprasCancelar;
   public void setPermisoComprasCancelar(String property){
       this.permisoComprasCancelar = property;
   }

   private String permisoComprasCargarArchivo;
   public void setPermisoComprasCargarArchivo(String property){
       this.permisoComprasCargarArchivo = property;
   }

   private String permisoComprasDevolucion;
   public void setPermisoComprasDevolucion(String property){
       this.permisoComprasDevolucion = property;
   }

   private String permisoComprasNotCredito;
   public void setPermisoComprasNotCredito(String property){
       this.permisoComprasNotCredito = property;
   }

   private String permisoComprasNuevo;
   public void setPermisoComprasNuevo(String property){
       this.permisoComprasNuevo = property;
   }

   private String permisoComprasParcial;
   public void setPermisoComprasParcial(String property){
       this.permisoComprasParcial = property;
   }

   private String permisoComprasRecibirOrden;
   public void setPermisoComprasRecibirOrden(String property){
       this.permisoComprasRecibirOrden = property;
   }

   private String permisoComprasVer;
   public void setPermisoComprasVer(String property){
       this.permisoComprasVer = property;
   }

   private String permisoConceptosNC;
   public void setPermisoConceptosNC(String property){
       this.permisoConceptosNC = property;
   }

   private String permisoConf;
   public void setPermisoConf(String property){
       this.permisoConf = property;
   }

   private String permisoConfiguracionesGenerales;
   public void setPermisoConfiguracionesGenerales(String property){
       this.permisoConfiguracionesGenerales = property;
   }

   private String permisoContabilidad;
   public void setPermisoContabilidad(String property){
       this.permisoContabilidad = property;
   }

   private String permisoCorreos;
   public void setPermisoCorreos(String property){
       this.permisoCorreos = property;
   }

   private String permisoCotiza;
   public void setPermisoCotiza(String property){
       this.permisoCotiza = property;
   }

   private String permisoCotizaAbrir;
   public void setPermisoCotizaAbrir(String property){
       this.permisoCotizaAbrir = property;
   }

   private String permisoCotizaCancelar;
   public void setPermisoCotizaCancelar(String property){
       this.permisoCotizaCancelar = property;
   }

   private String permisoCotizaNueva;
   public void setPermisoCotizaNueva(String property){
       this.permisoCotizaNueva = property;
   }

   private String permisoCotizaReenviar;
   public void setPermisoCotizaReenviar(String property){
       this.permisoCotizaReenviar = property;
   }

   private String permisoCotizaVenta;
   public void setPermisoCotizaVenta(String property){
       this.permisoCotizaVenta = property;
   }

   private String permisoCotizaVer;
   public void setPermisoCotizaVer(String property){
       this.permisoCotizaVer = property;
   }

   private String permisoCxc;
   public void setPermisoCxc(String property){
       this.permisoCxc = property;
   }

   private String permisoDatosEmpresa;
   public void setPermisoDatosEmpresa(String property){
       this.permisoDatosEmpresa = property;
   }

   private String permisoGiros;
   public void setPermisoGiros(String property){
       this.permisoGiros = property;
   }

   private String permisoImpresoras;
   public void setPermisoImpresoras(String property){
       this.permisoImpresoras = property;
   }

   private String permisoImpuestos;
   public void setPermisoImpuestos(String property){
       this.permisoImpuestos = property;
   }

   private String permisoInventario;
   public void setPermisoInventario(String property){
       this.permisoInventario = property;
   }

   private String permisoMonedas;
   public void setPermisoMonedas(String property){
       this.permisoMonedas = property;
   }

   private String permisoPagoNuevo;
   public void setPermisoPagoNuevo(String property){
       this.permisoPagoNuevo = property;
   }

   private String permisoPrevio;
   public void setPermisoPrevio(String property){
       this.permisoPrevio = property;
   }

   private String permisoPrevioAbrir;
   public void setPermisoPrevioAbrir(String property){
       this.permisoPrevioAbrir = property;
   }

   private String permisoPrevioCancelar;
   public void setPermisoPrevioCancelar(String property){
       this.permisoPrevioCancelar = property;
   }

   private String permisoPrevioCompra;
   public void setPermisoPrevioCompra(String property){
       this.permisoPrevioCompra = property;
   }

   private String permisoPrevioNueva;
   public void setPermisoPrevioNueva(String property){
       this.permisoPrevioNueva = property;
   }

   private String permisoPrevioSeries;
   public void setPermisoPrevioSeries(String property){
       this.permisoPrevioSeries = property;
   }

   private String permisoPrevioVer;
   public void setPermisoPrevioVer(String property){
       this.permisoPrevioVer = property;
   }

   private String permisoProductos;
   public void setPermisoProductos(String property){
       this.permisoProductos = property;
   }

   private String permisoProductosModificar;
   public void setPermisoProductosModificar(String property){
       this.permisoProductosModificar = property;
   }

   private String permisoProductosNuevo;
   public void setPermisoProductosNuevo(String property){
       this.permisoProductosNuevo = property;
   }

   private String permisoProvee;
   public void setPermisoProvee(String property){
       this.permisoProvee = property;
   }

   private String permisoProveeBorrar;
   public void setPermisoProveeBorrar(String property){
       this.permisoProveeBorrar = property;
   }

   private String permisoProveeModificar;
   public void setPermisoProveeModificar(String property){
       this.permisoProveeModificar = property;
   }

   private String permisoProveeNuevo;
   public void setPermisoProveeNuevo(String property){
       this.permisoProveeNuevo = property;
   }

   private String permisoProveeVer;
   public void setPermisoProveeVer(String property){
       this.permisoProveeVer = property;
   }

   private String permisoReparar;
   public void setPermisoReparar(String property){
       this.permisoReparar = property;
   }

   private String permisoRepararErrores;
   public void setPermisoRepararErrores(String property){
       this.permisoRepararErrores = property;
   }

   private String permisoRepararRestaurar;
   public void setPermisoRepararRestaurar(String property){
       this.permisoRepararRestaurar = property;
   }

   private String permisoReportes;
   public void setPermisoReportes(String property){
       this.permisoReportes = property;
   }

   private String permisoReportesEstadistica;
   public void setPermisoReportesEstadistica(String property){
       this.permisoReportesEstadistica = property;
   }

   private String permisoReportesLog;
   public void setPermisoReportesLog(String property){
       this.permisoReportesLog = property;
   }

   private String permisoReportesRespaldos;
   public void setPermisoReportesRespaldos(String property){
       this.permisoReportesRespaldos = property;
   }

   private String permisoReportesUsuarios;
   public void setPermisoReportesUsuarios(String property){
       this.permisoReportesUsuarios = property;
   }

   private String permisoRevocacion;
   public void setPermisoRevocacion(String property){
       this.permisoRevocacion = property;
   }

   private String permisoSeries;
   public void setPermisoSeries(String property){
       this.permisoSeries = property;
   }

   private String permisoUsuarios;
   public void setPermisoUsuarios(String property){
       this.permisoUsuarios = property;
   }

   private String permisoUsuariosConectados;
   public void setPermisoUsuariosConectados(String property){
       this.permisoUsuariosConectados = property;
   }

   private String permisoUsuariosDefinir;
   public void setPermisoUsuariosDefinir(String property){
       this.permisoUsuariosDefinir = property;
   }

   private String permisoUsuariosPermisos;
   public void setPermisoUsuariosPermisos(String property){
       this.permisoUsuariosPermisos = property;
   }

   private String permisoVentas;
   public void setPermisoVentas(String property){
       this.permisoVentas = property;
   }

   private String permisoVentasAcuse;
   public void setPermisoVentasAcuse(String property){
       this.permisoVentasAcuse = property;
   }

   private String permisoVentasBorrarArchivo;
   public void setPermisoVentasBorrarArchivo(String property){
       this.permisoVentasBorrarArchivo = property;
   }

   private String permisoVentasCancelar;
   public void setPermisoVentasCancelar(String property){
       this.permisoVentasCancelar = property;
   }

   private String permisoVentasCargarArchivo;
   public void setPermisoVentasCargarArchivo(String property){
       this.permisoVentasCargarArchivo = property;
   }

   private String permisoVentasComprobar;
   public void setPermisoVentasComprobar(String property){
       this.permisoVentasComprobar = property;
   }

   private String permisoVentasDevolucion;
   public void setPermisoVentasDevolucion(String property){
       this.permisoVentasDevolucion = property;
   }

   private String permisoVentasEntregar;
   public void setPermisoVentasEntregar(String property){
       this.permisoVentasEntregar = property;
   }

   private String permisoVentasEnviar;
   public void setPermisoVentasEnviar(String property){
       this.permisoVentasEnviar = property;
   }

   private String permisoVentasFacturar;
   public void setPermisoVentasFacturar(String property){
       this.permisoVentasFacturar = property;
   }

   private String permisoVentasNotCredito;
   public void setPermisoVentasNotCredito(String property){
       this.permisoVentasNotCredito = property;
   }

   private String permisoVentasNueva;
   public void setPermisoVentasNueva(String property){
       this.permisoVentasNueva = property;
   }

   private String permisoVentasObtenerXml;
   public void setPermisoVentasObtenerXml(String property){
       this.permisoVentasObtenerXml = property;
   }

   private String permisoVentasParcial;
   public void setPermisoVentasParcial(String property){
       this.permisoVentasParcial = property;
   }

   private String permisoVentasTimbrar;
   public void setPermisoVentasTimbrar(String property){
       this.permisoVentasTimbrar = property;
   }

   private String permisoVentasVer;
   public void setPermisoVentasVer(String property){
       this.permisoVentasVer = property;
   }

   private String permisoZonas;
   public void setPermisoZonas(String property){
       this.permisoZonas = property;
   }

   private String userID;
   public void setUserID(String property){
       this.userID = property;
   }


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

}