/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.easyretail.controllers.views;

import com.era.datamodels.ComputerLicenseDataModel;
import com.era.easyretail.premium.PremiumFunctionsManager;
import com.era.models.License;
import com.era.models.ServerSession;
import com.era.httpclient.GetComputerStatusHttpClient;
import com.era.httpclient.LoginLocalHttpClient;
import com.era.httpclient.responses.LoginLocalResponseRequestModel;
import com.era.httpclient.subscriber.LoginSubscriberInterface;
import com.era.logger.LoggerUtility;
import com.era.models.BasDats;
import com.era.models.Company;
import com.era.models.Product;
import com.era.models.Supplier;
import com.era.repositories.RepositoryManager;
import com.era.repositories.models.HibernateConfigModel;
import com.era.repositories.utils.HibernateUtil;
import com.era.repositories.utils.MysqlScriptsUtil;
import com.era.utilities.UtilityManager;
import com.era.utilities.WinRegistry;
import com.era.views.LoginLicenseJFrame;
import com.era.views.dialogs.especifics.EmptyFieldsDialog;
import com.era.views.dialogs.especifics.ExceptionDialog;
import com.era.views.dialogs.especifics.InvalidCredentialsDialog;
import com.era.views.dialogs.especifics.InvalidEmailSintaxDialog;
import com.era.views.exceptions.EmptyFieldsException;
import com.era.views.exceptions.InvalidEmailSintaxException;
import com.era.views.validators.LoginLicenseValidator;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author PC
 */
public class LoginLocalViewController extends LoginLicenseJFrame {
    
    public LoginLocalViewController(){
        
        super();
        
        //Add the fields that when pressing enter inside click in continue button
        final List<JTextField> JTextFields = new ArrayList<>();
        JTextFields.add(jTextFieldUser);
        JTextFields.add(jPasswordFieldPassword);
        JComponentUtils.addJTextFieldsWhenEnterKeyIsPressed(JTextFields,loginButton);
        
        loginButton.addActionListener((ActionEvent e) -> {
            loginButtonClicked();
        });
    }
    
    
    private void loginButtonClicked(){
        
        //Validate all the validator model errors and show messages acordly
        final LoginLicenseValidator LoginLicenseValidator = new LoginLicenseValidator();
        LoginLicenseValidator.setPasswordJPasswordField(jPasswordFieldPassword);
        LoginLicenseValidator.setUserEditJTextField(jTextFieldUser);
        try{
            LoginLicenseValidator.validate();

        }catch(InvalidEmailSintaxException InvalidEmailSintaxException){

            final InvalidEmailSintaxDialog InvalidEmailSintaxDialog = new InvalidEmailSintaxDialog(this);
            InvalidEmailSintaxDialog.show();
            return;
        }
        catch(EmptyFieldsException EmptyFieldsException){

            final EmptyFieldsDialog EmptyFieldsDialog = new EmptyFieldsDialog(this);
            EmptyFieldsDialog.show();
            return;

        } catch (Exception ex) {

            final ExceptionDialog ExceptionDialog = new ExceptionDialog(this,ex);
            ExceptionDialog.show();
            return;
        }

        getInformationFromServer();
    }
    
    private void getInformationFromServer(){
        
        //Show loading screen while database creation
        RenderControlersViewManager.getSingleton().getCreatingDatabaseWaitViewController().setVisible(true);

        jPasswordFieldPassword.setEditable(false);
        jTextFieldUser.setEditable(false);
        loginButton.setEnabled(false);

        //Run database creation in another thread
        new Thread(() -> {

            try {

                getInfoFromServer();

            } catch (Exception ex) {

                LoggerUtility.getSingleton().logError(LoginLocalViewController.class, ex);
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Campo vacio", JOptionPane.INFORMATION_MESSAGE);

            }finally{

                //Close the loading screen database
                RenderControlersViewManager.getSingleton().getCreatingDatabaseWaitViewController().dispose();

                jPasswordFieldPassword.setEditable(true);
                jTextFieldUser.setEditable(true);
                loginButton.setEnabled(true);
            }
        }).start();
    }
    
