package com.Appypie.pages;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.Appypie.Utility.browserFactory;

public class baseClass {

	public WebDriver driver;
	
	@BeforeClass
	public void launchBrowser() {
		browserFactory.startApplication(driver, "chrome", "Https://www.appypie.com");
	}
	
	@AfterClass
	public void tearDown() {
		browserFactory.quitbrowser(driver);
	}
	
	
}
