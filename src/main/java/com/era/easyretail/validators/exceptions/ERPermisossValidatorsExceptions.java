package com.era.easyretail.validators.exceptions;

public class ERPermisossValidatorsExceptions {

   private static ERPermisossValidatorsExceptions ERPermisossValidatorsExceptions;

   public static ERPermisossValidatorsExceptions getSigleton(){
       if(ERPermisossValidatorsExceptions==null){ERPermisossValidatorsExceptions = new ERPermisossValidatorsExceptions();}return ERPermisossValidatorsExceptions;
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

   public Exception getFKIdUsuarioException(){
       return new Exception("Falta espeficiar FKIdUsuario");
   }

   public Exception getOtorgaPermisoCxcException(){
       return new Exception("Falta espeficiar OtorgaPermisoCxc");
   }

   public Exception getOtorgaPermisosClientesException(){
       return new Exception("Falta espeficiar OtorgaPermisosClientes");
   }

   public Exception getOtorgaPermisosComprasException(){
       return new Exception("Falta espeficiar OtorgaPermisosCompras");
   }

   public Exception getOtorgaPermisosConfigException(){
       return new Exception("Falta espeficiar OtorgaPermisosConfig");
   }

   public Exception getOtorgaPermisosCotizaException(){
       return new Exception("Falta espeficiar OtorgaPermisosCotiza");
   }

   public Exception getOtorgaPermisosInventarioException(){
       return new Exception("Falta espeficiar OtorgaPermisosInventario");
   }

   public Exception getOtorgaPermisosModulosException(){
       return new Exception("Falta espeficiar OtorgaPermisosModulos");
   }

   public Exception getOtorgaPermisosPrevioException(){
       return new Exception("Falta espeficiar OtorgaPermisosPrevio");
   }

   public Exception getOtorgaPermisosProveeException(){
       return new Exception("Falta espeficiar OtorgaPermisosProvee");
   }

   public Exception getOtorgaPermisosSistemaException(){
       return new Exception("Falta espeficiar OtorgaPermisosSistema");
   }

   public Exception getOtorgaPermisosVentasException(){
       return new Exception("Falta espeficiar OtorgaPermisosVentas");
   }

   public Exception getPermisProductosBorrarException(){
       return new Exception("Falta espeficiar PermisProductosBorrar");
   }

   public Exception getPermisProductosCargadoImagenException(){
       return new Exception("Falta espeficiar PermisProductosCargadoImagen");
   }

   public Exception getPermisProductosListaPrecioException(){
       return new Exception("Falta espeficiar PermisProductosListaPrecio");
   }

   public Exception getPermisoActivarSistemaException(){
       return new Exception("Falta espeficiar PermisoActivarSistema");
   }

   public Exception getPermisoBaseDatosException(){
       return new Exception("Falta espeficiar PermisoBaseDatos");
   }

   public Exception getPermisoBaseDatosArchivoException(){
       return new Exception("Falta espeficiar PermisoBaseDatosArchivo");
   }

   public Exception getPermisoBaseDatosConexionesException(){
       return new Exception("Falta espeficiar PermisoBaseDatosConexiones");
   }

   public Exception getPermisoCambiarIconoException(){
       return new Exception("Falta espeficiar PermisoCambiarIcono");
   }

   public Exception getPermisoCancelarPagoException(){
       return new Exception("Falta espeficiar PermisoCancelarPago");
   }

   public Exception getPermisoCatalogoGarantiasException(){
       return new Exception("Falta espeficiar PermisoCatalogoGarantias");
   }

   public Exception getPermisoClavesException(){
       return new Exception("Falta espeficiar PermisoClaves");
   }

   public Exception getPermisoClientesException(){
       return new Exception("Falta espeficiar PermisoClientes");
   }

   public Exception getPermisoClientesBorrarException(){
       return new Exception("Falta espeficiar PermisoClientesBorrar");
   }

   public Exception getPermisoClientesEnviarException(){
       return new Exception("Falta espeficiar PermisoClientesEnviar");
   }

   public Exception getPermisoClientesModificarException(){
       return new Exception("Falta espeficiar PermisoClientesModificar");
   }

   public Exception getPermisoClientesNuevoException(){
       return new Exception("Falta espeficiar PermisoClientesNuevo");
   }

   public Exception getPermisoClientesVerException(){
       return new Exception("Falta espeficiar PermisoClientesVer");
   }

   public Exception getPermisoComprasException(){
       return new Exception("Falta espeficiar PermisoCompras");
   }

   public Exception getPermisoComprasBorrarArchivoException(){
       return new Exception("Falta espeficiar PermisoComprasBorrarArchivo");
   }

   public Exception getPermisoComprasCancelarException(){
       return new Exception("Falta espeficiar PermisoComprasCancelar");
   }

   public Exception getPermisoComprasCargarArchivoException(){
       return new Exception("Falta espeficiar PermisoComprasCargarArchivo");
   }

   public Exception getPermisoComprasDevolucionException(){
       return new Exception("Falta espeficiar PermisoComprasDevolucion");
   }

   public Exception getPermisoComprasNotCreditoException(){
       return new Exception("Falta espeficiar PermisoComprasNotCredito");
   }

   public Exception getPermisoComprasNuevoException(){
       return new Exception("Falta espeficiar PermisoComprasNuevo");
   }

   public Exception getPermisoComprasParcialException(){
       return new Exception("Falta espeficiar PermisoComprasParcial");
   }

   public Exception getPermisoComprasRecibirOrdenException(){
       return new Exception("Falta espeficiar PermisoComprasRecibirOrden");
   }

   public Exception getPermisoComprasVerException(){
       return new Exception("Falta espeficiar PermisoComprasVer");
   }

   public Exception getPermisoConceptosNCException(){
       return new Exception("Falta espeficiar PermisoConceptosNC");
   }

   public Exception getPermisoConfException(){
       return new Exception("Falta espeficiar PermisoConf");
   }

   public Exception getPermisoConfiguracionesGeneralesException(){
       return new Exception("Falta espeficiar PermisoConfiguracionesGenerales");
   }

   public Exception getPermisoContabilidadException(){
       return new Exception("Falta espeficiar PermisoContabilidad");
   }

   public Exception getPermisoCorreosException(){
       return new Exception("Falta espeficiar PermisoCorreos");
   }

   public Exception getPermisoCotizaException(){
       return new Exception("Falta espeficiar PermisoCotiza");
   }

   public Exception getPermisoCotizaAbrirException(){
       return new Exception("Falta espeficiar PermisoCotizaAbrir");
   }

   public Exception getPermisoCotizaCancelarException(){
       return new Exception("Falta espeficiar PermisoCotizaCancelar");
   }

   public Exception getPermisoCotizaNuevaException(){
       return new Exception("Falta espeficiar PermisoCotizaNueva");
   }

   public Exception getPermisoCotizaReenviarException(){
       return new Exception("Falta espeficiar PermisoCotizaReenviar");
   }

   public Exception getPermisoCotizaVentaException(){
       return new Exception("Falta espeficiar PermisoCotizaVenta");
   }

   public Exception getPermisoCotizaVerException(){
       return new Exception("Falta espeficiar PermisoCotizaVer");
   }

   public Exception getPermisoCxcException(){
       return new Exception("Falta espeficiar PermisoCxc");
   }

   public Exception getPermisoDatosEmpresaException(){
       return new Exception("Falta espeficiar PermisoDatosEmpresa");
   }

   public Exception getPermisoGirosException(){
       return new Exception("Falta espeficiar PermisoGiros");
   }

   public Exception getPermisoImpresorasException(){
       return new Exception("Falta espeficiar PermisoImpresoras");
   }

   public Exception getPermisoImpuestosException(){
       return new Exception("Falta espeficiar PermisoImpuestos");
   }

   public Exception getPermisoInventarioException(){
       return new Exception("Falta espeficiar PermisoInventario");
   }

   public Exception getPermisoMonedasException(){
       return new Exception("Falta espeficiar PermisoMonedas");
   }

   public Exception getPermisoPagoNuevoException(){
       return new Exception("Falta espeficiar PermisoPagoNuevo");
   }

   public Exception getPermisoPrevioException(){
       return new Exception("Falta espeficiar PermisoPrevio");
   }

   public Exception getPermisoPrevioAbrirException(){
       return new Exception("Falta espeficiar PermisoPrevioAbrir");
   }

   public Exception getPermisoPrevioCancelarException(){
       return new Exception("Falta espeficiar PermisoPrevioCancelar");
   }

   public Exception getPermisoPrevioCompraException(){
       return new Exception("Falta espeficiar PermisoPrevioCompra");
   }

   public Exception getPermisoPrevioNuevaException(){
       return new Exception("Falta espeficiar PermisoPrevioNueva");
   }

   public Exception getPermisoPrevioSeriesException(){
       return new Exception("Falta espeficiar PermisoPrevioSeries");
   }

   public Exception getPermisoPrevioVerException(){
       return new Exception("Falta espeficiar PermisoPrevioVer");
   }

   public Exception getPermisoProductosException(){
       return new Exception("Falta espeficiar PermisoProductos");
   }

   public Exception getPermisoProductosModificarException(){
       return new Exception("Falta espeficiar PermisoProductosModificar");
   }

   public Exception getPermisoProductosNuevoException(){
       return new Exception("Falta espeficiar PermisoProductosNuevo");
   }

   public Exception getPermisoProveeException(){
       return new Exception("Falta espeficiar PermisoProvee");
   }

   public Exception getPermisoProveeBorrarException(){
       return new Exception("Falta espeficiar PermisoProveeBorrar");
   }

   public Exception getPermisoProveeModificarException(){
       return new Exception("Falta espeficiar PermisoProveeModificar");
   }

   public Exception getPermisoProveeNuevoException(){
       return new Exception("Falta espeficiar PermisoProveeNuevo");
   }

   public Exception getPermisoProveeVerException(){
       return new Exception("Falta espeficiar PermisoProveeVer");
   }

   public Exception getPermisoRepararException(){
       return new Exception("Falta espeficiar PermisoReparar");
   }

   public Exception getPermisoRepararRestaurarException(){
       return new Exception("Falta espeficiar PermisoRepararRestaurar");
   }

   public Exception getPermisoReportesException(){
       return new Exception("Falta espeficiar PermisoReportes");
   }

   public Exception getPermisoReportesEstadisticaException(){
       return new Exception("Falta espeficiar PermisoReportesEstadistica");
   }

   public Exception getPermisoReportesLogException(){
       return new Exception("Falta espeficiar PermisoReportesLog");
   }

   public Exception getPermisoReportesRespaldosException(){
       return new Exception("Falta espeficiar PermisoReportesRespaldos");
   }

   public Exception getPermisoReportesUsuariosException(){
       return new Exception("Falta espeficiar PermisoReportesUsuarios");
   }

   public Exception getPermisoRevocacionException(){
       return new Exception("Falta espeficiar PermisoRevocacion");
   }

   public Exception getPermisoSeriesException(){
       return new Exception("Falta espeficiar PermisoSeries");
   }

   public Exception getPermisoUsuariosException(){
       return new Exception("Falta espeficiar PermisoUsuarios");
   }

   public Exception getPermisoUsuariosConectadosException(){
       return new Exception("Falta espeficiar PermisoUsuariosConectados");
   }

   public Exception getPermisoUsuariosDefinirException(){
       return new Exception("Falta espeficiar PermisoUsuariosDefinir");
   }

   public Exception getPermisoUsuariosPermisosException(){
       return new Exception("Falta espeficiar PermisoUsuariosPermisos");
   }

   public Exception getPermisoVentasException(){
       return new Exception("Falta espeficiar PermisoVentas");
   }

   public Exception getPermisoVentasAcuseException(){
       return new Exception("Falta espeficiar PermisoVentasAcuse");
   }

   public Exception getPermisoVentasBorrarArchivoException(){
       return new Exception("Falta espeficiar PermisoVentasBorrarArchivo");
   }

   public Exception getPermisoVentasCancelarException(){
       return new Exception("Falta espeficiar PermisoVentasCancelar");
   }

   public Exception getPermisoVentasCargarArchivoException(){
       return new Exception("Falta espeficiar PermisoVentasCargarArchivo");
   }

   public Exception getPermisoVentasComprobarException(){
       return new Exception("Falta espeficiar PermisoVentasComprobar");
   }

   public Exception getPermisoVentasDevolucionException(){
       return new Exception("Falta espeficiar PermisoVentasDevolucion");
   }

   public Exception getPermisoVentasEntregarException(){
       return new Exception("Falta espeficiar PermisoVentasEntregar");
   }

   public Exception getPermisoVentasEnviarException(){
       return new Exception("Falta espeficiar PermisoVentasEnviar");
   }

   public Exception getPermisoVentasFacturarException(){
       return new Exception("Falta espeficiar PermisoVentasFacturar");
   }

   public Exception getPermisoVentasNotCreditoException(){
       return new Exception("Falta espeficiar PermisoVentasNotCredito");
   }

   public Exception getPermisoVentasNuevaException(){
       return new Exception("Falta espeficiar PermisoVentasNueva");
   }

   public Exception getPermisoVentasObtenerXmlException(){
       return new Exception("Falta espeficiar PermisoVentasObtenerXml");
   }

   public Exception getPermisoVentasParcialException(){
       return new Exception("Falta espeficiar PermisoVentasParcial");
   }

   public Exception getPermisoVentasTimbrarException(){
       return new Exception("Falta espeficiar PermisoVentasTimbrar");
   }

   public Exception getPermisoVentasVerException(){
       return new Exception("Falta espeficiar PermisoVentasVer");
   }

   public Exception getPermisoZonasException(){
       return new Exception("Falta espeficiar PermisoZonas");
   }

}