    private void getInfoFromServer() throws Exception {
                            
        LoggerUtility.getSingleton().logInfo(LoginLicenseJFrame.class, "Licenciamiento: Validando con el servicio web si las credenciales de login de licenciamiento son correctas");

        //Get variables
        final String user = jTextFieldUser.getText().trim();
        final String password = String.valueOf(jPasswordFieldPassword.getPassword());

        //Check with the web service the license information for this user computer
        final LoginLocalHttpClient LoginLocalHttpClient = new LoginLocalHttpClient();
        LoginLocalHttpClient.setUser(user);
        LoginLocalHttpClient.setPassword(password);
        LoginLocalHttpClient.setLoginSubscriberInterface(new LoginSubscriberInterface() {

            @Override
            public void OnLoginCorrect(LoginLocalResponseRequestModel LoginLocalResponseRequestModel) {
                
                try{

                    getComputerInformationWithServer(LoginLocalResponseRequestModel,user,password);        

                }catch(Exception e){

                    LoggerUtility.getSingleton().logError(LoginLicenseJFrame.class, e);

                    final ExceptionDialog ExceptionDialog = new ExceptionDialog(baseJFrame,e);
                    ExceptionDialog.show();
                }                
            }

            @Override
            public void OnInvalidLogin() {
                onInvalidLoginServer();
            }

            @Override
            public void OnUserNotExists(){                    
                onUserNotExistsServer();                    
            }
        });
        LoginLocalHttpClient.execute();
    }    
    
    
    private void saveServerInformation(ComputerLicenseDataModel ComputerLicenseDataModel) throws Exception{
        
        LoggerUtility.getSingleton().logInfo(LoginLicenseJFrame.class, "Licenciamiento: El servidor devolvio información de licenciamiento");

        LoggerUtility.getSingleton().logInfo(LoginLicenseJFrame.class, "Licenciamiento: " + ComputerLicenseDataModel);

        //Get the serie
        final boolean serieExists = ComputerLicenseDataModel.getSerie()!=null;
        final String serie = serieExists ? ComputerLicenseDataModel.getSerie():"";

        //Validate if create or update the user license
        final boolean winregExists = WinRegistry.existsUserLicenseRegistry();
        if(!winregExists){

            LoggerUtility.getSingleton().logInfo(LoginLicenseJFrame.class, "Licenciamiento: No existen valores para la serie en el registro de windows");

            WinRegistry.addUserLicense(serie);

            LoggerUtility.getSingleton().logInfo(LoginLicenseJFrame.class, "Licenciamiento: Se crearon nuevos valores para la serie en el registro de windows");
        }
        else{

            LoggerUtility.getSingleton().logInfo(LoginLicenseJFrame.class, "Licenciamiento: Si existen valores para la serie en el registro de windows");

            WinRegistry.updateUserLicense(serie);

            LoggerUtility.getSingleton().logInfo(LoginLicenseJFrame.class, "Licenciamiento: Se actualizo la serie en el registro de windows");
        }

        final BasDats CompanyTest = ComputerLicenseDataModel.getTestCompanyDataModel().getCompanyTestDataModel();
        
        final String user = jTextFieldUser.getText().trim();
        final String password = String.valueOf(jPasswordFieldPassword.getPassword());
        
        LoggerUtility.getSingleton().logInfo(LoginLicenseJFrame.class, "Licenciamiento: Saving basdats info into database");
        
        final BasDats BasDats = new BasDats();
        BasDats.setCodemp(CompanyTest.getCodemp());
        BasDats.setBd(CompanyTest.getBd());
        BasDats.setNom(CompanyTest.getNom());
                
        //Save the basdats record
        RepositoryManager.getInstance().getBasDatsRepository().save(BasDats);                  

        LoggerUtility.getSingleton().logInfo(LoginLicenseJFrame.class, "Licenciamiento: Finished");
        
        LoggerUtility.getSingleton().logInfo(LoginLicenseJFrame.class, "Licenciamiento: Saving licence information in database");
        
        //Save in the database the license information
        final License License = new License();
        License.setUser(user);
        License.setPassword(password);
        License.setUsers(ComputerLicenseDataModel.getNumberComputers());
        License.setRemainingDays(ComputerLicenseDataModel.getRemainingDays());
        License.setServerDate(ComputerLicenseDataModel.getCreated_at());
        License.setChannel(ComputerLicenseDataModel.getChannel());
        RepositoryManager.getInstance().getLicenseRepository().addLicense(License);

        LoggerUtility.getSingleton().logInfo(LoginLicenseJFrame.class, "Licenciamiento: Licence information saved in database");
        
        LoggerUtility.getSingleton().logInfo(LoginLicenseJFrame.class, "Licenciamiento: Saving server info in database");
        
        final ServerSession ServerSession = new ServerSession();
        ServerSession.setGenericSerial(ComputerLicenseDataModel.getGenericSerial());                                
        RepositoryManager.getInstance().getServerSessionRepository().addServerSession(ServerSession);
        
        LoggerUtility.getSingleton().logInfo(LoginLicenseJFrame.class, "Licenciamiento: Finished");                
        
        CompanyTest.setMetcost("peps");
        CompanyTest.setRutap(System.getProperty("user.dir"));        
        CompanyTest.setTest(true);
        
        //Get hibernate configuration file
        HibernateConfigModel HibernateConfigModel = HibernateUtil.getSingleton().getHibernateConfigModel();
        
        //Save the local connections params for local db
        HibernateConfigModel HibernateConfigModel_ = new HibernateConfigModel();
        HibernateConfigModel_.setInstance(HibernateConfigModel.getInstance());
        HibernateConfigModel_.setPassword(HibernateConfigModel.getPassword());
        HibernateConfigModel_.setPort(HibernateConfigModel.getPort());
        HibernateConfigModel_.setUrl(HibernateConfigModel.getUrl());
        HibernateConfigModel_.setUser(HibernateConfigModel.getUser());
        HibernateConfigModel_.setDatabase(CompanyTest.getBd());
        HibernateUtil.getSingleton().setHibernateConfigModelLocal(HibernateConfigModel_); //Set this for the entire system

        LoggerUtility.getSingleton().logInfo(LoginLicenseJFrame.class, "Hibernate: Connecting to hibernate local");
        
        //Connect to local
        HibernateUtil.getSingleton().connectToDbLocal();
        
        LoggerUtility.getSingleton().logInfo(LoginLicenseJFrame.class, "Hibernate: Creating jdbc database and reading scripts file");
        
        //Create the new company with JDBC and read all the catalogs script from disk
        MysqlScriptsUtil.getInstance().creaDB(CompanyTest.getBd(), HibernateConfigModel.getUser(), HibernateConfigModel.getPassword(), HibernateConfigModel.getInstance(), HibernateConfigModel.getPort());
                
        LoggerUtility.getSingleton().logInfo(LoginLicenseJFrame.class, "Hibernate: finished");
                
        LoggerUtility.getSingleton().logInfo(LoginLicenseJFrame.class, "Hibernate: Finished");
        
        LoggerUtility.getSingleton().logInfo(LoginLicenseJFrame.class, "Hibernate: Adding test company");
        
        //Save the company in database
        RepositoryManager.getInstance().getCompanyRepository().save(CompanyTest);       

        LoggerUtility.getSingleton().logInfo(LoginLicenseJFrame.class, "Hibernate: Test company added");

        LoggerUtility.getSingleton().logInfo(LoginLicenseJFrame.class, "Licenciamiento: Saving test product 1 into database");
        final Product Product1 = ComputerLicenseDataModel.getTestCompanyDataModel().getProduct1();
        RepositoryManager.getInstance().getProductRepository().addOrUpdateProduct(Product1);
        LoggerUtility.getSingleton().logInfo(LoginLicenseJFrame.class, "Licenciamiento: Test product 1 saved in the database");

        final String pathImgProduc1 = ComputerLicenseDataModel.getTestCompanyDataModel().getProduct1().getPathIMG();
        final String productCode1 = ComputerLicenseDataModel.getTestCompanyDataModel().getProduct1().getCodeProduct();                                
        LoggerUtility.getSingleton().logInfo(LoginLicenseJFrame.class, "Licenciamiento: Product 1 saving image " + pathImgProduc1 + " to local folder");
        UtilityManager.getSingleton().getImagesUtility().saveImageFromUrl(productCode1, pathImgProduc1);
        LoggerUtility.getSingleton().logInfo(LoginLicenseJFrame.class, "Licenciamiento: Saved");

        LoggerUtility.getSingleton().logInfo(LoginLicenseJFrame.class, "Licenciamiento: Saving test product 2 into database");
        final Product Product2 = ComputerLicenseDataModel.getTestCompanyDataModel().getProduct2();                                
        RepositoryManager.getInstance().getProductRepository().addOrUpdateProduct(Product2);
        LoggerUtility.getSingleton().logInfo(LoginLicenseJFrame.class, "Licenciamiento: Test product 2 saved in the database");

        final String pathImgProduc2 = ComputerLicenseDataModel.getTestCompanyDataModel().getProduct2().getPathIMG();
        final String productCode2 = ComputerLicenseDataModel.getTestCompanyDataModel().getProduct2().getCodeProduct();                                
        LoggerUtility.getSingleton().logInfo(LoginLicenseJFrame.class, "Licenciamiento: Product 2 saving image " + pathImgProduc2 + " to local folder");
        UtilityManager.getSingleton().getImagesUtility().saveImageFromUrl(productCode2, pathImgProduc2);
        LoggerUtility.getSingleton().logInfo(LoginLicenseJFrame.class, "Licenciamiento: Saved");

        LoggerUtility.getSingleton().logInfo(LoginLicenseJFrame.class, "Licenciamiento: Saving test product 3 into database");
        final Product Product3 = ComputerLicenseDataModel.getTestCompanyDataModel().getProduct3();                                
        RepositoryManager.getInstance().getProductRepository().addOrUpdateProduct(Product3);
        LoggerUtility.getSingleton().logInfo(LoginLicenseJFrame.class, "Licenciamiento: Test product 3 saved in the database");

        final String pathImgProduc3 = ComputerLicenseDataModel.getTestCompanyDataModel().getProduct3().getPathIMG();
        final String productCode3 = ComputerLicenseDataModel.getTestCompanyDataModel().getProduct3().getCodeProduct();                                
        LoggerUtility.getSingleton().logInfo(LoginLicenseJFrame.class, "Licenciamiento: Product 3 saving image " + pathImgProduc3 + " to local folder");
        UtilityManager.getSingleton().getImagesUtility().saveImageFromUrl(productCode3, pathImgProduc3);
        LoggerUtility.getSingleton().logInfo(LoginLicenseJFrame.class, "Licenciamiento: Saved");

        LoggerUtility.getSingleton().logInfo(LoginLicenseJFrame.class, "Licenciamiento: Saving test product 4 into database");
        final Product Product4 = ComputerLicenseDataModel.getTestCompanyDataModel().getProduct4();                                
        RepositoryManager.getInstance().getProductRepository().addOrUpdateProduct(Product4);
        LoggerUtility.getSingleton().logInfo(LoginLicenseJFrame.class, "Licenciamiento: Test product 4 saved in the database");

        final String pathImgProduc4 = ComputerLicenseDataModel.getTestCompanyDataModel().getProduct4().getPathIMG();
        final String productCode4 = ComputerLicenseDataModel.getTestCompanyDataModel().getProduct4().getCodeProduct();                                
        LoggerUtility.getSingleton().logInfo(LoginLicenseJFrame.class, "Licenciamiento: Product 4 saving image " + pathImgProduc4 + " to local folder");
        UtilityManager.getSingleton().getImagesUtility().saveImageFromUrl(productCode4, pathImgProduc4);
        LoggerUtility.getSingleton().logInfo(LoginLicenseJFrame.class, "Licenciamiento: Saved");

        LoggerUtility.getSingleton().logInfo(LoginLicenseJFrame.class, "Licenciamiento: Saving test product 5 into database");
        final Product Product5 = ComputerLicenseDataModel.getTestCompanyDataModel().getProduct5();                                
        RepositoryManager.getInstance().getProductRepository().addOrUpdateProduct(Product5);
        LoggerUtility.getSingleton().logInfo(LoginLicenseJFrame.class, "Licenciamiento: Test product 5 saved in the database");

        final String pathImgProduc5 = ComputerLicenseDataModel.getTestCompanyDataModel().getProduct5().getPathIMG();
        final String productCode5 = ComputerLicenseDataModel.getTestCompanyDataModel().getProduct5().getCodeProduct();                                
        LoggerUtility.getSingleton().logInfo(LoginLicenseJFrame.class, "Licenciamiento: Product 5 saving image " + pathImgProduc5 + " to local folder");
        UtilityManager.getSingleton().getImagesUtility().saveImageFromUrl(productCode5, pathImgProduc5);
        LoggerUtility.getSingleton().logInfo(LoginLicenseJFrame.class, "Licenciamiento: Saved");

        LoggerUtility.getSingleton().logInfo(LoginLicenseJFrame.class, "Licenciamiento: Saving test customer 1 into database");
        final Company Customer1 = ComputerLicenseDataModel.getTestCompanyDataModel().getCustomer1();
        RepositoryManager.getInstance().getCompanyRepository().saveOrUpdateCustomer(Customer1);
        LoggerUtility.getSingleton().logInfo(LoginLicenseJFrame.class, "Licenciamiento: Test customer 1 saved in the database");

        LoggerUtility.getSingleton().logInfo(LoginLicenseJFrame.class, "Licenciamiento: Saving test customer 2 into database");
        final Company Customer2 = ComputerLicenseDataModel.getTestCompanyDataModel().getCustomer2();
        RepositoryManager.getInstance().getCompanyRepository().saveOrUpdateCustomer(Customer2);
        LoggerUtility.getSingleton().logInfo(LoginLicenseJFrame.class, "Licenciamiento: Test customer 2 saved in the database");

        LoggerUtility.getSingleton().logInfo(LoginLicenseJFrame.class, "Licenciamiento: Saving test customer 3 into database");
        final Company Customer3 = ComputerLicenseDataModel.getTestCompanyDataModel().getCustomer3();
        RepositoryManager.getInstance().getCompanyRepository().saveOrUpdateCustomer(Customer3);
        LoggerUtility.getSingleton().logInfo(LoginLicenseJFrame.class, "Licenciamiento: Test customer 3 saved in the database");

        LoggerUtility.getSingleton().logInfo(LoginLicenseJFrame.class, "Licenciamiento: Saving test customer 4 into database");
        final Company Customer4 = ComputerLicenseDataModel.getTestCompanyDataModel().getCustomer4();
        RepositoryManager.getInstance().getCompanyRepository().saveOrUpdateCustomer(Customer4);
        LoggerUtility.getSingleton().logInfo(LoginLicenseJFrame.class, "Licenciamiento: Test customer 4 saved in the database");

        LoggerUtility.getSingleton().logInfo(LoginLicenseJFrame.class, "Licenciamiento: Saving test customer 5 into database");
        final Company Customer5 = ComputerLicenseDataModel.getTestCompanyDataModel().getCustomer5();
        RepositoryManager.getInstance().getCompanyRepository().saveOrUpdateCustomer(Customer5);
        LoggerUtility.getSingleton().logInfo(LoginLicenseJFrame.class, "Licenciamiento: Test customer 5 saved in the database");

        LoggerUtility.getSingleton().logInfo(LoginLicenseJFrame.class, "Licenciamiento: Saving test supplier 1 into database");
        final Supplier Supplier1 = ComputerLicenseDataModel.getTestCompanyDataModel().getSupplier1();
        RepositoryManager.getInstance().getSuppliersRepository().save(Supplier1);
        LoggerUtility.getSingleton().logInfo(LoginLicenseJFrame.class, "Licenciamiento: Test supplier 1 saved in the database");

        LoggerUtility.getSingleton().logInfo(LoginLicenseJFrame.class, "Licenciamiento: Saving test supplier 2 into database");
        final Supplier Supplier2 = ComputerLicenseDataModel.getTestCompanyDataModel().getSupplier2();
        RepositoryManager.getInstance().getSuppliersRepository().save(Supplier2);
        LoggerUtility.getSingleton().logInfo(LoginLicenseJFrame.class, "Licenciamiento: Test supplier 2 saved in the database");

        LoggerUtility.getSingleton().logInfo(LoginLicenseJFrame.class, "Licenciamiento: Saving test supplier 3 into database");
        final Supplier Supplier3 = ComputerLicenseDataModel.getTestCompanyDataModel().getSupplier3();
        RepositoryManager.getInstance().getSuppliersRepository().save(Supplier3);
        LoggerUtility.getSingleton().logInfo(LoginLicenseJFrame.class, "Licenciamiento: Test supplier 3 saved in the database");

        LoggerUtility.getSingleton().logInfo(LoginLicenseJFrame.class, "Licenciamiento: Saving test supplier 4 into database");
        final Supplier Supplier4 = ComputerLicenseDataModel.getTestCompanyDataModel().getSupplier4();
        RepositoryManager.getInstance().getSuppliersRepository().save(Supplier4);
        LoggerUtility.getSingleton().logInfo(LoginLicenseJFrame.class, "Licenciamiento: Test supplier 4 saved in the database");

        LoggerUtility.getSingleton().logInfo(LoginLicenseJFrame.class, "Licenciamiento: Saving test supplier 5 into database");
        final Supplier Supplier5 = ComputerLicenseDataModel.getTestCompanyDataModel().getSupplier5();
        RepositoryManager.getInstance().getSuppliersRepository().save(Supplier5);
        LoggerUtility.getSingleton().logInfo(LoginLicenseJFrame.class, "Licenciamiento: Test supplier 5 saved in the database");                      
        
        LoggerUtility.getSingleton().logInfo(LoginLicenseJFrame.class, "Licenciamiento: Is premium: " + ComputerLicenseDataModel.getPremiumFuntionsDataModel().isPremium());
        LoggerUtility.getSingleton().logInfo(LoginLicenseJFrame.class, "Licenciamiento: sendToOnlyOneDestinataryInFact: " + ComputerLicenseDataModel.getPremiumFuntionsDataModel().isSendToOnlyOneDestinataryInFact());
        LoggerUtility.getSingleton().logInfo(LoginLicenseJFrame.class, "Licenciamiento: onlyUseIVATax: " + ComputerLicenseDataModel.getPremiumFuntionsDataModel().isOnlyUseIVATax());
        LoggerUtility.getSingleton().logInfo(LoginLicenseJFrame.class, "Licenciamiento: onlyOneSerieForDocument: " + ComputerLicenseDataModel.getPremiumFuntionsDataModel().isOnlyOneSerieForDocument());
        LoggerUtility.getSingleton().logInfo(LoginLicenseJFrame.class, "Licenciamiento: disableInvoiceTicketsWindow: " + ComputerLicenseDataModel.getPremiumFuntionsDataModel().isDisableInvoiceTicketsWindow());
        
        LoggerUtility.getSingleton().logInfo(LoginLicenseJFrame.class, "Licenciamiento: Saving premium functions in dynamic datamodel");
        
        //Save premium functions
        PremiumFunctionsManager.getSingleton().setPremiumFuntionsDataModel(ComputerLicenseDataModel.getPremiumFuntionsDataModel());
        
        LoggerUtility.getSingleton().logInfo(LoginLicenseJFrame.class, "Licenciamiento: Finished");

        LoggerUtility.getSingleton().logInfo(LoginLicenseJFrame.class, "Licenciamiento: Connecting to dbempresas again");
        
        HibernateUtil.getSingleton().connectToDbEmpresas();

        LoggerUtility.getSingleton().logInfo(LoginLicenseJFrame.class, "Licenciamiento: Finished");
        
        LoggerUtility.getSingleton().logInfo(LoginLicenseJFrame.class, "Licenciamiento: Showing next window");
        
        //Close current window
        dispose();
        
        //Show the presentation screen
        final PresentationController PresentationController = new PresentationController();
        PresentationController.setVisible();
    }
    
