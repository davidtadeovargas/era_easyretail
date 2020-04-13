/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.easyretail.controllers.views;

import com.era.datamodels.CertificatesDataModel;
import com.era.datamodels.enums.SearchCommonTypeEnum;
import com.era.easyretail.premium.BasePremiumImpl;
import com.era.logger.LoggerUtility;
import com.era.models.BasDats;
import com.era.repositories.RepositoryFactory;
import com.era.repositories.models.HibernateConfigModel;
import com.era.repositories.utils.HibernateConfigUtil;
import com.era.repositories.utils.MysqlScriptsUtil;
import com.era.utilities.FileChooserUtility;
import com.era.utilities.PathsUtility;
import com.era.utilities.UtilitiesFactory;
import com.era.views.CreatingDatabaseWaitJFrame;
import com.era.views.EmpresasJFrame;
import com.era.views.ViewsFactory;
import com.era.views.dialogs.DialogsFactory;
import com.era.views.dialogs.OKDialog;
import com.era.views.dialogs.QuestionDialog;
import java.awt.event.ActionEvent;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.event.ListSelectionEvent;

/**
 *
 * @author PC
 */
public class EmpresasViewController extends EmpresasJFrame {
    
    private BasDats Company;
    private String certificatePath;
    private String certificateKeyPath;
    private String templatePath;
    private String appPath;
    private String logoPath;    
    
    
    public EmpresasViewController() throws Exception{
        
        this.setPropertyTitle("companies_title");                
        
        //Validate the premium functionality for the button color
        final BasePremiumImpl BasePremiumImpl_ = BasePremiumImpl.getSingleton();
        BasePremiumImpl_.setINotPremium(() -> {
            BasePremiumImpl_.paintButton(BTNNuevaEmpresa); //Paint the button to desired premium                        
        });
        BasePremiumImpl_.validate();
        
        JTCodigoEmpresa.setText(UtilitiesFactory.getSingleton().getGeneralsUtility().getUniqueDayCode());
        
        loadCompanies();
                
        jTabEmpresas.setITableRowSelected((ListSelectionEvent lse) -> {
            
            if(jTabEmpresas.getRowCount() > 0){
                if (jTabEmpresas.getSelectedRow() == -1){
                    jTabEmpresas.setRowSelectionInterval(0, 0);
                }
                
                Company = (BasDats) jTabEmpresas.getRowSelected();
                
                vCargaComponentes(Company);
            }
        });  
        
        //To mayus when typed
        JComponentUtils.onKeyTypedToMayus(JTRFC);
        
        BTNCargaCDS.addActionListener((ActionEvent e) -> {
            buttonCertificatePathClicked(e);
        });
        BTNCargaKey.addActionListener((ActionEvent e) -> {
            buttonCertificateKeyPathClicked(e);
        });
        BTNPlantilla.addActionListener((ActionEvent e) -> {
            buttonPlantillaPathClicked(e);
        });
        btnRutaAplicacion.addActionListener((ActionEvent e) -> {
            buttonAppPathClicked(e);
        });
        BTNRespalda.addActionListener((ActionEvent e) -> {
            buttonBackupDBPathClicked(e);
        });
        BTNRestaura.addActionListener((ActionEvent e) -> {
            buttonImportBackupClicked(e);
        });        
        BTNBorraPorId.addActionListener((ActionEvent e) -> {
            buttonDeleteCompanyClicked(e);
        });
        BTNActualiza.addActionListener((ActionEvent e) -> {
            buttonUpdateCompanyClicked(e);
        });
        BTNNuevaEmpresa.addActionListener((ActionEvent e) -> {
            buttonNewCompanyClicked(e);
        });
        BTNLimpiarCampos.addActionListener((ActionEvent e) -> {
            buttonClearFieldsClicked(e);
        });
        BTNPruebaPW.addActionListener((ActionEvent e) -> {
            buttonTestCertificateClicked(e);
        });
        BTNCodigoPostal.addActionListener((ActionEvent e) -> {
            buttonSearchCPClicked(e);
        });
        BTNCargaPais.addActionListener((ActionEvent e) -> {
            buttonSearchCountryClicked(e);
        });
        jBCargImg.addActionListener((ActionEvent e) -> {
            buttonLoadIconClicked(e);
        });
        jBDelImg.addActionListener((ActionEvent e) -> {
            buttonDeleteImageClicked(e);
        });        
    }
        
    private void buttonDeleteImageClicked(ActionEvent e){
     
        jLImg.setIcon(null);
        jLImg.setVisible(false);
    }
    
