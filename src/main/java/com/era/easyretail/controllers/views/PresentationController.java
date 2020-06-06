/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.easyretail.controllers.views;

import com.era.easyretail.enums.LoginTypeEmpresa;
import com.era.views.PresentationJFrame;
import java.util.List;

/**
 *
 * @author PC
 */
public class PresentationController extends PresentationJFrame {
    
    public PresentationController(){
        
        initTimer();
    }
    
    private void initTimer(){
        
        //Close the window in seconds
        (new Thread()
        {
            @Override
            public void run()
            {
                /*Duerme el thread 4 segundos*/
                try
                {
                    Thread.sleep(4000);
                }
                catch(InterruptedException expnInterru)
                {                    
                }
                
                /*Llama al recolector de basura*/
                System.gc();
        
                /*Cierra la forma*/
                dispose();
                
                //Show login screen
                final LoginViewController LoginViewController = ViewControlersFactory.getSingleton().getLoginViewController();
                LoginViewController.setLoginTypeEmpresa(LoginTypeEmpresa.FIRST_LOGIN);
                LoginViewController.setVisible();
            }
            
        }).start();
    }
    
    @Override
    public void loadModelInFields(Object ObjectModel) throws  Exception {        
    }
    
    @Override
    public void clearFields(){
    }
    
    @Override
    public List<?> getItemsToLoadInTable() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
