package com.cargill.mobile.qa.runners;

import com.cargill.mobile.qa.utils.DriverManager;
import com.cargill.mobile.qa.utils.GlobalParams;
import com.cargill.mobile.qa.utils.ServerManager;

/* Note - If we call these 3 things; and they are all correct, then we can hit one method from the "LoginPage".
    1) GlobalParams
    2) DriverManager
    3) ServerManager */
// First we have to call "GlobalParams" and then call "initializeGlobalParams".
public class MyTestRunner {
    /* First we created an object called "params" and then using this object we called the method
       "initializeGlobalParams" so that all our params will be properly set. */
    /* Then we call the server manager by calling "startServer" which will set up the 3 environment variables;
       then "GlobalParams" has all the params which we will be taking to create one "AppiumServiceBuilder".
       Now our server is properly configured with my system.*/
    public static void main(String[] args) {
        GlobalParams params = new GlobalParams();
        params.initializeGlobalParams();

        // Starts server
        ServerManager serverManager = new ServerManager();
        serverManager.startServer();

        try {
            DriverManager driverManager = new DriverManager();
            driverManager.initializeDriver();
            driverManager.getDriver().quit();
            serverManager.getServer().stop();

        } catch (Exception ex) {

        }
    }
}
