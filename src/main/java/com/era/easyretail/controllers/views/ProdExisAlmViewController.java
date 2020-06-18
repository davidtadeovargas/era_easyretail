/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.easyretail.controllers.views;

import com.era.logger.LoggerUtility;
import com.era.models.Existalma;
import com.era.repositories.RepositoryFactory;
import com.era.views.ProdExisAlmJFrame;
import com.era.views.dialogs.DialogsFactory;
import com.era.views.tables.headers.TableHeaderFactory;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class ProdExisAlmViewController extends ProdExisAlmJFrame {
    
    public ProdExisAlmViewController() {
        super("window_title_exisalma");
        
        try{
            
            this.disposeButton(jBSal);
            
            //Init the table
            this.BaseJTable = this.jTab;
            this.jTab.addShowColumn(TableHeaderFactory.getSigleton().getExistalmasTableHeader().getROWNUMBER());
            this.jTab.addShowColumn(TableHeaderFactory.getSigleton().getExistalmasTableHeader().getALMA());
            this.jTab.addShowColumn(TableHeaderFactory.getSigleton().getExistalmasTableHeader().getDESCRIPTION());
            this.jTab.addShowColumn(TableHeaderFactory.getSigleton().getExistalmasTableHeader().getEXIST());
            
        }catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ProdExisAlmViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(ProdExisAlmViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }

    public void setProductCode(String productCode) throws Exception {
        
        //Get all the warehouses existences for that product
        final List<Existalma> existences = RepositoryFactory.getInstance().getExistalmasRepository().getAllWarehousesExistencesByProduct(productCode);
        
        //Reload the table
        this.jTab.initTable(existences);
    }   
    
    @Override
    public void clearFields(){
    }
    
    @Override
    public void loadModelInFields(Object ObjectModel) throws  Exception {        
    }
        
    @Override
    public List<?> getItemsToLoadInTable() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
