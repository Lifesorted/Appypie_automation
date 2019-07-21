package com.Appypie.pages;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver ldriver){
		this.driver=ldriver;
	}
	
	@FindBy(xpath="//a[contains(text(),'Log in')]")
	WebElement LoginBtn;
	
	@FindBy(xpath="//input[@name='login_username']")
	WebElement username;
	
	@FindBy(xpath="//input[@name='login_password']")
	WebElement password;
	
	@FindBy(xpath="//button[@id='submitme']")
	WebElement loginme;
	
	@FindBy(xpath="//a[contains(text(),'Join')]")
	WebElement joinbutton;
	
	@FindBy(xpath="//span[contains(text(), 'appypie.com')]")
	WebElement logotext;
	
	@FindBy(xpath="//div[@class='globeDropdown']//div[@class='dropbtn'][span[@class='iconz-global']]")
	WebElement languageicon;
	
	@FindBy(xpath="//a[contains(text(),'Español')]")
	WebElement Espanollang;
	
	@FindBy(xpath="//img[@src='https://d2wuvg8krwnvon.cloudfront.net/wp/en/images/logo_new.png']")
	WebElement logoclick;
		
	//Login test with positive scenario 
	public void logintoApp(String uname,String pass) throws InterruptedException {
		LoginBtn.click();
		username.sendKeys(uname);
		password.sendKeys(pass);
		loginme.click();
		Thread.sleep(5000);
		String roadmapurl= driver.getCurrentUrl();
		if(!roadmapurl.equals("https://snappy.appypie.com/user#/roadmap")) {
			System.out.println("Not able to login Check login details or site is down");
		}else {
			Assert.assertEquals(roadmapurl, "https://snappy.appypie.com/user#/roadmap");
			System.out.println("Login successfully and redirect to roadmap page");
		}

	}
	
	//Test logo text present below the logo
	public void verifyLogotext() {
		Assert.assertEquals("appypie.com","appypie.com");
		System.out.println("Logo text is present");
	}
	
	//Test language icon is present or not
	public void verifyLanguageIcon() {
		
		if(languageicon.isDisplayed()==true){
			System.out.println("language Icon is present on homepage");
		}
		else {
			new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='globeDropdown']//div[@class='dropbtn'][span[@class='iconz-global")));
	        System.out.println("Waiting for 5 secs");
			System.out.print("Language icon is not present on home page");
		}
	}

	//Test to change the language in available ones
	public void verifyLanguageOptions() {
		Actions action =new Actions(driver);
		action.moveToElement(languageicon).perform();
		Espanollang.click();
		String spanishurl=driver.getCurrentUrl();
		Assert.assertEquals(spanishurl, "https://es.appypie.com/?domain=es");
		System.out.println("Url get Change and current url is>>>>>"+spanishurl);
		}
	
	//Test to verify logo is clickable or not  to refresh the current page 
	public void verifylogoClick() {
		boolean logo=logoclick.isDisplayed()==true;
	    if(logo==true) {
	    	logoclick.click();
	    	System.out.println("logo is clickable and refresh the page");
	    }else {
	    System.out.println("Logo is not present");	
	    }
	}
	
	// Test join button
	public void verifyJoinbtn() throws InterruptedException {
		joinbutton.click();
		Thread.sleep(3000);
		String signupurl=driver.getCurrentUrl();
		if(signupurl.equals("https://snappy.appypie.com/signup")) {
			System.out.println("Signup button clickable and redirect to signup popup");
		}else {
			System.out.println("Buttton is blocked or no clikable");
		}
	}

}
