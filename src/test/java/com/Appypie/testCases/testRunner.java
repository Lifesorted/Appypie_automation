package com.Appypie.testCases;

import com.Appypie.utilities.testNgListener;
import com.aventstack.extentreports.ExtentReporter;
import com.beust.testng.TestNG;

public class testRunner {

	static TestNG testng;
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// TODO Auto-generated method stubListener 
		
	   testNgListener list=new testNgListener();
       testng=new TestNG();
       testng.setTestClasses(new Class[] {HomePageTestCases.class});
       testng.run();
	}

}
