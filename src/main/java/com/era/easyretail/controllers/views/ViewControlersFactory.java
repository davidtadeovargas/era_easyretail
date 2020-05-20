/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.easyretail.controllers.views;

import com.era.views.AlmasJFrame;
import com.era.views.CatalBancosJFrame;
import com.era.views.CatalogoMonedaJFrame;
import com.era.views.ClientsJFrame;
import com.era.views.CompsJFrame;
import com.era.views.ConceptosPagoJFrame;
import com.era.views.CuentasContablesJFrame;
import com.era.views.ImpsJFrame;
import com.era.views.Impuestos_X_productos_nuevoJFrame;
import com.era.views.LotPedCatJFrame;
import com.era.views.MaxsMinsJFrame;
import com.era.views.MonsJFrame;
import com.era.views.ProdSerJFrame;
import com.era.views.ProdsJFrame;
import com.era.views.ProvsJFrame;
import com.era.views.RubrJFrame;
import com.era.views.SectoresJFrame;
import com.era.views.SeriesJFrame;
import com.era.views.SubramosJFrame;
import com.era.views.TipsPagsJFrame;
import com.era.views.UnidadesJFrame;
import com.era.views.UsrsJFrame;
import com.era.views.VerCtaContJFrame;

/**
 *
 * @author PC
 */
public class ViewControlersFactory {
    
    private static ViewControlersFactory RenderControlersViewManager;
    
