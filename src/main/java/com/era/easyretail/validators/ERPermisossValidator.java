package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.ERPermisossValidatorsExceptions;
import com.era.models.ERPermisos;
import com.era.repositories.RepositoryFactory;

public class ERPermisossValidator extends IValidate{

   private String FKIdUsuario;
   public void setFKIdUsuario(String property){
       this.FKIdUsuario = property;
   }

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

}