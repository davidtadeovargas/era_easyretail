/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.easyretail.controllers.views;

import com.era.views.ListadoPagosJFrame;
import java.util.List;

/**
 *
 * @author PC
 */
public class ListadoPagosViewController extends ListadoPagosJFrame {
    
    public ListadoPagosViewController() {
        super("window_title_list_payments");
    }
    
    @Override
    public List<?> getItemsToLoadInTable() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