    private PremiumViewController PremiumViewController;
    private LoadingViewController CreatingDatabaseWaitViewController;
    private EmpresasViewController EmpresasViewController;
    private SearchViewController SearchViewController;
    private PrincipViewController PrincipViewController;
    private VerCtaContJFrame VerCtaContJFrame;
    private UsrsJFrame UsrsJFrame;
    private UnidadesJFrame UnidadesJFrame;
    private TipsPagsJFrame TipsPagsJFrame;
    private SubramosJFrame SubramosJFrame;
    private SeriesJFrame SeriesJFrame;
    private SectoresJFrame SectoresJFrame;
    private RubrJFrame RubrJFrame;
    private ProvsJFrame ProvsJFrame;
    private ProdsJFrame ProdsJFrame;
    private ProdSerJFrame ProdSerJFrame;
    private MonsJFrame MonsJFrame;
    private MaxsMinsJFrame MaxsMinsJFrame;
    private LotPedCatJFrame LotPedCatJFrame;
    private Impuestos_X_productos_nuevoJFrame Impuestos_X_productos_nuevoJFrame;
    private ImpsJFrame ImpsJFrame;
    private CuentasContablesJFrame CuentasContablesJFrame;
    private ConceptosPagoJFrame ConceptosPagoJFrame;
    private CompsJFrame CompsJFrame;
    private ClientsJFrame ClientsJFrame;
    private CatalogoMonedaJFrame CatalogoMonedaJFrame;
    private CatalBancosJFrame CatalBancosJFrame;
    private AlmasJFrame AlmasJFrame;
    private VerCtaContViewController VerCtaContViewController;
    private UsrsViewController UsrsViewController;
    private UnidadesViewController UnidadesViewController;
    private TipsPagsViewController TipsPagsViewController;
    private SubramosViewController SubramosViewController;
    private SeriesViewController SeriesViewController;
    private SectoresViewController SectoresViewController;
    private RubrViewController RubrViewController;
    private ProvsViewController ProvsViewController;
    private ProdsViewController ProdsViewController;
    private MonsViewController MonsViewController;
    private ProdSerViewController ProdSerViewController;
    private MaxsMinsViewController MaxsMinsViewController;
    private Impuestos_X_productos_nuevoViewController Impuestos_X_productos_nuevoViewController;
    private LotPedCatViewController LotPedCatViewController;
    private ImpsViewController ImpsViewController;
    private CuentasContablesViewController CuentasContablesViewController;
    private ConceptosPagoViewController ConceptosPagoViewController;
    private CompsViewController CompsViewController;
    private ClientsViewController ClientsViewController;
    private CatalogoMonedaViewController CatalogoMonedaViewController;
    private CatalBancosViewController CatalBancosViewController;
    private AlmasViewController AlmasViewController;
    private ClientViewController ClientViewController;
    private AltsMaxsViewController AltsMaxsViewController;
    private AcerDViewController AcerDViewController;
    private AbonosViewController AbonosViewController;
    private ClavMastViewController ClavMastViewController;
    private BajsMinViewController BajsMinViewController;
    private ComprViewController ComprViewController;    
    private CotsViewController CotsViewController;
    private NewNotViewController NewNotViewController;
    private NewNotProvViewController NewNotProvViewController;
    private PedidoViewController PedidoViewController;
    private PedidosViewController PedidosViewController;
    private PrevCompViewController PrevCompViewController;
    private ProdExisAlmViewController ProdExisAlmViewController;
    private RecibOrdViewController RecibOrdViewController;
    private SalidaViewController SalidaViewController;
    private SalidaEntradaViewController SalidaEntradaViewController;
    private SelCorrViewController SelCorrViewController;
    private TicketsFacturadosViewController TicketsFacturadosViewController;
    private TraspasViewController TraspasViewController;
    private TraspasosSalidaViewController TraspasosSalidaViewController;
    private UltPrecsViewController UltPrecsViewController;
    private VAbonsViewController VAbonsViewController;
    private VCompViewController VCompViewController;
    private VOrdsViewController VOrdsViewController;
    private VVtasViewController VVtasViewController;
    private correoTerminalViewController correoTerminalViewController;
    private NewClienExpViewController NewClienExpViewController;
    private MovimientosInventariosViewController MovimientosInventariosViewController;
    private LogCorrsViewController LogCorrsViewController;
    private LPrecsViewController LPrecsViewController;
    private KitsViewController KitsViewController;
    private IngrPrevComViewController IngrPrevComViewController;
    private IngrInventViewController IngrInventViewController;
    private DocumentosTimbradosViewController DocumentosTimbradosViewController;
    private EntradasSalidasViewController EntradasSalidasViewController;
    private FacturarTicketsViewController FacturarTicketsViewController;
    private Impuestos_X_partidaViewController Impuestos_X_partidaViewController;
    private DatsCartaPorViewController DatsCartaPorViewController;
    private CxpViewController CxpViewController;
    private CxcViewController CxcViewController;
    private ConfigBancosViewController ConfigBancosViewController;
    private CobroViewController CobroViewController;
    private BuscCompViewController BuscCompViewController;
    private BuscVtaViewController BuscVtaViewController;
    private NewVtaViewController NewVtaViewController;
    private OptPtoVtaViewController OptPtoVtaViewController;
    private PermsEstacsViewController PermsEstacsViewController;
    private PtoVtaTouViewController PtoVtaTouViewController;
    private VtasViewController VtasViewController;
    private IngrComViewController IngrComViewController;
    private ImpresViewController ImpresViewController;
    private CotNormViewController CotNormViewController;
    private ConfGralViewController ConfGralViewController;
    private LoginOtraViewController LoginOtraViewController;
    
    
    private ViewControlersFactory(){        
    }
    
    public static ViewControlersFactory getSingleton(){
        if(RenderControlersViewManager==null){
            RenderControlersViewManager = new ViewControlersFactory();            
        }
        return RenderControlersViewManager;
    }
    
    public PremiumViewController getPremiumViewController(){
        PremiumViewController = new PremiumViewController();
        return PremiumViewController;
    }
    
    public LoadingViewController getCreatingDatabaseWaitViewController(){
        CreatingDatabaseWaitViewController = new LoadingViewController();
        return CreatingDatabaseWaitViewController;
    }
    
    public EmpresasViewController getEmpresasViewController() throws Exception{
        EmpresasViewController = new EmpresasViewController();        
        return EmpresasViewController;
    }
    
    public SearchViewController getSearchViewController() throws Exception{
        SearchViewController = new SearchViewController();
        return SearchViewController;
    }
    
    public PrincipViewController getPrincipViewController(){
        PrincipViewController = new PrincipViewController();
        return PrincipViewController;       
    }
    
