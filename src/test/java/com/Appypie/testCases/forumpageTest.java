package com.Appypie.testCases;

import org.testng.annotations.Test;

import com.Appypie.Page.HomePage;
import com.Appypie.Page.baseClass;
import com.Appypie.Page.forumPage;

public class forumpageTest extends baseClass {

	HomePage homepage;
	forumPage frmpage;
	
	/*@Test
	public void searchByAppIdTest() {
		homepage = new HomePage(driver);
		homepage.logintoApp(excel.getStringData("Login", 0,0),excel.getStringData("Login", 0, 1));
		try {
			Thread.sleep(9000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		homepage.searchAppId(excel.getStringData("homepagetestdata", 1, 0));
		
	}
	
	@Test
	private void getallelements() {
		frmpage=new forumPage(driver);
		frmpage.getAllElements();
	}
	
	@Test
	private void navigateToForumTest() {
		homepage = new HomePage(driver);
		frmpage= new forumPage(driver);
		homepage.logintoApp(excel.getStringData("Login", 0,0),excel.getStringData("Login", 0, 1));
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		frmpage.navigateToForum();
	}
	*/
	
	@Test
	private void addForumQuestionTest() {
		homepage = new HomePage(driver);
		frmpage= new forumPage(driver);
		homepage.logintoApp(excel.getStringData("Login", 0,0),excel.getStringData("Login", 0, 1));
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		frmpage.addForumQuestion();
	}
}
