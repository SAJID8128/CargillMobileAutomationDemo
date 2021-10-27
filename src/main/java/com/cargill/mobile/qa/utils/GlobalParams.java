package com.cargill.mobile.qa.utils;

//***COMPLETE***
// This will be called by the "runner class" which then will start the server and initialize the driver.
public class GlobalParams {

    // Each of these variables has a getter and setter method on the bottom.
    // Variables work for both Android and iOS frameworks.
    /* All the variables created in this Params class, we use ThreadLocal because "garbage collector" is going to
       come and collect these objects when we don't need them.
       And this is the same we create a variable inside DriverManager
    */
    private static ThreadLocal<String> platformName = new ThreadLocal<String>();
    private static ThreadLocal<String> udid = new ThreadLocal<String>();
    private static ThreadLocal<String> deviceName = new ThreadLocal<String>();
    private static ThreadLocal<String> systemPort = new ThreadLocal<String>();
    private static ThreadLocal<String> chromeDriverPort = new ThreadLocal<String>();


    public String getPlatformName() {
        return platformName.get();
    }

    public void setPlatformName(String platformName1) {
        platformName.set(platformName1);
    }


    public String getUDID() {
        return udid.get();
    }

    public void setUDID(String udid2) {
        udid.set(udid2);
    }


    public String getDeviceName() {
        return deviceName.get();
    }

    public void setDeviceName(String deviceName2) {
        deviceName.set(deviceName2);
    }


    public String getSystemPort() {
        return systemPort.get();
    }

    public void setSystemPort(String systemPort2) {
        systemPort.set(systemPort2);
    }


    public String getChromeDriverPort() {
        return chromeDriverPort.get();
    }

    public void setChromeDriverPort(String chromeDriverPort2) {
        chromeDriverPort.set(chromeDriverPort2);
    }

    /* We wrote this method because on top we are using ThreadLocal; so we need to create an instance of this class
       this method (initializeGlobalParams) so everywhere there will be a different object and it will be collected
       by the "garbage collector".*/
    public void initializeGlobalParams() {
        GlobalParams params = new GlobalParams();
        params.setPlatformName(System.getProperty("platformName", "Android"));
        params.setUDID(System.getProperty("udid", "emulator-5554"));
        params.setDeviceName(System.getProperty("deviceName", "Emulator1"));

        String platform = params.getPlatformName();
        if(platform.equals("Android")) {
            params.setSystemPort(System.getProperty("systemPort", "10000"));
            params.setChromeDriverPort(System.getProperty("chromeDriverPort", "11000"));
        } else {
            throw new IllegalStateException("Invalid platform name!");
        }

    }

}
