/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.easyretail.controllers.views;

import com.era.datamodels.enums.SearchCommonTypeEnum;
import com.era.easyretail.validators.CompanysValidator;
import com.era.logger.LoggerUtility;
import com.era.models.Company;
import com.era.models.User;
import com.era.repositories.RepositoryFactory;
import com.era.views.ClientJFrame;
import com.era.views.dialogs.DialogsFactory;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import com.era.easyretail.validators.RFCValidator;
import com.era.easyretail.validators.EmailValidator;
import com.era.easyretail.validators.WebsitelValidator;
import com.era.models.CCodigopostal;
import com.era.models.CCountry;
import com.era.models.CPaymentForm;
import com.era.models.CUsoCFDI;
import java.math.BigDecimal;

/**
 *
 * @author PC
 */
public class ClientViewController extends ClientJFrame {

    private Company CompanyGlobal;
    
    public ClientViewController() {
        super("window_title_newcustomer");
        
        try{
            
            this.getRootPane().setDefaultButton(jBGuar);
            
            jTRazSoc.grabFocus();
          
            this.JComponentUtils.moneyFormat(jTLimCred);
            
            this.JComponentUtils.onlyNumbers(jTCta);            
            this.JComponentUtils.onlyNumbers(jTClavBanc);

            this.JComponentUtils.limitCharacters(jTClavBanc, 16);
            
            this.JComponentUtils.onKeyTypedToMayus(jTRazSoc);
            this.JComponentUtils.onKeyTypedToMayus(jTCodCli);
            this.JComponentUtils.onKeyTypedToMayus(jTRFC);
            
            this.JComponentUtils.onlyDecimals(jTDesc);            
            
            jBGuar.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBGuarActionPerformed(evt);
            });
            jBSal.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBSalActionPerformed(evt);
            });
            jBVend.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBVendActionPerformed(evt);
            });
            jBCP.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBCPActionPerformed(evt);
            });
            jBPais.addActionListener((java.awt.event.ActionEvent evt) -> {
                jBPaisActionPerformed(evt);
            });
                        
            jComUsoCfdi.setChangeSelectionListener((Object ObjectModel) -> {
                
                try {
                 
                    //Cast the model
                    final CUsoCFDI CUsoCfdi = (CUsoCFDI)ObjectModel;
                    
                    usoCfdiDescription.setText(CUsoCfdi.getDescription());
                    
                } catch (Exception ex) {
                    LoggerUtility.getSingleton().logError(this.getClass(), ex);
                    try {
                        DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
                    } catch (Exception ex1) {
                        Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex1);
                    }
                }
            });
            
            //Load all the comboboxes            
            jComUsoCfdi.loadItems();            
            jComFormPag.loadItems();
            
        }catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ClientViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(ClientViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }

    public void setCompanyGlobal(Company CompanyGlobal) throws Exception {
        
        //Save globally the customr
        this.CompanyGlobal = CompanyGlobal;
        
        //Load the customer in fields
        loadModelInFields(this.CompanyGlobal);
        
        //Disable fields that should not be modified
        jTCodCli.setEditable(false);
    }
    
    @Override
    public void loadModelInFields(Object ObjectModel) throws  Exception {
        
        //Cast model
        final Company Company = (Company)ObjectModel;
        
        String limitCred = "";
        if(Company.getLimtcred().compareTo(BigDecimal.ZERO)>0){
            double dCant = Company.getLimtcred().doubleValue();
            NumberFormat n = NumberFormat.getCurrencyInstance(new Locale("es","MX"));
            limitCred = n.format(dCant);                    
        }
        //Meter en el get de la clase
        String account = "0000";
        if(Company.getCta().compareTo("")!=0){
           account = Company.getCta();
        }

        //Fill all the fields
        jTCodCli.setText(Company.getCompanyCode());
        jTBeneficiario.setText(Company.getBeneficiario());
        jTCtaPred.setText(Company.getCtapred());
        jTCtaConta.setText(Company.getCtaconta());
        jTBanc.setText(Company.getBanc());
        jTClavBanc.setText(Company.getClavbanc());
        jTRazSoc.setText(Company.getNom());
        jTTel.setText(Company.getTel());        
        jTCall.setText(Company.getCalle());
        jTCel.setText(Company.getCel());
        jTExten.setText(Company.getExten());
        jTLada.setText(Company.getLada());
        jTCol.setText(Company.getCol());
        jTCP.setText(Company.getCP());
        jTCiu.setText(Company.getCiu());
        jTEstad.setText(Company.getEstad());
        jTPai.setText(Company.getPai());
        jTRFC.setText(Company.getRFC());
        jTCURP.setText(Company.getCurp());
        jTDesc.setText(String.valueOf(Company.getDescu()));
        jTCo1.setText(Company.getCo1());
        jTVend.setText(Company.getVend());
        jTCo2.setText(Company.getCo2());
        jTPag1.setText(Company.getPagweb1());
        jTCodEmp.setText(Company.getCompanyCode());
        jTNoInt.setText(Company.getNoint());
        jTNoExt.setText(Company.getNoext());
        jTDCred.setText(String.valueOf(Company.getDiacred()));
        jTLimCred.setText(String.valueOf(Company.getLimtcred()));        
        jTCta.setText(Company.getCta());
        jComList.setSelectedItem(String.valueOf(Company.getList()));        
        jCBloq.setSelected(Company.isBloq());
        jCBloqCred.setSelected(Company.isBloqlimcred());

        if(Company.getPers().compareTo("M")==0)
            jRaMor.setSelected(true);
        else
            jRaFis.setSelected(true);
        
        String sDepGar  = Float.toString(Company.getDeposit());
        NumberFormat n = NumberFormat.getCurrencyInstance(Locale.US);
        double dCant = Double.parseDouble(sDepGar);                
        sDepGar = n.format(dCant);        
        
        final String usoCFI = Company.getUsocfdi();
        final CUsoCFDI UsoCFDI = (CUsoCFDI)RepositoryFactory.getInstance().getCUsoCFDIsRepository().getByCode(usoCFI);
        if(UsoCFDI != null){
            jComUsoCfdi.selectByObject(UsoCFDI);            
        }
        final CPaymentForm CPaymentForm = (CPaymentForm)RepositoryFactory.getInstance().getPaymentFormsRepository().getByCode(Company.getMetpag());
        if(CPaymentForm != null){
            jComFormPag.selectByObject(CPaymentForm);
        }
    }
    
    @Override
    public void clearFields() throws Exception{
    }
    
    private void jBPaisActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
            final SearchViewController SearchViewController = new SearchViewController();
            SearchViewController.setSEARCH_TYPE(SearchCommonTypeEnum.COUNTRIES);
            SearchViewController.setButtonAceptClicked(() -> {
                final String countryCode = SearchViewController.getCod();                
                jTPai.setText(countryCode);
            });
            SearchViewController.setVisible();
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ClientViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(ClientViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    
    private void jBCPActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
            final SearchViewController SearchViewController = new SearchViewController();
            SearchViewController.setSEARCH_TYPE(SearchCommonTypeEnum.CPS);
            SearchViewController.setButtonAceptClicked(() -> {
                final String cp = SearchViewController.getCod();                
                jTCP.setText(cp);
            });
            SearchViewController.setVisible();
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ClientViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(ClientViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    
    private void jBVendActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{            	
            
            final SearchViewController SearchViewController = new SearchViewController();
            SearchViewController.setSEARCH_TYPE(SearchCommonTypeEnum.SALES_MAN);
            SearchViewController.setButtonAceptClicked(() -> {
                final String salesmanCode = SearchViewController.getCod();                
                jTVend.setText(salesmanCode);
            });
            SearchViewController.setVisible();
	}
	catch (Exception ex) {
            LoggerUtility.getSingleton().logError(ClientViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(ClientViewController.class.getName()).log(Level.SEVERE, null, ex1);
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
            LoggerUtility.getSingleton().logError(ClientViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(ClientViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    private void jBGuarActionPerformed(java.awt.event.ActionEvent evt) {                                             

	try{
            
            String companyCode = this.jTCodCli.getText().trim();
            String companyName = this.jTRazSoc.getText().trim();
            String RFC = this.jTRFC.getText().trim();
            
            try{
                
                final CompanysValidator CompanysValidator = new CompanysValidator();
                CompanysValidator.setCompanyCode(companyCode);            
                CompanysValidator.setNom(companyName);
                CompanysValidator.setRFC(RFC);
                if(this.CompanyGlobal == null){
                    CompanysValidator.validateInsert();
                }
                else{
                    CompanysValidator.validateUpdate();
                }
                
            }catch(Exception e){
                DialogsFactory.getSingleton().showErrorTextOKDialog(baseJFrame, e.getMessage());
                return;
            }
            
            //New customer
            if(this.CompanyGlobal == null){
                
                //Validate that the customer doesnt exists before continue
                final Company Company = RepositoryFactory.getInstance().getCompanysRepository().getCustomerByCode(companyCode);
                if(Company != null){
                    DialogsFactory.getSingleton().showErrorRecordExistsOKDialog(baseJFrame, (JFrame jFrame) -> {
                        jTCodCli.requestFocus();
                    });
                    return;
                }
            }            
                  
            //Validate that the RFC be valid
            try{

                final RFCValidator RFCValidator = new RFCValidator();
                RFCValidator.setRFC(RFC);
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
            Company Company_;                
            if(this.CompanyGlobal != null){ //Update 
                Company_ = RepositoryFactory.getInstance().getCompanysRepository().rfcExists(RFC, this.CompanyGlobal.getRFC());
            }
            else{ //New
                Company_ = RepositoryFactory.getInstance().getCompanysRepository().rfcExists(RFC);
            }
            if(Company_ != null){
                DialogsFactory.getSingleton().showErrorOKCallbackDialog(baseJFrame, "errors_rfc_exists", (JFrame jFrame) -> {
                    jTRFC.grabFocus();
                });
                return;
            }
            
            //Get the salesman code
            final String salesmanCode = jTVend.getText().trim();
            
            //Validate if apply that the sales person exists before continue
            if(!salesmanCode.isEmpty()){
                final User User = (User)RepositoryFactory.getInstance().getUsersRepository().getByCode(salesmanCode);
                if(User == null){
                    DialogsFactory.getSingleton().showErrorOKRecordNotExistsCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                        jTVend.requestFocus();
                    });
                    return;
                }
            }
                        
            //Get the country code
            final String countryCode = jTPai.getText().trim();
            
            //Validate if apply that the country code exists before continue
            if(!countryCode.isEmpty()){
                final CCountry CCountry = (CCountry)RepositoryFactory.getInstance().getCCountriesRepository().getByCode(countryCode);
                if(CCountry == null){
                    DialogsFactory.getSingleton().showErrorOKRecordNotExistsCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                        jTPai.requestFocus();
                    });
                    return;
                }
            }
            
            //Get emails
            final String email = jTCo1.getText().trim();
            final String email2 = jTCo2.getText().trim();
            
            //If defined email validate the correct sintax
            if(!email.isEmpty()){
                
                try{
                    
                    final EmailValidator EmailValidator = new EmailValidator();
                    EmailValidator.setEmail(email);
                    EmailValidator.isValid();
                    
                }catch(Exception e){
                    DialogsFactory.getSingleton().showErrorOKCallbackDialog(baseJFrame, e.getMessage(), (JFrame jFrame) -> {
                        jTCo1.grabFocus();
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
                        jTCo2.grabFocus();
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
            
            //Get web page
            final String cp = jTCP.getText().trim();
            
            //If defined CP validate that exists
            if(!cp.isEmpty()){
                
                final CCodigopostal CCodigopostal = RepositoryFactory.getInstance().getCCodigoPostalRepository().getByPostalCode(cp);
                if(CCodigopostal == null){
                    DialogsFactory.getSingleton().showErrorOKRecordNotExistsCallbackDialog(baseJFrame, (JFrame jFrame) -> {
                        jTCP.requestFocus();
                    });
                    return;
                }
            }
            
            //Get the record
            final String clabeBank = jTClavBanc.getText().trim();
            
            //Validate that the bank clabe be into limits size
            if(!clabeBank.isEmpty()){
                if(clabeBank.length()!=16){                    
                    DialogsFactory.getSingleton().showErrorOKCallbackDialog(baseJFrame,"errors_clabe_not_in_correct_size", (JFrame jFrame) -> {
                        jTClavBanc.grabFocus();
                    });
                    return;                    
                }
            }
            
            //Question if continue
            DialogsFactory.getSingleton().showQuestionContinueDialog(baseJFrame, (JFrame jFrame) -> {
             
                try{
                    
                    //Create the model
                    String sDesc = jTDesc.getText();        
                    
                    String sPers;
                    if(jRaMor.isSelected())
                        sPers = "M";
                    else
                        sPers = "F";
                    
                    if(sDesc.compareTo("")==0)
                        sDesc = "0";

                    String sDiaCred = jTDCred.getText();        
                    if(sDiaCred.compareTo("")==0)
                        sDiaCred = "0";

                    String sLimCred = jTLimCred.getText();
                    if(sLimCred.compareTo("")==0)
                        sLimCred = "0";

                    sLimCred = sLimCred.replace("$", "").replace(",", "");

                    String sBloq;
                    if(jCBloq.isSelected())
                        sBloq = "1";
                    else
                        sBloq = "0";

                    String sCta = jTCta.getText();

                    if(sCta.compareTo("")==0)
                        sCta = "0000";

                    String sList = jComList.getSelectedItem().toString();
                    
                    String sBloqCred = "0";
                    if(jCBloqCred.isSelected())
                        sBloqCred = "1";

                    //Get the selected payment method            
                    CPaymentForm PaymentForm = (CPaymentForm)jComFormPag.getSelectedObject();
            
                    //If edit or new customer
                    Company Company;
                    if(CompanyGlobal == null){
                        Company = new Company();
                    }
                    else{
                        Company = CompanyGlobal;
                    }
                     
                    //Get selected object
                    final CUsoCFDI CUsoCFDI = (CUsoCFDI)jComUsoCfdi.getSelectedObject();
                    String usoCFDI = "";
                    if(CUsoCFDI != null){
                        usoCFDI = CUsoCFDI.getCode();
                    }
                            
                    Company.setCompanyCode(companyCode);
                    Company.setNom(companyName);                    
                    Company.setTel(jTTel.getText());
                    Company.setUsocfdi(usoCFDI);
                    Company.setBanc(jTBanc.getText());
                    Company.setCtapred(jTCtaPred.getText());
                    Company.setClavbanc(jTClavBanc.getText());
                    Company.setBloqlimcred((sBloqCred.equals("1")));
                    Company.setCtaconta(jTCtaConta.getText());
                    Company.setCel(jTCel.getText());
                    Company.setExten(jTExten.getText());
                    Company.setTelper1(jTTelPer1.getText());
                    Company.setLada(jTLada.getText());
                    Company.setVend(salesmanCode);
                    Company.setCalle(jTCall.getText());                    
                    Company.setCol(jTCol.getText());
                    Company.setCP(cp);
                    Company.setCiu(jTCiu.getText());
                    Company.setEstad(jTEstad.getText());
                    Company.setPai(countryCode);
                    Company.setRFC(RFC);
                    Company.setDescu(Float.parseFloat(sDesc));
                    Company.setCo1(email);
                    Company.setCo2(email2);
                    Company.setPagweb1(webpage);
                    Company.setCurp(jTCURP.getText());
                    Company.setExten(jTNoExt.getText());
                    Company.setNoint(jTNoInt.getText());
                    Company.setDiacred(Integer.valueOf(sDiaCred));
                    Company.setLimtcred(new BigDecimal(sLimCred));
                    Company.setBloq(sBloq.equals("1"));
                    Company.setPers(sPers);
                    Company.setMetpag(PaymentForm.getC_FormaPago());
                    Company.setCta(sCta);
                    Company.setList(Integer.parseInt(sList));
                    Company.setBeneficiario(jTBeneficiario.getText());
                    
                    //Save or update the new customer
                    if(CompanyGlobal != null){
                        RepositoryFactory.getInstance().getCompanysRepository().update(Company);
                    }
                    else{
                        RepositoryFactory.getInstance().getCompanysRepository().save(Company);
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
            LoggerUtility.getSingleton().logError(ClientViewController.class, ex);
            try {
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
            } catch (Exception ex1) {
                Logger.getLogger(ClientViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
	}
    }
    
    @Override
    public List<?> getItemsToLoadInTable() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
