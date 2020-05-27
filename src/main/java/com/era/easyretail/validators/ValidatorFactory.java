package com.era.easyretail.validators;

public class ValidatorFactory {

   private static ValidatorFactory ValidatorFactory;
   public static ValidatorFactory getSigleton(){
       if(ValidatorFactory==null){ValidatorFactory = new ValidatorFactory();}return ValidatorFactory;
   }

   public ActfijcatsValidator getActfijcatsValidator(){
       return new ActfijcatsValidator();
   }

   public ActfijsValidator getActfijsValidator(){
       return new ActfijsValidator();
   }

   public ActivossValidator getActivossValidator(){
       return new ActivossValidator();
   }

   public AduanasValidator getAduanasValidator(){
       return new AduanasValidator();
   }

   public AnaqssValidator getAnaqssValidator(){
       return new AnaqssValidator();
   }

   public AsientosContablessValidator getAsientosContablessValidator(){
       return new AsientosContablessValidator();
   }

   public AsocdescsValidator getAsocdescsValidator(){
       return new AsocdescsValidator();
   }

   public AuxiliarsValidator getAuxiliarsValidator(){
       return new AuxiliarsValidator();
   }

   public BancosValidator getBancosValidator(){
       return new BancosValidator();
   }

   public BasDatssValidator getBasDatssValidator(){
       return new BasDatssValidator();
   }

   public CAduanasValidator getCAduanasValidator(){
       return new CAduanasValidator();
   }

   public CClaveprodservsValidator getCClaveprodservsValidator(){
       return new CClaveprodservsValidator();
   }

   public CClaveUnidadsValidator getCClaveUnidadsValidator(){
       return new CClaveUnidadsValidator();
   }

   public CCoinsValidator getCCoinsValidator(){
       return new CCoinsValidator();
   }

   public CFDIRelacionadosPagosValidator getCFDIRelacionadosPagosValidator(){
       return new CFDIRelacionadosPagosValidator();
   }

   public ChatsValidator getChatsValidator(){
       return new ChatsValidator();
   }

   public ClasempsValidator getClasempsValidator(){
       return new ClasempsValidator();
   }

   public ClasificacionsValidator getClasificacionsValidator(){
       return new ClasificacionsValidator();
   }

   public ClasjeraclisValidator getClasjeraclisValidator(){
       return new ClasjeraclisValidator();
   }

   public ClasjeraprodsValidator getClasjeraprodsValidator(){
       return new ClasjeraprodsValidator();
   }

   public ClasjeraprovsValidator getClasjeraprovsValidator(){
       return new ClasjeraprovsValidator();
   }

   public ClasprodsValidator getClasprodsValidator(){
       return new ClasprodsValidator();
   }

   public ClasprovsValidator getClasprovsValidator(){
       return new ClasprovsValidator();
   }

   public CoinsValidator getCoinsValidator(){
       return new CoinsValidator();
   }

   public ColossValidator getColossValidator(){
       return new ColossValidator();
   }

   public CompanysValidator getCompanysValidator(){
       return new CompanysValidator();
   }

   public CompasValidator getCompasValidator(){
       return new CompasValidator();
   }

   public ComprssValidator getComprssValidator(){
       return new ComprssValidator();
   }

   public ComprsTmpsValidator getComprsTmpsValidator(){
       return new ComprsTmpsValidator();
   }

   public ConcepnotsValidator getConcepnotsValidator(){
       return new ConcepnotsValidator();
   }

   public ConceppagsValidator getConceppagsValidator(){
       return new ConceppagsValidator();
   }

   public ConcepssValidator getConcepssValidator(){
       return new ConcepssValidator();
   }

   public ConfgralsValidator getConfgralsValidator(){
       return new ConfgralsValidator();
   }

   public ConsecsValidator getConsecsValidator(){
       return new ConsecsValidator();
   }

   public ContrassValidator getContrassValidator(){
       return new ContrassValidator();
   }

   public ControlexportarsValidator getControlexportarsValidator(){
       return new ControlexportarsValidator();
   }

