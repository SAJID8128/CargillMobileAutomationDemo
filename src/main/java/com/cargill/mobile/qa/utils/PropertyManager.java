package com.cargill.mobile.qa.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyManager {

    private static Properties props = new Properties();
    private Utils utils = new Utils();

    public Properties getProps() throws IOException {
        InputStream is = null;
        String propsFileName = "config.properties";
        if (props.isEmpty()) {
            try {
                utils.log().info("loading config properties");
                is = getClass().getClassLoader().getResourceAsStream(propsFileName);
                props.load(is);
            } catch (IOException ex) {
                ex.printStackTrace();
                throw ex;
            }finally {
                if (is != null) {
                    is.close();
                }
            }
        }
        return props;
    }
}