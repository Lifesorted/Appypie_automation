package com.Appypie.testCases;
import org.testng.annotations.Test;
import com.Appypie.Page.HomePage;
import com.Appypie.Page.baseClass;
import com.aventstack.extentreports.ExtentTest;

//@Listeners(com.Appypie.Utility.testNgListener.class)
    class HomePageTestCases extends baseClass{
	
    	HomePage homepage;
    	
	    ExtentTest logger;
	
	  @Test(priority=1)
	  public void loginTest() throws InterruptedException {
	  logger = report.createTest("Login test");
	  homepage=new HomePage(driver);
	  logger.info("Start Application");
      homepage.logintoApp(excel.getStringData("Login", 0,0),excel.getStringData("Login", 0, 1));
      logger.pass("login success");
      
	  }
	  
	  @Test(priority=4)
	  public void creatorbtntest() {
		  homepage=new HomePage(driver);
		  homepage.creatorbtn_Test();
	  }
	  
	  @Test(priority=2)
	  public void logoClickTest() {
	  homepage=new HomePage(driver);
	  homepage.verifylogoClick();
	  }
	  
	  @Test(priority=3)
	  private void signUpbtnTabTest() throws InterruptedException {
	  homepage=new HomePage(driver);
	  homepage.signUpTabTest();
	  }
	  
	  @Test(priority=0)
	  protected void connectDomainTest() {
		  logger=report.createTest("Switch To Connect Domain Test");
		  homepage=new HomePage(driver);
		  logger.info("Start application");
		  homepage.switchToConnect();
		  logger.pass("Test Case Passed");
	  }
	/*  
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
	 
	  @Test(priority=2)
	  public void changeLanguageTest() {
	  logger = report.createTest("Change Language test");
	  HomePage homepage=new HomePage(driver);
	  homepage.verifyLanguageOptions();
	  logger.fail("language icon is present");
	  }
	  	  
	  
	  */
}