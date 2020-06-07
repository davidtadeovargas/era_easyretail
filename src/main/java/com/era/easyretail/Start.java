/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.easyretail;

import com.era.utilities.ConfigFileUtil;
import com.era.utilities.models.ConfigFileModel;
import com.era.repositories.models.HibernateConfigModel;
import com.era.httpclient.GetComputerStatusHttpClient;
import com.era.repositories.RepositoryFactory;
import com.era.datamodels.ComputerLicenseDataModel;
import com.era.easyretail.controllers.views.DBFileConnectionConfigurationController;
import com.era.easyretail.premium.PremiumFunctionsManager;
import com.era.easyretail.controllers.views.LoginLocalViewController;
import com.era.easyretail.controllers.views.ViewControlersFactory;
import com.era.easyretail.enums.DBFileConnectionConfigurationType;
import com.era.httpclient.subscriber.HttpClientErrorSubscriberInterface;
import com.era.logger.LoggerUtility;
import com.era.models.BasDats;
import com.era.models.License;
import com.era.models.ServerSession;
import com.era.repositories.utils.HibernateUtil;
import com.era.repositories.utils.MysqlScriptsUtil;
import com.era.utilities.UtilitiesFactory;
import com.era.utilities.WinRegistry;
import com.era.views.ViewsFactory;
import com.era.views.dialogs.DialogsFactory;
import com.era.views.dialogs.ErrorDialogJFrame.OnOkButtonActionPerformed;
import java.awt.event.ActionEvent;

//Initialization of the system
public class Start {
 
    public static void main(String[] args) throws Exception {
        
        try{
            
            //If the configuration file does not exists
            if(!ConfigFileUtil.getSingleton().configFileExists()){
                
                //Show the window to create it
                final DBFileConnectionConfigurationController DBFileConnectionConfigurationController = new DBFileConnectionConfigurationController();
                DBFileConnectionConfigurationController.setDBFileConnectionConfigurationType(DBFileConnectionConfigurationType.NEW);
                DBFileConnectionConfigurationController.setOnSave(() -> {
                    try{
                        initSystem();
                    }catch(Exception e){
                        LoggerUtility.getSingleton().logError(Start.class, e);
                    }
                });
                DBFileConnectionConfigurationController.setVisible();
            }
            else{                
                initSystem();
            }
                        
        }catch(Exception e){
            LoggerUtility.getSingleton().logError(Start.class, e);
            
            try{
                    
                //Show the error dialog and exit system when user press ok
                DialogsFactory.getSingleton().showErrorDialogByTextJFrame(e.getMessage(), (ActionEvent evt) -> {                    
                    System.exit(-1);
                });

            }catch(Exception ex){
                LoggerUtility.getSingleton().logError(Start.class, ex);
            }
        }
    }
        
    
    private static void initSystem() throws Exception{
        
        //Get the configuration connection params
        ConfigFileModel ConfigFileModel;
        ConfigFileModel = ConfigFileUtil.getSingleton().getConfigFileModel();

        final String instance = ConfigFileModel.getInstance();
        final String user = ConfigFileModel.getUser();
        final String password = ConfigFileModel.getPassword();
        final String db = ConfigFileModel.getDb();
        final String port = ConfigFileModel.getPort();

        //Save dbempresas params connection to hibernate config file
        final HibernateConfigModel HibernateConfigModel_ = new HibernateConfigModel();
        HibernateConfigModel_.setUser(user);        
        HibernateConfigModel_.setPassword(password);
        HibernateConfigModel_.setPort(Integer.valueOf(port));
        HibernateConfigModel_.setInstance(instance);
        HibernateConfigModel_.setDatabase(db);
        HibernateUtil.getSingleton().setHibernateConfigModelDbEmpresas(HibernateConfigModel_);

        //Check if the main database exists
        boolean result = MysqlScriptsUtil.getInstance().existsDB(HibernateConfigModel_.getDatabase(), HibernateConfigModel_.getUser(), HibernateConfigModel_.getPassword(), HibernateConfigModel_.getInstance(), HibernateConfigModel_.getPort());
        
        //Init the UtilityManager with the current app path
        UtilitiesFactory.getSingleton().getImagesUtility().init(System.getProperty("user.dir"));
            
        
        if(!result) {//Else database not exists                
            dbempresasNotExists();
        }
        else {  //The dabatase already exists 
            
            HibernateUtil.getSingleton().loadDbEmpresas();
            veryLicense();
        }
    }
    
            
    private static void dbempresasNotExists(){
        
        //Run database creation in another thread
        new Thread(() -> {
            
            try {
                
                //Grt the connection params to dbempresas
                final ConfigFileModel ConfigFileModel = ConfigFileUtil.getSingleton().getConfigFileModel();
                
                //Create the jdbc datanase
                MysqlScriptsUtil.getInstance().creaDBJDBC(ConfigFileModel.getDb(), ConfigFileModel.getUser(), ConfigFileModel.getPassword(), ConfigFileModel.getInstance(), Integer.valueOf(ConfigFileModel.getPort()));
                
                //Create hibernate schemes and initial connection for dbempresas
                HibernateUtil.getSingleton().createDbEmpresas();                
                
                //Insert base catalogs in dbempresa
                MysqlScriptsUtil.getInstance().loadDBEmpresasCatalogFileIntoDatabase(ConfigFileModel.getDb(), ConfigFileModel.getUser(), ConfigFileModel.getPassword(), ConfigFileModel.getInstance(), Integer.valueOf(ConfigFileModel.getPort()));
                
                //Continue with the normal system flow
                veryLicense();
            
            } catch (Exception ex) {
                LoggerUtility.getSingleton().logError(Start.class, ex);

                try {
                    //Rollback
                    final HibernateConfigModel HibernateConfigModel_ = HibernateUtil.getSingleton().getHibernateConfigModelDbempresas();
                    MysqlScriptsUtil.getInstance().rollbackDBEmpresas(HibernateConfigModel_.getUser(), HibernateConfigModel_.getPassword(), HibernateConfigModel_.getInstance(), HibernateConfigModel_.getPort());
                    
                } catch (Exception ex1) {
                    LoggerUtility.getSingleton().logError(Start.class, ex1);
                }
                
                ViewsFactory.getSingleton().getDialogJFrame(ex.getMessage()).setVisible();
                
                System.exit(-1);
            }
            
        }).start();
    }
    