   public CorreoTerminalsValidator getCorreoTerminalsValidator(){
       return new CorreoTerminalsValidator();
   }

   public CorrselecsValidator getCorrselecsValidator(){
       return new CorrselecsValidator();
   }

   public CortessValidator getCortessValidator(){
       return new CortessValidator();
   }

   public CortszxsValidator getCortszxsValidator(){
       return new CortszxsValidator();
   }

   public CostssValidator getCostssValidator(){
       return new CostssValidator();
   }

   public CotssValidator getCotssValidator(){
       return new CotssValidator();
   }

   public CPaymentFormsValidator getCPaymentFormsValidator(){
       return new CPaymentFormsValidator();
   }

   public CPaymentMethodsValidator getCPaymentMethodsValidator(){
       return new CPaymentMethodsValidator();
   }

   public CTipoComprobantesValidator getCTipoComprobantesValidator(){
       return new CTipoComprobantesValidator();
   }

   public CTipoRelacionsValidator getCTipoRelacionsValidator(){
       return new CTipoRelacionsValidator();
   }

   public CuentasContablessValidator getCuentasContablessValidator(){
       return new CuentasContablessValidator();
   }

   public CumplesValidator getCumplesValidator(){
       return new CumplesValidator();
   }

   public CUsoCFDIsValidator getCUsoCFDIsValidator(){
       return new CUsoCFDIsValidator();
   }

   public CxcsValidator getCxcsValidator(){
       return new CxcsValidator();
   }

   public CxpsValidator getCxpsValidator(){
       return new CxpsValidator();
   }

   public DatoscpsValidator getDatoscpsValidator(){
       return new DatoscpsValidator();
   }

   public DeliverAddressCustomersValidator getDeliverAddressCustomersValidator(){
       return new DeliverAddressCustomersValidator();
   }

   public DocumentOriginsValidator getDocumentOriginsValidator(){
       return new DocumentOriginsValidator();
   }

   public DocumentosContabilizadossValidator getDocumentosContabilizadossValidator(){
       return new DocumentosContabilizadossValidator();
   }

   public DocumentosOrigensValidator getDocumentosOrigensValidator(){
       return new DocumentosOrigensValidator();
   }

   public DocumentosPagosValidator getDocumentosPagosValidator(){
       return new DocumentosPagosValidator();
   }

   public DomentclisValidator getDomentclisValidator(){
       return new DomentclisValidator();
   }

   public EREjerciciossValidator getEREjerciciossValidator(){
       return new EREjerciciossValidator();
   }

   public ERMmovimientosInventariosValidator getERMmovimientosInventariosValidator(){
       return new ERMmovimientosInventariosValidator();
   }

   public ERPermisossValidator getERPermisossValidator(){
       return new ERPermisossValidator();
   }

   public EstadiscorsValidator getEstadiscorsValidator(){
       return new EstadiscorsValidator();
   }

   public ExistalmasValidator getExistalmasValidator(){
       return new ExistalmasValidator();
   }

   public FabssValidator getFabssValidator(){
       return new FabssValidator();
   }

   public FacturassValidator getFacturassValidator(){
       return new FacturassValidator();
   }

   public FlujactsValidator getFlujactsValidator(){
       return new FlujactsValidator();
   }

   public FlujsValidator getFlujsValidator(){
       return new FlujsValidator();
   }

   public GaransValidator getGaransValidator(){
       return new GaransValidator();
   }

   public GeneralConfigsValidator getGeneralConfigsValidator(){
       return new GeneralConfigsValidator();
   }

   public GirosValidator getGirosValidator(){
       return new GirosValidator();
   }

   public GralssValidator getGralssValidator(){
       return new GralssValidator();
   }

   public HistAntiguedaddesaldosValidator getHistAntiguedaddesaldosValidator(){
       return new HistAntiguedaddesaldosValidator();
   }

   public ImpuestosVentasValidator getImpuestosVentasValidator(){
       return new ImpuestosVentasValidator();
   }

