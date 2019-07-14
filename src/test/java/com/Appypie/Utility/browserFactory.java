package com.Appypie.Utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class browserFactory {
	
	public static WebDriver startApplication(WebDriver driver, String browserName, String appUrl) {
		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.chrome.driver", "./Drivers/geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else {
			System.out.println("Driver not Found or do not support the browser.");
		}
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(appUrl);
		
		return driver;
	}
	
	
	public static void quitbrowser(WebDriver driver) {
		driver.quit();
	}

}
