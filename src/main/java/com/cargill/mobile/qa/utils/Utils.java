package com.cargill.mobile.qa.utils;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Utils {

    public static final long WAIT = 10;
    // Public = access modifier
    // Logger = return type
    // log = name of method
    public Logger log() {
        return LogManager.getLogger(Thread.currentThread().getStackTrace()[2].getClassName());

    }
}
