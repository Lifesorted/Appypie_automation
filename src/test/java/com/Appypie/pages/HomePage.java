package com.Appypie.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
	
	public void logintoApp(String uname,String pass) {
		LoginBtn.click();
		username.sendKeys(uname);
		password.sendKeys(pass);
		loginme.click();
	}

}
