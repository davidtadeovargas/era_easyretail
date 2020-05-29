/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.easyretail.controllers.views;

import com.era.views.ReportsJFrame;
import java.util.List;

/**
 *
 * @author PC
 */
public class ReportsViewController extends ReportsJFrame {
    
    public ReportsViewController(){
     
        super("window_title_general_reports");
    }    

    @Override
    public List<?> getItemsToLoadInTable() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
