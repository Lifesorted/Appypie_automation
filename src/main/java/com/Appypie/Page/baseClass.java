package com.Appypie.Page;
import java.io.File;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.Appypie.utilities.browserFactory;
import com.Appypie.utilities.configDataProvider;
import com.Appypie.utilities.excelDataProvider;
import com.Appypie.utilities.helper;
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
	
	@Parameters({"browser"})
	@BeforeMethod
	public void launchBrowser(String browser) {
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver", "./Drivers/IEDriverServer.exe");
			driver=new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.get(configdp.getUrl());
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	    
		//driver=browserFactory.getAppUrl(driver,configdp.getUrl());
	}
	
	@AfterMethod(alwaysRun=true)
	public void tearDown(ITestResult result) throws Exception{
		if(result.getStatus()==ITestResult.FAILURE) {
			
				logger.fail("Test Failed",MediaEntityBuilder.createScreenCaptureFromPath(helper.captureScreenshot(driver)).build());
		}
		else if(result.getStatus()==ITestResult.SKIP) {
			
				logger.skip("Test Skipped",MediaEntityBuilder.createScreenCaptureFromPath(helper.captureScreenshot(driver)).build());
		}
		report.flush();
		browserFactory.quitbrowser(driver);
      }
}