    private void getComputerInformationWithServer(LoginLocalResponseRequestModel LoginLocalResponseRequestModel, final String user, final String password) throws Exception {
        
        LoggerUtility.getSingleton().logInfo(LoginLicenseJFrame.class, "Licenciamiento: Las credenciales son correctas");

        LoggerUtility.getSingleton().logInfo(LoginLicenseJFrame.class, "Licenciamiento: Obteniendo información con el servidor de licenciamiento del computador");

        //Create the http client request to get license information
        final GetComputerStatusHttpClient GetComputerStatusHttpClient = new GetComputerStatusHttpClient();                                
        GetComputerStatusHttpClient.setUser(user);
        GetComputerStatusHttpClient.setPassword(password);
        GetComputerStatusHttpClient.setGetComputerStatusSubscriberInteface((ComputerLicenseDataModel ComputerLicenseDataModel) -> {
                        
            try{
                saveServerInformation(ComputerLicenseDataModel);
            }catch(Exception Exception){

                LoggerUtility.getSingleton().logError(LoginLicenseJFrame.class, Exception);

                final ExceptionDialog ExceptionDialog = new ExceptionDialog(baseJFrame,Exception);
                ExceptionDialog.show();                                                                       
            }
        });
        GetComputerStatusHttpClient.execute();
    }
    
    private void onInvalidLoginServer(){
        
        RenderControlersViewManager.getSingleton().getCreatingDatabaseWaitViewController().dispose();
                    
        LoggerUtility.getSingleton().logInfo(LoginLicenseJFrame.class, "Licenciamiento: Las credenciales no son correctas");

        final InvalidCredentialsDialog InvalidCredentialsDialog = new InvalidCredentialsDialog(this);
        InvalidCredentialsDialog.show();
    }
    
    private void onUserNotExistsServer(){
        
        RenderControlersViewManager.getSingleton().getCreatingDatabaseWaitViewController().dispose();
                    
        LoggerUtility.getSingleton().logInfo(LoginLicenseJFrame.class, "Licenciamiento: No existe el usuario");

        RegisterWebsiteViewController RegisterWebsiteViewController = new RegisterWebsiteViewController();
        RegisterWebsiteViewController.setVisible(true);
    }
}
