/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.easyretail.controllers.views;

import com.era.utilities.JFrameUtils;
import com.era.views.PremiumJFrame;
import java.util.List;

/**
 *
 * @author PC
 */
public class PremiumViewController extends PremiumJFrame {
    
    public PremiumViewController(){                        
        
        JFrameUtils.getInstance().setIconToWindow(this);
    }
    
    @Override
    public void clearFields(){
    }
    
    @Override
    public List<?> getItemsToLoadInTable() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
