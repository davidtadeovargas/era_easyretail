/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.easyretail.controllers.views;

import com.era.views.ActivosJFrame;
import java.util.List;

/**
 *
 * @author PC
 */
public class ActivosViewController extends ActivosJFrame {
    
    public ActivosViewController(){
        
        super("window_title_actives");
    }

    @Override
    public List<?> getItemsToLoadInTable() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
