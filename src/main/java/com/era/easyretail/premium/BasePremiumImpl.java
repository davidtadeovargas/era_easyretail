/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.easyretail.premium;

import com.era.logger.LoggerUtility;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;

/**
 *
 * @author PC
 */
public class BasePremiumImpl implements IPremium {
    
    protected INotPremium INotPremium;
    protected IYesPremium IYesPremium;
    
    //Contains previous button color
    private Color previousButtonForeground;
    private Color previousButtonBackground;

    private static BasePremiumImpl BasePremiumImpl;
    
    private JButton JButtonGlobal;
    
    
    
    
    private BasePremiumImpl(){        
    }
    
    public static BasePremiumImpl getSingleton(){
        if(BasePremiumImpl==null){
            BasePremiumImpl = new BasePremiumImpl();
        }
        return BasePremiumImpl;
    }
    
    @Override
    public void validate(){
        
        final boolean premium = PremiumFunctionsManager.getSingleton().isPremium();
        if(premium){
            
            LoggerUtility.getSingleton().logInfo(BasePremiumImpl.class, "Validating and this is premium");
            
            if(IYesPremium!=null){
                IYesPremium.action();
            }
        }
        else{
            LoggerUtility.getSingleton().logInfo(BasePremiumImpl.class, "Validating and this is not premium");
            
            if(INotPremium!=null){
                INotPremium.action();
            }
        }            
    }
    
    //Paint the button to distinghuis if is premium or not
    public void paintButton(final JButton JButton){
        
        //Another button
        if(JButtonGlobal!=JButton){
            JButtonGlobal = JButton;
            
            previousButtonForeground = JButton.getForeground();
            previousButtonBackground = JButton.getBackground();
        }                    
        
        //Paint the button
        JButton.setForeground(new java.awt.Color(255, 255, 255));
        JButton.setBackground(new java.awt.Color(255, 102, 0));
    }
        
    //Paint the button to distinghuis if is premium or not
    public void paintCombobox(final JComboBox JComboBox){
        
        //Paint the button
        JComboBox.setForeground(new java.awt.Color(255, 255, 255));
        JComboBox.setBackground(new java.awt.Color(255, 102, 0));
    }
    
    //Previus color boton
    public void paintPreviousButton(JButton JButton){
        
        //Another button
        if(JButtonGlobal==JButton){
            
            JButton.setForeground(previousButtonForeground);
            JButton.setBackground(previousButtonBackground);
        }
    }
    
    //Paint the button to distinghuis if is premium or not
    public void paintCheckbox(final JCheckBox JCheckBox){
        JCheckBox.setForeground(new java.awt.Color(255, 255, 255));
        JCheckBox.setBackground(new java.awt.Color(255, 102, 0));
    }
    
    public void setINotPremium(INotPremium INotPremium) {
        this.INotPremium = INotPremium;
    }

    public void setIYesPremium(IYesPremium IYesPremium) {
        this.IYesPremium = IYesPremium;
    }
    
    public boolean isPremium(){
        return PremiumFunctionsManager.getSingleton().isPremium();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
}
