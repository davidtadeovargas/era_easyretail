/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.easyretail.controllers.views;

import com.era.logger.LoggerUtility;
import com.era.models.User;
import com.era.repositories.RepositoryFactory;
import com.era.views.ImpresJFrame;
import com.era.views.dialogs.DialogsFactory;
import com.era.views.tables.headers.TableHeaderFactory;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class ImpresViewController extends ImpresJFrame {
    
    public ImpresViewController() {
        super("window_title_impres");
        
        try{
         
            //Load the items in table
            this.loadItemsInTable();

            //Load the printers
            jComImpTick.loadItems();
            jComImpFact.loadItems();

            //Specify the columnos to show in the table
            this.BaseJTable = this.jTab;
            this.jTab.addShowColumn(TableHeaderFactory.getSigleton().getUsersTableHeader().getNO());
            this.jTab.addShowColumn(TableHeaderFactory.getSigleton().getUsersTableHeader().getUSER());
            this.jTab.addShowColumn(TableHeaderFactory.getSigleton().getUsersTableHeader().getTICKET_PRINTER());
            this.jTab.addShowColumn(TableHeaderFactory.getSigleton().getUsersTableHeader().getINVOICE_PRINTER());
            this.jTab.addShowColumn(TableHeaderFactory.getSigleton().getUsersTableHeader().getMM_52());
            this.jTab.addShowColumn(TableHeaderFactory.getSigleton().getUsersTableHeader().getCORT());
            
            //Load all the users in the table
            this.loadItemsInTable();
            
        }catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ImpresViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(ImpresViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
 
    @Override
    public List<?> getItemsToLoadInTable() throws Exception {
        final List<User> users = (List<User>) RepositoryFactory.getInstance().getUsersRepository().getAll();
        return users;
    }
}
