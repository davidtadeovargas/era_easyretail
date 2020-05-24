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
import com.era.models.License;
import com.era.models.ServerSession;
import com.era.repositories.utils.HibernateUtil;
import com.era.repositories.utils.MysqlScriptsUtil;
import com.era.utilities.UtilitiesFactory;
import com.era.utilities.WinRegistry;
import com.era.views.ViewsFactory;
import com.era.views.dialogs.DialogsFactory;
import java.awt.event.ActionEvent;

//Initialization of the system
public class Start {
 
    private static HibernateConfigModel HibernateConfigModel;    
    
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
                DialogsFactory.getSingleton().getErrorDialogByTextJFrame(e.getMessage(), (ActionEvent evt) -> {                    
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
        HibernateConfigModel = new HibernateConfigModel();
        HibernateConfigModel.setUser(user);
        HibernateConfigModel.setPassword(password);
        HibernateConfigModel.setPort(Integer.valueOf(port));
        HibernateConfigModel.setInstance(instance);
        HibernateConfigModel.setDatabase(db);
        HibernateUtil.getSingleton().setHibernateConfigModelDbEmpresas(HibernateConfigModel);

        //Check if the main database exists
        boolean result = MysqlScriptsUtil.getInstance().existsDBEmpresasDatabase(HibernateConfigModel.getUser(), HibernateConfigModel.getPassword(), HibernateConfigModel.getInstance(), HibernateConfigModel.getPort());                
        
        UtilitiesFactory.getSingleton().getImagesUtility().init(System.getProperty("user.dir"));
                
        //Init the UtilityManager with the current app path
        UtilitiesFactory.getSingleton().getImagesUtility().init(System.getProperty("user.dir"));
        
        if(!result) {//Else database not exists                
            dbempresasNotExists();
        }
        else {  //The dabatase already exists 
            veryLicense();
        }
    }
    
            
    private static void dbempresasNotExists(){
        
        //Run database creation in another thread
        new Thread(() -> {
            
            try {
                        
                MysqlScriptsUtil.getInstance().creaDBEmpresas(HibernateConfigModel.getUser(), HibernateConfigModel.getPassword(), HibernateConfigModel.getInstance(), HibernateConfigModel.getPort());
                
                //Create schemes for dbempresas
                HibernateUtil.getSingleton().buildSessionFactoryFordbempresasCreate(HibernateConfigModel);
                
                veryLicense();
            
            } catch (Exception ex) {
                LoggerUtility.getSingleton().logError(Start.class, ex);

                try {
                    //Rollback
                    MysqlScriptsUtil.getInstance().rollbackDBEmpresas(HibernateConfigModel.getUser(), HibernateConfigModel.getPassword(), HibernateConfigModel.getInstance(), HibernateConfigModel.getPort());
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
        
        License License = RepositoryFactory.getInstance().getLicenseRepository().getLicense();

        if(License==null){

            LoggerUtility.getSingleton().logInfo(Start.class, "Licenciamiento: No existe información de licenciamiento");

            LoggerUtility.getSingleton().logInfo(Start.class, "Licenciamiento: Mostrando pantalla de login de licenciamiento");

            //Show the license login form to create again all the license info
            final LoginLocalViewController LoginLocalViewController = new LoginLocalViewController();                    
            LoginLocalViewController.setVisible(true);
        }
        else{
            getLicenseInformationFromServer();
        }
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
                    DialogsFactory.getSingleton().getErrorDialogByIdTextJFrame("errors_failed_connection_to_ws", (ActionEvent evt) -> {                    
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
                License License1 = RepositoryFactory.getInstance().getLicenseRepository().getLicense();
                License1.setChannel(ComputerLicenseDataModel.getChannel());
                License1.setRemainingDays(ComputerLicenseDataModel.getRemainingDays());
                RepositoryFactory.getInstance().getLicenseRepository().addLicense(License1);
                final ServerSession ServerSession = new ServerSession();
                ServerSession.setGenericSerial(ComputerLicenseDataModel.getGenericSerial());
                RepositoryFactory.getInstance().getServerSessionRepository().addServerSession(ServerSession);
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
