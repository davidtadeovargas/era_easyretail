/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.easyretail.controllers.views;

import com.era.views.Presentation;

/**
 *
 * @author PC
 */
public class PresentationController extends Presentation {
    
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
                LoginController LoginController = new LoginController();
                LoginController.setVisible();
            }
            
        }).start();
    }
}
