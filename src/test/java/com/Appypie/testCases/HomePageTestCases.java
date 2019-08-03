package com.Appypie.testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Appypie.Utility.browserFactory;
import com.Appypie.Utility.excelDataProvider;
import com.Appypie.pages.HomePage;
import com.Appypie.pages.baseClass;

public class HomePageTestCases extends baseClass{
	
	/*
	 * public HomePageTestCases() { HomePage
	 * homepage=PageFactory.initElements(driver, HomePage.class); }
	 */
	HomePage homepage;//=new HomePage(driver);
	
	//login test case
	/*
	  @Test(priority=0)
	  public void loginTest() throws InterruptedException {
	  
	  homepage=PageFactory.initElements(driver, HomePage.class);
	  homepage.logintoApp(excel.getStringData("Login", 0,0),excel.getStringData("Login", 0, 1));
	  }
	  
	  @Test(priority=1)
	  public void checkLogoText() {
	  homepage.verifyLogotext();
	  }
	  
	  @Test(priority=2)
	  public void languageIconTest() {
	  homepage=PageFactory.initElements(driver, HomePage.class);
	  homepage.verifyLanguageIcon();
	  }
	 
	@Test(priority=3)
	public void changeLanguageTest() {
		homepage=PageFactory.initElements(driver, HomePage.class);
		homepage.verifyLanguageOptions();
	}
	
	  @Test(priority=4)
	  public void logoClickTest() {
	  homepage=PageFactory.initElements(driver, HomePage.class);
	  homepage.verifylogoClick();
	  }
	  
	  @Test(priority=5)
	  private void signUpbtnTest() throws InterruptedException {
	  homepage=PageFactory.initElements(driver, HomePage.class);
	  homepage.verifyJoinbtn();
	  }
	  */
	  @Test(priority=6)
	  private void appysearchtest() {
		  homepage=PageFactory.initElements(driver, HomePage.class);
		  homepage.navigateAppyStore(excel.getappysearchtext("homepagetestdata", 0, 0));
	  }
}
