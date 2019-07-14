package com.Appypie.testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Appypie.Utility.browserFactory;
import com.Appypie.pages.HomePage;
import com.Appypie.pages.baseClass;

public class HomePageTestCases extends baseClass{
	
	@Test
	public void loginTest() {
		
      HomePage homepage=PageFactory.initElements(driver, HomePage.class);
      homepage.logintoApp("shailendra@appypie.com", "Secure@web1");
      
	}
	
}