    private static void veryLicense() throws Exception {
                
        LoggerUtility.getSingleton().logInfo(Start.class, "Licenciamiento: Obteniendo información de licenciamiento");

        UtilitiesFactory.getSingleton().getSessionUtility().getUser().setCode("INICIAL");
        UtilitiesFactory.getSingleton().getSessionUtility().getUser().setSucu("INICIAL");
        UtilitiesFactory.getSingleton().getSessionUtility().getUser().setEstac("INICIAL");
        
        //Get the db test name
        final BasDats BasDats = RepositoryFactory.getInstance().getBasDatssRepository().getDBTest();
        
        //Check if the dabase test exists really in the database
        boolean testDbExists = false;
        if(BasDats != null){
            
            //Get the test db name
            final String testDbName = BasDats.getBd();
            
            //Ghet the hibernate config file
            final HibernateConfigModel HibernateConfigModel_ = HibernateUtil.getSingleton().getHibernateConfigModelCurrent();
            
            //Verify that the test dabase exist
            testDbExists = MysqlScriptsUtil.getInstance().existsDB(testDbName, HibernateConfigModel_.getUser(), HibernateConfigModel_.getPassword(), HibernateConfigModel_.getInstance(), HibernateConfigModel_.getPort());
            
            if(!testDbExists){
                DialogsFactory.getSingleton().showErrorDialogByIdTextJFrame("errors_dbtest_not_exists_sintax", (ActionEvent evt) -> {
                    showLoginLocalWindow();
                });
            }
            else{
                validateIfShowLoginOrContinue();
            }
        }
        else{
            validateIfShowLoginOrContinue();
        }
    }
    
    private static void validateIfShowLoginOrContinue() throws Exception {
        
        License License = RepositoryFactory.getInstance().getLicensesRepository().getLicense();

        if(License.getPassword()==null){
            showLoginLocalWindow();
        }
        else{
            getLicenseInformationFromServer();
        }
    }
    
    private static void showLoginLocalWindow(){
        
        LoggerUtility.getSingleton().logInfo(Start.class, "Licenciamiento: No existe información de licenciamiento");

        LoggerUtility.getSingleton().logInfo(Start.class, "Licenciamiento: Mostrando pantalla de login de licenciamiento");

        //Show the license login form to create again all the license info
        final LoginLocalViewController LoginLocalViewController = new LoginLocalViewController();                    
        LoginLocalViewController.setVisible(true);
    }
    
