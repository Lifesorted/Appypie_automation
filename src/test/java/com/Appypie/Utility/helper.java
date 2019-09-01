package com.Appypie.Utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class helper {

	public static String captureScreenshot(WebDriver driver) {
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String screenshotpath=System.getProperty("user.dir")+"/Screenshots/Appypie_"+getCurrentDateTime()+ ".png";
		try {
			FileHandler.copy(src, new File(screenshotpath));
			System.out.println("Screenshot captured successfully");
		} catch (IOException e) {
			System.out.println("Unable to capture screenshot"+e.getMessage());
		}
       return screenshotpath;
	}
	
	// get date to append with screenshot
	public static String getCurrentDateTime() {
		DateFormat customformat=new SimpleDateFormat("dd_MM_yy_HH_mm_ss");
		Date currentDate=new Date();
		return customformat.format(currentDate);
	}
}
