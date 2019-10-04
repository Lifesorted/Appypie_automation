package com.Appypie.pages;

import java.io.File;
import java.io.IOException;

import org.apache.logging.log4j.core.util.Loader;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.Appypie.Utility.browserFactory;
import com.Appypie.Utility.configDataProvider;
import com.Appypie.Utility.excelDataProvider;
import com.Appypie.Utility.helper;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class baseClass {

	public WebDriver driver;
	public excelDataProvider excel;
	public configDataProvider configdp;
	public ExtentReports report;
	public ExtentTest logger;
	
	@BeforeSuite
	public void setupSuite() {
		excel=new excelDataProvider();
		configdp=new configDataProvider();
		ExtentHtmlReporter extent=new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/Appypie_"+helper.getCurrentDateTime()+".html"));
		report=new ExtentReports();
		report.attachReporter(extent);
	}
	
	@BeforeMethod
	public void launchBrowser() {
		
		driver=browserFactory.startApplication(driver, configdp.getBrowser(), configdp.getUrl());
		 //configdp.getBrowser()
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) throws Exception{

		if(result.getStatus()==ITestResult.FAILURE) {
			
				logger.fail("Test Failed",MediaEntityBuilder.createScreenCaptureFromPath(helper.captureScreenshot(driver)).build());
			
		}	
		/*else if(result.getStatus()==ITestResult.SUCCESS) {
			
				logger.pass("Test Passed",MediaEntityBuilder.createScreenCaptureFromPath(helper.captureScreenshot(driver)).build());
			
		}*/
		else if(result.getStatus()==ITestResult.SKIP) {
			
				logger.skip("Test Skipped",MediaEntityBuilder.createScreenCaptureFromPath(helper.captureScreenshot(driver)).build());
				
		}
		
		report.flush();
		browserFactory.quitbrowser(driver);
}
	
}