    public VerCtaContViewController getVerCtaContViewController(){
        VerCtaContViewController = new VerCtaContViewController();
        return VerCtaContViewController;       
    }
    
    public UsrsViewController getUsrsViewController(){
        UsrsViewController = new UsrsViewController();
        return UsrsViewController;       
    }
    
    public UnidadesViewController getUnidadesViewController(){
        UnidadesViewController = new UnidadesViewController();
        return UnidadesViewController;       
    }
    
    public TipsPagsViewController getTipsPagsViewController(){
        TipsPagsViewController = new TipsPagsViewController();
        return TipsPagsViewController;       
    }
    
    public SubramosViewController getSubramosViewController(){
        SubramosViewController = new SubramosViewController();
        return SubramosViewController;       
    }
    
    public SeriesViewController getSeriesViewController(){
        SeriesViewController = new SeriesViewController();
        return SeriesViewController;       
    }
    
    public SectoresViewController getSectoresViewController(){
        SectoresViewController = new SectoresViewController();
        return SectoresViewController;       
    }
    
    public RubrViewController getRubrViewController(){
        RubrViewController = new RubrViewController();
        return RubrViewController;       
    }
    
    public ProvsViewController getProvsViewController(){
        ProvsViewController = new ProvsViewController();
        return ProvsViewController;       
    }
    
    public ProdsViewController getProdsViewController(){
        ProdsViewController = new ProdsViewController();
        return ProdsViewController;       
    }
    
    public MonsViewController getMonsViewController(){
        MonsViewController = new MonsViewController();
        return MonsViewController;       
    }
    
    public ProdSerViewController getProdSerViewController(){
        ProdSerViewController = new ProdSerViewController();
        return ProdSerViewController;
    }
    
    public LotPedCatViewController getLotPedCatViewController(){
        LotPedCatViewController = new LotPedCatViewController();
        return LotPedCatViewController;       
    }
    
    public Impuestos_X_productos_nuevoViewController getImpuestos_X_productos_nuevoViewController(){
        Impuestos_X_productos_nuevoViewController = new Impuestos_X_productos_nuevoViewController();
        return Impuestos_X_productos_nuevoViewController;       
    }
    
    public ImpsViewController getImpsViewController(){
        ImpsViewController = new ImpsViewController();
        return ImpsViewController;       
    }
    
    public CuentasContablesViewController getCuentasContablesViewController(){
        CuentasContablesViewController = new CuentasContablesViewController();
        return CuentasContablesViewController;       
    }
    
    public ConceptosPagoViewController getConceptosPagoViewController(){
        ConceptosPagoViewController = new ConceptosPagoViewController();
        return ConceptosPagoViewController;       
    }
    public CompsViewController getCompsViewController(){
        CompsViewController = new CompsViewController();
        return CompsViewController;       
    }
    
    public ClientsViewController getClientsViewController(){
        ClientsViewController = new ClientsViewController();
        return ClientsViewController;       
    }
    
    public CatalogoMonedaViewController getCatalogoMonedaViewController(){
        CatalogoMonedaViewController = new CatalogoMonedaViewController();
        return CatalogoMonedaViewController;       
    }
    
    public CatalBancosViewController getCatalBancosViewController(){
        CatalBancosViewController = new CatalBancosViewController();
        return CatalBancosViewController;       
    }
    
    public AlmasViewController getAlmasViewController(){
        AlmasViewController = new AlmasViewController();
        return AlmasViewController;       
    }
    
    public ClientViewController getClientViewController(){
        ClientViewController = new ClientViewController();
        return ClientViewController;       
    }
    
    public AltsMaxsViewController getAltsMaxsViewController(){
        AltsMaxsViewController = new AltsMaxsViewController();
        return AltsMaxsViewController;       
    }
    
    public AcerDViewController getAcerDViewController(){
        AcerDViewController = new AcerDViewController();
        return AcerDViewController;       
    }
    
    public AbonosViewController getAbonosViewController(){
        AbonosViewController = new AbonosViewController();
        return AbonosViewController;       
    }
        
