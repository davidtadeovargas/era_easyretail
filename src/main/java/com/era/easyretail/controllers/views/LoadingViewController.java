/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.easyretail.controllers.views;

import com.era.utilities.JFrameUtils;
import com.era.views.LoadingWaitJFrame;

/**
 *
 * @author PC
 */
public class LoadingViewController extends LoadingWaitJFrame {
    
    public LoadingViewController(){
        super();
        
        JFrameUtils.getInstance().setIconToWindow(this);
    }
    
}
