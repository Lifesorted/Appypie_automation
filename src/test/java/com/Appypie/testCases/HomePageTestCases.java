package com.Appypie.testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.Appypie.Utility.browserFactory;
import com.Appypie.pages.HomePage;

public class HomePageTestCases {

	WebDriver driver;
	
	@Test
	public void loginTest() {
		
      driver=browserFactory.startApplication(driver, "chrome", "Https://www.appypie.com");
      HomePage homepage=PageFactory.initElements(driver, HomePage.class);
      homepage.logintoApp("shailendra@ppypie.com", "Secure@web1");
      browserFactory.quitbrowser(driver);
	}
}
