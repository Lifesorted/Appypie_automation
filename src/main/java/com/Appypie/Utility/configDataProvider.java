package com.Appypie.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Pattern;

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
