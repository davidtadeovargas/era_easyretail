/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.easyretail.controllers.views;

import com.era.datamodels.enums.SearchCommonTypeEnum;
import com.era.easyretail.premium.BasePremiumImpl;
import com.era.easyretail.validators.EmailValidator;
import com.era.easyretail.validators.RFCValidator;
import com.era.easyretail.validators.SuppliersValidator;
import com.era.easyretail.validators.WebsitelValidator;
import com.era.logger.LoggerUtility;
import com.era.models.Consec;
import com.era.models.Giro;
import com.era.models.Serie;
import com.era.models.Supplier;
import com.era.models.Zona;
import com.era.repositories.RepositoryFactory;
import com.era.utilities.UtilitiesFactory;
import com.era.views.ProvJFrame;
import com.era.views.comboboxes.SeriesCombobox;
import com.era.views.dialogs.DialogsFactory;
import java.awt.event.MouseEvent;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author PC
 */
public class ProvViewController extends ProvJFrame {

    private Supplier SupplierGlobal;
    
    
    public ProvViewController(){
        
        super("window_title_supplier");
        
        try{
            
            jBGuar.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBGuarActionPerformed(evt);
            });
            jBSal.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBSalActionPerformed(evt);
            });
            jBGir.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBGirActionPerformed(evt);
            });
            jBZon.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBZonActionPerformed(evt);
            });
            
            this.JComponentUtils.limitCharacters(jTClavBanc, 16);
            
            this.addMouseListenerClicked(jLCorreo1, (MouseEvent evt) -> {
                try{
                    
                    final String emailTo = jLCorreo1.getText().trim();
                    UtilitiesFactory.getSingleton().getDesktopUtility().openEmailTo(emailTo);
                
                }catch (Exception ex) {
                    LoggerUtility.getSingleton().logError(ProvViewController.class, ex);
                    try {
                        DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
                    } catch (Exception ex1) {
                        Logger.getLogger(ProvViewController.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                }
            });
            
            this.addMouseListenerClicked(jLCorreo2, (MouseEvent evt) -> {
                try{
                    
                    final String emailTo = jLCorreo2.getText().trim();
                    UtilitiesFactory.getSingleton().getDesktopUtility().openEmailTo(emailTo);
                
                }catch (Exception ex) {
                    LoggerUtility.getSingleton().logError(ProvViewController.class, ex);
                    try {
                        DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
                    } catch (Exception ex1) {
                        Logger.getLogger(ProvViewController.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                }
            });
                        
            this.addMouseListenerClicked(jLPag1, (MouseEvent evt) -> {
                try{
                    
                    final String url = jLPag1.getText().trim();
                    UtilitiesFactory.getSingleton().getDesktopUtility().openURL(url);
                
                }catch (Exception ex) {
                    LoggerUtility.getSingleton().logError(ProvViewController.class, ex);
                    try {
                        DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
                    } catch (Exception ex1) {
                        Logger.getLogger(ProvViewController.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                }
            });
            
            this.JComponentUtils.moneyFormat(jTLimiCred);
            
            this.getRootPane().setDefaultButton(jBGuar);
            
            jTNomb.grabFocus();
            
            this.JComponentUtils.onlyNumbers(jTCP);            
            this.JComponentUtils.onlyNumbers(jTDCred);
            this.JComponentUtils.onlyNumbers(jTClavBanc);
            
            this.JComponentUtils.onlyDecimals(jTDesc);
                    
            this.JComponentUtils.onKeyTypedToMayus(jTRFC);
            this.JComponentUtils.onKeyTypedToMayus(jTNomb);
            this.JComponentUtils.onKeyTypedToMayus(jTCiu);
            this.JComponentUtils.onKeyTypedToMayus(jTEstad);
            this.JComponentUtils.onKeyTypedToMayus(jTPai);
            this.JComponentUtils.onKeyTypedToMayus(jTBanc);
            
            //Load all the comboboxes
            jComSer.setType(SeriesCombobox.Type.PROV);
            jComSer.loadItems();
            
            //Validate the premium functionality for the button color
            final BasePremiumImpl BasePremiumImpl_ = BasePremiumImpl.getSingleton();
            BasePremiumImpl_.setINotPremium(() -> {
                BasePremiumImpl_.paintCombobox(jComSer);
            });
            BasePremiumImpl_.validate();

        }catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ProvViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(ProvViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }            
    
    @Override
    public void loadModelInFields(Object ObjectModel) throws  Exception {
        
        jTCtaConta.setText(SupplierGlobal.getContableAccount());
        jTMetPag.setText(SupplierGlobal.getPaymentMethod());
        jTCta.setText(SupplierGlobal.getAccount());
        jTBanc.setText(SupplierGlobal.getBank());
        jTClavBanc.setText(SupplierGlobal.getClaveBank());        
        jTGir.setText(SupplierGlobal.getGiro());
        jTZon.setText(SupplierGlobal.getZone());

        //Money format to the credit limit
        double dCant = this.SupplierGlobal.getLimtcred();
        NumberFormat n = NumberFormat.getCurrencyInstance(new Locale("es","MX"));
        String sLimCred = n.format(dCant);

        /*Coloca todas las lecturas en los campos de edición*/                
        jTProv.setText(SupplierGlobal.getCode());
        jTNomb.setText(SupplierGlobal.getName());
        jTTel.setText(SupplierGlobal.getPhone());
        jTCall.setText(SupplierGlobal.getStreet());
        jTCol.setText(SupplierGlobal.getColony());
        jTCP.setText(SupplierGlobal.getCp());
        jTCel.setText(SupplierGlobal.getCelphone());
        jTExten.setText(SupplierGlobal.getExtension());
        jTNoInt.setText(SupplierGlobal.getInteriorNumber());
        jTLada.setText(SupplierGlobal.getLada());
        jTNoExt.setText(SupplierGlobal.getExternalNumber());
        jTCiu.setText(SupplierGlobal.getCity());
        jTEstad.setText(SupplierGlobal.getEstate());
        jTPai.setText(SupplierGlobal.getCountry());
        jTRFC.setText(SupplierGlobal.getRfc());
        jTDesc.setText(String.valueOf(SupplierGlobal.getDisccount()));
        jTDCred.setText(SupplierGlobal.getCreditDays());
        jTLimiCred.setText(sLimCred);
        jTCorreo1.setText(SupplierGlobal.getEmail1());
        jLCorreo1.setText(SupplierGlobal.getEmail1());
        jTCorreo2.setText(SupplierGlobal.getEmail2());
        jLCorreo2.setText(SupplierGlobal.getEmail2());
        jTPag1.setText(SupplierGlobal.getWebpage1());
        jLPag1.setText(SupplierGlobal.getWebpage1());
        jTAObserv.setText(SupplierGlobal.getObservations());
        jTCodProv.setText(SupplierGlobal.getCode());    
        jTRev.setText(SupplierGlobal.getRevision());    
        jTPag.setText(SupplierGlobal.getPayments());

        if(SupplierGlobal.getPers().compareTo("M")==0)
            jRaMor.setSelected(true);
        else
            jRaFisi.setSelected(true);

        if(SupplierGlobal.isAnotherCoin())
            jCOtraMon.setSelected(true);
        else
            jCOtraMon.setSelected(false);
        
        if(SupplierGlobal.isBloq())
            jCBloq.setSelected(true);
        else
            jCBloq.setSelected(false);
        
        if(SupplierGlobal.isBloqlimcred())
            jCBloqCred.setSelected(true);
        else
            jCBloqCred.setSelected(false);
        
        if(SupplierGlobal.isAnotherCoinC())
            jCOrdOtrMon.setSelected(true);
        else
            jCOrdOtrMon.setSelected(false);
        
        final String serie = this.SupplierGlobal.getSerie();
        final Serie Serie = (Serie)RepositoryFactory.getInstance().getSeriesRepository().getBySerie(serie);
        if(Serie != null){
            jComSer.selectByObject(Serie);
        }
    }
    
    @Override
    public void clearFields(){
    }

    public void setSupplierGlobal(Supplier SupplierGlobal) throws Exception {
        
        //Save globally the supplier
        this.SupplierGlobal = SupplierGlobal;
        
        //Load the supplier in fields
        loadModelInFields(this.SupplierGlobal);
    }
        
    private void jBGuarActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
            String socialRazon = this.jTNomb.getText().trim();                        
            final Serie Serie = (Serie)jComSer.getSelectedObject();            
            
            if(Serie.getCode() == null){
                DialogsFactory.getSingleton().showErrorOKNoSelectionCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                    jComSer.requestFocus();
                });
                return;
            }
            
            //Get the consec based on the serie
            final Consec Consec = (Consec)RepositoryFactory.getInstance().getConsecsRepository().getByID(Serie.getId());
            
            //Get the manual code
            final String manualCode = jTCodProv.getText().trim();
            
            //Get the automated code
            String code;
            if(SupplierGlobal==null){ //Update
                code = Serie.getSer() + String.valueOf((Consec.getConsec() + 1));
            }
            else{//Create
                code = this.jTProv.getText().trim();
            }
            
            //Select the manual code
            if(!manualCode.isEmpty()){
                code = manualCode;
            }
            
            final String code_ = code;
            
            //Validate that can insert the record
            try{
                
                final SuppliersValidator SuppliersValidator = new SuppliersValidator();
                SuppliersValidator.setCode(code_);
                SuppliersValidator.setName(socialRazon);
                SuppliersValidator.setSerie(Serie.getSer());
                if(this.SupplierGlobal == null){
                    SuppliersValidator.validateInsert();
                }
                else{
                    SuppliersValidator.validateUpdate();
                }
                
            }catch(Exception e){
                
                //If also there is not a manual code the user can not continue
                if(manualCode.isEmpty()){
                    DialogsFactory.getSingleton().showErrorTextOKDialog(baseJFrame, e.getMessage());
                    return;
                }
            }
            
            //New supplier
            if(this.SupplierGlobal == null){
                
                //Validate that the supplier doesnt exists before continue
                final Supplier Supplier = (Supplier)RepositoryFactory.getInstance().getSuppliersRepository().getByCode(code);
                if(Supplier != null){
                    DialogsFactory.getSingleton().showErrorRecordExistsOKDialog(baseJFrame, (JFrame jFrame) -> {
                        jTProv.requestFocus();
                    });
                    return;
                }
            }            
            
            //Get the rfc
            final String rfc = jTRFC.getText().trim();
            
            //If not emtpty
            if(!rfc.isEmpty()){
                
                //Validate that the RFC be valid
                try{

                    final RFCValidator RFCValidator = new RFCValidator();
                    RFCValidator.setRFC(rfc);
                    if(jRaMor.isSelected()){
                        RFCValidator.isRFCMoralValid();
                    }                
                    else{
                        RFCValidator.isRFCFisicValid();
                    }

                }catch(Exception e){
                    DialogsFactory.getSingleton().showErrorOKCallbackDialog(baseJFrame, e.getMessage(), (JFrame jFrame) -> {
                        jTRFC.grabFocus();
                    });
                    return;
                }
                
                //Validate that the RFC doesnt exists
                Supplier Supplier_;                
                if(this.SupplierGlobal != null){ //Update 
                    Supplier_ = RepositoryFactory.getInstance().getSuppliersRepository().rfcExists(rfc, this.SupplierGlobal.getRfc());
                }
                else{ //New
                    Supplier_ = RepositoryFactory.getInstance().getSuppliersRepository().rfcExists(rfc);
                }
                if(Supplier_ != null){
                    DialogsFactory.getSingleton().showErrorOKCallbackDialog(baseJFrame, "errors_rfc_exists", (JFrame jFrame) -> {
                        jTRFC.grabFocus();
                    });
                    return;
                }
            }
            
            //Get emails
            final String email = jTCorreo1.getText().trim();
            final String email2 = jTCorreo2.getText().trim();
            
            //If defined email validate the correct sintax
            if(!email.isEmpty()){
                
                try{
                    
                    final EmailValidator EmailValidator = new EmailValidator();
                    EmailValidator.setEmail(email);
                    EmailValidator.isValid();
                    
                }catch(Exception e){
                    DialogsFactory.getSingleton().showErrorOKCallbackDialog(baseJFrame, e.getMessage(), (JFrame jFrame) -> {
                        jTCorreo1.grabFocus();
                    });
                    return;
                }
            }
            if(!email2.isEmpty()){
                
                try{
                    
                    final EmailValidator EmailValidator = new EmailValidator();
                    EmailValidator.setEmail(email2);
                    EmailValidator.isValid();
                    
                }catch(Exception e){
                    DialogsFactory.getSingleton().showErrorOKCallbackDialog(baseJFrame, e.getMessage(), (JFrame jFrame) -> {
                        jTCorreo2.grabFocus();
                    });
                    return;
                }
            }
            
            //Get web page
            final String webpage = jTPag1.getText().trim();            
            
            //If defined webpage validate the correct sintax
            if(!webpage.isEmpty()){
                
                try{
                    
                    final WebsitelValidator WebsitelValidator = new WebsitelValidator();
                    WebsitelValidator.setWebpage(webpage);
                    WebsitelValidator.isValid();
                    
                }catch(Exception e){
                    DialogsFactory.getSingleton().showErrorOKCallbackDialog(baseJFrame, e.getMessage(), (JFrame jFrame) -> {
                        jTPag1.grabFocus();
                    });
                    return;
                }
            }
            
            //Get the zone
            final String zone = jTZon.getText().trim();
            
            //If not empty
            if(!zone.isEmpty()){
                //Validate that the zone doesnt exists before continue
                final Zona Zona = (Zona)RepositoryFactory.getInstance().getZonasRepository().getByCode(zone);
                if(Zona != null){
                    DialogsFactory.getSingleton().showErrorRecordExistsOKDialog(baseJFrame, (JFrame jFrame) -> {
                        jTZon.requestFocus();
                    });
                    return;
                }
            }
            
            //Get the zone
            final String giro = jTGir.getText().trim();
            
            //If not empty
            if(!giro.isEmpty()){
                //Validate that the giro doesnt exists before continue
                final Giro Giro = (Giro)RepositoryFactory.getInstance().getGirosRepository().getByCode(code);
                if(Giro != null){
                    DialogsFactory.getSingleton().showErrorRecordExistsOKDialog(baseJFrame, (JFrame jFrame) -> {
                        jTGir.requestFocus();
                    });
                    return;
                }
            }
            
            //Question if continue
            DialogsFactory.getSingleton().showQuestionContinueDialog(baseJFrame, (JFrame jFrame) -> {
             
                try{
                    
                    String sPers    = "F";
                    if(jRaMor.isSelected())
                        sPers       = "M";
                    
                    String sDesc    = jTDesc.getText();

                    if(sDesc.compareTo("")==0)
                        sDesc       = "0";

                    String sDiaCred = jTDCred.getText();

                    if(sDiaCred.compareTo("")==0)
                        sDiaCred    = "0";

                    String sLimCred = jTLimiCred.getText();

                    if(sLimCred.compareTo("")==0)
                        sLimCred = "0";

                    sLimCred = sLimCred.replace("$", "");

                    sLimCred = sLimCred.replace(",", "");

                    String  sOtrMon;
                    if(jCOtraMon.isSelected())
                        sOtrMon = "1";
                    else
                        sOtrMon = "0";

                    String  sOtrMonO;
                    if(jCOrdOtrMon.isSelected())
                        sOtrMonO = "1";
                    else
                        sOtrMonO = "0";

                    String  sBloq;
                    if(jCBloq.isSelected())
                        sBloq = "1";
                    else
                        sBloq = "0";

                    //Determina si tiene o no bloqueado el crédito
                    String sBloqCred    = "0";
                    if(jCBloqCred.isSelected())
                        sBloqCred       = "1";
                    
                    Supplier Supplier;
                    if(SupplierGlobal == null){
                        Supplier = new Supplier();
                    }
                    else{
                        Supplier = SupplierGlobal;
                    }
                    
                    Supplier.setName(jTNomb.getText());
                    Supplier.setPhone(jTTel.getText());
                    Supplier.setStreet(jTCall.getText());
                    Supplier.setColony(jTCol.getText());
                    Supplier.setCp(jTCP.getText());
                    Supplier.setSerie(Serie.getSer());
                    Supplier.setInteriorNumber(jTNoInt.getText());
                    Supplier.setExternalNumber(jTNoExt.getText());
                    Supplier.setCity(jTCiu.getText());
                    Supplier.setEstate(jTEstad.getText());
                    Supplier.setCountry(jTPai.getText());
                    Supplier.setRfc(jTRFC.getText());
                    Supplier.setDisccount(Float.valueOf(sDesc));
                    Supplier.setCreditDays(sDiaCred);
                    Supplier.setLimtcred(Float.valueOf(sLimCred));
                    Supplier.setEmail1(jTCorreo1.getText());
                    Supplier.setEmail2(jTCorreo2.getText());
                    Supplier.setWebpage1(jTPag1.getText());
                    Supplier.setPersonalPhone1(jTTelPerl11.getText());                    
                    Supplier.setObservations(jTAObserv.getText());
                    Supplier.setCode(code_);
                    Supplier.setPers(sPers);
                    Supplier.setAnotherCoin(jCOtraMon.isSelected());
                    Supplier.setAnotherCoinC(jCOrdOtrMon.isSelected());
                    Supplier.setBloq(jCBloq.isSelected());
                    Supplier.setLada(jTLada.getText());
                    Supplier.setExtension(jTExten.getText());
                    Supplier.setCelphone(jTCel.getText());
                    Supplier.setGiro(jTGir.getText().trim());
                    Supplier.setZone(jTZon.getText().trim());
                    Supplier.setContableAccount(jTCtaConta.getText().trim());                    
                    Supplier.setPaymentMethod(jTMetPag.getText().trim());
                    Supplier.setAccount(jTCta.getText().trim());
                    Supplier.setBank(jTBanc.getText().trim());
                    Supplier.setClaveBank(jTClavBanc.getText().trim());
                    Supplier.setBloqlimcred(jCBloqCred.isSelected());
                                                                    
                    //Save or update the new supplier
                    if(SupplierGlobal != null){
                        RepositoryFactory.getInstance().getSuppliersRepository().update(Supplier);
                    }
                    else{
                        RepositoryFactory.getInstance().getSuppliersRepository().save(Supplier);
                    }
                    
                    //Announce the user of success
                    DialogsFactory.getSingleton().showOKOperationCompletedCallbackDialog(jFrame, (JFrame jFrame1) -> {
                        dispose();
                    });
                    
                }catch (Exception ex) {
                    LoggerUtility.getSingleton().logError(ClientViewController.class, ex);
                    try {
                        DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
                    } catch (Exception ex1) {
                        Logger.getLogger(ClientViewController.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                }
            });
	}
	catch (Exception ex) {
		LoggerUtility.getSingleton().logError(ProvViewController.class, ex);
		try {
                    DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
		} catch (Exception ex1) {
                    Logger.getLogger(ProvViewController.class.getName()).log(Level.SEVERE, null, ex1);
		}
	}
    }
    
    private void jBSalActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
            //Question if continue
            DialogsFactory.getSingleton().showQuestionExitDialog(baseJFrame, (JFrame jFrame) -> {
                dispose();
            });
	}
	catch (Exception ex) {
		LoggerUtility.getSingleton().logError(ProvViewController.class, ex);
		try {
                    DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
		} catch (Exception ex1) {
                    Logger.getLogger(ProvViewController.class.getName()).log(Level.SEVERE, null, ex1);
		}
	}
    }
    
    private void jBGirActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{
            
            final SearchViewController SearchViewController = new SearchViewController();
            SearchViewController.setSEARCH_TYPE(SearchCommonTypeEnum.GIROS);
            SearchViewController.setButtonAceptClicked(() -> {
                final String giroCode = SearchViewController.getCod();                
                jTGir.setText(giroCode);
            });
            SearchViewController.setVisible();
	}
	catch (Exception ex) {
		LoggerUtility.getSingleton().logError(ProvViewController.class, ex);
		try {
                    DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
		} catch (Exception ex1) {
                    Logger.getLogger(ProvViewController.class.getName()).log(Level.SEVERE, null, ex1);
		}
	}
    }
    
    private void jBZonActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
            final SearchViewController SearchViewController = new SearchViewController();
            SearchViewController.setSEARCH_TYPE(SearchCommonTypeEnum.ZONES);
            SearchViewController.setButtonAceptClicked(() -> {
                final String zoneCode = SearchViewController.getCod();                
                jTZon.setText(zoneCode);
            });
            SearchViewController.setVisible();
	}
	catch (Exception ex) {
		LoggerUtility.getSingleton().logError(ProvViewController.class, ex);
		try {
                    DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
		} catch (Exception ex1) {
                    Logger.getLogger(ProvViewController.class.getName()).log(Level.SEVERE, null, ex1);
		}
	}
    }
    
    @Override
    public List<?> getItemsToLoadInTable() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
