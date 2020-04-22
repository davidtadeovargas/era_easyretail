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
    
    
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
}
