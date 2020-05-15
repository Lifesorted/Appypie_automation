package com.Appypie.Page;

import java.lang.reflect.Array;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class forumPage {
	
	WebDriver driver;
	public forumPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
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
}