   public ImpuestosXComprasValidator getImpuestosXComprasValidator(){
       return new ImpuestosXComprasValidator();
   }

   public ImpuestosXVentasValidator getImpuestosXVentasValidator(){
       return new ImpuestosXVentasValidator();
   }

   public ImpuesxpartidacotsValidator getImpuesxpartidacotsValidator(){
       return new ImpuesxpartidacotsValidator();
   }

   public ImpuesxpartidapedsValidator getImpuesxpartidapedsValidator(){
       return new ImpuesxpartidapedsValidator();
   }

   public ImpuesXProductsValidator getImpuesXProductsValidator(){
       return new ImpuesXProductsValidator();
   }

   public IngresosEncabsValidator getIngresosEncabsValidator(){
       return new IngresosEncabsValidator();
   }

   public IngressValidator getIngressValidator(){
       return new IngressValidator();
   }

   public KitssValidator getKitssValidator(){
       return new KitssValidator();
   }

   public LicensesValidator getLicensesValidator(){
       return new LicensesValidator();
   }

   public LinesValidator getLinesValidator(){
       return new LinesValidator();
   }

   public LogsValidator getLogsValidator(){
       return new LogsValidator();
   }

   public LugssValidator getLugssValidator(){
       return new LugssValidator();
   }

   public MarcprodsValidator getMarcprodsValidator(){
       return new MarcprodsValidator();
   }

   public MarcssValidator getMarcssValidator(){
       return new MarcssValidator();
   }

   public MaxminconfsValidator getMaxminconfsValidator(){
       return new MaxminconfsValidator();
   }

   public MeasuresValidator getMeasuresValidator(){
       return new MeasuresValidator();
   }

   public MedssValidator getMedssValidator(){
       return new MedssValidator();
   }

   public MetogoPagosValidator getMetogoPagosValidator(){
       return new MetogoPagosValidator();
   }

   public ModelprodsValidator getModelprodsValidator(){
       return new ModelprodsValidator();
   }

   public ModelsValidator getModelsValidator(){
       return new ModelsValidator();
   }

   public ModificaImpuestossValidator getModificaImpuestossValidator(){
       return new ModificaImpuestossValidator();
   }

   public MoninvensValidator getMoninvensValidator(){
       return new MoninvensValidator();
   }

   public MovimientosAsientossValidator getMovimientosAsientossValidator(){
       return new MovimientosAsientossValidator();
   }

   public MovimientosPagossValidator getMovimientosPagossValidator(){
       return new MovimientosPagossValidator();
   }

   public MsjssValidator getMsjssValidator(){
       return new MsjssValidator();
   }

   public NewUsersValidator getNewUsersValidator(){
       return new NewUsersValidator();
   }

   public OrdssValidator getOrdssValidator(){
       return new OrdssValidator();
   }

   public PartcomprssValidator getPartcomprssValidator(){
       return new PartcomprssValidator();
   }

   public PartcomprsTmpsValidator getPartcomprsTmpsValidator(){
       return new PartcomprsTmpsValidator();
   }

   public PartcotsValidator getPartcotsValidator(){
       return new PartcotsValidator();
   }

   public PartflujactsValidator getPartflujactsValidator(){
       return new PartflujactsValidator();
   }

   public PartordssValidator getPartordssValidator(){
       return new PartordssValidator();
   }

   public PartprevcomprssValidator getPartprevcomprssValidator(){
       return new PartprevcomprssValidator();
   }

   public PartprevcomprsTmpsValidator getPartprevcomprsTmpsValidator(){
       return new PartprevcomprsTmpsValidator();
   }

   public PartvtasValidator getPartvtasValidator(){
       return new PartvtasValidator();
   }

   public PaymentFormsValidator getPaymentFormsValidator(){
       return new PaymentFormsValidator();
   }

   public PaymentsValidator getPaymentsValidator(){
       return new PaymentsValidator();
   }

   public PedidosPartssValidator getPedidosPartssValidator(){
       return new PedidosPartssValidator();
   }