    public ClavMastViewController getClavMastViewController(){
        ClavMastViewController = new ClavMastViewController();
        return ClavMastViewController;       
    }
    
    public BajsMinViewController getBajsMinViewController(){
        BajsMinViewController = new BajsMinViewController();
        return BajsMinViewController;       
    }        
    
    public ComprViewController getComprViewController(){
        ComprViewController = new ComprViewController();
        return ComprViewController;       
    }
                
    public NewNotViewController getNewNotViewController(){
        NewNotViewController = new NewNotViewController();
        return NewNotViewController;       
    }
    
    public NewNotProvViewController getNewNotProvViewController(){
        NewNotProvViewController = new NewNotProvViewController();
        return NewNotProvViewController;       
    }
    
    public PedidoViewController getPedidoViewController(){
        PedidoViewController = new PedidoViewController();
        return PedidoViewController;       
    }
    
    public PedidosViewController getPedidosViewController(){
        PedidosViewController = new PedidosViewController();
        return PedidosViewController;       
    }
    
    public PrevCompViewController getPrevCompViewController(){
        PrevCompViewController = new PrevCompViewController();
        return PrevCompViewController;       
    }
    
    public ProdExisAlmViewController getProdExisAlmViewController(){
        ProdExisAlmViewController = new ProdExisAlmViewController();
        return ProdExisAlmViewController;       
    }
    
    public RecibOrdViewController getRecibOrdViewController(){
        RecibOrdViewController = new RecibOrdViewController();
        return RecibOrdViewController;       
    }
    
    public SalidaViewController getSalidaViewController(){
        SalidaViewController = new SalidaViewController();
        return SalidaViewController;       
    }
    
    public SalidaEntradaViewController getSalidaEntradaViewController(){
        SalidaEntradaViewController = new SalidaEntradaViewController();
        return SalidaEntradaViewController;       
    }
    
    public SelCorrViewController getSelCorrViewController(){
        SelCorrViewController = new SelCorrViewController();
        return SelCorrViewController;       
    }
    
    public TicketsFacturadosViewController getTicketsFacturadosViewController(){
        TicketsFacturadosViewController = new TicketsFacturadosViewController();
        return TicketsFacturadosViewController;       
    }
    
    public TraspasViewController getTraspasViewController(){
        TraspasViewController = new TraspasViewController();
        return TraspasViewController;       
    }
    
    public TraspasosSalidaViewController getTraspasosSalidaViewController(){
        TraspasosSalidaViewController = new TraspasosSalidaViewController();
        return TraspasosSalidaViewController;       
    }
    
    public UltPrecsViewController getUltPrecsViewController(){
        UltPrecsViewController = new UltPrecsViewController();
        return UltPrecsViewController;       
    }
    
    public VAbonsViewController getVAbonsViewController(){
        VAbonsViewController = new VAbonsViewController();
        return VAbonsViewController;       
    }
    
    public VCompViewController getVCompViewController(){
        VCompViewController = new VCompViewController();
        return VCompViewController;       
    }
    
    public VOrdsViewController getVOrdsViewController(){
        VOrdsViewController = new VOrdsViewController();
        return VOrdsViewController;       
    }
    
    public VVtasViewController getVVtasViewController(){
        VVtasViewController = new VVtasViewController();
        return VVtasViewController;       
    }
    
    public correoTerminalViewController getcorreoTerminalViewController(){
        correoTerminalViewController = new correoTerminalViewController();
        return correoTerminalViewController;       
    }
    
    public NewClienExpViewController getNewClienExpViewController(){
        NewClienExpViewController = new NewClienExpViewController();
        return NewClienExpViewController;       
    }
    
    public MovimientosInventariosViewController getMovimientosInventariosViewController(){
        MovimientosInventariosViewController = new MovimientosInventariosViewController();
        return MovimientosInventariosViewController;       
    }
    
    public LogCorrsViewController getLogCorrsViewController(){
        LogCorrsViewController = new LogCorrsViewController();
        return LogCorrsViewController;       
    }
    
    public LPrecsViewController getLPrecsViewController(){
        LPrecsViewController = new LPrecsViewController();
        return LPrecsViewController;       
    }
    
