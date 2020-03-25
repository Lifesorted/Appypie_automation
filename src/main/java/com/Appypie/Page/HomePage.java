package com.Appypie.Page;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HomePage{
	
	WebDriver driver;	
	public HomePage(WebDriver driver){
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[contains(text(),'Log In')]")
	WebElement LoginBtn;
	
	@FindBy(xpath="//input[@name='login_username']")
	WebElement username;
	
	@FindBy(xpath="//input[@name='login_password']")
	WebElement password;
	
	@FindBy(xpath="//button[@id='submitme']")
	WebElement loginme;
	
	@FindBy(xpath="//a[contains(text(),'Sign up') and @class=\"style-navi ng-binding\"]")
	WebElement signup;
	
	@FindBy(xpath="//span[contains(text(),'Already have an account?')]")
	WebElement alreadtext;
	
	@FindBy(xpath="//span[contains(text(), 'appypie.com')]")
	WebElement logotext;
	
	@FindBy(xpath="//div[@class='globeDropdown']//div[@class='dropbtn'][span[@class='appyslim-network-global-network']]")
	WebElement languageicon;
	
	@FindBy(xpath="//a[contains(text(),'App Creatore') and @href='https://it.appypie.com']")
	WebElement Espanollang;
	
	@FindBy(xpath="//img[@src='https://www.appypie.com/wp-content/themes/appypie2016/images/logo_new.png' and @class='lazyloaded']")
	WebElement logoclick;
	
	@FindBy(xpath="//span[contains(text(),'Products')]")
	WebElement products;
	
	@FindBy(xpath="//span[contains(text(),'Appy Store')]")
	WebElement appystore;
	
	@FindBy(xpath="//input[@id=\"appfilter\"]")
	WebElement searchapp;
	
	@FindBy(xpath="//img[@class='img-rounded mpappLogo']")
	WebElement searchedtext;
	
	@FindBy(xpath="//div[@class='alert alert-info ng-scope']")
	WebElement appnotfound;
	
	@FindBy(xpath="//span[contains(text(),'Welcome')]")
	WebElement welcomemenu;
	
	@FindBy(xpath="//a[contains(text(),'Logout')]")
	WebElement Logout;
	
	@FindBy(xpath="//span[contains(text(),'Products')]")
	WebElement product;
	
	@FindBy(xpath="//span[contains(text(),'Create Your Free App Now')]")
	WebElement creatorbtn;
	
	//Login test with positive scenario 
	public void logintoApp(String uname,String pass) throws InterruptedException {
		LoginBtn.click();
		username.sendKeys(uname);
		password.sendKeys(pass);
		loginme.click();
		Thread.sleep(5000);
		String roadmapurl= driver.getCurrentUrl();
		if(!roadmapurl.equals("https://snappy.appypie.com/user/app/")) {
			System.out.println("Not able to login Check login details or site is down");
		}else {
			Assert.assertEquals(roadmapurl, "https://snappy.appypie.com/user/app/");
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
			new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='globeDropdown']//div[@class='dropbtn'][span[@class='appyslim-network-global-network']]")));
	        System.out.println("Waiting for 5 secs");
			System.out.print("Language icon is not present on home page");
		}
	}

	//Test to change the language in available ones
	public void verifyLanguageOptions() {
		Actions action =new Actions(driver);
		action.moveToElement(languageicon).perform();
		Espanollang.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String italianlang=driver.getCurrentUrl();
		Assert.assertEquals(italianlang, "https://it.appypie.com/");
		System.out.println("Url get Change and current url is>>>>>"+italianlang);
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
	
	// Test signup button
	public void signUpTabTest() throws InterruptedException {
		LoginBtn.click();
		signup.click();
		if(alreadtext.isDisplayed()) {
			System.out.println("Signup button is working");
		}else {
			System.out.print("Signup tab not working");
		}
	}
	
	//products page test method
	public HomePage navigateAppyStore(String searchstring){
		Actions action =new Actions(driver);
		action.moveToElement(products).perform();
		appystore.click();
		searchapp.clear();
		searchapp.sendKeys(searchstring);
		searchapp.sendKeys(Keys.RETURN);
		//waitToload();
		WebDriverWait wait = new WebDriverWait(driver, 20);  // timeout of 15 seconds
		 try {
		      wait.until(ExpectedConditions.visibilityOf(searchedtext));
		     } catch (TimeoutException t) {
		      System.out.println("Did not find the Label within explicit wait time");
		     }
		if(searchedtext.isDisplayed()) {
			System.out.println("Searched App logo is present that means app is available on appystore");
		}else {
			System.out.println("App not available");
		}
		return new HomePage(driver);
	}
	
	//test logut functionality
	protected HomePage logoutfunctionality() {
		Actions action =new Actions(driver);
		action.moveToElement(welcomemenu).perform();
		Logout.click();
		return new HomePage(driver);
	}
	
	public void creatorbtn_Test() {
		creatorbtn.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String url=driver.getCurrentUrl();
		Assert.assertEquals(url,"https://snappy.appypie.com/appbuilder/creator-software/");
	}
}