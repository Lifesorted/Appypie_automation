package com.Appypie.pages;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.Appypie.Utility.browserFactory;
import com.Appypie.Utility.configDataProvider;
import com.Appypie.Utility.excelDataProvider;
import com.Appypie.Utility.helper;

public class baseClass {

	public WebDriver driver;
	
	public excelDataProvider excel;
	public configDataProvider configdp;
	
	@BeforeSuite
	public void setupSuite() {
		excel=new excelDataProvider();
		configdp=new configDataProvider();
	}
	
	@BeforeMethod
	public void launchBrowser() {
		driver=browserFactory.startApplication(driver, configdp.getBrowser(), configdp.getUrl());
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) {
		
		if(result.getStatus()==ITestResult.FAILURE) {
			helper.captureScreenshot(driver);
		}		
		browserFactory.quitbrowser(driver);
	}
	
	
	
}
