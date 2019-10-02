package com.Appypie.testCases;
import org.testng.annotations.Test;

import com.Appypie.Page.HomePage;
import com.Appypie.Page.baseClass;
import com.aventstack.extentreports.ExtentTest;

//@Listeners(com.Appypie.Utility.testNgListener.class)
public class HomePageTestCases extends baseClass{
	
	HomePage homepage;
	ExtentTest logger;
	
	  @Test(priority=7)
	  public void loginTest() throws InterruptedException {
	  logger = report.createTest("Login test");
	  HomePage homepage=new HomePage(driver);
	  logger.info("Start Application");
      homepage.logintoApp(excel.getStringData("Login", 0,0),excel.getStringData("Login", 0, 1));
      logger.pass("login success");
	  }
	  
	  @Test(priority=6)
	  public void checkLogoText() {
	  logger=report.createTest("Logo text test");
	  HomePage homepage=new HomePage(driver);
	  homepage.verifyLogotext();
	  logger.pass("Logo text is present");
	  }
	  
	  @Test(priority=5)
	  public void languageIconTest() {
	  logger = report.createTest("Language icon present test");
	  HomePage homepage=new HomePage(driver);
	  homepage.verifyLanguageIcon();
	  logger.pass("language icon is present");
	  }
	 
	  @Test(priority=1)
	  public void changeLanguageTest() {
	  HomePage homepage=new HomePage(driver);
	  homepage.verifyLanguageOptions();
	  }
	
	  @Test(priority=2)
	  public void logoClickTest() {
	  HomePage homepage=new HomePage(driver);
	  homepage.verifylogoClick();
	  }
	  
	  @Test(priority=3)
	  private void signUpbtnTest() throws InterruptedException {
	  HomePage homepage=new HomePage(driver);
	  homepage.verifyJoinbtn();
	  }
	  
	  @Test(priority=4)
	  private void appysearchtest() {
	  HomePage homepage=new HomePage(driver);
	  homepage.navigateAppyStore(excel.getappysearchtext("homepagetestdata", 0, 0));
	  }
}