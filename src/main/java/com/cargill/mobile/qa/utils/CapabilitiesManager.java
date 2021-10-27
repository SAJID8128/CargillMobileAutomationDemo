package com.cargill.mobile.qa.utils;

import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.util.Properties;
//***COMPLETED***
public class CapabilitiesManager {

    Utils utils = new Utils();

    public DesiredCapabilities getCapabilities()  throws Exception{

        GlobalParams params = new GlobalParams();
        Properties props = new PropertyManager().getProps();

        try {
            utils.log().info("get capabilities");
            DesiredCapabilities capabilities = new DesiredCapabilities();
            /* All these 3 Capabilities are the same for Android, iOS, and Windows; except Windows
            doesn't need a device.*/
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, params.getPlatformName());
            capabilities.setCapability(MobileCapabilityType.UDID, params.getUDID());
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, params.getDeviceName());

            // For Android framework.
            /* The reason the values are kept inside a property file is because these values can change
               (Android or iOS).*/
            if("Android".equals(params.getPlatformName())) {
                capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,props.getProperty("androidAutomationName"));
                capabilities.setCapability("platformVersion",props.getProperty("10"));
                capabilities.setCapability("appPackage",props.getProperty("androidAppPackage"));
                capabilities.setCapability("appActivity",props.getProperty("androidAppActivity"));
                capabilities.setCapability("systemPort",params.getSystemPort());
                capabilities.setCapability("chromeDriverPort",params.getChromeDriverPort());

                // String appPath = file path/src/test
                String appPath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" +
                        File.separator + "resources" + File.separator +  "apps" + File.separator +
                        "Android.SauceLabs.Mobile.Sample.app.2.2.1.apk";
                        utils.log().info("App path: " + appPath);
                        capabilities.setCapability("app",appPath);

                // For iOS framework.
            }else if("iOS".equals(params.getPlatformName())) {
            }
            return capabilities;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }
}

/*
System.getProperty("user.dir") = /Users/nyla/IdeaProjects/CargillMobileAutomationDemo
File.separator = /
src
File.separator = /
test
File.separator = /
resources
File.separator = /
apps
FileSeparator
Facebook.apk


System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"+ File.separator + "resources" +
File.separator + "apps" + File.separator + "Facebook.apk";
 */