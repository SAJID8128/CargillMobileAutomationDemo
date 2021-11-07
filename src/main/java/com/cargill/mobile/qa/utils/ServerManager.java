package com.cargill.mobile.qa.utils;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import java.io.File;
import java.util.HashMap;

// This ServerManager is the same for all types of framework (Android, iOS, Windows).
// ServerManager will be creating one variable called "server" and the type will be (AppiumDriverLocalService).
/* Here we will be creating one getter method called "getServer" and we don't need a setter method because
   we will be creating the server here.*/
// Another method we will have is "startServer" and inside this method we will be starting our server.
// The server can start from "Windows" or "Mac" platform.
/* The 3 environment variables we set up before have no issues in Windows platform but for Mac, every time
   we close the session or close the terminal the bash profile get formatted.*/
/* So, how many methods do we have here? (4 METHODS)
1) One method to get the server.
2) One method to start the server.
3) One method to set up the environment variables for Windows.
4) One method to set up the environment variables for Mac.*/
public class ServerManager {

    private static ThreadLocal<AppiumDriverLocalService> server = new ThreadLocal<AppiumDriverLocalService>();
    private Utils utils = new Utils();

    // Method 1)
    // Here you cannot "return" the "server" but the "value of the server" (server.get()).
    public AppiumDriverLocalService getServer() {

        return server.get();
    }

    // Method 2)
    public void startServer() {
        utils.log().info("Starting appium server");
        /* To make sure we chose the right service, hold "Command" key and hover cursor over the chosen service
           "getMacAppiumService()"; which will turn blue and then click - it will take you to that service method.*/
        // We will start the server and make sure it has started by using the if/else statement.
        AppiumDriverLocalService service = getMacAppiumService();
        service.start();
        /* We have to check if service is "null" and if it's not "null", we have to make sure that its running---
           lets say because of some "path" was a mistake or because of some other mistake, your machine is not running.
           So, that time also, our variable will not be "null" but somehow our server didn't get started because of
           some issue with our environment variables. So this check we also need to do.*/
        if(service == null || !service.isRunning()) {
            utils.log().fatal("Appium server has not started. ABORT !!!");
            throw new AppiumServerHasNotBeenStartedLocallyException("Appium server is not started. ABORT !!!");
        }
        server.set(service);
        utils.log().info("Appium server is started");
    }

    // Method 3)
    private AppiumDriverLocalService getWindowsAppiumService() {
        // Params created locally.
        GlobalParams params = new GlobalParams();
        AppiumServiceBuilder builder = new AppiumServiceBuilder();
        // Usually "port" is 4723 but if its being used, then it will look for another "free port".
        builder.usingAnyFreePort();
        builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
        builder.withLogFile(new File(params.getPlatformName() + " " + params.getDeviceName() +
                File.separator + "Server.logs"));
        AppiumDriverLocalService service = AppiumDriverLocalService.buildService(builder);
        return service;
    }

    // Method 4)
    // First we create our HashMap with our 3 environment variables, and then we create our service.
    private AppiumDriverLocalService getMacAppiumService() {
        HashMap<String, String> environment = new HashMap<String, String>();
        environment.put("JAVA_HOME", "/Library/Internet Plug-Ins/JavaAppletPlugin.plugin/Contents/Home");
        environment.put("ANDROID_HOME", "/Users/nyla/Library/Android/sdk");
        environment.put("PATH", "/usr/local/bin:/usr/bin:/bin:/usr/sbin:/sbin:JAVA_HOME/bin:/usr/local/Cellar" +
                "/mysql/8.0.12/bin:/Users/nyla/Desktop/MAVEN/apache-maven-3.6.3/bin:/Users/nyla/Library/Android" +
                "/sdk/tools:/Users/nyla/Library/Android/sdk/platform-tools");

        GlobalParams params = new GlobalParams();
        AppiumServiceBuilder builder = new AppiumServiceBuilder();
        // Usually "port" is 4723 but if its being used, then it will look for another "free port".
        // Bottom 3 below are the same as in Windows.
        builder.usingAnyFreePort();
        builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
        builder.withLogFile(new File(params.getPlatformName() + " " + params.getDeviceName() +
                File.separator + "Server.logs"));
        // Bottom 3 are exclusively for Mac.
        builder.withEnvironment(environment);
        builder.usingDriverExecutable(new File("/usr/local/bin/node"));
        builder.withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"));
        AppiumDriverLocalService service = AppiumDriverLocalService.buildService(builder);
        return service;
    }
}
