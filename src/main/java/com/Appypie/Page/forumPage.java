package com.Appypie.Page;

import java.lang.reflect.Array;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class forumPage {
	
	WebDriver driver;
	public forumPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@CacheLookup
	@FindBy(xpath="//a[@ng-click=\"viewMore(item,$index);\" and @id=\"click54158ef6c991\"]")
	WebElement viewmore;
	
	@CacheLookup
	@FindBy(xpath="//a[@ng-click=\"viewMoreFeatureItem(selectedApp.myAppOption.feature_app.length)\" and text()=\"More Items\"]")
	WebElement moreitems;
	
	@CacheLookup
	@FindBy(xpath="//span[text()='Forum']")
	WebElement forum;
	
	@CacheLookup
	@FindBy(xpath="//input[@id=\"dp1589892814168\"]")
	WebElement forumdatefilter;
	
	@CacheLookup
	@FindBy(xpath="//a[contains(text(),'Pending Questions')]")
	WebElement pendingquestions;
	
	public forumPage navigateToForum() {
		
		//WebDriverWait wait=new WebDriverWait(driver,20);
		//WebElement element=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@ng-click=\"viewMore(item,$index);\" and @id=\"click54158ef6c991\"]")));
		//viewmore.click();
		clickkeyswait(driver,viewmore,12000);
		System.out.println(viewmore.getText());
		
		try {
			Thread.sleep(13000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		//clickkeyswait(driver,moreitems,50000);
		moreitems.click();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;  
		js.executeScript("window.scrollBy(0,250)");
		forum.click();
		
		try {
			Thread.sleep(9000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//String date="05/01/2020";
		//selectDateFilter(driver,forumdatefilter,date);
		pendingquestions.click();
		if(pendingquestions.isDisplayed()) {
			System.out.println("Pending question tab is displayed");
		}else {
			System.out.println("Testcase failed");
		}
		return new forumPage(driver);
	}
	
	public void selectDateFilter(WebDriver driver,WebElement element,String dateval) {
		JavascriptExecutor js = (JavascriptExecutor) driver;  
        js.executeScript("arguments[0].setAttribute('value','"+dateval+"')", element);
	}
	public void getAllElements() {
		List<WebElement> checkbx=driver.findElements(By.xpath("//div[@class=\"textwidget\"]//a[@role=\"link\"]"));
		System.out.println("Count of languages available"+checkbx.size());
		for(int i=0;i<checkbx.size();i++) {
			System.out.println(checkbx.get(i).getAttribute("innerHTML"));
			System.out.println(checkbx.get(i).getAttribute("href"));
		}
		if(checkbx.size()==7) {
			System.out.println("All options are present related to language");
		}else
			System.out.println("All language option not present and test case failed");
	}
	
	public static void clickkeyswait(WebDriver driver,WebElement element,int timeout) {
		new WebDriverWait(driver,timeout).until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}
}