    private static void getLicenseInformationFromServer() throws Exception {
                                
        LoggerUtility.getSingleton().logInfo(Start.class, "Licenciamiento: Obteniendo información de licenciamiento del servidor");

        LoggerUtility.getSingleton().logInfo(Start.class, "Licenciamiento: Obteniendo información con el servidor de licenciamiento del computador");

        //Get information about the license from the server
        final GetComputerStatusHttpClient GetComputerStatusHttpClient = new GetComputerStatusHttpClient();        
        GetComputerStatusHttpClient.getBaseHttpClientManager().setHttpClientErrorSubscriberInterface(new HttpClientErrorSubscriberInterface() {
            
            @Override
            public void OnException(Exception Exception) {
                
                try{
                    
                    //Show the error dialog and exit system when user press ok
                    DialogsFactory.getSingleton().showErrorDialogByIdTextJFrame("errors_failed_connection_to_ws", (ActionEvent evt) -> {                    
                        System.exit(-1);
                    });

                }catch(Exception e){
                    LoggerUtility.getSingleton().logError(Start.class, e);
                }
            }

            @Override
            public void OnUnknownError() {             
            }
        });
        GetComputerStatusHttpClient.setGetComputerStatusSubscriberInteface((ComputerLicenseDataModel ComputerLicenseDataModel) -> {

            LoggerUtility.getSingleton().logInfo(Start.class, "Licenciamiento: El servidor devolvio información de licenciamiento");
            
            //Get the serie
            final boolean serieExists = ComputerLicenseDataModel.getSerie()!=null;
            final String serie = serieExists ? ComputerLicenseDataModel.getSerie():"";
            try{

                //Validate if create or update the user license
                final boolean winregExists = WinRegistry.existsUserLicenseRegistry();
                if(!winregExists){

                    LoggerUtility.getSingleton().logInfo(Start.class, "Licenciamiento: No existen valores para la serie en el registro de windows");

                    WinRegistry.addUserLicense(serie);

                    LoggerUtility.getSingleton().logInfo(Start.class, "Licenciamiento: Se crearon nuevos valores para la serie en el registro de windows");
                }
                else{

                    LoggerUtility.getSingleton().logInfo(Start.class, "Licenciamiento: Si existen valores para la serie en el registro de windows");

                    WinRegistry.updateUserLicense(serie);

                    LoggerUtility.getSingleton().logInfo(Start.class, "Licenciamiento: Se actualizo la serie en el registro de windows");
                }

                //Save premium functions
                PremiumFunctionsManager.getSingleton().setPremiumFuntionsDataModel(ComputerLicenseDataModel.getPremiumFuntionsDataModel());

                LoggerUtility.getSingleton().logInfo(Start.class, "Licenciamiento: Updating channel " + ComputerLicenseDataModel.getChannel());
                License License1 = RepositoryFactory.getInstance().getLicensesRepository().getLicense();
                License1.setChannel(ComputerLicenseDataModel.getChannel());
                License1.setRemainingDays(ComputerLicenseDataModel.getRemainingDays());
                RepositoryFactory.getInstance().getLicensesRepository().addLicense(License1);
                final ServerSession ServerSession = new ServerSession();
                ServerSession.setCode(ComputerLicenseDataModel.getGenericSerial());
                RepositoryFactory.getInstance().getServerSessionsRepository().addServerSession(ServerSession);
                LoggerUtility.getSingleton().logInfo(Start.class, "Licenciamiento: Channel updated " + ComputerLicenseDataModel.getChannel());

                LoggerUtility.getSingleton().logInfo(Start.class, "Licenciamiento: Is premium: " + ComputerLicenseDataModel.getPremiumFuntionsDataModel().isPremium());
                LoggerUtility.getSingleton().logInfo(Start.class, "Licenciamiento: sendToOnlyOneDestinataryInFact: " + ComputerLicenseDataModel.getPremiumFuntionsDataModel().isSendToOnlyOneDestinataryInFact());
                LoggerUtility.getSingleton().logInfo(Start.class, "Licenciamiento: onlyUseIVATax: " + ComputerLicenseDataModel.getPremiumFuntionsDataModel().isOnlyUseIVATax());
                LoggerUtility.getSingleton().logInfo(Start.class, "Licenciamiento: onlyOneSerieForDocument: " + ComputerLicenseDataModel.getPremiumFuntionsDataModel().isOnlyOneSerieForDocument());
                LoggerUtility.getSingleton().logInfo(Start.class, "Licenciamiento: disableInvoiceTicketsWindow: " + ComputerLicenseDataModel.getPremiumFuntionsDataModel().isDisableInvoiceTicketsWindow());
                LoggerUtility.getSingleton().logInfo(Start.class, "Licenciamiento: Mostrando la pantalla de presentación del sistema");

                //Init the working direcory
                final String currentWorkingDir = System.getProperty("user.dir");
                UtilitiesFactory.getSingleton().getPathsUtility().initPaths(currentWorkingDir, "");
                
                //Continue with the presentation screen
                ViewControlersFactory.getSingleton().getPresentationController().setVisible();
                
            }catch(Exception e){
                LoggerUtility.getSingleton().logError(Start.class, e);
            }
        });
        GetComputerStatusHttpClient.execute();
    }
}
