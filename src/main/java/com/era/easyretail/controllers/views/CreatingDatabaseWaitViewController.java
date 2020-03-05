/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.easyretail.controllers.views;

import com.era.utilities.JFrameUtils;
import com.era.views.CreatingDatabaseWaitJFrame;

/**
 *
 * @author PC
 */
public class CreatingDatabaseWaitViewController extends CreatingDatabaseWaitJFrame {
    
    public CreatingDatabaseWaitViewController(){
        super();
        
        JFrameUtils.getInstance().setIconToWindow(this);
    }
    
}