    private void buttonLoadIconClicked(ActionEvent e){
     
        try{
            
            final FileChooserUtility FileChooserUtility = UtilitiesFactory.getSingleton().getFileChooserUtility();
            FileChooserUtility.setPropertyTitle("fc_titles_search_logo");
            FileChooserUtility.setIApproveOpption((String absolutePath, String fileName) -> {
                
                try{
                    
                    if(     !fileName.endsWith(".jpg") && 
                            !fileName.endsWith(".jpeg") && 
                            !fileName.endsWith(".bmp") && 
                            !fileName.endsWith(".gif") && 
                            !fileName.endsWith(".png")){
                        
                        final OKDialog OKDialog = DialogsFactory.getSingleton().getOKDialog(baseJFrame);
                        OKDialog.setPropertyText("basdats_frame_msg18");
                        OKDialog.show();
                        return;
                    }
                    
                    logoPath = absolutePath + "\\" + fileName;
                    
                    jLImg.setIcon(new ImageIcon(logoPath));
                    jLImg.setVisible(true);
                
                }catch(Exception ex){
            
                    try {

                        LoggerUtility.getSingleton().logError(EmpresasViewController.class, ex);

                        DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();

                    } catch (Exception ex1) {
                        Logger.getLogger(EmpresasViewController.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                }
            });
            FileChooserUtility.showSaveDialog(baseJFrame);
        }
        catch(Exception ex){
            
            try {

                LoggerUtility.getSingleton().logError(EmpresasViewController.class, ex);

                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();

            } catch (Exception ex1) {
                Logger.getLogger(EmpresasViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    private void buttonSearchCountryClicked(ActionEvent e){
        
        try{
            
            final SearchViewController SearchViewController = new SearchViewController();
            SearchViewController.setSEARCH_TYPE(SearchCommonTypeEnum.COUNTRIES);
            SearchViewController.setButtonAceptClicked(() -> {
                final String country = SearchViewController.getCod();                
                JTPais.setText(country);
            });
            SearchViewController.setVisible();
        }
        catch(Exception ex){
            
            try {

                LoggerUtility.getSingleton().logError(EmpresasViewController.class, ex);

                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();

            } catch (Exception ex1) {
                Logger.getLogger(EmpresasViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    private void buttonSearchCPClicked(ActionEvent e){
        
        try{
            
            final SearchViewController SearchViewController = new SearchViewController();
            SearchViewController.setSEARCH_TYPE(SearchCommonTypeEnum.CPS);
            SearchViewController.setButtonAceptClicked(() -> {
                final String cp = SearchViewController.getCod();                
                JTCP.setText(cp);
            });
            SearchViewController.setVisible();
        }
        catch(Exception ex){
            
            try {

                LoggerUtility.getSingleton().logError(EmpresasViewController.class, ex);

                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();

            } catch (Exception ex1) {
                Logger.getLogger(EmpresasViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }        
    }
    
    private void buttonTestCertificateClicked(ActionEvent e){
        
        try{
            
            //Test that the certificate is valid        
            if(validateCertificate()){
                final QuestionDialog QuestionDialog = DialogsFactory.getSingleton().getQuestionDialog(baseJFrame);
                QuestionDialog.setPropertyText("basdats_frame_msg15");
                QuestionDialog.show();
            }
        }
        catch(Exception ex){
            
            try {

                LoggerUtility.getSingleton().logError(EmpresasViewController.class, ex);

                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();

            } catch (Exception ex1) {
                Logger.getLogger(EmpresasViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    private void buttonClearFieldsClicked(ActionEvent e){
        
        try{
            this.clearFields();
        }
        catch(Exception ex){
            
            try {

                LoggerUtility.getSingleton().logError(EmpresasViewController.class, ex);

                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();

            } catch (Exception ex1) {
                Logger.getLogger(EmpresasViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    private void buttonNewCompanyClicked(ActionEvent e){
        
        try{
            
             //Validate the premium functionality
            final BasePremiumImpl BasePremiumImpl_ = BasePremiumImpl.getSingleton();
            BasePremiumImpl_.setINotPremium(() -> {
                ViewControlersFactory.getSingleton().getPremiumViewController().setVisible();
            });
            BasePremiumImpl_.validate();
            if(!BasePremiumImpl_.isPremium()){            
                return;
            }
            
            //Valida que los campos requeridos no tengan cadenas vacias            
            final boolean fieldsFilled = validateRequiredFields();
            if(!fieldsFilled){
                final OKDialog OKDialog = DialogsFactory.getSingleton().getOKDialog(baseJFrame);
                OKDialog.setPropertyText("basdats_frame_msg9");
                OKDialog.show();
            }                        
            else{
                
                //Show the loading dialog
                final CreatingDatabaseWaitJFrame CreatingDatabaseWaitJFrame = ViewsFactory.getSingleton().getCreatingDatabaseWaitJFrame();
                CreatingDatabaseWaitJFrame.setVisible(true);
                
                //Save the new company
                this.updateCompany(false);

                //Create the new database structure
                final HibernateConfigModel HibernateConfigModel = HibernateConfigUtil.getInstance().getHibernateConfigFile();
                MysqlScriptsUtil.getInstance().creaDB(this.Company.getBd(), HibernateConfigModel.getUser(), HibernateConfigModel.getPassword(), HibernateConfigModel.getInstance(), HibernateConfigModel.getPort());
                                
                //Hide the loading database window
                CreatingDatabaseWaitJFrame.setVisible(false);                                
                                
                //Reload table
                this.loadCompanies();
                
                //Show success dialog
                final QuestionDialog QuestionDialog = DialogsFactory.getSingleton().getQuestionDialog(baseJFrame);
                QuestionDialog.setPropertyText("basdats_frame_msg14");
                QuestionDialog.show();
            }
        }
        catch(Exception ex){
            
            try {

                LoggerUtility.getSingleton().logError(EmpresasViewController.class, ex);

                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();

            } catch (Exception ex1) {
                Logger.getLogger(EmpresasViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    private void updateCompany(final boolean update) throws Exception {
                
        String MetodoCosteo      = "";
        String TipoContribuyente = "";
        String RegimenFiscal     = "";

         /*Determina el método de costeo seleccionado*/
        if(JRBPEPS.isSelected())
            MetodoCosteo    = "peps";
        else if(JRBUEPS.isSelected())
            MetodoCosteo    = "ueps";
        else if(JRBPromedio.isSelected())
            MetodoCosteo    = "prom";
        else 
            MetodoCosteo    = "ultcost";

         /*Determina el tipo de contribuyente*/
        if(JRBFisica.isSelected())
            TipoContribuyente = "F";
        else 
            TipoContribuyente = "M";

        StringTokenizer tokens = new StringTokenizer(JTRegimenFiscal.getText().trim(), "-");

        if (tokens.hasMoreTokens()) {
            RegimenFiscal = tokens.nextToken().trim();
        }

        /*Si hay archivo en el certificado entonces*/
        if(JTRutaCertificado.getText().trim().compareTo("")!=0)
        {            
            /*Si el certificado es valido entonces mueve el archivo de certificado y llave a la carpeta de la empresa*/
            if(!validateCertificate())
            {
                final CertificatesDataModel CertificatesDataModel = UtilitiesFactory.getSingleton().getCertificatesUtility().copyCertificatesToFoler(Company.getCodemp(), Company.getRutap(), certificatePath, certificateKeyPath);

                Company.setRutcer(CertificatesDataModel.getCertificatePath());
                Company.setRutkey(CertificatesDataModel.getCertificateKeyPath());
            }
        } 
        
        //If logo to update so
        if(logoPath!=null){
            final PathsUtility PathsUtility = UtilitiesFactory.getSingleton().getPathsUtility();
            String companyLogoPath = PathsUtility.getCompanyLogoPath();
            final String logoFileName = UtilitiesFactory.getSingleton().getPathsUtility().getLogoFileName();
            companyLogoPath += "\\" + logoFileName;
            UtilitiesFactory.getSingleton().getFilesUtility().copyFile(logoPath, companyLogoPath);
        }
        
        Company.setNom(JTEmpresa.getText().trim());
        Company.setCodemp(JTCodigoEmpresa.getText());
        Company.setBd(JTBaseDeDatos.getText());
        Company.setMetcost(MetodoCosteo);
        Company.setTel(JTTelefono.getText());
        //Company.setExtension(JTExtTel.getText());
        Company.setCalle(JTCalle.getText());
        Company.setNoext(JTNoExt.getText());
        Company.setNoint(JTNoInt.getText());
        Company.setCol(JTColonia.getText());
        Company.setCiu(JTCiudad.getText());
        Company.setEstad(JTEstado.getText());
        Company.setPai(JTPais.getText());
        Company.setRFC(JTRFC.getText());
        Company.setCorr(JTCorreoElectronico.getText());
        Company.setSucu(JTSucursal.getText());
        Company.setNocaj(JTCaja.getText());
        Company.setPagweb(JTSitioWeb.getText());
        //Company.setRegfisc(TipoContribuyente);
        Company.setEstac(JTEstacion.getText());
        Company.setLugexp(JTLugarDeExpedicion.getText());
        Company.setRegfisc(RegimenFiscal);
        Company.setRutcer(JTRutaCertificado.getText());
        Company.setRutkey(JTRutaKey.getText());
        Company.setPasscer(JTPasswordCertificado.getText());
        Company.setCP(JTCP.getText());
        //Company.setp(JTPlantilla.getText());
        Company.setRutap(JTRutaAplicacion.getText());

        //Update or add the new company
        if(update){
            RepositoryFactory.getInstance().getBasDatsRepository().update(Company);
        }
        else{
            RepositoryFactory.getInstance().getBasDatsRepository().save(Company);
        }

        //Save the new app path        
        //UtilitiesFactory.getSingleton().getSessionUtility().setRutApp(Company.getRutap());
    }
    
    private void buttonUpdateCompanyClicked(ActionEvent e){
        
        try{
            
            //No row selection
            if(jTabEmpresas.getSelectedRow()==-1){
                final OKDialog OKDialog = DialogsFactory.getSingleton().getOKDialog(baseJFrame);
                OKDialog.setPropertyText("basdats_frame_msg20");
                OKDialog.show();
                return;
            }
            
            final QuestionDialog QuestionDialog = DialogsFactory.getSingleton().getQuestionDialog(baseJFrame);
            QuestionDialog.setPropertyText("question_continue");
            QuestionDialog.setOKDialogInterface((JFrame jFrame) -> {
                
                try{
                    
                    //Updte the company in the database
                    updateCompany(true);
                             
                    jTabEmpresas.clearRows();
                    
                    //Reload table
                    this.loadCompanies();
                    
                    //Success message
                    final OKDialog OKDialog = DialogsFactory.getSingleton().getOKDialog(baseJFrame);
                    OKDialog.setPropertyText("basdats_frame_msg13");
                    OKDialog.show();

                }catch(Exception ex){
            
                    try {

                        LoggerUtility.getSingleton().logError(EmpresasViewController.class, ex);

                        DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();

                    } catch (Exception ex1) {
                        Logger.getLogger(EmpresasViewController.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                }
            });
            QuestionDialog.show();
            
        }catch(Exception ex){
            
            try {
                
                LoggerUtility.getSingleton().logError(EmpresasViewController.class, ex);
                
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
                
            } catch (Exception ex1) {
                Logger.getLogger(EmpresasViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    private void buttonDeleteCompanyClicked(ActionEvent e){
                
        try{
            
            //No row selection
            if(jTabEmpresas.getSelectedRow()==-1){
                final OKDialog OKDialog = DialogsFactory.getSingleton().getOKDialog(baseJFrame);
                OKDialog.setPropertyText("basdats_frame_msg19");
                OKDialog.show();
                return;
            }
            
            //Continue ?
            final QuestionDialog QuestionDialog = DialogsFactory.getSingleton().getQuestionDialog(baseJFrame);
            QuestionDialog.setPropertyText("question_continue");
            QuestionDialog.setOKDialogInterface((JFrame jFrame) -> {                
                
                try{
                    
                    final BasDats BasDats = (BasDats) jTabEmpresas.getRowSelected();
                    
                    //Delete company database and record from basdats
                    final HibernateConfigModel HibernateConfigModel = HibernateConfigUtil.getInstance().getHibernateConfigFile();
                    MysqlScriptsUtil.getInstance().deleteDatabase(HibernateConfigModel.getUser(), HibernateConfigModel.getPassword(), HibernateConfigModel.getInstance(), HibernateConfigModel.getPort(), BasDats.getBd());
                    RepositoryFactory.getInstance().getBasDatsRepository().deleteBasDats(BasDats.getCodemp());
                    
                    //Clear all fields
                    clearFields();
                    
                    //Reload table
                    loadCompanies();                    
                    
                }catch(Exception ex){
            
                    try {

                        LoggerUtility.getSingleton().logError(EmpresasViewController.class, ex);

                        DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();

                    } catch (Exception ex1) {
                        Logger.getLogger(EmpresasViewController.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                }
            });
            QuestionDialog.show();
            
        }catch(Exception ex){
            
            try {
                
                LoggerUtility.getSingleton().logError(EmpresasViewController.class, ex);
                
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
                
            } catch (Exception ex1) {
                Logger.getLogger(EmpresasViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    private void buttonBackupDBPathClicked(ActionEvent e){
            
        try{
            
            //No row selecion
            if(jTabEmpresas.getSelectedRow()==-1){
                final OKDialog OKDialog = DialogsFactory.getSingleton().getOKDialog(baseJFrame);
                OKDialog.setPropertyText("basdats_frame_msg21");
                OKDialog.show();
                return;
            }
            
            final FileChooserUtility FileChooserUtility = UtilitiesFactory.getSingleton().getFileChooserUtility();
            FileChooserUtility.setPropertyTitle("basdats_frame_msg10");
            FileChooserUtility.setIApproveOpption((String absolutePath, String fileName) -> {
                
                try{
                    
                    final String backupDBPath = absolutePath + "\\" + fileName;

                    final HibernateConfigModel HibernateConfigModel = HibernateConfigUtil.getInstance().getHibernateConfigFile();

                    final BasDats BasDats = (BasDats) jTabEmpresas.getRowSelected();
                    
                    //Backup database
                    final boolean success = MysqlScriptsUtil.getInstance().backupDatabase(HibernateConfigModel.getUser(), HibernateConfigModel.getPassword(), HibernateConfigModel.getInstance(), HibernateConfigModel.getPort(), BasDats.getBd(), backupDBPath);
                    final OKDialog OKDialog = DialogsFactory.getSingleton().getOKDialog(baseJFrame);
                    if(success){                        
                        OKDialog.setPropertyText("basdats_frame_msg11");                        
                    }
                    else{                        
                        OKDialog.setPropertyText("basdats_frame_msg12");                        
                    }
                    OKDialog.show();
                    
                }catch(Exception ex){
            
                    try {

                        LoggerUtility.getSingleton().logError(EmpresasViewController.class, ex);

                        DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();

                    } catch (Exception ex1) {
                        Logger.getLogger(EmpresasViewController.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                }
            });
            FileChooserUtility.showSaveDialog(baseJFrame);
            
        }catch(Exception ex){
            
            try {
                
                LoggerUtility.getSingleton().logError(EmpresasViewController.class, ex);
                
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
                
            } catch (Exception ex1) {
                Logger.getLogger(EmpresasViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    
    private void buttonImportBackupClicked(ActionEvent e){
            
        try{
            
            //No row selecion
            if(jTabEmpresas.getSelectedRow()==-1){
                final OKDialog OKDialog = DialogsFactory.getSingleton().getOKDialog(baseJFrame);
                OKDialog.setPropertyText("basdats_frame_msg22");
                OKDialog.show();
                return;
            }
            
            final FileChooserUtility FileChooserUtility = UtilitiesFactory.getSingleton().getFileChooserUtility();
            FileChooserUtility.setPropertyTitle("question_continue");
            FileChooserUtility.setIApproveOpption((String absolutePath, String fileName) -> {
                
                try{
                    
                    final String backupRestoreDBPath = absolutePath + "\\" + fileName;

                    final HibernateConfigModel HibernateConfigModel = HibernateConfigUtil.getInstance().getHibernateConfigFile();

                    final BasDats BasDats = (BasDats) jTabEmpresas.getRowSelected();
                    
                    //Backup database
                    final boolean success = MysqlScriptsUtil.getInstance().importBackupDatabase(HibernateConfigModel.getUser(), HibernateConfigModel.getPassword(), HibernateConfigModel.getInstance(), HibernateConfigModel.getPort(), BasDats.getBd(), backupRestoreDBPath);
                    final OKDialog OKDialog = DialogsFactory.getSingleton().getOKDialog(baseJFrame);
                    if(success){                        
                        OKDialog.setPropertyText("basdats_frame_msg23");                        
                    }
                    else{                        
                        OKDialog.setPropertyText("basdats_frame_msg24");                        
                    }
                    OKDialog.show();
                    
                }catch(Exception ex){
            
                    try {

                        LoggerUtility.getSingleton().logError(EmpresasViewController.class, ex);

                        DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();

                    } catch (Exception ex1) {
                        Logger.getLogger(EmpresasViewController.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                }
            });
            FileChooserUtility.showSaveDialog(baseJFrame);
            
        }catch(Exception ex){
            
            try {
                
                LoggerUtility.getSingleton().logError(EmpresasViewController.class, ex);
                
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
                
            } catch (Exception ex1) {
                Logger.getLogger(EmpresasViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    
    private void buttonCertificatePathClicked(ActionEvent e){
        
        try{
            
            final FileChooserUtility FileChooserUtility = UtilitiesFactory.getSingleton().getFileChooserUtility();
            FileChooserUtility.setPropertyTitle("fc_titles_search_cert");
            FileChooserUtility.setIApproveOpption((String absolutePath, String fileName) -> {
                
                try{
                    
                    if(!fileName.endsWith(".key")){
                        final OKDialog OKDialog = DialogsFactory.getSingleton().getOKDialog(baseJFrame);
                        OKDialog.setPropertyText("basdats_frame_msg17");
                        OKDialog.show();
                        return;
                    }
                    
                    //Save the path and add the path to the path
                    certificatePath = absolutePath + "\\" + fileName;
                    JTRutaCertificado.setText(certificatePath);
                    
                }catch(Exception ex){
            
                    try {

                        LoggerUtility.getSingleton().logError(EmpresasViewController.class, ex);

                        DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();

                    } catch (Exception ex1) {
                        Logger.getLogger(EmpresasViewController.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                }
            });
            FileChooserUtility.showSaveDialog(baseJFrame);
            
        }catch(Exception ex){
            
            try {
                
                LoggerUtility.getSingleton().logError(EmpresasViewController.class, ex);
                
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
                
            } catch (Exception ex1) {
                Logger.getLogger(EmpresasViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    private void buttonCertificateKeyPathClicked(ActionEvent e){
        
        try{
            
            final FileChooserUtility FileChooserUtility = UtilitiesFactory.getSingleton().getFileChooserUtility();
            FileChooserUtility.setPropertyTitle("fc_titles_search_certkey");
            FileChooserUtility.setIApproveOpption((String absolutePath, String fileName) -> {
                
                try{
                    
                    if(!fileName.endsWith(".cer")){
                        final OKDialog OKDialog = DialogsFactory.getSingleton().getOKDialog(baseJFrame);
                        OKDialog.setPropertyText("basdats_frame_msg16");
                        OKDialog.show();
                        return;
                    }
                    
                    //Save the path and add the path to the path
                    certificateKeyPath = absolutePath + "\\" + fileName;
                    JTRutaKey.setText(certificateKeyPath);
                    
                }catch(Exception ex){
            
                    try {

                        LoggerUtility.getSingleton().logError(EmpresasViewController.class, ex);

                        DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();

                    } catch (Exception ex1) {
                        Logger.getLogger(EmpresasViewController.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                }
            });
            FileChooserUtility.showSaveDialog(baseJFrame);
            
        }catch(Exception ex){
            
            try {
                
                LoggerUtility.getSingleton().logError(EmpresasViewController.class, ex);
                
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
                
            } catch (Exception ex1) {
                Logger.getLogger(EmpresasViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    private void buttonPlantillaPathClicked(ActionEvent e){
        
        try{
            
            final FileChooserUtility FileChooserUtility = UtilitiesFactory.getSingleton().getFileChooserUtility();
            FileChooserUtility.setPropertyTitle("fc_titles_search_template");
            FileChooserUtility.setIApproveOpption((String absolutePath, String fileName) -> {
                
                try{
                    
                    //Save the path and add the path to the path
                    templatePath = absolutePath + "\\" + fileName;
                    JTPlantilla.setText(templatePath);
                    
                }catch(Exception ex){
            
                    try {

                        LoggerUtility.getSingleton().logError(EmpresasViewController.class, ex);

                        DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();

                    } catch (Exception ex1) {
                        Logger.getLogger(EmpresasViewController.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                }
            });
            FileChooserUtility.showSaveDialog(baseJFrame);
            
        }catch(Exception ex){
            
            try {
                
                LoggerUtility.getSingleton().logError(EmpresasViewController.class, ex);
                
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
                
            } catch (Exception ex1) {
                Logger.getLogger(EmpresasViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    private void buttonAppPathClicked(ActionEvent e){
        
        try{
            
            final FileChooserUtility FileChooserUtility = UtilitiesFactory.getSingleton().getFileChooserUtility();
            FileChooserUtility.setPropertyTitle("fc_titles_search_apppath");
            FileChooserUtility.setIApproveOpption((String absolutePath, String fileName) -> {
                
                try{
                    
                    //Save the path and add the path to the path
                    appPath = absolutePath + "\\" + fileName;
                    JTRutaAplicacion.setText(appPath);
                    
                }catch(Exception ex){
            
                    try {

                        LoggerUtility.getSingleton().logError(EmpresasViewController.class, ex);

                        DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();

                    } catch (Exception ex1) {
                        Logger.getLogger(EmpresasViewController.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                }
            });
            FileChooserUtility.showSaveDialog(baseJFrame);
            
        }catch(Exception ex){
            
            try {
                
                LoggerUtility.getSingleton().logError(EmpresasViewController.class, ex);
                
                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();
                
            } catch (Exception ex1) {
                Logger.getLogger(EmpresasViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    public boolean validateCertificate() throws Exception{
        
        /*Si no hay archivo escrito entonces*/
        if(this.certificatePath.isEmpty()){

            final OKDialog OKDialog = DialogsFactory.getSingleton().getOKDialog(baseJFrame);
            OKDialog.setPropertyText("basdats_frame_msg1");
            return false;
        }

        /*Si no hay archivo key escrito entonces*/
        if(this.certificateKeyPath.isEmpty())
        {
            final OKDialog OKDialog = DialogsFactory.getSingleton().getOKDialog(baseJFrame);
            OKDialog.setPropertyText("basdats_frame_msg4");
            return false;
        }
        
        /*Si no hay contraseña escrito entonces*/
        if(JTPasswordCertificado.getText().isEmpty())
        {
            final OKDialog OKDialog = DialogsFactory.getSingleton().getOKDialog(baseJFrame);
            OKDialog.setPropertyText("basdats_frame_msg7");
            return false;
        }
        
        /*Si no existe el archivo cer entonces*/            
        if(!UtilitiesFactory.getSingleton().getFilesUtility().fileExists(this.appPath))
        {
            final OKDialog OKDialog = DialogsFactory.getSingleton().getOKDialog(baseJFrame);
            OKDialog.setPropertyText("basdats_frame_msg2");
            return false;
        }

        /*Si el archivo no termina en cer entonces*/
        if(!this.certificatePath.trim().toLowerCase().endsWith(".cer"))
        {
            final OKDialog OKDialog = DialogsFactory.getSingleton().getOKDialog(baseJFrame);
            OKDialog.setPropertyText("basdats_frame_msg3");
            return false;
        }        

        /*Si no existe el archivo key entonces*/
        if(!UtilitiesFactory.getSingleton().getFilesUtility().fileExists(this.certificateKeyPath))
        {
            final OKDialog OKDialog = DialogsFactory.getSingleton().getOKDialog(baseJFrame);
            OKDialog.setPropertyText("basdats_frame_msg5");
            return false;
        }

        /*Si el archivo no termina en key entonces*/
        if(!certificateKeyPath.trim().toLowerCase().endsWith(".key"))
        {
            final OKDialog OKDialog = DialogsFactory.getSingleton().getOKDialog(baseJFrame);
            OKDialog.setPropertyText("basdats_frame_msg6");
            return false;
        }

        final String certificatePassword = JTPasswordCertificado.getText().trim();

        //Vaidate the certificate
        final boolean validCertificate = UtilitiesFactory.getSingleton().getCertificatesUtility().validateCertificate(certificatePath, certificateKeyPath, certificatePassword);
        if(!validCertificate){

            final OKDialog OKDialog = DialogsFactory.getSingleton().getOKDialog(baseJFrame);
            OKDialog.setPropertyText("basdats_frame_msg8");
            return false;
        }
        
        return true;
    }
    
    private boolean validateRequiredFields() throws Exception{
            
        boolean val = true;
        if (JTEmpresa.getText().equals("")){
            val = false;
        }        
        else if (JTBaseDeDatos.getText().equals("")){
            val = false;
        }        
        else if (JTRFC.getText().equals("")){
            val = false;
        }        
        else if (JTCalle.getText().equals("")){
            val = false;
        }        
        else if (JTNoExt.getText().equals("")){
            val = false;
        }        
        else if (JTColonia.getText().equals("")){
            val = false;
        }        
        else if (JTCiudad.getText().equals("")){
            val = false;
        }                
        else if (JTEstado.getText().equals("")){
            val = false;
        }        
        else if (JTCP.getText().equals("")){
            val = false;
        }        
        else if (JTPais.getText().equals("")){
            val = false;
        }
        
        return val;
    }
    
    public void clearFields() throws Exception {
        
        JTIdEmpresa.setText("");
        JTCodigoEmpresa.setText(UtilitiesFactory.getSingleton().getGeneralsUtility().getUniqueDayCode());
        JTEmpresa.setText("");
        JTBaseDeDatos.setText("");
        JTTelefono.setText("");
        JTExtTel.setText("");
        JTCalle.setText("");
        JTCP.setText("");
        JTNoExt.setText("");
        JTNoInt.setText("");
        JTColonia.setText("");
        JTCiudad.setText("");
        JTEstado.setText("");
        JTPais.setText("");
        JTRFC.setText("");
        JTCorreoElectronico.setText("");
        JTSucursal.setText("");
        JTCaja.setText("");
        JTSitioWeb.setText("");
        JTEstacion.setText("");
        JTLugarDeExpedicion.setText("");
        JTRegimenFiscal.setText("");
        JTRutaCertificado.setText("");
        JTRutaKey.setText("");
        JTPasswordCertificado.setText("");
        JTRutaAplicacion.setText("");
        JTPlantilla.setText("");                
        
        if(jTabEmpresas.isTableInitialized()){
            jTabEmpresas.clearRows();
        }
        
        /*Selecciona el método de costeo que sea de la empresa*/
        bgMetodoCosteo.setSelected(JRBPEPS.getModel(), true);
        bgMetodoCosteo.setSelected(JRBUEPS.getModel(), false);
        bgMetodoCosteo.setSelected(JRBUltCost.getModel(), false);
        bgMetodoCosteo.setSelected(JRBPromedio.getModel(), false);
        
        bgTipoContribuyente.setSelected(JRBMoral.getModel(), true);
        bgTipoContribuyente.setSelected(JRBFisica.getModel(), false);
        
        jLImg.setIcon(null);
        jLImg.setVisible(false);
        
        //Reload table
        this.loadCompanies();
    }
    
    public final void loadCompanies() throws Exception {
        
        final List<BasDats> companies = (List<BasDats>) RepositoryFactory.getInstance().getBasDatsRepository().getAll();        
        jTabEmpresas.initTable(companies);        
    }
    
    public final synchronized void vCargaComponentes(BasDats Company)
    {
        JTIdEmpresa.setText(String.valueOf(Company.getId()));
        JTCodigoEmpresa.setText(Company.getCodemp());
        JTEmpresa.setText(Company.getNom());
        JTBaseDeDatos.setText(Company.getBd());
        JTTelefono.setText(Company.getTel());
        JTExtTel.setText("");
        JTCalle.setText(Company.getCalle());
        JTCP.setText(Company.getCP());
        JTNoExt.setText(Company.getNoext());
        JTNoInt.setText(Company.getNoint());
        JTColonia.setText(Company.getCol());
        JTCiudad.setText(Company.getCiu());
        JTEstado.setText(Company.getEstad());
        JTPais.setText(Company.getPai());
        JTRFC.setText(Company.getRFC());
        JTCorreoElectronico.setText(Company.getCorr());
        JTSucursal.setText(Company.getSucu());
        JTCaja.setText(Company.getNocaj());
        JTSitioWeb.setText(Company.getPagweb());
        JTEstacion.setText(Company.getEstac());
        JTLugarDeExpedicion.setText(Company.getLugexp());
        JTRegimenFiscal.setText(Company.getRegfisc());
        JTRutaCertificado.setText(Company.getRutcer());
        JTRutaKey.setText(Company.getRutkey());
        JTPasswordCertificado.setText(Company.getPasscer());
        JTRutaAplicacion.setText(Company.getRutap());
        JTPlantilla.setText("");
        
        UtilitiesFactory.getSingleton().getPathsUtility().initPaths(null, Company.getCodemp());
                
        //Load icon
        String companyLogoPath = UtilitiesFactory.getSingleton().getPathsUtility().getCompanyLogoPath();
        companyLogoPath += "\\" + UtilitiesFactory.getSingleton().getPathsUtility().getLogoFileName();
        if(UtilitiesFactory.getSingleton().getFilesUtility().fileExists(companyLogoPath)){
            jLImg.setIcon(new ImageIcon(companyLogoPath));
            jLImg.setVisible(true);
        }        
        
        /*Selecciona el método de costeo que sea de la empresa*/
        switch (Company.getMetcost()) {
            case "metcost":
                bgMetodoCosteo.setSelected(JRBPEPS.getModel(), true);
                break;
            case "ueps":
                bgMetodoCosteo.setSelected(JRBUEPS.getModel(), true);
                break;
            case "ultcost":
                bgMetodoCosteo.setSelected(JRBUltCost.getModel(), true);
                break;
            case "prom":
                bgMetodoCosteo.setSelected(JRBPromedio.getModel(), true);
                break;
        }
        
        final String regimenFiscal = Company.getRegfisc()==null?"F":Company.getRegfisc();
        switch (regimenFiscal) {
            case "M":
                bgTipoContribuyente.setSelected(JRBMoral.getModel(), true);
                break;        
            case "F":
                bgTipoContribuyente.setSelected(JRBFisica.getModel(), true);
                break;
        }
    }
}
