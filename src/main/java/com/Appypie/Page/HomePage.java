package com.Appypie.Page;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

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
	
	@FindBy(xpath="//a[contains(text(),'Log In')]")
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
	
	@FindBy(xpath="//img[@src='https://images.appypie.com/wp-content/uploads/2020/03/16070955/appypie-logo.svg' and @class='lazyloaded']")
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
	
	@FindBy(xpath="//a[contains(text(),'Get Started') and @class='diyBannerBtn']")
	WebElement creatorbtn;
	
	@FindBy(xpath="//a[contains(text(),'Next')]")
	WebElement nextbtn;
	
	@FindBy(xpath="//h4[contains(text(),'Task Automation')]")
	WebElement taskauto;
	
	@FindBy(xpath="//span[contains(text(),'Continue with Facebook')]")
	WebElement fbloginbtn;
	
	@FindBy(xpath="//input[@placeholder=\"Search by App Name or App ID\"]")
	WebElement appid;
	
	@FindBy(xpath="//button[@ng-click=\"searchBtnEvent();\"]")
	WebElement searchicon;
	
	//Login test with positive scenario 
	public void logintoApp(String uname,String pass) {
		LoginBtn.click();
		username.sendKeys(uname);
		password.sendKeys(pass);
		loginme.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	
	// Test signup button switch 
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
	
	//test logout functionality
	protected HomePage logoutfunctionality() {
		Actions action =new Actions(driver);
		action.moveToElement(welcomemenu).perform();
		Logout.click();
		return new HomePage(driver);
	}
	
	public void creatorbtn_Test() {
		creatorbtn.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean b=	nextbtn.isDisplayed();
		if(b==true) {
			System.out.println("Creator button is clickable and working");
		}else {
			System.out.println("Creator button not clickable or there is some other issue");
		}
	}
	
	public HomePage switchToConnect() {
		taskauto.click();
		creatorbtn.click();
		String getcurrenturl=driver.getCurrentUrl();
		Assert.assertEquals("https://www.appypie.com/connect/", getcurrenturl);
		System.out.print("Successfully redirect to connect domain");
		return new HomePage(driver);
	}
	
	@FindBy(xpath="//input[@name='email']")
	WebElement fbemail;
	
	@FindBy(xpath="//input[@name='pass']")
	WebElement fbpass;
	
	@FindBy(xpath="//input[@name='login']")
	WebElement fbsigninbtn;
	
	public void facebooklogin(String fbuser,String fbpassword) {
		LoginBtn.click();
		fbloginbtn.click();
		String parentWindow=driver.getWindowHandle();
		for(String winhandle:driver.getWindowHandles()) {
		driver.switchTo().window(winhandle);
		}
		fbemail.sendKeys(fbuser);
		fbpass.sendKeys(fbpassword);
		fbsigninbtn.click();
		driver.switchTo().window(parentWindow);
		try {
            Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String url=driver.getCurrentUrl();
		//waitafter(driver,20,url);
		System.out.println(url);
		Assert.assertEquals(url, "https://snappy.appypie.com/user/app/");
		//System.out.println("Login success with facebook");
	}
	
	public void searchAppId(String app_id) {
		
					
		appid.sendKeys(app_id);
		//HomePage.clickkeyswait(driver, viewmoretext, 30);
		searchicon.click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//viewmoretext.click();
		String searchurl=driver.getCurrentUrl();
		Assert.assertEquals(searchurl, "https://snappy.appypie.com/user/app/3f2825e0033f");
		System.out.println("search working by app id");
		
		
	}
	
	public static void sendkeyswait(WebDriver driver,WebElement element,int timeout,String value) {
		new WebDriverWait(driver,timeout).until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(value);
		
	}
	
	public static void waitafter(WebDriver driver,int timeout,String element) {
		new WebDriverWait(driver,timeout).until(ExpectedConditions.urlContains("https://snappy.appypie.com/user/app/"));
		element.startsWith("https://snappy.appypie.com/user/app/");
		
	}
	public static void clickkeyswait(WebDriver driver,WebElement element,int timeout) {
		new WebDriverWait(driver,timeout).until(ExpectedConditions.visibilityOf(element));
		element.click();
		
	}
	
}