package com.Appypie.utilities;
import org.openqa.selenium.WebDriver;

public class browserFactory {
	
	public static WebDriver getAppUrl(WebDriver driver,String appUrl) {
		driver.get(appUrl);
		return driver;
	}
	
	public static void quitbrowser(WebDriver driver) {
		driver.quit();
	}

}
