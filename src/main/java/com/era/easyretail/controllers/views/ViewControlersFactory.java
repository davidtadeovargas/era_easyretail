/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.easyretail.controllers.views;

/**
 *
 * @author PC
 */
public class ViewControlersFactory {
    
    private static ViewControlersFactory RenderControlersViewManager;
    
    private PremiumViewController PremiumViewController;
    private CreatingDatabaseWaitViewController CreatingDatabaseWaitViewController;
    private EmpresasViewController EmpresasViewController;
    private SearchViewController SearchViewController;
    
    
    private ViewControlersFactory(){        
    }
    
    public static ViewControlersFactory getSingleton(){
        if(RenderControlersViewManager==null){
            RenderControlersViewManager = new ViewControlersFactory();            
        }
        return RenderControlersViewManager;
    }
    
    public PremiumViewController getPremiumViewController(){
        if(PremiumViewController==null){
            PremiumViewController = new PremiumViewController();
        }
        return PremiumViewController;
    }
    
    public CreatingDatabaseWaitViewController getCreatingDatabaseWaitViewController(){
        if(CreatingDatabaseWaitViewController==null){
            CreatingDatabaseWaitViewController = new CreatingDatabaseWaitViewController();
        }
        return CreatingDatabaseWaitViewController;
    }
    
    public EmpresasViewController getEmpresasViewController() throws Exception{
        EmpresasViewController = new EmpresasViewController();        
        return EmpresasViewController;
    }
    
    public SearchViewController getSearchViewController() throws Exception{
        if(SearchViewController==null){
            SearchViewController = new SearchViewController();
        }
        return SearchViewController;
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
}
