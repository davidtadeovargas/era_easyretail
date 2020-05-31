/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.easyretail.controllers.views;

import com.era.easyretail.premium.PremiumFunctionsManager;
import com.era.logger.LoggerUtility;
import com.era.models.License;
import com.era.models.ServerSession;
import com.era.repositories.RepositoryFactory;
import com.era.utilities.WinRegistry;
import com.era.views.AcerDJFrame;
import com.era.views.dialogs.DialogsFactory;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class AcerDViewController extends AcerDJFrame {
    
    public AcerDViewController() {
        super("window_title_acerd");
        
        try{
         
            serial.grabFocus();
            
            String serialString = WinRegistry.getUserSerie();       
                        
            //Set if the user is premium or not
            String finalString = "";
            final boolean premium = PremiumFunctionsManager.getSingleton().isPremium();
            if(premium){
                if(serialString.isEmpty()){
                    
                    License License = RepositoryFactory.getInstance().getLicensesRepository().getLicense();                
                    
                    finalString += "PREMIUM - " + License.getServerDate() + " - días restantes - " + License.getRemainingDays();
                    
                    final ServerSession ServerSession = RepositoryFactory.getInstance().getServerSessionsRepository().getServerSession();
                    final String genericSerial = ServerSession.getGenericSerial();
                
                    serial.setText(genericSerial);
                    serial.setCaretPosition(0);
                }
                else{
                    
                    serial.setText(serialString);
                    serial.setCaretPosition(0);
            
                    finalString = "PREMIUM";
                }                
            }
            else{
                finalString = "BASICO";
            }        
            estadJTextField.setText(finalString);
            
        }catch (Exception ex) {
            LoggerUtility.getSingleton().logError(AcerDViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(AcerDViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        
    }
    
    @Override
    public List<?> getItemsToLoadInTable() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
