package com.Appypie.utilities;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class configDataProvider {
	
	Properties pro;
	
	public configDataProvider() {
		File src=new File("./Config/Config.properties");
		try {
			FileInputStream fis=new FileInputStream(src);
			pro= new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Unable to connect to property file "+e.getMessage());
		}
	}
	
	public String getUrl() {
		return pro.getProperty("qaUrl");
	}
	
	public String getBrowser() {
		return pro.getProperty("Browser");
	}
}