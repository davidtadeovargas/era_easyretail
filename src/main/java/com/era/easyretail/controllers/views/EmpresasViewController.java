/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.easyretail.controllers.views;

import com.era.datamodels.CertificatesDataModel;
import com.era.datamodels.enums.SearchCommonTypeEnum;
import com.era.easyretail.premium.BasePremiumImpl;
import com.era.easyretail.swingworkers.BaseSwingWorker;
import com.era.easyretail.swingworkers.ISwingWorkerActions;
import com.era.logger.LoggerUtility;
import com.era.models.BasDats;
import com.era.models.CCodigopostal;
import com.era.models.CCountry;
import com.era.models.CRegimenfiscal;
import com.era.repositories.RepositoryFactory;
import com.era.repositories.models.HibernateConfigModel;
import com.era.repositories.utils.HibernateConfigUtil;
import com.era.repositories.utils.HibernateUtil;
import com.era.repositories.utils.MysqlScriptsUtil;
import com.era.utilities.FileChooserUtility;
import com.era.utilities.PathsUtility;
import com.era.utilities.UtilitiesFactory;
import com.era.views.EmpresasJFrame;
import com.era.views.dialogs.DialogsFactory;
import com.era.views.dialogs.ErrorOKDialog;
import com.era.views.dialogs.OKDialog;
import com.era.views.dialogs.QuestionDialog;
import com.era.views.tables.headers.TableHeaderFactory;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.util.List;
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
    private String templatePath;    
    private String logoPath;
    private boolean certificateCer;
    private boolean certificateKey;
    
    
    
    public EmpresasViewController() {
        
        super("window_title_emps");
        
        try{                        

            this.setPropertyTitle("companies_title");                

            //Validate the premium functionality for the button color
            final BasePremiumImpl BasePremiumImpl_ = BasePremiumImpl.getSingleton();
            BasePremiumImpl_.setINotPremium(() -> {
                BasePremiumImpl_.paintButton(BTNNuevaEmpresa); //Paint the button to desired premium                        
            });
            BasePremiumImpl_.validate();

            JTCodigoEmpresa.setText(UtilitiesFactory.getSingleton().getGeneralsUtility().getUniqueDayCode());

            this.BaseJTable = jTabEmpresas;
            this.BaseJTable.addShowColumn(TableHeaderFactory.getSigleton().getBasDatssTableHeader().getROWNUMBER());
            this.BaseJTable.addShowColumn(TableHeaderFactory.getSigleton().getBasDatssTableHeader().getCODEMP());
            this.BaseJTable.addShowColumn(TableHeaderFactory.getSigleton().getBasDatssTableHeader().getNOM());
            this.BaseJTable.addShowColumn(TableHeaderFactory.getSigleton().getBasDatssTableHeader().getBD());
            this.BaseJTable.addShowColumn(TableHeaderFactory.getSigleton().getBasDatssTableHeader().getCALLE()); 
            this.BaseJTable.addShowColumn(TableHeaderFactory.getSigleton().getBasDatssTableHeader().getNOEXT());
            this.BaseJTable.addShowColumn(TableHeaderFactory.getSigleton().getBasDatssTableHeader().getNOINT());
            this.BaseJTable.addShowColumn(TableHeaderFactory.getSigleton().getBasDatssTableHeader().getCIU());
            this.BaseJTable.addShowColumn(TableHeaderFactory.getSigleton().getBasDatssTableHeader().getPAI());
            this.BaseJTable.addShowColumn(TableHeaderFactory.getSigleton().getBasDatssTableHeader().getCP());            
            this.BaseJTable.addShowColumn(TableHeaderFactory.getSigleton().getBasDatssTableHeader().getCORR());
            this.BaseJTable.addShowColumn(TableHeaderFactory.getSigleton().getBasDatssTableHeader().getRFC());            
            this.BaseJTable.loadAllItemsInTable();

            JTCodigoEmpresa.setEditable(false);

            JComponentUtils.addFocusLost(JTBaseDeDatos, (FocusEvent e) -> {
                final String newString = JTBaseDeDatos.getText().trim().replace(" ", "");
                JTBaseDeDatos.setText(newString);
            });

            BTNActualiza.setEnabled(false);

            jTabEmpresas.setITableRowSelected((ListSelectionEvent lse, Object Object) -> {

                try{

                    //Cast the model
                    Company = (BasDats) Object;
                    
                    if (jTabEmpresas.getSelectedRow() == -1){
                        jTabEmpresas.setRowSelectionInterval(0, 0);
                    }
                    
                    clearFields();

                    Company = (BasDats) jTabEmpresas.getRowSelected();

                    vCargaComponentes(Company);

                    BTNActualiza.setEnabled(true);
                    BTNNuevaEmpresa.setEnabled(false);

                    JTBaseDeDatos.setEditable(false);
                }
                catch(Exception ex){

                    try {

                        LoggerUtility.getSingleton().logError(EmpresasViewController.class, ex);

                        DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();

                    } catch (Exception ex1) {
                        Logger.getLogger(EmpresasViewController.class.getName()).log(Level.SEVERE, null, ex1);
                    }
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
            BTNCargaRegimenFiscal.addActionListener((ActionEvent e) -> {
                buttonSearchFiscalRegimenClicked(e);
            });
            BTNCargaLugarExpedicion.addActionListener((ActionEvent e) -> {
                buttonSearchExpeditionPlaceClicked(e);
            });

            String workingDir = UtilitiesFactory.getSingleton().getFilesUtility().getCurrentWorkingDir();        

            JTRutaAplicacion.setText(workingDir);
            
        }catch(Exception ex){

            try {

                LoggerUtility.getSingleton().logError(EmpresasViewController.class, ex);

                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();

            } catch (Exception ex1) {
                Logger.getLogger(EmpresasViewController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
      
    @Override
    public void loadModelInFields(Object ObjectModel) throws  Exception {        
    }
    
    private void buttonSearchExpeditionPlaceClicked(ActionEvent e){
     
        try{
            
            final SearchViewController SearchViewController = new SearchViewController();
            SearchViewController.setSEARCH_TYPE(SearchCommonTypeEnum.EXPEDITION_PLACE);
            SearchViewController.setButtonAceptClicked(() -> {
                final String fiscalRegimen = SearchViewController.getCod();                
                JTLugarDeExpedicion.setText(fiscalRegimen);
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
    
    private void buttonSearchFiscalRegimenClicked(ActionEvent e){
     
        try{
            
            final SearchViewController SearchViewController = new SearchViewController();
            SearchViewController.setSEARCH_TYPE(SearchCommonTypeEnum.FISCAL_REGIMEN);
            SearchViewController.setButtonAceptClicked(() -> {
                final String fiscalRegimen = SearchViewController.getCod();                
                JTRegimenFiscal.setText(fiscalRegimen);
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
                
                final OKDialog OKDialog = DialogsFactory.getSingleton().getOKDialog(baseJFrame);
                OKDialog.setPropertyText("basdats_frame_msg15");
                OKDialog.show();
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
            
            clearTable();
            
            this.BaseJTable.loadAllItemsInTable();
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
            
            final QuestionDialog QuestionDialog = DialogsFactory.getSingleton().getQuestionDialog(baseJFrame);
            QuestionDialog.setPropertyText("question_continue");
            QuestionDialog.setOKDialogInterface((JFrame jFrame) -> {
                
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
                        return;
                    }                        

                    //Vaildate that the database does not exists
                    final String database = JTBaseDeDatos.getText().trim();
                    final HibernateConfigModel HibernateConfigModel = HibernateUtil.getSingleton().getHibernateConfigModelCurrent();
                    final boolean exists = MysqlScriptsUtil.getInstance().testDatabaseConnection(database, HibernateConfigModel.getUser(), HibernateConfigModel.getPassword(), HibernateConfigModel.getInstance(), HibernateConfigModel.getPort());
                    if(exists){
                        final ErrorOKDialog ErrorOKDialog = DialogsFactory.getSingleton().getErrorOKDialog(baseJFrame);
                        ErrorOKDialog.setPropertyText("errors_db_exists");
                        ErrorOKDialog.show();
                        return;
                    }
                    
                    //Save the new company
                    if(!this.addOrUpdateCompany()){                    
                        return;
                    }

                    //Create database and catalogs for the new company
                    final BaseSwingWorker BaseSwingWorker = new BaseSwingWorker();
                    BaseSwingWorker.setShowLoading(baseJFrame);
                    BaseSwingWorker.setISwingWorkerActions(new ISwingWorkerActions(){

                        @Override
                        public void before() {
                        }

                        @Override
                        public Object doinbackground(){

                            try{
                                
                                //Create new database, populate schemes and load initial catalogs
                                HibernateUtil.getSingleton().createNewLocalDatabase(Company.getBd());
                                
                                return null;

                            }catch(Exception ex){

                                try {

                                    LoggerUtility.getSingleton().logError(EmpresasViewController.class, ex);

                                } catch (Exception ex1) {
                                    Logger.getLogger(EmpresasViewController.class.getName()).log(Level.SEVERE, null, ex1);
                                }

                                return ex;
                            }
                        }

                        @Override
                        public void after(Object Object) {

                            try{

                                //No error
                                if(Object==null){

                                    //Reload table
                                    BaseJTable.loadAllItemsInTable();

                                    //Show success dialog
                                    final OKDialog OKDialog = DialogsFactory.getSingleton().getOKDialog(baseJFrame);
                                    OKDialog.setPropertyText("basdats_frame_msg14");
                                    OKDialog.show();

                                }
                                else{

                                    final Exception Exception = (Exception) Object;
                                    try {

                                        LoggerUtility.getSingleton().logError(EmpresasViewController.class, Exception);

                                        DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, Exception).show();

                                    } catch (Exception ex1) {
                                        Logger.getLogger(EmpresasViewController.class.getName()).log(Level.SEVERE, null, ex1);
                                    }
                                }

                            }catch(Exception ex){

                                    try {

                                        LoggerUtility.getSingleton().logError(EmpresasViewController.class, ex);

                                    } catch (Exception ex1) {
                                        Logger.getLogger(EmpresasViewController.class.getName()).log(Level.SEVERE, null, ex1);
                                    }
                                }
                            }
                        });
                    BaseSwingWorker.execute();
                    
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
    
    private boolean addOrUpdateCompany() throws Exception {
                
        String MetodoCosteo      = "";
        String TipoContribuyente = "";        

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

        //Validate that the cp exists
        final String cp = JTCP.getText().trim();
        CCodigopostal CCodigopostal = (CCodigopostal) RepositoryFactory.getInstance().getCCodigoPostalRepository().getByPostalCode(cp);
        if(CCodigopostal==null){
                        
            final ErrorOKDialog ErrorOKDialog = DialogsFactory.getSingleton().getErrorOKDialog(baseJFrame);
            ErrorOKDialog.setPropertyText("errors_cp_not_exists");
            ErrorOKDialog.show();
            return false;
        }
        
        //Validate that the country exists
        final String country = JTPais.getText().trim();
        CCountry CCountry = RepositoryFactory.getInstance().getCCountriesRepository().getCountryByCode(country);
        if(CCountry==null){
                        
            final ErrorOKDialog ErrorOKDialog = DialogsFactory.getSingleton().getErrorOKDialog(baseJFrame);
            ErrorOKDialog.setPropertyText("errors_country_not_exists");
            ErrorOKDialog.show();
            return false;
        }
        
        //Validate that the expedition place exists
        final String expeditionPlace = JTLugarDeExpedicion.getText().trim();
        if(!expeditionPlace.isEmpty()){
            
            final boolean exists = RepositoryFactory.getInstance().getCCodigoPostalRepository().existsExpeditionPlace(expeditionPlace);
            if(!exists){
                final ErrorOKDialog ErrorOKDialog = DialogsFactory.getSingleton().getErrorOKDialog(baseJFrame);
                ErrorOKDialog.setPropertyText("errors_expedition_place_not_exists");
                ErrorOKDialog.show();
                return false;
            }
        }
        
        //Validate that the fiscal regimen exists
        final String fiscalRegimen = JTRegimenFiscal.getText().trim();
        CRegimenfiscal CRegimenfiscal;
        if(!fiscalRegimen.isEmpty()){
            
            CRegimenfiscal = RepositoryFactory.getInstance().getCRegimenFiscalRepository().getRegimenByCode(fiscalRegimen);
            if(CRegimenfiscal==null){
                final ErrorOKDialog ErrorOKDialog = DialogsFactory.getSingleton().getErrorOKDialog(baseJFrame);
                ErrorOKDialog.setPropertyText("errors_fiscal_regimen_not_exists");
                ErrorOKDialog.show();
                return false;
            }
        }
        
        /*Si hay archivo en el certificado entonces*/
        CertificatesDataModel CertificatesDataModel = null;
        if(certificateCer)
        {            
            if(!certificateKey){
                final ErrorOKDialog ErrorOKDialog = DialogsFactory.getSingleton().getErrorOKDialog(baseJFrame);
                ErrorOKDialog.setPropertyText("errors_keypath_missing");
                ErrorOKDialog.show();
                return false;
            }
            
            /*Si el certificado es valido entonces mueve el archivo de certificado y llave a la carpeta de la empresa*/
            if(validateCertificate())
            {
                String certificatePath = JTRutaCertificado.getText().trim();                
                String certificateKeyPath = JTRutaKey.getText().trim();                
                String appPath = JTRutaAplicacion.getText().trim();
                String companyCode = JTCodigoEmpresa.getText().trim();                
                        
                CertificatesDataModel = UtilitiesFactory.getSingleton().getCertificatesUtility().copyCertificatesToFoler(companyCode, appPath, certificatePath, certificateKeyPath);                
            }
        } 
        
        final String companyCode = JTCodigoEmpresa.getText().trim();
        
        //If logo to update so
        if(logoPath!=null){
            
            final PathsUtility PathsUtility = UtilitiesFactory.getSingleton().getPathsUtility();
            
            PathsUtility.initPaths(null, companyCode);           
            
            String companyLogoPath = PathsUtility.getCompanyLogoPath();
            final String logoFileName = PathsUtility.getLogoFileName();
            companyLogoPath += "\\" + logoFileName;
            UtilitiesFactory.getSingleton().getFilesUtility().copyFile(logoPath, companyLogoPath);
        }
        
        boolean update = true;
        if(Company==null){
            Company = new BasDats();
            update = false;
        }        
        Company.setNom(JTEmpresa.getText().trim());
        Company.setCodemp(JTCodigoEmpresa.getText());
        Company.setBd(JTBaseDeDatos.getText());
        Company.setMetcost(MetodoCosteo);
        Company.setTel(JTTelefono.getText());
        Company.setNoexten(JTExtTel.getText());
        Company.setCalle(JTCalle.getText());
        Company.setNoext(JTNoExt.getText());
        Company.setNoint(JTNoInt.getText());
        Company.setCol(JTColonia.getText());
        Company.setCiu(JTCiudad.getText());
        Company.setEstad(JTEstado.getText());
        Company.setPai(JTPais.getText());
        Company.setRFC(JTRFC.getText());
        Company.setCorr(JTCorreoElectronico.getText());
        Company.setPagweb(JTSitioWeb.getText());
        Company.setContribuyentType(TipoContribuyente);        
        Company.setLugexp(JTLugarDeExpedicion.getText());
        Company.setRegfisc(fiscalRegimen);
        Company.setRutcer(JTRutaCertificado.getText().replace("\\", "\\\\"));
        Company.setRutkey(JTRutaKey.getText().replace("\\", "\\\\"));
        Company.setPasscer(JTPasswordCertificado.getText());
        Company.setCP(JTCP.getText());
        //Company.setp(JTPlantilla.getText());
        Company.setRutap(JTRutaAplicacion.getText().replace("\\", "\\\\"));
        
        if(CertificatesDataModel!=null){
            Company.setRutcer(CertificatesDataModel.getCertificatePath());
            Company.setRutkey(CertificatesDataModel.getCertificateKeyPath());
        }        
                
        //Update or add the new company
        if(update){
            RepositoryFactory.getInstance().getBasDatssRepository().update(Company);
        }
        else{
            RepositoryFactory.getInstance().getBasDatssRepository().save(Company);
        }

        return true;
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
                    addOrUpdateCompany();
                             
                    jTabEmpresas.clearRows();
                    
                    //Reload table
                    this.BaseJTable.loadAllItemsInTable();
                    
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
                
                final BaseSwingWorker BaseSwingWorker = new BaseSwingWorker();
                BaseSwingWorker.setShowLoading(baseJFrame);
                BaseSwingWorker.setISwingWorkerActions(new ISwingWorkerActions(){
                    @Override
                    public void before() {
                    }

                    @Override
                    public Object doinbackground() {
                        
                        try{

                            final BasDats BasDats = (BasDats) jTabEmpresas.getRowSelected();

                            //Delete company database and record from basdats
                            final HibernateConfigModel HibernateConfigModel = HibernateConfigUtil.getInstance().getHibernateConfigFile();
                            MysqlScriptsUtil.getInstance().deleteDatabase(HibernateConfigModel.getUser(), HibernateConfigModel.getPassword(), HibernateConfigModel.getInstance(), HibernateConfigModel.getPort(), BasDats.getBd());
                            RepositoryFactory.getInstance().getBasDatssRepository().deleteBasDats(BasDats.getCodemp());

                            //Clear all fields
                            clearFields();

                            //Reload table
                            BaseJTable.loadAllItemsInTable();
                            
                            //No errors
                            return null;

                        }catch(Exception ex){

                            //Error
                            return ex;
                        }
                    }

                    @Override
                    public void after(Object Object) {
                        
                        try{
                            
                            //No error
                            if(Object==null){

                                //Reload table
                                BaseJTable.loadAllItemsInTable();

                                //Show success dialog
                                final OKDialog OKDialog = DialogsFactory.getSingleton().getOKDialog(baseJFrame);
                                OKDialog.setPropertyText("company_deleted");
                                OKDialog.show();

                            }
                            else{

                                final Exception Exception = (Exception) Object;
                                try {

                                    LoggerUtility.getSingleton().logError(EmpresasViewController.class, Exception);

                                    DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, Exception).show();

                                } catch (Exception ex1) {
                                    Logger.getLogger(EmpresasViewController.class.getName()).log(Level.SEVERE, null, ex1);
                                }
                            }

                        }catch(Exception ex){
            
                            try {

                                LoggerUtility.getSingleton().logError(EmpresasViewController.class, ex);

                                DialogsFactory.getSingleton().getExceptionDialog(baseJFrame, ex).show();

                            } catch (Exception ex1) {
                                Logger.getLogger(EmpresasViewController.class.getName()).log(Level.SEVERE, null, ex1);
                            }
                        }
                    }
                });
                BaseSwingWorker.execute();
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
                
                if(!fileName.endsWith(".sql")){
                    fileName = fileName + ".sql";
                }
                
                final String backupDBPath = absolutePath + "\\" + fileName;
                
                final BaseSwingWorker BaseSwingWorker = new BaseSwingWorker();
                BaseSwingWorker.setShowLoading(baseJFrame);
                BaseSwingWorker.setISwingWorkerActions(new ISwingWorkerActions(){

                    @Override
                    public void before() {                        
                    }

                    @Override
                    public Object doinbackground() {       
                        
                        try{
                            
                            final HibernateConfigModel HibernateConfigModel = HibernateConfigUtil.getInstance().getHibernateConfigFile();

                            final BasDats BasDats = (BasDats) jTabEmpresas.getRowSelected();

                            //Backup database
                            final boolean success = MysqlScriptsUtil.getInstance().backupDatabase(HibernateConfigModel.getUser(), HibernateConfigModel.getPassword(), HibernateConfigModel.getInstance(), HibernateConfigModel.getPort(), BasDats.getBd(), backupDBPath);

                            if(success){
                                return null;
                            }
                            else{
                                return new Exception("Error en mysql scripts");
                            }
                            
                        }catch(Exception ex){

                            try {

                                LoggerUtility.getSingleton().logError(EmpresasViewController.class, ex);

                            } catch (Exception ex1) {
                                Logger.getLogger(EmpresasViewController.class.getName()).log(Level.SEVERE, null, ex1);
                            }
                            
                            return ex;
                        }
                    }

                    @Override
                    public void after(Object Object) {
                        
                        try{

                            //No error
                            final OKDialog OKDialog = DialogsFactory.getSingleton().getOKDialog(baseJFrame);
                            if(Object==null){ //No error                               
                                OKDialog.setPropertyText("basdats_frame_msg11");
                            }
                            else{
                                OKDialog.setPropertyText("basdats_frame_msg12");
                            }
                            
                            OKDialog.show();

                        }catch(Exception ex){

                            try {

                                LoggerUtility.getSingleton().logError(EmpresasViewController.class, ex);

                            } catch (Exception ex1) {
                                Logger.getLogger(EmpresasViewController.class.getName()).log(Level.SEVERE, null, ex1);
                            }
                        }
                    }
                });
                BaseSwingWorker.execute();
                
                try{                                        

                    
                    
                    
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
                
                final String backupRestoreDBPath = absolutePath + "\\" + fileName;
                
                final BaseSwingWorker BaseSwingWorker = new BaseSwingWorker();
                BaseSwingWorker.setShowLoading(baseJFrame);
                BaseSwingWorker.setISwingWorkerActions(new ISwingWorkerActions(){
                    
                    @Override
                    public void before() {                    
                    }

                    @Override
                    public Object doinbackground() {
                        
                        try{
                            
                            final HibernateConfigModel HibernateConfigModel = HibernateConfigUtil.getInstance().getHibernateConfigFile();

                            final BasDats BasDats = (BasDats) jTabEmpresas.getRowSelected();

                            //Backup database
                            final boolean success = MysqlScriptsUtil.getInstance().importBackupDatabase(HibernateConfigModel.getUser(), HibernateConfigModel.getPassword(), HibernateConfigModel.getInstance(), HibernateConfigModel.getPort(), BasDats.getBd(), backupRestoreDBPath);
                            
                            if(success){
                                return null;
                            }
                            else{
                                return new Exception("Error en mysql scripts");
                            }
                            
                        }catch(Exception ex){
            
                            try {

                                LoggerUtility.getSingleton().logError(EmpresasViewController.class, ex);

                            } catch (Exception ex1) {
                                Logger.getLogger(EmpresasViewController.class.getName()).log(Level.SEVERE, null, ex1);
                            }
                            
                            return ex;
                        }
                    }

                    @Override
                    public void after(Object Object) {
                        
                        try{

                            //No error
                            final OKDialog OKDialog = DialogsFactory.getSingleton().getOKDialog(baseJFrame);
                            if(Object==null){ //No error                               
                                OKDialog.setPropertyText("basdats_frame_msg23");
                            }
                            else{
                                OKDialog.setPropertyText("basdats_frame_msg24");
                            }
                            
                            OKDialog.show();

                        }catch(Exception ex){

                            try {

                                LoggerUtility.getSingleton().logError(EmpresasViewController.class, ex);

                            } catch (Exception ex1) {
                                Logger.getLogger(EmpresasViewController.class.getName()).log(Level.SEVERE, null, ex1);
                            }
                        }
                    }
                });
                BaseSwingWorker.execute();
                
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
                    
                    if(!fileName.endsWith(".cer")){
                        final OKDialog OKDialog = DialogsFactory.getSingleton().getOKDialog(baseJFrame);
                        OKDialog.setPropertyText("basdats_frame_msg16");
                        OKDialog.show();
                        return;
                    }
                    
                    //Save the path and add the path to the path
                    final String certificatePath = absolutePath + "\\" + fileName;
                    JTRutaCertificado.setText(certificatePath);
                    
                    certificateCer = true;
                    
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
                    
                    if(!fileName.endsWith(".key")){
                        final OKDialog OKDialog = DialogsFactory.getSingleton().getOKDialog(baseJFrame);
                        OKDialog.setPropertyText("basdats_frame_msg17");
                        OKDialog.show();
                        return;
                    }
                    
                    //Save the path and add the path to the path
                    final String certificateKeyPath = absolutePath + "\\" + fileName;
                    JTRutaKey.setText(certificateKeyPath);
                    
                    certificateKey = true;
                    
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
                    final String appPath = absolutePath + "\\" + fileName;
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
            FileChooserUtility.showSaveFolderDialog(baseJFrame);
            
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
        if(JTRutaCertificado.getText().trim().isEmpty()){

            final OKDialog OKDialog = DialogsFactory.getSingleton().getOKDialog(baseJFrame);
            OKDialog.setPropertyText("basdats_frame_msg1");
            OKDialog.show();
            return false;
        }

        /*Si no hay archivo key escrito entonces*/
        if(JTRutaKey.getText().trim().isEmpty())
        {
            final OKDialog OKDialog = DialogsFactory.getSingleton().getOKDialog(baseJFrame);
            OKDialog.setPropertyText("basdats_frame_msg4");
            OKDialog.show();
            return false;
        }
        
        /*Si no hay contraseña escrito entonces*/        
        if(JTPasswordCertificado.getText().isEmpty())
        {
            final OKDialog OKDialog = DialogsFactory.getSingleton().getOKDialog(baseJFrame);
            OKDialog.setPropertyText("basdats_frame_msg7");
            OKDialog.show();
            return false;
        }
        
        final String certificatePath = JTRutaCertificado.getText().trim();
        final String keyPath = JTRutaKey.getText().trim();
        
        /*Si no existe el archivo cer entonces*/            
        if(!UtilitiesFactory.getSingleton().getFilesUtility().fileExists(certificatePath))
        {
            final OKDialog OKDialog = DialogsFactory.getSingleton().getOKDialog(baseJFrame);
            OKDialog.setPropertyText("basdats_frame_msg2");
            OKDialog.show();
            return false;
        }

        /*Si el archivo no termina en cer entonces*/
        if(!certificatePath.toLowerCase().endsWith(".cer"))
        {
            final OKDialog OKDialog = DialogsFactory.getSingleton().getOKDialog(baseJFrame);
            OKDialog.setPropertyText("basdats_frame_msg3");
            OKDialog.show();
            return false;
        }        

        /*Si no existe el archivo key entonces*/
        if(!UtilitiesFactory.getSingleton().getFilesUtility().fileExists(keyPath))
        {
            final OKDialog OKDialog = DialogsFactory.getSingleton().getOKDialog(baseJFrame);
            OKDialog.setPropertyText("basdats_frame_msg5");
            OKDialog.show();
            return false;
        }

        /*Si el archivo no termina en key entonces*/
        if(!keyPath.toLowerCase().endsWith(".key"))
        {
            final OKDialog OKDialog = DialogsFactory.getSingleton().getOKDialog(baseJFrame);
            OKDialog.setPropertyText("basdats_frame_msg6");
            OKDialog.show();
            return false;
        }

        final String certificatePassword = JTPasswordCertificado.getText().trim();

        //Vaidate the certificate
        final boolean validCertificate = UtilitiesFactory.getSingleton().getCertificatesUtility().validateCertificate(certificatePath, keyPath, certificatePassword);
        if(!validCertificate){

            final OKDialog OKDialog = DialogsFactory.getSingleton().getOKDialog(baseJFrame);
            OKDialog.setPropertyText("basdats_frame_msg8");
            OKDialog.show();
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
    
    private void clearTable(){
        if(jTabEmpresas.isTableInitialized()){
            jTabEmpresas.clearRows();
        }
    }
    
    @Override
    public void clearFields() {
        
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
        JTSitioWeb.setText("");
        JTLugarDeExpedicion.setText("");
        JTRegimenFiscal.setText("");
        JTRutaCertificado.setText("");
        JTRutaKey.setText("");
        JTPasswordCertificado.setText("");
        JTRutaAplicacion.setText(UtilitiesFactory.getSingleton().getFilesUtility().getCurrentWorkingDir());
        JTPlantilla.setText("");
        
        BTNActualiza.setEnabled(false);
        BTNNuevaEmpresa.setEnabled(true);
        
        JTBaseDeDatos.setEditable(true);
        
        certificateCer = false;
        certificateKey = false;
        
        /*Selecciona el método de costeo que sea de la empresa*/
        bgMetodoCosteo.setSelected(JRBPEPS.getModel(), true);
        bgMetodoCosteo.setSelected(JRBUEPS.getModel(), false);
        bgMetodoCosteo.setSelected(JRBUltCost.getModel(), false);
        bgMetodoCosteo.setSelected(JRBPromedio.getModel(), false);
        
        bgTipoContribuyente.setSelected(JRBMoral.getModel(), true);
        bgTipoContribuyente.setSelected(JRBFisica.getModel(), false);
        
        jLImg.setIcon(null);
        jLImg.setVisible(false);
        
        Company = null;
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
        JTSitioWeb.setText(Company.getPagweb());
        JTLugarDeExpedicion.setText(Company.getLugexp());
        JTRegimenFiscal.setText(Company.getRegfisc());
        
        final String certPath = Company.getRutcer()==null?"":Company.getRutcer().replace("\\\\", "\\");
        final String certKeyPath = Company.getRutkey()==null?"":Company.getRutkey().replace("\\\\", "\\");
        final String appPath = Company.getRutap()==null?UtilitiesFactory.getSingleton().getFilesUtility().getCurrentWorkingDir():Company.getRutkey().replace("\\\\", "\\");
        
        JTRutaCertificado.setText(certPath);
        JTRutaKey.setText(certKeyPath);
        JTPasswordCertificado.setText(Company.getPasscer());
        JTRutaAplicacion.setText(appPath);
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

    @Override
    public List<?> getItemsToLoadInTable() throws Exception {
        final List<BasDats> companies = (List<BasDats>) RepositoryFactory.getInstance().getBasDatssRepository().getAll();        
        return companies;
    }
}
