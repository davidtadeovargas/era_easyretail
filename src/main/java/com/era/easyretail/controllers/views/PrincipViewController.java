/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.easyretail.controllers.views;

import com.era.models.BasDats;
import com.era.models.Confgral;
import com.era.models.User;
import com.era.repositories.RepositoryFactory;
import com.era.utilities.UtilitiesFactory;
import com.era.views.PrincipJFrame;
import javax.swing.ImageIcon;

/**
 *
 * @author PC
 */
public class PrincipViewController extends PrincipJFrame {
    
    public PrincipViewController(){
     
        final Confgral Confgral = RepositoryFactory.getInstance().getConfgralRepository().getSistemClasifByConf("reporteCaja");
        jBReporteCaja.setEnabled(Confgral.getVal()==1);
        
        final ImageIcon ImageIcon = UtilitiesFactory.getSingleton().getIconsUtility().getImageIconFromImage("ban.png");                
        jLImg.setIcon(ImageIcon);
        
        final BasDats BasDats = UtilitiesFactory.getSingleton().getSessionUtility().getBasDats();
        final User User = UtilitiesFactory.getSingleton().getSessionUtility().getUser();
        final String userLoggedTime = UtilitiesFactory.getSingleton().getSessionUtility().getUserLoggedTime();
        
        this.setTitle(BasDats.getNom() + " Usuario: <" + User.getName() + "> V2.5.9 " + userLoggedTime);
    }    
}