   public PedidossValidator getPedidossValidator(){
       return new PedidossValidator();
   }

   public PerssValidator getPerssValidator(){
       return new PerssValidator();
   }

   public PessValidator getPessValidator(){
       return new PessValidator();
   }

   public PetissValidator getPetissValidator(){
       return new PetissValidator();
   }

   public PrevcomprssValidator getPrevcomprssValidator(){
       return new PrevcomprssValidator();
   }

   public ProdpartsValidator getProdpartsValidator(){
       return new ProdpartsValidator();
   }

   public ProductsValidator getProductsValidator(){
       return new ProductsValidator();
   }

   public PushNotificationsValidator getPushNotificationsValidator(){
       return new PushNotificationsValidator();
   }

   public RegistroemailsValidator getRegistroemailsValidator(){
       return new RegistroemailsValidator();
   }

   public RegistrossValidator getRegistrossValidator(){
       return new RegistrossValidator();
   }

   public ResplogsValidator getResplogsValidator(){
       return new ResplogsValidator();
   }

   public ResponsablesValidator getResponsablesValidator(){
       return new ResponsablesValidator();
   }

   public RespsValidator getRespsValidator(){
       return new RespsValidator();
   }

   public RFCValidator getRFCValidator(){
       return new RFCValidator();
   }

   public RubrsValidator getRubrsValidator(){
       return new RubrsValidator();
   }

   public RutssValidator getRutssValidator(){
       return new RutssValidator();
   }

   public SalessValidator getSalessValidator(){
       return new SalessValidator();
   }

   public SectoressValidator getSectoressValidator(){
       return new SectoressValidator();
   }

   public SerieprodsValidator getSerieprodsValidator(){
       return new SerieprodsValidator();
   }

   public SeriesValidator getSeriesValidator(){
       return new SeriesValidator();
   }

   public ServerSessionsValidator getServerSessionsValidator(){
       return new ServerSessionsValidator();
   }

   public SubramossValidator getSubramossValidator(){
       return new SubramossValidator();
   }

   public SucursalsValidator getSucursalsValidator(){
       return new SucursalsValidator();
   }

   public SuppliersValidator getSuppliersValidator(){
       return new SuppliersValidator();
   }

   public TallcolosValidator getTallcolosValidator(){
       return new TallcolosValidator();
   }

   public TallsValidator getTallsValidator(){
       return new TallsValidator();
   }

   public TarssValidator getTarssValidator(){
       return new TarssValidator();
   }

   public TaxsValidator getTaxsValidator(){
       return new TaxsValidator();
   }

   public TermarcamodelosValidator getTermarcamodelosValidator(){
       return new TermarcamodelosValidator();
   }

   public TerprodcompasValidator getTerprodcompasValidator(){
       return new TerprodcompasValidator();
   }

   public TipactfijsValidator getTipactfijsValidator(){
       return new TipactfijsValidator();
   }

   public TipscambsValidator getTipscambsValidator(){
       return new TipscambsValidator();
   }

   public TipssValidator getTipssValidator(){
       return new TipssValidator();
   }

   public TraspassValidator getTraspassValidator(){
       return new TraspassValidator();
   }

   public UbiadsValidator getUbiadsValidator(){
       return new UbiadsValidator();
   }

   public UnidsValidator getUnidsValidator(){
       return new UnidsValidator();
   }

   public UpdateUsersValidator getUpdateUsersValidator(){
       return new UpdateUsersValidator();
   }

   public UserPermissionsValidator getUserPermissionsValidator(){
       return new UserPermissionsValidator();
   }

   public UsersValidator getUsersValidator(){
       return new UsersValidator();
   }

   public UsoCFDIsValidator getUsoCFDIsValidator(){
       return new UsoCFDIsValidator();
   }

   public UsuarioseriesValidator getUsuarioseriesValidator(){
       return new UsuarioseriesValidator();
   }

   public WarehousesValidator getWarehousesValidator(){
       return new WarehousesValidator();
   }

   public ZonasValidator getZonasValidator(){
       return new ZonasValidator();
   }

}