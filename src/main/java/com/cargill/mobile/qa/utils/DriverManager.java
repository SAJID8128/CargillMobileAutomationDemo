package com.cargill.mobile.qa.utils;

import io.appium.java_client.AppiumDriver;

//***COMPLETED***
public class DriverManager {
    private static ThreadLocal<AppiumDriver> driver = new ThreadLocal<AppiumDriver>();

    private Utils utils = new Utils();

    public AppiumDriver getDriver() {
        return driver.get();
    }

    public void setDriver(AppiumDriver driver1) {
        driver.set(driver1);
    }

    public void initializeDriver() throws Exception {
        AppiumDriver driver = null;

        GlobalParams params = new GlobalParams();

        // Equal Equal (==) operator we only use inside conditional operator; conditional means (if while).
        if (driver == null) {
            try {
                // This was put in a try/catch block because the CapabilitiesManager throws an exception.
                // Something happened here that the driver did not get initialized.
                if ("Android".equals(params.getPlatformName())) {
                    CapabilitiesManager capabilitiesManager = new CapabilitiesManager();
                    ServerManager serverManager = new ServerManager();
                    driver = new AppiumDriver(serverManager.getServer().getUrl(), capabilitiesManager.getCapabilities());
                    if(driver == null) {
                        throw new Exception("Driver is null. ABORT !!!");
                    }
                    setDriver(driver);
                    utils.log().info("Driver is initialized.");
                }
                // Because drive did not get initialized, it was caught here.
                // Log gives custom fatal error message along with the server message (ex.toString()).
            } catch (Exception ex) {
                ex.printStackTrace();
                utils.log().fatal("Drive initialization failure. ABORT !!!!" + ex.toString());
            }

        } else {

        }
    }
}

// option command L = to format page