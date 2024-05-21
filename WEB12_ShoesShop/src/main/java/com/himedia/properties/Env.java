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
    
    // member
    public static String getMember() {
		return prop.getProperty("getMember");
	}
    
    public static String join() {
    	return prop.getProperty("join");
    }
    
    // product
    public static String getBestList() {
    	return prop.getProperty("bestlist");
    }
    
    public static String getNewList() {
    	return prop.getProperty("newlist");
    }
    
    public static String getListByCategory() {
    	return prop.getProperty("getListByCategory");
    }
    
    public static String getProduct() {
    	return prop.getProperty("getProduct");
    }
    
    public static String getProductName() {
    	return prop.getProperty("getProductName");
    }
    
    public static String getLastProductID() {
    	return prop.getProperty("lastProductID");
    }
    
    public static String getInsertProduct() {
    	return prop.getProperty("insertProduct");
    }
    
    // productImage
    public static String getInsertProductImage() {
    	return prop.getProperty("insertProductImage");
    }
    
    public static String getProductImage() {
    	return prop.getProperty("getProductImage");
    }
    
    // cart
    public static String addCart() {
    	return prop.getProperty("addCart");
    }
    
    public static String getCartList() {
    	return prop.getProperty("getCartList");
    }
}