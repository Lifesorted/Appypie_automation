package com.Appypie.utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class testNgListener implements ITestListener {

	public void onTestStart(ITestResult result) {
		System.out.println("Test Case started running: "+result);
		
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Case Passed: "+result.getName());
		
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("Test Case Failed: "+result.getName());
		
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("Test Case Skipped: "+result);
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	public void onStart(ITestContext context) {
		
		
	}

	public void onFinish(ITestContext context) {
		
		
	}

}
