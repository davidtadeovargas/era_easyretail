/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.easyretail.controllers.views;

import com.era.utilities.JFrameUtils;
import com.era.views.PremiumJFrame;

/**
 *
 * @author PC
 */
public class PremiumViewController extends PremiumJFrame {
    
    public PremiumViewController(){        
        super();
        
        JFrameUtils.getInstance().setIconToWindow(this);
    }
}
