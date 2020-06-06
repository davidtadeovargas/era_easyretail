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
import java.util.List;

/**
 *
 * @author PC
 */
public class RegisterWebsiteViewController extends RegisterWebsiteJFrame {
    
    private OnURLLabelClicked OnURLLabelClicked;
    private OnOKButtonClicked OnOKButtonClicked;
    
    
    
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
    
    @Override
    public void loadModelInFields(Object ObjectModel) throws  Exception {        
    }
    
    @Override
    public void clearFields(){
    }
    
    public OnURLLabelClicked getOnURLLabelClicked() {
        return OnURLLabelClicked;
    }

    public void setOnURLLabelClicked(OnURLLabelClicked OnURLLabelClicked) {
        this.OnURLLabelClicked = OnURLLabelClicked;
    }

    public OnOKButtonClicked getOnOKButtonClicked() {
        return OnOKButtonClicked;
    }

    public void setOnOKButtonClicked(OnOKButtonClicked OnOKButtonClicked) {
        this.OnOKButtonClicked = OnOKButtonClicked;
    }
    
    @Override
    public List<?> getItemsToLoadInTable() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
     public interface OnURLLabelClicked{
        public void onClicked(java.awt.event.MouseEvent evt);
    }
    
    public interface OnOKButtonClicked{
        public void onClicked(java.awt.event.ActionEvent evt);
    }
}
