package com.auto;
import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

public class TakeScreenShotOnFailure1 {

	WebDriver driver;

	public void captureScreenShot(ITestResult result) throws Exception {
		if(ITestResult.FAILURE == result.getStatus()) 
		{
			//create reference of TakeScreenShot Interface and type cating
			TakesScreenshot ts=  (TakesScreenshot) driver; // typeCasting of 2 Interfaces
			
			// Use Get ScreenShotAs() method to capture screenShot in file formate
			//getScreenShotAS() method return type is File
			
			File source =ts.getScreenshotAs(OutputType.FILE);
			
			// Copy file to Specific Location 
			 FileUtils.copyFile(source,new File("./Shreenshots/"+result.getName()+" .png"));
			System.out.println(result.getName()+"method() ScreenShot captured ");
				}
	}

}
