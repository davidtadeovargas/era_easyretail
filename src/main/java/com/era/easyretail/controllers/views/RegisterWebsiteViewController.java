/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.easyretail.controllers.views;

import com.era.views.RegisterWebsiteJFrame;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

/**
 *
 * @author PC
 */
public class RegisterWebsiteViewController extends RegisterWebsiteJFrame {
    
    public RegisterWebsiteViewController(){
        
        this.setOnURLLabelClicked((MouseEvent me) -> {
            
            try {
                Desktop.getDesktop().browse(new URL("http://easyretail.com.mx/").toURI());
            } catch (URISyntaxException | IOException e) {
                e.printStackTrace();
            }
        });
        
        this.setOnOKButtonClicked((ActionEvent ae) -> {
            dispose();
        });
    }       
}
