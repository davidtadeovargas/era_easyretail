/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.easyretail.controllers.views;

import com.era.utilities.JFrameUtils;
import com.era.views.LoadingWaitJFrame;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.WindowConstants;

/**
 *
 * @author PC
 */
public class LoadingViewController extends LoadingWaitJFrame {
    
    public LoadingViewController(){
        
        super("");
        
        JFrameUtils.getInstance().setIconToWindow(this);
        
        java.net.URL imgURL = getClass().getResource("/imgs/loading.gif");
        if (imgURL != null) {
            labelLoading.setIcon(new ImageIcon(imgURL, ""));            
        } else {
            System.err.println("Couldn't find file: ");            
        }
            
        setAlwaysOnTop( true );
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        toFront();
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
    }

    @Override
    public void clearFields(){            
    }
    
    @Override
    public List<?> getItemsToLoadInTable() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