    public KitsViewController getKitsViewController(){
        KitsViewController = new KitsViewController();
        return KitsViewController;       
    }
    
    public IngrPrevComViewController getIngrPrevComViewController(){
        IngrPrevComViewController = new IngrPrevComViewController();
        return IngrPrevComViewController;       
    }
    
    public IngrInventViewController getIngrInventViewController(){
        IngrInventViewController = new IngrInventViewController();
        return IngrInventViewController;       
    }
    
    public DocumentosTimbradosViewController getDocumentosTimbradosViewController(){
        DocumentosTimbradosViewController = new DocumentosTimbradosViewController();
        return DocumentosTimbradosViewController;       
    }
    
    public EntradasSalidasViewController getEntradasSalidasViewController(){
        EntradasSalidasViewController = new EntradasSalidasViewController();
        return EntradasSalidasViewController;       
    }
    
    public FacturarTicketsViewController getFacturarTicketsViewController(){
        FacturarTicketsViewController = new FacturarTicketsViewController();
        return FacturarTicketsViewController;       
    }
    
    public Impuestos_X_partidaViewController getImpuestos_X_partidaViewController(){
        Impuestos_X_partidaViewController = new Impuestos_X_partidaViewController();
        return Impuestos_X_partidaViewController;       
    }
    
    public DatsCartaPorViewController getDatsCartaPorViewController(){
        DatsCartaPorViewController = new DatsCartaPorViewController();
        return DatsCartaPorViewController;       
    }
    
    public CxpViewController getCxpViewController(){
        CxpViewController = new CxpViewController();
        return CxpViewController;       
    }
    
    public CxcViewController getCxcViewController(){
        CxcViewController = new CxcViewController();
        return CxcViewController;       
    }
    
    public ConfigBancosViewController getConfigBancosViewController(){
        ConfigBancosViewController = new ConfigBancosViewController();
        return ConfigBancosViewController;       
    }
    
    public CobroViewController getCobroViewController(){
        CobroViewController = new CobroViewController();
        return CobroViewController;       
    }
    
    public BuscCompViewController getBuscCompViewController(){
        BuscCompViewController = new BuscCompViewController();
        return BuscCompViewController;       
    }
    
    public BuscVtaViewController getBuscVtaViewController(){
        BuscVtaViewController = new BuscVtaViewController();
        return BuscVtaViewController;       
    }
    
    public NewVtaViewController getNewVtaViewController(){
        NewVtaViewController = new NewVtaViewController();
        return NewVtaViewController;       
    }
    
    public OptPtoVtaViewController getOptPtoVtaViewController(){
        OptPtoVtaViewController = new OptPtoVtaViewController();
        return OptPtoVtaViewController;       
    }
    
    public PermsEstacsViewController getPermsEstacsViewController(){
        PermsEstacsViewController = new PermsEstacsViewController();
        return PermsEstacsViewController;       
    }
    
    public PtoVtaTouViewController getPtoVtaTouViewController(){
        PtoVtaTouViewController = new PtoVtaTouViewController();
        return PtoVtaTouViewController;       
    }
    
    
    public VtasViewController getVtasViewController(){
        VtasViewController = new VtasViewController();
        return VtasViewController;       
    }
    
    
    public IngrComViewController getIngrComViewController(){
        IngrComViewController = new IngrComViewController();
        return IngrComViewController;       
    }
    
    public ImpresViewController getImpresViewController(){
        ImpresViewController = new ImpresViewController();
        return ImpresViewController;       
    }
    
    public CotNormViewController getCotNormViewController(){
        CotNormViewController = new CotNormViewController();
        return CotNormViewController;       
    }
    
    public ConfGralViewController getConfGralViewController(){
        ConfGralViewController = new ConfGralViewController();
        return ConfGralViewController;       
    }
       
    public CotsViewController getCotsViewController(){
        CotsViewController = new CotsViewController();
        return CotsViewController;
    }
    
    public LoginOtraViewController getLoginOtraViewController(){
        LoginOtraViewController = new LoginOtraViewController();
        return LoginOtraViewController;
    }
    
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
}