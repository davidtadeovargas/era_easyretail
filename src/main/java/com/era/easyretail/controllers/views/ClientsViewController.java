/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.easyretail.controllers.views;

import com.era.views.ClientsJFrame;
import java.util.List;

/**
 *
 * @author PC
 */
public class ClientsViewController extends ClientsJFrame {
    
    public ClientsViewController() {
        super("window_title_customers");
    }
    
    @Override
    public List<?> getItemsToLoadInTable() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
