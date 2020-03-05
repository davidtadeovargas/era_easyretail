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
public class RenderControlersViewManager {
    
    private static RenderControlersViewManager RenderControlersViewManager;
    
    private PremiumViewController PremiumViewController;
    private CreatingDatabaseWaitViewController CreatingDatabaseWaitViewController;
    
    
    private RenderControlersViewManager(){        
    }
    
    public static RenderControlersViewManager getSingleton(){
        if(RenderControlersViewManager==null){
            RenderControlersViewManager = new RenderControlersViewManager();            
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
    
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
}
