/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.easyretail.swingworkers;

import com.era.logger.LoggerUtility;
import com.era.views.BaseJFrame;
import com.era.views.LoadingWaitJFrame;
import com.era.views.ViewsFactory;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

/**
 *
 * @author PC
 */
public class BaseSwingWorker extends SwingWorker {
    
    protected ISwingWorkerActions ISwingWorkerActions;
    private boolean showLoading;
    private boolean blockComponents = true;
    private BaseJFrame BaseJFrame;

    @Override
    protected Object doInBackground() throws Exception{
            
        Object Object = null;
        
        if(ISwingWorkerActions!=null){
            
            //Run before in ui thread
            SwingUtilities.invokeLater(() -> {
                
                if(showLoading){
                    
                    if(blockComponents){
                        
                        //Disable all the jframe components
                        BaseJFrame.getJComponentUtils().disableAllComponents(BaseJFrame);
                    }

                    //Show the loading database window
                    final LoadingWaitJFrame LoadingWaitJFrame = ViewsFactory.getSingleton().getLoadingWaitJFrame();
                    LoadingWaitJFrame.setVisible(true);
                }
                
                ISwingWorkerActions.before();
            });
            
            //Run in background
            Object = ISwingWorkerActions.doinbackground();
        }
        
        return Object;
    }

    public void setBlockComponents(boolean blockComponents) {
        this.blockComponents = blockComponents;
    }
    

    public void setShowLoading(final BaseJFrame BaseJFrame) {
        this.showLoading = true;
        this.BaseJFrame = BaseJFrame;
    }
    
    @Override
    protected void done() {
        
        super.done();
        
        try{
            
            final Object Object = this.get();
                
            if(showLoading){
                
                if(blockComponents){
                    
                    //Enable all the jframe components
                    BaseJFrame.getJComponentUtils().enableAllComponents(BaseJFrame);
                }                
                    
                //Hide the loading database window
                final LoadingWaitJFrame LoadingWaitJFrame = ViewsFactory.getSingleton().getLoadingWaitJFrame();
                LoadingWaitJFrame.setVisible(false);
            }
            
            if(ISwingWorkerActions!=null){
                ISwingWorkerActions.after(Object);
            }

        }catch(Exception Exception){
            LoggerUtility.getSingleton().logError(BaseSwingWorker.class, Exception);
        }
    }
           
    
    public void setISwingWorkerActions(ISwingWorkerActions ISwingWorkerActions) {
        this.ISwingWorkerActions = ISwingWorkerActions;
    }        
}
