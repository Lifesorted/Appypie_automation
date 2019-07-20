package com.Appypie.pages;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.Appypie.Utility.browserFactory;

public class baseClass {

	public WebDriver driver;
	
	@BeforeMethod
	public void launchBrowser() {
		driver=browserFactory.startApplication(driver, "chrome", "Https://www.appypie.com");
	}
	
	@AfterMethod
	public void tearDown() {
		browserFactory.quitbrowser(driver);
	}
	
	
}
