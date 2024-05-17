package com.himedia.properties;

import java.io.IOException;
import java.util.Properties;

public class Env {
	static Properties prop = new Properties();
	static {
        try {
            prop.load(Env.class.getResourceAsStream("Env.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    // DB Properties
    public static String getEnvContext() {
    	return prop.getProperty("envContext");
    }
    
    public static String getDataSource() {
    	return prop.getProperty("DataSource");
    }
    
    // init
    public static String getInitPath() {
    	return prop.getProperty("InitPath");
    }
    
    public static String select() {
    	return prop.getProperty("select");
    }

	public static String insert() {
		return prop.getProperty("insert");
	}
}