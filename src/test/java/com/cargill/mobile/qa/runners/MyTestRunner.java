package com.cargill.mobile.qa.runners;

import com.cargill.mobile.qa.pages.LoginPage;
import com.cargill.mobile.qa.utils.DriverManager;
import com.cargill.mobile.qa.utils.GlobalParams;
import com.cargill.mobile.qa.utils.ServerManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;

/* Note - If we call these 3 things; and they are all correct, then we can hit one method from the "LoginPage".
    1) GlobalParams
    2) DriverManager
    3) ServerManager */
// First we have to call "GlobalParams" and then call "initializeGlobalParams".
public class MyTestRunner {

    @BeforeClass
    public static void initialize() throws Exception {
        GlobalParams params = new GlobalParams();
        params.initializeGlobalParams();
        ServerManager serverManager = new ServerManager();
        serverManager.startServer();
        DriverManager driverManager = new DriverManager();
        driverManager.initializeDriver();
    }

    @AfterClass
    public static void quit() {
        DriverManager driverManager = new DriverManager();
        if (driverManager.getDriver() != null) {
            driverManager.getDriver().quit();
            driverManager.setDriver(null);
        }

        ServerManager serverManager = new ServerManager();
        if (serverManager.getServer() != null) {
            serverManager.getServer().stop();
        }
    }
}


// NOTE:---------- Everything below is done above using Cucumber/JUnit ----------
    /* First we created an object called "params" and then using this object we called the method
       "initializeGlobalParams" so that all our params will be properly set. */
    /* Then we call the server manager by calling "startServer" which will set up the 3 environment variables;
       then "GlobalParams" has all the params which we will be taking to create one "AppiumServiceBuilder".
       Now our server is properly configured with my system.*/
   /* public static void main(String[] args) {
        GlobalParams params = new GlobalParams();
        params.initializeGlobalParams();

        // Starts server
        ServerManager serverManager = new ServerManager();
        serverManager.startServer();

        try {
            DriverManager driverManager = new DriverManager();
            driverManager.initializeDriver();

            LoginPage loginPage = new LoginPage();
            loginPage.enterUserName("Nyla-8128");
            loginPage.enterPassword("supergirl");
            loginPage.pressLogBtn();
            //driverManager.getDriver().quit();
           // serverManager.getServer().stop();

        } catch (Exception ex) {

        }
    }*/

